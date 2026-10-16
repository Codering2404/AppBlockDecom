package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f42878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f42879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f42880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f42881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f42882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f42883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f42884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f42885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f42886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f42887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f42888k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f42889l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f42890m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f42891n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f42892o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f42893p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f42894q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f42895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f42896s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f42897a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f42898b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f42899c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f42900d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f42901e = Util.P0(20);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f42902f = Util.P0(500);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f42903g = 0.999f;

        public DefaultLivePlaybackSpeedControl a() {
            return new DefaultLivePlaybackSpeedControl(this.f42897a, this.f42898b, this.f42899c, this.f42900d, this.f42901e, this.f42902f, this.f42903g);
        }
    }

    private void f(long j3) {
        long j4 = this.f42895r + (this.f42896s * 3);
        if (this.f42890m > j4) {
            float fP0 = Util.P0(this.f42880c);
            this.f42890m = Longs.h(j4, this.f42887j, this.f42890m - (((long) ((this.f42893p - 1.0f) * fP0)) + ((long) ((this.f42891n - 1.0f) * fP0))));
            return;
        }
        long jS = Util.s(j3 - ((long) (Math.max(0.0f, this.f42893p - 1.0f) / this.f42881d)), this.f42890m, j4);
        this.f42890m = jS;
        long j5 = this.f42889l;
        if (j5 == -9223372036854775807L || jS <= j5) {
            return;
        }
        this.f42890m = j5;
    }

    private void g() {
        long j3;
        long j4 = this.f42885h;
        if (j4 != -9223372036854775807L) {
            j3 = this.f42886i;
            if (j3 == -9223372036854775807L) {
                long j5 = this.f42888k;
                if (j5 != -9223372036854775807L && j4 < j5) {
                    j4 = j5;
                }
                j3 = this.f42889l;
                if (j3 == -9223372036854775807L || j4 <= j3) {
                    j3 = j4;
                }
            }
        } else {
            j3 = -9223372036854775807L;
        }
        if (this.f42887j == j3) {
            return;
        }
        this.f42887j = j3;
        this.f42890m = j3;
        this.f42895r = -9223372036854775807L;
        this.f42896s = -9223372036854775807L;
        this.f42894q = -9223372036854775807L;
    }

    private static long h(long j3, long j4, float f3) {
        return (long) ((j3 * f3) + ((1.0f - f3) * j4));
    }

    private void i(long j3, long j4) {
        long j5 = j3 - j4;
        long j6 = this.f42895r;
        if (j6 == -9223372036854775807L) {
            this.f42895r = j5;
            this.f42896s = 0L;
        } else {
            long jMax = Math.max(j5, h(j6, j5, this.f42884g));
            this.f42895r = jMax;
            this.f42896s = h(this.f42896s, Math.abs(j5 - jMax), this.f42884g);
        }
    }

    @Override // androidx.media3.exoplayer.LivePlaybackSpeedControl
    public void a(MediaItem.LiveConfiguration liveConfiguration) {
        this.f42885h = Util.P0(liveConfiguration.f40792a);
        this.f42888k = Util.P0(liveConfiguration.f40793b);
        this.f42889l = Util.P0(liveConfiguration.f40794c);
        float f3 = liveConfiguration.f40795d;
        if (f3 == -3.4028235E38f) {
            f3 = this.f42878a;
        }
        this.f42892o = f3;
        float f4 = liveConfiguration.f40796e;
        if (f4 == -3.4028235E38f) {
            f4 = this.f42879b;
        }
        this.f42891n = f4;
        if (f3 == 1.0f && f4 == 1.0f) {
            this.f42885h = -9223372036854775807L;
        }
        g();
    }

    @Override // androidx.media3.exoplayer.LivePlaybackSpeedControl
    public float b(long j3, long j4) {
        if (this.f42885h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j3, j4);
        if (this.f42894q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f42894q < this.f42880c) {
            return this.f42893p;
        }
        this.f42894q = SystemClock.elapsedRealtime();
        f(j3);
        long j5 = j3 - this.f42890m;
        if (Math.abs(j5) < this.f42882e) {
            this.f42893p = 1.0f;
        } else {
            this.f42893p = Util.q((this.f42881d * j5) + 1.0f, this.f42892o, this.f42891n);
        }
        return this.f42893p;
    }

    @Override // androidx.media3.exoplayer.LivePlaybackSpeedControl
    public long c() {
        return this.f42890m;
    }

    @Override // androidx.media3.exoplayer.LivePlaybackSpeedControl
    public void d() {
        long j3 = this.f42890m;
        if (j3 == -9223372036854775807L) {
            return;
        }
        long j4 = j3 + this.f42883f;
        this.f42890m = j4;
        long j5 = this.f42889l;
        if (j5 != -9223372036854775807L && j4 > j5) {
            this.f42890m = j5;
        }
        this.f42894q = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.LivePlaybackSpeedControl
    public void e(long j3) {
        this.f42886i = j3;
        g();
    }

    private DefaultLivePlaybackSpeedControl(float f3, float f4, long j3, float f5, long j4, long j5, float f6) {
        this.f42878a = f3;
        this.f42879b = f4;
        this.f42880c = j3;
        this.f42881d = f5;
        this.f42882e = j4;
        this.f42883f = j5;
        this.f42884g = f6;
        this.f42885h = -9223372036854775807L;
        this.f42886i = -9223372036854775807L;
        this.f42888k = -9223372036854775807L;
        this.f42889l = -9223372036854775807L;
        this.f42892o = f3;
        this.f42891n = f4;
        this.f42893p = 1.0f;
        this.f42894q = -9223372036854775807L;
        this.f42887j = -9223372036854775807L;
        this.f42890m = -9223372036854775807L;
        this.f42895r = -9223372036854775807L;
        this.f42896s = -9223372036854775807L;
    }
}
