all:
	@javac Main.java -d ./obj/
	@java -cp ./obj/ Main

clean:
	@del obj
