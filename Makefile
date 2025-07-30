BIN_DIR := bin/
SRC_DIR := src/

run: $(BIN_DIR)$*.class
	java -cp bin src.Main

$(BIN_DIR)$*.class:
	javac -d $(BIN_DIR) $(SRC_DIR)*.java

clean:
	rm -rf $(BIN_DIR)$*.class