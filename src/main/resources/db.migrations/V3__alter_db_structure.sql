create table crew_job (
	id int auto_increment primary key,
    job varchar(128)
);
alter table crew drop foreign key crew_ibfk_2;
alter table crew drop column job_id;
alter table crew add column crew_job_id int;
alter table crew add foreign key (crew_job_id) references crew_job(id);
alter table crew drop foreign key crew_ibfk_3;
alter table crew drop column person_id;
alter table crew add column employee_id int;
alter table crew add foreign key (employee_id) references employee(id);

alter table ticket drop foreign key ticket_ibfk_1;
alter table ticket drop column person_id;
alter table ticket add column account_id bigint;
alter table ticket add foreign key (account_id) references account(id);

insert into crew_job (job) value ('capitan');
insert into crew_job (job) value ('pilot');
insert into crew_job (job) value ('steward');
insert into crew_job (job) value ('chief steward');
