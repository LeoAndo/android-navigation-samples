package com.example.navigationjavasample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;


public class ProgressIndicatorLayout extends FrameLayout {

    public  ProgressIndicatorLayout(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }
    public  ProgressIndicatorLayout(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_progress_indicator, this);
        // 初期値は非表示
        hide();
        // android:clickable="true" にすることで裏側のコンテンツに触れさせない
        setClickable(true);

        final TypedValue typedValue = new TypedValue();
        final boolean isFoundedAttribute =
                getContext().getTheme().resolveAttribute(
                        R.attr.scrimBackground, typedValue, true
                );

        if (isFoundedAttribute) {
            // foreground = AppCompatResources.getDrawable(context, typedValue.resourceId)
            setBackgroundResource(typedValue.resourceId);
        }
    }

    public void show() {
        this.setVisibility(View.VISIBLE);
    }

    public void hide() {
        this.setVisibility(View.GONE);
    }
}
