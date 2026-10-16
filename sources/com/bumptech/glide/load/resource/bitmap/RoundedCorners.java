package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RoundedCorners extends BitmapTransformation {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f66913c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Key.f66253a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f66914b;

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f66913c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f66914b).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        return TransformationUtils.q(bitmapPool, bitmap, this.f66914b);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.f66914b == ((RoundedCorners) obj).f66914b;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.p(-569625254, Util.o(this.f66914b));
    }
}
