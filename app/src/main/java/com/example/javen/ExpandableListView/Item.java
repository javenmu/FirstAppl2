package com.example.javen.ExpandableListView;

/**
 * Created by Administrator on 2015/10/28.
 */
public class Item {
    private int iId;
    private String iName;

    public Item(int id, String name) {
        iId = id;
        iName = name;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
