package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class IcyDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f44699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f44700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener f44701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f44702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44703e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void b(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i3, Listener listener) {
        Assertions.a(i3 > 0);
        this.f44699a = dataSource;
        this.f44700b = i3;
        this.f44701c = listener;
        this.f44702d = new byte[1];
        this.f44703e = i3;
    }

    private boolean n() {
        if (this.f44699a.read(this.f44702d, 0, 1) == -1) {
            return false;
        }
        int i3 = (this.f44702d[0] & 255) << 4;
        if (i3 == 0) {
            return true;
        }
        byte[] bArr = new byte[i3];
        int i4 = i3;
        int i5 = 0;
        while (i4 > 0) {
            int i6 = this.f44699a.read(bArr, i5, i4);
            if (i6 == -1) {
                return false;
            }
            i5 += i6;
            i4 -= i6;
        }
        while (i3 > 0 && bArr[i3 - 1] == 0) {
            i3--;
        }
        if (i3 > 0) {
            this.f44701c.b(new ParsableByteArray(bArr, i3));
        }
        return true;
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f44699a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f44699a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f44699a.getUri();
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        if (this.f44703e == 0) {
            if (!n()) {
                return -1;
            }
            this.f44703e = this.f44700b;
        }
        int i5 = this.f44699a.read(bArr, i3, Math.min(this.f44703e, i4));
        if (i5 != -1) {
            this.f44703e -= i5;
        }
        return i5;
    }
}
