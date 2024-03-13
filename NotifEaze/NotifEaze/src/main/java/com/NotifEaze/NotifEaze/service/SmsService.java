package com.NotifEaze.NotifEaze.service;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;



public interface SmsService {
    BaseSmsResponse sendSms(String phoneNumber, String message);

    SmsDeliveryStatus checkDeliveryStatus(String messageId);
}
