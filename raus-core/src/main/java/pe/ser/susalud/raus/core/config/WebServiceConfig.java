package pe.ser.susalud.raus.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponents5MessageSender;

@Configuration
public class WebServiceConfig {

  /**
   * Defines a SOAP message factory using SAAJ with SOAP 1.1 protocol.
   * This bean is responsible for creating SOAP messages
   * that will be sent and received by the WebServiceTemplate.
   */
  @Bean(name = "messageFactory")
  SaajSoapMessageFactory messageFactory() {
    SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
    messageFactory.setSoapVersion(SoapVersion.SOAP_11);
    return messageFactory;
  }

  /**
   * Defines an HTTP sender based on Apache HttpClient 5.
   * Configures connection and read timeouts at 15 seconds.
   * Note: Timeouts are configured directly in HttpClient;
   * avoid using sender setters to prevent IllegalStateException.
   */
  @Bean(name = "messageSender")
  HttpComponents5MessageSender messageSender() {
    HttpComponents5MessageSender sender = new HttpComponents5MessageSender();
    sender.setConnectionTimeout(java.time.Duration.ofSeconds(15));
    sender.setReadTimeout(java.time.Duration.ofSeconds(15));
    return sender;
  }

  /**
   * Configures the JAXB marshaller/unmarshaller for Susalud.
   * Scans the package containing the generated WSDL classes
   * to convert between Java objects and XML payloads.
   */
  @Bean(name = "susaludMarshaller")
  @Primary
  Jaxb2Marshaller susaludMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("pe.ser.susalud.raus.wsdl.affiliates");
    return marshaller;
  }

  /**
   * Defines the WebServiceTemplate for Susalud integration.
   * - Uses the configured message factory (SOAP 1.1 + SAAJ).
   * - Uses the JAXB marshaller/unmarshaller for XML mapping.
   * - Uses the Apache HttpClient 5 message sender with timeouts.
   * - Sets the default endpoint URI from application properties.
   *
   * This is the main entry point for sending SOAP requests
   * and receiving SOAP responses from Susalud.
   */
  @Bean(name = "susaludWebServiceTemplate")
  @Primary
  WebServiceTemplate susaludWebServiceTemplate(
    SaajSoapMessageFactory messageFactory,
    Jaxb2Marshaller susaludMarshaller,
    HttpComponents5MessageSender messageSender,
    @Value("${soap.external.susalud.endpoint}") String endpoint
  ) {
    WebServiceTemplate serviceTemplate = new WebServiceTemplate();
    serviceTemplate.setMessageFactory(messageFactory);
    serviceTemplate.setMarshaller(susaludMarshaller);
    serviceTemplate.setUnmarshaller(susaludMarshaller);
    serviceTemplate.setMessageSender(messageSender);
    serviceTemplate.setDefaultUri(endpoint);
    return serviceTemplate;
  }
}
