package com.rous.integration.susalud.soap.mappers;

import com.rous.integration.susalud.api.dtos.AfiliacionDto;
import com.rous.integration.susalud.query.affiliates.Afiliaciones;
import java.util.List;
import java.util.stream.Collectors;

public class AffiliatesMapper {

  private AffiliatesMapper() {}

  public static List<AfiliacionDto> mapAfiliaciones(Afiliaciones afiliaciones) {
    if (afiliaciones == null || afiliaciones.getAfiliacion() == null) {
      return List.of();
    }

    return afiliaciones
      .getAfiliacion()
      .stream()
      .map(afiliacion ->
        AfiliacionDto.builder()
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
      .collect(Collectors.toList());
  }
}
