package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteArrayDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UriResolver f41799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f41800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f41801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f41802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f41803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f41804j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UriResolver {
        byte[] a(Uri uri);
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws DataSourceException {
        p(dataSpec);
        Uri uri = dataSpec.f41829a;
        this.f41800f = uri;
        byte[] bArrA = this.f41799e.a(uri);
        this.f41801g = bArrA;
        long j3 = dataSpec.f41835g;
        if (j3 > bArrA.length) {
            throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        this.f41802h = (int) j3;
        int length = bArrA.length - ((int) j3);
        this.f41803i = length;
        long j4 = dataSpec.f41836h;
        if (j4 != -1) {
            this.f41803i = (int) Math.min(length, j4);
        }
        this.f41804j = true;
        q(dataSpec);
        long j5 = dataSpec.f41836h;
        return j5 != -1 ? j5 : this.f41803i;
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        if (this.f41804j) {
            this.f41804j = false;
            o();
        }
        this.f41800f = null;
        this.f41801g = null;
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41800f;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.f41803i;
        if (i5 == 0) {
            return -1;
        }
        int iMin = Math.min(i4, i5);
        System.arraycopy(Assertions.i(this.f41801g), this.f41802h, bArr, i3, iMin);
        this.f41802h += iMin;
        this.f41803i -= iMin;
        n(iMin);
        return iMin;
    }
}
