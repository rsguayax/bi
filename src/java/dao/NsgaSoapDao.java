/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import eva.auth.AutenticacionAcademicoRpsType;
import eva.auth.AutenticacionAcademicoRqsType;
import java.util.List;
import eva.auth.*;
import nsga.persona.*;
/**
 *
 * @author TAWSBC
 */
public class NsgaSoapDao {

    public AutenticacionAcademicoRpsType autenticar_usuario_eva(String usuario, String password) {
        try {
            eva.auth.Autenticar wsAuth = new eva.auth.Autenticar();
            AutenticacionAcademicoRqsType request = new AutenticacionAcademicoRqsType();
            request.setLogin(usuario);
            request.setClave(password);
            AutenticacionAcademicoRpsType resp = wsAuth.getAutenticarPort().autenticacionAcademico(request);
//        String autenticado = resp.getMsgRetorno();
            return resp;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

//    public AutenticarMsgRpsType autenticar_usuario_sin_password_nsga(String usuario) {
//        AutenticacionAcademicoUS wsAuth = new AutenticacionAcademicoUS();
//        AutenticarMsgRqsType request = new AutenticarMsgRqsType();
//        request.setLogin(usuario);
//        AutenticarMsgRpsType resp = wsAuth.getBasicHttpBindingIAutenticacionAcademicoUS().autenticar(request);
////        String autenticado = resp.getMsgRetorno();
//        return resp;
//    }

    public PersonaType buscar_persona_cedula_nsga(String cedula) throws IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        try {
            PersonaES persona = new PersonaES();
            ConsultarPorIdentificacionRqsType sol = new ConsultarPorIdentificacionRqsType();
            sol.setIdentificacion(cedula);
            List<PersonaType> personaLista = persona.getBasicHttpBindingIPersonaES().consultarPorIdentificacion(sol).getPersona();
            return personaLista.get(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public PersonaType buscar_persona_usuario_nsga(String usuario) throws IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage {
        try {
            PersonaES wsPersona = new PersonaES();
            ConsultarPorUsloguinRqsType sol = new ConsultarPorUsloguinRqsType();
            sol.setUsloguin(usuario);
            PersonaType persona = wsPersona.getBasicHttpBindingIPersonaES().consultarPorUsloguin(sol).getPersona();
            return persona;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
