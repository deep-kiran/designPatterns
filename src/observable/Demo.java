package observable;

public class Demo {
    public static void main(String[] args) throws Exception {
        Person person =new Person();
        Event<PropertyChangedEventArgs>.Subscription subscription = person.eventArgsEvent.addHandler(x -> {
            System.out.println(x.propertyName + " has changed ");
        });
        person.setAge(14);
        person.setName("Deep");
        person.setAge(23);
        subscription.close();
        person.setName("Kiran");

    }
}
