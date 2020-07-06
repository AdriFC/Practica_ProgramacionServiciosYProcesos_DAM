# Pac_ProgServicios
Pac de desarrollo de Programación de servicios y procesos

En esta PAC se valorarán vuestro conocimiento sobre los sockets de conexión entre diferentes aplicaciones.

¿Qué tiene que realizar la aplicación?

Básicamente se va a centrar en una comunicación entre 1 cliente y 1 servidor.

¿Cuál va a ser la estructura de la PAC?

• Proyecto
    o src
          ▪ server (package)
              • Main
              • Server
              • Tarea
          ▪ client (package)
              • Main
              • Client
              
Como podemos observar debemos crear dos packages con la información correspondiente a cada uno de ellos.

Datos de conexión necesarios:

• Dirección: localhost
• Puerto: 9876

Comunicación entre cliente y servidor: 

  Servidor:
    Inicia el servidor
  
  Cliente:
    Cliente se conecta
  
  Servidor:
    Pregunta el nombre del cliente
  
  Cliente:
    Envía su nombre
  
  Servidor:
    Recibe nombre de cliente.
    Pregunta nº de tareas a realizar
  
  Cliente:
    Envía nº de tareas a realizar
  
  Servidor:
    Bucle
  
  Cliente:
    Bucle
  
  Servidor:
    Envía al cliente nº de la tarea
  
  Cliente:
    Recibe nº de tarea
  
  Servidor:
    Solicita la descripción de la tarea
  
  Cliente:
    Solicita al usuario la descripción de la tarea y se la envía al servidor
  
  Servidor:
    Solicita el estado de la tarea
  
  Cliente:
    Solicita al usuario
  
  Servidor:
    Fin bucle
  
  Cliente:
    Fin bucle
  
  Servidor:
    Envía mensaje al cliente informando de que va enviar las tareas
  
  Servidor:
    Envía todas las tareas
  
  Cliente:
    Recibe la información de las tareas.
  
Clase Tarea:
• String descripción
• String estado.
  
  
