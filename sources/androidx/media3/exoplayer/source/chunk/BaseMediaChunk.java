package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMediaChunk extends MediaChunk {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f45067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f45068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BaseMediaChunkOutput f45069l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f45070m;

    public final int g(int i3) {
        return ((int[]) Assertions.i(this.f45070m))[i3];
    }

    protected final BaseMediaChunkOutput h() {
        return (BaseMediaChunkOutput) Assertions.i(this.f45069l);
    }

    public void i(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.f45069l = baseMediaChunkOutput;
        this.f45070m = baseMediaChunkOutput.a();
    }
}
