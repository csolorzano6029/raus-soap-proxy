package com.raus.integration.susalud.services.queryaffiliates;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/connection")
  public ResponseEntity<String> connection() {
    return ResponseEntity.ok(
      "Conexión exitosa con raus-integration-susalud-ms"
    );
  }
}
