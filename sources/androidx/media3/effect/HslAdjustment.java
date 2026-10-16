package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HslAdjustment implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f42441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f42442c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return this.f42440a == 0.0f && this.f42441b == 0.0f && this.f42442c == 0.0f;
    }

    @Override // androidx.media3.effect.GlEffect
    public BaseGlShaderProgram a(Context context, boolean z2) {
        return new HslShaderProgram(context, this, z2);
    }
}
