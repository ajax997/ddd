/**
 * Created by nguyennghi on 12/10/18 10:30 PM
 */
public class DecoratorPattern {

    public static void main(String ... args)
    {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }
}

abstract class Beverage{
    String description = "Unknown Beverage";

    public String getDescription()
    {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage{
    protected Beverage warpObj;
}


class HouseBlend extends Beverage{

    public HouseBlend()
    {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
class Espresso extends Beverage{

    public Espresso()
    {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.0;
    }
}

class Mocha extends CondimentDecorator{
    public Mocha(Beverage wrapObj)
    {
        this.warpObj = wrapObj;
    }
    @Override
    public double cost() {
        return 3 + warpObj.cost();
    }
}

class Milk extends CondimentDecorator{

    public Milk(Beverage wrapObj)
    {
        this.warpObj = wrapObj;
    }
    @Override
    public double cost() {
        return 0.7 + warpObj.cost();
    }
}


