package com.raus.integration.susalud.vo.queryaffiliates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AfiliacionVO {

  private String coAfiliacion;
  private String tiPlanSalud;
  private String dePlanSalud;
  private String coIafas;
  private String tiIafas;
  private String deIafas;
  private String coParentesco;
  private String coPaisTitular;
  private String tiDocTitular;
  private String nuDocTitular;
  private String feIniAfiliacion;
  private String feFinAfiliacion;
  private String feFinCobertura;
  private String feActIafas;
  private String feActSunasa;
}
