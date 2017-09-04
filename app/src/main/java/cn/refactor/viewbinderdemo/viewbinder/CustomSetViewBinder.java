package cn.refactor.viewbinderdemo.viewbinder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.refactor.viewbinder.ViewBinder;
import cn.refactor.viewbinderdemo.DataEntity;
import cn.refactor.viewbinderdemo.R;


/**
 * Created by andy (https://github.com/andyxialm)
 * Creation time: 17/9/4 18:27
 * Description: CustomSetViewBinder
 */
public class CustomSetViewBinder extends ViewBinder<DataEntity> {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onViewCreated(@NonNull View view) {
        textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = getData().getCount();
                getData().setCount(++ count);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDataBinding(@NonNull View view, DataEntity data) {
        textView.setText(String.format("%s %s", getContext().getString(R.string.click_me), String.valueOf(data.getCount())));
        imageView.setImageResource(R.mipmap.ic_icecream);
    }

}
