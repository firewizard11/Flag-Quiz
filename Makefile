run: bin/Game.class
	java -cp bin Game

bin/Game.class:
	javac -d bin Game.java

