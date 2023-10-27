insert into discount(name, discount) values ('none', 0);
insert into discount(name, discount) values ('bronze', 10);
insert into discount(name, discount) values ('silver', 20);
insert into discount(name, discount) values ('gold', 30);
insert into discount(name, discount) values ('platinum', 40);

insert into role(role) value ('costumer');
insert into role(role) value ('manager');
insert into role(role) value ('dispatcher');
insert into role(role) value ('hr');

insert into job(job) value ('pilot');
insert into job(job) value ('steward');
insert into job(job) value ('dispatcher');
insert into job(job) value ('hr');

insert into employee_status(status) value ('active');
insert into employee_status(status) value ('rest');
insert into employee_status(status) value ('ilness');
insert into employee_status(status) value ('vacation');

insert into seat_class(class) value ('first');
insert into seat_class(class) value ('economy');

insert into airplane_status(status) value ('ready');
insert into airplane_status(status) value ('flight');
insert into airplane_status(status) value ('service');
insert into airplane_status(status) value ('refueling');

insert into flight_status(status) value ('getting ready');
insert into flight_status(status) value ('boarding');
insert into flight_status(status) value ('in mid course');
insert into flight_status(status) value ('late');
insert into flight_status(status) value ('canceled');

insert into ticket_status(status) value ('booked');
insert into ticket_status(status) value ('paid');
insert into ticket_status(status) value ('used');
insert into ticket_status(status) value ('canceled');