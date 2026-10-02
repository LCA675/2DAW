

window.onload = function () {

	function validar() {
		const formulario = document.getElementById("formulario_1");

		formulario.addEventListener("submit", (e) => {
			// aqui definimos las variables que vamos a usar para validar el formulario
			let nombre = document.getElementById("nombre").value;
			let dni = document.getElementById("dni").value;
			let sexo = document.getElementById("sexo").value;
			let sugerencia = document.getElementById("sugerencia").value;
			let error = true;
			// validamos el nombre
			if (nombre.trim().length < 2 || nombre === "") {
				error = false;
				document.getElementById("info_nombre").textContent = "El nombre es incorrecto";

			}
			// validamos el dni

			const formatoValido = /^\d{8}[A-Z]$/;
			const valorLimpio = dni.trim().toUpperCase();
			let dniValido = true;

			if (!formatoValido.test(valorLimpio)) {
				dniValido = false;
			} else {
				const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
				const numero = parseInt(valorLimpio.substring(0, 8), 10);
				const letraCalculada = letras[numero % 23];
				if (letraCalculada !== valorLimpio.charAt(8)) {
					dniValido = false;
				}
			}

			if (dni.trim() == "" || dni.length < 9 || letraCalculada !== valorLimpio.charAt(8)) {
				error = false;
				document.getElementById("info_dni").textContent = "El DNI es incorrecto";
			}
			// validamos el sexo
			if (sexo == "") {
				error = false;
				document.getElementById("info_sexo").textContent = "Debes seleccionar un género";
				// validamos la sugerencia
				if (sugerencia == "") {
					error = false;
					document.getElementById("info_sugerencia").textContent = "Debes ingresar una sugerencia";
				}

				if (!error) {
					e.preventDefault();
				}


				return error;
			}})



	}
}

// funcion para limpiar el formulario


function limpiar() {
	document.getElementById("nombre").value = "";
	document.getElementById("dni").value = "";
	document.getElementById("sexo").value = "";
	document.getElementById("sugerencia").value = "";
}