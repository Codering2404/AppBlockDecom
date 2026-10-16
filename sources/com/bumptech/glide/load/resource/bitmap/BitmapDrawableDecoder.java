package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ResourceDecoder f66816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f66817b;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder resourceDecoder) {
        this.f66817b = (Resources) Preconditions.e(resources);
        this.f66816a = (ResourceDecoder) Preconditions.e(resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Object obj, Options options) {
        return this.f66816a.a(obj, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource b(Object obj, int i3, int i4, Options options) {
        return LazyBitmapDrawableResource.d(this.f66817b, this.f66816a.b(obj, i3, i4, options));
    }
}
