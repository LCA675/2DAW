// =====================================================================
// SESIÓN 3 · COMBINAR PROMESAS · Ejercicios 3.1, 3.2 y 3.4
// Escribe tu código debajo de cada enunciado.
// Para ejecutarlo: node ejercicios.js
// (El ejercicio 3.3, la tienda, está en la carpeta tienda/)
//
// OJO: cuando acabes un ejercicio, coméntalo (Ctrl + /) antes de pasar
// al siguiente, para que los mensajes no se mezclen.
// =====================================================================


// ---------- Código que ya tienes hecho (no hace falta tocarlo) ----------
// esperar(ms): promesa que se cumple pasados ms milisegundos
const esperar = ms => new Promise(resolve => setTimeout(resolve, ms));

// tarea(nombre, ms, falla): promesa que tarda ms milisegundos.
// Si falla es true, se rechaza; si no, se cumple con el nombre.
const tarea = (nombre, ms, falla = false) => new Promise((resolve, reject) => {
  setTimeout(() => {
    if (falla) reject(new Error(nombre + ' ha fallado'));
    else resolve(nombre);
  }, ms);
});
// ------------------------------------------------------------------------


// ---------------------------------------------------------------------
// EJERCICIO 3.1 · ¿En serie o en paralelo?
// Lanza tres tareas de 1000 ms:
//   a) primero encadenadas con then (una detrás de otra)
//   b) después todas a la vez con Promise.all
// Mide el tiempo de cada versión con console.time('nombre') al empezar
// y console.timeEnd('nombre') al terminar.
// ¿Cuánto tarda cada una y por qué?
// ---------------------------------------------------------------------

// Tu código aquí:
console.time('serie');
tarea('A', 1000)
  .then(resultado => {
    console.log(resultado);
    return tarea('B', 1000);
  })
  .then(resultado => {
    console.log(resultado);
    return tarea('C', 1000);
  })
  .then(resultado => {
    console.log(resultado);
    console.timeEnd('serie');
    console.time('paralelo');
    return Promise.all([
      tarea('A', 1000),
      tarea('B', 1000),
      tarea('C', 1000)
    ]);
  })
  .then(resultados => {
    console.log(resultados);
    console.timeEnd('paralelo');
  })
  .catch(err => console.error(err.message));


// Cuánto tarda cada una y por qué:

//en serie: unos 3000 ms, porque cada tarea espera a la anterior y los tiempos se suman.
//en paralelo: unos 1000 ms, porque las tres van a la vez y solo cuenta la más lenta.
//si las tareas no dependen unas de otras, mejor en paralelo.
// ---------------------------------------------------------------------
// EJERCICIO 3.2 · Elige el combinador
// Para cada situación, escribe qué método usarías
// (Promise.all, Promise.allSettled, Promise.race o Promise.any) y por qué.
// No hace falta programar nada: responde en los comentarios.
// ---------------------------------------------------------------------

// a) Necesito el usuario, sus pedidos y su carrito para pintar la página.
//    Método: Promise.all
//    Por qué: necesito los tres datos y, si falla uno, no puedo pintar la página.
//
// b) Quiero cancelar si el servidor tarda más de 3 segundos.
//    Método: Promise.race
//    Por qué: la petición compite con un temporizador de 3 s y gana la que acabe antes.
//
// c) Envío 5 correos y quiero saber cuáles han fallado.
//    Método: Promise.allSettled
//    Por qué: espera a todos aunque alguno falle y dice cuáles han ido bien y cuáles no.
//
// d) Tengo tres servidores con los mismos datos y me vale el primero
//    que responda bien.
//    Método: Promise.any
//    Por qué: se queda con la primera respuesta correcta y no le importan los fallos.



// ---------------------------------------------------------------------
// EJERCICIO 3.4 · Timeout (ampliación, para quien termine la tienda)
// Escribe conTimeout(promesa, ms), que devuelva una promesa que se
// rechace con new Error('Tiempo agotado') si promesa no termina en ms
// milisegundos. Pista: combina Promise.race con esperar.
// Pruébala con:
//   conTimeout(tarea('Rápida', 500), 1000)  → debe cumplirse con 'Rápida'
//   conTimeout(tarea('Lenta', 2000), 1000)  → debe fallar: Tiempo agotado
//
// Después, úsala en la tienda (lo explica el final de tienda.js).
// ---------------------------------------------------------------------

// Tu código aquí:

const conTimeout = (promesa, ms) => {
  const limite = esperar(ms).then(() => {
    throw new Error('Tiempo agotado');
  });
  return Promise.race([promesa, limite]);
};

conTimeout(tarea('Rápida', 500), 1000)
  .then(resultado => console.log('Cumplida:', resultado))
  .catch(err => console.error('Error:', err.message));

conTimeout(tarea('Lenta', 2000), 1000)
  .then(resultado => console.log('Cumplida:', resultado))
  .catch(err => console.error('Error:', err.message));
