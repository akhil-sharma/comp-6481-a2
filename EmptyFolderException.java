public class EmptyFolderException extends Exception{
    public EmptyFolderException(String folderName){
        super(folderName);
    }
}
