package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RawAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditedMediaItem f48356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetLoader.Listener f48357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Format f48358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Format f48359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f48361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f48362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f48363h;

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        if (this.f48360e == 2) {
            long jMin = Math.min(this.f48362g, this.f48363h);
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            progressHolder.f48349a = Math.round((jMin / this.f48356a.f48099e) * 100.0f);
        }
        return this.f48360e;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return ImmutableMap.n();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48360e = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        long j3 = this.f48356a.f48099e;
        this.f48360e = j3 == -9223372036854775807L ? 3 : 2;
        this.f48357b.f(j3);
        this.f48357b.c((this.f48358c == null || this.f48359d == null) ? 1 : 2);
        this.f48361f = true;
    }
}
