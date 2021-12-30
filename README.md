# Aplicacion para vista de anuncios
Esta aplicacion contiene el modulo del backend y del frontend.

# Backend
El backend esta hecho con SpringBoot (Java 1.8) y para ejecutarlo solo debemos ejecutar la clase AdvertisementApplication
El endpoint para el scrapper de milanuncios.com es el siguiente: http://localhost:8080/advertisement/scrape
En cuanto a la seguridad solo tenemos un usuario: Usuario: grego Clave: 12345
Fueron agregados unos Unit Testing para la capa de servicios

# Frontend
El frontend esta realizado con React (v16.13.0) para ejecutar debemos ejecutar los comandos 'npm install' y 'npm start' desde el terminal en la ruta src/main/ui. La aplicacion podra ser accedida desde esta direccion http://localhost:3000

Las credenciales de base de dato y de aplicacion podran ser encontradas en el archivo application.properties
