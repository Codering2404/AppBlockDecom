package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CachedContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TreeSet f42072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f42073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DefaultContentMetadata f42074e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Range {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f42075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f42076b;

        public Range(long j3, long j4) {
            this.f42075a = j3;
            this.f42076b = j4;
        }

        public boolean a(long j3, long j4) {
            long j5 = this.f42076b;
            if (j5 == -1) {
                return j3 >= this.f42075a;
            }
            if (j4 == -1) {
                return false;
            }
            long j6 = this.f42075a;
            return j6 <= j3 && j3 + j4 <= j6 + j5;
        }

        public boolean b(long j3, long j4) {
            long j5 = this.f42075a;
            if (j5 > j3) {
                return j4 == -1 || j3 + j4 > j5;
            }
            long j6 = this.f42076b;
            return j6 == -1 || j5 + j6 > j3;
        }
    }

    public CachedContent(int i3, String str) {
        this(i3, str, DefaultContentMetadata.f42097c);
    }

    public void a(SimpleCacheSpan simpleCacheSpan) {
        this.f42072c.add(simpleCacheSpan);
    }

    public boolean b(ContentMetadataMutations contentMetadataMutations) {
        this.f42074e = this.f42074e.g(contentMetadataMutations);
        return !r2.equals(r0);
    }

    public long c(long j3, long j4) {
        Assertions.a(j3 >= 0);
        Assertions.a(j4 >= 0);
        SimpleCacheSpan simpleCacheSpanE = e(j3, j4);
        if (simpleCacheSpanE.b()) {
            return -Math.min(simpleCacheSpanE.c() ? Long.MAX_VALUE : simpleCacheSpanE.f42056c, j4);
        }
        long j5 = j3 + j4;
        long j6 = j5 >= 0 ? j5 : Long.MAX_VALUE;
        long jMax = simpleCacheSpanE.f42055b + simpleCacheSpanE.f42056c;
        if (jMax < j6) {
            for (SimpleCacheSpan simpleCacheSpan : this.f42072c.tailSet(simpleCacheSpanE, false)) {
                long j7 = simpleCacheSpan.f42055b;
                if (j7 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j7 + simpleCacheSpan.f42056c);
                if (jMax >= j6) {
                    break;
                }
            }
        }
        return Math.min(jMax - j3, j4);
    }

    public DefaultContentMetadata d() {
        return this.f42074e;
    }

    public SimpleCacheSpan e(long j3, long j4) {
        SimpleCacheSpan simpleCacheSpanH = SimpleCacheSpan.h(this.f42071b, j3);
        SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) this.f42072c.floor(simpleCacheSpanH);
        if (simpleCacheSpan != null && simpleCacheSpan.f42055b + simpleCacheSpan.f42056c > j3) {
            return simpleCacheSpan;
        }
        SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan) this.f42072c.ceiling(simpleCacheSpanH);
        if (simpleCacheSpan2 != null) {
            long j5 = simpleCacheSpan2.f42055b - j3;
            j4 = j4 == -1 ? j5 : Math.min(j5, j4);
        }
        return SimpleCacheSpan.g(this.f42071b, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CachedContent.class == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            if (this.f42070a == cachedContent.f42070a && this.f42071b.equals(cachedContent.f42071b) && this.f42072c.equals(cachedContent.f42072c) && this.f42074e.equals(cachedContent.f42074e)) {
                return true;
            }
        }
        return false;
    }

    public TreeSet f() {
        return this.f42072c;
    }

    public boolean g() {
        return this.f42072c.isEmpty();
    }

    public boolean h(long j3, long j4) {
        for (int i3 = 0; i3 < this.f42073d.size(); i3++) {
            if (((Range) this.f42073d.get(i3)).a(j3, j4)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f42070a * 31) + this.f42071b.hashCode()) * 31) + this.f42074e.hashCode();
    }

    public boolean i() {
        return this.f42073d.isEmpty();
    }

    public boolean j(long j3, long j4) {
        for (int i3 = 0; i3 < this.f42073d.size(); i3++) {
            if (((Range) this.f42073d.get(i3)).b(j3, j4)) {
                return false;
            }
        }
        this.f42073d.add(new Range(j3, j4));
        return true;
    }

    public boolean k(CacheSpan cacheSpan) {
        if (!this.f42072c.remove(cacheSpan)) {
            return false;
        }
        File file = cacheSpan.f42058f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public SimpleCacheSpan l(SimpleCacheSpan simpleCacheSpan, long j3, boolean z2) {
        long j4;
        Assertions.g(this.f42072c.remove(simpleCacheSpan));
        File file = (File) Assertions.e(simpleCacheSpan.f42058f);
        if (z2) {
            j4 = j3;
            File fileI = SimpleCacheSpan.i((File) Assertions.e(file.getParentFile()), this.f42070a, simpleCacheSpan.f42055b, j4);
            if (file.renameTo(fileI)) {
                file = fileI;
            } else {
                Log.i("CachedContent", "Failed to rename " + file + " to " + fileI);
            }
        } else {
            j4 = j3;
        }
        SimpleCacheSpan simpleCacheSpanD = simpleCacheSpan.d(file, j4);
        this.f42072c.add(simpleCacheSpanD);
        return simpleCacheSpanD;
    }

    public void m(long j3) {
        for (int i3 = 0; i3 < this.f42073d.size(); i3++) {
            if (((Range) this.f42073d.get(i3)).f42075a == j3) {
                this.f42073d.remove(i3);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public CachedContent(int i3, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f42070a = i3;
        this.f42071b = str;
        this.f42074e = defaultContentMetadata;
        this.f42072c = new TreeSet();
        this.f42073d = new ArrayList();
    }
}
