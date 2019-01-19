package Com.kanwal.ManualClient;

import java.net.URL;
import com.kanwal.WebserviceRpc.HelloWorld;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
public class HelloWorldClient {
public static void main(String[] args) throws Exception {
	URL url = new URL("http://localhost:9999/ws/hello?wsdl");
	QName qname = new QName("http://WebserviceRpc.kanwal.com/", "HelloWorldImplService");
	Service service = Service.create(url,qname);
	HelloWorld hello = service.getPort(HelloWorld.class);
	System.out.println(hello.);
}
}
