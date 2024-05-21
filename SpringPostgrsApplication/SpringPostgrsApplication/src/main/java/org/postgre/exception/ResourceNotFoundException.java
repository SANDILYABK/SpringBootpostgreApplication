package org.postgre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException {
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class Exception {

		private static final long serialVersionUID = 1L;

		public Exception(String message){
	    	super();
	    }
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}