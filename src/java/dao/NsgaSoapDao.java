/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import nsga.persona.*;
/**
 *
 * @author TAWSBC
 */
public class NsgaSoapDao {

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
