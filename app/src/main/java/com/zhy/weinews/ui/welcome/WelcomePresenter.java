package com.zhy.weinews.ui.welcome;


import com.zhy.weinews.base.RxPresenter;
import com.zhy.weinews.model.DataRespository;
import com.zhy.weinews.model.bean.GankItemBean;
import com.zhy.weinews.model.http.response.GankHttpResponse;
import com.zhy.weinews.util.RxUtil;
import com.zhy.weinews.wight.CommonSubscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by codeest on 16/8/15.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter{


    private static final int COUNT_DOWN_TIME = 3000;

    private DataRespository mDataManager;

    @Inject
    public WelcomePresenter(DataRespository mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getWelcomeData() {
        addSubscribe(mDataManager.fetchRandomGirl(1)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView){
                    @Override
                    public void onNext(List<GankItemBean> list) {
                        mView.showContent(list.get(0));
                        startCountDown();
                    }
                })
        );
    }

    private void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        mView.jumpToMain();
                    }
                })
        );
    }
}
