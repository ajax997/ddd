import java.lang.invoke.SwitchPoint;

/**
 * Created by nguyennghi on 12/10/18 5:05 PM
 */

interface Shape{
    void draw();
}
interface Color{
    void fill();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle Draw");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square Draw");
    }
}
class Rect implements Shape{

    @Override
    public void draw() {
        System.out.println("Rect Draw");
    }
}

class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Fill Red");
    }
}

class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Fill Green");
    }
}

class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Fill Blue");
    }
}


enum Colors{
    RED, GREEN, BLUE
}
enum Shapes{
    CIRCLE, RECT, SQUARE
}

public abstract class AbstractFactory {
    abstract Color getColor(Colors c);
    abstract Shape getShape(Shapes s);
}


class ShapeFactory extends  AbstractFactory
{

    @Override
    Color getColor(Colors c) {

        return  null;
    }

    @Override
    Shape getShape(Shapes s) {
        switch (s){
            case RECT:
                return new Rect();
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();

        }
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    Color getColor(Colors c) {
        switch (c){
            case RED:
                return new Red();
            case BLUE:
                return new Blue();
            case GREEN:
                return new Green();
        }
        return null;
    }

    @Override
    Shape getShape(Shapes s) {
        return null;
    }
}

class Factory{
    public static AbstractFactory getFactory(String c)
    {
        if (c.equalsIgnoreCase("shape"))
        {
            return new ShapeFactory();
        }
        else return new ColorFactory();
    }

}

class Main{
    public static void main(String ... args)
    {
        AbstractFactory shapeAbstractFactory = Factory.getFactory("shape");
        AbstractFactory colorAbstractFactory = Factory.getFactory("color");

        Color c = colorAbstractFactory.getColor(Colors.GREEN);
        c.fill();

        Shape s = shapeAbstractFactory.getShape(Shapes.RECT);
        s.draw();

    }
}

