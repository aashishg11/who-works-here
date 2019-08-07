package com.aashishgodambe.whosworking.test;

import com.aashishgodambe.whosworking.BaseApplication;
import com.aashishgodambe.whosworking.di.DaggerAppComponent;

public class TestApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .appModule(new TestAppModule(this))
                .build().inject(this);
    }
}
