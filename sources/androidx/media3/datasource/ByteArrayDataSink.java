package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteArrayDataSink implements DataSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteArrayOutputStream f41798a;

    @Override // androidx.media3.datasource.DataSink
    public void b(DataSpec dataSpec) {
        long j3 = dataSpec.f41836h;
        if (j3 == -1) {
            this.f41798a = new ByteArrayOutputStream();
        } else {
            Assertions.a(j3 <= 2147483647L);
            this.f41798a = new ByteArrayOutputStream((int) dataSpec.f41836h);
        }
    }

    @Override // androidx.media3.datasource.DataSink
    public void close() throws IOException {
        ((ByteArrayOutputStream) Util.k(this.f41798a)).close();
    }

    @Override // androidx.media3.datasource.DataSink
    public void write(byte[] bArr, int i3, int i4) {
        ((ByteArrayOutputStream) Util.k(this.f41798a)).write(bArr, i3, i4);
    }
}
