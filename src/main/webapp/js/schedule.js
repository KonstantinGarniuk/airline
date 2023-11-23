

function setDepartureGate(flightId, csrf) {
    var params = new FormData();
    params.set('flightId', flightId);
    params.set('departureGate', event.target.value);
    params.set('arrivalGate', null);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});
}

function setArrivalGate(flightId, csrf) {
    var params = new URLSearchParams();
    params.set('flightId', flightId);
    params.set('departureGate', null);
    params.set('arrivalGate', event.target.value);
    params.set('_csrf', csrf);
    fetch("/schedule", {
        credentials: 'include',
        method: 'POST',
        body: params});

}