package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameDropEffect implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42431b;

    private FrameDropEffect(float f3, float f4) {
        this.f42430a = f3;
        this.f42431b = f4;
    }

    public static FrameDropEffect k(float f3) {
        return new FrameDropEffect(-3.4028235E38f, f3);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        float f3 = this.f42430a;
        return f3 == -3.4028235E38f ? new DefaultFrameDroppingShaderProgram(context, z2, this.f42431b) : new SimpleFrameDroppingShaderProgram(f3, this.f42431b);
    }
}
