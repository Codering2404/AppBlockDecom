package androidx.media3.datasource;

import androidx.media3.common.PriorityTaskManager;
import androidx.media3.datasource.DataSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class PriorityDataSourceFactory implements DataSource.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource.Factory f41973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PriorityTaskManager f41974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f41975c;

    @Override // androidx.media3.datasource.DataSource.Factory
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PriorityDataSource a() {
        return new PriorityDataSource(this.f41973a.a(), this.f41974b, this.f41975c);
    }
}
