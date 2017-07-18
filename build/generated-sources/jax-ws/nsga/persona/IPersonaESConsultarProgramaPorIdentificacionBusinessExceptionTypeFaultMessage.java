
package nsga.persona;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "BusinessExceptionType", targetNamespace = "http://utpl.edu.ec/schema/Common/v1/")
public class IPersonaESConsultarProgramaPorIdentificacionBusinessExceptionTypeFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BusinessExceptionType faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IPersonaESConsultarProgramaPorIdentificacionBusinessExceptionTypeFaultMessage(String message, BusinessExceptionType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IPersonaESConsultarProgramaPorIdentificacionBusinessExceptionTypeFaultMessage(String message, BusinessExceptionType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: nsga.persona.BusinessExceptionType
     */
    public BusinessExceptionType getFaultInfo() {
        return faultInfo;
    }

}
