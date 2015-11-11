package com.example.jesuscagide.gridsample.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jesuscagide on 11/10/15.
 */
public class FeedItem implements Parcelable {
    private String title;
    private String thumbnail;


    public FeedItem(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


        protected FeedItem(Parcel in) {
            title = in.readString();
            thumbnail = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(thumbnail);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<FeedItem> CREATOR = new Parcelable.Creator<FeedItem>() {
            @Override
            public FeedItem createFromParcel(Parcel in) {
                return new FeedItem(in);
            }

            @Override
            public FeedItem[] newArray(int size) {
                return new FeedItem[size];
            }
        };
    }
