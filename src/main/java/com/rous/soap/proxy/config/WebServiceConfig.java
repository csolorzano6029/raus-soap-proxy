package com.rous.soap.proxy.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.support.interceptor.ClientInterceptorAdapter;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class WebServiceConfig {

  @Autowired
  private Jaxb2Marshaller calculatorMarshaller;

  @Bean
  public SaajSoapMessageFactory messageFactory() {
    SaajSoapMessageFactory mf = new SaajSoapMessageFactory();
    mf.afterPropertiesSet(); // asegura init SAAJ 1.1 por defecto
    return mf;
  }

  @Bean
  public WebServiceTemplate externalWebServiceTemplate() {
    // Crear HttpClient (Apache 4.x, no 5.x)
    HttpClient httpClient = HttpClientBuilder.create().build();

    // Usar sender de HttpClient 4
    HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
    sender.setHttpClient(httpClient);

    // Configurar el WebServiceTemplate
    WebServiceTemplate template = new WebServiceTemplate(messageFactory());
    template.setMessageSender(sender);
    template.setMarshaller(calculatorMarshaller);
    template.setUnmarshaller(calculatorMarshaller);
    return template;
  }

  @Bean
  public WebServiceTemplate webServiceTemplate(
    SaajSoapMessageFactory mf,
    Jaxb2Marshaller marshaller
  ) {
    WebServiceTemplate t = new WebServiceTemplate(mf);
    t.setMarshaller(marshaller);
    t.setUnmarshaller(marshaller);

    // HttpClient 4.x con timeouts
    RequestConfig rc = RequestConfig.custom()
      .setConnectTimeout(10_000) // 10s
      .setConnectionRequestTimeout(10_000)
      .setSocketTimeout(20_000) // 20s
      .build();

    CloseableHttpClient hc = HttpClients.custom()
      .setDefaultRequestConfig(rc)
      .build();

    HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
    sender.setHttpClient(hc);

    t.setMessageSender(sender);

    // Logging de request/response para ver EXACTO qué sale y entra
    t.setInterceptors(
      new ClientInterceptor[] {
        new ClientInterceptorAdapter() {
          @Override
          public boolean handleRequest(MessageContext mc) {
            try {
              ((SoapMessage) mc.getRequest()).writeTo(System.out);
              System.out.println();
            } catch (Exception ignore) {}
            return true;
          }

          @Override
          public boolean handleResponse(MessageContext mc) {
            try {
              ((SoapMessage) mc.getResponse()).writeTo(System.out);
              System.out.println();
            } catch (Exception ignore) {}
            return true;
          }

          @Override
          public boolean handleFault(MessageContext mc) {
            try {
              ((SoapMessage) mc.getResponse()).writeTo(System.out);
              System.out.println();
            } catch (Exception ignore) {}
            return true;
          }
        },
      }
    );

    return t;
  }
}
