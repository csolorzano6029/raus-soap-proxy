package com.rous.soap.proxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponents5MessageSender;

@Configuration
public class WebServiceConfig {

  private static final String CALC_CLIENT_PKG =
    "com.rous.soap.proxy.calculator.client";

  /**
   * SOAP 1.1 con SAAJ
   */
  @Bean
  public SaajSoapMessageFactory messageFactory() {
    SaajSoapMessageFactory mf = new SaajSoapMessageFactory();
    mf.setSoapVersion(SoapVersion.SOAP_11);
    mf.afterPropertiesSet();
    return mf;
  }

  /**
   * Marshaller/Unmarshaller para las clases generadas por XJC
   */
  @Bean
  public Jaxb2Marshaller calculatorMarshaller() {
    Jaxb2Marshaller m = new Jaxb2Marshaller();
    m.setPackagesToScan(CALC_CLIENT_PKG);
    return m;
  }

  /**
   * Sender HTTP basado en Apache HttpClient 5 con timeouts.
   * (Timeouts configurados en HttpClient; no usar setters del sender para evitAR IllegalStateException)
   */
  @Bean
  public HttpComponents5MessageSender messageSender() {
    HttpComponents5MessageSender sender = new HttpComponents5MessageSender();
    sender.setConnectionTimeout(java.time.Duration.ofSeconds(15));
    sender.setReadTimeout(java.time.Duration.ofSeconds(15));
    return sender;
  }

  /**
   * WebServiceTemplate con defaultUri (puedes seguir pasando el endpoint en tu service si prefieres).
   * Se puede sobreescribir con application.yml:
   * soap.external.calculator.endpoint: https://www.dneonline.com/calculator.asmx
   */
  @Bean
  public WebServiceTemplate webServiceTemplate(
    SaajSoapMessageFactory messageFactory,
    Jaxb2Marshaller calculatorMarshaller,
    HttpComponents5MessageSender messageSender,
    @Value(
      "${soap.external.calculator.endpoint:https://www.dneonline.com/calculator.asmx}"
    ) String defaultUri
  ) {
    WebServiceTemplate tpl = new WebServiceTemplate();
    tpl.setMessageFactory(messageFactory);
    tpl.setMarshaller(calculatorMarshaller);
    tpl.setUnmarshaller(calculatorMarshaller);
    tpl.setMessageSender(messageSender);
    tpl.setDefaultUri(defaultUri); // opcional; tu código puede seguir pasando 'endpoint' explícito
    return tpl;
  }
}
