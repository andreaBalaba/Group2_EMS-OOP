use group2_ems;
CREATE TABLE logIndata (
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL
);

insert into logIndata values ('jaby@manager.com', 'manager'),
                            ('andrea@hr.com', 'hrdeng'),
                            ('kyla@employee.com', 'empkyla');
						
select * from logIndata;
                            
							





