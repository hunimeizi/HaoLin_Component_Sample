package com.haolin.logincomponent.listenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.haolin.conentlibrary.listenter.ILoginService;
import com.haolin.logincomponent.LoginActivity;
import com.haolin.logincomponent.UserInfoFragment;

/**
 * 作者：haoLin_Lee on 2019/04/23 22:02
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class LoginService implements ILoginService {
    @Override
    public void launch(Context context, String targetClass) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_TARGET_CLASS, targetClass);
        context.startActivity(intent);
    }

    @Override
    public Fragment newUserInfoFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        UserInfoFragment fragment = new UserInfoFragment();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().add(viewId, fragment).commit();
        return fragment;
    }
}
