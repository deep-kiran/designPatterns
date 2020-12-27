package decorator;

//Decorator pattern is used to enhance functionality of existing class
// either by referencing the class or by inheriting it
public class Circle implements Shape {
    private float radius;

    public Circle(float radius){
        this.radius=radius;
    }
    public void resize(float factor){
        radius *=factor;
    }
    @Override
    public String info() {
        return "A circle of radius "+ radius;
    }
}
