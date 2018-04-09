package com.kdp.wanandroidclient.net.interceptor;

import com.kdp.wanandroidclient.utils.LogUtils;
import com.kdp.wanandroidclient.utils.PreUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 保存Cookie
 * author: 康栋普
 * date: 2018/2/27
 */

public class SaveCookieInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        List<String> mCookieList = response.headers("Set-Cookie");
        //保存Cookie
        if (!mCookieList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String cookie : mCookieList) {
                //注意Cookie请求头字段中的每个Cookie之间用逗号或分号分隔
                sb.append(cookie).append(",");
            }
            LogUtils.e(sb.toString());
            PreUtils.put(response.request().url().host(), sb.toString());
        }
        return response;
    }
}
