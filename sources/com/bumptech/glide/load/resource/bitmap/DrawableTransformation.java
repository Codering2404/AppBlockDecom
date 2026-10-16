package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transformation f66866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f66867c;

    public DrawableTransformation(Transformation transformation, boolean z2) {
        this.f66866b = transformation;
        this.f66867c = z2;
    }

    private Resource d(Context context, Resource resource) {
        return LazyBitmapDrawableResource.d(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource a(Context context, Resource resource, int i3, int i4) {
        BitmapPool bitmapPoolF = Glide.c(context).f();
        Drawable drawable = (Drawable) resource.get();
        Resource resourceA = DrawableToBitmapConverter.a(bitmapPoolF, drawable, i3, i4);
        if (resourceA != null) {
            Resource resourceA2 = this.f66866b.a(context, resourceA, i3, i4);
            if (!resourceA2.equals(resourceA)) {
                return d(context, resourceA2);
            }
            resourceA2.a();
            return resource;
        }
        if (!this.f66867c) {
            return resource;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        this.f66866b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f66866b.equals(((DrawableTransformation) obj).f66866b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f66866b.hashCode();
    }

    public Transformation c() {
        return this;
    }
}
