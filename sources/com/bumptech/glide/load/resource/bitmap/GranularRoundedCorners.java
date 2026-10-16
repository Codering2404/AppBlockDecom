package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GranularRoundedCorners extends BitmapTransformation {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f66871f = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners".getBytes(Key.f66253a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f66872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f66873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f66874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f66875e;

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(f66871f);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f66872b).putFloat(this.f66873c).putFloat(this.f66874d).putFloat(this.f66875e).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i3, int i4) {
        return TransformationUtils.p(bitmapPool, bitmap, this.f66872b, this.f66873c, this.f66874d, this.f66875e);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GranularRoundedCorners) {
            GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
            if (this.f66872b == granularRoundedCorners.f66872b && this.f66873c == granularRoundedCorners.f66873c && this.f66874d == granularRoundedCorners.f66874d && this.f66875e == granularRoundedCorners.f66875e) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.n(this.f66875e, Util.n(this.f66874d, Util.n(this.f66873c, Util.p(-2013597734, Util.m(this.f66872b)))));
    }
}
