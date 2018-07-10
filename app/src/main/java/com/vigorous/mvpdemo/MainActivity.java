package com.vigorous.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vigorous.mvpdemo.mvp.bean.request.RequestBean;
import com.vigorous.mvpdemo.mvp.bean.result.ResultBean;
import com.vigorous.mvpdemo.mvp.mvpinterface.ViewInterface;
import com.vigorous.mvpdemo.mvp.presenter.MvpPresenter;
import com.vigorous.mvpdemo.mvp.presenter.base.BasePresenter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    private HashMap<String, BasePresenter> presenterMap = new HashMap<>();

    private final static String PRESENTER_VIEW = "view";
    private final static String PRESENTER_USER_INFO = "userInfo";
    private final static String PRESENTER_KV = "kv";
    private final static String PRESENTER_HOT_ACTIVITY = "hotActivity";

    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenterMap();
        initView();
    }

    /**
     * 初始化presenter
     */
    private void initPresenterMap() {
        MvpPresenter mvpPresenter = new MvpPresenter(this);
        mvpPresenter.attachView(this);
        presenterMap.put(PRESENTER_VIEW, mvpPresenter);

    }

    /**
     * 取出presenter
     *
     * @param type
     * @return
     */
    private BasePresenter getPresenter(String type) {
        if (presenterMap != null) {
            return presenterMap.get(type);
        } else {
            return null;
        }
    }

    private void initView() {
        mTvText = findViewById(R.id.tv_text);
        mTvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestRefreshView();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenterMap != null) {
            Iterator<Map.Entry<String, BasePresenter>> it = presenterMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, BasePresenter> item = it.next();
                item.getValue().detachView();
            }
        }
    }

    private void requestRefreshView() {
        RequestBean requestBean = new RequestBean();
        ((MvpPresenter) getPresenter(PRESENTER_VIEW)).loadAssetsDebtsData(requestBean);
    }

    @Override
    public void refreshView(ResultBean resultBean) {
        if (mTvText != null && resultBean != null) {
            mTvText.setText(resultBean.getResultData());
        }
    }

    @Override
    public void loadDataError(String desc) {

    }
}
