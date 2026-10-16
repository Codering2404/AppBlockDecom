package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSourceInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSpec f41824b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f41828g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f41826d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f41827f = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f41825c = new byte[1];

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.f41823a = dataSource;
        this.f41824b = dataSpec;
    }

    private void a() {
        if (this.f41826d) {
            return;
        }
        this.f41823a.b(this.f41824b);
        this.f41826d = true;
    }

    public void b() {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f41827f) {
            return;
        }
        this.f41823a.close();
        this.f41827f = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f41825c) == -1) {
            return -1;
        }
        return this.f41825c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        Assertions.g(!this.f41827f);
        a();
        int i5 = this.f41823a.read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        this.f41828g += (long) i5;
        return i5;
    }
}
