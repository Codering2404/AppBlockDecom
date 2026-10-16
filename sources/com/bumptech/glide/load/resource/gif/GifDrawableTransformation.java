package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transformation f66979b;

    public GifDrawableTransformation(Transformation transformation) {
        this.f66979b = (Transformation) Preconditions.e(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource a(Context context, Resource resource, int i3, int i4) {
        GifDrawable gifDrawable = (GifDrawable) resource.get();
        Resource bitmapResource = new BitmapResource(gifDrawable.e(), Glide.c(context).f());
        Resource resourceA = this.f66979b.a(context, bitmapResource, i3, i4);
        if (!bitmapResource.equals(resourceA)) {
            bitmapResource.a();
        }
        gifDrawable.m(this.f66979b, (Bitmap) resourceA.get());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        this.f66979b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.f66979b.equals(((GifDrawableTransformation) obj).f66979b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f66979b.hashCode();
    }
}
