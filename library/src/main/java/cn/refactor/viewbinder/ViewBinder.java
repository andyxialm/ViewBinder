/*
  Copyright 2017 andy (https://github.com/andyxialm)
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package cn.refactor.viewbinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by andy (https://github.com/andyxialm)
 * Creation time: 17/8/16 23:18
 * Description: View Binder
 */
public abstract class ViewBinder<T> {

    private T mData;
    private View mView;
    private Context mContext;

    public View inflate(Context context, int resource, ViewGroup root) {
        return onCreateView(LayoutInflater.from(context).inflate(resource, root));
    }

    public View inflate(Context context, XmlPullParser parser, ViewGroup root) {
        return onCreateView(LayoutInflater.from(context).inflate(parser, root));
    }

    public View inflate(Context context, int resource, ViewGroup root, boolean attachToRoot) {
        return onCreateView(LayoutInflater.from(context).inflate(resource, root, attachToRoot));
    }

    public View inflate(Context context, XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        return onCreateView(LayoutInflater.from(context).inflate(parser, root, attachToRoot));
    }

    public void attachView(@NonNull View view) {
        onCreateView(view);
    }

    public View getView() {
        return mView;
    }

    public void setData(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }

    public void notifyDataSetChanged() {
        if (mView != null) {
            onDataBinding(mView, mData);
        }
    }

    protected Context getContext() {
        return mContext;
    }

    private View onCreateView(@NonNull View view) {
        mView = view;
        mContext = view.getContext();
        onViewCreated(mView);
        return view;
    }

    protected abstract void onViewCreated(@NonNull View view);
    protected abstract void onDataBinding(@NonNull View view, T data);
}
