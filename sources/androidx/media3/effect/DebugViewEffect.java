package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugViewEffect implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DebugViewProvider f42253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorInfo f42254b;

    public DebugViewEffect(DebugViewProvider debugViewProvider, ColorInfo colorInfo) {
        this.f42253a = debugViewProvider;
        this.f42254b = colorInfo;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new DebugViewShaderProgram(context, this.f42253a, this.f42254b);
    }
}
