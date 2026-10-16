package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.PriorityDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import com.facebook.ads.AdError;
import java.io.File;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cache f42017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSource f42018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f42019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataSource f42020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CacheKeyFactory f42021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventListener f42022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f42023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f42024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f42025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Uri f42026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DataSpec f42027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private DataSpec f42028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DataSource f42029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f42030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f42031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f42032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CacheSpan f42033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f42034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f42035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f42036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f42037u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventListener {
        void a(int i3);

        void b(long j3, long j4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Cache f42038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DataSource.Factory f42039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private DataSink.Factory f42040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CacheKeyFactory f42041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f42042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private DataSource.Factory f42043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private PriorityTaskManager f42044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f42045h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f42046i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private EventListener f42047j;

        private CacheDataSource e(DataSource dataSource, int i3, int i4) {
            DataSink dataSinkA;
            Cache cache = (Cache) Assertions.e(this.f42038a);
            if (this.f42042e || dataSource == null) {
                dataSinkA = null;
            } else {
                DataSink.Factory factory = this.f42040c;
                dataSinkA = factory != null ? factory.a() : new CacheDataSink.Factory().b(cache).a();
            }
            return new CacheDataSource(cache, dataSource, this.f42039b.a(), dataSinkA, this.f42041d, i3, this.f42044g, i4, this.f42047j);
        }

        @Override // androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CacheDataSource a() {
            DataSource.Factory factory = this.f42043f;
            return e(factory != null ? factory.a() : null, this.f42046i, this.f42045h);
        }

        public CacheDataSource c() {
            DataSource.Factory factory = this.f42043f;
            return e(factory != null ? factory.a() : null, this.f42046i | 1, -4000);
        }

        public CacheDataSource d() {
            return e(null, this.f42046i | 1, -4000);
        }

        public PriorityTaskManager f() {
            return this.f42044g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private int A(DataSpec dataSpec) {
        if (this.f42024h && this.f42034r) {
            return 0;
        }
        return (this.f42025i && dataSpec.f41836h == -1) ? 1 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n() {
        DataSource dataSource = this.f42029m;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.f42028l = null;
            this.f42029m = null;
            CacheSpan cacheSpan = this.f42033q;
            if (cacheSpan != null) {
                this.f42017a.h(cacheSpan);
                this.f42033q = null;
            }
        }
    }

    private static Uri q(Cache cache, String str, Uri uri) {
        Uri uriD = ContentMetadata.d(cache.b(str));
        return uriD != null ? uriD : uri;
    }

    private void r(Throwable th) {
        if (t() || (th instanceof Cache.CacheException)) {
            this.f42034r = true;
        }
    }

    private boolean s() {
        return this.f42029m == this.f42020d;
    }

    private boolean t() {
        return this.f42029m == this.f42018b;
    }

    private boolean u() {
        return !t();
    }

    private boolean v() {
        return this.f42029m == this.f42019c;
    }

    private void w() {
        EventListener eventListener = this.f42022f;
        if (eventListener == null || this.f42036t <= 0) {
            return;
        }
        eventListener.b(this.f42017a.g(), this.f42036t);
        this.f42036t = 0L;
    }

    private void x(int i3) {
        EventListener eventListener = this.f42022f;
        if (eventListener != null) {
            eventListener.a(i3);
        }
    }

    private void y(DataSpec dataSpec, boolean z2) throws InterruptedIOException {
        CacheSpan cacheSpanI;
        long jMin;
        DataSpec dataSpecA;
        DataSource dataSource;
        String str = (String) Util.k(dataSpec.f41837i);
        if (this.f42035s) {
            cacheSpanI = null;
        } else if (this.f42023g) {
            try {
                cacheSpanI = this.f42017a.i(str, this.f42031o, this.f42032p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpanI = this.f42017a.e(str, this.f42031o, this.f42032p);
        }
        if (cacheSpanI == null) {
            dataSource = this.f42020d;
            dataSpecA = dataSpec.a().h(this.f42031o).g(this.f42032p).a();
        } else if (cacheSpanI.f42057d) {
            Uri uriFromFile = Uri.fromFile((File) Util.k(cacheSpanI.f42058f));
            long j3 = cacheSpanI.f42055b;
            long j4 = this.f42031o - j3;
            long jMin2 = cacheSpanI.f42056c - j4;
            long j5 = this.f42032p;
            if (j5 != -1) {
                jMin2 = Math.min(jMin2, j5);
            }
            dataSpecA = dataSpec.a().i(uriFromFile).k(j3).h(j4).g(jMin2).a();
            dataSource = this.f42018b;
        } else {
            if (cacheSpanI.c()) {
                jMin = this.f42032p;
            } else {
                jMin = cacheSpanI.f42056c;
                long j6 = this.f42032p;
                if (j6 != -1) {
                    jMin = Math.min(jMin, j6);
                }
            }
            dataSpecA = dataSpec.a().h(this.f42031o).g(jMin).a();
            dataSource = this.f42019c;
            if (dataSource == null) {
                dataSource = this.f42020d;
                this.f42017a.h(cacheSpanI);
                cacheSpanI = null;
            }
        }
        this.f42037u = (this.f42035s || dataSource != this.f42020d) ? Long.MAX_VALUE : this.f42031o + 102400;
        if (z2) {
            Assertions.g(s());
            if (dataSource == this.f42020d) {
                return;
            }
            try {
                n();
            } catch (Throwable th) {
                if (((CacheSpan) Util.k(cacheSpanI)).b()) {
                    this.f42017a.h(cacheSpanI);
                }
                throw th;
            }
        }
        if (cacheSpanI != null && cacheSpanI.b()) {
            this.f42033q = cacheSpanI;
        }
        this.f42029m = dataSource;
        this.f42028l = dataSpecA;
        this.f42030n = 0L;
        long jB = dataSource.b(dataSpecA);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpecA.f41836h == -1 && jB != -1) {
            this.f42032p = jB;
            ContentMetadataMutations.g(contentMetadataMutations, this.f42031o + jB);
        }
        if (u()) {
            Uri uri = dataSource.getUri();
            this.f42026j = uri;
            ContentMetadataMutations.h(contentMetadataMutations, dataSpec.f41829a.equals(uri) ? null : this.f42026j);
        }
        if (v()) {
            this.f42017a.l(str, contentMetadataMutations);
        }
    }

    private void z(String str) {
        this.f42032p = 0L;
        if (v()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.g(contentMetadataMutations, this.f42031o);
            this.f42017a.l(str, contentMetadataMutations);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        try {
            String strB = this.f42021e.b(dataSpec);
            DataSpec dataSpecA = dataSpec.a().f(strB).a();
            this.f42027k = dataSpecA;
            this.f42026j = q(this.f42017a, strB, dataSpecA.f41829a);
            this.f42031o = dataSpec.f41835g;
            int iA = A(dataSpec);
            boolean z2 = iA != -1;
            this.f42035s = z2;
            if (z2) {
                x(iA);
            }
            if (this.f42035s) {
                this.f42032p = -1L;
            } else {
                long jB = ContentMetadata.b(this.f42017a.b(strB));
                this.f42032p = jB;
                if (jB != -1) {
                    long j3 = jB - dataSpec.f41835g;
                    this.f42032p = j3;
                    if (j3 < 0) {
                        throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
                    }
                }
            }
            long jMin = dataSpec.f41836h;
            if (jMin != -1) {
                long j4 = this.f42032p;
                if (j4 != -1) {
                    jMin = Math.min(j4, jMin);
                }
                this.f42032p = jMin;
            }
            long j5 = this.f42032p;
            if (j5 > 0 || j5 == -1) {
                y(dataSpecA, false);
            }
            long j6 = dataSpec.f41836h;
            return j6 != -1 ? j6 : this.f42032p;
        } catch (Throwable th) {
            r(th);
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f42018b.c(transferListener);
        this.f42020d.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f42027k = null;
        this.f42026j = null;
        this.f42031o = 0L;
        w();
        try {
            n();
        } catch (Throwable th) {
            r(th);
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return u() ? this.f42020d.e() : Collections.EMPTY_MAP;
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f42026j;
    }

    public Cache o() {
        return this.f42017a;
    }

    public CacheKeyFactory p() {
        return this.f42021e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        if (r17.f42030n < r13) goto L29;
     */
    @Override // androidx.media3.common.DataReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r18, int r19, int r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            r2 = 0
            if (r0 != 0) goto L8
            return r2
        L8:
            long r3 = r1.f42032p
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = -1
            if (r3 != 0) goto L12
            return r4
        L12:
            androidx.media3.datasource.DataSpec r3 = r1.f42027k
            java.lang.Object r3 = androidx.media3.common.util.Assertions.e(r3)
            androidx.media3.datasource.DataSpec r3 = (androidx.media3.datasource.DataSpec) r3
            androidx.media3.datasource.DataSpec r7 = r1.f42028l
            java.lang.Object r7 = androidx.media3.common.util.Assertions.e(r7)
            androidx.media3.datasource.DataSpec r7 = (androidx.media3.datasource.DataSpec) r7
            long r8 = r1.f42031o     // Catch: java.lang.Throwable -> L2f
            long r10 = r1.f42037u     // Catch: java.lang.Throwable -> L2f
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L31
            r8 = 1
            r1.y(r3, r8)     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r0 = move-exception
            goto L9d
        L31:
            androidx.media3.datasource.DataSource r8 = r1.f42029m     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = androidx.media3.common.util.Assertions.e(r8)     // Catch: java.lang.Throwable -> L2f
            androidx.media3.datasource.DataSource r8 = (androidx.media3.datasource.DataSource) r8     // Catch: java.lang.Throwable -> L2f
            r9 = r18
            r10 = r19
            int r8 = r8.read(r9, r10, r0)     // Catch: java.lang.Throwable -> L2f
            r11 = -1
            if (r8 == r4) goto L66
            boolean r0 = r1.t()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L51
            long r2 = r1.f42036t     // Catch: java.lang.Throwable -> L2f
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L2f
            long r2 = r2 + r4
            r1.f42036t = r2     // Catch: java.lang.Throwable -> L2f
        L51:
            long r2 = r1.f42031o     // Catch: java.lang.Throwable -> L2f
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L2f
            long r2 = r2 + r4
            r1.f42031o = r2     // Catch: java.lang.Throwable -> L2f
            long r2 = r1.f42030n     // Catch: java.lang.Throwable -> L2f
            long r2 = r2 + r4
            r1.f42030n = r2     // Catch: java.lang.Throwable -> L2f
            long r2 = r1.f42032p     // Catch: java.lang.Throwable -> L2f
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L91
            long r2 = r2 - r4
            r1.f42032p = r2     // Catch: java.lang.Throwable -> L2f
            return r8
        L66:
            boolean r4 = r1.u()     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L85
            long r13 = r7.f41836h     // Catch: java.lang.Throwable -> L2f
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 == 0) goto L79
            r15 = r5
            long r5 = r1.f42030n     // Catch: java.lang.Throwable -> L2f
            int r4 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r4 >= 0) goto L86
        L79:
            java.lang.String r0 = r3.f41837i     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r0 = androidx.media3.common.util.Util.k(r0)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L2f
            r1.z(r0)     // Catch: java.lang.Throwable -> L2f
            return r8
        L85:
            r15 = r5
        L86:
            long r4 = r1.f42032p     // Catch: java.lang.Throwable -> L2f
            int r6 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r6 > 0) goto L92
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 != 0) goto L91
            goto L92
        L91:
            return r8
        L92:
            r1.n()     // Catch: java.lang.Throwable -> L2f
            r1.y(r3, r2)     // Catch: java.lang.Throwable -> L2f
            int r0 = r17.read(r18, r19, r20)     // Catch: java.lang.Throwable -> L2f
            return r0
        L9d:
            r1.r(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CacheDataSource.read(byte[], int, int):int");
    }

    private CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int i3, PriorityTaskManager priorityTaskManager, int i4, EventListener eventListener) {
        this.f42017a = cache;
        this.f42018b = dataSource2;
        this.f42021e = cacheKeyFactory == null ? CacheKeyFactory.f42053a : cacheKeyFactory;
        this.f42023g = (i3 & 1) != 0;
        this.f42024h = (i3 & 2) != 0;
        this.f42025i = (i3 & 4) != 0;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i4) : dataSource;
            this.f42020d = dataSource;
            this.f42019c = dataSink != null ? new TeeDataSource(dataSource, dataSink) : null;
        } else {
            this.f42020d = PlaceholderDataSource.f41965a;
            this.f42019c = null;
        }
        this.f42022f = eventListener;
    }
}
