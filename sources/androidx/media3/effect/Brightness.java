package androidx.media3.effect;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Brightness implements RgbMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f42206a;

    @Override // androidx.media3.effect.RgbMatrix
    public float[] g(long j3, boolean z2) {
        Assertions.b(!z2, "HDR is not supported.");
        return this.f42206a;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return Arrays.equals(this.f42206a, GlUtil.h());
    }
}
