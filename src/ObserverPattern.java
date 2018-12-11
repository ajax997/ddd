import java.util.ArrayList;

/**
 * Created by nguyennghi on 12/10/18 11:29 PM
 */
public class ObserverPattern {


    public static void main(String ... args)
    {
        ChannelData channelData = new ChannelData();
        YoutubeMobile youtubeMobile = new YoutubeMobile(channelData);
        channelData.setChange(100, "Sai Nguoi, Sai Thoi Diem");
        channelData.setChange(1000, "Yeu Don Phuong");
    }
}

interface Subscriber{
    public void update(int like, String video);
}

 interface Devices{
    void showNotification();
}

interface Channel{
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void pushNotification();
}


class ChannelData implements Channel{


    int like;
    String videoName;

    ArrayList<Subscriber> subscribers = new ArrayList<>();


    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void pushNotification() {
        for (Subscriber subscriber: subscribers) {
            subscriber.update(like, videoName);
        }
    }

    public void setChange(int like, String videoName)
    {
        this.like = like;
        this.videoName = videoName;
        pushNotification();
    }
}


class YoutubeMobile implements Subscriber, Devices{

    int like;
    String video;



    public YoutubeMobile(ChannelData channelData) {
        this.like = channelData.like;
        this.video = channelData.videoName;
        channelData.subscribe(this);
    }

    @Override
    public void update(int like, String video) {
        this.like = like;
        this.video = video;
        showNotification();
    }

    @Override
    public void showNotification() {
        System.out.println("New Video " + video + ": Like" + String.valueOf(like));
    }
}