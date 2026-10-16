package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RgbFilter implements RgbMatrix {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float[] f42552c = {0.2126f, 0.2126f, 0.2126f, 0.0f, 0.7152f, 0.7152f, 0.7152f, 0.0f, 0.0722f, 0.0722f, 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f42553d = {0.2627f, 0.2627f, 0.2627f, 0.0f, 0.678f, 0.678f, 0.678f, 0.0f, 0.0593f, 0.0593f, 0.0593f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float[] f42554e = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f42555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f42556b;

    private void k(boolean z2) {
        Boolean bool = this.f42556b;
        if (bool == null) {
            this.f42556b = Boolean.valueOf(z2);
        } else {
            Assertions.h(bool.booleanValue() == z2, "Changing HDR setting is not supported.");
        }
    }

    @Override // androidx.media3.effect.RgbMatrix
    public float[] g(long j3, boolean z2) {
        k(z2);
        int i3 = this.f42555a;
        if (i3 == 1) {
            return z2 ? f42553d : f42552c;
        }
        if (i3 == 2) {
            return f42554e;
        }
        throw new IllegalStateException("Invalid color filter " + this.f42555a);
    }

    @Override // androidx.media3.effect.RgbMatrix, androidx.media3.effect.GlEffect
    public BaseGlShaderProgram a(Context context, boolean z2) {
        k(z2);
        return super.a(context, z2);
    }
}
