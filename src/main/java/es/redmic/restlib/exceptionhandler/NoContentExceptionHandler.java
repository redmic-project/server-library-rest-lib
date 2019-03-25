package es.redmic.restlib.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.redmic.exception.common.NoContentException;
import es.redmic.exception.handler.BaseExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class NoContentExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(value = NoContentException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT) // 204
	@ResponseBody
	public void handleConflictException(NoContentException e) {
		return;
	}
}
