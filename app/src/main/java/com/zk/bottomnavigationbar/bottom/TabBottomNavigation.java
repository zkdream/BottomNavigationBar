package com.zk.bottomnavigationbar.bottom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.zk.bottomnavigationbar.bottom.iterator.TabIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by zhangke
 * @filename TabBottomNavigation
 * @date on 2017\12\4 0004 18:00
 * @email 206357792@qq.com
 * @describe 底部导航栏
 */

public class TabBottomNavigation extends LinearLayout{

    private List<BottomTabItem> mTabItems;
    private int mCurrentIndex=-1;

    public TabBottomNavigation(Context context) {
        this(context,null);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        mTabItems=new ArrayList<>();
    }

    public void setTabIterator(TabIterator<BottomTabItem> tabIterator){
        mTabItems.clear();
//        当前位置
        int index=0;
        while (tabIterator.hasNext()){
            BottomTabItem tabItem=tabIterator.next();
            View tabView=tabItem.getTabView();
            addView(tabView);

            LayoutParams params= (LayoutParams) tabView.getLayoutParams();
            params.weight=1;
            params.gravity= Gravity.CENTER;
            tabView.setLayoutParams(params);
//        给每个条目设置点击事件
            setItemClickListener(tabView,index++);

            mTabItems.add(tabItem);
        }
//        第一个位置设置为选中
        mTabItems.get(0).setSelected(true);
        mCurrentIndex=0;

    }

    private void setItemClickListener(View tabView, final int position) {
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex!=position){
                   //   原来的标为非选中
                    mTabItems.get(mCurrentIndex).setSelected(false);
                    mCurrentIndex=position;
                    mTabItems.get(mCurrentIndex).setSelected(true);
//                    把点击事件用接口回调回去
                    if (mBottomClickListener!=null){
                        mBottomClickListener.click(mCurrentIndex);
                    }
                }
            }
        });
    }


    private TabBottomClickListener mBottomClickListener;

    public void setOnTabBottomClickListener(TabBottomClickListener bottomClickListener){
        this.mBottomClickListener=bottomClickListener;
    }

    public interface TabBottomClickListener{
        void click(int position);
    }
}
