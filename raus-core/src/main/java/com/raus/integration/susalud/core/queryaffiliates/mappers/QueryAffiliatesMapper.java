package com.raus.integration.susalud.core.queryaffiliates.mappers;

import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaRequest;
import com.raus.integration.susalud.wsdl.affiliates.ConsultaResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    if (src == null) {
      return QueryAffiliatesResponseVO.builder()
        .coError("")
        .deError("")
        .tiDocumento("")
        .nuDocumento("")
        .apPaterno("")
        .apMaterno("")
        .apCasada("")
        .noPersona("")
        .deSexo("")
        .feNacimiento("")
        .deUbigeo("")
        .coContinente("")
        .deContinente("")
        .coPais("")
        .dePais("")
        .coDepartamento("")
        .deDepartamento("")
        .coProvincia("")
        .deProvincia("")
        .coDistrito("")
        .deDistrito("")
        .inFallecimiento("")
        .feFallecimiento("")
        .coPaisEmisor("")
        .edadActual("")
        //.afiliaciones(Collections.emptyList())
        .build();
    }

    return QueryAffiliatesResponseVO.builder()
      .coError(defaultIfNull(src.getCoError()))
      .deError(defaultIfNull(src.getCoError()))
      .tiDocumento(defaultIfNull(src.getTiDocumento()))
      .nuDocumento(defaultIfNull(src.getNuDocumento()))
      .apPaterno(defaultIfNull(src.getApPaterno()))
      .apMaterno(defaultIfNull(src.getApMaterno()))
      .apCasada(defaultIfNull(src.getApCasada()))
      .noPersona(defaultIfNull(src.getNoPersona()))
      .deSexo(defaultIfNull(src.getDeSexo()))
      .feNacimiento(formatDateToDDMMYYYY(src.getFeNacimiento()))
      .deUbigeo(defaultIfNull(src.getDeUbigeo()))
      .coContinente(defaultIfNull(src.getCoContinente()))
      .deContinente(defaultIfNull(src.getDeContinente()))
      .coPais(defaultIfNull(src.getCoPais()))
      .dePais(defaultIfNull(src.getDePais()))
      .coDepartamento(defaultIfNull(src.getCoDepartamento()))
      .deDepartamento(defaultIfNull(src.getDeDepartamento()))
      .coProvincia(defaultIfNull(src.getCoProvincia()))
      .deProvincia(defaultIfNull(src.getDeProvincia()))
      .coDistrito(defaultIfNull(src.getCoDistrito()))
      .deDistrito(defaultIfNull(src.getDeDistrito()))
      .inFallecimiento(mapDeathIndicator(src.getInFallecimiento()))
      .feFallecimiento(formatDateToDDMMYYYY(src.getFeFallecimiento()))
      .coPaisEmisor(defaultIfNull(src.getCoPaisEmisor()))
      //.afiliaciones(AffiliatesMapper.mapAfiliaciones(src.getAfiliaciones()))
      .edadActual(calculateAge(formatDateToDDMMYYYY(src.getFeNacimiento())))
      .build();
  }

  private static String defaultIfNull(String value) {
    return value != null ? value : "";
  }

  private static String formatDateToDDMMYYYY(String date) {
    if (date == null || date.isEmpty()) return "";
    if (date.contains("/")) return date; // ya en formato dd/MM/yyyy
    if (date.contains("-")) {
      // viene como yyyy-MM-dd
      String[] parts = date.split("-");
      return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
    if (date.length() == 8) {
      // viene como yyyymmdd
      return (
        date.substring(6, 8) +
        "/" +
        date.substring(4, 6) +
        "/" +
        date.substring(0, 4)
      );
    }
    return date;
  }

  private static String mapDeathIndicator(String value) {
    if (value == null) return "";
    if ("1".equalsIgnoreCase(value)) return "NO"; // no fallecido
    if ("0".equalsIgnoreCase(value)) return "SI"; // fallecido
    return "";
  }

  private static String calculateAge(String birthDateStr) {
    if (birthDateStr == null || birthDateStr.isEmpty()) return "";
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date birthDate = sdf.parse(birthDateStr);
      Calendar birth = Calendar.getInstance();
      birth.setTime(birthDate);

      Calendar today = Calendar.getInstance();
      int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
      if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
        age--;
      }
      return String.valueOf(age);
    } catch (Exception e) {
      return "";
    }
  }
}
