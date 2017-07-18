
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DireccionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DireccionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paisId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paisNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provinciaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="provinciaNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantonId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cantonNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parroquiaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parroquiaNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="zonaResidenciaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="zonaResidenciaNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="barrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="callePrincipal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="calleSecundaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DireccionType", propOrder = {
    "id",
    "tipoId",
    "tipo",
    "paisId",
    "paisNombre",
    "provinciaId",
    "provinciaNombre",
    "cantonId",
    "cantonNombre",
    "parroquiaId",
    "parroquiaNombre",
    "zonaResidenciaId",
    "zonaResidenciaNombre",
    "barrio",
    "callePrincipal",
    "calleSecundaria",
    "referencia",
    "numero"
})
public class DireccionType {

    protected String id;
    protected String tipoId;
    protected String tipo;
    protected String paisId;
    protected String paisNombre;
    protected String provinciaId;
    protected String provinciaNombre;
    protected String cantonId;
    protected String cantonNombre;
    protected String parroquiaId;
    protected String parroquiaNombre;
    protected String zonaResidenciaId;
    protected String zonaResidenciaNombre;
    protected String barrio;
    protected String callePrincipal;
    protected String calleSecundaria;
    protected String referencia;
    protected String numero;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoId() {
        return tipoId;
    }

    /**
     * Define el valor de la propiedad tipoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoId(String value) {
        this.tipoId = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad paisId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisId() {
        return paisId;
    }

    /**
     * Define el valor de la propiedad paisId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisId(String value) {
        this.paisId = value;
    }

    /**
     * Obtiene el valor de la propiedad paisNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisNombre() {
        return paisNombre;
    }

    /**
     * Define el valor de la propiedad paisNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisNombre(String value) {
        this.paisNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad provinciaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinciaId() {
        return provinciaId;
    }

    /**
     * Define el valor de la propiedad provinciaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinciaId(String value) {
        this.provinciaId = value;
    }

    /**
     * Obtiene el valor de la propiedad provinciaNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    /**
     * Define el valor de la propiedad provinciaNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinciaNombre(String value) {
        this.provinciaNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad cantonId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantonId() {
        return cantonId;
    }

    /**
     * Define el valor de la propiedad cantonId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantonId(String value) {
        this.cantonId = value;
    }

    /**
     * Obtiene el valor de la propiedad cantonNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantonNombre() {
        return cantonNombre;
    }

    /**
     * Define el valor de la propiedad cantonNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantonNombre(String value) {
        this.cantonNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad parroquiaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParroquiaId() {
        return parroquiaId;
    }

    /**
     * Define el valor de la propiedad parroquiaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParroquiaId(String value) {
        this.parroquiaId = value;
    }

    /**
     * Obtiene el valor de la propiedad parroquiaNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParroquiaNombre() {
        return parroquiaNombre;
    }

    /**
     * Define el valor de la propiedad parroquiaNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParroquiaNombre(String value) {
        this.parroquiaNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad zonaResidenciaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZonaResidenciaId() {
        return zonaResidenciaId;
    }

    /**
     * Define el valor de la propiedad zonaResidenciaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZonaResidenciaId(String value) {
        this.zonaResidenciaId = value;
    }

    /**
     * Obtiene el valor de la propiedad zonaResidenciaNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZonaResidenciaNombre() {
        return zonaResidenciaNombre;
    }

    /**
     * Define el valor de la propiedad zonaResidenciaNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZonaResidenciaNombre(String value) {
        this.zonaResidenciaNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad barrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * Define el valor de la propiedad barrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrio(String value) {
        this.barrio = value;
    }

    /**
     * Obtiene el valor de la propiedad callePrincipal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallePrincipal() {
        return callePrincipal;
    }

    /**
     * Define el valor de la propiedad callePrincipal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallePrincipal(String value) {
        this.callePrincipal = value;
    }

    /**
     * Obtiene el valor de la propiedad calleSecundaria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    /**
     * Define el valor de la propiedad calleSecundaria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalleSecundaria(String value) {
        this.calleSecundaria = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

}
