package com.example.rrudz.bullyhound;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView list;

    ArrayList<Tweet> tweetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        tweetList = new ArrayList<>();
        list = (ListView) findViewById(R.id.list_view);

        new GetTweets().execute();
    }

    private class GetTweets extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "JSON data is downloading", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpHandler httphandler = new HttpHandler();

            // make request to URL
            String url = "https://api.twitter.com/1.1/search/tweets.json?q=%40rrudzinskipl&src=typd";
            String jsonString = httphandler.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonString);

            if (jsonString != null) {
                JsonParse tweets = new JsonParse(jsonString);
                tweetList = tweets.getStatuses();




            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Couldn't get json from server, check logcat",
                                Toast.LENGTH_LONG).show();;
                    }
                });
            }

            return null;
        }
    }
}
