package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Encoder f66332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f66333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Options f66334c;

    DataCacheWriter(Encoder encoder, Object obj, Options options) {
        this.f66332a = encoder;
        this.f66333b = obj;
        this.f66334c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean a(File file) {
        return this.f66332a.a(this.f66333b, file, this.f66334c);
    }
}
