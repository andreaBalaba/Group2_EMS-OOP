use group2_ems;

create table employeeData (
name varchar(200) not null,
age int, 
dateOfHired date,
email varchar(200) not null,
address varchar(500) not null,
phone varchar(100) not null,
employeeId varchar(50) not null,
education varchar(500) not null,
position varchar(100) not null,
salary int,
department varchar(100) not null
);

INSERT INTO employeeData (name, age, dateOfHired, email, address, phone, employeeId, education, position, salary, department)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);

INSERT INTO employeeData (name, age, dateOfHired, email, address, phone, employeeId, education, position, salary, department)
                VALUES ('Jaby Almadin', 20, '2023-06-11', 'jabya@yahoo.com', 'Laguna' , '', '0001', 'College Graduate', 'Manager', 40000, ''),
		       ('Kyla Aquino', 20, '2023-06-11', 'kylaa@yahoo.com', 'Laguna' , '', '0002', 'College Graduate', 'HR Staff', 30000, ''),
                       ('Dhuke Marquez', 20, '2023-06-11', 'dhukem@yahoo.com', 'Laguna', '', '0003', 'College Graduate', 'HR Staff', 30000, ''),
                       ('Aldrich Calabio', 20, '2023-06-11', 'aldrichc@yahoo.com', 'Laguna' , '', '0004', 'College Graduate', 'HR Staff', 30000, ''),
                       ('Andrea Balaba', 20, '2023-06-11', 'andreab@yahoo.com', 'Binan, Laguna' , '09056438680', '0005', 'College Graduate', 'HR Staff', 30000, ''),
                       ('Juan Dela Cruz', 23, '2023-06-14', 'juandc@yahoo.com', 'Binan, Laguna' , '09021002100', '0006', 'High School Graduate', 'Troubleshooter', 10000, '');


select * from employeeData;


