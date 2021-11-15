# [TQS] MASTERMIND



Programación del juego "Mastermind" por medio de TDD con arquitectura MVC.

<img src="https://github.com/EmilCarvajal/MASTERMIND/blob/master/img/master.jpg"/>



# Tabla de Contenidos
* [Que es Mastermind?](#que-es-Mastermind?)
* [Descripción de proyecto](#descripción-del-proyecto)
* [Implementación](#implementación)
* [Jugar](#jugar)

* [Tests](#tests)

* [Autores](#autores)

# Que es Mastermind?
Mastermind es un juego de mesa, de ingenio y reflexión, para dos jugadores.
Se juega en un tablero con fichas blancas y negras pequeñas y de otros colores, de un tamaño algo superior. Uno de los jugadores escoge un número de fichas de colores, 4 en el juego original, y pone un código secreto oculto del otro jugador. Este, tomando fichas de colores del mismo conjunto, aventura una posibilidad contestada con negras (fichas de color bien colocadas) o blancas (fichas de color con el color correcto, pero mal colocadas).

Termina al averiguarse la combinación (es decir, se consigue una combinación con cuatro negras), o bien se agota el tablero (depende del tamaño, aunque generalmente son 15 combinaciones).

# Descripción del proyecto	
Hemos implementado este juego utilizando lenguage Java i la IDE de IntellIJ. Para ello hemos adaptado algunas cosas del juego:
- 1vs1 contra la máquina
- El tablero se muestra por la terminal

Tambíen lo hemos programado utilizando TDD (Test Driven Development), el cual cosiste en programar antes los tests que los métodos a implementar de las clases creadas para el juego.
Después hemos utilizado diversos tipos y técnicas de tests.

# Implementación
CLASES:
- Board: Clase de vista que muestra el tablero por el terminal
- Code: Clase de códigos
- Player: Clase que controlo los códigos introducidos por el usuario
- SecretCode: Clase que genera el código secreto
- Hint: Clase que guarda cada pista
- MastermindGame: Clase que controla el juego

# Jugar
Para ejecutar el juego es tan sencillo como ejecutar la raiz del proyecto: "MAIN".

# Tests
Se han realizado tests de de caja blanca y de caja negra. 
Tambié se han implentado MockObjects.

Técnicas utilizadas:
- Particiones equivalentes
- Valores límite y frontera	
- Pairwise testing	
- Mock object	
- Statement Coverage	
- Decision Coverage	
- Condition Coverage	
- Path Coverage	
- Loop testing

EJEMPLO DE RESULTADOS: STATEMENT COVERAGE 

<img src="https://github.com/EmilCarvajal/MASTERMIND/blob/master/img/state.JPG"/>
Se puede encontrar el informe completo de tests en la carpeta Informe.

# Autores
Emil Carvajal - 1529821   
Lluis Galante - 1535722
