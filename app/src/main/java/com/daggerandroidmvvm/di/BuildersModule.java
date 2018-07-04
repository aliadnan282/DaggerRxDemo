package com.daggerandroidmvvm.di;

import com.daggerandroidmvvm.lobby.LobbyActivity;
import com.daggerandroidmvvm.lobby.LobbyModule;
import com.daggerandroidmvvm.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LobbyModule.class)

    abstract LobbyActivity bindLobbyActivity();

    abstract MainActivity bindMainActivity();

    // Add bindings for other sub-components here
}
