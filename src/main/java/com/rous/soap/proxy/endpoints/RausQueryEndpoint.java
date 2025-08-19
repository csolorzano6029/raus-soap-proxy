package com.rous.soap.proxy.endpoints;

import com.rous.soap.proxy.services.RausQueryService;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Endpoint
public class RausQueryEndpoint {

  private static final String NAMESPACE =
    "http://example.com/soapproxy/calculator";
  private final RausQueryService client;

  public RausQueryEndpoint(RausQueryService client) {
    this.client = client;
  }

  /**
   * Recibe tu request <addRequest a, b>, llama SOAP externo "Add", retorna <addResponse>.
   */
  @PayloadRoot(namespace = NAMESPACE, localPart = "addRequest")
  @ResponsePayload
  public Element handleAdd(@RequestPayload Element request) throws Exception {
    try {
      // 1) Leer parámetros de tu request
      int a = Integer.parseInt(
        request.getElementsByTagNameNS(NAMESPACE, "a").item(0).getTextContent()
      );
      int b = Integer.parseInt(
        request.getElementsByTagNameNS(NAMESPACE, "b").item(0).getTextContent()
      );

      // 2) Consumir SOAP externo
      int result = client.add(a, b);

      // 3) Construir tu response propio
      Document doc = DocumentBuilderFactory.newInstance()
        .newDocumentBuilder()
        .newDocument();
      Element resp = doc.createElementNS(NAMESPACE, "addResponse");

      Element resultEl = doc.createElementNS(NAMESPACE, "result");
      resultEl.setTextContent(String.valueOf(result));
      resp.appendChild(resultEl);

      Element sourceEl = doc.createElementNS(NAMESPACE, "source");
      sourceEl.setTextContent("DNEOnlineCalculator");
      resp.appendChild(sourceEl);

      Element traceEl = doc.createElementNS(NAMESPACE, "traceId");
      traceEl.setTextContent(java.util.UUID.randomUUID().toString());
      resp.appendChild(traceEl);

      return resp;
    } catch (org.springframework.ws.client.WebServiceIOException e) {
      e.printStackTrace(); // mira e.getCause()
      System.out.println(e.getMessage());
      System.out.println(e.getCause());
      throw e;
    }
  }
}
