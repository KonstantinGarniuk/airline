create table discount (
	id int auto_increment primary key,
    name varchar(64),
    discount int
);

create table role (
	id int auto_increment primary key,
    role varchar(64)
);

create table job (
	id int auto_increment primary key,
    job varchar(128)
);

create table employee_status (
	id int auto_increment primary key,
    status varchar(128)
);

create table location (
	id int auto_increment primary key,
    country varchar(128),
    town varchar(128)
);

create table person (
	id bigint auto_increment primary key,
    first_name varchar(256),
    last_name varchar(256),
    dob date
);

create table account (
	id bigint auto_increment primary key,
    person_id bigint,
    user_name varchar(256),
    password varchar(256),
    role_id int,
    discount_id int,
    foreign key (person_id) references person(id), 
    foreign key (role_id) references role(id),
    foreign key (discount_id) references discount(id)
);

create table employee (
	id int auto_increment primary key,
    person_id bigint,
    job_id int,
    location_id int,
    salary int,
    status_id int,
    foreign key (person_id) references person(id),
    foreign key (job_id) references job(id),
    foreign key (location_id) references location(id),
    foreign key (status_id) references employee_status(id)
);

create table airplane_type (
	id int auto_increment primary key,
    name varchar(255),
    first_class_seats int,
    economy_class_seats int,
    carrying_weight int,
    service_period int
);

create table seat_class(
	id int auto_increment primary key,
    class varchar(64)
);

create table airplane_status (
	id int auto_increment primary key,
    status varchar(64)
);

create table airplane(
	id int auto_increment primary key,
    type_id int,
    side_number varchar(16),
    status_id int,
    service_time date,
    location_id int,
    foreign key (type_id) references airplane_type(id),
    foreign key (status_id) references airplane_status(id),
    foreign key (location_id) references location(id)
);

create table seat (
	id int auto_increment primary key,
    airplane_id int,
    number int,
    class_id int,
    foreign key (airplane_id) references airplane(id),
    foreign key (class_id) references seat_class(id)
);

create table crew(
	id int auto_increment primary key,
    airplane_id int,
    job_id int,
    person_id bigint,
    foreign key (airplane_id) references airplane(id),
    foreign key (job_id) references job(id),
    foreign key (person_id) references person(id)
);

create table airport (
	id int auto_increment primary key,
    name varchar(256),
    location_id int,
    foreign key (location_id) references location(id)
);

create table gate (
	id int auto_increment primary key,
    name varchar(64),
    airport_id int,
    foreign key (airport_id) references airport(id)
);

create table route(
	id int auto_increment primary key,
    departure_airport_id int,
    arrival_airport_id int,
    distance int,
    foreign key (departure_airport_id) references airport(id),
    foreign key (arrival_airport_id) references airport(id)
);

create table flight_status (
	id int auto_increment primary key,
    status varchar(64)
);

create table flight(
	id bigint auto_increment primary key,
    route_id int,
    airplane_id int,
    departure_time timestamp,
    arrival_time timestamp,
    departure_gate_id int,
    arrival_gate_id int,
    status_id int,
	foreign key (route_id) references route(id),
    foreign key (airplane_id) references airplane(id),
    foreign key (departure_gate_id) references gate(id),
    foreign key (arrival_gate_id) references gate(id),
    foreign key (status_id) references flight_status(id)
);

create table ticket_status (
	id int auto_increment primary key,
    status varchar(64)
);

create table ticket (
	id int auto_increment primary key,
    person_id bigint,
    flight_id bigint,
    seat_id int,
    luggage int,
    price decimal,
    status_id int,
    foreign key (person_id) references person(id),
    foreign key (flight_id) references flight(id),
    foreign key (seat_id) references seat(id),
    foreign key (status_id) references ticket_status(id)
);

