package model;
// Generated 20-jun-2017 17:28:51 by Hibernate Tools 4.3.1



/**
 * Participante generated by hbm2java
 */
public class Participante  implements java.io.Serializable {


     private Integer id;
     private Idea idea;
     private ItemCatalogo itemCatalogo;
     private Usuario usuario;
     private String nombre;

    public Participante() {
    }

	
    public Participante(Idea idea, ItemCatalogo itemCatalogo, Usuario usuario) {
        this.idea = idea;
        this.itemCatalogo = itemCatalogo;
        this.usuario = usuario;
    }
    public Participante(Idea idea, ItemCatalogo itemCatalogo, Usuario usuario, String nombre) {
       this.idea = idea;
       this.itemCatalogo = itemCatalogo;
       this.usuario = usuario;
       this.nombre = nombre;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Idea getIdea() {
        return this.idea;
    }
    
    public void setIdea(Idea idea) {
        this.idea = idea;
    }
    public ItemCatalogo getItemCatalogo() {
        return this.itemCatalogo;
    }
    
    public void setItemCatalogo(ItemCatalogo itemCatalogo) {
        this.itemCatalogo = itemCatalogo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


