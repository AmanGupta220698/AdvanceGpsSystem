package com.example.www.advancegpstracking.ui.AlarmModule.locationalarm;

import com.example.www.advancegpstracking.db.CheckPoint;
import com.example.www.advancegpstracking.mvpbase.IMVPPresenter;
import com.example.www.advancegpstracking.mvpbase.IMVPView;
import com.google.android.gms.common.api.ResolvableApiException;


public interface LocationAlarmMVPContract {
  interface ILocationAlarmView extends IMVPView {

    void updateCurrentLocation(double latitude, double longitude);

    void showAddCheckPointDialog();

    void startLocationAwareService();

    void startResolutionForLocation(ResolvableApiException resolvable);

    void showError(String message);

    void addMarkerOnMap(CheckPoint checkPoint);

    void showBottomSheet();

    void notifyListAdapter();

    void removeMarker(int adapterPosition);
  }

  interface ILocationPresenter<V extends ILocationAlarmView> extends IMVPPresenter<V> {

    void onLocationPermissionGranted();

    void onLocationPinClicked();

    void onSetCheckPoint(String checkpointName, double latitude, double longitude);

    void onMyLocationBtnClicked();

    void onCheckPointListBtnClicked();

    int getCheckPointsCount();

    CheckPoint getCheckPointAt(int position);

    void onCheckPointItemClicked(int adapterPosition);

    void onDeleteCheckPoint(int adapterPosition);

    void onEditCheckPoint(int adapterPosition);

    void onLocationSelected(double latitude, double longitude);
  }
}
