
package stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "webServer", targetNamespace = "http://currencyconvertorserver.sltc.edu/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServer {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAmount", targetNamespace = "http://currencyconvertorserver.sltc.edu/", className = "stub.GetAmount")
    @ResponseWrapper(localName = "getAmountResponse", targetNamespace = "http://currencyconvertorserver.sltc.edu/", className = "stub.GetAmountResponse")
    @Action(input = "http://currencyconvertorserver.sltc.edu/webServer/getAmountRequest", output = "http://currencyconvertorserver.sltc.edu/webServer/getAmountResponse")
    public double getAmount(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2);

}
