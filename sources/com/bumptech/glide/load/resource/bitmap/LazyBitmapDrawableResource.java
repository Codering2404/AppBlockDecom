package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f66900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resource f66901b;

    private LazyBitmapDrawableResource(Resources resources, Resource resource) {
        this.f66900a = (Resources) Preconditions.e(resources);
        this.f66901b = (Resource) Preconditions.e(resource);
    }

    public static Resource d(Resources resources, Resource resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void a() {
        this.f66901b.a();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f66900a, (Bitmap) this.f66901b.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f66901b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource resource = this.f66901b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }
}
