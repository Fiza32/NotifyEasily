package com.NotifEaze.NotifEaze.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseSmsRequest {
	private String phoneNumber;
	private String message;
}
