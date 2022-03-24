public class InvalidFileException extends Exception{
    public InvalidFileException(String fileName){
        super("Error: Input file named " + fileName + " cannot be found.");
    }

    public InvalidFileException(){
        super("Invalid file detected.");
    }
}
