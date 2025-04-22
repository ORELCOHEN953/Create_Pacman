# Create_Pacman
Pac-Man Game Implementation
This project is an implementation of the classic Pac-Man game using Java. The game was designed with object-oriented principles, focusing on modularity, graphical interfaces, and smooth user experience. It includes key components for managing shapes, controlling the game logic, and interacting with the graphical user interface.

Project Structure
The project is organized into several Java classes that manage different aspects of the game:

Ex4Main.java: The entry point of the game, responsible for setting up and running the game loop.

Ex4_Const.java: Contains constant values used throughout the game (e.g., game settings, grid size).

GUIShape.java: Defines the graphical elements (shapes) used in the game, such as Pac-Man, ghosts, and items.

GUI_Shapeable.java: Interface for classes that can be rendered as graphical shapes in the game.

ShapeCollection.java: Manages collections of shapes, enabling the dynamic addition, removal, and management of game elements.

ShapeCollectionable.java: Interface for classes that manage collections of shapes in the game.

README.md: This file, providing an overview of the project and instructions for running it.

jar_Ex4.jar: The packaged executable file for running the game.

Gameplay
The objective of the game is to control Pac-Man as he navigates through a maze, eating dots while avoiding ghosts. The player must collect all dots in the maze to win the game. The ghosts move randomly, and Pac-Man must avoid them to stay alive. The game includes power-ups that temporarily allow Pac-Man to eat the ghosts for extra points.

Key Features:
Maze Navigation: Pac-Man moves through a grid-based maze.

Ghosts: The ghosts follow simple AI patterns, adding challenge to the game.

Score System: Points are earned by collecting dots and eating ghosts when empowered.

Graphical Interface: The game includes a GUI for visual interaction with Pac-Man and the maze.

Running the Game
To run the game, follow these steps:

Download the repository or clone it using:

bash
Copy
Edit
git clone <repository_url>
Compile and run the game:

Compile the project using your IDE or from the command line with javac.

Alternatively, you can run the pre-packaged jar_Ex4.jar file:

nginx
Copy
Edit
java -jar jar_Ex4.jar
Requirements
Java 8 or higher.

A graphical user interface (GUI) supported by Java Swing.

Future Improvements
This game can be further enhanced by adding:

More complex AI for the ghosts.

A variety of mazes.

Enhanced visual effects and animations.

Sound effects and background music.

License
This project is open source and available for educational purposes. You can modify and extend it as needed.
