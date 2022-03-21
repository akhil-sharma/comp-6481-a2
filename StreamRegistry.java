import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class StreamRegistry {
    
    private ArrayList<Closeable> streams = new ArrayList<>();

    public void register(Closeable closeable){
        streams.add(closeable);
    }

    public void closeAll(){
        for (Closeable closeable: streams){
            try {
                closeable.close();
            
            } catch (IOException ioe){
                System.out.println("There was an error closing a stream. Ignoring...");
            }
            
        }
    }

    public boolean isEmpty(){
        return streams.size() == 0;
    }

    public void reset(){
        streams.clear();
    }

    public ArrayList<Closeable> getStreams(){
        return this.streams;
    }
}
