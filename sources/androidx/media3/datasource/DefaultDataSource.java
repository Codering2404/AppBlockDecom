package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f41850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f41851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f41852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DataSource f41853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DataSource f41854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DataSource f41855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DataSource f41856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DataSource f41857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DataSource f41858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DataSource f41859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DataSource f41860k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f41861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DataSource.Factory f41862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TransferListener f41863c;

        public Factory(Context context) {
            this(context, new DefaultHttpDataSource.Factory());
        }

        @Override // androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DefaultDataSource a() {
            DefaultDataSource defaultDataSource = new DefaultDataSource(this.f41861a, this.f41862b.a());
            TransferListener transferListener = this.f41863c;
            if (transferListener != null) {
                defaultDataSource.c(transferListener);
            }
            return defaultDataSource;
        }

        public Factory(Context context, DataSource.Factory factory) {
            this.f41861a = context.getApplicationContext();
            this.f41862b = (DataSource.Factory) Assertions.e(factory);
        }
    }

    public DefaultDataSource(Context context, boolean z2) {
        this(context, null, 8000, 8000, z2);
    }

    private void n(DataSource dataSource) {
        for (int i3 = 0; i3 < this.f41851b.size(); i3++) {
            dataSource.c((TransferListener) this.f41851b.get(i3));
        }
    }

    private DataSource o() {
        if (this.f41854e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f41850a);
            this.f41854e = assetDataSource;
            n(assetDataSource);
        }
        return this.f41854e;
    }

    private DataSource p() {
        if (this.f41855f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f41850a);
            this.f41855f = contentDataSource;
            n(contentDataSource);
        }
        return this.f41855f;
    }

    private DataSource q() {
        if (this.f41858i == null) {
            DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
            this.f41858i = dataSchemeDataSource;
            n(dataSchemeDataSource);
        }
        return this.f41858i;
    }

    private DataSource r() {
        if (this.f41853d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f41853d = fileDataSource;
            n(fileDataSource);
        }
        return this.f41853d;
    }

    private DataSource s() {
        if (this.f41859j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f41850a);
            this.f41859j = rawResourceDataSource;
            n(rawResourceDataSource);
        }
        return this.f41859j;
    }

    private DataSource t() {
        if (this.f41856g == null) {
            try {
                DataSource dataSource = (DataSource) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.f41856g = dataSource;
                n(dataSource);
            } catch (ClassNotFoundException unused) {
                Log.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating RTMP extension", e3);
            }
            if (this.f41856g == null) {
                this.f41856g = this.f41852c;
            }
        }
        return this.f41856g;
    }

    private DataSource u() {
        if (this.f41857h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f41857h = udpDataSource;
            n(udpDataSource);
        }
        return this.f41857h;
    }

    private void v(DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.c(transferListener);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        Assertions.g(this.f41860k == null);
        String scheme = dataSpec.f41829a.getScheme();
        if (Util.F0(dataSpec.f41829a)) {
            String path = dataSpec.f41829a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f41860k = r();
            } else {
                this.f41860k = o();
            }
        } else if ("asset".equals(scheme)) {
            this.f41860k = o();
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.f41860k = p();
        } else if ("rtmp".equals(scheme)) {
            this.f41860k = t();
        } else if ("udp".equals(scheme)) {
            this.f41860k = u();
        } else if ("data".equals(scheme)) {
            this.f41860k = q();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.f41860k = s();
        } else {
            this.f41860k = this.f41852c;
        }
        return this.f41860k.b(dataSpec);
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41852c.c(transferListener);
        this.f41851b.add(transferListener);
        v(this.f41853d, transferListener);
        v(this.f41854e, transferListener);
        v(this.f41855f, transferListener);
        v(this.f41856g, transferListener);
        v(this.f41857h, transferListener);
        v(this.f41858i, transferListener);
        v(this.f41859j, transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        DataSource dataSource = this.f41860k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f41860k = null;
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        DataSource dataSource = this.f41860k;
        return dataSource == null ? Collections.EMPTY_MAP : dataSource.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        DataSource dataSource = this.f41860k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        return ((DataSource) Assertions.e(this.f41860k)).read(bArr, i3, i4);
    }

    public DefaultDataSource(Context context, String str, int i3, int i4, boolean z2) {
        this(context, new DefaultHttpDataSource.Factory().f(str).d(i3).e(i4).c(z2).a());
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.f41850a = context.getApplicationContext();
        this.f41852c = (DataSource) Assertions.e(dataSource);
        this.f41851b = new ArrayList();
    }
}
