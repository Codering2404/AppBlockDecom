package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AssetDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssetManager f41789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f41790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputStream f41791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f41792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f41793i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(Throwable th, int i3) {
            super(th, i3);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f41789e = context.getAssets();
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.f41829a;
            this.f41790f = uri;
            String strSubstring = (String) Assertions.e(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith("/")) {
                strSubstring = strSubstring.substring(1);
            }
            p(dataSpec);
            InputStream inputStreamOpen = this.f41789e.open(strSubstring, 1);
            this.f41791g = inputStreamOpen;
            if (inputStreamOpen.skip(dataSpec.f41835g) < dataSpec.f41835g) {
                throw new AssetDataSourceException(null, AdError.REMOTE_ADS_SERVICE_ERROR);
            }
            long j3 = dataSpec.f41836h;
            if (j3 != -1) {
                this.f41792h = j3;
            } else {
                long jAvailable = this.f41791g.available();
                this.f41792h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f41792h = -1L;
                }
            }
            this.f41793i = true;
            q(dataSpec);
            return this.f41792h;
        } catch (AssetDataSourceException e3) {
            throw e3;
        } catch (IOException e4) {
            throw new AssetDataSourceException(e4, e4 instanceof FileNotFoundException ? 2005 : AdError.SERVER_ERROR_CODE);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41790f = null;
        try {
            try {
                InputStream inputStream = this.f41791g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e3) {
                throw new AssetDataSourceException(e3, AdError.SERVER_ERROR_CODE);
            }
        } finally {
            this.f41791g = null;
            if (this.f41793i) {
                this.f41793i = false;
                o();
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41790f;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws AssetDataSourceException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41792h;
        if (j3 == 0) {
            return -1;
        }
        if (j3 != -1) {
            try {
                i4 = (int) Math.min(j3, i4);
            } catch (IOException e3) {
                throw new AssetDataSourceException(e3, AdError.SERVER_ERROR_CODE);
            }
        }
        int i5 = ((InputStream) Util.k(this.f41791g)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        long j4 = this.f41792h;
        if (j4 != -1) {
            this.f41792h = j4 - ((long) i5);
        }
        n(i5);
        return i5;
    }
}
