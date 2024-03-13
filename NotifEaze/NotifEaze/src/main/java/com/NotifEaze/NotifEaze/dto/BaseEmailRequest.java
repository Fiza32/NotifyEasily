package com.NotifEaze.NotifEaze.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseEmailRequest {
	private String to;
	private String subject;
	private String body;
}
