package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SeparableConvolution implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42569b;

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new SeparableConvolutionShaderProgram(context, z2, this, this.f42568a, this.f42569b);
    }

    public abstract ConvolutionFunction1D k(long j3);
}
