.PHONY: run clean

run: bin/Game.class bin/game/eventListener.class
	java -cp bin Game

bin/Game.class bin/game/eventListener.class: Game.java game/eventListener.java
	javac -d bin Game.java game/eventListener.java

clean:
	rm -r bin/*