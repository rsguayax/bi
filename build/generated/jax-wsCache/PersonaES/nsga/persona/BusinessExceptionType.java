
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="stacktrace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="details" type="{http://utpl.edu.ec/schema/Common/v1/}detailsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "message",
    "clazz",
    "stacktrace",
    "details"
})
@XmlRootElement(name = "BusinessExceptionType", namespace = "http://utpl.edu.ec/schema/Common/v1/")
public class BusinessExceptionType {

    @XmlElement(namespace = "http://utpl.edu.ec/schema/Common/v1/")
    protected String message;
    @XmlElement(name = "class", namespace = "http://utpl.edu.ec/schema/Common/v1/")
    protected String clazz;
    @XmlElement(namespace = "http://utpl.edu.ec/schema/Common/v1/")
    protected String stacktrace;
    @XmlElement(namespace = "http://utpl.edu.ec/schema/Common/v1/")
    protected DetailsType details;

    /**
     * Obtiene el valor de la propiedad message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define el valor de la propiedad message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtiene el valor de la propiedad clazz.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Define el valor de la propiedad clazz.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Obtiene el valor de la propiedad stacktrace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStacktrace() {
        return stacktrace;
    }

    /**
     * Define el valor de la propiedad stacktrace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStacktrace(String value) {
        this.stacktrace = value;
    }

    /**
     * Obtiene el valor de la propiedad details.
     * 
     * @return
     *     possible object is
     *     {@link DetailsType }
     *     
     */
    public DetailsType getDetails() {
        return details;
    }

    /**
     * Define el valor de la propiedad details.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailsType }
     *     
     */
    public void setDetails(DetailsType value) {
        this.details = value;
    }

}
