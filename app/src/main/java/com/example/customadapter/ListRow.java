package com.example.customadapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListRow {
    public ListRow(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ImageView imageView = new ImageView(context);
        TextView textView = new TextView(context);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
    }
}
