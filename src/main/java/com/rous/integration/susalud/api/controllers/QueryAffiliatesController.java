package com.rous.integration.susalud.api.controllers;

import com.rous.integration.susalud.api.dtos.QueryAffiliatesRequestDto;
import com.rous.integration.susalud.api.dtos.QueryAffiliatesResponseDto;
import com.rous.integration.susalud.soap.SusaludSoapClient;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/affiliates")
public class QueryAffiliatesController {

  private final SusaludSoapClient client;

  public QueryAffiliatesController(SusaludSoapClient client) {
    this.client = client;
  }

  @PostMapping("/query")
  public ResponseEntity<QueryAffiliatesResponseDto> query(
    @Valid @RequestBody QueryAffiliatesRequestDto req
  ) {
    return ResponseEntity.ok(client.consultaAfiliados(req));
  }
}
