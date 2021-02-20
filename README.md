# SE452-Chicago-Med
This project set up a server-side website to support doctors and clients to manage their profile and appointments. PostgreSQL is used to store data tables and MongoDB is used to store NOSQL data.\
Technology stacks: Maven, Lombok, JSP, JDBC, PostgreSQL, MongoDB

To compile and run the application:\
compile: mvn install -Dmaven.test.skip=true\
run: mvn spring-boot:run

Login to test the Application:\
Login as Admin: user = 100, password = ""\
Login as Patient: user = 12345, password = ""\
Login as Doctor: user = 1, password = ""
