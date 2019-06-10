package com.example.magictheguessing.presenter;

import com.example.magictheguessing.view.ViewContract;

public interface PresenterContract {
    void bind(ViewContract viewContract);
    void unbind();
    void sendCard(String card);
    void sendArt(String art);
    void onError(String message);
    void getACard();
}
