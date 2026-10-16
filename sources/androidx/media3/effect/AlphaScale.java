package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AlphaScale implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42173a;

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return this.f42173a == 1.0f;
    }

    @Override // androidx.media3.effect.GlEffect
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public AlphaScaleShaderProgram a(Context context, boolean z2) {
        return new AlphaScaleShaderProgram(context, z2, this.f42173a);
    }
}
