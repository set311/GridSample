package com.example.jesuscagide.gridsample.ViewController;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesuscagide.gridsample.Model.FeedItem;
import com.example.jesuscagide.gridsample.R;
import com.squareup.picasso.Picasso;

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

        Bundle data = getIntent().getExtras();
        FeedItem item = (FeedItem) data.getParcelable("item");

        imageView =  (ImageView)findViewById(R.id.imageView);
        text =   (TextView)findViewById(R.id.textView);

        text.setText(item.getTitle());
        Picasso.with(this).load(item.getThumbnail())
                .error(android.R.drawable.ic_btn_speak_now)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(imageView);
    }

}
