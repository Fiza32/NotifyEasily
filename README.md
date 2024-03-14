# NotifyEasily

NotifyEasily is a communication service that provides SMS, email, and push notification functionalities. It integrates with multiple service providers to send notifications.

## Technologies Used
- Java
- Spring Boot

## Project Structure
### Notification Integration Service Classes:
- Interfaces in **com.NotifEaze.NotifEaze.service** Package:
  - Contains interface definitions for SMS, email, and notification services.
  - Likely includes EmailService, PushNotificationService, and SmsService interfaces.
- Implementation Classes in **com.NotifEaze.NotifEaze.service.impl** Package:
  - Contains sample implementations for Gupshup (SMS, email, PN).
  - Include classes like SmsServiceImpl, EmailServiceImpl, NotificationServiceImpl, etc.

### Mock Class:
- **GupshupMock** Class in **com.NotifEaze.NotifEaze.mock** Package:
  - Provides mocked responses for various communication channels, including SMS, email, and push notifications.
  - Designed for testing purposes to simulate different scenarios and responses from the Gupshup API or a similar communication service.

### Controller Class:
- **CommunicationController** Class in **com.NotifEaze.NotifEaze.controller** Package:
  - A sample controller for testing the services.
  - Contains API endpoints for sending SMS, email, push notifications, and checking delivery status.
  - Uses instances of EmailService, PushNotificationService, and SmsService to handle the communication.

## Getting Started
To get started with NotifyEasily, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Fiza32/NotifyEasily.git
   ```
2. Navigate to the project directory:
   ```bash
   cd NotifyEasily
   ```
3. Build the project using Maven:
   ```bash
   mvn clean package
   ```
4. Run the application:
   ```bash
   java -jar target/NotifEaze-1.0.jar
   ```

## Usage
### Sending SMS
- To send an SMS, make a POST request to **/api/communication/send-sms** with the message content in the request body.

### Sending Email
- To send an email, make a POST request to **/api/communication/send-email** with the email content in the request body.

### Sending Push Notification
- To send a push notification, make a POST request to **/api/communication/send-notification** with the notification content in the request body.

## Contributors
- Md Faizan Raza


