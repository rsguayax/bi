/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

/**
 *
 * @author TAWSBC
 */
public class Innovador {
    private int id;
    private String nombre;
    private String rol;
    private int us;
    private int numIdeas;

    public Innovador() {
    }

    public Innovador(int id, String nombre, String rol, int us, int numIdeas) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.us = us;
        this.numIdeas = numIdeas;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the us
     */
    public int getUs() {
        return us;
    }

    /**
     * @param us the us to set
     */
    public void setUs(int us) {
        this.us = us;
    }

    /**
     * @return the numIdeas
     */
    public int getNumIdeas() {
        return numIdeas;
    }

    /**
     * @param numIdeas the numIdeas to set
     */
    public void setNumIdeas(int numIdeas) {
        this.numIdeas = numIdeas;
    }
    
}
