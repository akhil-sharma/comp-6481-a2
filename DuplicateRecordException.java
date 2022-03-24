/**
 * This exception class is thrown when a duplicate record is found.
 */
public class DuplicateRecordException extends Exception {
    public DuplicateRecordException(String message){
        super(message);
    }

    public DuplicateRecordException(){
        super("Duplicate record found!");
    }
}
