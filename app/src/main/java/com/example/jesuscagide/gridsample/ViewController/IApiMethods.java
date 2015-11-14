package com.example.jesuscagide.gridsample.ViewController;

/**
 * Created by jesuscagide on 11/10/15.
 */


import com.example.jesuscagide.gridsample.Model.FeedItem;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.Callback;

public interface IApiMethods {

    @GET("/")
    void getFeedItems(
            @Query("json=get_recent_posts&count=45") Callback<FeedItem> feedItems
    );
}
