
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
@WebService(name = "webServer", targetNamespace = "http://soa.sltc.com/")
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
    @RequestWrapper(localName = "getAmount", targetNamespace = "http://soa.sltc.com/", className = "stub.GetAmount")
    @ResponseWrapper(localName = "getAmountResponse", targetNamespace = "http://soa.sltc.com/", className = "stub.GetAmountResponse")
    @Action(input = "http://soa.sltc.com/webServer/getAmountRequest", output = "http://soa.sltc.com/webServer/getAmountResponse")
    public double getAmount(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getKeyList", targetNamespace = "http://soa.sltc.com/", className = "stub.GetKeyList")
    @ResponseWrapper(localName = "getKeyListResponse", targetNamespace = "http://soa.sltc.com/", className = "stub.GetKeyListResponse")
    @Action(input = "http://soa.sltc.com/webServer/getKeyListRequest", output = "http://soa.sltc.com/webServer/getKeyListResponse")
    public String getKeyList();

}