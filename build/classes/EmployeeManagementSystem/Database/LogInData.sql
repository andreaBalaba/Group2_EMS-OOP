use group2_ems;
CREATE TABLE logIndata (
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL
);

insert into logIndata values ('jaby@manager.com', 'manager'),
							('kyla@hr.com', 'hrkyla'),
                            ('andrea@hr.com', 'hrdeng'),
							('duke@hr.com', 'hrduke'),
							('drich@hr.com', 'hrdrich');
						
select * from logIndata;
                            
							





