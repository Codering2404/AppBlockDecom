package androidx.media3.datasource;

import android.content.Context;
import androidx.media3.datasource.DataSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class DefaultDataSourceFactory implements DataSource.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f41864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TransferListener f41865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource.Factory f41866c;

    @Override // androidx.media3.datasource.DataSource.Factory
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DefaultDataSource a() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.f41864a, this.f41866c.a());
        TransferListener transferListener = this.f41865b;
        if (transferListener != null) {
            defaultDataSource.c(transferListener);
        }
        return defaultDataSource;
    }
}
