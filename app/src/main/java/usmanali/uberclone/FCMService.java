package usmanali.uberclone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import usmanali.uberclone.Model.fcm_response;
import usmanali.uberclone.Model.sender;

/**
 * Created by SAJIDCOMPUTERS on 11/8/2017.
 */

public interface FCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAbh-3on0:APA91bGB5gyxxjZnGT36QR1oAAQ-2p74PnIEHMerfGh7HkKbi6iAVpZQ_Il98b9r9VA_q8kQ_66llcLWXnhy4HdOKyceh9Iga-yg5Xh5DkMoX6AVDEIMJ7OltAHlXM__Yye6VAGBu-Wb"
    })
    @POST("fcm/send")
    Call<fcm_response> send_message(@Body sender body);
}
