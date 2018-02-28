package com.zhy.weinews.di.module;

import com.zhy.weinews.app.App;
import com.zhy.weinews.model.DataRespository;
import com.zhy.weinews.model.db.DBHelper;
import com.zhy.weinews.model.db.RealmHelper;
import com.zhy.weinews.model.http.HttpHelper;
import com.zhy.weinews.model.http.RetrofitHelper;
import com.zhy.weinews.model.prefs.ImplPreferencesHelper;
import com.zhy.weinews.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

   @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataRespository provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        return new DataRespository(httpHelper, DBHelper, preferencesHelper);
    }
}
