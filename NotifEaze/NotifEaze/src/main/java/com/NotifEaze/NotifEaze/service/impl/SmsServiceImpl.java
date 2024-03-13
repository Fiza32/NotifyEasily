package com.NotifEaze.NotifEaze.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.SmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class SmsServiceImpl implements SmsService {
	
	@Autowired
	private GupshupMock gupshupMock;

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		// TODO: Implement the logic to send an SMS
		
		// Initialize the response object
		BaseSmsResponse baseSmsResponse = null;
		
		// TODO: Use the mocked response from GupshupMock
		String mockedSMSResponse = gupshupMock.getSMSMockedResponse(phoneNumber);
		
		// Check if the mocked response is available
		if(mockedSMSResponse == null) {
			// Throw an exception if the mocked response is null
			throw new IllegalArgumentException("Got the null value of BaseSmsResponse");
		}
			ObjectMapper objectMapper = new ObjectMapper();
			
			try {
				// Parse the mocked response JSON
				Map<String, Object> jsonDataMap = objectMapper.readValue(mockedSMSResponse, Map.class);
				
				// Extract relevant information from the JSON
				String newMessage = (String) jsonDataMap.get("message");
				Boolean status = (Boolean) jsonDataMap.get("status");
				
				// Create the response object
				baseSmsResponse = new BaseSmsResponse(status, newMessage);
			} catch (JsonProcessingException ex) {
				// Handle JSON processing exception (if any)
				// Print the exception stack trace for debugging
				ex.printStackTrace(); 
			}
		
	
		
		// Return the response object
		return baseSmsResponse;
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		// Initialize the response object
		SmsDeliveryStatus smsDeliveryStatus = null;
		
		// TODO: Use the mocked response from GupshupMock
		String mockedDeliveryResponse = gupshupMock.getSMSDeliveryStatusMockedResponse(messageId);
		
		// Check if the mocked response is available
		if(mockedDeliveryResponse != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			
			try {
				// Parse the mocked response JSON
				Map<String, Object> jsonDataMap = objectMapper.readValue(mockedDeliveryResponse, Map.class);
				
				
				// Extract relevant information from the JSON
				String newMessage = (String) jsonDataMap.get("message");
				String status = (String) jsonDataMap.get("status");
				
				
				// Convert the status to a boolean
				boolean currStatus = false;
				
				if(status.equalsIgnoreCase("success")) {
					currStatus = true;
				}
				
				// Create the response object
				smsDeliveryStatus = new SmsDeliveryStatus(currStatus, newMessage);
				
			} catch (JsonProcessingException ex) {
				// Handle JSON processing exception (if any)
				ex.getMessage();
			}
		}
		
		else {
			// Throw an exception if the mocked response is null
			throw new IllegalArgumentException("Got the null value of mockedDeliveryResponse");
		}
		
		// Return the response object
		return smsDeliveryStatus;
	}

}
