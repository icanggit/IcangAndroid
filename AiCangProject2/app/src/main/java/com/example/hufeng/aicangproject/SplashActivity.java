package com.example.hufeng.aicangproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.hufeng.com.example.hufeng.utils.UIHelper;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by hufeng on 2016/3/25.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                UIHelper.jump(SplashActivity.this,LoginActivity.class);
                finish();
            }
        };

        timer.schedule(timerTask,1000*5);
    }
}
