package com.example.www.advancegpstracking.di.components;

import com.example.www.advancegpstracking.ui.AlarmModule.alarm.AlarmActivity;
import com.example.www.advancegpstracking.di.scopes.ActivityScope;
import com.example.www.advancegpstracking.di.modules.ActivityModule;
import com.example.www.advancegpstracking.ui.AlarmModule.locationalarm.LocationAlarmActivity;

import dagger.Component;

@ActivityScope
@Component (modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
  void inject(LocationAlarmActivity locationAlarmActivity);

  void inject(AlarmActivity alarmActivity);
}
