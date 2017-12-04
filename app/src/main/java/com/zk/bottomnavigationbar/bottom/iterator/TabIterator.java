package com.zk.bottomnavigationbar.bottom.iterator;

import com.zk.bottomnavigationbar.bottom.BottomTabItem;

/**
 * @author Created by zhangke
 * @filename TabIterator
 * @date on 2017\12\4 0004 18:01
 * @email 206357792@qq.com
 * @describe 迭代器模式定义标准接口
 */

public interface TabIterator<M extends BottomTabItem> {

    BottomTabItem next();

    boolean hasNext();
}
