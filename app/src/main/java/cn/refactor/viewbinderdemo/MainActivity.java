package cn.refactor.viewbinderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import cn.refactor.viewbinderdemo.viewbinder.CustomSetViewBinder;
import cn.refactor.viewbinderdemo.viewbinder.CustomViewBinder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);
        CustomViewBinder roundViewBinder = new CustomViewBinder();
        container.addView(roundViewBinder.inflate(this, R.layout.layout_custom, null));
        roundViewBinder.setData(new Entity(R.mipmap.ic_launcher_round, R.string.app_name));
        roundViewBinder.notifyDataSetChanged();

        CustomViewBinder rectViewBinder = new CustomViewBinder();
        container.addView(rectViewBinder.inflate(this, R.layout.layout_custom, null));
        rectViewBinder.setData(new Entity(R.mipmap.ic_launcher, R.string.sample_image_view));
        rectViewBinder.notifyDataSetChanged();

        CustomSetViewBinder customSetViewBinder = new CustomSetViewBinder();
        customSetViewBinder.attachView(findViewById(R.id.custom_ll));
        customSetViewBinder.setData(new DataEntity());
        customSetViewBinder.notifyDataSetChanged();
    }
}
