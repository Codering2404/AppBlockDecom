package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FitCenter extends BitmapTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f66868b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(Key.f66253a);

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f66868b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        return TransformationUtils.f(bitmapPool, bitmap, i3, i4);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1572326941;
    }
}
