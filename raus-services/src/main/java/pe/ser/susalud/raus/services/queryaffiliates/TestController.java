package pe.ser.susalud.raus.services.queryaffiliates;

import pe.ser.susalud.raus.client.common.Messages;
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
