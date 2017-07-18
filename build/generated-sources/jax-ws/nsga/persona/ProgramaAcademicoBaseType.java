
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ProgramaAcademicoBaseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ProgramaAcademicoBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modalidadId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nivelAcademicoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nivelAcademico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroPeriodo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sistemaEstudioId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sistemaEstudio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadAcademicaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadAcademica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="areaFormacionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="areaFormacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramaAcademicoBaseType", namespace = "http://utpl.edu.ec/schema/syllabus/ProgramaAcademico/v1/", propOrder = {
    "id",
    "codigo",
    "nombre",
    "modalidadId",
    "modalidad",
    "nivelAcademicoId",
    "nivelAcademico",
    "periodoId",
    "periodo",
    "numeroPeriodo",
    "sistemaEstudioId",
    "sistemaEstudio",
    "titulo",
    "unidadAcademicaId",
    "unidadAcademica",
    "areaFormacionId",
    "areaFormacion",
    "version"
})
public class ProgramaAcademicoBaseType {

    protected String id;
    protected String codigo;
    protected String nombre;
    protected String modalidadId;
    protected String modalidad;
    protected String nivelAcademicoId;
    protected String nivelAcademico;
    protected String periodoId;
    protected String periodo;
    protected int numeroPeriodo;
    protected String sistemaEstudioId;
    protected String sistemaEstudio;
    protected String titulo;
    protected String unidadAcademicaId;
    protected String unidadAcademica;
    protected String areaFormacionId;
    protected String areaFormacion;
    protected int version;

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
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad modalidadId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidadId() {
        return modalidadId;
    }

    /**
     * Define el valor de la propiedad modalidadId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidadId(String value) {
        this.modalidadId = value;
    }

    /**
     * Obtiene el valor de la propiedad modalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Define el valor de la propiedad modalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidad(String value) {
        this.modalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nivelAcademicoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivelAcademicoId() {
        return nivelAcademicoId;
    }

    /**
     * Define el valor de la propiedad nivelAcademicoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivelAcademicoId(String value) {
        this.nivelAcademicoId = value;
    }

    /**
     * Obtiene el valor de la propiedad nivelAcademico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivelAcademico() {
        return nivelAcademico;
    }

    /**
     * Define el valor de la propiedad nivelAcademico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivelAcademico(String value) {
        this.nivelAcademico = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoId() {
        return periodoId;
    }

    /**
     * Define el valor de la propiedad periodoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoId(String value) {
        this.periodoId = value;
    }

    /**
     * Obtiene el valor de la propiedad periodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Define el valor de la propiedad periodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodo(String value) {
        this.periodo = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPeriodo.
     * 
     */
    public int getNumeroPeriodo() {
        return numeroPeriodo;
    }

    /**
     * Define el valor de la propiedad numeroPeriodo.
     * 
     */
    public void setNumeroPeriodo(int value) {
        this.numeroPeriodo = value;
    }

    /**
     * Obtiene el valor de la propiedad sistemaEstudioId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSistemaEstudioId() {
        return sistemaEstudioId;
    }

    /**
     * Define el valor de la propiedad sistemaEstudioId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSistemaEstudioId(String value) {
        this.sistemaEstudioId = value;
    }

    /**
     * Obtiene el valor de la propiedad sistemaEstudio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSistemaEstudio() {
        return sistemaEstudio;
    }

    /**
     * Define el valor de la propiedad sistemaEstudio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSistemaEstudio(String value) {
        this.sistemaEstudio = value;
    }

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadAcademicaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadAcademicaId() {
        return unidadAcademicaId;
    }

    /**
     * Define el valor de la propiedad unidadAcademicaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadAcademicaId(String value) {
        this.unidadAcademicaId = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadAcademica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    /**
     * Define el valor de la propiedad unidadAcademica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadAcademica(String value) {
        this.unidadAcademica = value;
    }

    /**
     * Obtiene el valor de la propiedad areaFormacionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaFormacionId() {
        return areaFormacionId;
    }

    /**
     * Define el valor de la propiedad areaFormacionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaFormacionId(String value) {
        this.areaFormacionId = value;
    }

    /**
     * Obtiene el valor de la propiedad areaFormacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaFormacion() {
        return areaFormacion;
    }

    /**
     * Define el valor de la propiedad areaFormacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaFormacion(String value) {
        this.areaFormacion = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

}
