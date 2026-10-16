package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ResourceDrawableDecoder f66909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapPool f66910b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f66909a = resourceDrawableDecoder;
        this.f66910b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(Uri uri, int i3, int i4, Options options) {
        Resource resourceB = this.f66909a.b(uri, i3, i4, options);
        if (resourceB == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.f66910b, (Drawable) resourceB.get(), i3, i4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
