use group2_ems;

CREATE TABLE performance_review (
    name VARCHAR(255) not null,
    position VARCHAR(255) not null,
    manager VARCHAR(255) not null,
    date DATE,
    department VARCHAR(255) not null,
    employee_id VARCHAR(255) not null,
    work_to_full_potential BOOLEAN,
    work_consistency BOOLEAN,
    quality_of_work BOOLEAN,
    good_communication BOOLEAN,
    takes_initiative BOOLEAN,
    creativity BOOLEAN,
    reliability BOOLEAN,
    productivity BOOLEAN,
    technical_skills BOOLEAN,
    efficiency BOOLEAN,
    teamwork BOOLEAN,
    leadership BOOLEAN,
    independent_work BOOLEAN,
    punctuality BOOLEAN,
    area_of_improvement TEXT,
    comment TEXT,
    overall_review VARCHAR(255) not null
);

INSERT INTO performance_review (name, position, manager, date, department, employee_id,
    work_to_full_potential, work_consistency, quality_of_work, good_communication,
    takes_initiative, creativity, reliability, productivity, technical_skills, efficiency,
    teamwork, leadership, independent_work, punctuality, area_of_improvement, comment, overall_review)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);


select * from performance_review;
