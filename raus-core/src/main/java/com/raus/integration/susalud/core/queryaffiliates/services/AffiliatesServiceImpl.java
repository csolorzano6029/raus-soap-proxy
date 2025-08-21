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

// import org.springframework.ws.soap.client.core.SoapActionCallback; // si tu WSDL exige SOAPAction

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
    // 1) DTO -> SOAP
    ConsultaRequest soapReq = QueryAffiliatesMapper.toSoapRequest(dto);

    // 2) Llamada SOAP: muchas implementaciones no requieren SOAPAction
    Object raw = serviceTemplate.marshalSendAndReceive(soapReq);

    // Si tu operación requiere SOAPAction explícita, usa esto:
    // Object raw = tpl.marshalSendAndReceive(soapReq, new SoapActionCallback("<<SOAP_ACTION_REAL>>"));

    // 3) SOAP -> DTO
    if (!(raw instanceof ConsultaResponse resp)) {
      throw new IllegalStateException(
        "Respuesta inesperada del servicio SUSALUD"
      );
    }
    return QueryAffiliatesMapper.fromSoapResponse(resp);
  }
}
