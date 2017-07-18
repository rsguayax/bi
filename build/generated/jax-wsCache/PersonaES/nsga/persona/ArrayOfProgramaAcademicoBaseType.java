
package nsga.persona;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfProgramaAcademicoBaseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProgramaAcademicoBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultados" type="{http://utpl.edu.ec/schema/syllabus/ProgramaAcademico/v1/}ProgramaAcademicoBaseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProgramaAcademicoBaseType", propOrder = {
    "resultados"
})
public class ArrayOfProgramaAcademicoBaseType {

    protected List<ProgramaAcademicoBaseType> resultados;

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
     * {@link ProgramaAcademicoBaseType }
     * 
     * 
     */
    public List<ProgramaAcademicoBaseType> getResultados() {
        if (resultados == null) {
            resultados = new ArrayList<ProgramaAcademicoBaseType>();
        }
        return this.resultados;
    }

}
