# cqrses

JAva Microservicios con KAfka
VEntajas de Docker 

- REtorno de Inversion 
- Mas Velocidad
- Aislamiento y Seguridad
- Posibiidad de Probar el mismo código en diferentes entornos 
- Facilita Testing 
- Menos costes para los test 
- Menos Espacio de almacenamiento para diferentes SO
- Portabilidad
-  Facilidad deDespliegue de aplicaciones al entorno de Producción


Docker Engine es donde se esta instalando al distribución de linux
Docker desktop
Docker Hub subir nuestras imagenes  entre nubes 
Docker Compose : administrar Containers 

Kubernetes



Container es un proceso que tiene un grupo de recursos de hardware y software
asignados para el. Segmento de hardware y sofware reservada para la ejecución 
deun program 


comandos 
*  docker version
* docker run name - Docker run busybox echo Welcome Edwin.
* docker run busybox ping google.com
* docker stop 
* docker stop id 
* docker start -a id
* docker crete hello-world --- devuelve el id ya creado
* docker ps --all
* docker system prum ---- eliminar todos los containers que estan detenidos
* docker stop Id 
* docker kill ID 
* docker pull redis-- descargar la imagen de redis 
* docker run -d -p 6379:6379 --name redis_container redis -- puerto interno y puertoo externo
* docker exec -it <container-id> <command> --- permite ejecutar un comando 
	docker exec -i -> Acceder al output del bash
	docker exc -t -> Escribir el comando en el bash de linux 
	redis-cli
* docker exec -it redis-container sh
* docker run -it nusybox sh


Comó se crea un docker comentainer?
Container es solo un archivo de tipo configuración que se encarga de crear.

Una imagen es un File system Snapshot.
Startup Command. correr la aplicación

Creacion de imagen con docker 

Como crear una imagen?
Docker File -> Docker Cliente -> Docker Serve -> Imagen

Coo crear un docker File? 
Escribir una imagen base-> Ejecutar comandos para instalar dependencias -> especiificar 
comandos para inicialiixar un container basado en esta imagen

** Microservices 
- Independientes entre si 
- Alta disponibilidad
- NO comparten codigo ni base de datos 
- Evitar acoplamiento, Promover Cohesion-- bajo acoplamiento y alta cohesi'on
 Acoplamiento: grado de dependencia entre otros artefactos.
 Cohesion: entre dos partes deben de trabajar juntas para lograr mejores resultados.
- PReferimos Independencia y Autonomia es m[as importante que la reutilizaci'on del 
c'odigo.
 - Debe ser orientada a resolver una sola responsabilidad
 - En un mundo ideal no deberian ser necesarias las comunicaciones entre microservicios 
 ( Pero si sucede trabaja con event/bus o gRCP)
 

CQR(ommand QUery Responsability )Design Pattern 

* Seapration of Commands and Query Responsability
* CQS (Command Query Separation)
* Commands - CommandHandlers
* QUery - QUery-Handlers
 
 * Escalabilidad : Los querys pueden ejecutarse en su propio ambiente, independiente 
 de los commands de escritura.
* Performance:  agregar optimizaciones que en un arquitectura estrechamente acoplado
	en tareas de escritura y lectura.
* Simplicidad implementaci[on complea de este patron comparado con los veneficios.


 ---** Principios transacciones 
Operaciones de alto nivel  
 QUery + lectura de información y retornan informacion
 Command + Modifican data de nuestra aplicación y no retornan ningun valor.
 Crear, actualizar o eliminar 
 
  Que es Event sourcing?
  
  El evento event sourocing define que todos dlos cambios hechos a una determinada
entidad u objeto  deben ser almacenados en una secuencia inmutable de eventos.
  A esta base de datos encargada de registrar los eventos o log o logs, se le denomina 
  event store.
  
  Event store una dela sprincipales caracteristicas regitrar todas las actividades, 
  eventos que ocurran sobre las entidades de mi aplicación.
  
  Veneficios 
 - Event Store contienen el registro de todos los eventos.
