/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth_rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import java.net.URLEncoder;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TAWSBC
 */
public class Autenticacion {

    String serviceURL = "https://srv-si-001.utpl.edu.ec/REST_PRO/api/cuenta/autenticacion";
    String appId = "1acfdd58a8264ffa9f466dd09f063b3b";
    String apiKey = "4wbs1Tmknku4bjgdVx8Pv8y4WLQiuzUcsUjLElvDJ1E=";

    public AuthenticationData authenticate(String username, String pwd) {
        System.out.println("RG 1->Ingreso a método authenticate");
        AuthenticationData auth = new AuthenticationData();
        System.out.println("RG 2->Luego de método autenticar");
        String msg = "";
        try {
            String serviceURLEncode;
            String unixTime;
            String cadenaFirmar = "%s%s%s%s";
            Mac sha256HMAC;
            SecretKeySpec secretKey;
            String firma;
            String authorizationCode = "amx %s:%s:%s";
            Client client;
            WebResource resource;
            ClientResponse response;
            String data = "{\"usuario\":\"%s\", \"contrasenia\":\"%s\"}";

            client = Client.create();
            data = String.format(data, username, pwd);
            System.out.println("RG 3-> creado client y data");

//            try {
            serviceURLEncode = URLEncoder.encode(serviceURL, "UTF-8");
            System.out.println("RG 4<-> "+serviceURLEncode);
            ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
            System.out.println("RG 5<-> utc:"+utc);
            unixTime = String.valueOf(utc.toInstant().now().getEpochSecond());
            System.out.println("RG 6<-> unixTime:"+unixTime);
            cadenaFirmar = String.format(cadenaFirmar, appId, "POST", serviceURLEncode.toLowerCase(), unixTime);
            System.out.println("RG 7<-> cadenaFirmar:"+cadenaFirmar);
            sha256HMAC = Mac.getInstance("HmacSHA256");
            System.out.println("RG 8<-> sha256HMAC:"+sha256HMAC);
            secretKey = new SecretKeySpec(Base64.decode(apiKey), "HmacSHA256");
            System.out.println("RG 9<-> secretKey:"+secretKey);
            sha256HMAC.init(secretKey);
            System.out.println("RG 10<-> sha256HMAC:"+sha256HMAC);
            firma = new String(Base64.encode(sha256HMAC.doFinal(cadenaFirmar.getBytes("UTF-8"))));
            System.out.println("RG 11<-> firma:"+firma);
            authorizationCode = String.format(authorizationCode, appId, firma, unixTime);
            System.out.println("RG 12<-> authorizationCode:"+authorizationCode);
            resource = client.resource(serviceURL);
            System.out.println("RG 13<-> resource:"+resource);
            response = resource.accept("application/json").type("application/json").header("Authorization", authorizationCode).post(ClientResponse.class, data);
            System.out.println("RG 14<->");
            if (response.getStatus() == 200) {
                System.out.println("RG 15<-> respuesta correcta == 200");
                Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                auth = prettyGson.fromJson(response.getEntity(String.class), AuthenticationData.class);
                return auth;
            } else {
                System.out.println("RG -- "+response.toString());
                System.out.println("RG 16<-> respuesta incorrecta == "+response.getStatus());
                auth.Status = response.getStatus();
                auth.Message = response.getClientResponseStatus().getReasonPhrase();
                return auth;
            }
//            } catch (NoSuchAlgorithmException ex) {
//                Logger.getLogger("***ERROR authenticate").log(Level.SEVERE, "error  " + username + " -->> " + ex.getMessage());
//                Logger.getLogger(Autenticacion.class.getName()).log(Level.SEVERE, null, ex);
//                msg = ex.getMessage();
//            } catch (InvalidKeyException ex) {
//                Logger.getLogger("***ERROR authenticate").log(Level.SEVERE, "error  " + username + " -->> " + ex.getMessage());
//                Logger.getLogger(Autenticacion.class.getName()).log(Level.SEVERE, null, ex);
//                msg = ex.getMessage();
//            } catch (IOException ex) {
//                Logger.getLogger("***ERROR authenticate").log(Level.SEVERE, "error  " + username + " -->> " + ex.getMessage());
//                msg = ex.getMessage();
//            }
        } catch (Exception ex) {
            auth.Message = ex.getMessage();
            Logger.getLogger("***ERROR authenticate GENERAL").log(Level.SEVERE, "error  " + username + " -->> " + ex.getMessage());
        }
        System.out.println("RG->fin de método authenticate: " + msg);
        auth.Status = -1;
        auth.Message = msg;
        return auth;
    }

}
