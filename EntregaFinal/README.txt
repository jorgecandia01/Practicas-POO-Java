Bienvenido a la versión 1.0 de la aplicación para realizar exámenes tipo test para preparar oposiciones de formantia.es.

Esta es una versión alpha de muestra de lo que en un futuro será una aplicación mucho más grande.

En esta versión puede importar preguntas desde archivos .csv con "\t" de separador, realizar exámenes tipo 
test y obtener su nota, indicando al final en qué preguntas ha fallado y cuánto tiempo ha tardado en completar
el examen. Finalmente, podrá retroceder para ver los enunciados de cada pregunta.

Además, cabe mencionar que el sistema para importar preguntas detecta si una pregunta no tiene la estructura requerida, la 
mete en otro HashSet distinto y pasa a la siguiente.

Los códigos contienen lógica que aún no está implementada, como un banco de preguntas falladas, donde se 
guardará un registro de las preguntas que ha fallado el usuario. Otra funcionalidad será el elegir parámetros
del examen, como la longitud (actualmente está fijado a 10 preguntas), el porcentaje de preguntas falladas
anteriormente que quiere en su examen, o la comunidad autónoma de procedencia de la pregunta. También está pensado 
un sistema de login, para que cada usuario tenga un id y solo los administradores puedan añadir preguntas a la batería.

También hay partes gráficas codificadas y no implementadas, como una pantalla de finalización del examen donde 
se podrá hacer de nuevo o volver a la pantalla de inicio. 


Nota para David: Está implementada la lógica para diferenciar si dos preguntas son iguales. Haciendo debug, he
averiguado que dos preguntas iguales, después de ser importadas del archivo, tienen el mismo hashcode (fijado al
hashcode del id de la pregunta) y el .equals fijado al id de la pregunta, pero a pesar de esto se añaden repetidas 
al mismo HashSet, así que se supondrá que el administrador no añade la misma pregunta varias veces a la batería.

Además, hay un montón de comentarios con prints o código que no está implementado aún, por si necesito hacer debug
en un futuro e ir implementando nuevas funcionalidades (este verano trabajaré en ello).

Inicialmente, la batería de preguntas del programa está vacia, para que se pueda comprobar la funcionalidad de importar 
preguntas, las cuales se guardarán automaticamente en un fichero de tipo objeto. Las próximas veces que se inicie el
programa, no necesitará importar las preguntas.

IMPORTANTE: Libro1.csv es el fichero desde que se importa la muestra de preguntas. Se han introducido varias lineas de texto
erroneas para probar que el sistema de lectura las detecta.

