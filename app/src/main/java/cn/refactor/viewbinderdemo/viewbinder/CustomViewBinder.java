package cn.refactor.viewbinderdemo.viewbinder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.refactor.viewbinder.ViewBinder;
import cn.refactor.viewbinderdemo.ArgumentKeys;
import cn.refactor.viewbinderdemo.Entity;
import cn.refactor.viewbinderdemo.R;


/**
 * Created by andy (https://github.com/andyxialm)
 * Creation time: 17/8/17 00:12
 * Description: CustomViewBinder
 */
public class CustomViewBinder extends ViewBinder<Entity> {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onViewCreated(@NonNull View view) {
        textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);
    }

    @Override
    protected void onDataBinding(@NonNull View view, Entity data) {
        imageView.setImageResource(data.getIcon());

        if (getArguments() != null) {
            textView.setText(getArguments().getString(ArgumentKeys.KEY_CUSTOM));
        } else {
            textView.setText(data.getText());
        }
    }

}
