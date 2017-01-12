package nyc.c4q.wesniemarcelin.keyboardkeyexam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class KeyResponse {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("available keys")
    @Expose
    private List<AvailableKey> availableKeys = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<AvailableKey> getAvailableKeys() {
        return availableKeys;
    }

    public void setAvailableKeys(List<AvailableKey> availableKeys) {
        this.availableKeys = availableKeys;
    }

}
