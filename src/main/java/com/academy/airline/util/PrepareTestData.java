package com.academy.airline.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;

import com.academy.airline.model.entity.*;
import com.academy.airline.model.repository.*;

//@Component
public class PrepareTestData {

	private final PersonRepository personRepository;
	private final AccountRepository accountRepository;
	private final LocationRepository locationRepository;
	private final EmployeeRepository employeeRepository;
	private final AirplaneRepository airplaneRepository;
	private final AirportRepository airportRepository;
	private final RouteRepository routeRepository;
	private final FlightRepository flightRepository;
	private final TicketRepository ticketRepository;
	private final PasswordEncoder passwordEncoder;
	
	private List<Airport> airports;
	private List<Person> people;
	private List<Location> locations;
	private List<Account> accounts;
	private List<Route> routes;
	private List<Flight> flights;

	Random random;

	public PrepareTestData (
			PersonRepository personRepository,
			AccountRepository accountRepository,
			LocationRepository locationRepository,
			EmployeeRepository employeeRepository,
			AirplaneRepository airplaneRepository,
			AirportRepository airportRepository,
			RouteRepository routeRepository,
			FlightRepository flightRepository,
			TicketRepository ticketRepository,
			PasswordEncoder passwordEncoder
		) {
		this.personRepository = personRepository;
		this.accountRepository = accountRepository;
		this.locationRepository = locationRepository;
		this.employeeRepository = employeeRepository;
		this.airplaneRepository = airplaneRepository;
		this.airportRepository = airportRepository;
		this.routeRepository = routeRepository;
		this.flightRepository = flightRepository;
		this.ticketRepository = ticketRepository;
		this.passwordEncoder = passwordEncoder;
		
		random = new Random();

		prepareTestPeople();
		prepareTestAccounts();
		prepareLocations();
		prepareEmployees();
		prepareAirplanes();
		prepareAirports();
		prepareRoutes();
		prepareFlights();
		prepareTickets();
	}

