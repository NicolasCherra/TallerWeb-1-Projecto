docker run -p3306:3306 --name mysql-tw1 -e MYSQL_ROOT_PASSWORD=1234 -d -e MYSQL_ROOT_HOST=% mysql/mysql-server


-- despues de correr el docker run, creamos una db llamada "db" con un cliente (workbench) 
-- y entonces con docker commit mysql-tw1, modificamos el container creado con una db adentro.
-- una vez hecho esto se levanta el container (con la db adentro) con docker start mysql-tw1


-- Comandos utiles docker:
-- docker ps -a = ver todos los contenedores.
-- docker stop {name} = stopea la imagen
-- docker rm {container} = borra contenedor.
-- ./{nombre de script} = corre el script en la terminal (hay que estar en master, carpeta del proyecto)
-- docker commit {name contenedor} = comitea cambios en tu contenedor. Te los guarda en el contenedor.
-- chmod +x {nombre archivo(script)} = da permisos para correr los script luego.

