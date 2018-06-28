package es.redmic.restlib.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.redmic.exception.common.RequestTimeoutException;
import es.redmic.exception.dto.ErrorDTO;
import es.redmic.exception.handler.BaseExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class RequestTimeoutExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(value = RequestTimeoutException.class)
	@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT) // 408
	@ResponseBody
	public ErrorDTO handleBadRequestException(RequestTimeoutException e) {
		return getError(e);
	}
}
