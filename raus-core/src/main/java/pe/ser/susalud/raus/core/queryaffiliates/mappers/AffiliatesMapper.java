package pe.ser.susalud.raus.core.queryaffiliates.mappers;

import java.util.List;
import pe.ser.susalud.raus.vo.queryaffiliates.AfiliacionVO;
import pe.ser.susalud.raus.wsdl.affiliates.Afiliaciones;

public class AffiliatesMapper {

  private AffiliatesMapper() {}

  public static List<AfiliacionVO> mapAfiliaciones(Afiliaciones afiliaciones) {
    if (afiliaciones == null || afiliaciones.getAfiliacion() == null) {
      return List.of();
    }

    return afiliaciones
      .getAfiliacion()
      .stream()
      .map(afiliacion ->
        AfiliacionVO.builder()
          .coAfiliacion(afiliacion.getCoAfiliacion())
          .tiPlanSalud(afiliacion.getTiPlanSalud())
          .dePlanSalud(afiliacion.getDePlanSalud())
          .coIafas(afiliacion.getCoIafas())
          .tiIafas(afiliacion.getTiIafas())
          .deIafas(afiliacion.getDeIafas())
          .coParentesco(afiliacion.getCoParentesco())
          .coPaisTitular(afiliacion.getCoPaisTitular())
          .tiDocTitular(afiliacion.getTiDocTitular())
          .nuDocTitular(afiliacion.getNuDocTitular())
          .feIniAfiliacion(afiliacion.getFeIniAfiliacion())
          .feFinAfiliacion(afiliacion.getFeFinAfiliacion())
          .feFinCobertura(afiliacion.getFeFinCobertura())
          .feActIafas(afiliacion.getFeActIafas())
          .feActSunasa(afiliacion.getFeActSunasa())
          .build()
      )
      .toList();
  }
}
