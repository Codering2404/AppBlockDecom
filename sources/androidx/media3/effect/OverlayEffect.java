package androidx.media3.effect;

import android.content.Context;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class OverlayEffect implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f42503a;

    @Override // androidx.media3.effect.GlEffect
    public BaseGlShaderProgram a(Context context, boolean z2) {
        return new OverlayShaderProgram(context, z2, this.f42503a);
    }
}
