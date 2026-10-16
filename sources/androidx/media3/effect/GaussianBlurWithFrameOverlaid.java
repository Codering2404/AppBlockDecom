package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GaussianBlurWithFrameOverlaid extends SeparableConvolution {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f42434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f42435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f42436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f42437f;

    @Override // androidx.media3.effect.SeparableConvolution, androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new SharpSeparableConvolutionShaderProgram(context, z2, this, this.f42436e, this.f42437f);
    }

    @Override // androidx.media3.effect.SeparableConvolution
    public ConvolutionFunction1D k(long j3) {
        return new GaussianFunction(this.f42434c, this.f42435d);
    }
}
