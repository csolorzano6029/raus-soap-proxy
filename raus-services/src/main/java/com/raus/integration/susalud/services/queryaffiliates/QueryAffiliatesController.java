package com.raus.integration.susalud.services.queryaffiliates;

import com.raus.integration.susalud.client.queryaffiliates.AffiliatesService;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/affiliates")
public class QueryAffiliatesController {

  private final AffiliatesService client;

  public QueryAffiliatesController(AffiliatesService client) {
    this.client = client;
  }

  @PostMapping("/query")
  public ResponseEntity<QueryAffiliatesResponseVO> query(
    @Valid @RequestBody QueryAffiliatesRequestVO req
  ) {
    return ResponseEntity.ok(client.queryAffiliates(req));
  }
}
