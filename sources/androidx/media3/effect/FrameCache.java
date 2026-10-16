package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameCache implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42423a;

    public FrameCache(int i3) {
        Assertions.a(i3 > 0 && i3 < 9);
        this.f42423a = i3;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new FrameCacheGlShaderProgram(context, this.f42423a, z2);
    }
}
