package nyc.c4q.wesniemarcelin.keyboardkeyexam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by wesniemarcelin on 1/11/17.
 */

public class SecondKeyActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    ImageView mImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_for_images);
        mImage = (ImageView) findViewById(R.id.image_for_key);
        Intent intent = getIntent();
        String url = intent.getStringExtra("image");
        Bundle picUrl = intent.getExtras();
        if(picUrl!=null){
        Picasso.with(SecondKeyActivity.this)
                .load("http://jsjrobotics.nyc" + url)
                .into(mImage);
        }

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.press_back, Toast.LENGTH_SHORT).show();
    }
}
