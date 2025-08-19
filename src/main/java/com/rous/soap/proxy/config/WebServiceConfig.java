package com.rous.soap.proxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

@Configuration
public class WebServiceConfig {

  // Paquete donde están las clases JAXB generadas para el calculator
  private static final String CALCULATOR_CONTEXT_PATH =
    "com.rous.soap.proxy.calculator.client";

  /**
   * Marshaller para el servicio Calculator.
   * Escanea las clases JAXB generadas (Add, AddResponse, etc).
   */
  @Bean
  public Jaxb2Marshaller calculatorMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan(CALCULATOR_CONTEXT_PATH);
    return marshaller;
  }

  /**
   * MessageFactory SAAJ con SOAP 1.1 (el servicio público de tempuri usa SOAP 1.1).
   */
  @Bean
  public SaajSoapMessageFactory soapMessageFactory() {
    SaajSoapMessageFactory mf = new SaajSoapMessageFactory();
    mf.setSoapVersion(SoapVersion.SOAP_11);
    mf.afterPropertiesSet();
    return mf;
  }

  /**
   * WebServiceTemplate específico para Calculator, usando JDK HttpUrlConnection
   * (evita el problema de Content-Length duplicado).
   */
  @Bean(name = "calculatorWsTemplate")
  public WebServiceTemplate calculatorWsTemplate(
    Jaxb2Marshaller calculatorMarshaller,
    SaajSoapMessageFactory soapMessageFactory
  ) {
    WebServiceTemplate template = new WebServiceTemplate(soapMessageFactory);
    template.setMarshaller(calculatorMarshaller);
    template.setUnmarshaller(calculatorMarshaller);

    // Sender SIN Apache HttpClient
    HttpUrlConnectionMessageSender sender =
      new HttpUrlConnectionMessageSender();
    // timeouts opcionales (ms)
    //sender.setConnectionTimeout(10_000);
    //sender.setReadTimeout(10_000);

    template.setMessageSender(sender);

    // Si quieres, puedes dejar configurado un defaultUri; igual puedes pasar el endpoint por código
    // template.setDefaultUri("http://www.dneonline.com/calculator.asmx");

    return template;
  }
}
