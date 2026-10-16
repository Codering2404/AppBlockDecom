package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioTrackPositionTracker {
    private long A;
    private long B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private boolean H;
    private long I;
    private Clock J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Listener f43730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f43731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AudioTrack f43732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioTimestampPoller f43735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f43737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f43738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f43739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f43741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f43742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Method f43743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f43744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f43745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f43746q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f43747r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f43748s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f43749t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f43750u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f43751v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f43752w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f43753x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f43754y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f43755z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(int i3, long j3);

        void b(long j3);

        void c(long j3);

        void d(long j3, long j4, long j5, long j6);

        void e(long j3, long j4, long j5, long j6);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f43730a = (Listener) Assertions.e(listener);
        try {
            this.f43743n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f43731b = new long[10];
        this.J = Clock.f41485a;
    }

    private boolean b() {
        return this.f43737h && ((AudioTrack) Assertions.e(this.f43732c)).getPlayState() == 2 && d() == 0;
    }

    private long d() {
        if (this.f43754y != -9223372036854775807L) {
            return Math.min(this.B, f());
        }
        long jA = this.J.a();
        if (jA - this.f43748s >= 5) {
            w(jA);
            this.f43748s = jA;
        }
        return this.f43749t + this.I + (this.f43750u << 32);
    }

    private long e() {
        return Util.Y0(d(), this.f43736g);
    }

    private long f() {
        if (((AudioTrack) Assertions.e(this.f43732c)).getPlayState() == 2) {
            return this.A;
        }
        return this.A + Util.I(Util.f0(Util.P0(this.J.a()) - this.f43754y, this.f43739j), this.f43736g);
    }

    private void l(long j3) {
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.e(this.f43735f);
        if (audioTimestampPoller.f(j3)) {
            long jD = audioTimestampPoller.d();
            long jC = audioTimestampPoller.c();
            long jE = e();
            if (Math.abs(jD - j3) > 5000000) {
                this.f43730a.e(jC, jD, j3, jE);
                audioTimestampPoller.g();
            } else if (Math.abs(Util.Y0(jC, this.f43736g) - jE) <= 5000000) {
                audioTimestampPoller.a();
            } else {
                this.f43730a.d(jC, jD, j3, jE);
                audioTimestampPoller.g();
            }
        }
    }

    private void m() {
        long jB = this.J.b() / 1000;
        if (jB - this.f43742m >= 30000) {
            long jE = e();
            if (jE != 0) {
                this.f43731b[this.f43752w] = Util.l0(jE, this.f43739j) - jB;
                this.f43752w = (this.f43752w + 1) % 10;
                int i3 = this.f43753x;
                if (i3 < 10) {
                    this.f43753x = i3 + 1;
                }
                this.f43742m = jB;
                this.f43741l = 0L;
                int i4 = 0;
                while (true) {
                    int i5 = this.f43753x;
                    if (i4 >= i5) {
                        break;
                    }
                    this.f43741l += this.f43731b[i4] / ((long) i5);
                    i4++;
                }
            } else {
                return;
            }
        }
        if (this.f43737h) {
            return;
        }
        l(jB);
        n(jB);
    }

    private void n(long j3) {
        Method method;
        if (!this.f43746q || (method = this.f43743n) == null || j3 - this.f43747r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) Util.k((Integer) method.invoke(Assertions.e(this.f43732c), null))).intValue()) * 1000) - this.f43738i;
            this.f43744o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f43744o = jMax;
            if (jMax > 5000000) {
                this.f43730a.c(jMax);
                this.f43744o = 0L;
            }
        } catch (Exception unused) {
            this.f43743n = null;
        }
        this.f43747r = j3;
    }

    private static boolean o(int i3) {
        if (Util.f41609a < 23) {
            return i3 == 5 || i3 == 6;
        }
        return false;
    }

    private void r() {
        this.f43741l = 0L;
        this.f43753x = 0;
        this.f43752w = 0;
        this.f43742m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f43740k = false;
    }

    private void w(long j3) {
        AudioTrack audioTrack = (AudioTrack) Assertions.e(this.f43732c);
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f43737h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f43751v = this.f43749t;
            }
            playbackHeadPosition += this.f43751v;
        }
        if (Util.f41609a <= 29) {
            if (playbackHeadPosition == 0 && this.f43749t > 0 && playState == 3) {
                if (this.f43755z == -9223372036854775807L) {
                    this.f43755z = j3;
                    return;
                }
                return;
            }
            this.f43755z = -9223372036854775807L;
        }
        long j4 = this.f43749t;
        if (j4 > playbackHeadPosition) {
            if (this.H) {
                this.I += j4;
                this.H = false;
            } else {
                this.f43750u++;
            }
        }
        this.f43749t = playbackHeadPosition;
    }

    public void a() {
        this.H = true;
        AudioTimestampPoller audioTimestampPoller = this.f43735f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.b();
        }
    }

    public long c() {
        long jMin;
        AudioTrack audioTrack = (AudioTrack) Assertions.e(this.f43732c);
        if (audioTrack.getPlayState() == 3) {
            m();
        }
        long jB = this.J.b() / 1000;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.e(this.f43735f);
        boolean zE = audioTimestampPoller.e();
        if (zE) {
            jMin = Util.Y0(audioTimestampPoller.c(), this.f43736g) + Util.f0(jB - audioTimestampPoller.d(), this.f43739j);
        } else {
            long jMax = Math.max(0L, (this.f43753x == 0 ? this.f43754y != -9223372036854775807L ? Util.Y0(f(), this.f43736g) : e() : Util.f0(this.f43741l + jB, this.f43739j)) - this.f43744o);
            jMin = this.f43754y != -9223372036854775807L ? Math.min(Util.Y0(this.B, this.f43736g), jMax) : jMax;
        }
        if (this.E != zE) {
            this.G = this.D;
            this.F = this.C;
        }
        long j3 = jB - this.G;
        if (j3 < 1000000) {
            long jF0 = this.F + Util.f0(j3, this.f43739j);
            long j4 = (j3 * 1000) / 1000000;
            jMin = ((jMin * j4) + ((1000 - j4) * jF0)) / 1000;
        }
        if (!this.f43740k && jMin > this.C && audioTrack.getPlayState() == 3) {
            this.f43740k = true;
            this.f43730a.b(this.J.currentTimeMillis() - Util.t1(Util.l0(Util.t1(jMin - this.C), this.f43739j)));
        }
        this.D = jB;
        this.C = jMin;
        this.E = zE;
        return jMin;
    }

    public void g(long j3) {
        this.A = d();
        this.f43754y = Util.P0(this.J.a());
        this.B = j3;
    }

    public boolean h(long j3) {
        return j3 > Util.I(c(), this.f43736g) || b();
    }

    public boolean i() {
        return ((AudioTrack) Assertions.e(this.f43732c)).getPlayState() == 3;
    }

    public boolean j(long j3) {
        return this.f43755z != -9223372036854775807L && j3 > 0 && this.J.a() - this.f43755z >= 200;
    }

    public boolean k(long j3) {
        int playState = ((AudioTrack) Assertions.e(this.f43732c)).getPlayState();
        if (this.f43737h) {
            if (playState == 2) {
                this.f43745p = false;
                return false;
            }
            if (playState == 1 && d() == 0) {
                return false;
            }
        }
        boolean z2 = this.f43745p;
        boolean zH = h(j3);
        this.f43745p = zH;
        if (z2 && !zH && playState != 1) {
            this.f43730a.a(this.f43734e, Util.t1(this.f43738i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f43754y == -9223372036854775807L) {
            ((AudioTimestampPoller) Assertions.e(this.f43735f)).h();
            return true;
        }
        this.A = d();
        return false;
    }

    public void q() {
        r();
        this.f43732c = null;
        this.f43735f = null;
    }

    public void s(AudioTrack audioTrack, boolean z2, int i3, int i4, int i5) {
        this.f43732c = audioTrack;
        this.f43733d = i4;
        this.f43734e = i5;
        this.f43735f = new AudioTimestampPoller(audioTrack);
        this.f43736g = audioTrack.getSampleRate();
        this.f43737h = z2 && o(i3);
        boolean zC0 = Util.C0(i3);
        this.f43746q = zC0;
        this.f43738i = zC0 ? Util.Y0(i5 / i4, this.f43736g) : -9223372036854775807L;
        this.f43749t = 0L;
        this.f43750u = 0L;
        this.H = false;
        this.I = 0L;
        this.f43751v = 0L;
        this.f43745p = false;
        this.f43754y = -9223372036854775807L;
        this.f43755z = -9223372036854775807L;
        this.f43747r = 0L;
        this.f43744o = 0L;
        this.f43739j = 1.0f;
    }

    public void t(float f3) {
        this.f43739j = f3;
        AudioTimestampPoller audioTimestampPoller = this.f43735f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.h();
        }
        r();
    }

    public void u(Clock clock) {
        this.J = clock;
    }

    public void v() {
        if (this.f43754y != -9223372036854775807L) {
            this.f43754y = Util.P0(this.J.a());
        }
        ((AudioTimestampPoller) Assertions.e(this.f43735f)).h();
    }
}
