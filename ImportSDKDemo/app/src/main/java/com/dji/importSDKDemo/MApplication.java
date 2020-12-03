package com.dji.importSDKDemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.multidex.MultiDex;

import com.secneo.sdk.Helper;

public class MApplication extends Application {
    private CAM cam;
    public static GEOtest mApplication;

    public void loadApplication(Context paramContext) {
        if (mApplication != null)
            return;
            mApplication = new GEOtest(this);

    }
    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        MultiDex.install(this);
        if (mApplication != null) {
            return;
        }
        Helper.install(MApplication.this);
        loadApplication(paramContext);
        if (cam == null) {
            cam = new CAM();
            cam.setContext(this);

        }

    }
    @Override
    public void onCreate() {
        super.onCreate();
        cam.onCreate();
        mApplication.onCreate();
    }
    @Override
    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        mApplication.onConfigurationChanged(paramConfiguration);

    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mApplication.onLowMemory();

    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}