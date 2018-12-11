/**
 * Created by nguyennghi on 12/10/18 5:19 PM
 */
public abstract class TemplateMethod {

    public void buildHouse()
    {
        buildFundamental();
        buildWall();
        buildWindows();
        buildRoof();

    }

      void buildRoof(){
        System.out.println("Roof done!");
      }

     abstract void buildWindows();

     abstract void buildWall();

      void buildFundamental(){
         System.out.println("Fundamental complete!");
     }

}

class GlassHouse extends TemplateMethod{

    @Override
    void buildWindows() {
        System.out.println("Glass Window Complete");
    }

    @Override
    void buildWall() {
        System.out.println("Glass Wall complete");
    }
}

class WoodenHouse extends TemplateMethod{

    @Override
    void buildWindows() {
        System.out.println("Wood Window Complete");
    }

    @Override
    void buildWall() {
        System.out.println("Wood Wall Complete");
    }
}


class Main2{
    public static  void main(String ... args)
    {
        TemplateMethod t = new GlassHouse();
        t.buildHouse();
        System.out.println("----------------------------------");
        TemplateMethod t2 = new WoodenHouse();
        t2.buildHouse();

    }
}
