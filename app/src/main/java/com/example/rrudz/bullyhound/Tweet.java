package com.example.rrudz.bullyhound;


public class Tweet {

    public String mUserName;
    public String mMessage;
    public boolean mIsBadTweet;

    public Tweet(String userName, String message, String date) {
        mUserName = userName;
        mMessage = message;
        mIsBadTweet = LanguageInterpreter.checkString(message);
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmMessage() {
        return mMessage;
    }

    public boolean isIsBadTweet() {
        return mIsBadTweet;
    }
}
