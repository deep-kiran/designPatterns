package observable;

public class Person {
    Event<PropertyChangedEventArgs> eventArgsEvent =new Event<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name!=null && this.name.equals(name)){
            return;
        }
        this.name = name;
        eventArgsEvent.fire(new PropertyChangedEventArgs(this,"name"));
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(this.age==age)return;
        this.age = age;
        eventArgsEvent.fire(new PropertyChangedEventArgs(this,"age"));
    }
}
