function hidePages() {
	const pages = document.getElementsByClassName("page");
	for (let page of pages) {
		page.style.display = "none";
	}
}
function showMainPage() {
	document.location.href = "/";
}
function showSchedulePage() {
	document.location.href = "/schedule";
}
function showBookingPage() {
	document.location.href = "/booking";
}
function showCharterPage() {
	document.location.href = "/charter";
}
function showAccountPage() {
	document.location.href = "/account";
}