//Callbacks

function saludar() {
    console.log("hola")
}

saludar();

function saludarA(nombre) {
    console.log("Hola, " + nombre);
}

saludarA("Jose Enrique");

function doble(n) {
    return n * 2;
}

const resultado = doble(5);

console.log(resultado + 1);

function sinReturn(n) {
    n * 2;
}



console.log(sinReturn(5)); //Sale undefined porque se hace la operacion pero no se muestra 

const resultadoSinReturn = sinReturn(5);

console.log(resultadoSinReturn); //sigue saliendo undefined porque no tiene return

const persona = { nombre: "Ana", edad: 30 } //Declaracion de clase

console.log(persona.nombre);

//Funciones flecha
function doble(n) { return n * 2; }

//Las funciones son como otro objeto en JS
//Se queda como una funcion anonima ya que esta dentro de una variable
const doble1 = function (n) { return n * 2; };

//Transformamos la funcion

const doble2 = (n) => { return n * 2 }

//podemos reducirla aun mas
//solo si tenemos un parametro podemos quitarle el parentesis a los parametros
const doble3 = n => { return n * 2 };


//POdemos reducirla aun mas de esta forma

//si no tiene llave no se le pone return porque esta implicito , solo con las funciones flecha
const doble4 = n => n * 2;


