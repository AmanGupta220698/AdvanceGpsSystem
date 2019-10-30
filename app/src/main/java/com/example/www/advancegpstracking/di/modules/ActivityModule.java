package com.example.www.advancegpstracking.di.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.example.www.advancegpstracking.ui.AlarmModule.alarm.AlarmMVPContract;
import com.example.www.advancegpstracking.ui.AlarmModule.alarm.AlarmPresenter;
import com.example.www.advancegpstracking.di.qualifiers.ActivityContext;
import com.example.www.advancegpstracking.di.scopes.ActivityScope;
import com.example.www.advancegpstracking.ui.AlarmModule.locationalarm.LocationAlarmMVPContract;
import com.example.www.advancegpstracking.ui.AlarmModule.locationalarm.LocationAlarmPresenter;

import dagger.Module;
import dagger.Provides;


@Module public class ActivityModule {
  private final AppCompatActivity appCompatActivity;

  public ActivityModule(AppCompatActivity appCompatActivity) {
    this.appCompatActivity = appCompatActivity;
  }

  @ActivityScope
  @ActivityContext
  @Provides
  Context providesContext() {
    return appCompatActivity;
  }

  @ActivityScope
  @Provides
  LocationAlarmMVPContract.ILocationPresenter<LocationAlarmMVPContract.ILocationAlarmView> provideLocationPresenter(
      LocationAlarmPresenter<LocationAlarmMVPContract.ILocationAlarmView> locationAlarmPresenter) {
    return locationAlarmPresenter;
  }

  @ActivityScope
  @Provides
  AlarmMVPContract.IAlarmPresenter<AlarmMVPContract.IAlarmView> provideAlarmPresenter(
      AlarmPresenter<AlarmMVPContract.IAlarmView> alarmPresenter) {
    return alarmPresenter;
  }

  @ActivityScope
  @Provides LayoutInflater provideLayoutInflater(@ActivityContext Context context) {
    return LayoutInflater.from(context);
  }
}
