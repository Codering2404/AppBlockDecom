package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackParameters {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PlaybackParameters f40950d = new PlaybackParameters(1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f40951e = Util.y0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f40952f = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f40953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f40954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f40955c;

    public PlaybackParameters(float f3) {
        this(f3, 1.0f);
    }

    public long a(long j3) {
        return j3 * ((long) this.f40955c);
    }

    public PlaybackParameters b(float f3) {
        return new PlaybackParameters(f3, this.f40954b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PlaybackParameters.class == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.f40953a == playbackParameters.f40953a && this.f40954b == playbackParameters.f40954b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f40953a)) * 31) + Float.floatToRawIntBits(this.f40954b);
    }

    public String toString() {
        return Util.J("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f40953a), Float.valueOf(this.f40954b));
    }

    public PlaybackParameters(float f3, float f4) {
        Assertions.a(f3 > 0.0f);
        Assertions.a(f4 > 0.0f);
        this.f40953a = f3;
        this.f40954b = f4;
        this.f40955c = Math.round(f3 * 1000.0f);
    }
}
