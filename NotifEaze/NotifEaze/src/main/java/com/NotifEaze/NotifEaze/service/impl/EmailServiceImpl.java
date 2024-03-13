package com.NotifEaze.NotifEaze.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;


import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
	
	private final GupshupMock gupshupMock;

	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		// TODO: Implement the logic to send an email
		// TODO: Use the mocked response from GupshupMock
		
		String mockedEmailResponse = gupshupMock.getEmailMockedResponse(to);
		
		BaseEmailResponse baseEmailResponse = null;
		
		// Check if the mocked response is available
		if(mockedEmailResponse != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			
			try {
				// Parse the mocked response JSON
				Map<String, Object> jsonDataMap = objectMapper.readValue(mockedEmailResponse, Map.class);
				
				// Extract relevant information from the JSON
				String message = (String) jsonDataMap.get("message");
				String status = (String) jsonDataMap.get("status");
				
				
				// Convert the status to a boolean
				boolean currStatus = false;
				
				if(status.equalsIgnoreCase("success")) {
					currStatus = true;
				}
				
				// Create the response object
				baseEmailResponse = new BaseEmailResponse(currStatus, message);
			} catch (JsonProcessingException ex) {
				// Handle JSON processing exception (if any)
				ex.getMessage();
			}
		}
		
		// Return the response object
		return baseEmailResponse;
	}

}
