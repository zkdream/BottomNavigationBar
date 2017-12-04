package com.zk.bottomnavigationbar.bottom.iterator;

import com.zk.bottomnavigationbar.bottom.BottomTabItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by zhangke
 * @filename TabListIterator
 * @date on 2017\12\4 0004 18:05
 * @email 206357792@qq.com
 * @describe 迭代器具体的实现类
 */

public class TabListIterator<T extends BottomTabItem> implements TabIterator<BottomTabItem> {
    private List<T> mTabItems;
    private int index;

    public TabListIterator() {
        this.mTabItems = new ArrayList<>();
    }


    public void addItem(T item){
        mTabItems.add(item);
    }
    @Override
    public BottomTabItem next() {
        return mTabItems.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<mTabItems.size();
    }
}
