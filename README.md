## Esquema en Markdown Room
Es una capa de abstracción que se ubica sobre una base de datos SQLite. Room simplifica las tareas de configuración de la base de datos, así como las interacciones con la app.


##  Requisitos


-   Código de inicio de la app de  **Inventory**
-   Una computadora con Android Studio
-   Un dispositivo o un emulador con nivel de API 26 o posterior

## Descripción general de la app

El usuario tendrá opciones para agregar un elemento nuevo, actualizar uno existente y borrarlo de la base de datos de inventario. En este codelab, guardarás los datos del elemento en la base de datos de Room.

## Componentes principales de Room
Kotlin ofrece una manera fácil de trabajar con datos a través de clases de datos. Si bien es fácil trabajar con datos en la memoria mediante clases de datos, cuando se trata de datos persistentes, debes convertirlos en un formato compatible con el almacenamiento de bases de datos. De este modo, necesitas  _tablas_  para almacenar los datos y  _consultas_  para acceder a ellos y modificarlos.

## Crea el elemento Entity
Una clase [Entity](https://developer.android.com/reference/androidx/room/Entity?hl=es-419) define una tabla, y cada instancia de esta clase representa una fila en la tabla de la base de datos. La anotación `@Entity` tiene varios argumentos posibles. De forma predeterminada (no hay argumentos para `@Entity`), el nombre de la tabla es el mismo que el nombre de la clase. Usa el argumento `tableName` para personalizar el nombre de la tabla.

## Crea el elemento DAO
-   **Insertar**  o agregar un elemento nuevo
-   **Actualizar**  un elemento existente para actualizar el nombre, el precio y la cantidad
-   **Obtener**  un elemento específico según su clave primaria,  `id`
-   **Obtener todos los elementos**  para que puedas mostrarlos
-   **Borrar**  una entrada de la base de datos


## Crea una instancia de base de datos
  La clase  [`Database`](https://developer.android.com/reference/androidx/room/Database?hl=es-419)  proporciona a tu app instancias de los DAO que definas. A su vez, la app puede usar los DAO para recuperar datos de la base de datos como instancias de objetos de entidad de datos asociados. La app también puede usar las entidades de datos definidas para actualizar filas de las tablas correspondientes o crear filas nuevas para su inserción.

Debes crear una clase abstracta  `RoomDatabase`  y anotarla con  `@Database`. Esta clase tiene un método que muestra la instancia existente de  `RoomDatabase`  si la base de datos no existe.

### Crea la base de datos

1.  En el paquete  `data`, crea una clase de Kotlin  `InventoryDatabase.kt`.
2.  En el archivo  `InventoryDatabase.kt`, haz que la clase  `InventoryDatabase`  sea una clase  `abstract`  que extienda  `RoomDatabase`.
3.  Anota la clase con  `@Database`. Ignora el error de parámetros faltantes, ya que lo corregirás en el siguiente paso.
