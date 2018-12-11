/**
 * Created by nguyennghi on 12/10/18 5:34 PM
 */
public class CommandPattern {

    public static  void main(String ... args)
    {
        ElectronicDevice device = new Television();
        TVOnCommand command = new TVOnCommand(device);
        DeviceButton button = new DeviceButton(command);
        button.press();

        TVOffCommand command1 = new TVOffCommand(device);
        DeviceButton button1 = new DeviceButton(command1);
        button1.press();


    }

}

interface ICommand {
    void execute();
}

interface ElectronicDevice{
    void on();
    void off();
    void volumeUp();
    void volumeDown();
}

class Television implements ElectronicDevice{

    int volume = 0;
    @Override
    public void on() {
        System.out.println("TV is ON");
    }

    @Override
    public void off() {
        System.out.println("TV is OFF");
    }

    @Override
    public void volumeUp() {
        volume ++;
        System.out.println("TV volume level at" + volume);
    }

    @Override
    public void volumeDown() {
        volume ++;
        System.out.println("TV volume level at" + volume);
    }
}

class TVOnCommand implements ICommand {

    ElectronicDevice device;

    public TVOnCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
     device.on();
    }
}

class TVOffCommand implements ICommand {

    ElectronicDevice device;

    public TVOffCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.off();
    }
}

class TVVolumeUpCommand implements ICommand {

    ElectronicDevice device;

    public TVVolumeUpCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }
}

class TVVolumeDownCommand implements ICommand {

    ElectronicDevice device;

    public TVVolumeDownCommand(ElectronicDevice device) {
        this.device = device;
    }

    @Override
    public void execute()
    {
        device.volumeDown();
    }
}


class DeviceButton {
    ICommand command;

    public DeviceButton(ICommand command) {
        this.command = command;
    }

    public void press()
    {
        command.execute();
    }
}

