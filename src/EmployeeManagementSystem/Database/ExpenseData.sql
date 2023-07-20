use group2_ems;

create table expense_request (
request_id INT AUTO_INCREMENT PRIMARY KEY,
name varchar(200) not null,
employeeId varchar(50) not null,
reqDate date, 
projName varchar(500) not null, 
reqEndDate date,
dept varchar(50) not null,
amount varchar(100) not null, 
notes varchar(100) not null,
initiate boolean,
planning boolean,  
execution boolean,  
perform boolean, 
closure boolean,
summary text,
status VARCHAR(20)
);
/*
INSERT INTO expense_request (name, employeeId, reqDate, projName, reqEndDate, amount, notes, inititate, planning, execution, perform, closure )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);*/



