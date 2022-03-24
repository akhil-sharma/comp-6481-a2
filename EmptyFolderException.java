/**
 * This class exception is thrown when a folder listed in 
 * the logs is empty.
 */
public class EmptyFolderException extends Exception{
    public EmptyFolderException(String folderName){
        super("ERROR: The directory " + folderName + " is empty.");
    }

    public EmptyFolderException(){
        super("Empty folder detected.");
    }
}
