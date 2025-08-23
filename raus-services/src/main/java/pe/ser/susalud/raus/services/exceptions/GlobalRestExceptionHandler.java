package pe.ser.susalud.raus.services.exceptions;

import pe.ser.susalud.raus.vo.common.ErrorResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.client.SoapFaultClientException;

@ControllerAdvice
public class GlobalRestExceptionHandler {

  private ResponseEntity<ErrorResponseVO> buildErrorResponse(
    Exception ex,
    HttpStatus status
  ) {
    ErrorResponseVO errorResponse = ErrorResponseVO.builder()
      .status(status.value())
      .error(status.getReasonPhrase()) // Ej: "Bad Gateway", "Internal Server Error"
      .message(ex.getMessage()) // mensaje real de la excepción
      .build();

    return ResponseEntity.status(status).body(errorResponse);
  }

  @ExceptionHandler(WebServiceIOException.class)
  public ResponseEntity<ErrorResponseVO> handleWsIo(WebServiceIOException ex) {
    return buildErrorResponse(ex, HttpStatus.BAD_GATEWAY);
  }

  @ExceptionHandler(SoapFaultClientException.class)
  public ResponseEntity<ErrorResponseVO> handleSoapFault(
    SoapFaultClientException ex
  ) {
    return buildErrorResponse(ex, HttpStatus.BAD_GATEWAY);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseVO> handleGeneric(Exception ex) {
    return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
