package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f66826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapPool f66827b;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.f66826a = (Bitmap) Preconditions.f(bitmap, "Bitmap must not be null");
        this.f66827b = (BitmapPool) Preconditions.f(bitmapPool, "BitmapPool must not be null");
    }

    public static BitmapResource d(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
        this.f66827b.c(this.f66826a);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f66826a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.i(this.f66826a);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.f66826a.prepareToDraw();
    }
}
