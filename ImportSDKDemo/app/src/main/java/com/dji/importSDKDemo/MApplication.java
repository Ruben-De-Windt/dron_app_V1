package com.dji.importSDKDemo;

import android.app.Application;
import android.content.Context;

import com.secneo.sdk.Helper;

public class MApplication extends Application {
    private CAM cam;
    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        Helper.install(MApplication.this);
        if (cam == null) {
            cam = new CAM();
            cam.setContext(this);
        }

    }
    @Override
    public void onCreate() {
        super.onCreate();
        cam.onCreate();
    }

}