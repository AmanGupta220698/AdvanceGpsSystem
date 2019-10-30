package com.example.www.advancegpstracking.mvpbase;

public interface IMVPPresenter<V extends IMVPView> {
  void onAttach(V view);
  void onDetach();
}
