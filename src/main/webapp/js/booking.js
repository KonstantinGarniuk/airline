function setRoute() {
    let params = new URLSearchParams();
    params.set('departureAirport', document.getElementById('departureAirportInput').value);
    params.set('destinationAirport', document.getElementById('destinationAirportInput').value);
    document.location.href = "/booking?" + params;
}
function updateReturnFlightsVisibility() {
    if (document.getElementById("thwoDirrections").checked) {
        document.getElementById("returnFligthChoose").style.display = "block";
    } else {
        document.getElementById("returnFligthChoose").style.display = "none";
    }
}
function cancelBooking() {
    document.location.href = "/booking";
}