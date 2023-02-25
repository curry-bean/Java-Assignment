CREATE DATABASE hospital;

USE hospital;

CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    gender VARCHAR(10),
    phone_number VARCHAR(20)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY,
    patient_id INT,
    doctor_name VARCHAR(50),
    appointment_datetime DATETIME,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(50),
    specialization VARCHAR(50),
    phone_number VARCHAR(20)
);
