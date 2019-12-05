package ar.edu.unlp.bd.biblio.error;

import java.util.Date;

public class BiblioResponse {
	private Date timestamp;
	private String message;
	private String error;
	private Integer status;

	
	public BiblioResponse(String message, String error, Integer status) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.timestamp = new Date();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	

}
