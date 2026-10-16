package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CacheDataSource f42060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Cache f42061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSpec f42062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f42063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f42064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ProgressListener f42065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f42066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f42068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f42069j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProgressListener {
        void a(long j3, long j4, long j5);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, byte[] bArr, ProgressListener progressListener) {
        this.f42060a = cacheDataSource;
        this.f42061b = cacheDataSource.o();
        this.f42062c = dataSpec;
        this.f42064e = bArr == null ? new byte[131072] : bArr;
        this.f42065f = progressListener;
        this.f42063d = cacheDataSource.p().b(dataSpec);
        this.f42066g = dataSpec.f41835g;
    }

    private long c() {
        long j3 = this.f42067h;
        if (j3 == -1) {
            return -1L;
        }
        return j3 - this.f42062c.f41835g;
    }

    private void d(long j3) {
        this.f42068i += j3;
        ProgressListener progressListener = this.f42065f;
        if (progressListener != null) {
            progressListener.a(c(), this.f42068i, j3);
        }
    }

    private void e(long j3) {
        if (this.f42067h == j3) {
            return;
        }
        this.f42067h = j3;
        ProgressListener progressListener = this.f42065f;
        if (progressListener != null) {
            progressListener.a(c(), this.f42068i, 0L);
        }
    }

    private long f(long j3, long j4) throws Exception {
        long jB;
        boolean z2 = true;
        boolean z3 = j3 + j4 == this.f42067h || j4 == -1;
        if (j4 != -1) {
            try {
                jB = this.f42060a.b(this.f42062c.a().h(j3).g(j4).a());
            } catch (Exception unused) {
                DataSourceUtil.a(this.f42060a);
                z2 = false;
                jB = -1;
            }
        } else {
            z2 = false;
            jB = -1;
        }
        if (!z2) {
            g();
            try {
                jB = this.f42060a.b(this.f42062c.a().h(j3).g(-1L).a());
            } catch (Exception e3) {
                DataSourceUtil.a(this.f42060a);
                throw e3;
            }
        }
        if (z3 && jB != -1) {
            try {
                e(jB + j3);
            } catch (Exception e4) {
                DataSourceUtil.a(this.f42060a);
                throw e4;
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 != -1) {
            g();
            CacheDataSource cacheDataSource = this.f42060a;
            byte[] bArr = this.f42064e;
            i3 = cacheDataSource.read(bArr, 0, bArr.length);
            if (i3 != -1) {
                d(i3);
                i4 += i3;
            }
        }
        if (z3) {
            e(j3 + ((long) i4));
        }
        this.f42060a.close();
        return i4;
    }

    private void g() throws InterruptedIOException {
        if (this.f42069j) {
            throw new InterruptedIOException();
        }
    }

    public void a() throws InterruptedIOException {
        g();
        Cache cache = this.f42061b;
        String str = this.f42063d;
        DataSpec dataSpec = this.f42062c;
        this.f42068i = cache.c(str, dataSpec.f41835g, dataSpec.f41836h);
        DataSpec dataSpec2 = this.f42062c;
        long j3 = dataSpec2.f41836h;
        if (j3 != -1) {
            this.f42067h = dataSpec2.f41835g + j3;
        } else {
            long jB = ContentMetadata.b(this.f42061b.b(this.f42063d));
            if (jB == -1) {
                jB = -1;
            }
            this.f42067h = jB;
        }
        ProgressListener progressListener = this.f42065f;
        if (progressListener != null) {
            progressListener.a(c(), this.f42068i, 0L);
        }
        while (true) {
            long j4 = this.f42067h;
            if (j4 != -1 && this.f42066g >= j4) {
                return;
            }
            g();
            long j5 = this.f42067h;
            long jF = this.f42061b.f(this.f42063d, this.f42066g, j5 == -1 ? Long.MAX_VALUE : j5 - this.f42066g);
            if (jF > 0) {
                this.f42066g += jF;
            } else {
                long j6 = -jF;
                if (j6 == Long.MAX_VALUE) {
                    j6 = -1;
                }
                long j7 = this.f42066g;
                this.f42066g = j7 + f(j7, j6);
            }
        }
    }

    public void b() {
        this.f42069j = true;
    }
}
