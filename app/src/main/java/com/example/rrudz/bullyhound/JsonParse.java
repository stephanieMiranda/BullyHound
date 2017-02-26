package com.example.rrudz.bullyhound;
import android.util.Log;

<<<<<<< HEAD
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonParse {

    JsonObject statuses;

    public JsonParse(String searchResult) {
        JsonElement jelement = new JsonParser().parse(searchResult);
        JsonObject jsonObject = jelement.getAsJsonObject();
        if (jsonObject.get("errors") != null)
        {
            // add toast logic for malformed response/query
            Log.e("JSONQuery Malformed", "Please check the query string for correct formedness");
        }
        JsonObject statuses = jsonObject.getAsJsonObject("statuses");
    }

    public TweetObject[] getStatuses() {

        for (int i = 0; i < ) {
            TweetObject tweetObject = new TweetObject(
                    js.get("text"),
                    js.get("entities").get("screen_name"),
                    js.get("id"));
        }   


    }

=======
import org.json.*;
import java.util.ArrayList;

public class JsonParse {

    private JSONArray statusesArray;

    public JsonParse(String searchResult) {
        try {
            JSONObject jsonObject = new JSONObject(searchResult);
            if (jsonObject.get("errors") != null) {
                // add toast logic for malformed response/query
                Log.e("JSONQuery Malformed", "Please check the query string for correct formedness");
            }
            statusesArray = jsonObject.getJSONArray("statuses");
        }
        catch (JSONException je){
            // Toast Logic for failure
            Log.e("ConstructorFailure","Error in JsonParse");
        }
    }

    public ArrayList<Tweet> getStatuses() {
        ArrayList<Tweet> outputList = new ArrayList<>();
        for(int i = 0; i < statusesArray.length(); i++) {
            try {
                JSONObject element = statusesArray.getJSONObject(i);
                String name = element.getJSONObject("entities").getJSONArray("user_mentions").getJSONObject(1).get("screen_name").toString();
                String message = element.getJSONObject("text").toString();
                Tweet newTweet = new Tweet(name, message);
                outputList.add(newTweet);
            } catch (JSONException je2) {
                Log.e("ArrayList", "Failure in getStatuses()");
            }
        }
        return outputList;
    }
>>>>>>> 35b99db477be97b9a131b77af2c4b3ea01825794
}
