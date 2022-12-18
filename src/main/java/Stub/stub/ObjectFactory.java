
package stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAmountResponse_QNAME = new QName("http://soa.sltc.com/", "getAmountResponse");
    private final static QName _GetAmount_QNAME = new QName("http://soa.sltc.com/", "getAmount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAmountResponse }
     * 
     */
    public GetAmountResponse createGetAmountResponse() {
        return new GetAmountResponse();
    }

    /**
     * Create an instance of {@link GetAmount }
     * 
     */
    public GetAmount createGetAmount() {
        return new GetAmount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.sltc.com/", name = "getAmountResponse")
    public JAXBElement<GetAmountResponse> createGetAmountResponse(GetAmountResponse value) {
        return new JAXBElement<GetAmountResponse>(_GetAmountResponse_QNAME, GetAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.sltc.com/", name = "getAmount")
    public JAXBElement<GetAmount> createGetAmount(GetAmount value) {
        return new JAXBElement<GetAmount>(_GetAmount_QNAME, GetAmount.class, null, value);
    }

}
