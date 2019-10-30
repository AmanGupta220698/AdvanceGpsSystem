package com.example.www.advancegpstracking.di.components;

import com.example.www.advancegpstracking.bgservice.LocationAwareService;
import com.example.www.advancegpstracking.di.modules.ServiceModule;
import com.example.www.advancegpstracking.di.scopes.ServiceScope;

import dagger.Component;


@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
@ServiceScope
public interface ServiceComponent {
  void inject(LocationAwareService locationAwareService);
}
