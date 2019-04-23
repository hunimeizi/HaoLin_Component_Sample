package com.haolin.conentlibrary.listenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * 作者：haoLin_Lee on 2019/04/23 21:58
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public interface ILoginService {


    void launch(Context context, String targetClass);

    Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle);
}
