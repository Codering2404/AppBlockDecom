package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResolvingDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resolver f41983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f41984c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataSource.Factory f41985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Resolver f41986b;

        @Override // androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResolvingDataSource a() {
            return new ResolvingDataSource(this.f41985a.a(), this.f41986b);
        }
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver) {
        this.f41982a = dataSource;
        this.f41983b = resolver;
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        DataSpec dataSpecB = this.f41983b.b(dataSpec);
        this.f41984c = true;
        return this.f41982a.b(dataSpecB);
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41982a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        if (this.f41984c) {
            this.f41984c = false;
            this.f41982a.close();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f41982a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        Uri uri = this.f41982a.getUri();
        if (uri == null) {
            return null;
        }
        return this.f41983b.a(uri);
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        return this.f41982a.read(bArr, i3, i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Resolver {
        DataSpec b(DataSpec dataSpec);

        default Uri a(Uri uri) {
            return uri;
        }
    }
}
