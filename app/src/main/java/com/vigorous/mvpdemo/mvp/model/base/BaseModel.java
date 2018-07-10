package com.vigorous.mvpdemo.mvp.model.base;


import com.vigorous.mvpdemo.mvp.callback.NetworkCallback;

/**
 * Created by vigorousliang
 * Created on 2018/6/7
 */

public abstract class BaseModel<P, R> {

    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(P params, NetworkCallback<R> callback);

}