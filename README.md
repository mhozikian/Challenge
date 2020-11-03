# Challenge
## Introducción
El presente repositorio contiene el código fuente de la aplicación propuesta para el desafío. Ademas se adjunta una colección de Postman para poder probar los endpoints.
## Herramientas
Se trabajó con IDE IntelliJ Idea Ultimate versión de prueba. Es un proyecto Maven utilizando el framework Spring, JDK version 1.8. No se utilizó base de datos.
Para generar el deploy, fue necesario crear una cuenta en Heroku quien proveyó el servidor remoto y la URL de acceso al mismo.
## Cómo probar
La URL que proveé Heroku es https://challenge-app-ml.herokuapp.com/. 
Para obtener la información de la nave se puede hacer de dos formas. La primera es invocando al método POST topsecret cuyo body recibe toda la información necesaria. La segunda opción es hacer tres invocaciones a POST topsecret_split?name=<cada_uno_de_los_satelites> con los datos correspondientes a cada satélite.
En la colección de Postman adjunta se pueden encontrar los endpoints:
* https://challenge-app-ml.herokuapp.com/topsecret es un método HTTP POST que contiene un Body con la información de los tres satelites y devuelve las coordenadas y el mensaje armado. Se puede probar el caso de falla cambiando el valor de alguna de las distancias de los satélites.
* https://challenge-app-ml.herokuapp.com/topsecret_split?name=sato  es un método HTTP POST que recibe como parámetro en la URL el nombre de uno de los satélites y en el Body la distancia a la nave y el mensaje de dicho satélite. En caso de tener la información necesaria, retornará un objeto con la misma estructura del punto anterior, caso contrario retornará un error 404 con un mensaje de error. En la colección se adjuntan los endpoints para el POST de cada uno de los satélites, y los datos que deben enviarse para una respuesta exitosa.
* https://challenge-app-ml.herokuapp.com/topsecret_split es un método GET que no recibe ningún parámetro y devuelve la información obtenida de la nave, en caso de haber sido resuelta por medio de la ejecución de los endpoints anteriores.
* https://challenge-app-ml.herokuapp.com/resetLocalMemory este endpoint fue creado para resetear la información que se encuentra en la memoria y realizar las pruebas con la memoria en limpio.
