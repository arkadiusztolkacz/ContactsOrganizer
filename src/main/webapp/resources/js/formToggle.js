	var modal = document.getElementById("modalBox");
	var btn = document.getElementById("toggle");
	var span = document.getElementById("closeForm");
		
	btn.onclick = function() {
	    modal.style.display = "block";

	}

	span.onclick = function() {
	    modal.style.display = "none";
	}

	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
