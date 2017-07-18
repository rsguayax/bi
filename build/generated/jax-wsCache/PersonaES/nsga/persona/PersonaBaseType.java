
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PersonaBaseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PersonaBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoIdentificacionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoIdentificacionCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primerNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundoNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="segundoApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoCivilId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nacionalidadId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nacionalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="generoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="genero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discapacidadId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="discapacidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="porcentajeDiscapacidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaBaseType", propOrder = {
    "id",
    "tipoIdentificacionId",
    "tipoIdentificacionCodigo",
    "identificacion",
    "primerNombre",
    "segundoNombre",
    "primerApellido",
    "segundoApellido",
    "estadoCivilId",
    "estadoCivil",
    "nacionalidadId",
    "nacionalidad",
    "fechaNacimiento",
    "generoId",
    "genero",
    "discapacidadId",
    "discapacidad",
    "porcentajeDiscapacidad"
})
public class PersonaBaseType {

    protected String id;
    protected String tipoIdentificacionId;
    protected String tipoIdentificacionCodigo;
    protected String identificacion;
    protected String primerNombre;
    protected String segundoNombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String estadoCivilId;
    protected String estadoCivil;
    protected String nacionalidadId;
    protected String nacionalidad;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaNacimiento;
    protected String generoId;
    protected String genero;
    protected String discapacidadId;
    protected String discapacidad;
    protected int porcentajeDiscapacidad;

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
     * Obtiene el valor de la propiedad tipoIdentificacionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    /**
     * Define el valor de la propiedad tipoIdentificacionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIdentificacionId(String value) {
        this.tipoIdentificacionId = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoIdentificacionCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIdentificacionCodigo() {
        return tipoIdentificacionCodigo;
    }

    /**
     * Define el valor de la propiedad tipoIdentificacionCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIdentificacionCodigo(String value) {
        this.tipoIdentificacionCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad identificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Define el valor de la propiedad identificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacion(String value) {
        this.identificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad primerNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * Define el valor de la propiedad primerNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerNombre(String value) {
        this.primerNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * Define el valor de la propiedad segundoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoNombre(String value) {
        this.segundoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Define el valor de la propiedad primerApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Define el valor de la propiedad segundoApellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCivilId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCivilId() {
        return estadoCivilId;
    }

    /**
     * Define el valor de la propiedad estadoCivilId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCivilId(String value) {
        this.estadoCivilId = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCivil.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Define el valor de la propiedad estadoCivil.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoCivil(String value) {
        this.estadoCivil = value;
    }

    /**
     * Obtiene el valor de la propiedad nacionalidadId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidadId() {
        return nacionalidadId;
    }

    /**
     * Define el valor de la propiedad nacionalidadId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidadId(String value) {
        this.nacionalidadId = value;
    }

    /**
     * Obtiene el valor de la propiedad nacionalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Define el valor de la propiedad nacionalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidad(String value) {
        this.nacionalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad generoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneroId() {
        return generoId;
    }

    /**
     * Define el valor de la propiedad generoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneroId(String value) {
        this.generoId = value;
    }

    /**
     * Obtiene el valor de la propiedad genero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define el valor de la propiedad genero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenero(String value) {
        this.genero = value;
    }

    /**
     * Obtiene el valor de la propiedad discapacidadId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscapacidadId() {
        return discapacidadId;
    }

    /**
     * Define el valor de la propiedad discapacidadId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscapacidadId(String value) {
        this.discapacidadId = value;
    }

    /**
     * Obtiene el valor de la propiedad discapacidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Define el valor de la propiedad discapacidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscapacidad(String value) {
        this.discapacidad = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeDiscapacidad.
     * 
     */
    public int getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    /**
     * Define el valor de la propiedad porcentajeDiscapacidad.
     * 
     */
    public void setPorcentajeDiscapacidad(int value) {
        this.porcentajeDiscapacidad = value;
    }

}
