
CREATE TABLE patient (
    patientid SERIAL,
    patientfirstname varchar (255),
    patientlastname varchar (255),
    patientDOB varchar (255),
    patientGender varchar (255)
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
    locationid SERIAL,
    locationname varchar (255),
    address varchar (255),
    city varchar (255),
    state varchar (255),
    zipcode integer
);

CREATE TABLE locationDoc (
    doclocationid integer PRIMARY KEY,
    locationid integer,
    doctorid integer
);

CREATE TABLE bill(
    appointmentid integer,
    billid SERIAL,
    billamt int,
    paidamt int,
    duedate date,
	patientid int,
	billbalance int
);

Create Table appointment (
    appointmentid SERIAL,
    appointmentdatetime varchar,
    patientid integer,
    doctorid integer,
    locationid integer
);

CREATE TABLE doctor(
    doctorid SERIAL,
    doctorfirstname varchar(255),
    doctorlastname varchar(255)
);


CREATE TABLE doctorcontact(
    doctorid int PRIMARY KEY,
    doctoremail varchar(255),
    doctorphonenumber varchar(255)
);

CREATE TABLE doctorspecialization(
    doctorid int PRIMARY KEY,
    specialization varchar(255)
);