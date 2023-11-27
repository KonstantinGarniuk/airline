function confirm(csrf) {
    let params = new FormData();
    params.set("ticketId", document.getElementById("ticketId").value);
    params.set("_csrf", csrf);
    fetch("/ticket/cancel", {
        credentials: 'include',
        method: 'POST',
        body: params});
}

function cancel() {
    document.location.href = "/account";
}