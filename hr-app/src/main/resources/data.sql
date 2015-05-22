-- This file will be automatically run against the app's database on startup.
-- Spring Boot looks for a file named data.sql (and schema.sql) in the classpath
-- to run on startup.
-- See http://docs.spring.io/spring-boot/docs/1.2.2.RELEASE/reference/htmlsingle/#howto-intialize-a-database-using-spring-jdbc
-- for more information.
insert into employee(employee_id, name, hire_date, salary, is_full_time, vacation_days, comments) values (1, 'John Smith', {ts '2015-04-06 00:00:00.00'}, 0.0, true, 0, 'New Hire');
insert into employee(employee_id, name, hire_date, salary, is_full_time, vacation_days, comments) values (2, 'John Lee', {ts '2015-04-06 00:00:00.00'}, 0.0, false, 0, 'New Hire');
insert into employee(employee_id, name, hire_date, salary, is_full_time, vacation_days, comments) values (3, 'James Smith', {ts '2015-04-05 00:00:00.00'}, 0.0, true, 0, 'New Hire');
insert into employee(employee_id, name, hire_date, salary, is_full_time, vacation_days, comments) values (4, 'Doug Steve', {ts '2015-04-05 00:00:00.00'}, 0.0, false, 0, 'New Hire');
