package com.raus.integration.susalud.core.config;

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
   * SOAP 1.1 con SAAJ
   */
  @Bean(name = "messageFactory")
  public SaajSoapMessageFactory messageFactory() {
    SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
    messageFactory.setSoapVersion(SoapVersion.SOAP_11);
    return messageFactory;
  }

  /**
   * Sender HTTP basado en Apache HttpClient 5 con timeouts.
   * (Timeouts configurados en HttpClient; no usar setters del sender para evitAR IllegalStateException)
   */
  @Bean(name = "messageSender")
  public HttpComponents5MessageSender messageSender() {
    HttpComponents5MessageSender sender = new HttpComponents5MessageSender();
    sender.setConnectionTimeout(java.time.Duration.ofSeconds(15));
    sender.setReadTimeout(java.time.Duration.ofSeconds(15));
    return sender;
  }

  @Bean(name = "susaludMarshaller")
  @Primary
  public Jaxb2Marshaller susaludMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan(
      "com.raus.integration.susalud.wsdl.affiliates"
    );
    return marshaller;
  }

  @Bean(name = "susaludWebServiceTemplate")
  @Primary
  public WebServiceTemplate susaludWebServiceTemplate(
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
