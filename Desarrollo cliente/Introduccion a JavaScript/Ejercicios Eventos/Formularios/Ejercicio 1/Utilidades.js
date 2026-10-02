window.onload = function () {
	// aqui se ejecuta el código cuando la página se ha cargado
	document.getElementById("nombre").focus();

	
	
	const formulario = document.getElementById("formulario_1");

	formulario.addEventListener("submit", (e) => {
		// definimos las variables que vamos a usar para validar el formulario
		let nombre = document.getElementById("nombre").value;
		let dni = document.getElementById("dni").value;
		let sexo = document.getElementById("sexo").value;
		let sugerencia = document.getElementById("sugerencia").value;
		let apellidos = document.getElementById("apellidos").value;
		let fdia = document.getElementById("f_dia").value;
		let fmes = document.getElementById("f_mes").value;
		let fano = document.getElementById("f_ano").value;
		let error = true;

		// validamos el nombre

		if (nombre.trim().length < 2 || nombre === "") {
			error = false;
			document.getElementById("info_nombre").textContent = "El nombre es incorrecto";

		}
		// validamos los apellidos
		if (apellidos.trim().length < 4 || apellidos === "") {
			error = false;
			document.getElementById("info_apellidos").textContent = "Los apellidos son incorrectos";
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
		}
		// validamos la sugerencia
		if (sugerencia == "") {
			error = false;
			document.getElementById("info_sugerencia").textContent = "Debes ingresar una sugerencia";
		}
		// validamos la fecha
		 if (fdia == "" || fmes == "" || fano == "") {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes%2==0 && fdia>31) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if(fano.length<4){
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes == 2 && fdia > 29 && ((fano % 4 === 0 && fano % 100 !== 0) || (fano % 400 === 0))) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
		}

		if (fmes%2!=0 && fdia>30) {
			error = false;
			document.getElementById("info_fecha").textContent = "Fecha incorrecta";
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
	document.getElementById("fdia").value = "";
	document.getElementById("fmes").value = "";
	document.getElementById("fano").value = "";
	document.getElementById("info_apellidos").value = "";
	}