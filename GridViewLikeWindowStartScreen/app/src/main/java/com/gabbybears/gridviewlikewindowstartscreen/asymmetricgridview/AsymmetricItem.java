package com.gabbybears.gridviewlikewindowstartscreen.asymmetricgridview;

import android.os.Parcelable;

public interface AsymmetricItem extends Parcelable {
    int getColumnSpan();
    int getRowSpan();
}

