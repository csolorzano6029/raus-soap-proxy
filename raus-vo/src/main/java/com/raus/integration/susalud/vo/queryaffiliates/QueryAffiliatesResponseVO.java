package com.raus.integration.susalud.vo.queryaffiliates;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryAffiliatesResponseVO {

  private String coError;
  private String deError;
  private String tiDocumento;
  private String nuDocumento;
  private String apPaterno;
  private String apMaterno;
  private String apCasada;
  private String noPersona;
  private String deSexo;
  private String feNacimiento;
  private String deUbigeo;
  private String coContinente;
  private String deContinente;
  private String coPais;
  private String dePais;
  private String coDepartamento;
  private String deDepartamento;
  private String coProvincia;
  private String deProvincia;
  private String coDistrito;
  private String deDistrito;
  private String inFallecimiento;
  private String feFallecimiento;
  private String coPaisEmisor;
  private String edadActual;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<AfiliacionVO> afiliaciones;
}
