package observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Event <TArgs>{
    private int count=0;
    private Map<Integer, Consumer<TArgs>> handlers =new HashMap<>(); //subscribers
    public Subscription addHandler(Consumer<TArgs> consumer){
        int i =count;
        
        handlers.put(count++,consumer);
        return new Subscription(i,this);
    }
    public void fire(TArgs t){
        for(int i : handlers.keySet()){
            handlers.get(i).accept(t);
        }
    }

    public class Subscription implements AutoCloseable {
        int id;
        Event<TArgs> event;

        public Subscription(int i, Event<TArgs> event) {
            this.id =i;
            this.event= event;
        }

        @Override
        public void close() throws Exception {  //unsubscribing
            event.handlers.remove(id);
        }
    }
}
