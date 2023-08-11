 <h1 align="center">Sistema de Gestión de Clientes y Equipos </h1>

<p align="center">
  <img src="https://github.com/miloRobles/DataSystem/blob/main/imagenesDataSystem/Captura%20de%20pantalla%20(428).png" alt="loguin">
</p>
 <p align="center">
  <img src="https://github.com/miloRobles/DataSystem/blob/main/imagenesDataSystem/Captura%20de%20pantalla%20(429).png " alt="Administrador">
</p>
 <p align="center">
  <img src="https://github.com/miloRobles/DataSystem/blob/main/imagenesDataSystem/Captura%20de%20pantalla%20(433).png" alt="gráfica estatus">
</p>
 <p align="center">
  <img src="https://github.com/miloRobles/DataSystem/blob/main/imagenesDataSystem/Captura%20de%20pantalla%20(434).png" alt="gráfica equipos">
</p>

 

<h1>Descripción del proyecto</h1>
Es una aplicación Java diseñada siguiendo el patrón de arquitectura MVC (Modelo-Vista-Controlador). Esta herramienta permite una gestión integral de la información de clientes y equipos, con características esenciales como autenticación de usuarios, interacción con una base de datos MySQL, generación de reportes en PDF y gráficas para visualizar datos.

<h2>Características Destacadas</h2>
<h3>Autenticación de Usuarios </h3>
La aplicación ofrece un sistema de autenticación seguro con tres roles de usuario:
<br> 
<br> 
Administrador: Tiene acceso completo a todas las funcionalidades de la aplicación, incluida la gestión de usuarios, clientes y equipos. <br>
Capturista: Puede registrar nuevos clientes y equipos, además de actualizar la información existente.<br>
Técnico: Tiene acceso para buscar clientes y equipos, permitiendo realizar actualizaciones según sea necesario.<br>

<h3>El sistema permite:</h3> 

Registrar nuevos clientes con detalles como nombre, dirección, número de contacto, etc.<br> 
Actualizar información existente de los clientes.<br> 
Gestión de Clientes<br> 
Realizar registro y actualizaciones de datos de los clientes <br> 
Gestión de <br> 
Realizar búsquedas eficientes en la base de datos para localizar información específica de los Equipos registrados.<br> 
<h3>Las características de gestión de equipos incluyen:</h3>

Agregar nuevos equipos al inventario con detalles como marca, modelo, año, etc.<br> 
Actualizar los detalles de los equipos existentes, como estado, mantenimiento, etc.<br> 
Realizar búsquedas detalladas para encontrar equipos específicos en el inventario.<br> 
Generación de Reportes en PDF<br> 
<h3>El sistema permite generar reportes en PDF personalizados para:</h3>

Clientes registrados, proporcionando detalles relevantes y resumen de transacciones.<br> 
Equipos en el inventario, incluyendo detalles técnicos y estado actual.<br> 
Gráficas Avanzadas<br> 
<h3>La aplicación ofrece la capacidad de crear gráficas para: </h3>

Visualizar las marcas más comunes de los equipos registrados, proporcionando una visión general de las preferencias de los clientes.<br> 
Determinar la cantidad de equipos de cada marca en el inventario, permitiendo una gestión más efectiva de los recursos.<br> 
<h3>Requisitos</h3>
Para ejecutar esta aplicación, necesitarás: <br> <br> 
<ul>
<li> Java Development Kit (JDK) 8 o superior. </li> 
<li> IDE compatible con Java (Eclipse recomendado). </li> 
<li> Conexión a una base de datos MySQL. </li> 
<li> Librerías para generación de reportes en PDF (iText).</li> 
</ul>
 <br> 
 
<h3>El proyecto sigue una estructura organizativa MVC:</h3>


modelo: Clases relacionadas con el modelo de datos y acceso a la base de datos.<br> 
vista: Clases para la interfaz de usuario y presentación.<br> 
controlador: Clases que gestionan la interacción entre el modelo y la vista. <br> 
conexion: Clases para la gestión de conexiones a la base de datos MySQL.<br> 
referencia: Clases compartidas o de utilidad.<br> 
dao: Clases de acceso a datos (Data Access Object).<br> <br> 
<h3>Configuración</h3>
Configura la conexión a la base de datos MySQL en el paquete conexion.<br> 
Asegúrate de tener las librerías necesarias para la generación de reportes en PDF.<br> 
Ejecuta la aplicación desde la clase principal.<br> <br> 

<h3>Notas</h3>
Este proyecto es un ejemplo de una aplicación de gestión de datos que sigue el patrón MVC y utiliza tecnologías comunes de Java. Para un entorno de producción, se deben considerar aspectos de seguridad, manejo de excepciones, validación de datos y otras buenas prácticas.
