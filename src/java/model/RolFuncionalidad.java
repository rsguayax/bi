package model;
// Generated 20-jun-2017 17:28:51 by Hibernate Tools 4.3.1



/**
 * RolFuncionalidad generated by hbm2java
 */
public class RolFuncionalidad  implements java.io.Serializable {


     private Integer id;
     private Funcionalidad funcionalidad;
     private Rol rol;

    public RolFuncionalidad() {
    }

    public RolFuncionalidad(Funcionalidad funcionalidad, Rol rol) {
       this.funcionalidad = funcionalidad;
       this.rol = rol;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Funcionalidad getFuncionalidad() {
        return this.funcionalidad;
    }
    
    public void setFuncionalidad(Funcionalidad funcionalidad) {
        this.funcionalidad = funcionalidad;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }




}


