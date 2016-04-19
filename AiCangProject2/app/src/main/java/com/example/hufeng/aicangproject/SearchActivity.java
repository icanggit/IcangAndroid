package com.example.hufeng.aicangproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hufeng.com.example.hufeng.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.next.tagview.TagCloudView;

/**
 * Created by hufeng on 2016/3/30.
 */
public class SearchActivity extends Activity implements TagCloudView.OnTagClickListener{
    @Bind(R.id.tag_cloud_view)//热门标签控件
    TagCloudView tagCloudView;
    @Bind(R.id.tv_cancle)//搜索取消按钮
    TextView tvCancle;
    @Bind(R.id.lv_search_history)
    ListView lvSearchHistory;
    @Bind(R.id.ll_delete_history)
    LinearLayout llDeleteHistory;
    private List<String> tags;//存放热门标签的集合
    private List<String> history;//存放历史搜索标签的集合
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        tags = new ArrayList<>();
        tags.add("漫画");
        tags.add("动漫");
        tags.add("电玩");
        tags.add("手游");
        tags.add("女优");
        tags.add("娃娃");
        tags.add("苹果");
        tags.add("微信");
        tagCloudView.setTags(tags);
        tagCloudView.setOnTagClickListener(this);
        history = new ArrayList<>();
        history.add("女忧");
        history.add("娃娃");
        history.add("动漫");
        history.add("手游");
        history.add("漫画");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,history);
        lvSearchHistory.setAdapter((ListAdapter) adapter);

        setListeners();
    }

    private void setListeners() {
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        llDeleteHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0;i<history.size();i++){
                    history.remove(i);
                }
            }
        });
    }

    @Override
    public void onTagClick(int position) {
        UIHelper.ToastShow(getApplicationContext(),tags.get(position)+"---被点击了");
    }
}
