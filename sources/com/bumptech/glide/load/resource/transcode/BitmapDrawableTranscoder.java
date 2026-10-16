package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f67012a;

    public BitmapDrawableTranscoder(Resources resources) {
        this.f67012a = (Resources) Preconditions.e(resources);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource a(Resource resource, Options options) {
        return LazyBitmapDrawableResource.d(this.f67012a, resource);
    }
}
