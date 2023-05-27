# Proyecto del Tercer Parcial
## Desarrollo Basado en Platafomas

## Descripcion
Los archivos contenidos en este repositorio representan una aplicacion de Android Studio, cuya funcionalidad es la de ofrecer un menu con opciones que representan a los integrantes de este equipo. Al seleccionar alguna opcion mediante el boton respectivo, se nos presenta un actividad que muestra el Curriculum Vitae de la persona seleccionada.

## Requisitos
Esta Aplicacion no es un paquete listo para usar en plataformas mobiles, los archivos contenidos en este repositorio representan los archivos de un proyecto de Android Studio y solo funcionaran usandolos bajo este ambiente.
  Se necesita Android Studio
  Java JDK
  
## Instalacion / Ejecucion
Para hacer la prueba de la App, se deben de guardar los archivos en una carpeta que corresponda al directorio donde se guardan los proyectos de android studio:

Comunmente es en:

    user/AndroidStudioProjects/app
  
Una vez que los archivos se encuentren en el lugar correcto se debe de iniciar android Studio y abrir el proyecto

Al abrir el proyecto hay que asegurarse de correr la sincronizacion de Gradle para descargar/instalar las dependencias del codigo.

Esto se hace accediendo en android studio en:

    carpeta de Grade ---- > build.gradle(Module)
  
Una vez ahi se debe de activar la sincronizacion con el boton Sync Project with Gradle Files que se encuentra en la parte superior derecha de la ventana

Ahora tenemos que seleccionar un emulador de Dispositivo, esto se hace a un lado del boton mencionado anteriormente

Cuando se cuente con un dispositivo adecuado se debe de seleccionar en la barra de herramientas la app y correrla con el boton "Run App" o con Mayus + F10 (En Windows)

## Uso de la app
La aplicacion iniciara con un menu que cuenta con boton que representan a los integrantes del equipo, se debe de pulsar alguno para iniciar la siguiente activiad que mostrara la informacion correspondiente al Curriculum Vitae del integrante
La Actividad correspondiente a cada integrante cuenta con un ScrollView para poder desplazarse verticalmente, al final de la informacion se cuenta con un boton que nos redirigira a la pagina de internet del Github del integrante (Esto abre un navegador web).
Para volver al menu principal se pueden usar los control predeterminados para dispositivos android, en el caso de el emulador se puede hacer a traves de la tecla Esc en Windows.

En este repositorio puedes encontrar un video de ejemplo de como funciona la app!

    ./videoAPP.mp4
    
    
## Construido con 

    Android Studio
  
    Java
  
    Jsoup

<h2>Autores</h2>
<ul>
  <li>Anahí Peinado Villalobos 353262</li>
  <li>José Eduardo Conde Hernandez 299506</li>

  <p>Desarrollo basado en plataformas <b> I.S Luis Antonio Ramírez Martínez </b></p>
</ul>
