package androidx.media3.transformer;

import androidx.media3.transformer.AssetLoader;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class TextureAssetLoader implements AssetLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditedMediaItem f48465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetLoader.Listener f48466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f48468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f48469e;

    @Override // androidx.media3.transformer.AssetLoader
    public int e(ProgressHolder progressHolder) {
        if (this.f48467c == 2) {
            progressHolder.f48349a = Math.round((this.f48469e / this.f48465a.f48099e) * 100.0f);
        }
        return this.f48467c;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public ImmutableMap g() {
        return ImmutableMap.n();
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void release() {
        this.f48467c = 0;
    }

    @Override // androidx.media3.transformer.AssetLoader
    public void start() {
        this.f48467c = 2;
        this.f48466b.f(this.f48465a.f48099e);
        this.f48466b.c(1);
        this.f48468d = true;
    }
}
