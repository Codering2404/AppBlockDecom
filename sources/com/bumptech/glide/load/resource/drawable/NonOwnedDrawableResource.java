package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    static Resource d(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return this.f66954a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Math.max(1, this.f66954a.getIntrinsicWidth() * this.f66954a.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
    }
}
