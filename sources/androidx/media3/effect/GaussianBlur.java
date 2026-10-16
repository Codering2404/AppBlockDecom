package androidx.media3.effect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GaussianBlur extends SeparableConvolution {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f42432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f42433d;

    @Override // androidx.media3.effect.SeparableConvolution
    public ConvolutionFunction1D k(long j3) {
        return new GaussianFunction(this.f42432c, this.f42433d);
    }
}
