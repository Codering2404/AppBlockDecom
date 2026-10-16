package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Drawable u(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f67225b).getResources(), bitmap);
    }
}
