/**
 * Created by nguyennghi on 12/11/18 1:01 PM
 */
public class AdapterPattern {
    public static void main(String ... args)
    {
        User user = new User();
        user.setName("Nguyen Nghi");

        CustomeAdapter customeAdapter = new CustomeAdapter(user);
        System.out.println(customeAdapter.getFirstName());
        System.out.println(customeAdapter.getLastName());
    }

}

interface IUser {
    String getName();
    String setName(String name);
}

class User implements IUser{
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String setName(String name) {
        return this.name = name;
    }
}


interface ICustomer {
    String getFirstName();
    String getLastName();
    void setFirstName(String f_name);
    void setLastName(String l_name);
}

class Customer implements ICustomer {

    String f_name, l_name;

    @Override
    public String getFirstName() {
        return f_name;
    }

    @Override
    public String getLastName() {
        return l_name;
    }

    @Override
    public void setFirstName(String f_name) {
        this.f_name = f_name;
    }

    @Override
    public void setLastName(String l_name) {
        this.l_name = l_name;
    }
}


class CustomeAdapter implements ICustomer {
    String f_name, l_name;

    public CustomeAdapter(User user)
    {
        f_name = user.getName().split(" ")[0];
        l_name = user.getName().split(" ")[1];
    }

    @Override
    public String getFirstName() {
        return f_name;
    }

    @Override
    public String getLastName() {
        return l_name;
    }

    @Override
    public void setFirstName(String f_name) {
        this.f_name = f_name;
    }

    @Override
    public void setLastName(String l_name) {
        this.l_name = l_name;
    }
}