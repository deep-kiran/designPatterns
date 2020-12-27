package decorator;

public class Square implements Shape{
    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "Shape  of side ";
    }
}
