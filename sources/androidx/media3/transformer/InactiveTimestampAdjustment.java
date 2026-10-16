package androidx.media3.transformer;

import android.content.Context;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.SpeedProviderUtil;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.PassthroughShaderProgram;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class InactiveTimestampAdjustment implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeedProvider f48283a;

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new PassthroughShaderProgram();
    }

    @Override // androidx.media3.common.Effect
    public long e(long j3) {
        return SpeedProviderUtil.a(this.f48283a, j3);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean i(int i3, int i4) {
        return true;
    }
}
