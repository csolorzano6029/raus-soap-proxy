package com.rous.integration.susalud.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WsdlExposureConfig {

  // Carga el XSD
  @Bean
  public XsdSchema calculatorSchema() {
    return new SimpleXsdSchema(
      new org.springframework.core.io.ClassPathResource(
        "xsd/calculator-proxy.xsd"
      )
    );
  }

  // Expone el WSDL en /ws/calculator.wsdl
  @Bean(name = "calculator")
  public DefaultWsdl11Definition calculatorWsdl(XsdSchema calculatorSchema) {
    DefaultWsdl11Definition defaultWsdl = new DefaultWsdl11Definition();
    defaultWsdl.setPortTypeName("CalculatorProxyPort");
    defaultWsdl.setLocationUri("/ws");
    defaultWsdl.setTargetNamespace("http://example.com/soapproxy/calculator");
    defaultWsdl.setSchema(calculatorSchema);
    return defaultWsdl;
  }

  @Bean
  public ServletRegistrationBean<
    MessageDispatcherServlet
  > messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    // Mapea TODAS las peticiones SOAP a /ws/*
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }
}