	private void prepareTestPeople() {
		people = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Person person = Person.builder()
								.firstName("PersonTestName" + i)
								.lastName("PersonTestLastName" + i)
								.dob(LocalDate.of(1980 + random.nextInt(20), 1 + random.nextInt(11), 1 + random.nextInt(25)))
								.pid("testId" + random.nextInt(1000000))
								.build();
			people.add(person);
		}
		personRepository.saveAllAndFlush(people);
	}
	private void prepareTestAccounts() {
		accounts = new ArrayList<>();
		Account account = Account.builder()
								.person(people.get(0))
								.userName("TestManager")
								.password(passwordEncoder.encode("manager"))
								.role(Role.MANAGER)
								.discount(Discount.PLATINUM)
								.build();
		accounts.add(account);								
		account = Account.builder()
						.person(people.get(1))
						.userName("TestDispatcher")
						.password(passwordEncoder.encode("dispatcher"))
						.role(Role.DISPATCHER)
						.discount(Discount.PLATINUM)
						.build();
		accounts.add(account);
		account = Account.builder()
						.person(people.get(4))
						.userName("TestHr")
						.password(passwordEncoder.encode("hr"))
						.role(Role.HR)
						.discount(Discount.PLATINUM)
						.build();
		accounts.add(account);
		for (int i = 0; i < 100; i++) {
			 account = Account.builder()
							.person(people.get(i))
							.userName("TestAccount" + i)
							.password(passwordEncoder.encode("testPass" + i))
							.role(Role.CUSTOMER)
							.discount(Discount.NONE)
							.build();
			accounts.add(account);			
		}
		accountRepository.saveAllAndFlush(accounts);
	}
	private void prepareLocations() {
		locations = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				Location location = Location.builder()
										.country("TestCountry" + i)
										.town("TestTown" + i + j)
										.build();
				locations.add(location);
			}
		}
		locationRepository.saveAllAndFlush(locations);
	}
	private void prepareEmployees() {
		List<Employee> employees = new ArrayList<>();

		Employee employee = Employee.builder()
									.person(people.get(0))
									.job(Job.builder().id(3).build())
									.location(locations.get(random.nextInt(locations.size() - 1)))
									.salary(300 + random.nextInt(500))
									.status(EmployeeStatus.ACTIVE)
									.build();
		employees.add(employee);
		employee = Employee.builder()
						.person(people.get(1))
						.job(Job.builder().id(4).build())
						.location(locations.get(random.nextInt(locations.size() - 1)))
						.salary(300 + random.nextInt(500))
						.status(EmployeeStatus.ACTIVE)
						.build();
		employees.add(employee);
		employee = Employee.builder()
						.person(people.get(2))
						.job(Job.builder().id(5).build())
						.location(locations.get(random.nextInt(locations.size() - 1)))
						.salary(300 + random.nextInt(500))
						.status(EmployeeStatus.ACTIVE)
						.build();
		employees.add(employee);
		for (int i = 0; i < 10; i++) {
			employee = Employee.builder()
								.person(people.get(i + 10))
								.job(Job.builder().id(1).build())
								.location(locations.get(random.nextInt(locations.size() - 1)))
								.salary(700 + random.nextInt(700))
								.status(EmployeeStatus.ACTIVE)
								.build();
			employees.add(employee);
		}
		for (int i = 0; i < 20; i++) {
			employee = Employee.builder()
								.person(people.get(i + 30))
								.job(Job.builder().id(2).build())
								.location(locations.get(random.nextInt(locations.size() - 1)))
								.salary(300 + random.nextInt(500))
								.status(EmployeeStatus.ACTIVE)
								.build();
			employees.add(employee);
		}
		employeeRepository.saveAllAndFlush(employees);
	}
	private void prepareAirplanes() {
		List<Airplane> airplanes = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			List<Seat> seats = new ArrayList<>();
			Airplane airplane = Airplane.builder()
										.type(AirplaneType.builder().id(random.nextInt(3) + 1).build())
										.sideNumber("S" + i)
										.status(AirplaneStatus.READY)
										.serviceTime(LocalDate.now())
										.location(locations.get(random.nextInt(20)))
										.build();
			for (int j = 0; j < 50; j++) {
				Seat seat = Seat.builder()
								.seatClass(SeatClass.ECONOMY)
								.number(j)
								.build();
				seats.add(seat);
			}
			airplane.setSeats(seats);
			List<Crew> crewList = new ArrayList<>();
			Crew capitan = Crew.builder()
					.job(CrewJob.builder().id(1).build())
					.build();
			crewList.add(capitan);
			Crew pilot = Crew.builder()
					.job(CrewJob.builder().id(2).build())
					.build();
			crewList.add(pilot);
			Crew chiefSteward = Crew.builder()
					.job(CrewJob.builder().id(4).build())
					.build();
			crewList.add(chiefSteward);
			Crew steward = Crew.builder()
					.job(CrewJob.builder().id(3).build())
					.build();
			crewList.add(steward);
			steward = Crew.builder()
					.job(CrewJob.builder().id(3).build())
					.build();
			crewList.add(steward);
			steward = Crew.builder()
					.job(CrewJob.builder().id(3).build())
					.build();
			crewList.add(steward);
			airplane.setCrew(crewList);
			airplanes.add(airplane);
		}
		airplaneRepository.saveAllAndFlush(airplanes);
	}
	private void prepareAirports() {
		airports = new ArrayList<>();
		int i = 0;
		for (Location location: locations) {
			Set<Gate> gates = new HashSet<>();
			Airport airport = Airport.builder()
					.name("TestAirport" + i)
					.location(location)
					.build();
			i++;
			for (int j = 0; j < 10; j++) {
				Gate gate = Gate.builder().name("Gate" + j).build();
				gates.add(gate);
			}
			airport.setGates(gates);
			airports.add(airport);
		}
		airportRepository.saveAllAndFlush(airports);
	}
	private void prepareRoutes() {
		routes = new ArrayList<>();
		for (int i = 0; i < airports.size(); i++) {
			for(int j = 0; j < airports.size(); j++) {
				if (j != i) {
					Route route = Route.builder()
							.departureAirport(airports.get(i))
							.destinationAirport(airports.get(j))
							.distance(random.nextInt(5000))
							.build();
					routes.add(route);
				}
			}
		}
		routeRepository.saveAllAndFlush(routes);
	}
	private void prepareFlights() {
		flights = new ArrayList<>();
		LocalDateTime timeOfFlight = LocalDateTime.now();
		for (Route route: routes) {
			for (int i = 0; i < 3; i++) {
				Flight flight = Flight.builder()
						.route(route)
						.departureTime(timeOfFlight)
						.arrivalTime(timeOfFlight.plusHours(random.nextInt(20)))
						.status(FlightStatus.GETTING_READY)
						.build();
				flights.add(flight);
				timeOfFlight = timeOfFlight.plusMinutes(10 + random.nextInt(30));
			}
		}
		flightRepository.saveAllAndFlush(flights);
	}
	private void prepareTickets() {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Ticket ticket = Ticket.builder()
					.account(accounts.get(random.nextInt(accounts.size() - 1)))
					.flight(flights.get(random.nextInt(flights.size() - 1)))
					.luggage(25)
					.status(TicketStatus.BOOKED)
					.build();
			tickets.add(ticket);
		}
		ticketRepository.saveAllAndFlush(tickets);
	}
}
