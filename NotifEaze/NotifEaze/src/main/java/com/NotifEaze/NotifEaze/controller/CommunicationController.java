package com.NotifEaze.NotifEaze.controller;

import com.NotifEaze.NotifEaze.dto.BaseEmailRequest;
import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationRequest;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsRequest;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/communication")
public class CommunicationController {
	
	private final EmailService emailService;
	private final PushNotificationService pushNotificationService;
	private final SmsService smsService;
	
    @PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody BaseSmsRequest request) {
    	// TODO: Implement logic to send an SMS
    	
    	BaseSmsResponse baseSmsResponse = smsService.sendSms(request.getPhoneNumber(), request.getMessage());
    	
        return new ResponseEntity<>(baseSmsResponse, HttpStatus.OK);
    }

    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody BaseEmailRequest request) {
    	// TODO: Implement logic to send an email
    	BaseEmailResponse baseEmailResponse = emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
    	
        return new ResponseEntity<>(baseEmailResponse, HttpStatus.OK);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification(@RequestBody BasePushNotificationRequest request) {
    	// TODO: Implement logic to send a push notification
    	BasePushNotificationResponse basePushNotificationResponse = pushNotificationService.sendNotification(request.getFcmToken(), request.getMessage());
    	
        return new ResponseEntity<>(basePushNotificationResponse, HttpStatus.OK);
    }
    
    @PostMapping("/get-status/{messageId}")
    public ResponseEntity<SmsDeliveryStatus> getDeliveryStatus(@PathVariable String messageId){
    	// TODO: Implement logic to get the delivery status of an SMS
    	SmsDeliveryStatus smsDeliveryStatus = smsService.checkDeliveryStatus(messageId);
    	
    	return new ResponseEntity<SmsDeliveryStatus>(smsDeliveryStatus, HttpStatus.OK);
    }
}
