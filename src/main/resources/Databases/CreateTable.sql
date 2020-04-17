CREATE TABLE public.appointment(
    appointmentid int PRIMARY KEY,
    appointmentdate date,
    patientid int,
    doctorid int,
    locationid int
    );

CREATE TABLE public.bill(
    appointmentid integer PRIMARY KEY,
    billid int,
    billamt int,
    paidamt int,
    duedate date,
	patientid int,
	billbalance int
);

CREATE TABLE public.doctor(
    doctorid int PRIMARY KEY,
    doctorfirstname varchar(255),
    doctorlastname varchar(255)
);


CREATE TABLE public.doctorcontact(
    doctorid int PRIMARY KEY,
    doctoremail varchar(255),
    doctorphone varchar(255)
);

CREATE TABLE public.doctorspecialization(
    doctorid int PRIMARY KEY,
    specialization varchar(255)
);