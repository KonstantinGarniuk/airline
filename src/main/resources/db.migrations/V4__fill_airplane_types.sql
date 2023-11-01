alter table airplane_type add column consumption int;
insert into airplane_type (name, first_class_seats, economy_class_seats, carrying_weight, service_period, consumption) 
	values ('SSJ 100', 0, 95, 12250, 10, 100);
insert into airplane_type (name, first_class_seats, economy_class_seats, carrying_weight, service_period, consumption) 
	values ('Boeing-747', 25, 120, 16000, 10, 150);
insert into airplane_type (name, first_class_seats, economy_class_seats, carrying_weight, service_period, consumption) 
	values ('Airbus A320', 16, 100, 14000, 10, 120);
insert into airplane_type (name, first_class_seats, economy_class_seats, carrying_weight, service_period, consumption) 
	values ('IL-86', 30, 200, 20000, 10, 200);