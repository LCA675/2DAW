// =====================================================================
// SESIÓN 4 · FETCH CON FORMATOS · Ejercicios 4.1 a 4.6
// Escribe tu código debajo de cada enunciado.
// Para ejecutarlo: abre index.html con Live Server (clic derecho →
// «Open with Live Server»). Con doble clic (file://) fetch no funciona.
// Los archivos que vas a pedir están en la carpeta data/.
// =====================================================================


// ---------- Código que ya tienes hecho (no hace falta tocarlo) ----------
// pintarTabla(alumnos, titulo): devuelve una <table> con los alumnos.
// alumnos es un array de objetos { nombre, apellido, edad, curso }.
function pintarTabla(alumnos, titulo) {
  const tabla = document.createElement('table');
  const caption = document.createElement('caption');
  caption.textContent = titulo;
  tabla.append(caption);
  const cabecera = tabla.insertRow();
  for (const campo of ['Nombre', 'Apellido', 'Edad', 'Curso']) {
    const th = document.createElement('th');
    th.textContent = campo;
    cabecera.append(th);
  }
  for (const a of alumnos) {
    const fila = tabla.insertRow();
    for (const valor of [a.nombre, a.apellido, a.edad, a.curso]) {
      fila.insertCell().textContent = valor;
    }
  }
  return tabla;
}
// ------------------------------------------------------------------------


// ---------------------------------------------------------------------
// EJERCICIO 4.1 · Mira la respuesta por dentro
// Haz un fetch de 'data/contenido.json' con then y, en el primer then,
// muestra por consola:
//   - la respuesta entera
//   - respuesta.status y respuesta.ok
//   - el tipo de contenido: respuesta.headers.get('Content-Type')
// Después lee el contenido con .json() y, en un segundo then, muestra
// los datos por consola. Termina la cadena con un catch.
//
// Repite lo mismo con 'data/contenido.txt' (léelo con .text()).
// ¿Qué Content-Type tiene cada uno?
// ---------------------------------------------------------------------

// Tu código aquí:

fetch('data/contenido.json')
  .then(respuesta => {
    console.log('--- JSON ---');
    console.log(respuesta);
    console.log(respuesta.status, respuesta.ok);
    console.log(respuesta.headers.get('Content-Type'));
    return respuesta.json();
  })
  .then(datos => console.log(datos))
  .catch(err => console.log('Error:', err.message));

fetch('data/contenido.txt')
  .then(respuesta => {
    console.log('--- TXT ---');
    console.log(respuesta);
    console.log(respuesta.status, respuesta.ok);
    console.log(respuesta.headers.get('Content-Type'));
    return respuesta.text();
  })
  .then(texto => console.log(texto))
  .catch(err => console.log('Error:', err.message));

// Content-Type del JSON: application/json charset=UTF-8
// Content-Type del TXT:  text/plai charset=UTF-8



// ---------------------------------------------------------------------
// EJERCICIO 4.2 · Cuatro formatos
// Completa las cuatro funciones. Cada una pide su archivo de data/ y
// pinta el resultado en su caja (#json, #txt, #html y #xml).
// Los botones de la página ya las llaman.
//   - JSON: léelo con .json(). Pinta el titulo en un <h3> y el
//           mensaje en un <p>.
//   - TXT:  léelo con .text() y píntalo con textContent.
//   - HTML: léelo con .text() y píntalo con innerHTML.
//   - XML:  léelo con .text(), conviértelo con
//           new DOMParser().parseFromString(texto, 'application/xml')
//           y saca <titulo> y <mensaje> con querySelector.
//           Píntalos como en el JSON.
// Termina cada cadena con un catch que pinte el mensaje del error
// en la caja.
// ---------------------------------------------------------------------

function cargarJson() {
  const caja = document.querySelector('#json');
  caja.textContent = '';
  fetch('data/contenido.json')
    .then(respuesta => respuesta.json())
    .then(datos => {
      const h3 = document.createElement('h3');
      h3.textContent = datos.titulo;
      const p = document.createElement('p');
      p.textContent = datos.mensaje;
      caja.append(h3, p);
    })
    .catch(err => {
      caja.textContent = err.message;
    });
}

function cargarTxt() {
  const caja = document.querySelector('#txt');
  fetch('data/contenido.txt')
    .then(respuesta => respuesta.text())
    .then(texto => {
      caja.textContent = texto;
    })
    .catch(err => {
      caja.textContent = err.message;
    });
}

