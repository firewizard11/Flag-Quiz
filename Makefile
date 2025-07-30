BIN_DIR := bin
SRC_DIR := src
SRC_FILES := $(wildcard $(SRC_DIR)/*.java)
BIN_FILES := $(wildcard $(BIN_DIR)/*.class)
MAIN := src.Main

run: $(BIN_FILES)
	java -cp $(BIN_DIR) $(MAIN) 

$(BIN_FILES): $(SRC_FILES)
	javac -d $(BIN_DIR) $(SRC_FILES)

clean:
	rm -rf $(BIN_DIR)/*