package br.com.dalessio.auto.category.model;

public class ErrorDTO {

	private String message;
	
	public ErrorDTO(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
