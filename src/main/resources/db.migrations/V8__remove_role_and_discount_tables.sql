alter table account drop foreign key account_ibfk_2;
alter table account drop foreign key account_ibfk_3;
alter table account drop column role_id;
alter table account drop column discount_id;
alter table account add column role varchar(64);
alter table account add column discount varchar(64);
drop table role;
drop table discount;