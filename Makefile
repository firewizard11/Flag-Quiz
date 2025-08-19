run: bin/Game.class bin/Main.class
	java -cp bin src.Main

bin/Game.class bin/Main.class: src/Main.java src/Game.java
	javac -sourcepath src -d bin src/Main.java src/Game.java

src/Main.java src/Game.java:
	echo "Can't find src files"