function cargarHtml() {
  const caja = document.querySelector('#html');
  fetch('data/contenido.html')
    .then(respuesta => respuesta.text())
    .then(texto => {
      caja.innerHTML = texto; // HTML de nuestro propio servidor
    })
    .catch(err => {
      caja.textContent = err.message;
    });
}

function cargarXml() {
  const caja = document.querySelector('#xml');
  caja.textContent = '';
  fetch('data/contenido.xml')
    .then(respuesta => respuesta.text())
    .then(texto => {
      const xml = new DOMParser().parseFromString(texto, 'application/xml');
      const h3 = document.createElement('h3');
      h3.textContent = xml.querySelector('titulo').textContent;
      const p = document.createElement('p');
      p.textContent = xml.querySelector('mensaje').textContent;
      caja.append(h3, p);
    })
    .catch(err => {
      caja.textContent = err.message;
    });
}



// ---------------------------------------------------------------------
// EJERCICIO 4.3 · Piensa y prueba
// Responde en los comentarios. Para la c) y la d), cambia el código del
// 4.2, prueba y después déjalo como estaba.
// ---------------------------------------------------------------------

// a) ¿Por qué hacen falta DOS then para tener
//    los datos de un fetch?
//    el primer then recibe la respuesta y el segundo los datos, porque leer el contenido también es una promesa
// b) Hay respuesta.json() y respuesta.text(), pero no respuesta.xml().
//    ¿Cómo leemos entonces un XML?
//    con .text() y luego lo convertimos con DOMParser
// c) En cargarJson, cambia la ruta por 'data/contenido.txt'.
//    ¿Qué error sale? ¿En qué paso falla: en el fetch o en el .json()?
//    sale "...is not valid JSON", falla el .json() porque el contenido no es JSON, el fetch va bien
// d) En cargarHtml, cambia innerHTML por textContent. ¿Qué cambia?
//    ¿Por qué es peligroso usar innerHTML con HTML que no es nuestro?
//    con textContent se ven las etiquetas escritas 
//    es peligroso porque si el HTML viene de fuera puede traer código que se ejecute en nuestra página


// ---------------------------------------------------------------------
// EJERCICIO 4.4 · Los errores de fetch
// a) Escribe la función pedir(url, formato). Debe DEVOLVER (return)
//    la promesa del fetch con un then que:
//    - si respuesta.ok es false, lance un error:
//        throw new Error(`Error ${respuesta.status} en ${url}`)
//    - si formato es 'json', devuelva respuesta.json();
//      si no, devuelva respuesta.text()
//    Así, quien la use recibe los datos ya leídos en un solo then:
//      pedir('data/contenido.json', 'json').then(datos => ...)
// b) Completa probarErrores: usa pedir con 'data/noexiste.json' y,
//    en el catch, pinta el mensaje del error en #errores.
// c) Quita el if de pedir y vuelve a probar. ¿Qué pasa ahora?
//    ¿Por qué fetch no falla solo con un 404?
// A partir de aquí, usa pedir en los demás ejercicios.
// ---------------------------------------------------------------------

// Tu código aquí (pedir):


function pedir(url, formato) {
  return fetch(url)
    .then(respuesta => {
      if (!respuesta.ok) {
        throw new Error(`Error ${respuesta.status} en ${url}`);
      }
      if (formato === 'json') {
        return respuesta.json();
      } else {
        return respuesta.text();
      }
    });
}


function probarErrores() {
  const caja = document.querySelector('#errores');
  pedir('data/noexiste.json', 'json')
    .then(datos => {
      caja.textContent = JSON.stringify(datos);
    })
    .catch(err => {
      caja.textContent = err.message; // Error 404 en data/noexiste.json
    });
}

// Respuesta c):

//sin el if no sale el error 404 ya que falla el .json por el formato 
//fetch no falla con un 404 porque el servidor sí responde, por eso hay que mirar respuesta.ok

