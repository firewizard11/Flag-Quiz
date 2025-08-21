run: build
	java -cp bin src.Main

build:
	javac -d bin src/*
