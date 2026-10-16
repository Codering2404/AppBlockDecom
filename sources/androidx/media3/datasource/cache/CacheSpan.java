package androidx.media3.datasource.cache;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CacheSpan implements Comparable<CacheSpan> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f42055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f42056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f42057d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f42058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f42059g;

    public CacheSpan(String str, long j3, long j4, long j5, File file) {
        this.f42054a = str;
        this.f42055b = j3;
        this.f42056c = j4;
        this.f42057d = file != null;
        this.f42058f = file;
        this.f42059g = j5;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CacheSpan cacheSpan) {
        if (!this.f42054a.equals(cacheSpan.f42054a)) {
            return this.f42054a.compareTo(cacheSpan.f42054a);
        }
        long j3 = this.f42055b - cacheSpan.f42055b;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.f42057d;
    }

    public boolean c() {
        return this.f42056c == -1;
    }

    public String toString() {
        return "[" + this.f42055b + ", " + this.f42056c + "]";
    }
}
