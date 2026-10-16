package androidx.media3.effect;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimestampWrapper implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GlEffect f42663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f42664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f42665c;

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new TimestampWrapperShaderProgram(context, z2, this);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return this.f42663a.i(i3, i4);
    }
}
