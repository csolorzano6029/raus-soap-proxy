package pe.ser.susalud.raus.services.queryaffiliates;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import pe.ser.susalud.raus.client.services.queryaffiliates.AffiliatesService;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesRequestVO;
import pe.ser.susalud.raus.vo.queryaffiliates.QueryAffiliatesResponseVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(QueryAffiliatesController.class)
class QueryAffiliatesControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private AffiliatesService affiliatesService;

  @Test
  void shouldReturnOkWhenServiceReturnsResponse() throws Exception {
    // Arrange
    QueryAffiliatesRequestVO request = new QueryAffiliatesRequestVO();
    request.setIdInstitucion("H001");
    request.setTiDocumento("DNI");
    request.setNuDocumento("12345678");
    request.setDoConsultante("APP-TEST");

    QueryAffiliatesResponseVO response = new QueryAffiliatesResponseVO();
    response.setNuDocumento("12345678");
    response.setTiDocumento("DNI");

    when(
      affiliatesService.queryAffiliates(any(QueryAffiliatesRequestVO.class))
    ).thenReturn(response);

    // Act & Assert
    mockMvc
      .perform(
        post("/affiliates/query")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(request))
      )
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.nuDocumento").value("12345678"))
      .andExpect(jsonPath("$.tiDocumento").value("DNI"));
  }

  @Test
  void shouldReturnNoContentWhenResponseIsNull() throws Exception {
    // Arrange
    QueryAffiliatesRequestVO request = new QueryAffiliatesRequestVO();
    request.setIdInstitucion("H001");
    request.setTiDocumento("DNI");
    request.setNuDocumento("00000000");

    when(
      affiliatesService.queryAffiliates(any(QueryAffiliatesRequestVO.class))
    ).thenReturn(null);

    // Act & Assert
    mockMvc
      .perform(
        post("/affiliates/query")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(request))
      )
      .andExpect(status().isNoContent());
  }
}
