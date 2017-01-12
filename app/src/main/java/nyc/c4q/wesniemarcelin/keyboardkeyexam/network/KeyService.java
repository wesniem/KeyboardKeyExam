package nyc.c4q.wesniemarcelin.keyboardkeyexam.network;

import nyc.c4q.wesniemarcelin.keyboardkeyexam.model.KeyResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public interface KeyService {
    @GET(" ")
    Call<KeyResponse> getKeys();
}
