package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f41794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f41795b = new ArrayList(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DataSpec f41797d;

    protected BaseDataSource(boolean z2) {
        this.f41794a = z2;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void c(TransferListener transferListener) {
        Assertions.e(transferListener);
        if (this.f41795b.contains(transferListener)) {
            return;
        }
        this.f41795b.add(transferListener);
        this.f41796c++;
    }

    protected final void n(int i3) {
        DataSpec dataSpec = (DataSpec) Util.k(this.f41797d);
        for (int i4 = 0; i4 < this.f41796c; i4++) {
            ((TransferListener) this.f41795b.get(i4)).c(this, dataSpec, this.f41794a, i3);
        }
    }

    protected final void o() {
        DataSpec dataSpec = (DataSpec) Util.k(this.f41797d);
        for (int i3 = 0; i3 < this.f41796c; i3++) {
            ((TransferListener) this.f41795b.get(i3)).f(this, dataSpec, this.f41794a);
        }
        this.f41797d = null;
    }

    protected final void p(DataSpec dataSpec) {
        for (int i3 = 0; i3 < this.f41796c; i3++) {
            ((TransferListener) this.f41795b.get(i3)).g(this, dataSpec, this.f41794a);
        }
    }

    protected final void q(DataSpec dataSpec) {
        this.f41797d = dataSpec;
        for (int i3 = 0; i3 < this.f41796c; i3++) {
            ((TransferListener) this.f41795b.get(i3)).e(this, dataSpec, this.f41794a);
        }
    }
}
