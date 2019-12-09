package com.example.gugymformation;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HoursAPI {

    HoursActivity hoursActivity;

    public HoursAPI(HoursActivity hoursActivity){
        this.hoursActivity = hoursActivity;
    }

    public void FetchHours(){
        FetchHoursAsyncTask asyncTask = new FetchHoursAsyncTask();
        asyncTask.execute();
    }

    class FetchHoursAsyncTask extends AsyncTask<Void, Void, Document> {
        String TAG = "FetchHoursTag: ";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ProgressBar progressBar = hoursActivity.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
            hoursActivity.receiveDocument(document);
            ProgressBar progressBar = hoursActivity.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Document doInBackground(Void... voids) {
            String url = "https://www.gonzaga.edu/student-life/health-well-being/rudolf-fitness-center/about/hours-of-operation";
            try {
                Document doc = Jsoup.connect(url).get();
                //String text = doc.body().text();
                //Log.d(TAG, text);
                return doc;
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
