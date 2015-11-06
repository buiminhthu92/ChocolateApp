package com.gabbybears.foodappver4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class TestActtivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_element_layout);

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.show_more_button_icon);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

        ImageView itemBtn1 = new ImageView(this);
        itemBtn1.setImageResource(R.drawable.show_more_button_icon);
        ImageView itemBtn2 = new ImageView(this);
        itemBtn1.setImageResource(R.drawable.show_more_button_icon);
        ImageView itemBtn3 = new ImageView(this);
        itemBtn1.setImageResource(R.drawable.show_more_button_icon);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        SubActionButton button1 = itemBuilder.setContentView(itemBtn1).build();
        SubActionButton button2 = itemBuilder.setContentView(itemBtn2).build();
        SubActionButton button3 = itemBuilder.setContentView(itemBtn3).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build();
    }
}
