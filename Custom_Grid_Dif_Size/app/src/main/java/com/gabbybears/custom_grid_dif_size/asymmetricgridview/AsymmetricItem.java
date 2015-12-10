package com.gabbybears.custom_grid_dif_size.asymmetricgridview;

import android.os.Parcelable;

public interface AsymmetricItem extends Parcelable {
    int getColumnSpan();
    int getRowSpan();
}

