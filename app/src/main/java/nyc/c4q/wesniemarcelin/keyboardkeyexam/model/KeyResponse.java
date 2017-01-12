package nyc.c4q.wesniemarcelin.keyboardkeyexam.model;

import java.util.List;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class KeyResponse {
    private boolean success;
    private List<AvailableKey> availableKeys;

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
