function filterNames() {
	var input = document.getElementById("nameInput");
	filterTable(0, input);
}

function filterCompanies() {
	var input = document.getElementById("companyInput");
	filterTable(1, input);
}

function filterTable(cell, input) {
	var filter = input.value.toUpperCase();
	var table = document.getElementById("contacts");
	var tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[cell];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}