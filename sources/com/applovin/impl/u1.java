package com.applovin.impl;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class u1 {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f64036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f64037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AudioTrack f64038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f64039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f64040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private t1 f64041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f64042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f64043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f64044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f64045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f64046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f64047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f64048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Method f64049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f64050o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f64051p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f64052q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f64053r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f64054s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f64055t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f64056u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f64057v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f64058w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f64059x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f64060y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f64061z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(int i3, long j3);

        void a(long j3);

        void a(long j3, long j4, long j5, long j6);

        void b(long j3);

        void b(long j3, long j4, long j5, long j6);
    }

    public u1(a aVar) {
        this.f64036a = (a) b1.a(aVar);
        if (xp.f65027a >= 18) {
            try {
                this.f64049n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f64037b = new long[10];
    }

    private boolean a() {
        return this.f64043h && ((AudioTrack) b1.a(this.f64038c)).getPlayState() == 2 && b() == 0;
    }

    private void h(long j3) {
        Method method;
        if (!this.f64052q || (method = this.f64049n) == null || j3 - this.f64053r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) xp.a((Integer) method.invoke(b1.a(this.f64038c), null))).intValue()) * 1000) - this.f64044i;
            this.f64050o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f64050o = jMax;
            if (jMax > 5000000) {
                this.f64036a.b(jMax);
                this.f64050o = 0L;
            }
        } catch (Exception unused) {
            this.f64049n = null;
        }
        this.f64053r = j3;
    }

    public int b(long j3) {
        return this.f64040e - ((int) (j3 - (b() * ((long) this.f64039d))));
    }

    public long c(long j3) {
        return t2.b(a(j3 - b()));
    }

    public void d(long j3) {
        this.f64061z = b();
        this.f64059x = SystemClock.elapsedRealtime() * 1000;
        this.A = j3;
    }

    public boolean e(long j3) {
        return j3 > b() || a();
    }

    public boolean f(long j3) {
        return this.f64060y != -9223372036854775807L && j3 > 0 && SystemClock.elapsedRealtime() - this.f64060y >= 200;
    }

    public boolean g(long j3) {
        int playState = ((AudioTrack) b1.a(this.f64038c)).getPlayState();
        if (this.f64043h) {
            if (playState == 2) {
                this.f64051p = false;
                return false;
            }
            if (playState == 1 && b() == 0) {
                return false;
            }
        }
        boolean z2 = this.f64051p;
        boolean zE = e(j3);
        this.f64051p = zE;
        if (z2 && !zE && playState != 1) {
            this.f64036a.a(this.f64040e, t2.b(this.f64044i));
        }
        return true;
    }

    public void i() {
        ((t1) b1.a(this.f64041f)).f();
    }

    private long c() {
        return a(b());
    }

    private void e() {
        long jC = c();
        if (jC == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f64048m >= 30000) {
            long[] jArr = this.f64037b;
            int i3 = this.f64057v;
            jArr[i3] = jC - jNanoTime;
            this.f64057v = (i3 + 1) % 10;
            int i4 = this.f64058w;
            if (i4 < 10) {
                this.f64058w = i4 + 1;
            }
            this.f64048m = jNanoTime;
            this.f64047l = 0L;
            int i5 = 0;
            while (true) {
                int i6 = this.f64058w;
                if (i5 >= i6) {
                    break;
                }
                this.f64047l += this.f64037b[i5] / ((long) i6);
                i5++;
            }
        }
        if (this.f64043h) {
            return;
        }
        a(jNanoTime, jC);
        h(jNanoTime);
    }

    private long b() {
        AudioTrack audioTrack = (AudioTrack) b1.a(this.f64038c);
        if (this.f64059x != -9223372036854775807L) {
            return Math.min(this.A, this.f64061z + ((((SystemClock.elapsedRealtime() * 1000) - this.f64059x) * ((long) this.f64042g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f64043h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f64056u = this.f64054s;
            }
            playbackHeadPosition += this.f64056u;
        }
        if (xp.f65027a <= 29) {
            if (playbackHeadPosition == 0 && this.f64054s > 0 && playState == 3) {
                if (this.f64060y == -9223372036854775807L) {
                    this.f64060y = SystemClock.elapsedRealtime();
                }
                return this.f64054s;
            }
            this.f64060y = -9223372036854775807L;
        }
        if (this.f64054s > playbackHeadPosition) {
            this.f64055t++;
        }
        this.f64054s = playbackHeadPosition;
        return playbackHeadPosition + (this.f64055t << 32);
    }

    public boolean f() {
        h();
        if (this.f64059x != -9223372036854775807L) {
            return false;
        }
        ((t1) b1.a(this.f64041f)).f();
        return true;
    }

    private long a(long j3) {
        return (j3 * 1000000) / ((long) this.f64042g);
    }

    public boolean d() {
        return ((AudioTrack) b1.a(this.f64038c)).getPlayState() == 3;
    }

    public long a(boolean z2) {
        long jMax;
        if (((AudioTrack) b1.a(this.f64038c)).getPlayState() == 3) {
            e();
        }
        long jNanoTime = System.nanoTime() / 1000;
        t1 t1Var = (t1) b1.a(this.f64041f);
        boolean zD = t1Var.d();
        if (zD) {
            jMax = a(t1Var.b()) + xp.a(jNanoTime - t1Var.c(), this.f64045j);
        } else {
            if (this.f64058w == 0) {
                jMax = c();
            } else {
                jMax = this.f64047l + jNanoTime;
            }
            if (!z2) {
                jMax = Math.max(0L, jMax - this.f64050o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j3 = jNanoTime - this.F;
        if (j3 < 1000000) {
            long jA = this.E + xp.a(j3, this.f64045j);
            long j4 = (j3 * 1000) / 1000000;
            jMax = ((jMax * j4) + ((1000 - j4) * jA)) / 1000;
        }
        if (!this.f64046k) {
            long j5 = this.B;
            if (jMax > j5) {
                this.f64046k = true;
                this.f64036a.a(System.currentTimeMillis() - t2.b(xp.b(t2.b(jMax - j5), this.f64045j)));
            }
        }
        this.C = jNanoTime;
        this.B = jMax;
        this.D = zD;
        return jMax;
    }

    public void g() {
        h();
        this.f64038c = null;
        this.f64041f = null;
    }

    private void h() {
        this.f64047l = 0L;
        this.f64058w = 0;
        this.f64057v = 0;
        this.f64048m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f64046k = false;
    }

    private void a(long j3, long j4) {
        t1 t1Var = (t1) b1.a(this.f64041f);
        if (t1Var.a(j3)) {
            long jC = t1Var.c();
            long jB = t1Var.b();
            if (Math.abs(jC - j3) > 5000000) {
                this.f64036a.b(jB, jC, j3, j4);
                t1Var.e();
            } else if (Math.abs(a(jB) - j4) > 5000000) {
                this.f64036a.a(jB, jC, j3, j4);
                t1Var.e();
            } else {
                t1Var.a();
            }
        }
    }

    public void a(AudioTrack audioTrack, boolean z2, int i3, int i4, int i5) {
        this.f64038c = audioTrack;
        this.f64039d = i4;
        this.f64040e = i5;
        this.f64041f = new t1(audioTrack);
        this.f64042g = audioTrack.getSampleRate();
        this.f64043h = z2 && a(i3);
        boolean zG = xp.g(i3);
        this.f64052q = zG;
        this.f64044i = zG ? a(i5 / i4) : -9223372036854775807L;
        this.f64054s = 0L;
        this.f64055t = 0L;
        this.f64056u = 0L;
        this.f64051p = false;
        this.f64059x = -9223372036854775807L;
        this.f64060y = -9223372036854775807L;
        this.f64053r = 0L;
        this.f64050o = 0L;
        this.f64045j = 1.0f;
    }

    public void a(float f3) {
        this.f64045j = f3;
        t1 t1Var = this.f64041f;
        if (t1Var != null) {
            t1Var.f();
        }
    }

    private static boolean a(int i3) {
        if (xp.f65027a < 23) {
            return i3 == 5 || i3 == 6;
        }
        return false;
    }
}
