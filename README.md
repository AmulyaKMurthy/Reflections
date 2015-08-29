# Reflections

This android application serves as an interface between students and teachers. Here, students can login and record their feedback for each subject.  This data is stored in a database which can be accessed later by the teacher. The application's home page consists of two buttons(student and teacher) which lead to the student and teacher login activities respectively. Students are expected to type in his/her correct Name, University Seat Number and Password to login. If the provided data matches the corresponding record in the database, the feedback activity for the first subject opens up. This activity contains three ratings i.e, good, average and bad for every parameter. When the student clicks on a button, the rating is automatically stored in the database. 
Feedback given by students can be viewed by teachers only. The feedback is the average ratings given by students. So, individual feedback given by students is not revealed to the teacher. 

   The Teacher is given special privileges of adding new students and removing existing students from the database. This helps us prevent malicious users and avoid fake ids from being created. Teachers cannot be added through the app for the same reason.

Dummy student records created are:
1. Name: student1
    Password:  pass1

2. Name: student2
    Password:  pass2

3. Name: student3
    Password:  pass3

Dummy teacher records created are:

1. Name: math teacher
    Password: mathpassword
           
2. Name: gt teacher
    Password: gtpassword
           
3. Name: unix teacher
    Password: unixpassword


To view the online database on Parse.com, the login details are
email address: amulyakm@gmail.com
password: whatever
