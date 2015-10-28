package com.example.javen.ViewFlipper;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.javen.firstappl.R;

public class DynamicFlipperActivity extends AppCompatActivity {
    private Context mContext;
    private ViewFlipper vflp_beauty;
    private int[] resId = {R.mipmap.beauty_1,R.mipmap.beauty_2,
            R.mipmap.beauty_3,R.mipmap.beauty_4};

    private final static int MIN_MOVE = 200;   //最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_flipper);

        mContext = DynamicFlipperActivity.this;
        //实例化SimpleOnGestureListener与GestureDetector对象
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);
        vflp_beauty = (ViewFlipper) findViewById(R.id.viewFlipper_dynamic);
        //动态导入添加子View
        for(int i = 0;i < resId.length;i++){
            vflp_beauty.addView(getImageView(resId[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dynamic_flipper, menu);
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

    //重写onTouchEvent触发MyGestureListener里的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    //自定义一个GestureListener,这个是View类下的，别写错哦！！！
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if(e1.getX() - e2.getX() > MIN_MOVE){
                vflp_beauty.setInAnimation(mContext,R.anim.right_in);
                vflp_beauty.setOutAnimation(mContext, R.anim.right_out);
                vflp_beauty.showNext();
            }else if(e2.getX() - e1.getX() > MIN_MOVE){
                vflp_beauty.setInAnimation(mContext,R.anim.left_in);
                vflp_beauty.setOutAnimation(mContext, R.anim.left_out);
                vflp_beauty.showPrevious();
            }
            return true;
        }
    }

    private ImageView getImageView(int resId){
        ImageView img = new ImageView(this);
        img.setBackgroundResource(resId);
        return img;
    }
}
