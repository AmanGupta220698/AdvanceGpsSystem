package com.example.www.advancegpstracking.ui.AlarmModule.alarm;


import com.example.www.advancegpstracking.db.CheckPoint;
import com.example.www.advancegpstracking.mvpbase.IMVPPresenter;
import com.example.www.advancegpstracking.mvpbase.IMVPView;

public interface AlarmMVPContract {
  interface IAlarmView extends IMVPView {

    void stopRinging();

    void loadMap();

    void setMarkerOnMap(CheckPoint checkPoint);

    void setCheckPointName(String name);
  }

  interface IAlarmPresenter<V extends IAlarmView> extends IMVPPresenter<V> {
    void onViewInitialised();

    void onDismissButtonClicked();

    void onIntentDataAvailable(CheckPoint currentCheckPoint);

    void onMapReady();
  }
}
