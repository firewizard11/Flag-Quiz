run: bin/Game.class
	java -cp bin Game

bin/Game.class: Game.java
	javac -d bin Game.java

Game.java:
	echo "Can't find Game.java"
