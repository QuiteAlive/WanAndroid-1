package com.kdp.wanandroidclient.ui.web;

import com.kdp.wanandroidclient.ui.mvp.view.IView;

/**
 * author: 康栋普
 * date: 2018/4/10
 */

public class WebViewContract {
    interface IWebViewPresenter{
        void collectArticle();
        void collectInsideArticle();
    }

    interface IWebView extends IView{
        int getArticleId();
    }
}