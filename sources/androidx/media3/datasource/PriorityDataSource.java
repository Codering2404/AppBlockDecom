package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PriorityDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSource f41967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PriorityTaskManager f41968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f41969c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataSource.Factory f41970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PriorityTaskManager f41971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f41972c;

        @Override // androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PriorityDataSource a() {
            return new PriorityDataSource(this.f41970a.a(), this.f41971b, this.f41972c);
        }
    }

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i3) {
        this.f41967a = (DataSource) Assertions.e(dataSource);
        this.f41968b = (PriorityTaskManager) Assertions.e(priorityTaskManager);
        this.f41969c = i3;
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) {
        this.f41968b.c(this.f41969c);
        return this.f41967a.b(dataSpec);
    }

    @Override // androidx.media3.datasource.DataSource
    public void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f41967a.c(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.f41967a.close();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        return this.f41967a.e();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.f41967a.getUri();
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        this.f41968b.c(this.f41969c);
        return this.f41967a.read(bArr, i3, i4);
    }
}
