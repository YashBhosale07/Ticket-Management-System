package com.ticketmanagement.exceptionhandling;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private LocalDateTime localDateTime;
	private String message;
	private String details;
}
