package com.vigorous.mvpdemo.mvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.vigorous.mvpdemo.mvp.bean.request.RequestBean;
import com.vigorous.mvpdemo.mvp.bean.result.ResultBean;
import com.vigorous.mvpdemo.mvp.callback.NetworkCallback;
import com.vigorous.mvpdemo.mvp.model.NetWorkRequestModel;
import com.vigorous.mvpdemo.mvp.mvpinterface.ViewInterface;
import com.vigorous.mvpdemo.mvp.presenter.base.BasePresenter;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by vigorousliang
 * Created on 2018/6/7
 */

public class MvpPresenter extends BasePresenter {

    private Context mContext;

    private NetWorkRequestModel netWorkRequestModel;

    public MvpPresenter(@NonNull Context context) {
        mContext = context;
        netWorkRequestModel = new NetWorkRequestModel(mContext);

    }

    public void loadAssetsDebtsData(@NonNull final RequestBean params) {
        if(isViewAttached()){
            netWorkRequestModel.execute(params, new NetworkCallback<ResultBean>() {
                @Override
                public void onSuccess(ResultBean result) {
                    if(isViewAttached()){
                        ((ViewInterface) getView()).refreshView(result);
                    }
                }

                @Override
                public void onError(String errorCode, String errorDesc) {
                    if(isViewAttached()){
                        ((ViewInterface) getView()).loadDataError(errorDesc);
                    }
                }
            });
        }
    }

}
