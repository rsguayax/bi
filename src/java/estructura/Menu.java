/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.util.List;
import model.Funcionalidad;
/**
 *
 * @author TAWSBC
 */
public class Menu {
    private Funcionalidad titulo;
    private List<Funcionalidad> items;

    public Menu() {
    }

    public Menu(Funcionalidad titulo, List<Funcionalidad> items) {
        this.titulo = titulo;
        this.items = items;
    }

    /**
     * @return the titulo
     */
    public Funcionalidad getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(Funcionalidad titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the items
     */
    public List<Funcionalidad> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Funcionalidad> items) {
        this.items = items;
    }
    
    
}
