package com.example.magictheguessing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CardPojo {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_uris")
    @Expose
    private CardArtUris image_uris;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardArtUris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(CardArtUris image_uris) {
        this.image_uris = image_uris;
    }


}
