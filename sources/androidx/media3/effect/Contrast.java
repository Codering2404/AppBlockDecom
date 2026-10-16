package androidx.media3.effect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Contrast implements RgbMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f42237b;

    @Override // androidx.media3.effect.RgbMatrix
    public float[] g(long j3, boolean z2) {
        return this.f42237b;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return this.f42236a == 0.0f;
    }
}
