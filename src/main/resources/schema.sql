DROP TABLE IF EXISTS application_user;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS appointment;

CREATE TABLE application_user (
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    user_email VARCHAR(250) NOT NULL,
    user_mobile VARCHAR(250) NOT NULL,
    location VARCHAR(250) NOT NULL
);
          
CREATE TABLE appointment (
  booking_id VARCHAR(250) PRIMARY KEY,
  disease VARCHAR(250) NOT NULL,
  tentative_date DATE NOT NULL,
  priority VARCHAR(250) NOT NULL,
  patient_id VARCHAR(250) NOT NULL,
  booking_time DATE 
);
  
CREATE TABLE patient (
  patient_id VARCHAR(250) PRIMARY KEY,
  patient_name VARCHAR(250) NOT NULL,
  patient_email VARCHAR(250) NOT NULL,
  patient_mobile VARCHAR(250) NOT NULL,
  registered_date DATE NOT NULL
);

  
