CREATE DATABASE ADS_DB;

USE ADS_DB;

CREATE TABLE `dentist` (
  `dentist_id` int NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `content_phone_no` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `specialization` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dentist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `patient` (
  `patient_id` int NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `contact_phone_no` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mailing_address` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `surgery` (
  `surgery_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location_address` varchar(45) DEFAULT NULL,
  `telephone_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`surgery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `appointment` (
  `appointment_id` int NOT NULL,
  `appointment_date` varchar(45) DEFAULT NULL,
  `appointment_time` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `surgery_id` int DEFAULT NULL,
  `dentist_id` int DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `dentist_id_idx` (`dentist_id`),
  KEY `patient_id_idx` (`patient_id`),
  KEY `surgery_id_idx` (`surgery_id`),
  CONSTRAINT `dentist_id` FOREIGN KEY (`dentist_id`) REFERENCES `dentist` (`dentist_id`),
  CONSTRAINT `patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  CONSTRAINT `surgery_id` FOREIGN KEY (`surgery_id`) REFERENCES `surgery` (`surgery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO dentist VALUES 
(1, 'John', 'Smith', '123-456-7890', 'john.smith@example.com', 'General'),
(2, 'Emily', 'Johnson', '987-654-3210', 'emily.j@example.com', 'Orthodontics'),
(3, 'Michael', 'Williams', '555-123-4567', 'm.williams@example.com', 'Endodontics'),
(4, 'Sarah', 'Brown', '999-888-7777', 'sbrown@example.com', 'Periodontics'),
(5, 'David', 'Jones', '111-222-3333', 'dj@example.com', 'Oral Surgery');

SELECT * FROM dentist;

INSERT INTO patient VALUES 
(1, 'Alice', 'Miller', '111-222-3333', 'alice.m@example.com', '123 Main St, City A', '1985-05-15'),
(2, 'Bob', 'Davis', '444-555-6666', 'bob.d@example.com', '456 Elm St, City B', '1978-10-20'),
(3, 'Carol', 'Wilson', '777-888-9999', 'carol.w@example.com', '789 Oak St, City C', '1992-03-12'),
(4, 'Dan', 'Thompson', '222-333-4444', 'dan.t@example.com', '321 Pine St, City D', '2000-12-30'),
(5, 'Eve', 'Roberts', '666-777-8888', 'eve.r@example.com', '654 Maple St, City E', '1995-08-25');

SELECT * FROM patient;

INSERT INTO surgery VALUES 
(1, 'City A Dental', '123 Main St, City A', '111-222-3333'),
(2, 'Smile Center', '456 Elm St, City B', '444-555-6666'),
(3, 'Oak Street Clinic', '789 Oak St, City C', '777-888-9999'),
(4, 'Pine Dental', '321 Pine St, City D', '222-333-4444'),
(5, 'Maple Dental', '654 Maple St, City E', '666-777-8888');

SELECT * FROM surgery;

INSERT INTO appointment VALUES 
(1, '2024-04-10', '10:00:00', 'confirmed', 1, 1, 1),
(2, '2024-04-11', '11:00:00', 'pending', 2, 2, 2),
(3, '2024-04-12', '12:00:00', 'pending', 3, 3, 3),
(4, '2024-04-13', '13:00:00', 'confirmed', 4, 4, 4),
(5, '2024-04-14', '14:00:00', 'pending', 5, 5, 5);

SELECT * FROM appointment;

-- Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames:
SELECT * FROM Dentist ORDER BY last_name ASC;

-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information:
SELECT Appointment.*, Patient.first_name AS patient_first_name, Patient.last_name AS patient_last_name
FROM Appointment
JOIN Patient ON Appointment.patient_id = Patient.patient_id
WHERE Appointment.dentist_id = 3;

-- Display the list of ALL Appointments that have been scheduled at a Surgery Location:
SELECT Appointment.*, Surgery.name AS surgery_name
FROM Appointment
JOIN Surgery ON Appointment.surgery_id = Surgery.surgery_id;

-- Display the list of the Appointments booked for a given Patient on a given Date:
SELECT Appointment.*, Dentist.first_name AS dentist_first_name, Dentist.last_name AS dentist_last_name
FROM Appointment
JOIN Dentist ON Appointment.dentist_id = Dentist.dentist_id
WHERE Appointment.patient_id = 2 AND Appointment.appointment_date = '2014-04-11';
