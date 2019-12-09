package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class HoursActivity extends AppCompatActivity {
    final String TAG = "HoursActivityTag";
    Document document;
    Elements tables;
    ArrayList<Hours> normalHours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours);

        HoursAPI hoursAPI = new HoursAPI(this);
        hoursAPI.FetchHours();

        ArrayList<String> locations = new ArrayList<>();
        locations.add("Gym");
        locations.add("Pool");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                locations);
        Spinner spinner = findViewById(R.id.choiceSpinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setHours();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });
    }

    private void setHours(){
        Spinner spinner = findViewById(R.id.choiceSpinner);
        TextView hoursView = findViewById(R.id.hoursTextView);
        String selection = spinner.getSelectedItem().toString();
        switch (selection){
            case "Gym":
                String gymHours = "";
                for(int i = 0; i < normalHours.size(); i++){
                    gymHours += normalHours.get(i).getDayOfWeek() + ": " + normalHours.get(i).getGymHours() + "\n";
                }
                hoursView.setText(gymHours);
                break;
            case "Pool":
                String hours = "";
                for(int i = 0; i < normalHours.size(); i++){
                    hours += normalHours.get(i).getDayOfWeek() + ": " + normalHours.get(i).getPoolHours() + "\n";
                }
                hoursView.setText(hours);
                break;
            default:
                break;
        };
    }

    public void receiveDocument(Document document){
        this.document = document;
        this.tables = getHoursTables(this.document);
        buildNormalHours(this.tables.eq(0));
    }

    private Elements getHoursTables(Document doc){
        Log.d(TAG, "getting hours");
        Elements tables = doc.select("tbody");
        //Log.d(TAG,tables.eq(0).toString());
        //Log.d(TAG,tables.eq(1).toString());
        return tables;
    }

    private void buildNormalHours(Elements table){
        Elements rows = table.select("tr");
        Log.d(TAG, "SIZE OF ROWS " + rows.size());
        for(int i = 1; i < rows.size(); i++){
            Elements cells = rows.eq(i).select("td");
            String days = cells.eq(0).html();
            String gym = cells.eq(1).html();
            String pool = cells.eq(2).html();
            normalHours.add(new Hours(days, gym, pool));
        }
    }
}