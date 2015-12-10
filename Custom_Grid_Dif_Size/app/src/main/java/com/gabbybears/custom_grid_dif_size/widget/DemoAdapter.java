package com.gabbybears.custom_grid_dif_size.widget;

import android.widget.ListAdapter;


import com.gabbybears.custom_grid_dif_size.model.DemoItem;

import java.util.List;

public interface DemoAdapter extends ListAdapter {

    void appendItems(List<DemoItem> newItems);

    void setItems(List<DemoItem> moreItems);
}
