package com.example.techcaredesktop1.chatbot.Network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public class ApiClient {
    public static String BASEURL = "http://sandbox.api.simsimi.com/";
    public static Retrofit retrofit = null;

    public static  Retrofit getClient(Context context) {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
