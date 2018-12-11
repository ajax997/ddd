/**
 * Created by nguyennghi on 12/10/18 4:56 PM
 */
 enum PhoneBranch {
    NOKIA, SAMSUNG, IPHONE
}


public class FactoryPattern {
    public static Phone getPhone(PhoneBranch name)
    {
        switch (name){
            case NOKIA:
                return new NokiaPhone();
            case IPHONE:
                return new IphonePhone();
            case SAMSUNG:
                return new SamSungPhone();
        }
        return null;
    }

}

interface Phone{
    void showInfo();
}

class SamSungPhone implements Phone{

    @Override
    public void showInfo() {
        System.out.println("Sam Phone");
    }
}

class IphonePhone implements Phone{

    @Override
    public void showInfo() {
        System.out.println("iPhone Phone");
    }
}
class NokiaPhone implements Phone{

    @Override
    public void showInfo() {
        System.out.println("Nokia Phone");
    }
}


class Test{
     public static void main(String ... args)
     {

         Phone p = FactoryPattern.getPhone(PhoneBranch.IPHONE);
         p.showInfo();
     }
}