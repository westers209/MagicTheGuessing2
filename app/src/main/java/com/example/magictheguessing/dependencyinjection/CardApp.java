package com.example.magictheguessing.dependencyinjection;

import android.app.Application;

import dagger.internal.DaggerCollections;

public class CardApp extends Application {

    public CardComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCardComponent.builder()
                .build();
    }

    public CardComponent getComponent(){
        return component;
    }
}
