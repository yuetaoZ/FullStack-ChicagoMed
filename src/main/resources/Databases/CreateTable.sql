Create Table appointment (
    appointmentId integer PRIMARY KEY,
    appointmentDate data,
    patientId integer,
    doctorId integer,
    locationId integer
);

CREATE TABLE patient (
    patientId integer  PRIMARY KEY ,
    patientFirstName varchar (255),
    patientLastName varchar (255)
);

CREATE TABLE patientDOB (
    patientId integer  PRIMARY KEY,
    dateOfBirth data
);

CREATE TABLE patientContact (
    patientId integer PRIMARY KEY,
    email varchar (255),
    phoneNumber varchar (255),
    address varchar (255),
    city varchar (255),
    state varchar (255),
    zipCode integer
);

CREATE TABLE location (
    locationId int PRIMARY KEY,
    address varchar (255),
    city varchar (255),
    state varchar (255),
    zipCode integer
);

CREATE TABLE locationDoc (
    locationId integer PRIMARY KEY,
    doctorId integer 
);