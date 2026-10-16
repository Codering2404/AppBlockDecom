package androidx.media3.datasource;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.facebook.ads.AdError;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSchemeDataSource extends BaseDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DataSpec f41813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f41814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f41815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f41816h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws ParserException, DataSourceException {
        p(dataSpec);
        this.f41813e = dataSpec;
        Uri uriNormalizeScheme = dataSpec.f41829a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        Assertions.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrH1 = Util.h1(uriNormalizeScheme.getSchemeSpecificPart(), ",");
        if (strArrH1.length != 2) {
            throw ParserException.b("Unexpected URI format: " + uriNormalizeScheme, null);
        }
        String str = strArrH1[1];
        if (strArrH1[0].contains(";base64")) {
            try {
                this.f41814f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e3) {
                throw ParserException.b("Error while parsing Base64 encoded string: " + str, e3);
            }
        } else {
            this.f41814f = Util.t0(URLDecoder.decode(str, StandardCharsets.US_ASCII.name()));
        }
        long j3 = dataSpec.f41835g;
        byte[] bArr = this.f41814f;
        if (j3 > bArr.length) {
            this.f41814f = null;
            throw new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        int i3 = (int) j3;
        this.f41815g = i3;
        int length = bArr.length - i3;
        this.f41816h = length;
        long j4 = dataSpec.f41836h;
        if (j4 != -1) {
            this.f41816h = (int) Math.min(length, j4);
        }
        q(dataSpec);
        long j5 = dataSpec.f41836h;
        return j5 != -1 ? j5 : this.f41816h;
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        if (this.f41814f != null) {
            this.f41814f = null;
            o();
        }
        this.f41813e = null;
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        DataSpec dataSpec = this.f41813e;
        if (dataSpec != null) {
            return dataSpec.f41829a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return 0;
        }
        int i5 = this.f41816h;
        if (i5 == 0) {
            return -1;
        }
        int iMin = Math.min(i4, i5);
        System.arraycopy(Util.k(this.f41814f), this.f41815g, bArr, i3, iMin);
        this.f41815g += iMin;
        this.f41816h -= iMin;
        n(iMin);
        return iMin;
    }
}
