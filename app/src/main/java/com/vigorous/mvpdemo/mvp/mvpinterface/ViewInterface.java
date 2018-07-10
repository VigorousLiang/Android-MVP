package com.vigorous.mvpdemo.mvp.mvpinterface;


import com.vigorous.mvpdemo.mvp.bean.result.ResultBean;
import com.vigorous.mvpdemo.mvp.mvpinterface.base.BaseViewInterface;

/**
 * Created by vigorousliang
 * Created on 2018/6/6
 */

public interface ViewInterface extends BaseViewInterface {

    void refreshView(ResultBean resultBean);

    void loadDataError(String desc);
}
