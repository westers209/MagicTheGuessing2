package com.example.magictheguessing.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.magictheguessing.R;
import com.example.magictheguessing.dependencyinjection.CardApp;
import com.example.magictheguessing.presenter.PresenterContract;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewContract{

    @Inject
    PresenterContract presenter;

    @BindView(R.id.tv_card_name)
    TextView tv_card_name;
    @BindView(R.id.btn_new_card)
    Button button;
    @BindView(R.id.tv_art)
    ImageView tv_art;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((CardApp)getApplicationContext()).getComponent().inject(this);


        presenter.bind(this);
        presenter.getACard();
    }

    @Override
    public void populateCard(String card) {
        tv_card_name.setText(card);
    }

    @Override
    public void populateArt(String art) {
        Picasso.get().load(art).into(tv_art);
    }

    @Override
    public void populateError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_new_card)
    public void getACard(){
        presenter.getACard();
    }
}
