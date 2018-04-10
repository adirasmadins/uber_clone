package usmanali.uberclone.Model;

/**
 * Created by SAJIDCOMPUTERS on 11/8/2017.
 */
public class Result{
    public Result() {
    }

    public Result(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String message_id;
}
