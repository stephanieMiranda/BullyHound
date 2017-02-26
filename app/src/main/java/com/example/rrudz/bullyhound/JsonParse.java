package com.example.rrudz.bullyhound;
import android.util.Log;

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

}
