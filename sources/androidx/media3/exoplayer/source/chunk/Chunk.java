package androidx.media3.exoplayer.source.chunk;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.upstream.Loader;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Chunk implements Loader.Loadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSpec f45093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Format f45095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f45096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f45097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f45098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f45099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final StatsDataSource f45100i;

    public final long b() {
        return this.f45100i.n();
    }

    public final Map d() {
        return this.f45100i.p();
    }

    public final Uri e() {
        return this.f45100i.o();
    }
}
