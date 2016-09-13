function printTime() {
	var today = new Date();

	var hour = today.getHours();
	if (hour < 10)
		hour = "0" + hour;

	var minute = today.getMinutes();
	if (minute < 10)
		minute = "0" + minute;

	var second = today.getSeconds();
	if (second < 10)
		second = "0" + second;

	document.getElementById("clockPanel").innerHTML = hour + ":" + minute + ":"
			+ second;

}

function countdown() {
	setInterval("printTime()", 1000);
}
