SRC_FILES := src/GameController.java src/GameModel.java src/GameView.java src/Main.java
BIN_FILES := bin/src/GameController.class bin/src/GameModel.class bin/src/GameView.class bin/src/Main.class

run: $(BIN_FILES)
	java -cp bin src.Main

$(BIN_FILES): $(SRC_FILES)
	javac -d bin $(SRC_FILES)

$(SRC_FILES):
	echo "Can't find src folder or files"