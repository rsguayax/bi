package model;
// Generated 20-jun-2017 17:28:51 by Hibernate Tools 4.3.1



/**
 * ItemCatalogo generated by hbm2java
 */
public class ItemCatalogo  implements java.io.Serializable {


     private Integer id;
     private Catalogo catalogo;
     private String nombre;
     private String descripcion;

    public ItemCatalogo() {
    }

	
    public ItemCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    public ItemCatalogo(Catalogo catalogo, String nombre, String descripcion) {
       this.catalogo = catalogo;
       this.nombre = nombre;
       this.descripcion = descripcion;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Catalogo getCatalogo() {
        return this.catalogo;
    }
    
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


