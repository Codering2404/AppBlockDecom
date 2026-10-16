package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.SpeedProviderUtil;
import androidx.media3.common.util.TimestampConsumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimestampAdjustment implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimestampMap f42653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeedProvider f42654b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TimestampMap {
        void a(long j3, TimestampConsumer timestampConsumer);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram a(Context context, boolean z2) {
        return new TimestampAdjustmentShaderProgram(this.f42653a);
    }

    @Override // androidx.media3.common.Effect
    public long e(long j3) {
        return SpeedProviderUtil.a(this.f42654b, j3);
    }
}
