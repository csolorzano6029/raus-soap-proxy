package com.rous.soap.proxy.services;

import com.rous.soap.proxy.calculator.client.Add;
import com.rous.soap.proxy.calculator.client.AddResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class RausQueryService {

  private final WebServiceTemplate wsTemplate;
  private final String endpoint;

  public RausQueryService(
    WebServiceTemplate externalWebServiceTemplate,
    @Value("${soap.external.calculator.endpoint}") String endpoint
  ) {
    this.wsTemplate = externalWebServiceTemplate;
    this.endpoint = endpoint;
  }

  // Envía XML "Add" de DNEOnline y devuelve el entero resultante
  public int add(int a, int b) {
    // 1) Construir objeto JAXB de request
    Add req = new Add();
    req.setIntA(a);
    req.setIntB(b);
    // 2) Enviar usando marshalSendAndReceive + SOAPAction
    AddResponse resp = (AddResponse) wsTemplate.marshalSendAndReceive(
      endpoint,
      req,
      new SoapActionCallback("http://tempuri.org/Add")
    );

    // 3) Retornar valor tipado (sin parsear XML)
    return resp.getAddResult();
  }
}
