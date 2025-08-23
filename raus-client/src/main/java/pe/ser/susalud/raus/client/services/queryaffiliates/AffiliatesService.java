package pe.ser.susalud.raus.client.services.queryaffiliates;

import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesRequestVO;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesResponseVO;

public interface AffiliatesService {
  QueryAffiliatesResponseVO queryAffiliates(QueryAffiliatesRequestVO req);
}
