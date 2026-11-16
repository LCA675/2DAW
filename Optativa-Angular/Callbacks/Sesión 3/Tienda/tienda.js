// =====================================================
// EJERCICIO 3.3 · TIENDA SIMULADA
// Tienes disponibles (en api.js):
//   obtenerProductos()  → Promise<[{ id, nombre, precio }, ...]>
//   obtenerStock(id)    → Promise<{ id, unidades }>
// Ambas fallan a veces. Completa los TODO.
// =====================================================

const cargando = document.getElementById('cargando');
const error = document.getElementById('error');
const mensajeError = document.getElementById('mensajeError');
const lista = document.getElementById('listaProductos');
const btnReintentar = document.getElementById('btnReintentar');

const mostrar = elemento => elemento.classList.remove('oculto');
const ocultar = elemento => elemento.classList.add('oculto');

// Pinta un producto en la lista. Ya está hecho: úsalo.
function pintarProducto(producto, unidades) {
  const li = document.createElement('li');
  const nombre = document.createElement('span');
  nombre.textContent = `${producto.nombre} · ${producto.precio.toFixed(2)} €`;
  const stock = document.createElement('span');
  stock.textContent = unidades > 0 ? `${unidades} uds.` : 'Agotado';
  if (unidades === 0) stock.classList.add('agotado');
  li.append(nombre, stock);
  lista.append(li);
}

function cargarTienda() {
  // TODO 1: vaciar la lista, ocultar el error y mostrar «Cargando…»
  lista.innerHTML = '';
  ocultar(error);
  mostrar(cargando);

  // TODO 2: obtener los productos
  return obtenerProductos()
    // TODO 3: pedir el stock de todos a la vez y pasar también los productos
    .then(productos => {
      const peticiones = productos.map(p => obtenerStock(p.id));
      return Promise.all(peticiones)
        .then(stocks => ({ productos, stocks }));
    })
    // TODO 4: pintar cada producto con su stock
    .then(({ productos, stocks }) => {
      productos.forEach((producto, i) => {
        pintarProducto(producto, stocks[i].unidades);
      });
    })
    // TODO 5: si algo falla, mostrar el error
    .catch(err => {
      mensajeError.textContent = err.message;
      mostrar(error);
    })
    // TODO 6: ocultar «Cargando…» siempre
    .finally(() => {
      ocultar(cargando);
    });
}

btnReintentar.addEventListener('click', cargarTienda);

cargarTienda();

// TODO 7: que el botón «Reintentar» vuelva a llamar a cargarTienda



// =====================================================
// AMPLIACIÓN (ejercicio 3.4): cuando tengas conTimeout, cópiala junto
// con esperar AL PRINCIPIO de este archivo (antes de la línea
// cargarTienda(), o dará error porque aún no existe) y envuelve con
// ella las dos peticiones de cargarTienda:
//   obtenerProductos()      →  conTimeout(obtenerProductos(), ms)
//   Promise.all(peticiones) →  conTimeout(Promise.all(peticiones), ms)
//
// 1. Pruébala con ms = 500. Esta API tarda entre 0,2 y 1 segundo en
//    cada petición, así que casi siempre saltará el error
//    «Tiempo agotado». Así compruebas que funciona.
// 2. Después déjala en 2000. Con esta API ya no saltará nunca, pero
//    con un servidor real (en AJAX) sí puede tardar más, y entonces
//    la tienda mostrará el error en lugar de quedarse «Cargando…».
// =====================================================

function esperar(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

// Hace una "carrera" entre la promesa y un temporizador:
// gana la que termine antes
function conTimeout(promesa, ms) {
  const limite = esperar(ms).then(() => {
    throw new Error('Tiempo agotado');
  });
  return Promise.race([promesa, limite]);
}