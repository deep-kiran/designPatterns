package decorator;

public class TransparentShape implements Shape{
    Shape shape;
    int opacity;
    @Override
    public String info() {
        return shape.info()+" has % "+ opacity;
    }
}
