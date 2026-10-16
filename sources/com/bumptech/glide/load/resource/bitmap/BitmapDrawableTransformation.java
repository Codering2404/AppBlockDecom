package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Transformation f66821b;

    private static Resource c(Resource resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource a(Context context, Resource resource, int i3, int i4) {
        return c(this.f66821b.a(context, d(resource), i3, i4));
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        this.f66821b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.f66821b.equals(((BitmapDrawableTransformation) obj).f66821b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f66821b.hashCode();
    }

    private static Resource d(Resource resource) {
        return resource;
    }
}
