package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TeeDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataSink f41992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f41993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f41994d;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.f41991a = (DataSource) Assertions.e(dataSource);
        this.f41992b = (DataSink) Assertions.e(dataSink);
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        long jB = this.f41991a.b(dataSpec);
        this.f41994d = jB;
        if (jB == 0) {
            return 0L;
        }
        if (dataSpec.f41836h == -1 && jB != -1) {
            dataSpec = dataSpec.f(0L, jB);
        }
        this.f41993c = true;
        this.f41992b.b(dataSpec);
        return this.f41994d;
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41991a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        try {
            this.f41991a.close();
        } finally {
            if (this.f41993c) {
                this.f41993c = false;
                this.f41992b.close();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f41991a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41991a.getUri();
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        if (this.f41994d == 0) {
            return -1;
        }
        int i5 = this.f41991a.read(bArr, i3, i4);
        if (i5 > 0) {
            this.f41992b.write(bArr, i3, i5);
            long j3 = this.f41994d;
            if (j3 != -1) {
                this.f41994d = j3 - ((long) i5);
            }
        }
        return i5;
    }
}
