package com.zk.bottomnavigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zk.bottomnavigationbar.bottom.TabBottomNavigation;
import com.zk.bottomnavigationbar.bottom.iterator.TabIterator;
import com.zk.bottomnavigationbar.bottom.iterator.TabListIterator;

public class MainActivity extends AppCompatActivity {


    private TabBottomNavigation mTabBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        mTabBottomNavigation=findViewById(R.id.tab_bottom_navigation);
        TabListIterator<MainBottomTabItem> tabIterator=new TabListIterator();
        tabIterator.addItem(new MainBottomTabItem.Builder(this).text("首页").resIcon(R.drawable.safely_school_image_selector).create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).text("消息").resIcon(R.drawable.message_image_selector).create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).text("通讯录").resIcon(R.drawable.contacts_image_selector).create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).text("我的").resIcon(R.drawable.setting_image_selector).create());

        mTabBottomNavigation.setTabIterator(tabIterator);
//        mTabBottomNavigation.setOnTabBottomClickListener(this);
    }
}
