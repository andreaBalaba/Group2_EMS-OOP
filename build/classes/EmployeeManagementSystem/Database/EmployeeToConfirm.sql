use group2_ems;

create table employeeToConfirm (
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