
package nsga.persona;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="resultados" type="{http://utpl.edu.ec/schema/syllabus/Persona/v1/}PersonaType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "resultados",
    "total"
})
@XmlRootElement(name = "ConsultarPorCriteriosRpsType")
public class ConsultarPorCriteriosRpsType {

    protected List<PersonaType> resultados;
    protected long total;

    /**
     * Gets the value of the resultados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonaType }
     * 
     * 
     */
    public List<PersonaType> getResultados() {
        if (resultados == null) {
            resultados = new ArrayList<PersonaType>();
        }
        return this.resultados;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     */
    public long getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     */
    public void setTotal(long value) {
        this.total = value;
    }

}
