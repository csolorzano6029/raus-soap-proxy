package com.rous.integration.susalud.soap;

import com.rous.integration.susalud.calculator.client.Add;
import com.rous.integration.susalud.calculator.client.AddResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class CalculatorSoapClient {

  private final WebServiceTemplate template;
  private final String endpoint;

  public CalculatorSoapClient(
    WebServiceTemplate template,
    @Value("${soap.external.calculator.endpoint}") String endpoint
  ) {
    this.template = template;
    this.endpoint = endpoint;
  }

  public int add(int a, int b) {
    Add req = new Add();
    req.setIntA(a);
    req.setIntB(b);

    AddResponse resp = (AddResponse) template.marshalSendAndReceive(
      endpoint,
      req,
      new SoapActionCallback("http://tempuri.org/Add")
    );
    return resp.getAddResult();
  }
}
