package nyc.c4q.wesniemarcelin.keyboardkeyexam.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.wesniemarcelin.keyboardkeyexam.MainKeyActivity;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.R;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.SecondKeyActivity;
import nyc.c4q.wesniemarcelin.keyboardkeyexam.model.AvailableKey;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class KeyViewHolder extends RecyclerView.ViewHolder {
//    ImageView keyView;
    TextView keyText;
    RecyclerView keyRv;
    Context context;
    View view;

    public KeyViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        keyRv = (RecyclerView) itemView.findViewById(R.id.key_recyclerView);
//        keyView = (ImageView) itemView.findViewById(R.id.key_image);
        keyText = (TextView) itemView.findViewById(R.id.key_text);
        context = itemView.getContext();
    }

    public void bind(final AvailableKey availableKey) {
//        Picasso.with(context).load(availableKey.getUrl()).into(keyView);
        keyText.setTextColor(Color.parseColor(availableKey.getTextColor()));
        keyText.setText(availableKey.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondKeyActivity.class);
                intent.putExtra("image", availableKey.getUrl());
                context.startActivity(intent);
            }
        });

    }
}
