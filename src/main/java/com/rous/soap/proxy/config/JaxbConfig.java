package com.rous.soap.proxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbConfig {

  @Bean
  public Jaxb2Marshaller calculatorMarshaller() {
    Jaxb2Marshaller m = new Jaxb2Marshaller();
    // Este paquete debe ser el que contiene las clases generadas Add, AddResponse, etc.
    m.setPackagesToScan("com.rous.soap.proxy.calculator.client");
    return m;
  }
}
