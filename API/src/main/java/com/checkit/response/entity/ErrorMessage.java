package com.checkit.response.entity;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ErrorMessage {

	private String timestamp;
	private String message;

	public ErrorMessage() {

	}

	public ErrorMessage(Date timestamp, String message) {
		this.setTimestamp(timestamp);
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);

		this.timestamp = ft.format(timestamp);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
