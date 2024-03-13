# NotifyEasily

NotifyEasily is a communication service that provides SMS, email, and push notification functionalities. It integrates with multiple service providers to send notifications.

## Technologies Used
- Java
- Spring Boot

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
- To send an SMS, make a POST request to /api/communication/send-sms with the message content in the request body.

### Sending Email
- To send an email, make a POST request to /api/communication/send-email with the email content in the request body.

### Sending Push Notification
- To send a push notification, make a POST request to /api/communication/send-notification with the notification content in the request body.

## Contributors
- Md Faizan Raza


