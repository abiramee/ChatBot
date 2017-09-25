package com.example.techcaredesktop1.chatbot.Network;

import com.example.techcaredesktop1.chatbot.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by TechCare Desktop 1 on 9/18/2017.
 */

public interface ApiService {

    @GET()
    Call<Model> getData(@Url String url);
}
