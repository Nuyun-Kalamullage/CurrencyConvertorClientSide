
package stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "webServerService", targetNamespace = "http://soa.sltc.com/", wsdlLocation = "http://localhost:8888/DemoWebService?wsdl")
public class WebServerService
    extends Service
{

    private final static URL WEBSERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVERSERVICE_EXCEPTION;
    private final static QName WEBSERVERSERVICE_QNAME = new QName("http://soa.sltc.com/", "webServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/DemoWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVERSERVICE_WSDL_LOCATION = url;
        WEBSERVERSERVICE_EXCEPTION = e;
    }

    public WebServerService() {
        super(__getWsdlLocation(), WEBSERVERSERVICE_QNAME);
    }

    public WebServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVERSERVICE_QNAME, features);
    }

    public WebServerService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVERSERVICE_QNAME);
    }

    public WebServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVERSERVICE_QNAME, features);
    }

    public WebServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns WebServer
     */
    @WebEndpoint(name = "webServerPort")
    public stub.WebServer getWebServerPort() {
        return super.getPort(new QName("http://soa.sltc.com/", "webServerPort"), WebServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServer
     */
    @WebEndpoint(name = "webServerPort")
    public WebServer getWebServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soa.sltc.com/", "webServerPort"), WebServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVERSERVICE_EXCEPTION!= null) {
            throw WEBSERVERSERVICE_EXCEPTION;
        }
        return WEBSERVERSERVICE_WSDL_LOCATION;
    }

}
