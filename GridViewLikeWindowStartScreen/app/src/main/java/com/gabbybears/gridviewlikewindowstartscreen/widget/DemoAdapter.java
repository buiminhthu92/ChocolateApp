package com.gabbybears.gridviewlikewindowstartscreen.widget;

import android.widget.ListAdapter;


import com.gabbybears.gridviewlikewindowstartscreen.model.DemoItem;

import java.util.List;

public interface DemoAdapter extends ListAdapter {

    void appendItems(List<DemoItem> newItems);

    void setItems(List<DemoItem> moreItems);
}

