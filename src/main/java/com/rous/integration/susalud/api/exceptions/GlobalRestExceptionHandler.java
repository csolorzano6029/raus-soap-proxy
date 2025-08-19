package com.rous.integration.susalud.api.exceptions;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.client.SoapFaultClientException;

@ControllerAdvice
public class GlobalRestExceptionHandler {

  @ExceptionHandler(WebServiceIOException.class)
  public ResponseEntity<Map<String, Object>> handleWsIo(
    WebServiceIOException ex
  ) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
      Map.of("error", "SOAP_UPSTREAM_IO", "message", ex.getMessage())
    );
  }

  @ExceptionHandler(SoapFaultClientException.class)
  public ResponseEntity<Map<String, Object>> handleSoapFault(
    SoapFaultClientException ex
  ) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
      Map.of(
        "error",
        "SOAP_FAULT",
        "faultCode",
        ex.getFaultCode().toString(),
        "message",
        ex.getMessage()
      )
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
      Map.of("error", "INTERNAL_ERROR", "message", ex.getMessage())
    );
  }
}
