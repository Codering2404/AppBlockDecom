package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AesCipherDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f41782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AesFlushingCipher f41783c;

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        long jB = this.f41781a.b(dataSpec);
        this.f41783c = new AesFlushingCipher(2, this.f41782b, dataSpec.f41837i, dataSpec.f41830b + dataSpec.f41835g);
        return jB;
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41781a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41783c = null;
        this.f41781a.close();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f41781a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41781a.getUri();
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.f41781a.read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        ((AesFlushingCipher) Util.k(this.f41783c)).e(bArr, i3, i5);
        return i5;
    }
}
