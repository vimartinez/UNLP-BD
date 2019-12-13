package ar.edu.unlp.bd.biblio.error;

import java.util.Date;

public class BiblioResponse {
	private Date timestamp;
	private String cause;
	private String message;
	private String result;
	private Integer status;

	
	public BiblioResponse(String cause, String message, String result, Integer status) {
		super();
		this.message = message;
		this.result = result;
		this.status = status;
		this.timestamp = new Date();
		this.cause = cause;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}	

}
