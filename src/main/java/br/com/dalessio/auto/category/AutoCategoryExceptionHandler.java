package br.com.dalessio.auto.category;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dalessio.auto.category.controller.AccountController;
import br.com.dalessio.auto.category.model.ErrorDTO;
import br.com.dalessio.auto.category.utils.LogUtils;
import br.com.dalessio.auto.category.utils.MessageUtils;

@ControllerAdvice(basePackageClasses = AccountController.class)
public class AutoCategoryExceptionHandler {

	private MessageUtils messageUtils;
	private LogUtils loggerUtils;

	@Autowired
	public AutoCategoryExceptionHandler(LogUtils logger, MessageUtils messageUtils) {
		this.loggerUtils = logger;
		this.messageUtils = messageUtils;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
		loggerUtils.logStackTrace(ex.fillInStackTrace(), this.getClass());
		String message = messageUtils.getMessageAndSubParams("errorMissingServletParameter", ex.getParameterName());
		return new ResponseEntity<>(new ErrorDTO(message), BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex) {
		loggerUtils.logStackTrace(ex.fillInStackTrace(), this.getClass());
		String message = ex.getConstraintViolations().stream().findFirst().isPresent()
				? ex.getConstraintViolations().stream().findFirst().get().getMessage()
				: messageUtils.getMessageAndSubParams("errorMissingConstraintViolation");
		return new ResponseEntity<>(new ErrorDTO(message), BAD_REQUEST);
	}

}
