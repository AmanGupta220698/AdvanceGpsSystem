package com.example.www.advancegpstracking.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.www.advancegpstracking.db.AppDataBase;
import com.example.www.advancegpstracking.db.CheckPointDataSource;
import com.example.www.advancegpstracking.di.qualifiers.ApplicationContext;
import com.example.www.advancegpstracking.global.LocationProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module public class ApplicationModule {
  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  @ApplicationContext
  Context provideApplicationContext() {
    return application.getApplicationContext();
  }

  @Singleton
  @Provides
  CheckPointDataSource provideCheckPointDataSource(@ApplicationContext Context context) {
    return AppDataBase.getInstance(context).getCheckPointDataSource();
  }

  @Singleton
  @Provides
  LocationProvider provideLocationProvider(@ApplicationContext Context context) {
    return new LocationProvider(context);
  }
}
