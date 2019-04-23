package com.haolin.logincomponent.application;

import android.app.Application;

import com.haolin.conentlibrary.ServiceFactory;
import com.haolin.conentlibrary.listenter.IPPComponent;
import com.haolin.logincomponent.listenter.LoginService;

/**
 * 作者：haoLin_Lee on 2019/04/23 22:14
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class LoginApplication extends Application implements IPPComponent {

    private static Application application;
    public static  Application getApplication(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializa(this);
    }

    @Override
    public void initializa(Application application) {
        LoginApplication.application = application;
        ServiceFactory.getInstance().setiLoginService(new LoginService());
    }
}
