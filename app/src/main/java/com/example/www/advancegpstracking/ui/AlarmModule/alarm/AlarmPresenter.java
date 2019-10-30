package com.example.www.advancegpstracking.ui.AlarmModule.alarm;

import android.content.Context;

import com.example.www.advancegpstracking.db.CheckPoint;
import com.example.www.advancegpstracking.db.CheckPointDataSource;
import com.example.www.advancegpstracking.di.qualifiers.ActivityContext;
import com.example.www.advancegpstracking.mvpbase.BasePresenter;

import javax.inject.Inject;

public class AlarmPresenter<V extends AlarmMVPContract.IAlarmView> extends BasePresenter<V>
    implements AlarmMVPContract.IAlarmPresenter<V> {

  private CheckPoint checkPoint;

  @Inject
  public AlarmPresenter(@ActivityContext Context context,
      CheckPointDataSource checkPointDataSource) {
    super(context, checkPointDataSource);
  }

  @Override public void onViewInitialised() {
  }

  @Override public void onDismissButtonClicked() {
    getView().stopRinging();
  }

  @Override public void onIntentDataAvailable(CheckPoint currentCheckPoint) {
    this.checkPoint = currentCheckPoint;
    getView().loadMap();
  }

  @Override public void onMapReady() {
    getView().setMarkerOnMap(checkPoint);
    getView().setCheckPointName(checkPoint.getName());
  }
}
