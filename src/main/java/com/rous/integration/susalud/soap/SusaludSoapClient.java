package com.rous.integration.susalud.soap;

import com.rous.integration.susalud.api.dtos.QueryAffiliatesRequestDto;
import com.rous.integration.susalud.api.dtos.QueryAffiliatesResponseDto;
import com.rous.integration.susalud.query.affiliates.ConsultaRequest;
import com.rous.integration.susalud.query.affiliates.ConsultaResponse;
import com.rous.integration.susalud.soap.mappers.QueryAffiliatesMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

// import org.springframework.ws.soap.client.core.SoapActionCallback; // si tu WSDL exige SOAPAction

@Service
public class SusaludSoapClient {

  private final WebServiceTemplate tpl;

  public SusaludSoapClient(
    @Qualifier("susaludWebServiceTemplate") WebServiceTemplate tpl
  ) {
    this.tpl = tpl;
  }

  public QueryAffiliatesResponseDto consultaAfiliados(
    QueryAffiliatesRequestDto dto
  ) {
    // 1) DTO -> SOAP
    ConsultaRequest soapReq = QueryAffiliatesMapper.toSoapRequest(dto);

    // 2) Llamada SOAP: muchas implementaciones no requieren SOAPAction
    Object raw = tpl.marshalSendAndReceive(soapReq);

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
