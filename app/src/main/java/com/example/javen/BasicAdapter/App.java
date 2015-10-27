package com.example.javen.BasicAdapter;

/**
 * Created by Administrator on 2015/10/27.
 */
public class App {
    private String aName;
    private int aIcon;

    public App(int id, String name) {
        aIcon = id;
        aName = name;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }
}
