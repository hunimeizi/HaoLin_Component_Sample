package com.haolin.minecomponent.listenter;

import android.content.Context;
import android.content.Intent;

import com.haolin.conentlibrary.listenter.IMineService;
import com.haolin.minecomponent.MineActivity;

/**
 * 作者：haoLin_Lee on 2019/04/23 22:02
 * 邮箱：Lhaolin0304@sina.com
 * class:
 */
public class MineService implements IMineService {
    @Override
    public void launch(Context context, int userId) {
        Intent intent = new Intent(context, MineActivity.class);
        intent.putExtra("id", userId);
        context.startActivity(intent);
    }
}
