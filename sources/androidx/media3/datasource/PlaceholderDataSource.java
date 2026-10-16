package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.datasource.DataSource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaceholderDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlaceholderDataSource f41965a = new PlaceholderDataSource();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DataSource.Factory f41966b = new DataSource.Factory() { // from class: androidx.media3.datasource.f0
        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            return PlaceholderDataSource.n();
        }
    };

    private PlaceholderDataSource() {
    }

    public static /* synthetic */ PlaceholderDataSource n() {
        return new PlaceholderDataSource();
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
    }
}
