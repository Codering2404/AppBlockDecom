package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.SpeedProviderUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpeedChangeEffect implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SpeedProvider f42615a;

    /* JADX INFO: renamed from: androidx.media3.effect.SpeedChangeEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements SpeedProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f42616a;

        @Override // androidx.media3.common.audio.SpeedProvider
        public float a(long j3) {
            return this.f42616a;
        }

        @Override // androidx.media3.common.audio.SpeedProvider
        public long b(long j3) {
            return -9223372036854775807L;
        }
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new SpeedChangeShaderProgram(this.f42615a);
    }

    @Override // androidx.media3.common.Effect
    public long e(long j3) {
        return SpeedProviderUtil.a(this.f42615a, j3);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return this.f42615a.a(0L) == 1.0f && this.f42615a.b(0L) == -9223372036854775807L;
    }
}
