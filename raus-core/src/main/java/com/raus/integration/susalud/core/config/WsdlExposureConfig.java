package com.raus.integration.susalud.core.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@Configuration
@EnableWs
public class WsdlExposureConfig {

  /**
   * Registers the Spring-WS MessageDispatcherServlet.
   *
   * - Integrates with the Spring ApplicationContext to detect
   *   and handle SOAP endpoints defined in the project.
   * - The "setTransformWsdlLocations(true)" option ensures that WSDL
   *   locations are dynamically adapted based on the server hostname/port
   *   (useful when deployed in different environments).
   * - Maps ALL SOAP requests under the context path "/ws/*".
   *
   * Example:
   *   A SOAP service exposed at "/ws/affiliates.wsdl" will be available
   *   for clients to download the WSDL and send requests.
   */
  @Bean
  ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
    ApplicationContext applicationContext
  ) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }
}
