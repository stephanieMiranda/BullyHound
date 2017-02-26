package com.example.rrudz.bullyhound;

import android.app.ListActivity;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import io.fabric.sdk.android.Fabric;

public class TimelineActivity extends ListActivity {

     // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
     private static final String TWITTER_KEY = "H8KFZggtlb6revjqZ2ADVD1Fo";
     private static final String TWITTER_SECRET = "1Omxt717VmKS3mGExZjFXYjist6iLMl2B8hHZ0wUUBYanDB0AV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.list_item);

        final UserTimeline userTimeline = new UserTimeline.Builder()
        .screenName("rrudzinskipl")
        .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
        .setTimeline(userTimeline)
        .build();
        setListAdapter(adapter);
    }
}