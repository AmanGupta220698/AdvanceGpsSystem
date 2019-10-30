package com.example.www.advancegpstracking.global;

import android.app.Application;

import com.example.www.advancegpstracking.di.modules.ApplicationModule;
import com.example.www.advancegpstracking.di.components.DaggerApplicationComponent;


public class LocationAware extends Application {
  private DaggerApplicationComponent daggerApplicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    daggerApplicationComponent =
        (DaggerApplicationComponent) DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
  }

  public DaggerApplicationComponent getApplicationComponent() {
    return daggerApplicationComponent;
  }
}
