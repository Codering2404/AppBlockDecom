package androidx.media3.datasource;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AesCipherDataSink implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSink f41777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f41778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f41779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AesFlushingCipher f41780d;

    @Override // androidx.media3.datasource.DataSink
    public void b(DataSpec dataSpec) {
        this.f41777a.b(dataSpec);
        this.f41780d = new AesFlushingCipher(1, this.f41778b, dataSpec.f41837i, dataSpec.f41830b + dataSpec.f41835g);
    }

    @Override // androidx.media3.datasource.DataSink
    public void close() {
        this.f41780d = null;
        this.f41777a.close();
    }

    @Override // androidx.media3.datasource.DataSink
    public void write(byte[] bArr, int i3, int i4) {
        if (this.f41779c == null) {
            ((AesFlushingCipher) Util.k(this.f41780d)).e(bArr, i3, i4);
            this.f41777a.write(bArr, i3, i4);
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            int iMin = Math.min(i4 - i5, this.f41779c.length);
            byte[] bArr2 = bArr;
            ((AesFlushingCipher) Util.k(this.f41780d)).d(bArr2, i3 + i5, iMin, this.f41779c, 0);
            this.f41777a.write(this.f41779c, 0, iMin);
            i5 += iMin;
            bArr = bArr2;
        }
    }
}
