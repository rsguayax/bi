
package eva.auth;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AutenticacionAcademicoRpsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AutenticacionAcademicoRpsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Login" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Identificacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MsgRetorno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutenticacionAcademicoRpsType", propOrder = {
    "login",
    "identificacion",
    "msgRetorno"
})
public class AutenticacionAcademicoRpsType {

    @XmlElement(name = "Login", required = true)
    protected String login;
    @XmlElement(name = "Identificacion", required = true)
    protected String identificacion;
    @XmlElement(name = "MsgRetorno", required = true)
    protected String msgRetorno;

    /**
     * Obtiene el valor de la propiedad login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define el valor de la propiedad login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
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
     * Obtiene el valor de la propiedad msgRetorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRetorno() {
        return msgRetorno;
    }

    /**
     * Define el valor de la propiedad msgRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgRetorno(String value) {
        this.msgRetorno = value;
    }

}