// ---------------------------------------------------------------------
// EJERCICIO 4.5 · Los mismos alumnos en dos formatos
// data/alumnos.json y data/alumnos.xml tienen los mismos 4 alumnos.
// Las dos primeras funciones no pintan nada: DEVUELVEN una promesa
// que se cumple con el array de alumnos (usa pedir y un then).
// a) cargarAlumnosJson(): promesa del array de alumnos del JSON.
//    Mira cómo es el archivo: los alumnos están dentro de "clase".
// b) cargarAlumnosXml(): promesa de un array con LA MISMA FORMA
//    { nombre, apellido, edad, curso }. Recorre los <alumno> con
//    querySelectorAll. Ojo: en el XML todo es texto, así que la edad
//    hay que pasarla a número con Number().
// c) mostrarAlumnos(): pide los dos A LA VEZ con Promise.all y añade a
//    #alumnos una tabla de cada uno con pintarTabla(alumnos, titulo).
//    Muestra por consola si los dos tienen el mismo número de alumnos.
// ¿Con qué formato ha sido más fácil? ¿Por qué crees que casi todas
// las APIs usan JSON?
//casi todas las apis usan json porque es como si fuera un objeto de js y es mas facil de usar
// ---------------------------------------------------------------------
function cargarAlumnosJson() {
  return pedir('data/alumnos.json', 'json')
    .then(datos => datos.clase);
}

function cargarAlumnosXml() {
  return pedir('data/alumnos.xml', 'text')
    .then(texto => {
      const xml = new DOMParser().parseFromString(texto, 'application/xml');
      const alumnos = [];
      xml.querySelectorAll('alumno').forEach(nodo => {
        alumnos.push({
          nombre: nodo.querySelector('nombre').textContent,
          apellido: nodo.querySelector('apellido').textContent,
          edad: Number(nodo.querySelector('edad').textContent),
          curso: nodo.querySelector('curso').textContent
        });
      });
      return alumnos;
    });
}

function mostrarAlumnos() {
  const caja = document.querySelector('#alumnos');
  caja.textContent = '';
  Promise.all([cargarAlumnosJson(), cargarAlumnosXml()])
    .then(resultados => {
      const alumnosJson = resultados[0];
      const alumnosXml = resultados[1];
      caja.append(pintarTabla(alumnosJson, 'Alumnos (JSON)'));
      caja.append(pintarTabla(alumnosXml, 'Alumnos (XML)'));
      if (alumnosJson.length === alumnosXml.length) {
        console.log(`Los dos tienen el mismo número de alumnos: ${alumnosJson.length}`);
      } else {
        console.log(`No coinciden: JSON tiene ${alumnosJson.length} y XML tiene ${alumnosXml.length}`);
      }
    })
    .catch(err => {
      caja.textContent = err.message;
    });
}

// ¿Qué formato ha sido más fácil y por qué?

//El formato mas facil ha sido el json ya que tenemos los objetos y los arrays de js con los tipos correctos

// ---------------------------------------------------------------------
// EJERCICIO 4.6 · Informe de carga (ampliación)
// Quieres comprobar qué archivos se cargan bien. Pide estos cinco A LA
// VEZ con pedir, cada uno con su formato:
//   'data/contenido.json' json      'data/contenido.txt'  text
//   'data/contenido.xml'  text      'data/noexiste.json'  json
//   'data/contenido.txt'  json   ← este fallará: ¿por qué?
// Usa el combinador que espera a TODAS aunque alguna falle (sesión 3).
// Pinta en #informe una lista <ul> con una línea por archivo:
//   ✔ data/contenido.json          (clase ok)
//   ✘ data/noexiste.json: Error 404 en data/noexiste.json   (clase error)
// ---------------------------------------------------------------------

function informe() {
  const caja = document.querySelector('#informe');
  caja.textContent = '';

  const peticiones = [
    { url: 'data/contenido.json', formato: 'json' },
    { url: 'data/contenido.txt', formato: 'text' },
    { url: 'data/contenido.xml', formato: 'text' },
    { url: 'data/noexiste.json', formato: 'json' },
    { url: 'data/contenido.txt', formato: 'json' }
  ];

  const promesas = peticiones.map(p => pedir(p.url, p.formato));

  Promise.allSettled(promesas)
    .then(resultados => {
      const ul = document.createElement('ul');
      resultados.forEach((resultado, i) => {
        const p = peticiones[i]; // mismo orden que el array de promesas
        const li = document.createElement('li');
        if (resultado.status === 'fulfilled') {
          li.textContent = `✔ ${p.url} (${p.formato})`;
          li.classList.add('ok');
        } else {
          li.textContent = `✘ ${p.url} (${p.formato}): ${resultado.reason.message}`;
          li.classList.add('error');
        }
        ul.append(li);
      });
      caja.append(ul);
    });
}
