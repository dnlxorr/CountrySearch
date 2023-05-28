#Country Search app

Aplicación básica para consumir un API REST. Cuenta con una vista de lista de países y una vista de detalle.

El proyecto se construyó bajo una arquitectura MVVM en la cual las vistas (View) de la aplicación solicitan información al ViewModel el cual, a través de los casos de uso pertinentes, obtiene informacion del repositorio de datos local o remoto para devolverlos a la vista. Logrando así un desacoplamiento de las diferentes capas.

Se utilizó la librería Picasso para cargar las imágenes. Retrofit como interface para la obtención de los datos junto con Gson para deserializar la respuesta del servicio. Las peticiones de red se realizaron en un hilo diferente al principal, haciendo uso de corrutinas.

