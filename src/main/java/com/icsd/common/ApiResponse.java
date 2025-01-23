package com.icsd.common;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.Data;

@Data
public class ApiResponse {

	private Integer code;
	
	private String message;
	
	private Object data;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp=LocalDateTime.now();

	public ApiResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ApiResponse(Integer code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ApiResponse() {
		
		this.timestamp=LocalDateTime.now();
		
	}

	@Override
	public String toString() {
		return "ApiResponse [code=" + code + ", message=" + message + ", data=" + data + ", timestamp=" + timestamp
				+ "]";
	}
	
	
	
}
