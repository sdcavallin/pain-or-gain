# Pain or Gain: The Card Game

Simple client-server program for my card game Pain or Gain that allows a group of people to play virtually by randomizing the deck and simulating card drawing.

To use, compile and run the DeckServer on your host machine.

Don't forget to *port-forward port 6789* (or another) to your host computer.

Players run the Client and press enter to draw a card.

Run the Client or DeckServer from the command line by compiling it with `javac Client.java` and running it with `java Client`

Alternatively, export it as a jar after compiling with `jar cfe Client.jar Client Client.class` and then run it with `java -jar Client.jar`
