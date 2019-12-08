package com.example.gugymformation;

//Final Project
//A Rudolf Fitness Center interactive gym helper app
//By Eric Av and Aaron Dodge

//Websites used for images
//flat icons:
//https://www.flaticon.com/free-icon/strong_418176?term=biceps&page=1&position=3
//https://www.flaticon.com/free-icon/gynecomastia_1597993?term=chest&page=1&position=8
//https://www.flaticon.com/free-icon/shoulder_2324333?term=body%20parts%20shoulder&page=1&position=20
//https://www.flaticon.com/free-icon/cardio_1546124?term=cardio&page=1&position=3
//https://www.flaticon.com/free-icon/back_2309078?term=back%20body&page=1&position=63
//https://www.flaticon.com/free-icon/muscles_1248756?term=man%20legs&page=1&position=16
//
//Gym pictures:
//https://www.gonzagabulletin.com/fitness-center-opens-to-rave-reviews-from-students/article_bf8348d3-8b02-583d-9d26-337d73c276e5.html
//https://www.gonzaga.edu/student-life/health-well-being/rudolf-fitness-center
//https://www.gonzaga.edu/student-life/health-well-being/rudolf-fitness-center/aquatics
//https://www.gonzagabulletin.com/news/communication-students-examine-comfortability-by-gender-in-rfc/article_5816d318-6b9a-11e9-b5e8-6f49f0722743.html
// https://www.gonzaga.edu/student-life/health-well-being/rudolf-fitness-center
// https://www.gonzaga.edu/student-life/health-well-being/rudolf-fitness-center/aquatics
// https://www.flickr.com/photos/gonzagauniversity/6190355946/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button hoursButton = (Button) findViewById(R.id.hoursButton);
        hoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HoursActivity.class);
                startActivity(intent);
            }
        });

        Button infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        Button workoutButton = (Button) findViewById(R.id.workoutButton);
        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
