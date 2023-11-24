alter table airplane drop foreign key airplane_ibfk_2;
alter table airplane drop column status_id;
alter table airplane add column status varchar(64);
drop table airplane_status;

alter table employee drop foreign key employee_ibfk_4;
alter table employee drop column status_id;
alter table employee add column status varchar(64);
drop table employee_status;

alter table flight drop foreign key flight_ibfk_5;
alter table flight drop column status_id;
alter table flight add column status varchar(64);
drop table flight_status;

alter table seat drop foreign key seat_ibfk_2;
alter table seat drop column class_id;
alter table seat add column seat_class varchar(64);
drop table seat_class;

alter table ticket drop foreign key ticket_ibfk_4;
alter table ticket drop column status_id;
alter table ticket add column status varchar(64);
drop table ticket_status;