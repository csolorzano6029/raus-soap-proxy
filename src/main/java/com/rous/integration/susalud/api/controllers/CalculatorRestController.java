package com.rous.integration.susalud.api.controllers;

import com.rous.integration.susalud.api.dtos.AddRequestDto;
import com.rous.integration.susalud.api.dtos.AddResponseDto;
import com.rous.integration.susalud.soap.CalculatorSoapClient;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorRestController {

  private final CalculatorSoapClient client;

  public CalculatorRestController(CalculatorSoapClient client) {
    this.client = client;
  }

  @PostMapping("/add")
  public ResponseEntity<AddResponseDto> add(
    @Valid @RequestBody AddRequestDto addRequestDto
  ) {
    int result = client.add(addRequestDto.getA(), addRequestDto.getB());
    return ResponseEntity.ok(new AddResponseDto(result));
  }
}
