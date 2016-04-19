package com.example.hufeng.aicangproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.hufeng.com.example.hufeng.adapters.MainPagerAdapter;
import com.example.hufeng.fragments.EventFragment;
import com.example.hufeng.fragments.HomeFragment;
import com.example.hufeng.fragments.PostFragment;
import com.example.hufeng.fragments.ShowFragment;
import com.example.hufeng.fragments.UserFragment;
import com.example.hufeng.views.FixViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hufeng on 2016/3/28.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener{
    @Bind(R.id.iv_main_menu_1)
    ImageView HomeMenu;
    @Bind(R.id.iv_main_menu_2)
    ImageView EventMenu;
    @Bind(R.id.iv_main_menu_3)
    ImageView PostMenu;
    @Bind(R.id.iv_main_menu_4)
    ImageView ShowMenu;
    @Bind(R.id.iv_main_menu_5)
    ImageView UserMenu;
    @Bind(R.id.vp_main_container)
    //作为页面容器的ViewPager
    FixViewPager fixViewPager;

    //页面的集合
    private List<Fragment> fragmentList;
    //五个碎片
    //首页
    private HomeFragment homeFragment;
    //商品展示页面
    private EventFragment eventFragment;
    //拍卖界面
    private PostFragment postFragment;
    //晒物界面
    private ShowFragment showFragment;
    //个人中心界面
    private UserFragment userFragment;
    //适配器
    private MainPagerAdapter mainPagerAdapter;

    private List<ImageView> menu;

    private int currentItem = 0;
    int[] imgs = {R.mipmap.main_menu_1_sel,R.mipmap.main_menu_2_sel,R.mipmap.main_menu_3_sel,R.mipmap.main_menu_4_sel,R.mipmap.main_menu_5_sel};
    int[] imgs2 ={R.mipmap.main_menu_1,R.mipmap.main_menu_2,R.mipmap.main_menu_3,R.mipmap.main_menu_4,R.mipmap.main_menu_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化数据
        initDatas();
        //设置监听
        setListers();
    }

    private void setListers() {
        HomeMenu.setOnClickListener(this);
        PostMenu.setOnClickListener(this);
        EventMenu.setOnClickListener(this);
        ShowMenu.setOnClickListener(this);
        UserMenu.setOnClickListener(this);
    }

    private void initDatas() {
        menu = new ArrayList<>();
        menu.add(HomeMenu);
        menu.add(EventMenu);
        menu.add(PostMenu);
        menu.add(ShowMenu);
        menu.add(UserMenu);
        fragmentList = new ArrayList<Fragment>();
        homeFragment = new HomeFragment();
        eventFragment = new EventFragment();
        postFragment = new PostFragment();
        showFragment = new ShowFragment();
        userFragment = new UserFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(eventFragment);
        fragmentList.add(postFragment);
        fragmentList.add(showFragment);
        fragmentList.add(userFragment);

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragmentList);

        fixViewPager.setAdapter(mainPagerAdapter);
        fixViewPager.setOffscreenPageLimit(fragmentList.size() - 1);
        fixViewPager.setCurrentItem(currentItem);

        fixViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0;i<fragmentList.size();i++){
                    if (i == position){
                        menu.get(position).setImageResource(imgs[position]);
                    }else{
                        menu.get(i).setImageResource(imgs2[i]);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_main_menu_1:
//                menu.get(0).setImageResource(imgs[0]);
//                fixViewPager.setCurrentItem(0,true);
//                for (int i = 1;i<menu.size();i++){
//                    menu.get(i).setImageResource(imgs2[i]);
//                }
                currentItem = 0;
                initStatus(currentItem);
                fixViewPager.setCurrentItem(currentItem,true);
                break;
            case R.id.iv_main_menu_2:
//                menu.get(1).setImageResource(imgs[1]);
//                fixViewPager.setCurrentItem(1,true);
//                int a;
//                for (a = 0;a<menu.size();a++){
//                    if(a != 1){
//                        menu.get(a).setImageResource(imgs2[a]);
//                    }
//                }
                currentItem = 1;
                initStatus(currentItem);
                fixViewPager.setCurrentItem(currentItem,true);
                break;
            case R.id.iv_main_menu_3:
//                menu.get(2).setImageResource(imgs[2]);
//                fixViewPager.setCurrentItem(2, true);
//                int j;
//                for (j = 0;j<menu.size();j++){
//                    if (j != 2){
//                        menu.get(j).setImageResource(imgs2[j]);
//                    }
//                }
                currentItem = 2;
                initStatus(currentItem);
                fixViewPager.setCurrentItem(currentItem,true);
                break;
            case R.id.iv_main_menu_4:
//                menu.get(3).setImageResource(imgs[3]);
//                fixViewPager.setCurrentItem(3, true);
//                int h;
//                for (h = 0;h<menu.size();h++){
//                    if (h != 3){
//                        menu.get(h).setImageResource(imgs2[h]);
//                    }
//                }
                currentItem = 3;
                initStatus(currentItem);
                fixViewPager.setCurrentItem(currentItem,true);
                break;
            case R.id.iv_main_menu_5:
//                menu.get(4).setImageResource(imgs[4]);
//                fixViewPager.setCurrentItem(4, true);
//                int g;
//                for (g = 0;g<menu.size();g++){
//                    if (g != 4){
//                        menu.get(g).setImageResource(imgs2[g]);
//                    }
//                }
                currentItem = 4;
                initStatus(currentItem);
                fixViewPager.setCurrentItem(currentItem,true);
                break;
            default:
                break;
        }
    }

    /**
     * 初始化按钮图片
     * @param index
     */
    private void initStatus(int index){
        int[]select = {R.mipmap.main_menu_1_sel,R.mipmap.main_menu_2_sel,R.mipmap.main_menu_3_sel,R.mipmap.main_menu_4_sel,R.mipmap.main_menu_5_sel};
        int[] defaut ={R.mipmap.main_menu_1,R.mipmap.main_menu_2,R.mipmap.main_menu_3,R.mipmap.main_menu_4,R.mipmap.main_menu_5};
        for (int i = 0;i<5;i++){
            if (i == index){
                menu.get(i).setImageResource(select[i]);
            }else{
                menu.get(i).setImageResource(defaut[i]);
            }
        }
    }
}
