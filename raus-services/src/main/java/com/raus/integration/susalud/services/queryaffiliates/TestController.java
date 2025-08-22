package com.raus.integration.susalud.services.queryaffiliates;

import com.raus.integration.susalud.client.common.Messages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/connection")
  public ResponseEntity<String> connection() {
    return ResponseEntity.ok(Messages.SUCCESSFUL_CONNECTION_MESSAGE);
  }
}
