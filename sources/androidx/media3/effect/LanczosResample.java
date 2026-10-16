package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;
import androidx.media3.effect.ConvolutionFunction1D;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LanczosResample implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f42463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f42464c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LanczosResampleScaledFunctionProvider implements ConvolutionFunction1D.Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f42465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f42466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f42467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f42468d;

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size a(Size size) {
            this.f42468d = LanczosResample.l(size.b(), size.a(), this.f42466b, this.f42467c);
            return new Size(Math.round(size.b() * this.f42468d), Math.round(size.a() * this.f42468d));
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D b(long j3) {
            return new ScaledLanczosFunction(this.f42465a, Math.min(this.f42468d, 1.0f));
        }

        private LanczosResampleScaledFunctionProvider(float f3, int i3, int i4) {
            Assertions.a(f3 > 0.0f);
            Assertions.a(i3 > 0);
            Assertions.a(i4 > 0);
            this.f42465a = f3;
            this.f42466b = i3;
            this.f42467c = i4;
            this.f42468d = -3.4028235E38f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float l(int i3, int i4, int i5, int i6) {
        Assertions.a(i3 > 0);
        Assertions.a(i4 > 0);
        return i4 * i5 <= i6 * i3 ? i5 / i3 : i6 / i4;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new SeparableConvolutionShaderProgram(context, z2, new LanczosResampleScaledFunctionProvider(this.f42462a, this.f42463b, this.f42464c));
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return Math.abs(l(i3, i4, this.f42463b, this.f42464c) - 1.0f) < 0.01f;
    }
}
