package com.wayhua.lrh2.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wayhua.lrh2.R;


public final class ImageBindingAdapter {

    @BindingAdapter(value = "url")
    public static void loadImageUrl(ImageView view, String url) {
        if (url != null && !url.equals(""))
            Glide.with(view.getContext())
                    .load( url)
                    .placeholder(R.drawable.placeholder)
                    .into(view);
    }

}
