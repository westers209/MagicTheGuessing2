package com.example.magictheguessing.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardApi {
    @GET("cards/random?q=-is%3Atransform")
    Call<CardPojo> getCard();
}
