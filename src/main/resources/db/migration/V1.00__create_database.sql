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

CREATE TABLE bill(
    appointmentid integer PRIMARY KEY,
    billid int,
    billamt int,
    paidamt int,
    duedate date,
	patientid int,
	billbalance int
);

Create Table appointment (
    appointmentid integer PRIMARY KEY,
    appointmentdatetime timestamp without time zone NOT NULL DEFAULT '2020-04-28 12:00:00'::timestamp without time zone,
    patientid integer,
    doctorid integer,
    locationid integer
);

CREATE TABLE doctor(
    doctorid int PRIMARY KEY,
    doctorfirstname varchar(255),
    doctorlastname varchar(255)
);


CREATE TABLE doctorcontact(
    doctorid int PRIMARY KEY,
    doctoremail varchar(255),
    doctorphone varchar(255)
);

CREATE TABLE doctorspecialization(
    doctorid int PRIMARY KEY,
    specialization varchar(255)
);