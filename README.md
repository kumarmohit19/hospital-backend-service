# Healthcare Service - Spring Boot

## HealthCare Service - SpringBoot Backend

**Create an API for Healthcare Service.**

**API Endpoints**

- _register:(HTTP METHOD-POST)_

  Should register a user.

  - On successful registration, the response should be
    `{message=""Registration successful""}` .
  - On registration failure, the response should be  
    `{message="Password or username policy failed"}`.

- _signin : (HTTP METHOD-POST)_

A user should be able to sign in through this endpoint by providing their email and password.
On successful login, the response should be:

```
{
  message = "Authentication successful!",
  token = JWTtoken,
  id=user.Id
};
```

On login failure, the response should be {message="Username or Password is Incorrect."}

- _"viewprofile/{userId}":(HTTP METHOD-GET)_

  Should return the details of all users.

- _"editprofile/{userId}":(HTTP METHOD-GET)_

  Should allow you to edit a user's profile.

- _"patients/register" : (HTTP METHOD-POST)_

  A user should be able to register a patient through this API.

  - On succcessful registration, the response should be `{message="Registration successful"}`.
  - On registration failure, the response should be  
    `{message="Registration failure"}`.

- _"patients/list/": (HTTP METHOD-GET)_

  Should return the list of all patients.

- _"patients/view/{Id}" : (HTTP METHOD-GET)_

  Should return details of a specified patient ID.

- _"patients/delete/{Id}" : (HTTP METHOD-DELETE)_

  Should delete a specified patient ID.

- _"appointment/register" : (HTTP METHOD-POST)_

  Should book an appointment.

  - On successful booking, the response should be  
    `{message="Booking successful"}` .
  - On booking failure, the response should be  
    `{message="Booking failure"}`.

- _"appointment/list" : (HTTP METHOD-GET)_

  Should return the list of all appointments.

- _"/appointment/view/{appointmentId}" : (HTTP METHOD-GET)_

  Should return details of a specified appointment ID.

- _"/appointment/list/{patientid}" : (HTTP METHOD-GET)_

  Should return the list of all the appointments of a specified patient ID.

- _"/appointment/delete/{appointmentId}" : (HTTP METHOD-DELETE)_

  Should delete a specified appointment ID.

**Middleware:**

Create a Middleware to validate the API calls using JSON web token (JWT).

'Sign in' and 'Register API' endpoints do not require Middleware.
If the login details are validated, send a response with the JWT as token parameter.

**Steps:**

1. Install dependencies (project > install)

2. Run application (project > run)

3. Test application (Run tests)
