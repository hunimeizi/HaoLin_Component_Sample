package com.haolin.conentlibrary;

import com.haolin.conentlibrary.listenter.ILoginService;
import com.haolin.conentlibrary.listenter.IMineService;

/**
 * 作者：haoLin_Lee on 2019/04/23 22:27
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    private ILoginService iLoginService;
    private IMineService iMineService;

    public ILoginService getiLoginService() {
        return iLoginService;
    }

    public void setiLoginService(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    public IMineService getiMineService() {
        return iMineService;
    }

    public void setiMineService(IMineService iMineService) {
        this.iMineService = iMineService;
    }
}
