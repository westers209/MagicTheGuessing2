package com.example.magictheguessing.view;

public interface ViewContract {
    void populateCard(String card);
    void populateArt(String art);
    void populateError(String message);
    void updateCardInputText(String input);
}
