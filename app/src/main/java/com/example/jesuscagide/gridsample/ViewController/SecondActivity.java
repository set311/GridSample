package com.example.jesuscagide.gridsample.ViewController;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesuscagide.gridsample.Model.FeedItem;
import com.example.jesuscagide.gridsample.R;
import com.squareup.picasso.Picasso;

import de.greenrobot.event.EventBus;

/**
 * Created by jesuscagide on 11/10/15.
 */
public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        FeedItem item = (FeedItem) EventBus.getDefault().removeStickyEvent(FeedItem.class);
        imageView =  (ImageView)findViewById(R.id.imageView);
        text =   (TextView)findViewById(R.id.textView);

        text.setText(item.getTitle());
        Picasso.with(this).load(item.getThumbnail())
                .error(android.R.drawable.ic_btn_speak_now)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(imageView);
    }

}
