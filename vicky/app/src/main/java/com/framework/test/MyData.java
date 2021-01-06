package com.framework.test;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyData implements Parcelable {
    @SerializedName("response")
    public Response response;


    public static class Response implements Parcelable {
        @SerializedName("docs")
        public List<Docs> docs;

        protected Response(Parcel in) {
            docs = in.readArrayList(Docs.class.getClassLoader());

        }

        public static Creator<Response> CREATOR = new Creator<Response>() {
            @Override
            public Response createFromParcel(Parcel in) {
                return new Response(in);
            }

            @Override
            public Response[] newArray(int size) {
                return new Response[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(docs);

        }
    }

    public static class Docs implements Parcelable {
        @SerializedName("id")
        public String id;
        @SerializedName("journal")
        public String journal;
        @SerializedName("eissn")
        public String eissn;
        @SerializedName("publication_data")
        public String publication_date;
        @SerializedName("article_type")
        public String article_type;

        protected Docs(Parcel in) {
            id = in.readString();
            journal = in.readString();
            eissn = in.readString();
            publication_date = in.readString();
            article_type = in.readString();
        }

        public static final Creator<Docs> CREATOR = new Creator<Docs>() {
            @Override
            public Docs createFromParcel(Parcel in) {
                return new Docs(in);
            }

            @Override
            public Docs[] newArray(int size) {
                return new Docs[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(journal);
            dest.writeString(eissn);
            dest.writeString(publication_date);
            dest.writeString(article_type);

        }

    }

    protected MyData(Parcel in) {
        response = in.readParcelable(Response.class.getClassLoader());
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel in) {
            return new MyData(in);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(response, 1);
    }

}
