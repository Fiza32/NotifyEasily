package com.NotifEaze.NotifEaze.service;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;



public interface PushNotificationService {
    BasePushNotificationResponse sendNotification(String fcmToken, String message);
}
