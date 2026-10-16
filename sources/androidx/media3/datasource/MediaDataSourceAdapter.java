package androidx.media3.datasource;

import android.media.MediaDataSource;
import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaDataSourceAdapter extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MediaDataSource f41960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f41961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f41962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f41963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f41964i;

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws DataSourceException {
        this.f41961f = dataSpec.f41829a;
        this.f41962g = dataSpec.f41835g;
        p(dataSpec);
        if (this.f41960e.getSize() != -1 && this.f41962g > this.f41960e.getSize()) {
            throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        if (this.f41960e.getSize() == -1) {
            this.f41963h = -1L;
        } else {
            this.f41963h = this.f41960e.getSize() - this.f41962g;
        }
        long jMin = dataSpec.f41836h;
        if (jMin != -1) {
            long j3 = this.f41963h;
            if (j3 != -1) {
                jMin = Math.min(j3, jMin);
            }
            this.f41963h = jMin;
        }
        this.f41964i = true;
        q(dataSpec);
        long j4 = dataSpec.f41836h;
        return j4 != -1 ? j4 : this.f41963h;
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41961f = null;
        if (this.f41964i) {
            this.f41964i = false;
            o();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41961f;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws DataSourceException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41963h;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            i4 = (int) Math.min(j3, i4);
        }
        try {
            int at = this.f41960e.readAt(this.f41962g, bArr, i3, i4);
            if (at == -1) {
                return -1;
            }
            long j4 = at;
            this.f41962g += j4;
            long j5 = this.f41963h;
            if (j5 != -1) {
                this.f41963h = j5 - j4;
            }
            n(at);
            return at;
        } catch (IOException e3) {
            throw new DataSourceException(e3, AdError.SERVER_ERROR_CODE);
        }
    }
}
