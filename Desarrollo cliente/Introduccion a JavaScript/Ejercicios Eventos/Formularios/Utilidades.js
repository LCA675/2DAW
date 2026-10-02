function validar() {
	const formulario = document.getElementById("formulario_1");

	formulario.addEventListener("submit", (e) => {

		let nombre = document.getElementById("nombre").value;
		let dni = document.getElementById("dni").value;
		let sexo = document.getElementById("sexo").value;
		let sugerencia = document.getElementById("sugerencia").value;
		let error = true;

		if (nombre.trim().length < 2 || nombre === "") {
			error = false;
			document.getElementById("info_nombre").textContent = "El nombre es incorrecto";

		}
		if (dni.trim() == "" || dni.length < 9) {
			error = false;
			document.getElementById("info_dni").textContent = "El DNI es incorrecto";
		}
		if (sexo == "") {
			error = false;
			document.getElementById("info_sexo").textContent = "Debes seleccionar un género";
		}
		if (sugerencia == "") {
			error = false;
			document.getElementById("info_sugerencia").textContent = "Debes ingresar una sugerencia";
		}

		if (!error) {
			e.preventDefault();
		}


		return error;
	})

	let enviar = document.getElementById("enviar");
	enviar.addEventListener("click", validation);





}

window.onload = function () {
    document.getElementById("nombre").focus();
}




function limpiar() {
	document.getElementById("nombre").value = "";
	document.getElementById("dni").value = "";
	document.getElementById("sexo").value = "";
	document.getElementById("sugerencia").value = "";
}