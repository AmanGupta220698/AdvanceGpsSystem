package com.example.www.advancegpstracking.mvpbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.www.advancegpstracking.di.components.DaggerActivityComponent;
import com.example.www.advancegpstracking.di.modules.ActivityModule;
import com.example.www.advancegpstracking.global.LocationAware;


public class BaseActivity extends AppCompatActivity {
  private DaggerActivityComponent daggerActivityComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    daggerActivityComponent = (DaggerActivityComponent) DaggerActivityComponent.builder()
        .applicationComponent(((LocationAware) getApplication()).getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  public DaggerActivityComponent getActivityComponent() {
    return daggerActivityComponent;
  }
}
