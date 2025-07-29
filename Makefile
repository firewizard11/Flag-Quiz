.PHONY: run build clean

run: build
	java -cp bin src.Main

build:
	javac -d bin src/*

clean:
	rm -r bin/*