package com.example.magictheguessing.dependencyinjection;

import com.example.magictheguessing.presenter.Presenter;
import com.example.magictheguessing.presenter.PresenterContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ModulePresenter {
    @Provides
    PresenterContract getPresenter(Presenter presenter){
        return presenter;
    }
}
