package pe.ser.susalud.raus.core.queryaffiliates.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import pe.ser.susalud.raus.client.services.queryaffiliates.AffiliatesService;
import pe.ser.susalud.raus.core.queryaffiliates.mappers.QueryAffiliatesMapper;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesRequestVO;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesResponseVO;
import pe.ser.susalud.raus.wsdl.affiliates.ConsultaRequest;
import pe.ser.susalud.raus.wsdl.affiliates.ConsultaResponse;

/**
 * If the WSDL requires SOAPAction, use this
 * import org.springframework.ws.soap.client.core.SoapActionCallback;
 */
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
    /**
     * If the operation requires an explicit SOAPAction, use this:
     * Object raw = serviceTemplate.marshalSendAndReceive(soapReq, new SoapActionCallback("<<SOAP_ACTION_REAL>>"));
     */
    ConsultaRequest soapReq = QueryAffiliatesMapper.toSoapRequest(dto);
    Object raw = serviceTemplate.marshalSendAndReceive(soapReq);

    if (!(raw instanceof ConsultaResponse resp)) {
      throw new IllegalStateException(
        "Respuesta inesperada del servicio SUSALUD"
      );
    }

    return QueryAffiliatesMapper.fromSoapResponse(resp);
  }
}
