package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StatsDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f41988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f41989c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f41990d = Collections.EMPTY_MAP;

    public StatsDataSource(DataSource dataSource) {
        this.f41987a = (DataSource) Assertions.e(dataSource);
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        this.f41989c = dataSpec.f41829a;
        this.f41990d = Collections.EMPTY_MAP;
        try {
            return this.f41987a.b(dataSpec);
        } finally {
            Uri uri = getUri();
            if (uri != null) {
                this.f41989c = uri;
            }
            this.f41990d = e();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41987a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41987a.close();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f41987a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41987a.getUri();
    }

    public long n() {
        return this.f41988b;
    }

    public Uri o() {
        return this.f41989c;
    }

    public Map p() {
        return this.f41990d;
    }

    public void q() {
        this.f41988b = 0L;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        int i5 = this.f41987a.read(bArr, i3, i4);
        if (i5 != -1) {
            this.f41988b += (long) i5;
        }
        return i5;
    }
}
