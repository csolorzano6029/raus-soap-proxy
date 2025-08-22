package com.raus.integration.susalud.core.queryaffiliates.services;

import com.raus.integration.susalud.client.services.queryaffiliates.AffiliatesService;
import com.raus.integration.susalud.core.queryaffiliates.mappers.QueryAffiliatesMapper;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaRequest;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

// If the WSDL requires SOAPAction, use this
// import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class AffiliatesServiceImpl implements AffiliatesService {

  private final WebServiceTemplate serviceTemplate;

  public AffiliatesServiceImpl(
    @Qualifier("susaludWebServiceTemplate") WebServiceTemplate serviceTemplate
  ) {
    this.serviceTemplate = serviceTemplate;
  }

  @Override
  public QueryAffiliatesResponseVO queryAffiliates(
    QueryAffiliatesRequestVO dto
  ) {
    ConsultaRequest soapReq = QueryAffiliatesMapper.toSoapRequest(dto);
    Object raw = serviceTemplate.marshalSendAndReceive(soapReq);

    // If the operation requires an explicit SOAPAction, use this:
    // Object raw = tpl.marshalSendAndReceive(soapReq, new SoapActionCallback("<<SOAP_ACTION_REAL>>"));

    if (!(raw instanceof ConsultaResponse resp)) {
      throw new IllegalStateException(
        "Respuesta inesperada del servicio SUSALUD"
      );
    }

    return QueryAffiliatesMapper.fromSoapResponse(resp);
  }
}
