package com.NotifEaze.NotifEaze.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PushNotificationServiceImpl implements PushNotificationService {
	
	private final GupshupMock gupshupMock;

	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
		// TODO: Implement the logic to send a push notification
		// TODO: Use the mocked response from GupshupMock
		String mockedEmailResponse = gupshupMock.getEmailMockedResponse(fcmToken);
		
		// Initialize the response object
		BasePushNotificationResponse basePushNotificationResponse = null;
		
		// Check if the mocked response is not null
		if(mockedEmailResponse != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			
			try {
				// Parse the mocked response JSON
				Map<String, Object> jsonDataMap = objectMapper.readValue(mockedEmailResponse, Map.class);
				
				// Extract relevant information from the JSON
				String newMessage = (String) jsonDataMap.get("message");
				String status = (String) jsonDataMap.get("status");
				
				// Convert the status to a boolean
				boolean currStatus = false;
				
				if(status.equalsIgnoreCase("success")) {
					currStatus = true;
				}
				
				// Create the response object
				basePushNotificationResponse = new BasePushNotificationResponse(currStatus, newMessage);
			} catch (JsonProcessingException ex) {
				// Handle JSON processing exception (if any)
				ex.getMessage();
			}
			
		} else {
			// Throw an exception if the mocked response is null
			throw new IllegalArgumentException("Got the null value of BasePushNotificationResponse");
		}
		
		// Return the response object
		return basePushNotificationResponse;
	}

}
