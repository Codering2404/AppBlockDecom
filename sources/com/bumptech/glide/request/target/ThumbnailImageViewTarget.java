package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void s(Object obj) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f67225b).getLayoutParams();
        Drawable drawableU = u(obj);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawableU = new FixedSizeDrawable(drawableU, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f67225b).setImageDrawable(drawableU);
    }

    protected abstract Drawable u(Object obj);
}
