CLASS_FILES := bin/src/Main.class bin/src/Game.class
JAVA_FILES := src/Main.java src/Game.java

run: $(CLASS_FILES)
	java -cp bin src.Main

$(CLASS_FILES): $(JAVA_FILES)
	javac -d bin $(JAVA_FILES)

$(JAVA_FILES):
	echo "Error: Can't find $(JAVA_FILES)"

clean:
	rm -rf $(CLASS_FILES)