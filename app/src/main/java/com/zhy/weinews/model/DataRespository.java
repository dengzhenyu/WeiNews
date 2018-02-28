package com.zhy.weinews.model;


import com.zhy.weinews.model.bean.GankItemBean;
import com.zhy.weinews.model.db.DBHelper;
import com.zhy.weinews.model.http.HttpHelper;
import com.zhy.weinews.model.http.response.GankHttpResponse;
import com.zhy.weinews.model.prefs.PreferencesHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataRespository  {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;


    public DataRespository(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    public boolean getNoImageState() {
        return mPreferencesHelper.getNoImageState();
    }

    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mHttpHelper.fetchRandomGirl(num);
    }
}
