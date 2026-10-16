package androidx.media3.effect;

import androidx.media3.common.util.Assertions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GaussianFunction implements ConvolutionFunction1D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42439b;

    public GaussianFunction(float f3, float f4) {
        Assertions.a(f3 > 0.0f && f4 > 0.0f);
        this.f42438a = f3;
        this.f42439b = f4;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float a(float f3) {
        float fAbs = Math.abs(f3);
        float f4 = this.f42439b;
        float f5 = this.f42438a;
        if (fAbs > f4 * f5) {
            return 0.0f;
        }
        float f6 = f3 / f5;
        return (float) ((Math.exp(((-f6) * f6) / 2.0f) / Math.sqrt(6.283185307179586d)) / ((double) this.f42438a));
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float b() {
        return this.f42439b * this.f42438a;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float c() {
        return (-this.f42439b) * this.f42438a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GaussianFunction)) {
            return false;
        }
        GaussianFunction gaussianFunction = (GaussianFunction) obj;
        return Float.compare(gaussianFunction.f42438a, this.f42438a) == 0 && Float.compare(gaussianFunction.f42439b, this.f42439b) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f42438a), Float.valueOf(this.f42439b));
    }
}
