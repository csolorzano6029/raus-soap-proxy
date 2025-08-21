package com.raus.integration.susalud.client.services.queryaffiliates;

import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesRequestVO;
import com.raus.integration.susalud.vo.queryaffiliates.QueryAffiliatesResponseVO;

public interface AffiliatesService {
  QueryAffiliatesResponseVO queryAffiliates(QueryAffiliatesRequestVO req);
}
