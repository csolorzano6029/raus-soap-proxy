package com.rous.integration.susalud.api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryAffiliatesRequestDto {

  @NotNull
  String idInstitucion;

  @NotNull
  String tiDocumento;

  @NotNull
  String nuDocumento;

  @NotNull
  String doConsultante;
}
