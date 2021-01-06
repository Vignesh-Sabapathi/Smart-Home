package com.framework.test;

import com.google.gson.annotations.SerializedName;

public class post {
    private static String Name;
    private static String id;
    private static String mobileNum;

    public static String getName() {
        return Name;
    }

    public static String getId() {
        return id;
    }

    @SerializedName("body")
    public static String getMobileNum() {
        return mobileNum;
    }
}
