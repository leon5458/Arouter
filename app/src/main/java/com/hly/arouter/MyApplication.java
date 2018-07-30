package com.hly.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/23~~~~~~
 * ~~~~~~更改时间:2018/7/23~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        }
        ARouter.init(this);

    }
}
