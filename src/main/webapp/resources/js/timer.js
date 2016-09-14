function printTime() {
	var today = new Date();
	document.getElementById("clockPanel").innerHTML = today.toLocaleTimeString();
}

window.onload = function() {
	setInterval("printTime()", 1000);
}
