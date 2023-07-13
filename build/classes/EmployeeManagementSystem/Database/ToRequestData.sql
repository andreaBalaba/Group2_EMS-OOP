USE group2_ems;

CREATE TABLE time_off_request (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(50),
    department VARCHAR(50),
    manager VARCHAR(50),
    employee_id VARCHAR(10),
    total_hours INT,
    date_of_absence_from DATE,
    date_of_absence_to DATE,
    vacation BOOLEAN,
    medical_leave BOOLEAN,
    jury_duty BOOLEAN,
    personal_leave BOOLEAN,
    family_reasons BOOLEAN,
    to_vote BOOLEAN,
    bereavement BOOLEAN,
    time_off_without_pay BOOLEAN,
    reason_for_request TEXT,
    employee_signature VARCHAR(50),
    request_date DATE,
    status VARCHAR(20)
);

INSERT INTO time_off_request ( employee_name, department, manager, employee_id, total_hours, date_of_absence_from, date_of_absence_to, vacation, medical_leave, 
              jury_duty, personal_leave, family_reasons, to_vote, bereavement, time_off_without_pay, reason_for_request, employee_signature, request_date, status)
 VALUES ('Juan Dela Cruz', 'Development', 'Mr.Almadin', '0006', 24, '2023-07-15', '2023-07-17', TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, FALSE, FALSE,
    'Vacation trip with family', 'Juan Dela Cruz', '2023-07-12', 'Pending');

SELECT * FROM time_off_request;


