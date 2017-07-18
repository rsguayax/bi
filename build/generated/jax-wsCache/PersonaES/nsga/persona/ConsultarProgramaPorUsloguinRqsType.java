
package nsga.persona;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="usloguin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "usloguin"
})
@XmlRootElement(name = "ConsultarProgramaPorUsloguinRqsType")
public class ConsultarProgramaPorUsloguinRqsType {

    protected String usloguin;

    /**
     * Obtiene el valor de la propiedad usloguin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsloguin() {
        return usloguin;
    }

    /**
     * Define el valor de la propiedad usloguin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsloguin(String value) {
        this.usloguin = value;
    }

}
