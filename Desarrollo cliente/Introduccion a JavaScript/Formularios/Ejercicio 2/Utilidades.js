window.onload = function () {
	// Aqui podemos el foco en el primer campo del formulario
	document.getElementById("nombre").focus();
	// aqui podemos añadir el evento submit al formulario
	const formulario = document.getElementById("formulario_1");

	formulario.addEventListener("submit", (e) => {

		// definimos las variables que vamos a utilizar para validar el formulario
		let nombre = document.getElementById("nombre").value;
		let dni = document.getElementById("dni").value;
		let sexo = document.querySelector('input[name="sexo"\]:checked');
		let sugerencia = document.getElementById("sugerencia").value;
		let apellidos = document.getElementById("apellidos").value;
		let fdia = document.getElementById("f_dia").value;
		let fmes = document.getElementById("f_mes").value;
		let fano = document.getElementById("f_ano").value;
		let estatura = document.getElementById("estatura").value;
		let estado_civil = document.getElementById("estado_civil").value;
		let bebidas = document.getElementById("bebidas").value;
		let ccc = document.getElementById("ccc").value;
		let error = true;

		// valicacion de nombre

		if (nombre.trim().length < 2 || nombre === "") {
			error = false;
			document.getElementById("info_nombre").textContent = "El nombre es incorrecto";
			// validacion de apellidos
		}
		if (apellidos.trim().length < 4 || apellidos === "") {
			error = false;
			document.getElementById("info_apellidos").textContent = "Los apellidos son incorrectos";
		}

		// validacion de dni

		const formatoValido = /^\d{8}[A-Z]$/;
		const valorLimpio = dni.trim().toUpperCase();
		let dniValido = true;
		let letraCalculada = "";

		if (!formatoValido.test(valorLimpio)) {
			dniValido = false;
		} else {
			const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			const numero = parseInt(valorLimpio.substring(0, 8), 10);
			letraCalculada = letras[numero % 23];
			if (letraCalculada !== valorLimpio.charAt(8)) {
				dniValido = false;
			}
		}

		if (dni.trim() == "" || dni.length < 9 || !dniValido) {
			error = false;
			document.getElementById("info_dni").textContent = "El DNI es incorrecto";
		}

		// validacion de sexo
		if (sexo == null) {
			error = false;
			document.getElementById("info_sexo").textContent = "Debes seleccionar un género";
		}
		// validacion de sugerencia
		if (sugerencia == "") {
			error = false;
			document.getElementById("info_sugerencia").textContent = "Debes ingresar una sugerencia";
		}
		// validacion de fecha
		if (fdia == "" || fmes == "" || fano == "") {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes % 2 == 0 && fdia > 31) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fano.length < 4) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes == 2 && fdia > 29 && ((fano % 4 === 0 && fano % 100 !== 0) || (fano % 400 === 0))) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes % 2 != 0 && fdia > 30) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		// validacion de estatura


		if (estatura == "" || estatura < 0.5 || estatura > 2.5) {
			error = false;
			document.getElementById("info_estatura").textContent = "Estatura incorrecta";
		}

		// validacion de estado civil

		if (estado_civil == "") {
			error = false;
			document.getElementById("info_estado_civil").textContent = "Debes seleccionar un estado civil";
		}


		// validacion de bebidas
		let contador = document.querySelectorAll("input[name='bebidas']:checked").length;


		if (contador < 3) {
			error = false;
			document.getElementById("info_bebidas").textContent = "Error llevas " + contador + " bebidas ";
		}

		// validacion de ccc 

		let contieneLetras = /[a-zA-Z]/;

		if (ccc == "" || ccc.trim().length < 20 || ccc.test(contieneLetras)) {
			error = false;
			document.getElementById("info_ccc").textContent = "El CCC es incorrecto";
		}

		if (!error) {
			e.preventDefault();
		}


		return error;
	})

}

// funcion para limpiar el formulario

function limpiar() {
	document.getElementById("nombre").value = "";
	document.getElementById("dni").value = "";
	document.getElementById("sexo").value = "";
	document.getElementById("sugerencia").value = "";
	document.getElementById("f_dia").value = "";
	document.getElementById("f_mes").value = "";
	document.getElementById("f_ano").value = "";
	document.getElementById("info_apellidos").value = "";
	document.getElementById("estatura").value = "";
	document.getElementById("estado_civil").value = "";
}