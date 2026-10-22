# entregaP3P4 — Laura Calle Anguita

Aplicación web hecha con Spring Boot, Spring MVC y Thymeleaf por Laura Calle Anguita
## Cómo ejecutarlo

### Requisitos
- Java 27
- Un IDE.

### Crear el proyecto
El proyecto se generó con **Spring Initializr** (start.spring.io) con las dependencias **Spring Web**, **Thymeleaf** y **Validation**

### Ejecutar
- Abrir la clase principal *EntregaP3P4Application* y pulsar *Run*.

Después abrir en el navegador: **http://localhost:8080/**

## Rutas

| Método | Ruta | Qué hace |
|---|---|---|
| GET | `/` | Catalogo de materiales |
| GET | `/materiales/{codigo}` | Ficha del material. |
| GET | `/solicitud/nueva` | Muestra el formulario de préstamo vacío |
| POST | `/solicitudes` |Valida y procesa el formulario si tiene errores vuelve al formulario|

## Estructura del proyecto

- `MaterialController`: va a recibir las peticiones del navegador y gestiona que pagina se muestra. También cuenta con los métodos auxiliares como busqueda.
- `SolicitudPrestamoFormulario`: Es el DTO donde vamos a guardar los datos que el usuario va a escribir por el formulario.
- `templates/`: `catalogo.html`, `ficha.html`, `formulario.html`, `resultado.html` y `error/404.html`, `error/4xx.html`, `error/5xx.html`.

## Ámbitos de variables y uso del modelo

| Elemento | Dónde vive | Ejemplo |
|---|---|---|
| **Propiedades del DTO** | Existen mientras exista el objeto del formulario; Spring las rellena en el binding | `nombre`, `email`, `unidades`, `fechaRecog`, `fechaDevo` |
| **Parámetros de método** | Solo durante la llamada al método | `codigo` y `turno` en la ficha; `form`, `result` y `model` en `comprobarForm` |
| **Variables locales** | Solo dentro del método donde se declaran | `material`, `dias`, `diasUnidades` en `comprobarForm` |
| **Atributos del modelo** | Los añade el controlador con `model.addAttribute` y solo están disponibles en la plantilla que se devuelve en esa petición | `materiales`, `solicitud`, `dias`, `diasUnidad` |

El `Model` es nuevo en cada petición. Por eso, cuando el formulario se vuelve a mostrar con errores, el controlador añade otra vez `materiales` para que el desplegable no salga vacío. Los valores escritos se conservan gracias a `th:object` y `th:field`.

## Casos de aceptación probados

Para probar la validación del servidor añadí temporalmente `novalidate` al `<form>` para que el formulario no lo validase.

| Caso | Resultado |
|---|---|
| `/` | Se ven los 3 materiales con enlace a su ficha | 
| `/materiales/MICRO` | Ficha con `general` | 
| `/materiales/MICRO?turno=tarde` | Ficha con `tarde` | 
| `/materiales/XXXX` | Estado 404 real y página `error/404.html` |
| Error 4xx (por ejemplo GET a `/solicitudes`) | Página `error/4xx.html` | 
| Error 5xx (excepción provocada temporalmente) | Página `error/5xx.html`, sin trazas | 
| Formulario vacío | Mensaje junto a cada campo, valores conservados, selector con los 3 materiales | 
| Nombre de más de 60 caracteres | Error de tamaño | 
| Correo con formato inválido | Error de correo | 
| Unidades 0 y 4 | Error de rango | 
| Unidades con texto (`abc`) | El formulario vuelve con un mensaje comprensible, sin resultado | 
| Fecha pasada | Error de fecha presente o futura | 
| Fecha con formato inválido | El formulario vuelve con un mensaje comprensible | 
| Devolución anterior a la recogida | Error junto a la devolución | 
| Motivo de menos de 30 caracteres | Error de tamaño | 
| Normas sin marcar | Error en la casilla | 
| Material inventado (código manipulado) | Error en el material | 
| Solicitud válida, mismo día de recogida y devolución | Resumen con 1 día y mensaje de un solo día | 
| Solicitud válida de varios días | Resumen con mensaje de varios días; días-unidad = días × unidades | 
| `<b>hola</b>` en el motivo | Se muestra como texto  | 



