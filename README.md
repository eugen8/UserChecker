# User Fraud Detector / User Checker

Description: Some sample Spring Boot application for a hypothetical user
fraud detection

Requirements:
* Given a user object with name/email/phone/etc
* Validate the existence, quality and validity of an email address
  * VIA regex
  * if Valid, second step via API https://rapidapi.com/whoisapi/api/email-verification/
* Validate phone number: https://www.bigdatacloud.com/phone-email-verification/phone-number-validation-api for  international and national phone number validation based on the E.164
* Validate the user has acceess to the email
* Validate the user has access to the phone number


For sample commands when running in localhost, see [commands.md](commands.md)