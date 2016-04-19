package com.example.hufeng.aicangproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hufeng.com.example.hufeng.utils.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by hufeng on 2016/3/25.
 */
public class FogetPswActivity extends Activity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_psw_visible)
    ImageView ivPsw;
    @Bind(R.id.et_psw)
    EditText etPsw;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.tv_get_code)
    TextView tvGetCode;

    private Boolean flag = true;
    private TimeCount time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_psw);
        ButterKnife.bind(this);

        setListeners();
        //构造TimeCount对象，设置倒计时时间单位ms
        time = new TimeCount(60000,1000);

    }

    private void setListeners() {
        /**
         * 描述：对标题中返回上一级的监听
         * 功能：点击标题栏的返回一级图标，跳转到上一级界面
         */
       ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                UIHelper.jump(FogetPswActivity.this,LoginActivity.class);
                finish();
            }
        });


        /**
         * 描述：对密码是否可见图标的监听
         * 功能：两种状态：
         *              状态一：密码不可见flag = false，密码显示方式是密码
         *              状态二：密码可见flag = true，密码显示方式是数字
         */
        ivPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    ivPsw.setImageResource(R.mipmap.login_psw_vislble);
                    etPsw.setInputType(InputType.TYPE_CLASS_TEXT);
                    flag = false;
                }else{
                    ivPsw.setImageResource(R.mipmap.login_psw_unvislble);
                    etPsw.setInputType(0x81);
                    flag = true;
                }
            }
        });

        /**
         * 描述：确定按钮的监听
         */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegister.setPressed(true);
                UIHelper.ToastShow(FogetPswActivity.this,"找回密码成功");
            }
        });

        /**
         * 描述：获取验证码（倒计时）的监听
         * 功能：点击图标：图标变换为倒计时状态，倒计时完毕还没有获取验证码，则重新变为图标
         */
        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始计时
                time.start();
            }
        });
    }

    class TimeCount extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            //参数依次为总时长,和计时的时间间隔，单位ms
            super(millisInFuture, countDownInterval);
        }

        //触发计时的时候调用，计时过程显示
        @Override
        public void onTick(long millisUntilFinished) {
            //计时的时候，文本框不可点击
            tvGetCode.setClickable(false);
            //设置文本背景
            tvGetCode.setBackgroundResource(R.color.bg_gray);
            //文本上显示计时内容
            tvGetCode.setText(millisUntilFinished / 1000 + "  s");
        }

        //计时结束后调用
        @Override
        public void onFinish() {
            //重新设置文本信息
            tvGetCode.setText("重新验证");
            //设置背景
            tvGetCode.setBackgroundResource(R.color.orange);
            //文本框可点击
            tvGetCode.setClickable(true);
        }
    }
}
