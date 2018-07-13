package com.mvvm.di;

import com.mvvm.lobby.LobbyActivity;
import com.mvvm.lobby.LobbyModule;
import com.mvvm.module.DaysModule;
import com.mvvm.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LobbyModule.class)
    abstract LobbyActivity bindLobbyActivity();

    @ContributesAndroidInjector(modules = DaysModule.class)
    abstract MainActivity bindMainActivity();

    // Add bindings for other sub-components here
}
