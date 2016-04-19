package com.example.hufeng.aicangproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hufeng.com.example.hufeng.utils.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hufeng on 2016/3/28.
 */
public class RegisterActivity extends Activity {
    @Bind(R.id.iv_back)//返回上一级图标
    ImageView ivBack;
    @Bind(R.id.et_username)//昵称
    EditText etUserName;
    @Bind(R.id.et_phone)//手机号
    EditText etPhone;
    @Bind(R.id.et_phone_code)//验证码
    EditText etPhoneCode;
    @Bind(R.id.et_psw)//密码
    EditText etPsw;
    @Bind(R.id.btn_register)//注册按钮
    Button btnRegister;
    @Bind(R.id.tv_get_code)//获取验证码
    TextView tvGetCode;
    @Bind(R.id.iv_psw_visible)//密码是否可见图标
    ImageView ivPswVisible;
//    @Bind(R.id.my_header)
//    MyHeader myHeader;
    private TimeCount time;
    private Boolean flag = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
//        myHeader.setVisibility(View.VISIBLE);
//        myHeader.init("注册");
        time = new TimeCount(60000,1000);
        setListeners();
    }

    private void setListeners() {
        /**
         * 返回上一级按钮
         */
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump(RegisterActivity.this, LoginActivity.class);
                finish();
            }
        });

        /**
         * 获取验证码逻辑处理（图标监听）
         */
        tvGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time.start();
            }
        });

        /**
         * 密码是否可见图标监听
         */
        ivPswVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    ivPswVisible.setImageResource(R.mipmap.login_psw_vislble);
                    etPsw.setInputType(InputType.TYPE_CLASS_TEXT);
                    flag = false;
                }else{
                    ivPswVisible.setImageResource(R.mipmap.login_psw_unvislble);
                    etPsw.setInputType(0x81);
                    flag = true;
                }
            }
        });

        /**
         * 注册按钮监听
         */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegister.setPressed(true);
                subMit(RegisterActivity.this);
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
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
                tvGetCode.setClickable(false);
                tvGetCode.setBackgroundResource(R.color.bg_gray);
                tvGetCode.setText(millisUntilFinished/1000+"  s");
        }

        @Override
        public void onFinish() {
            tvGetCode.setText("重新验证");
            tvGetCode.setBackgroundResource(R.color.orange);
            tvGetCode.setClickable(true);
        }
    }

    private void subMit(Context context){
        btnRegister.setPressed(true);
        btnRegister.setEnabled(false);
        if (TextUtils.isEmpty(etUserName.getText().toString())){
            UIHelper.ToastShow(context,"用户名不能为空");
            btnRegister.setEnabled(true);
            return;
        }else if (TextUtils.isEmpty(etPhone.getText().toString())){
           UIHelper.ToastShow(context,"手机号码不能为空");
            btnRegister.setEnabled(true);
            return;
        }else if (11 != etPhone.getText().length()){
            UIHelper.ToastShow(context,"手机号码格式不正确");
            btnRegister.setEnabled(true);
            return;
        }else if (TextUtils.isEmpty(etPhoneCode.getText().toString())){
            UIHelper.ToastShow(context,"验证码不能为空");
            btnRegister.setEnabled(true);
            return;
        }else if (TextUtils.isEmpty(etPsw.getText().toString())){
            UIHelper.ToastShow(context,"密码不能为空");
            btnRegister.setEnabled(true);
            return;
        }else{
            btnRegister.setPressed(true);
            UIHelper.ToastShow(context,"注册成功，等待验证");
            btnRegister.setEnabled(true);
            return;
        }

    }

}
