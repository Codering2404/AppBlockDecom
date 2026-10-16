package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ColorLut extends GlEffect {
    @Override // androidx.media3.effect.GlEffect
    default GlShaderProgram a(Context context, boolean z2) {
        return new ColorLutShaderProgram(context, this, z2);
    }

    int f(long j3);

    int h(long j3);

    void release();
}
