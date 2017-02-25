package com.example.rrudz.bullyhound;

interface TwitterInt {


    // username: Set the username to track for the client
    void setUsername(String username);


    // refreshRate: how often in ms to update the client stream, if greater than the
    // minimum for Twitter API, that is defaulted to.
    void setRefresh(int refreshRate);

    // phrase: phrase to the watch list for the client to check for.
    boolean addPhrase(String phrase);

}
