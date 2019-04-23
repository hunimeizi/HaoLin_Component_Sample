package com.haolin.component.sample.application;

import android.app.Application;

import com.haolin.conentlibrary.APPConfig;
import com.haolin.conentlibrary.listenter.IPPComponent;

/**
 * 作者：haoLin_Lee on 2019/04/23 22:18
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class MainApplication extends Application implements IPPComponent {

    private static MainApplication application;

    private static MainApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializa(this);
    }

    @Override
    public void initializa(Application application) {
        //将主App的上下文传到Login以及mine application中
        for (String component : APPConfig.COMPONENT) {
            try {
                Class<?> clazz = Class.forName(component);
                Object object = clazz.newInstance();
                if (object instanceof IPPComponent) {
                    ((IPPComponent) object).initializa(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
