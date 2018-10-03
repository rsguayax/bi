/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth_rest;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author utpl
 */
public class Test {

    public static void main(String[] args) {
        String serviceURL = "https://srv-si-001.utpl.edu.ec/REST_PRO/api/cuenta/autenticacion";
        String appId = "1acfdd58a8264ffa9f466dd09f063b3b";
        String apiKey = "4wbs1Tmknku4bjgdVx8Pv8y4WLQiuzUcsUjLElvDJ1E=";
        String usuario = "cralvarez5";
        String password = "v9kdR8Mr";
        Autenticacion t = new Autenticacion();
        AuthenticationData auth = t.authenticate(usuario, password);
        if (auth != null) {
            if (auth.Status == 1) {
                System.out.println(auth.Status);
                System.out.println(auth.Message);
//                System.out.println(auth.Message + " : " + auth.Status);
                System.out.println(auth.Data.Apellidos);
                System.out.println(auth.Data.CorreoAlterno);
                System.out.println(auth.Data.CorreoUTPL);
                System.out.println(auth.Data.DN);
                System.out.println(auth.Data.FechaCreacion);
                System.out.println(auth.Data.Identificacion);
                System.out.println(auth.Data.Login);
                System.out.println(auth.Data.Nombres);
                System.out.println(auth.Data.Origen);

            } else {
                System.out.println(auth.Message + " : " + auth.Status);
            }
        } else {
            System.out.println("error en la autenticación");
        }
    }
}
