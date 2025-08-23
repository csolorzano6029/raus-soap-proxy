package pe.ser.susalud.raus.vo.queryaffiliates;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryAffiliatesRequestVO {

  @NotNull
  String idInstitucion;

  @NotNull
  String tiDocumento;

  @NotNull
  String nuDocumento;

  @NotNull
  String doConsultante;
}
