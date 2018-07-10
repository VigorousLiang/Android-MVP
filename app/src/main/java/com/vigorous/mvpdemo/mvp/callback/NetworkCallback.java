package com.vigorous.mvpdemo.mvp.callback;

/**
 * Created by vigorousliang
 * Created on 2018/6/6
 */

public interface NetworkCallback<T> {

    void onSuccess(T result);

    void onError(String errorCode, String errorDesc);
}
