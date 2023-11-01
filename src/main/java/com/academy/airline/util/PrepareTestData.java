package com.academy.airline.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.academy.airline.model.entity.*;
import com.academy.airline.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class PrepareTestData {

	private PersonRepository personRepository;
	private AccountRepository accountRepository;
	private LocationRepository locationRepository;
	private EmployeeRepository employeeRepository;
	private AirplaneRepository airplaneRepository;
	private AirportRepository airportRepository;
	private RouteRepository routeRepository;
	private FlightRepository flightRepository;
	private TicketRepository ticketRepository;
	private List<Airport> airports;

	private List<Person> people;
	private List<Location> locations;
	private List<Account> accounts;
	private List<Employee> employees;
	private List<Airplane> airplanes;
	private List<Route> routes;
	private List<Flight> flights;
	private List<Ticket> tickets;

	@Autowired
	public void PrepareTestData(
			PersonRepository personRepository,
			AccountRepository accountRepository,
			LocationRepository locationRepository,
			EmployeeRepository employeeRepository,
			AirplaneRepository airplaneRepository,
			AirportRepository airportRepository,
			RouteRepository routeRepository,
			FlightRepository flightRepository,
			TicketRepository ticketRepository
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
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Person person = Person.builder()
								.firstName("PersonTestName" + i)
								.lastName("PersonTestLastName" + i)
								.dob(LocalDate.of(1980 + random.nextInt(20), 1 + random.nextInt(11), 1 + random.nextInt(25)))
								.build();
			people.add(person);
		}
		personRepository.saveAllAndFlush(people);
	}
	private void prepareTestAccounts() {
		accounts = new ArrayList<>();
		Random random = new Random();
		Account account = Account.builder()
								.person(people.get(0))
								.userName("TestManager")
								.password("manager")
								.role(Role.builder().id(2).build())
								.discount(Discount.builder().id(1 + random.nextInt(4)).build())
								.build();
		accounts.add(account);								
		account = Account.builder()
						.person(people.get(1))
						.userName("TestDispatcher")
						.password("dispatcher")
						.role(Role.builder().id(3).build())
						.discount(Discount.builder().id(1 + random.nextInt(4)).build())
						.build();
		accounts.add(account);
		account = Account.builder()
						.person(people.get(4))
						.userName("TestHr")
						.password("hr")
						.role(Role.builder().id(2).build())
						.discount(Discount.builder().id(1 + random.nextInt(4)).build())
						.build();
		accounts.add(account);
		for (int i = 0; i < 100; i++) {
			 account = Account.builder()
							.person(people.get(i))
							.userName("TestAccount" + i)
							.password("testPass" + i)
							.role(Role.builder().id(1).build())
							.discount(Discount.builder().id(1 + random.nextInt(4)).build())
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
										.town("TestTown" + i)
										.build();
				locations.add(location);
			}
		}
		locationRepository.saveAllAndFlush(locations);
	}
	private void prepareEmployees() {
		Random random = new Random();
		employees = new ArrayList<>();

		Employee employee = Employee.builder()
									.person(people.get(0))
									.job(Job.builder().id(3).build())
									.location(locations.get(random.nextInt(locations.size() - 1)))
									.salary(300 + random.nextInt(500))
									.status(EmployeeStatus.builder().id(1).build())
									.build();
		employees.add(employee);
		employee = Employee.builder()
						.person(people.get(1))
						.job(Job.builder().id(4).build())
						.location(locations.get(random.nextInt(locations.size() - 1)))
						.salary(300 + random.nextInt(500))
						.status(EmployeeStatus.builder().id(1).build())
						.build();
		employees.add(employee);
		employee = Employee.builder()
						.person(people.get(2))
						.job(Job.builder().id(5).build())
						.location(locations.get(random.nextInt(locations.size() - 1)))
						.salary(300 + random.nextInt(500))
						.status(EmployeeStatus.builder().id(1).build())
						.build();
		employees.add(employee);
		for (int i = 0; i < 10; i++) {
			employee = Employee.builder()
								.person(people.get(i + 10))
								.job(Job.builder().id(1).build())
								.location(locations.get(random.nextInt(locations.size() - 1)))
								.salary(700 + random.nextInt(700))
								.status(EmployeeStatus.builder().id(1).build())
								.build();
			employees.add(employee);
		}
		for (int i = 0; i < 20; i++) {
			employee = Employee.builder()
								.person(people.get(i + 30))
								.job(Job.builder().id(2).build())
								.location(locations.get(random.nextInt(locations.size() - 1)))
								.salary(300 + random.nextInt(500))
								.status(EmployeeStatus.builder().id(1).build())
								.build();
			employees.add(employee);
		}
		employeeRepository.saveAllAndFlush(employees);
	}
	private void prepareAirplanes() {
		airplanes = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			List<Seat> seats = new ArrayList<>();
			Airplane airplane = Airplane.builder()
										.type(AirplaneType.builder().id(random.nextInt(3) + 1).build())
										.sideNumber("S" + i)
										.status(AirplaneStatus.builder().id(1).build())
										.serviceTime(LocalDate.now())
										.location(locations.get(random.nextInt(20)))
										.build();
			for (int j = 0; j < 50; j++) {
				Seat seat = Seat.builder()
								.seatClass(SeatClass.builder().id(2).build())
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
			List<Gate> gates = new ArrayList<>();
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
			Route route = Route.builder()
					.departureAirport(airports.get(i))
					.arrivalAirport(airports.get(airports.size() - i - 1))
					.build();
			routes.add(route);
		}
		routeRepository.saveAllAndFlush(routes);
	}
	private void prepareFlights() {
		flights = new ArrayList<>();
		LocalDateTime timeOfFlight = LocalDateTime.now();
		Random random = new Random();
		for (Route route: routes) {
			for (int i = 0; i < 10; i++) {
				Flight flight = Flight.builder()
						.route(route)
						.departureTime(timeOfFlight)
						.arrivalTime(timeOfFlight.plusHours(random.nextInt(20)))
						.status(FlightStatus.builder().id(1).build())
						.build();
				flights.add(flight);
				timeOfFlight = timeOfFlight.plusMinutes(10 + random.nextInt(30));
			}
		}
		flightRepository.saveAllAndFlush(flights);
	}
	private void prepareTickets() {
		tickets = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Ticket ticket = Ticket.builder()
					.account(accounts.get(random.nextInt(accounts.size() - 1)))
					.flight(flights.get(random.nextInt(flights.size() - 1)))
					.luggage(25)
					.status(TicketStatus.builder().id(1).build())
					.build();
			tickets.add(ticket);
		}
		ticketRepository.saveAllAndFlush(tickets);
	}
}
