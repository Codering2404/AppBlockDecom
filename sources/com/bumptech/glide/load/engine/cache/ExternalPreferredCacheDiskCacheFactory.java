package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f66602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f66603b;

        private File b() {
            File cacheDir = this.f66602a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f66603b != null ? new File(cacheDir, this.f66603b) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File a() {
            File externalCacheDir;
            File fileB = b();
            return ((fileB == null || !fileB.exists()) && (externalCacheDir = this.f66602a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.f66603b != null ? new File(externalCacheDir, this.f66603b) : externalCacheDir : fileB;
        }
    }
}
