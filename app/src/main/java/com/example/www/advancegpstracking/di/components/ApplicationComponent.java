package com.example.www.advancegpstracking.di.components;

import android.content.Context;

import com.example.www.advancegpstracking.db.CheckPointDataSource;
import com.example.www.advancegpstracking.di.modules.ApplicationModule;
import com.example.www.advancegpstracking.di.qualifiers.ApplicationContext;
import com.example.www.advancegpstracking.global.BootReceiver;
import com.example.www.advancegpstracking.global.LocationAware;
import com.example.www.advancegpstracking.global.LocationProvider;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {
  void inject(LocationAware locationAware);

  @ApplicationContext
  Context getContext();

  CheckPointDataSource getCheckPointDataSource();

  LocationProvider getLocationProvider();

  void inject(BootReceiver bootReceiver);
}
