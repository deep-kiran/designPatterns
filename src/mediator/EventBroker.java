package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBroker<T> extends Observable<T>
{
  private List<Observer>
          observers = new ArrayList<>();

  @Override
  protected void subscribeAll(Observer<T> observer)
  {
    observers.add(observer);
  }

  public void publish(int n)
  {
    for (Observer<T> o : observers)
      o.onNext(n);
  }

  @Override
  public void subscribe(Consumer<T> consumer) {

  }
}

class FootballPlayer
{
  private int goalsScored = 0;
  private EventBroker broker;
  public String name;
  public FootballPlayer(EventBroker broker, String name)
  {
    this.broker = broker;
    this.name = name;
  }

  public void score()
  {
    broker.publish(++goalsScored);
  }
}

class FootballCoach
{
  public FootballCoach(EventBroker broker)
  {
    broker.subscribe(i -> {
      System.out.println("Hey, you scored " + i + " goals!");
    });
  }
}

class RxEventBrokerDemo
{
  public static void main(String [] args)
  {
    EventBroker broker = new EventBroker();
    FootballPlayer player = new FootballPlayer(broker, "jones");
    FootballCoach coach = new FootballCoach(broker);

    player.score();
    player.score();
    player.score();
  }
}