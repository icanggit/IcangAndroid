package com.example.hufeng.aicangproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hufeng.com.example.hufeng.utils.UIHelper;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class LoginActivity extends Activity {
    @ViewInject(R.id.iv_close)
    private ImageView ivClose;
    @ViewInject(R.id.rl_psw)
    private RelativeLayout rlPsw;
    @ViewInject(R.id.et_psw)
    private EditText etPsw;
    @ViewInject(R.id.iv_psw_visible)
    private ImageView ivPswVisible;
    @ViewInject(R.id.tv_forget_psw)
    private TextView tvForgetPsw;
    @ViewInject(R.id.btn_login)
    private Button btnLogin;
    @ViewInject(R.id.btn_register)
    private Button btnRegister;

    //EditText内容设置为密码形式的参数
    private static final int TEXT_PASSWORD = 0x81;
    //为EditText修改内容显示方式的标识
    private Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //加载xUtils中的ViewUtils
        ViewUtils.inject(this);
        //给各个控件设置监听
        setListeners();
    }



    private void setListeners() {
        /**
         * 描述：关闭图标的监听
         * 功能：点击该图标关闭当前界面
         */
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * 描述：对密码可见图标设置监听
         * 功能：两个状态：
         *              状态一：图标为可见，EditText中内容为数字模式：TYPE_CLASS_NUMBER
         *              状态二：图标为不可见，EditText中内容为密码模式：0x81
         */
        ivPswVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    ivPswVisible.setImageResource(R.mipmap.login_psw_vislble);
                    etPsw.setInputType(InputType.TYPE_CLASS_NUMBER);
                    flag = false;
                }else {
                    ivPswVisible.setImageResource(R.mipmap.login_psw_unvislble);
                    etPsw.setInputType(TEXT_PASSWORD);
                    flag = true;
                }
            }
        });

        /**
         * 忘记密码图标设置监听
         */
        tvForgetPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump(LoginActivity.this,FogetPswActivity.class);
                finish();
            }
        });

        /**
         * 登录按钮设置监听
         */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump(LoginActivity.this,MainActivity.class);
                finish();
            }
        });

        /**
         * 注册按钮监听
         */

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.jump(LoginActivity.this,RegisterActivity.class);
                finish();
            }
        });



    }

}
