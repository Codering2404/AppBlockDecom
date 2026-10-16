package com.bumptech.glide.load.resource.transcode;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapPool f67013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ResourceTranscoder f67014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ResourceTranscoder f67015c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder resourceTranscoder, ResourceTranscoder resourceTranscoder2) {
        this.f67013a = bitmapPool;
        this.f67014b = resourceTranscoder;
        this.f67015c = resourceTranscoder2;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource a(Resource resource, Options options) {
        Drawable drawable = (Drawable) resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f67014b.a(BitmapResource.d(((BitmapDrawable) drawable).getBitmap(), this.f67013a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f67015c.a(b(resource), options);
        }
        return null;
    }

    private static Resource b(Resource resource) {
        return resource;
    }
}
