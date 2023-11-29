function filterEmployees(sender) {
    window.name = sender;
    let param = new URLSearchParams();
    param.set("userName", document.getElementById("userName").value);
    param.set("firstName", document.getElementById("firstName").value);
    param.set("lastName", document.getElementById("lastName").value);
    document.location.href = "/employee?" + param;
}
function focusInput() {
    let element = document.getElementById(window.name);
    element.focus();
    let val = element.value;
    element.value = '';
    element.value = val;
}
function cancelDismiss() {
    document.location.href = "/employee";
}
function dismiss(id) {
    let param = new URLSearchParams();
    param.set("id", id);
    document.location.href = "/employee/dismiss?" + param;
}
function hire() {
    document.location.href = "/employee/hire";
}