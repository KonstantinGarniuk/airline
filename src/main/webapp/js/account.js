function login() {
	document.location.href = "/login";
}
function registarate() {
	document.location.href = "/registration";
}
function logout() {
	document.location.href = "/logout";
}
function updatePersonInfo() {
    let personInfoDisplayElements = document.getElementsByClassName("personInfoDisplay");
    Array.prototype.forEach.call(personInfoDisplayElements, function(element) {
        element.style.display="none";
    });
    let personInfoUpdateElements = document.getElementsByClassName("personInfoUpdate");
    Array.prototype.forEach.call(personInfoUpdateElements, function(element) {
        element.style.display="block";
    });
}
function canselTicket(id) {
    let params = new URLSearchParams();
    params.set("ticket", id);
    document.location.href = "/ticket/cancel?" + params;
}