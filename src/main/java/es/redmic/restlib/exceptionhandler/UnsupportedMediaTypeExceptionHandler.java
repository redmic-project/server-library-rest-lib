package es.redmic.restlib.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.redmic.exception.common.UnsupportedMediaTypeException;
import es.redmic.exception.dto.ErrorDTO;
import es.redmic.exception.handler.BaseExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class UnsupportedMediaTypeExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(value = UnsupportedMediaTypeException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE) // 415
	@ResponseBody
	public ErrorDTO handleConflictException(UnsupportedMediaTypeException e) {
		return getError(e);
	}
}
