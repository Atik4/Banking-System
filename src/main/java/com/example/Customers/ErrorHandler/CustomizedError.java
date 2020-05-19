package com.example.Customers.ErrorHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import com.example.Customers.Controller.CustomersController;
import com.example.Customers.Exception.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.ObjectError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.ConversionFailedException;

//By default the methods in an @ControllerAdvice apply globally to all Controllers
@ControllerAdvice(assignableTypes= {CustomersController.class})
@RestController
public class CustomizedError extends ResponseEntityExceptionHandler {

	@Autowired
	ErrorResponse errorResponse;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllErrors(Exception ex,WebRequest request){
		errorResponse.setTimeStamp(new Date());
		errorResponse.setMessage(ex.getMessage());
		List<String> details=new ArrayList<String>();
		details.add("Please Contact Administrator.");
		errorResponse.setDetails(details);
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleCustomerNotFoundException(ResourceNotFoundException ex,WebRequest request){
		errorResponse.setTimeStamp(new Date());
		errorResponse.setMessage("No Record Found.");
		List<String> details=new ArrayList<String>();
		details.add(ex.getMessage());
		errorResponse.setDetails(details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	/*
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		errorResponse.setTimeStamp(new Date());
		errorResponse.setMessage("Incorrect Syntax");
		List<String> details=new ArrayList<String>();
		details.add("Bad Type for "+ex.getParameterName()+".");
		errorResponse.setDetails(details);  
		return handleExceptionInternal(ex, errorResponse, headers, status, request);
	}
	*/
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        errorResponse.setTimeStamp(new Date());
        errorResponse.setMessage("New Customer Not Created.");
        List<String> details=ex.getBindingResult()
        		.getAllErrors().stream()
        		.map(ObjectError::getDefaultMessage)
        		.collect(Collectors.toList());
        errorResponse.setDetails(details);
        return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

	@Override
    protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
     
        final String error = "Value for parameter"+
        		" should be of type " + ex.getRequiredType().getSimpleName();
        errorResponse.setTimeStamp(new Date());
        errorResponse.setMessage("Using Incorrect Types.");
        List<String> details=new ArrayList<String>();
        details.add(error);
        errorResponse.setDetails(details);
        return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

	

}
