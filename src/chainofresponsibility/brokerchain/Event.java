package chainofresponsibility.brokerchain;

import java.util.function.Consumer;
import java.util.*;

public class Event<TArgs> {
    int index =0;
    private Map<Integer, Consumer<TArgs>> handlers =new HashMap<>();

    public int subscribe(Consumer<TArgs> handler){
        int i=index;
        handlers.put(index++,handler);
        return i;
    }
    void unsubscribe(int key){
        handlers.remove(key);

    }
    public void fire(TArgs tArgs){
        for (Consumer<TArgs> handler :handlers.values()){
            handler.accept(tArgs);
        }
    }
}
