package com.gabriel.projeto.api.handlerexception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gabriel.projeto.domain.exception.AutomovelVendidoException;

@ControllerAdvice
public class ApiHandleException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(AutomovelVendidoException.class)
	public ResponseEntity<Object> handleVendido(AutomovelVendidoException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
}
