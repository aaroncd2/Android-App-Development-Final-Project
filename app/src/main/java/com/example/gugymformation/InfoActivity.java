package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.IDNA;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    static final int LOGIN_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //intialize ImageViews for the workout options in the gallery
        ImageView imageView1 = (ImageView) findViewById(R.id.infoView1);
        imageView1.setImageResource(R.drawable.bicep_icon);
        ImageView imageView2 = (ImageView) findViewById(R.id.infoView2);
        imageView2.setImageResource(R.drawable.back_icon);
        ImageView imageView3 = (ImageView) findViewById(R.id.infoView3);
        imageView3.setImageResource(R.drawable.chest_icon);
        ImageView imageView4 = (ImageView) findViewById(R.id.infoView4);
        imageView4.setImageResource(R.drawable.legs_icon);
        ImageView imageView5 = (ImageView) findViewById(R.id.infoView5);
        imageView5.setImageResource(R.drawable.shoulder_icon);
        ImageView imageView6 = (ImageView) findViewById(R.id.infoView6);
        imageView6.setImageResource(R.drawable.cardio_icon);

        final Button quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.this.finish();
            }
        });

    }

    public void onButtonClick(View v)
    {
        ImageView imageView = (ImageView) v;
        String viewTag = imageView.getTag().toString();
        char check = viewTag.charAt(0);

        Intent intent = new Intent(InfoActivity.this, DisplayInfoActivity.class);
        intent.putExtra("typeOfWorkout", check);
        startActivityForResult(intent, LOGIN_REQUEST_CODE);
    }
}
