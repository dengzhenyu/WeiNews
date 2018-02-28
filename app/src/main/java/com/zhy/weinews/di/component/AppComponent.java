package com.zhy.weinews.di.component;

import com.zhy.weinews.app.App;
import com.zhy.weinews.di.module.AppModule;
import com.zhy.weinews.di.module.HttpModule;
import com.zhy.weinews.model.DataRespository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataRespository getDataRespository(); //数据中心

}
