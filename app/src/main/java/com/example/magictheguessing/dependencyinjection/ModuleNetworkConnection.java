package com.example.magictheguessing.dependencyinjection;

import com.example.magictheguessing.model.NetworkConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ModuleNetworkConnection {
    @Singleton
    @Provides
    NetworkConnection getNetworkConnection(Retrofit retrofit){
        return new NetworkConnection(retrofit);
    }

    @Singleton
    @Provides
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.scryfall.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
