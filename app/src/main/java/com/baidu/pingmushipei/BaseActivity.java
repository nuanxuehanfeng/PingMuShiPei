package com.baidu.pingmushipei;

import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.WindowManager;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    //横竖屏的切换等Configuration变化会导致更新Resources，需要重新处理一下
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();
    }
    public final static float DESIGN_WIDTH = 750;
    //更改DisplayMetrics为我们想要的与屏幕宽度相关的比例
    public void resetDensity(){
        Point size = new Point();
        ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x/DESIGN_WIDTH*72f;
    }
    //将pt转换为px值
    public float pt2px(int value){
        //TypedValue.applyDimension时注意传入的DisplayMetrics是改过之后的。或者不用这个方法自己来计算。
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, value, getResources().getDisplayMetrics());
    }




}
