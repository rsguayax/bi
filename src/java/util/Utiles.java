/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TAWSBC
 */
public class Utiles {

    public String md5(String password) {
        String original = password;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(null).log(Level.SEVERE, null, ex);
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Utiles u = new Utiles();
        System.out.println(u.md5("password"));
    }
//    private static final String SERVER_UPLOAD_OFERTA_LOCATION_FOLDER = "/Users/utpl/bancoideas/";
    private static final String SERVER_UPLOAD_OFERTA_LOCATION_FOLDER ="/app/glassfish/glassfish4/glassfish/domains/domain1/applications/bancoideas/";

    public String guardarArchivo(MultipartFile archivo) throws IOException {
        if (archivo != null) {
            String ruta = SERVER_UPLOAD_OFERTA_LOCATION_FOLDER;
            //Se crea el directorio en el servidor si aún no ha sido creado
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdir();
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            MultipartFile multipartFile = archivo;
            String test = multipartFile.getOriginalFilename();
            String fileNombre = multipartFile.getOriginalFilename();
            fileNombre = new String(fileNombre.getBytes("ISO-8859-1"), "UTF-8");

            String partes[] = fileNombre.split("\\.");
            String nombre = partes[0];
            String tipo = partes[1];

            if (fileNombre != null) {
                int cont = 1;
                while (encontrarArchivo(ruta, fileNombre)) {
                    fileNombre = nombre + "_" + cont + "." + tipo;
                    cont++;
                }
                try {
                    inputStream = multipartFile.getInputStream();
                    String dir = ruta + fileNombre;
                    File newFile = new File(dir);
                    newFile.createNewFile();
                    outputStream = new FileOutputStream(newFile);

                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return fileNombre;
            }

        }
        return null;
    }

    public boolean encontrarArchivo(String carpeta, String nombre_archivo) throws IOException {
        File directorio = new File(carpeta);
        File[] archivos = directorio.listFiles();
        for (File f : archivos) {
            if (f.isFile()) {
                if (!f.getName().equals(".DS_Store")) {
                    if (f.getName().equals(nombre_archivo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
