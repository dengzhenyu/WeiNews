package com.zhy.weinews.ui.welcome;

import com.zhy.weinews.base.BasePresenter;
import com.zhy.weinews.base.BaseView;
import com.zhy.weinews.model.bean.GankItemBean;

/**
 * Created by codeest on 16/8/15.
 */

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(GankItemBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
