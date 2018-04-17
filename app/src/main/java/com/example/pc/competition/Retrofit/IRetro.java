package com.example.pc.competition.Retrofit;

import com.example.pc.competition.Models.Competition;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pc on 17/04/2018.
 */

public interface IRetro {
    @GET("competitions")
    Call<List<Competition>> getAllCompetitions();
}
