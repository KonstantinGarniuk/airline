

function setDepartureGate(flightId, csrf) {
    let params = new FormData();
    params.set('flightId', flightId);
    params.set('departureGate', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});
}

function setArrivalGate(flightId, csrf) {
    let params = new URLSearchParams();
    params.set('flightId', flightId);
    params.set('arrivalGate', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});

}

function setFlightStatus(flightId, csrf) {
    let params = new URLSearchParams();
    params.set('flightId', flightId);
    params.set('flightStatus', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});

}