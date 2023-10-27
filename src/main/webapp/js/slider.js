let currentIndex = 0;
const slides = document.querySelectorAll('.slide');
const sliderCtrls = document.querySelectorAll('.sliderCtrl');
const slideInterval = 3000;
const imageTexts = [
	"Мы всегда рады Вас видеть",
	"У нас работают только профессионалы",
	"Мы заботимся о Вашем комфорте",
	"Мы тщательно следим за состоянием самолётов"
];

function showNextSlide() {
	slides[currentIndex].style.opacity = 0;
	sliderCtrls[currentIndex].checked = false;
	currentIndex = (currentIndex + 1) % slides.length;
	slides[currentIndex].style.opacity = 1;
	sliderCtrls[currentIndex].checked = true;
	document.getElementById("slideText").innerHTML = imageTexts[currentIndex];
}
function jumpToSlide(index) {
	slides[currentIndex].style.opacity = 0;
	currentIndex = index % slides.length;
	slides[currentIndex].style.opacity = 1;
}
function selectSlide() {
	for (sliderIndex in sliderCtrls) {
		if(sliderCtrls[sliderIndex].checked) {
			jumpToSlide(sliderIndex);
		}
	}
}
setInterval(showNextSlide, slideInterval);

