package com.example.www.advancegpstracking.global;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.www.advancegpstracking.bgservice.LocationAwareService;
import com.example.www.advancegpstracking.db.CheckPointDataSource;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;


public class BootReceiver extends BroadcastReceiver {

  @Inject
  CheckPointDataSource checkPointDataSource;

  @Override public void onReceive(Context context, Intent intent) {
    ((LocationAware) context.getApplicationContext()).getApplicationComponent().inject(this);
    checkPointDataSource.getCheckPointCount()
        .doOnSuccess(count -> {
          if (count > 0) {
            context.startService(new Intent(context, LocationAwareService.class));
          }
        })
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
