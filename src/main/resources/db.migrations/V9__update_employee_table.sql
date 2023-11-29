alter table employee drop foreign key employee_ibfk_1;
alter table employee drop column person_id;
alter table employee add column account_id bigint;
alter table employee add foreign key (account_id) references account(id);

alter table employee drop foreign key employee_ibfk_2;
alter table employee drop column job_id;
alter table employee add column job varchar(64);