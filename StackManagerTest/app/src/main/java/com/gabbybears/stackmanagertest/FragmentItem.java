package com.gabbybears.stackmanagertest;

import android.support.v4.app.Fragment;

/**
 * Created by Android on 10/30/2015.
 */
public class FragmentItem {
    private Fragment fragmentItem;

    public FragmentItem(Fragment fragmentItem) {
        this.fragmentItem = fragmentItem;
    }

    public Fragment getFragmentItem() {
        return fragmentItem;
    }

    public void setFragmentItem(Fragment fragmentItem) {
        this.fragmentItem = fragmentItem;
    }
}
