package es.redmic.restlib.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.redmic.exception.common.ConflictException;
import es.redmic.exception.dto.ErrorDTO;
import es.redmic.exception.handler.BaseExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ConflictExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(value = ConflictException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT) // 409
	@ResponseBody
	public ErrorDTO handleConflictException(ConflictException e) {
		return getError(e);
	}
}
