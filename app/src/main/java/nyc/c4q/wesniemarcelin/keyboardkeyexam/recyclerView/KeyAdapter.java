package nyc.c4q.wesniemarcelin.keyboardkeyexam.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.wesniemarcelin.keyboardkeyexam.R;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.model.AvailableKey;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {
    List<AvailableKey> mAvailableKeyList;

    public KeyAdapter(List<AvailableKey> mAvailableKeyList) {
        this.mAvailableKeyList = mAvailableKeyList;
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.key_item_layout, parent, false);
        return new KeyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {
        AvailableKey availableKey = mAvailableKeyList.get(position);
        holder.bind(availableKey);
    }

    @Override
    public int getItemCount() {
        return mAvailableKeyList.size();
    }
}
