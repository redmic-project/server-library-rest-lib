package es.redmic.restlib.exceptionhandler;

/*-
 * #%L
 * rest-lib
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.redmic.exception.common.UnsupportedMediaTypeException;
import es.redmic.exception.dto.ErrorDTO;
import es.redmic.exception.handler.BaseExceptionHandler;

@RestControllerAdvice
public class UnsupportedMediaTypeExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler(value = UnsupportedMediaTypeException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE) // 415
	public ErrorDTO handleConflictException(UnsupportedMediaTypeException e) {
		return getError(e);
	}
}
