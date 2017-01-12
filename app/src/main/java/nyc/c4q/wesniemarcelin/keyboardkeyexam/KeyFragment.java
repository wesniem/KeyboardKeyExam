package nyc.c4q.wesniemarcelin.keyboardkeyexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import nyc.c4q.wesniemarcelin.keyboardkeyexam.model.AvailableKey;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.model.KeyResponse;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.network.KeyService;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.recyclerView.KeyAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class KeyFragment extends Fragment {
    private static final String BASE_URL = "http://jsjrobotics.nyc/";
    List<AvailableKey> mKeyList;
    RecyclerView keyRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        keyRecyclerView = (RecyclerView) view.findViewById(R.id.key_recyclerView);
        fetchKeys();
        return view;
    }

    private void fetchKeys() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        KeyService service = retrofit.create(KeyService.class);
        Call<KeyResponse> call = service.getKeys();

        call.enqueue(new Callback<KeyResponse>() {
            @Override
            public void onResponse(Call<KeyResponse> call, Response<KeyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("Success", "in there");
                    Log.d("YOOO", "POJO" + response.body());

                    KeyResponse keyResponse = response.body();
                    mKeyList = keyResponse.getAvailableKeys();

                    keyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    KeyAdapter adapter = new KeyAdapter(mKeyList);
                    keyRecyclerView.setAdapter(adapter);

                    Log.d("Adapter", "adapter attached");
                } else {
                    try {
                        Log.d("Error ", "Message" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<KeyResponse> call, Throwable t) {
                Log.d("Failure ", t.getMessage());
            }
        });
    }
}
