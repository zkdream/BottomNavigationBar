package com.zk.bottomnavigationbar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zk.bottomnavigationbar.bottom.BottomTabItem;

/**
 * @author Created by zhangke
 * @filename MainBottomTabItem
 * @date on 2017\12\4 0004 19:02
 * @email 206357792@qq.com
 * @describe 项目中自己用的BottomTabItem,这个类要自己去写 呜呜
 */

public class MainBottomTabItem extends BottomTabItem{
    private Builder builder;

    private MainBottomTabItem(Context context) {
        super(R.layout.tab_main_bottom_item, context);
    }

    private MainBottomTabItem(Builder builder) {
        this(builder.context);
        this.builder = builder;
    }

    @Override
    protected void initLayout() {

        TextView tabText=findViewById(R.id.tab_text);
//        TextView tabMsgNum=findViewById(R.id.tab_unread_number);
        ImageView tabIcon=findViewById(R.id.tab_icon);

        if (!TextUtils.isEmpty(builder.text)){
            tabText.setText(builder.text);
        }

        if (builder.resIconId!=0){
            tabIcon.setImageResource(builder.resIconId);
        }

//        if (!TextUtils.isEmpty(builder.msgNum)){
//            tabMsgNum.setVisibility(View.VISIBLE);
//            tabMsgNum.setText(builder.msgNum);
//        }else {
//            tabMsgNum.setVisibility(View.GONE);
//        }


    }

    @Override
    protected void setSelected(boolean selected) {
        TextView tabText = findViewById(R.id.tab_text);
        ImageView tabIcon = findViewById(R.id.tab_icon);

        tabText.setSelected(selected);
        tabIcon.setSelected(selected);

    }

    public static class Builder{
        Context context;
        String text;
        int resIconId;
        String msgNum;

        public Builder(Context context) {
            this.context = context;
        }
        public Builder text(String text){
            this.text=text;
            return this;
        }

        public Builder resIcon(int resIconId){
            this.resIconId=resIconId;
            return this;
        }

        public Builder msgNum(String msgNum){
            this.msgNum=msgNum;
            return this;
        }

         public MainBottomTabItem create(){
            return new MainBottomTabItem(this);
         }
    }
}
