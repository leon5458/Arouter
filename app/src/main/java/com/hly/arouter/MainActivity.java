package com.hly.arouter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import hly.com.arount_hp.HpFragment;
import hly.com.arount_me.MeFragment;
import hly.com.arount_news.NewsFragment;
import hly.com.arount_set.SetFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private HpFragment hpFragment = (HpFragment) ARouter.getInstance().build("/hp/hpfragment").navigation();
   private MeFragment meFragment = (MeFragment) ARouter.getInstance().build("/me/mefragment").navigation();
   private NewsFragment newsFragment = (NewsFragment) ARouter.getInstance().build("/news/newsfragment").navigation();
   private SetFragment setFragment = (SetFragment) ARouter.getInstance().build("/set/setfragment").navigation();

//    HpFragment hpFragment ;
//    MeFragment meFragment ;
//    NewsFragment newsFragment ;
//    SetFragment setFragment ;
    private View hp_layout;
    private View service_layout;
    private View action_layout;
    private View myself_layout;

    private ImageView hpImage;
    private ImageView serviceImage;
    private ImageView actionImage;
    private ImageView myselfImage;


    private TextView hpText;
    private TextView serviceText;
    private TextView actionText;
    private TextView myselfText;

    private FragmentManager fragmentManager;//对fragment的管理

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);//第一次启动默认的tab(0)

    }

    private void initview() {
        hp_layout = findViewById(R.id.hp_bottom_layout);
        hpImage = findViewById(R.id.hp_bottom_image);
        hpText = findViewById(R.id.hp_bottom_text);

        service_layout = findViewById(R.id.service_bottom_layout);
        serviceImage = findViewById(R.id.service_bottom_image);
        serviceText = findViewById(R.id.service_bottom_text);

        action_layout = findViewById(R.id.action_bottom_layout);
        actionImage = findViewById(R.id.action_bottom_image);
        actionText = findViewById(R.id.action_bottom_text);

        myself_layout = findViewById(R.id.myself_bottom_layout);
        myselfImage = findViewById(R.id.myself_bottom_image);
        myselfText = findViewById(R.id.myself_bottom_text);

        hp_layout.setOnClickListener(this);
        service_layout.setOnClickListener(this);
        action_layout.setOnClickListener(this);
        myself_layout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hp_bottom_layout:
                setTabSelection(0);
                break;
            case R.id.service_bottom_layout:
                setTabSelection(1);
                break;
            case R.id.action_bottom_layout:
                setTabSelection(2);
                break;
            case R.id.myself_bottom_layout:
                setTabSelection(3);
                break;
        }

    }

    public void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        clearSelection();//每次选中之前清除掉上次选中的状态
        hideFragments(transaction);
        switch (index) {
            case 0:
                hpImage.setImageResource(R.mipmap.tab_contact_select);
                hpText.setTextColor(Color.parseColor("#293754"));
                hp_layout.setBackgroundColor(0xffDFE1E6);
                if (hpFragment == null) {
                    hpFragment = new HpFragment();
                    transaction.add(R.id.content, hpFragment);
                } else {
                    transaction.show(hpFragment);
                }
                break;
            case 1:
                serviceImage.setImageResource(R.mipmap.tab_home_select);
                serviceText.setTextColor(Color.parseColor("#293754"));
                service_layout.setBackgroundColor(0xffDFE1E6);
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case 2:
                actionImage.setImageResource(R.mipmap.tab_more_select);
                actionText.setTextColor(Color.parseColor("#293754"));
                action_layout.setBackgroundColor(0xffDFE1E6);
                if (setFragment == null) {
                    setFragment = new SetFragment();
                    transaction.add(R.id.content, setFragment);
                } else {
                    transaction.show(setFragment);
                }
                break;

            case 3:
                myselfImage.setImageResource(R.mipmap.tab_speech_select);
                myselfText.setTextColor(Color.parseColor("#293754"));
                myself_layout.setBackgroundColor(0xffDFE1E6);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 清除所有选中的状态
     */
    private void clearSelection() {
        hpImage.setImageResource(R.mipmap.tab_contact_unselect);
        hpText.setTextColor(Color.parseColor("#82858b"));
        hp_layout.setBackgroundColor(0xffffffff);
        serviceImage.setImageResource(R.mipmap.tab_home_unselect);
        serviceText.setTextColor(Color.parseColor("#82858b"));
        service_layout.setBackgroundColor(0xffffffff);
        actionImage.setImageResource(R.mipmap.tab_more_unselect);
        actionText.setTextColor(Color.parseColor("#82858b"));
        action_layout.setBackgroundColor(0xffffffff);
        myselfImage.setImageResource(R.mipmap.tab_speech_unselect);
        myselfText.setTextColor(Color.parseColor("#82858b"));
        myself_layout.setBackgroundColor(0xffffffff);
    }

    /**
     * 将所有的Fragment设置隐藏状态,用于对Fragment执行操作的事务
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (hpFragment != null) {
            transaction.hide(hpFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (setFragment != null) {
            transaction.hide(setFragment);
        }
    }


}
