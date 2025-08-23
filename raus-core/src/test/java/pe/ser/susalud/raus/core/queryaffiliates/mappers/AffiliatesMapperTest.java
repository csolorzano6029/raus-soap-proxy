package pe.ser.susalud.raus.core.queryaffiliates.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import pe.ser.susalud.raus.vo.queryaffiliates.AfiliacionVO;
import pe.ser.susalud.raus.wsdl.affiliates.Afiliaciones;
import pe.ser.susalud.raus.wsdl.affiliates.Afiliaciones.Afiliacion;

class AffiliatesMapperTest {

  @Test
  void whenAfiliacionesIsNull_thenReturnEmptyList() {
    List<AfiliacionVO> result = AffiliatesMapper.mapAfiliaciones(null);
    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void whenAfiliacionesEmpty_thenReturnEmptyList() {
    Afiliaciones afiliaciones = new Afiliaciones();
    List<AfiliacionVO> result = AffiliatesMapper.mapAfiliaciones(afiliaciones);
    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void whenAfiliacionesPresent_thenMapToVO() {
    Afiliaciones afiliaciones = new Afiliaciones();
    Afiliacion af = new Afiliacion();
    af.setCoAfiliacion("123");
    af.setTiPlanSalud("PLAN1");
    af.setDePlanSalud("Plan Salud Básico");
    af.setCoIafas("IAFAS01");
    af.setTiIafas("Tipo1");
    af.setDeIafas("Iafas prueba");
    af.setCoParentesco("H");
    af.setCoPaisTitular("EC");
    af.setTiDocTitular("DNI");
    af.setNuDocTitular("12345678");
    af.setFeIniAfiliacion("2020-01-01");
    af.setFeFinAfiliacion("2025-01-01");

    afiliaciones.getAfiliacion().add(af);

    List<AfiliacionVO> result = AffiliatesMapper.mapAfiliaciones(afiliaciones);

    assertEquals(1, result.size());
    AfiliacionVO vo = result.get(0);
    assertEquals("123", vo.getCoAfiliacion());
    assertEquals("PLAN1", vo.getTiPlanSalud());
    assertEquals("Plan Salud Básico", vo.getDePlanSalud());
    assertEquals("12345678", vo.getNuDocTitular());
  }
}
