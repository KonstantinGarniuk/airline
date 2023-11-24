

function setDepartureGate(flightId, csrf) {
    var params = new FormData();
    params.set('flightId', flightId);
    params.set('departureGate', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});
}

function setArrivalGate(flightId, csrf) {
    var params = new URLSearchParams();
    params.set('flightId', flightId);
    params.set('arrivalGate', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});

}

function setFlightStatus(flightId, csrf) {
    var params = new URLSearchParams();
    params.set('flightId', flightId);
    params.set('flightStatus', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});

}