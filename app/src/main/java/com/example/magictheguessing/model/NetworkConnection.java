package com.example.magictheguessing.model;

import com.example.magictheguessing.presenter.PresenterContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkConnection {
    PresenterContract presenterContract;
    Retrofit retrofit;

    @Inject
    public NetworkConnection(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    private Callback<CardPojo> callEnqueue = new Callback<CardPojo>() {
        @Override
        public void onResponse(Call<CardPojo> call, Response<CardPojo> response) {
            presenterContract.sendCard(response.body().getName());
            presenterContract.sendArt(response.body().getImage_uris().art_crop);
        }

        @Override
        public void onFailure(Call<CardPojo> call, Throwable t) {
            presenterContract.onError(t.getMessage());
        }
    };

    public void initNetworkCall(){
        retrofit.create(CardApi.class)
                .getCard()
                .enqueue(callEnqueue);
    }

    public void initPresenterContract(PresenterContract presenterContract){
        this.presenterContract = presenterContract;
    }
}
