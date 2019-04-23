package com.haolin.component.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.haolin.conentlibrary.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceFactory.getInstance().getiLoginService().launch(MainActivity.this, "");
            }
        });
        findViewById(R.id.goToMine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceFactory.getInstance().getiMineService().launch(MainActivity.this, 1);
            }
        });
        findViewById(R.id.showUI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServiceFactory.getInstance().getiLoginService().newUserInfoFragment(getSupportFragmentManager(),
                        R.id.frameLayout, new Bundle());
            }
        });
    }
}
