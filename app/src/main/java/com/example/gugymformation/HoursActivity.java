package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class HoursActivity extends AppCompatActivity {
    final String TAG = "HoursActivityTag";
    Document document;
    Elements tables;
    ArrayList<Hours> normalHours = new ArrayList<>();
    ArrayList<Hours> specialHours = new ArrayList<>();
    HashMap<String, GymHours> hoursMap;

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
        normalHours = buildHoursList(this.tables.eq(0));
        setHours();
        specialHours = buildHoursList(this.tables.eq(1));
        hoursMap = buildHoursMap();
        setStatus();
    }

    private Elements getHoursTables(Document doc){
        Log.d(TAG, "getting hours");
        Elements tables = doc.select("tbody");
        //Log.d(TAG,tables.eq(0).toString());
        //Log.d(TAG,tables.eq(1).toString());
        return tables;
    }

    private ArrayList<Hours> buildHoursList(Elements table){
        ArrayList<Hours> hours = new ArrayList<>();
        Elements rows = table.select("tr");
        Log.d(TAG, "SIZE OF ROWS " + rows.size());
        for(int i = 1; i < rows.size(); i++){
            Elements cells = rows.eq(i).select("td");
            String days = cells.eq(0).html();
            String gym = cells.eq(1).html();
            String pool = cells.eq(2).html();
            hours.add(new Hours(days, gym, pool));
        }
        return hours;
    }

    private HashMap<String, GymHours> buildHoursMap(){
        HashMap<String, GymHours> hours = new HashMap<>();
        hours.put("defaultMondayToThursday", new GymHours(6, 23));
        hours.put("defaultFriday", new GymHours(6, 22));
        hours.put("defaultSaturday", new GymHours(9, 18));
        hours.put("defaultSunday", new GymHours(9, 22));
        for(int i = 0; i < specialHours.size(); i++) {
            String monthDay = "";
            String[] temp = specialHours.get(i).getDayOfWeek().split(",");
            if (temp.length == 1) {
                monthDay = temp[0];
            } else {
                monthDay = temp[1];
            }
            monthDay = monthDay.trim();
            String[] tempHours = specialHours.get(i).getGymHours().split("-");
            if (tempHours.length == 1) {
                hours.put(monthDay, new GymHours(-1, -1));
            } else {
                String[] tempOpen = tempHours[0].split(" ");
                String openString = tempOpen[0].trim();
                if(openString.contains("am")){
                    StringBuilder sb = new StringBuilder();
                    sb.append(openString.charAt(0));
                    openString = sb.toString();
                }
                int opens = Integer.parseInt(openString);
                tempHours[1] = tempHours[1].trim();
                String[] tempCloses = tempHours[1].split(" ");
                String closesString = tempCloses[0].trim();
                if(closesString.contains("pm")){
                    StringBuilder sb = new StringBuilder();
                    sb.append(closesString.charAt(0));
                    closesString = sb.toString();
                }
                int closes = Integer.parseInt(closesString);
                hours.put(monthDay, new GymHours(opens, closes + 12));
            }
        }
        return hours;
    }

    private void setStatus(){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String key = "";
        if(month == Calendar.JANUARY){
            key += "Jan";
        } else if(month == Calendar.FEBRUARY){
            key += "Feb";
        } else if(month == Calendar.MARCH){
            key += "Mar";
        } else if(month == Calendar.APRIL){
            key += "April";
        } else if(month == Calendar.MAY){
            key += "May";
        } else if(month == Calendar.JUNE){
            key += "June";
        } else if(month == Calendar.JULY){
            key += "July";
        } else if(month == Calendar.AUGUST){
            key += "Aug";
        } else if(month == Calendar.SEPTEMBER){
            key += "Sept";
        } else if(month == Calendar.OCTOBER){
            key += "Oct";
        } else if(month == Calendar.NOVEMBER){
            key += "Nov";
        } else{
            key += "Dec";
        }
        key += " " + day;

        boolean isOpen = false;

        if(hoursMap.get(key) != null){
            GymHours today = hoursMap.get(key);
            if(hour >= today.opens && hour < today.closes){
                isOpen = true;
            }
        } else {
            GymHours today;
            if(dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY || dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY){
                today = hoursMap.get("defaultMondayToThursday");
            } else if(dayOfWeek == Calendar.FRIDAY){
                today = hoursMap.get("defaultFriday");
            } else if(dayOfWeek == Calendar.SATURDAY){
                today = hoursMap.get("defaultSaturday");
            } else{
                today = hoursMap.get("defaultSunday");
            }
            if(hour >= today.opens && hour < today.closes){
                isOpen = true;
            }

            TextView gymStatus = (TextView) findViewById(R.id.gymStatusTextView);
            if(isOpen){
                gymStatus.setText("GYM STATUS: " + "OPEN");
            } else {
                gymStatus.setText("GYM STATUS: " + "CLOSED");
            }
        }

        Log.d("SetStatus: ", dayOfWeek + " " + month + " " + day);
    }
}