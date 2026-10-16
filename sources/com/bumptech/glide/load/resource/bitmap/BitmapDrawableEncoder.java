package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitmapPool f66818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ResourceEncoder f66819b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder resourceEncoder) {
        this.f66818a = bitmapPool;
        this.f66819b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy b(Options options) {
        return this.f66819b.b(options);
    }

    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Resource resource, File file, Options options) {
        return this.f66819b.a(new BitmapResource(((BitmapDrawable) resource.get()).getBitmap(), this.f66818a), file, options);
    }
}
