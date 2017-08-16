package cn.refactor.viewbinderdemo;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by andy (https://github.com/andyxialm)
 * Creation time: 17/8/17 00:22
 * Description: Entity
 */
public class Entity {
    private @DrawableRes int icon;
    private @StringRes int text;

    public Entity(int icon, int text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }
}
