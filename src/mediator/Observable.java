package mediator;

import java.util.function.Consumer;

public abstract class Observable <T>{
    abstract void subscribeAll(Observer<T> observer) ;

    public abstract void subscribe(Consumer<T> consumer);
}
