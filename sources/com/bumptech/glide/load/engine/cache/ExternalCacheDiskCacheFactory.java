package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f66600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f66601b;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            File externalCacheDir = this.f66600a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f66601b != null ? new File(externalCacheDir, this.f66601b) : externalCacheDir;
        }
    }
}
