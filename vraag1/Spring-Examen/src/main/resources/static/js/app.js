function validate() {

	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	// var punchline = document.getElementById('punchline').value;
	
	if (firstName === '') {
		alert('Please enter a valid first name.');
		return false;
	}

	if (lastName === '') {
		alert('Please enter a valid last name.');
		return false;
	}
	

}