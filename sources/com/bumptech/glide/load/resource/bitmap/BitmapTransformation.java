package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    @Override // com.bumptech.glide.load.Transformation
    public final Resource a(Context context, Resource resource, int i3, int i4) {
        if (!Util.v(i3, i4)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i3 + " or height: " + i4 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool bitmapPoolF = Glide.c(context).f();
        Bitmap bitmap = (Bitmap) resource.get();
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getWidth();
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(bitmapPoolF, bitmap, i3, i4);
        return bitmap.equals(bitmapC) ? resource : BitmapResource.d(bitmapC, bitmapPoolF);
    }

    protected abstract Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4);
}
