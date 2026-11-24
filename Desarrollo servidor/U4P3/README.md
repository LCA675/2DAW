# U4P3 — Casetas de la Feria de Sevilla

Laura Calle Anguita — 2º DAW

Aplicación Spring Boot que muestra las casetas de la Feria guardadas en MariaDB y permite añadir nuevas con un formulario.

## Dominio y atributos

Cada caseta se identifica por su **calle + número** (clave compuesta con `@IdClass(ClaveCaseta.class)`), porque no puede haber dos casetas en el mismo sitio.

| Atributo | Tipo | Obligatorio | Reglas |
|---|---|---|---|
| calle | Texto | Sí | Una de las calles del recinto |
| numeroCalle | Entero | Sí | 1 – 600 |
| nombre | Texto | Sí | Máx. 100 caracteres |
| descripcion | Texto | No | Máx. 300 caracteres |
| foto (URL) | Texto | No | Máx. 300 caracteres |
| numSocios | Entero | Sí | 1 – 500 |
| metrosCuadrados | Decimal | Sí | Mín. 20, 3 enteros y 2 decimales |
| fechaAlta | Fecha | Sí | — |
| publica | Verdadero/falso | Sí | Por defecto `false` (privada) |

## Base de datos

Base de datos local: **`Feria`**. Hay que crearla vacía antes de arrancar:

```sql
CREATE DATABASE Feria;
```

Las credenciales se pasan con variables de entorno (`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`). Si no se definen, se usa `localhost:3306/Feria` con el usuario `root`. Hibernate crea la tabla con `ddl-auto=update`, que no borra los datos al reiniciar.

## Cómo arrancar

```bash
./mvnw spring-boot:run
```

Abrir **http://localhost:8080/**

## Capas

- **Entidad** (`Caseta`, `ClaveCaseta`): la tabla en la base de datos.
- **Repositorio** (`CasetaRepositorio`): acceso a datos con Spring Data JPA.
- **Servicio** (`CasetaService`): lógica de negocio. Lista las casetas y guarda las nuevas, comprobando que no estén duplicadas.
- **DTO** (`NuevaCasetaFormulario`): datos del formulario y sus validaciones.
- **Controlador** (`CasetaControlador`): recibe las peticiones y llama al servicio, nunca al repositorio.
- **Vista** (`recintoFerial.html`): Thymeleaf genera en el servidor el listado y el formulario.

Separar presentación y lógica hace que cada parte tenga una sola tarea. Así se puede cambiar el diseño sin tocar las reglas, y al revés.

## Tecnologías de acceso a datos

MariaDB (base de datos) → driver JDBC de MariaDB (conexión) → JPA/Hibernate (convierte objetos en tablas y SQL) → Spring Data JPA (repositorio sin tener que implementarlo).

## Patrón de diseño

**Inyección de dependencias por constructor:** `CasetaControlador` recibe el servicio y `CasetaService` recibe el repositorio por constructor, sin usar `new`. Así las clases están menos acopladas.

