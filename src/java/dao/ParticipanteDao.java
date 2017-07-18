/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import estructura.Innovador;
import java.util.ArrayList;
import java.util.List;
import model.Participante;

/**
 *
 * @author TAWSBC
 */
public class ParticipanteDao extends GenericDAO<Participante, Integer> {


    public List<Innovador> obtenerInnovadores() {
        List<Innovador> inn = new ArrayList<>();
        try {
            String q = "select p.id, p.nombre as innovador, ic.nombre as rol, p.usuario, count(p.usuario) as num_ideas\n"
                    + "from participante p, item_catalogo ic\n"
                    + "where p.funcion = ic.id\n"
                    + "group by p.usuario\n"
                    + "order by num_ideas desc";
            List<Object[]> results = listar_sentencia_sql(q);
            for (int i = 0; i < 10; i++) {
                Object[] o = results.get(i);
                int id = Integer.parseInt(o[0].toString());
                String innovador = o[1].toString();
                String rol = o[2].toString();
                int us = Integer.parseInt(o[3].toString());
                int numIdeas = Integer.parseInt(o[4].toString());
                inn.add(new Innovador(id, innovador, rol, us, numIdeas));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return inn;
    }
}
