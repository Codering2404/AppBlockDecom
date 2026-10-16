package androidx.media3.effect;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ScaledLanczosFunction implements ConvolutionFunction1D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42567b;

    public ScaledLanczosFunction(float f3, float f4) {
        this.f42566a = f3;
        this.f42567b = f4;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float a(float f3) {
        float f4 = f3 * this.f42567b;
        if (Math.abs(f4) < 1.0E-5d) {
            return 1.0f;
        }
        float fAbs = Math.abs(f4);
        float f5 = this.f42566a;
        if (fAbs > f5) {
            return 0.0f;
        }
        double d3 = f4;
        double d4 = 3.141592653589793d * d3;
        return (float) (((((double) f5) * Math.sin(d4)) * Math.sin(d4 / ((double) this.f42566a))) / ((9.869604401089358d * d3) * d3));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float b() {
        return this.f42566a / this.f42567b;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float c() {
        return (-this.f42566a) / this.f42567b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledLanczosFunction)) {
            return false;
        }
        ScaledLanczosFunction scaledLanczosFunction = (ScaledLanczosFunction) obj;
        return Float.compare(scaledLanczosFunction.f42566a, this.f42566a) == 0 && Float.compare(scaledLanczosFunction.f42567b, this.f42567b) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f42566a), Float.valueOf(this.f42567b));
    }
}
