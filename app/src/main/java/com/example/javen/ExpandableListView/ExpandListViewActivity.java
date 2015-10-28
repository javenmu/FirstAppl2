package com.example.javen.ExpandableListView;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.javen.firstappl.R;

import java.util.ArrayList;

public class ExpandListViewActivity extends AppCompatActivity {
    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list_view);

        mContext = ExpandListViewActivity.this;
        exlist_lol = (ExpandableListView) findViewById(R.id.exListView);

        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("AD"));
        gData.add(new Group("AP"));
        gData.add(new Group("TANK"));

        lData = new ArrayList<Item>();

        //AD组
        lData.add(new Item(R.mipmap.head_icon1,"剑圣"));
        lData.add(new Item(R.mipmap.head_icon2,"德莱文"));
        lData.add(new Item(R.mipmap.head_icon3,"男枪"));
        lData.add(new Item(R.mipmap.head_icon2,"韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.head_icon1, "提莫"));
        lData.add(new Item(R.mipmap.head_icon3, "安妮"));
        lData.add(new Item(R.mipmap.head_icon2, "天使"));
        lData.add(new Item(R.mipmap.head_icon1, "泽拉斯"));
        lData.add(new Item(R.mipmap.head_icon3, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<Item>();
        lData.add(new Item(R.mipmap.head_icon2, "诺手"));
        lData.add(new Item(R.mipmap.head_icon1, "德邦"));
        lData.add(new Item(R.mipmap.head_icon2, "奥拉夫"));
        lData.add(new Item(R.mipmap.head_icon3, "龙女"));
        lData.add(new Item(R.mipmap.head_icon1, "狗熊"));
        iData.add(lData);

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);

        //为列表设置点击事件
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expand_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
