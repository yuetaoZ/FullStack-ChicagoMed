Create Table appointment (
    appointmentid integer PRIMARY KEY,
    appointmentdate data,
    patientid integer,
    doctorid integer,
    locationid integer
);

CREATE TABLE patient (
    patientid integer  PRIMARY KEY ,
    patientfirstname varchar (255),
    patientlastname varchar (255)
);

CREATE TABLE patientDOB (
    patientid integer  PRIMARY KEY,
    dateofbirth date 
);

CREATE TABLE patientContact (
    patientid integer PRIMARY KEY,
    email varchar (255),
    phonenumber varchar (255),
    address varchar (255),
    city varchar (255),
    state varchar (255),
    zipcode integer
);

CREATE TABLE location (
    locationid int PRIMARY KEY,
    address varchar (255),
    city varchar (255),
    state varchar (255),
    zipcode integer
);

CREATE TABLE locationDoc (
    locationid integer PRIMARY KEY,
    doctorid integer
);