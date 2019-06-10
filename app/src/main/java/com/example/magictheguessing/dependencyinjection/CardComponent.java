package com.example.magictheguessing.dependencyinjection;

import com.example.magictheguessing.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ModuleNetworkConnection.class,
                ModulePresenter.class
        }
)
public interface CardComponent {
    void inject(MainActivity activity);
}
