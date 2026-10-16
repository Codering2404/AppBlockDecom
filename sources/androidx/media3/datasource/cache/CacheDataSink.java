package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSink implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cache f42004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f42005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f42006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DataSpec f42007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f42008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f42009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OutputStream f42010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f42012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ReusableBufferedOutputStream f42013j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSink.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Cache f42014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f42015b = 5242880;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f42016c = 20480;

        @Override // androidx.media3.datasource.DataSink.Factory
        public DataSink a() {
            return new CacheDataSink((Cache) Assertions.e(this.f42014a), this.f42015b, this.f42016c);
        }

        public Factory b(Cache cache) {
            this.f42014a = cache;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j3, int i3) {
        Assertions.h(j3 > 0 || j3 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j3 != -1 && j3 < 2097152) {
            Log.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f42004a = (Cache) Assertions.e(cache);
        this.f42005b = j3 == -1 ? Long.MAX_VALUE : j3;
        this.f42006c = i3;
    }

    private void a() {
        OutputStream outputStream = this.f42010g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            Util.o(this.f42010g);
            this.f42010g = null;
            File file = (File) Util.k(this.f42009f);
            this.f42009f = null;
            this.f42004a.j(file, this.f42011h);
        } catch (Throwable th) {
            Util.o(this.f42010g);
            this.f42010g = null;
            File file2 = (File) Util.k(this.f42009f);
            this.f42009f = null;
            file2.delete();
            throw th;
        }
    }

    private void c(DataSpec dataSpec) {
        long j3 = dataSpec.f41836h;
        this.f42009f = this.f42004a.a((String) Util.k(dataSpec.f41837i), dataSpec.f41835g + this.f42012i, j3 != -1 ? Math.min(j3 - this.f42012i, this.f42008e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f42009f);
        if (this.f42006c > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.f42013j;
            if (reusableBufferedOutputStream == null) {
                this.f42013j = new ReusableBufferedOutputStream(fileOutputStream, this.f42006c);
            } else {
                reusableBufferedOutputStream.a(fileOutputStream);
            }
            this.f42010g = this.f42013j;
        } else {
            this.f42010g = fileOutputStream;
        }
        this.f42011h = 0L;
    }

    @Override // androidx.media3.datasource.DataSink
    public void b(DataSpec dataSpec) throws CacheDataSinkException {
        Assertions.e(dataSpec.f41837i);
        if (dataSpec.f41836h == -1 && dataSpec.d(2)) {
            this.f42007d = null;
            return;
        }
        this.f42007d = dataSpec;
        this.f42008e = dataSpec.d(4) ? this.f42005b : Long.MAX_VALUE;
        this.f42012i = 0L;
        try {
            c(dataSpec);
        } catch (IOException e3) {
            throw new CacheDataSinkException(e3);
        }
    }

    @Override // androidx.media3.datasource.DataSink
    public void close() throws CacheDataSinkException {
        if (this.f42007d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e3) {
            throw new CacheDataSinkException(e3);
        }
    }

    @Override // androidx.media3.datasource.DataSink
    public void write(byte[] bArr, int i3, int i4) throws CacheDataSinkException {
        DataSpec dataSpec = this.f42007d;
        if (dataSpec == null) {
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            try {
                if (this.f42011h == this.f42008e) {
                    a();
                    c(dataSpec);
                }
                int iMin = (int) Math.min(i4 - i5, this.f42008e - this.f42011h);
                ((OutputStream) Util.k(this.f42010g)).write(bArr, i3 + i5, iMin);
                i5 += iMin;
                long j3 = iMin;
                this.f42011h += j3;
                this.f42012i += j3;
            } catch (IOException e3) {
                throw new CacheDataSinkException(e3);
            }
        }
    }
}
