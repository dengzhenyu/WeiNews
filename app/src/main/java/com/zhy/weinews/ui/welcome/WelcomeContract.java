package com.zhy.weinews.ui.welcome;

import com.zhy.weinews.base.BasePresenter;
import com.zhy.weinews.base.BaseView;

/**
 * Created by codeest on 16/8/15.
 */

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
