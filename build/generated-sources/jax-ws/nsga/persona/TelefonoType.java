
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TelefonoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TelefonoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codigoArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoTelefonoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoTelefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="operadoraId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="operadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelefonoType", propOrder = {
    "id",
    "codigoPais",
    "codigoArea",
    "numero",
    "extension",
    "tipoTelefonoId",
    "tipoTelefono",
    "operadoraId",
    "operadora"
})
public class TelefonoType {

    protected String id;
    protected String codigoPais;
    protected String codigoArea;
    protected String numero;
    protected String extension;
    protected String tipoTelefonoId;
    protected String tipoTelefono;
    protected String operadoraId;
    protected String operadora;

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
     * Obtiene el valor de la propiedad codigoPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * Define el valor de la propiedad codigoPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPais(String value) {
        this.codigoPais = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoArea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoArea() {
        return codigoArea;
    }

    /**
     * Define el valor de la propiedad codigoArea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoArea(String value) {
        this.codigoArea = value;
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

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTelefonoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    /**
     * Define el valor de la propiedad tipoTelefonoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTelefonoId(String value) {
        this.tipoTelefonoId = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTelefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTelefono() {
        return tipoTelefono;
    }

    /**
     * Define el valor de la propiedad tipoTelefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTelefono(String value) {
        this.tipoTelefono = value;
    }

    /**
     * Obtiene el valor de la propiedad operadoraId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperadoraId() {
        return operadoraId;
    }

    /**
     * Define el valor de la propiedad operadoraId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperadoraId(String value) {
        this.operadoraId = value;
    }

    /**
     * Obtiene el valor de la propiedad operadora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperadora() {
        return operadora;
    }

    /**
     * Define el valor de la propiedad operadora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperadora(String value) {
        this.operadora = value;
    }

}
