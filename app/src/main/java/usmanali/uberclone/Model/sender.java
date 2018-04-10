package usmanali.uberclone.Model;

/**
 * Created by SAJIDCOMPUTERS on 11/8/2017.
 */

public class sender {
    public Notification notification;
    public String to;

    public sender(Notification notification, String to) {
        this.notification = notification;
        this.to = to;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
