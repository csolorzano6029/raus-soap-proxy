package pe.ser.susalud.raus.core.queryaffiliates.mappers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesRequestVO;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesResponseVO;
import pe.ser.susalud.raus.wsdl.affiliates.ConsultaRequest;
import pe.ser.susalud.raus.wsdl.affiliates.ConsultaResponse;

class QueryAffiliatesMapperTest {

  @Test
  void testToSoapRequest() {
    QueryAffiliatesRequestVO dto = QueryAffiliatesRequestVO.builder()
      .idInstitucion("H001")
      .tiDocumento("DNI")
      .nuDocumento("12345678")
      .doConsultante("APP")
      .build();

    ConsultaRequest req = QueryAffiliatesMapper.toSoapRequest(dto);

    assertEquals("H001", req.getIdInstitucion());
    assertEquals("DNI", req.getTiDocumento());
    assertEquals("12345678", req.getNuDocumento());
    assertEquals("APP", req.getDoConsultante());
  }

  @Test
  void testFromSoapResponse_null_returnsEmptyVO() {
    QueryAffiliatesResponseVO result = QueryAffiliatesMapper.fromSoapResponse(
      null
    );

    assertNotNull(result);
    assertEquals("", result.getNuDocumento());
    assertEquals("", result.getApPaterno());
    assertEquals("", result.getEdadActual());
  }

  @Test
  void testFromSoapResponse_withData() {
    ConsultaResponse src = new ConsultaResponse();
    src.setCoError("0");
    src.setTiDocumento("DNI");
    src.setNuDocumento("12345678");
    src.setApPaterno("Perez");
    src.setFeNacimiento("1990-05-10"); // debería formatear a dd/MM/yyyy

    QueryAffiliatesResponseVO result = QueryAffiliatesMapper.fromSoapResponse(
      src
    );

    assertEquals("0", result.getCoError());
    assertEquals("DNI", result.getTiDocumento());
    assertEquals("12345678", result.getNuDocumento());
    assertEquals("Perez", result.getApPaterno());
    assertTrue(result.getFeNacimiento().contains("/")); // validó formato
    assertNotEquals("", result.getEdadActual()); // calculó edad
  }

  @Test
  void testFormatDateFromYYYYMMDD() {
    ConsultaResponse src = new ConsultaResponse();
    src.setFeNacimiento("19900510");

    QueryAffiliatesResponseVO result = QueryAffiliatesMapper.fromSoapResponse(
      src
    );

    assertEquals("10/05/1990", result.getFeNacimiento());
  }

  @Test
  void testMapDeathIndicator() {
    ConsultaResponse src = new ConsultaResponse();
    src.setInFallecimiento("0"); // fallecido

    QueryAffiliatesResponseVO result = QueryAffiliatesMapper.fromSoapResponse(
      src
    );

    assertEquals("SI", result.getInFallecimiento());
  }
}
