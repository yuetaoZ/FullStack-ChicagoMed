insert into patient(patientid, patientfirstname,patientlastname) values (12345, 'Dwight', 'Schrute');
insert into patient(patientid, patientfirstname,patientlastname) values (12346, 'Jim', 'Halpert');
insert into patient(patientid, patientfirstname,patientlastname) values (12347, 'Pam', 'Beasley');
insert into patient(patientid, patientfirstname,patientlastname) values (12348, 'Michael','Scott');

insert into patientcontact(patientid, email, phonenumber, address, city, state, zipcode) values (12345, 'dwightschrute@gmail.com', '773-123-4567', '100 N La Salle St', 'Chicago', 'Illinois', 60601);
insert into patientcontact(patientid, email, phonenumber, address, city, state, zipcode) values (12346, 'jimhalpert@gmail.com', '773-424-5948', '2700 N Hampden Ct', 'Chicago', 'Illinois', 60614);
insert into patientcontact(patientid, email, phonenumber, address, city, state, zipcode) values (12347, 'PB@gmail.com', '773-174-3918', '1516 S Wabash Ave', 'Chicago', 'Illinois', 60613);
insert into patientcontact(patientid, email, phonenumber, address, city, state, zipcode) values (12348, 'worldsbestboss@gmail.com', '773-987-6543', '655 W Irving Park Rd', 'Chicago', 'Illinois', 60613);

insert into patientdob (patientid, dateofbirth) values (12345, '1975-02-13');
insert into patientdob (patientid, dateofbirth) values (12346, '1983-12-12');
insert into patientdob (patientid, dateofbirth) values (12347, '1986-04-19');
insert into patientdob (patientid, dateofbirth) values (12348, '1972-10-15');

insert into location (locationid, locationname, address, city, state, zipcode) values (56788, 'Northwestern Hospital', '251 E Huron St', 'Chicago', 'Illinois', 60611);
insert into location (locationid, locationname, address, city, state, zipcode) values (56789, 'Chicago Primary Care', '200 N Michigan Ave', 'Chicago', 'Illinois', 60601);