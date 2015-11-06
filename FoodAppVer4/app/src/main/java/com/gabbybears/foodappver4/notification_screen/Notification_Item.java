package com.gabbybears.foodappver4.notification_screen;

/**
 * Created by Android on 10/31/2015.
 */
public class Notification_Item {
    private int avar_User_NoticeItem;
    private String name_User_NoticeItem;
    private String name_Of_NoticeItem;
    private int state_Read_NoticeItem;
    private String time_Post_NoticeItem;

    public Notification_Item(int avar_User_NoticeItem, String name_User_NoticeItem,
                             String name_Of_NoticeItem, int state_Read_NoticeItem, String time_Post_NoticeItem) {
        this.avar_User_NoticeItem = avar_User_NoticeItem;
        this.name_User_NoticeItem = name_User_NoticeItem;
        this.name_Of_NoticeItem = name_Of_NoticeItem;
        this.state_Read_NoticeItem = state_Read_NoticeItem;
        this.time_Post_NoticeItem = time_Post_NoticeItem;
    }

    public int getAvar_User_NoticeItem() {
        return avar_User_NoticeItem;
    }

    public void setAvar_User_NoticeItem(int avar_User_NoticeItem) {
        this.avar_User_NoticeItem = avar_User_NoticeItem;
    }

    public String getName_User_NoticeItem() {
        return name_User_NoticeItem;
    }

    public void setName_User_NoticeItem(String name_User_NoticeItem) {
        this.name_User_NoticeItem = name_User_NoticeItem;
    }

    public String getName_Of_NoticeItem() {
        return name_Of_NoticeItem;
    }

    public void setName_Of_NoticeItem(String name_Of_NoticeItem) {
        this.name_Of_NoticeItem = name_Of_NoticeItem;
    }

    public int getState_Read_NoticeItem() {
        return state_Read_NoticeItem;
    }

    public void setState_Read_NoticeItem(int state_Read_NoticeItem) {
        this.state_Read_NoticeItem = state_Read_NoticeItem;
    }

    public String getTime_Post_NoticeItem() {
        return time_Post_NoticeItem;
    }

    public void setTime_Post_NoticeItem(String time_Post_NoticeItem) {
        this.time_Post_NoticeItem = time_Post_NoticeItem;
    }
}
