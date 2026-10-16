package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f66596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f66597c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DiskLruCache f66599e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DiskCacheWriteLocker f66598d = new DiskCacheWriteLocker();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SafeKeyGenerator f66595a = new SafeKeyGenerator();

    protected DiskLruCacheWrapper(File file, long j3) {
        this.f66596b = file;
        this.f66597c = j3;
    }

    public static DiskCache c(File file, long j3) {
        return new DiskLruCacheWrapper(file, j3);
    }

    private synchronized DiskLruCache d() {
        try {
            if (this.f66599e == null) {
                this.f66599e = DiskLruCache.N(this.f66596b, 1, 1, this.f66597c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f66599e;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void a(Key key, DiskCache.Writer writer) {
        String strB = this.f66595a.b(key);
        this.f66598d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + key);
            }
            try {
                DiskLruCache diskLruCacheD = d();
                if (diskLruCacheD.L(strB) == null) {
                    DiskLruCache.Editor editorF = diskLruCacheD.F(strB);
                    if (editorF == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (writer.a(editorF.f(0))) {
                            editorF.e();
                        }
                        editorF.b();
                    } catch (Throwable th) {
                        editorF.b();
                        throw th;
                    }
                }
            } catch (IOException e3) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e3);
                }
            }
        } finally {
            this.f66598d.b(strB);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File b(Key key) {
        String strB = this.f66595a.b(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value valueL = d().L(strB);
            if (valueL != null) {
                return valueL.a(0);
            }
            return null;
        } catch (IOException e3) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e3);
            return null;
        }
    }
}
