package com.raus.integration.susalud.core.queryaffiliates.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaRequest;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.client.core.WebServiceTemplate;

@ExtendWith(MockitoExtension.class)
class AffiliatesServiceImplTest {

  @Mock
  private WebServiceTemplate serviceTemplate;

  @InjectMocks
  private AffiliatesServiceImpl affiliatesService;

  private QueryAffiliatesRequestVO requestVO;
  private ConsultaResponse soapResponse;

  @BeforeEach
  void setUp() {
    requestVO = QueryAffiliatesRequestVO.builder()
      .nuDocumento("12345678")
      .tiDocumento("DNI")
      .idInstitucion("H001")
      .build();

    soapResponse = new ConsultaResponse();
    // setea campos de prueba si los necesitas...
  }

  @Test
  void queryAffiliates_returnsMappedResponse() {
    // given → mock de la respuesta SOAP
    when(
      serviceTemplate.marshalSendAndReceive(any(ConsultaRequest.class))
    ).thenReturn(soapResponse);

    // when
    QueryAffiliatesResponseVO result = affiliatesService.queryAffiliates(
      requestVO
    );

    // then
    assertNotNull(result);
    // si QueryAffiliatesMapper.fromSoapResponse() setea algo,
    // valida los campos esperados:
    // assertEquals("12345678", result.getNuDocumento());

    verify(serviceTemplate, times(1)).marshalSendAndReceive(
      any(ConsultaRequest.class)
    );
  }

  @Test
  void queryAffiliates_invalidResponseType_throwsException() {
    // given → simular que el SOAP devuelve algo inválido
    when(
      serviceTemplate.marshalSendAndReceive(any(ConsultaRequest.class))
    ).thenReturn(new Object()); // no es ConsultaResponse

    // when + then
    IllegalStateException ex = assertThrows(IllegalStateException.class, () ->
      affiliatesService.queryAffiliates(requestVO)
    );

    assertTrue(ex.getMessage().contains("Respuesta inesperada"));
  }
}
