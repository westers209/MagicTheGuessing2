package com.example.magictheguessing.presenter;

import com.example.magictheguessing.model.NetworkConnection;
import com.example.magictheguessing.view.ViewContract;

import javax.inject.Inject;

public class Presenter implements PresenterContract{
    ViewContract view;
    NetworkConnection networkConnection;

    @Inject
    public Presenter(NetworkConnection networkConnection){
        this.networkConnection = networkConnection;
    }

    @Override
    public void bind(ViewContract viewContract) {
        this.view = viewContract;
        networkConnection.initPresenterContract(this);
    }

    @Override
    public void unbind() {
        view = null;
    }

    @Override
    public void sendCard(String card) {
        view.populateCard(card);
    }

    @Override
    public void sendArt(String art) {
        view.populateArt(art);
    }

    @Override
    public void onError(String message) {
        view.populateError(message);
    }

    @Override
    public void getACard() {
        networkConnection.initNetworkCall();
    }
}
