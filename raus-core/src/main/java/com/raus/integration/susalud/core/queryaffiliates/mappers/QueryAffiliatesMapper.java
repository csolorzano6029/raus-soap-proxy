package com.raus.integration.susalud.core.queryaffiliates.mappers;

import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaRequest;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaResponse;

public final class QueryAffiliatesMapper {

  private QueryAffiliatesMapper() {}

  public static ConsultaRequest toSoapRequest(QueryAffiliatesRequestVO dto) {
    ConsultaRequest req = new ConsultaRequest();
    req.setIdInstitucion(dto.getIdInstitucion());
    req.setTiDocumento(dto.getTiDocumento());
    req.setNuDocumento(dto.getNuDocumento());
    req.setDoConsultante(dto.getDoConsultante());
    return req;
  }

  public static QueryAffiliatesResponseVO fromSoapResponse(
    ConsultaResponse src
  ) {
    return QueryAffiliatesResponseVO.builder()
      .coError(src.getCoError())
      .tiDocumento(src.getTiDocumento())
      .nuDocumento(src.getNuDocumento())
      .apPaterno(src.getApPaterno())
      .apMaterno(src.getApMaterno())
      .apCasada(src.getApCasada())
      .noPersona(src.getNoPersona())
      .deSexo(src.getDeSexo())
      .feNacimiento(src.getFeNacimiento())
      .deUbigeo(src.getDeUbigeo())
      .coContinente(src.getCoContinente())
      .deContinente(src.getDeContinente())
      .coPais(src.getCoPais())
      .dePais(src.getDePais())
      .coDepartamento(src.getCoDepartamento())
      .deDepartamento(src.getDeDepartamento())
      .coProvincia(src.getCoProvincia())
      .deProvincia(src.getDeProvincia())
      .coDistrito(src.getCoDistrito())
      .deDistrito(src.getDeDistrito())
      .inFallecimiento(src.getInFallecimiento())
      .feFallecimiento(src.getFeFallecimiento())
      .coPaisEmisor(src.getCoPaisEmisor())
      .afiliaciones(AffiliatesMapper.mapAfiliaciones(src.getAfiliaciones()))
      .build();
  }
}
