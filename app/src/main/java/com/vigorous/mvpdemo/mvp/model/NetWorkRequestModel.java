package com.vigorous.mvpdemo.mvp.model;

import android.content.Context;

import com.vigorous.mvpdemo.mvp.bean.request.RequestBean;
import com.vigorous.mvpdemo.mvp.bean.result.ResultBean;
import com.vigorous.mvpdemo.mvp.callback.NetworkCallback;
import com.vigorous.mvpdemo.mvp.model.base.BaseModel;


/**
 * Created by vigorousliang
 * Created on 2018/6/7
 */

public class NetWorkRequestModel extends BaseModel<RequestBean, ResultBean> {

    private Context mContext;

    public NetWorkRequestModel(Context context) {
        mContext = context;
    }

    @Override
    public void execute(RequestBean params, final NetworkCallback<ResultBean> callback) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResultData("test");
        callback.onSuccess(resultBean);
    }
}
