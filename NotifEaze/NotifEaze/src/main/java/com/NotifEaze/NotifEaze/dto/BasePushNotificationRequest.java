package com.NotifEaze.NotifEaze.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasePushNotificationRequest {
	private String fcmToken;
	private String message;
}
