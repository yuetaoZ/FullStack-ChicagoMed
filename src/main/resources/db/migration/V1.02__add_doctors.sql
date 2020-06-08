insert into doctor(doctorid, doctorfirstname, doctorlastname) values (1, 'Michael', 'Jordan');
insert into doctor(doctorid, doctorfirstname, doctorlastname) values (2, 'Jerry', 'Seinfeld');
insert into doctor(doctorid, doctorfirstname, doctorlastname) values (3, 'Luke', 'Skywalker');


insert into doctorcontact(doctorid, doctoremail, doctorphonenumber) values (1, 'michael.jordan@gmail.com', '111-222-1111');
insert into doctorcontact(doctorid, doctoremail, doctorphonenumber) values (2, 'jerry.seinfeld@gmail.com', '111-222-3333');
insert into doctorcontact(doctorid, doctoremail, doctorphonenumber) values (3, 'luke@gmail.com', '111-222-4444');

insert into doctorspecialization(doctorid, specialization) values (1, 'Able to handle many conditions');
insert into doctorspecialization(doctorid, specialization) values (2, 'Able to handle many conditions with jokes');
insert into doctorspecialization(doctorid, specialization) values (3, 'Able to use the force to help');



--insert into bill(appointmentid,billid,billamt,paidamt,duedate,patientid,billbalance) values (3,11,120,120,0,1,0);


