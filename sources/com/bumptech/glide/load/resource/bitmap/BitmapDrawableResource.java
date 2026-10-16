package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapPool f66820b;

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
        this.f66820b.c(((BitmapDrawable) this.f66954a).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.i(((BitmapDrawable) this.f66954a).getBitmap());
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((BitmapDrawable) this.f66954a).getBitmap().prepareToDraw();
    }
}
