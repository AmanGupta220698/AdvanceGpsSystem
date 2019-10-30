package com.example.www.advancegpstracking.di.modules;

import android.app.Service;
import android.content.Context;

import com.example.www.advancegpstracking.di.qualifiers.ServiceContext;
import com.example.www.advancegpstracking.di.scopes.ServiceScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ServiceModule {
  private final Service service;

  public ServiceModule(Service service) {
    this.service = service;
  }

  @ServiceScope
  @ServiceContext
  @Provides
  Context provideContext() {
    return service;
  }

  @ServiceScope
  @Provides
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }
}
