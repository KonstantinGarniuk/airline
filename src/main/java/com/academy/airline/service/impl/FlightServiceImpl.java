package com.academy.airline.service.impl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.academy.airline.mapper.FlightMapper;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Airplane;
import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.FlightStatus;
import com.academy.airline.model.entity.Location;

import org.springframework.stereotype.Service;

import com.academy.airline.dto.ArrivalGateDto;
import com.academy.airline.dto.DepartureGateDto;
import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.FlightStatusDto;
import com.academy.airline.dto.RouteRequestDto;
import com.academy.airline.dto.RouteResponseDto;
import com.academy.airline.model.repository.AirplaneRepository;
import com.academy.airline.model.repository.AirportRepository;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.service.AvailableSeatsServise;
import com.academy.airline.service.EmployeeService;
import com.academy.airline.service.FlightService;
import com.academy.airline.service.TicketPriceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
	private final FlightRepository flightRepository;
	private final AirplaneRepository airplaneRepository;
	private final EmployeeService employeeService;
	
    private final AirportRepository airportRepository;
    private final AvailableSeatsServise availableSeatsServise;
    private final TicketPriceService ticketPriceService;

	@Override
	public List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to) {

		List<Flight> flights = flightRepository.findByArrivalTimeAfterAndDepartureTimeBefore(from, to);
		List<FlightDto> flightDtos = new ArrayList<>();

		flights.forEach(flight -> flightDtos.add(FlightMapper.mapToFlightDto(flight)) );

		return flightDtos;
	}

	@Override
	public void updateDepartureGate(DepartureGateDto departure) {
		Flight flight = flightRepository.getReferenceById(departure.getFlightId());
        if (departure.getDepartureGate() != null) {
            Airport airport = flight.getRoute().getDepartureAirport();
            airport.getGates().forEach(gate -> {
                if (gate.getName().equals(departure.getDepartureGate())) {
                    flight.setDepartureGate(gate);
                    return;
                }
            });
			flightRepository.save(flight);
        }
	}

	@Override
	public void updateArrivalGate(ArrivalGateDto arrival) {
		Flight flight = flightRepository.getReferenceById(arrival.getFlightId());
		if (arrival.getArrivalGate() != null) {
            Airport airport = flight.getRoute().getDestinationAirport();
            airport.getGates().forEach(gate -> {
                if (gate.getName().equals(arrival.getArrivalGate())) {
                    flight.setArrivalGate(gate);
                    return;
                }
            });
			flightRepository.save(flight);
        }
	}

	@Override
	public void updateStatus(FlightStatusDto status) {
		Flight flight = flightRepository.getReferenceById(status.getFlightId());
		if (status.getFlightStatus() != null) {
			FlightStatus flightStatus = Stream.of(FlightStatus.values())
											.filter(s -> s.getStatus().equals(status.getFlightStatus()))
											.findFirst()
											.orElseThrow(IllegalArgumentException::new);
			flight.setStatus(flightStatus);
			if (flightStatus == FlightStatus.LANDED) {
				Location location = flight.getRoute().getDestinationAirport().getLocation();
				Airplane airplane = flight.getAirplane();
				if(airplane != null) {
					airplane.setLocation(location);
					airplaneRepository.save(airplane);
					employeeService.updateLocation(airplane.getCrew(), location);
				}
				
			}
			flightRepository.save(flight);
		}
	}

	 @Override
    public List<RouteResponseDto> getDirectFlights(RouteRequestDto request, Account account) {
        List<RouteResponseDto> result = new ArrayList<>();
        if(request != null) {
            Airport departureAirport = airportRepository.findByTown(request.getDepartureAirport());
            Airport destinationAirport = airportRepository.findByTown(request.getDestinationAirport());
            LocalDateTime startTime = LocalDate.now().atStartOfDay();
            if (request.getDepartureDate() != null) {
                startTime = request.getDepartureDate().atStartOfDay();
            }
            List<Flight> flights = flightRepository.selectFlights(departureAirport, destinationAirport, startTime, startTime.plusDays(1));
            flights.forEach(flight -> {
                RouteResponseDto responseDto = FlightMapper.mapToRouteResporseDto(flight);
                responseDto.setSeatsAvailable(availableSeatsServise.countAvailableSeats(flight));
                responseDto.setPrice(ticketPriceService.countTicketPrice(flight, account)); 
                result.add(responseDto);
            });
        }
        return result;
    }

    @Override
    public List<RouteResponseDto> getReturnFlights(RouteRequestDto request, Account account) {
        List<RouteResponseDto> result = new ArrayList<>();
        if(request != null) {
            Airport departureAirport = airportRepository.findByTown(request.getDestinationAirport());
            Airport destinationAirport = airportRepository.findByTown(request.getDepartureAirport());
            LocalDateTime startTime = LocalDate.now().atStartOfDay();
            if (request.getReturningDate() != null) {
                startTime = request.getReturningDate().atStartOfDay();
            }
            List<Flight> flights = flightRepository.selectFlights(departureAirport, destinationAirport, startTime, startTime.plusDays(1));
            flights.forEach(flight -> { 
                RouteResponseDto responseDto = FlightMapper.mapToRouteResporseDto(flight);
                responseDto.setSeatsAvailable(availableSeatsServise.countAvailableSeats(flight)); 
                responseDto.setPrice(ticketPriceService.countTicketPrice(flight, account)); 
                result.add(responseDto);
            });
        }
        return result;
    }

    @Override
    public RouteResponseDto getFlight(BigInteger id, Account account) {
        if (id == null) {
            return null;
        }
        Flight flight = flightRepository.getReferenceById(id);
        RouteResponseDto responseDto = FlightMapper.mapToRouteResporseDto(flight);
        responseDto.setSeatsAvailable(availableSeatsServise.countAvailableSeats(flight)); 
        responseDto.setPrice(ticketPriceService.countTicketPrice(flight, account)); 
        return responseDto;
    }
	
}
