package com.applovin.impl;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.impl.p1;
import com.applovin.impl.r1;
import com.applovin.impl.u1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class r5 implements r1 {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static boolean f62739a0 = false;
    private long A;
    private long B;
    private long C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private float H;
    private p1[] I;
    private ByteBuffer[] J;
    private ByteBuffer K;
    private int L;
    private ByteBuffer M;
    private byte[] N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private v1 V;
    private boolean W;
    private long X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f62740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f62741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f62742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d3 f62743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zo f62744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p1[] f62745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p1[] f62746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConditionVariable f62747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u1 f62748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayDeque f62749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f62750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f62751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f62752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final g f62753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final g f62754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private r1.c f62755p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f62756q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private c f62757r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AudioTrack f62758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private l1 f62759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private f f62760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f f62761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ph f62762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ByteBuffer f62763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f62764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f62765z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioTrack f62766a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AudioTrack audioTrack) {
            super(str);
            this.f62766a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f62766a.flush();
                this.f62766a.release();
            } finally {
                r5.this.f62747h.open();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        long a(long j3);

        ph a(ph phVar);

        boolean a(boolean z2);

        p1[] a();

        long b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e9 f62768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f62769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f62772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f62773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f62774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f62775h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final p1[] f62776i;

        public c(e9 e9Var, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2, p1[] p1VarArr) {
            this.f62768a = e9Var;
            this.f62769b = i3;
            this.f62770c = i4;
            this.f62771d = i5;
            this.f62772e = i6;
            this.f62773f = i7;
            this.f62774g = i8;
            this.f62776i = p1VarArr;
            this.f62775h = a(i9, z2);
        }

        private int c(long j3) {
            int iD = r5.d(this.f62774g);
            if (this.f62774g == 5) {
                iD *= 2;
            }
            return (int) ((j3 * ((long) iD)) / 1000000);
        }

        private AudioTrack d(boolean z2, l1 l1Var, int i3) {
            return new AudioTrack.Builder().setAudioAttributes(a(l1Var, z2)).setAudioFormat(r5.b(this.f62772e, this.f62773f, this.f62774g)).setTransferMode(1).setBufferSizeInBytes(this.f62775h).setSessionId(i3).setOffloadedPlayback(this.f62770c == 1).build();
        }

        public AudioTrack a(boolean z2, l1 l1Var, int i3) throws r1.b {
            try {
                AudioTrack audioTrackB = b(z2, l1Var, i3);
                int state = audioTrackB.getState();
                if (state == 1) {
                    return audioTrackB;
                }
                try {
                    audioTrackB.release();
                } catch (Exception unused) {
                }
                throw new r1.b(state, this.f62772e, this.f62773f, this.f62775h, this.f62768a, b(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e3) {
                throw new r1.b(0, this.f62772e, this.f62773f, this.f62775h, this.f62768a, b(), e3);
            }
        }

        public long b(long j3) {
            return (j3 * 1000000) / ((long) this.f62772e);
        }

        public boolean b() {
            return this.f62770c == 1;
        }

        private AudioTrack b(boolean z2, l1 l1Var, int i3) {
            int i4 = xp.f65027a;
            if (i4 >= 29) {
                return d(z2, l1Var, i3);
            }
            if (i4 >= 21) {
                return c(z2, l1Var, i3);
            }
            return a(l1Var, i3);
        }

        private AudioTrack c(boolean z2, l1 l1Var, int i3) {
            return new AudioTrack(a(l1Var, z2), r5.b(this.f62772e, this.f62773f, this.f62774g), this.f62775h, 1, i3);
        }

        public boolean a(c cVar) {
            return cVar.f62770c == this.f62770c && cVar.f62774g == this.f62774g && cVar.f62772e == this.f62772e && cVar.f62773f == this.f62773f && cVar.f62771d == this.f62771d;
        }

        private int a(int i3, boolean z2) {
            if (i3 != 0) {
                return i3;
            }
            int i4 = this.f62770c;
            if (i4 == 0) {
                return a(z2 ? 8.0f : 1.0f);
            }
            if (i4 == 1) {
                return c(50000000L);
            }
            if (i4 == 2) {
                return c(250000L);
            }
            throw new IllegalStateException();
        }

        public long d(long j3) {
            return (j3 * 1000000) / ((long) this.f62768a.A);
        }

        private AudioTrack a(l1 l1Var, int i3) {
            int iE = xp.e(l1Var.f61094c);
            if (i3 == 0) {
                return new AudioTrack(iE, this.f62772e, this.f62773f, this.f62774g, this.f62775h, 1);
            }
            return new AudioTrack(iE, this.f62772e, this.f62773f, this.f62774g, this.f62775h, 1, i3);
        }

        public long a(long j3) {
            return (j3 * ((long) this.f62772e)) / 1000000;
        }

        private static AudioAttributes a(l1 l1Var, boolean z2) {
            if (z2) {
                return a();
            }
            return l1Var.a();
        }

        private int a(float f3) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f62772e, this.f62773f, this.f62774g);
            b1.b(minBufferSize != -2);
            int iA = xp.a(minBufferSize * 4, ((int) a(250000L)) * this.f62771d, Math.max(minBufferSize, ((int) a(750000L)) * this.f62771d));
            return f3 != 1.0f ? Math.round(iA * f3) : iA;
        }

        private static AudioAttributes a() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p1[] f62777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ak f62778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ok f62779c;

        public d(p1... p1VarArr) {
            this(p1VarArr, new ak(), new ok());
        }

        @Override // com.applovin.impl.r5.b
        public ph a(ph phVar) {
            this.f62779c.b(phVar.f62440a);
            this.f62779c.a(phVar.f62441b);
            return phVar;
        }

        @Override // com.applovin.impl.r5.b
        public long b() {
            return this.f62778b.j();
        }

        public d(p1[] p1VarArr, ak akVar, ok okVar) {
            p1[] p1VarArr2 = new p1[p1VarArr.length + 2];
            this.f62777a = p1VarArr2;
            System.arraycopy(p1VarArr, 0, p1VarArr2, 0, p1VarArr.length);
            this.f62778b = akVar;
            this.f62779c = okVar;
            p1VarArr2[p1VarArr.length] = akVar;
            p1VarArr2[p1VarArr.length + 1] = okVar;
        }

        @Override // com.applovin.impl.r5.b
        public boolean a(boolean z2) {
            this.f62778b.a(z2);
            return z2;
        }

        @Override // com.applovin.impl.r5.b
        public p1[] a() {
            return this.f62777a;
        }

        @Override // com.applovin.impl.r5.b
        public long a(long j3) {
            return this.f62779c.a(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e extends RuntimeException {
        private e(String str) {
            super(str);
        }

        /* synthetic */ e(String str, a aVar) {
            this(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f62784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Exception f62785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f62786c;

        public g(long j3) {
            this.f62784a = j3;
        }

        public void a() {
            this.f62785b = null;
        }

        public void a(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f62785b == null) {
                this.f62785b = exc;
                this.f62786c = this.f62784a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f62786c) {
                Exception exc2 = this.f62785b;
                if (exc2 != exc) {
                    exc2.addSuppressed(exc);
                }
                Exception exc3 = this.f62785b;
                a();
                throw exc3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class h implements u1.a {
        private h() {
        }

        @Override // com.applovin.impl.u1.a
        public void a(long j3) {
            if (r5.this.f62755p != null) {
                r5.this.f62755p.a(j3);
            }
        }

        @Override // com.applovin.impl.u1.a
        public void b(long j3, long j4, long j5, long j6) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j3 + ", " + j4 + ", " + j5 + ", " + j6 + ", " + r5.this.q() + ", " + r5.this.r();
            if (r5.f62739a0) {
                throw new e(str, null);
            }
            oc.d("DefaultAudioSink", str);
        }

        /* synthetic */ h(r5 r5Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.u1.a
        public void a(int i3, long j3) {
            if (r5.this.f62755p != null) {
                r5.this.f62755p.a(i3, j3, SystemClock.elapsedRealtime() - r5.this.X);
            }
        }

        @Override // com.applovin.impl.u1.a
        public void a(long j3, long j4, long j5, long j6) {
            StringBuilder sb = new StringBuilder();
            sb.append("Spurious audio timestamp (frame position mismatch): ");
            sb.append(j3);
            String str = HcgZcEUYo.CPxsSyIRT;
            sb.append(str);
            sb.append(j4);
            sb.append(str);
            sb.append(j5);
            sb.append(str);
            sb.append(j6);
            sb.append(str);
            sb.append(r5.this.q());
            sb.append(str);
            sb.append(r5.this.r());
            String string = sb.toString();
            if (!r5.f62739a0) {
                oc.d("DefaultAudioSink", string);
                return;
            }
            throw new e(string, null);
        }

        @Override // com.applovin.impl.u1.a
        public void b(long j3) {
            oc.d("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f62788a = new Handler();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTrack$StreamEventCallback f62789b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends AudioTrack$StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r5 f62791a;

            a(r5 r5Var) {
                this.f62791a = r5Var;
            }

            public void onDataRequest(AudioTrack audioTrack, int i3) {
                b1.b(audioTrack == r5.this.f62758s);
                if (r5.this.f62755p == null || !r5.this.S) {
                    return;
                }
                r5.this.f62755p.a();
            }

            public void onTearDown(AudioTrack audioTrack) {
                b1.b(audioTrack == r5.this.f62758s);
                if (r5.this.f62755p == null || !r5.this.S) {
                    return;
                }
                r5.this.f62755p.a();
            }
        }

        public i() {
            this.f62789b = new a(r5.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f62788a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new androidx.media3.exoplayer.audio.g0(handler), this.f62789b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f62789b);
            this.f62788a.removeCallbacksAndMessages(null);
        }
    }

    public r5(n1 n1Var, b bVar, boolean z2, boolean z3, int i3) {
        this.f62740a = n1Var;
        this.f62741b = (b) b1.a(bVar);
        int i4 = xp.f65027a;
        this.f62742c = i4 >= 21 && z2;
        this.f62750k = i4 >= 23 && z3;
        this.f62751l = i4 >= 29 ? i3 : 0;
        this.f62747h = new ConditionVariable(true);
        this.f62748i = new u1(new h(this, null));
        d3 d3Var = new d3();
        this.f62743d = d3Var;
        zo zoVar = new zo();
        this.f62744e = zoVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new wi(), d3Var, zoVar);
        Collections.addAll(arrayList, bVar.a());
        this.f62745f = (p1[]) arrayList.toArray(new p1[0]);
        this.f62746g = new p1[]{new b9()};
        this.H = 1.0f;
        this.f62759t = l1.f61090g;
        this.U = 0;
        this.V = new v1(0, 0.0f);
        ph phVar = ph.f62438d;
        this.f62761v = new f(phVar, false, 0L, 0L, null);
        this.f62762w = phVar;
        this.P = -1;
        this.I = new p1[0];
        this.J = new ByteBuffer[0];
        this.f62749j = new ArrayDeque();
        this.f62753n = new g(100L);
        this.f62754o = new g(100L);
    }

    private AudioTrack k() throws r1.b {
        try {
            return ((c) b1.a(this.f62757r)).a(this.W, this.f62759t, this.U);
        } catch (r1.b e3) {
            u();
            r1.c cVar = this.f62755p;
            if (cVar != null) {
                cVar.a(e3);
            }
            throw e3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean l() throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = r9.P
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.P = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.P
            com.applovin.impl.p1[] r5 = r9.I
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.e()
        L1f:
            r9.d(r7)
            boolean r0 = r4.c()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.P
            int r0 = r0 + r1
            r9.P = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            r9.a(r0, r7)
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.P = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.r5.l():boolean");
    }

    private void m() {
        int i3 = 0;
        while (true) {
            p1[] p1VarArr = this.I;
            if (i3 >= p1VarArr.length) {
                return;
            }
            p1 p1Var = p1VarArr[i3];
            p1Var.b();
            this.J[i3] = p1Var.d();
            i3++;
        }
    }

    private ph n() {
        return o().f62780a;
    }

    private f o() {
        f fVar = this.f62760u;
        return fVar != null ? fVar : !this.f62749j.isEmpty() ? (f) this.f62749j.getLast() : this.f62761v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long q() {
        c cVar = this.f62757r;
        return cVar.f62770c == 0 ? this.f62765z / ((long) cVar.f62769b) : this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        c cVar = this.f62757r;
        return cVar.f62770c == 0 ? this.B / ((long) cVar.f62771d) : this.C;
    }

    private void s() throws r1.b {
        this.f62747h.block();
        AudioTrack audioTrackK = k();
        this.f62758s = audioTrackK;
        if (a(audioTrackK)) {
            b(this.f62758s);
            if (this.f62751l != 3) {
                AudioTrack audioTrack = this.f62758s;
                e9 e9Var = this.f62757r.f62768a;
                audioTrack.setOffloadDelayPadding(e9Var.C, e9Var.D);
            }
        }
        this.U = this.f62758s.getAudioSessionId();
        u1 u1Var = this.f62748i;
        AudioTrack audioTrack2 = this.f62758s;
        c cVar = this.f62757r;
        u1Var.a(audioTrack2, cVar.f62770c == 2, cVar.f62774g, cVar.f62771d, cVar.f62775h);
        x();
        int i3 = this.V.f64368a;
        if (i3 != 0) {
            this.f62758s.attachAuxEffect(i3);
            this.f62758s.setAuxEffectSendLevel(this.V.f64369b);
        }
        this.F = true;
    }

    private boolean t() {
        return this.f62758s != null;
    }

    private void u() {
        if (this.f62757r.b()) {
            this.Y = true;
        }
    }

    private void v() {
        if (this.R) {
            return;
        }
        this.R = true;
        this.f62748i.d(r());
        this.f62758s.stop();
        this.f62764y = 0;
    }

    private void w() {
        this.f62765z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.Z = false;
        this.D = 0;
        this.f62761v = new f(n(), p(), 0L, 0L, null);
        this.G = 0L;
        this.f62760u = null;
        this.f62749j.clear();
        this.K = null;
        this.L = 0;
        this.M = null;
        this.R = false;
        this.Q = false;
        this.P = -1;
        this.f62763x = null;
        this.f62764y = 0;
        this.f62744e.k();
        m();
    }

    private void x() {
        if (t()) {
            if (xp.f65027a >= 21) {
                a(this.f62758s, this.H);
            } else {
                b(this.f62758s, this.H);
            }
        }
    }

    private void y() {
        p1[] p1VarArr = this.f62757r.f62776i;
        ArrayList arrayList = new ArrayList();
        for (p1 p1Var : p1VarArr) {
            if (p1Var.f()) {
                arrayList.add(p1Var);
            } else {
                p1Var.b();
            }
        }
        int size = arrayList.size();
        this.I = (p1[]) arrayList.toArray(new p1[size]);
        this.J = new ByteBuffer[size];
        m();
    }

    private boolean z() {
        return (this.W || !"audio/raw".equals(this.f62757r.f62768a.f59394m) || f(this.f62757r.f62768a.B)) ? false : true;
    }

    @Override // com.applovin.impl.r1
    public void h() {
        if (xp.f65027a < 25) {
            b();
            return;
        }
        this.f62754o.a();
        this.f62753n.a();
        if (t()) {
            w();
            if (this.f62748i.d()) {
                this.f62758s.pause();
            }
            this.f62758s.flush();
            this.f62748i.g();
            u1 u1Var = this.f62748i;
            AudioTrack audioTrack = this.f62758s;
            c cVar = this.f62757r;
            u1Var.a(audioTrack, cVar.f62770c == 2, cVar.f62774g, cVar.f62771d, cVar.f62775h);
            this.F = true;
        }
    }

    @Override // com.applovin.impl.r1
    public void i() {
        this.E = true;
    }

    @Override // com.applovin.impl.r1
    public void j() {
        this.S = true;
        if (t()) {
            this.f62748i.i();
            this.f62758s.play();
        }
    }

    public boolean p() {
        return o().f62781b;
    }

    @Override // com.applovin.impl.r1
    public void pause() {
        this.S = false;
        if (t() && this.f62748i.f()) {
            this.f62758s.pause();
        }
    }

    @Override // com.applovin.impl.r1
    public void reset() {
        b();
        for (p1 p1Var : this.f62745f) {
            p1Var.reset();
        }
        for (p1 p1Var2 : this.f62746g) {
            p1Var2.reset();
        }
        this.S = false;
        this.Y = false;
    }

    private long c(long j3) {
        return j3 + this.f62757r.b(this.f62741b.b());
    }

    private static boolean e(int i3) {
        return (xp.f65027a >= 24 && i3 == -6) || i3 == -32;
    }

    @Override // com.applovin.impl.r1
    public void d() {
        if (this.W) {
            this.W = false;
            b();
        }
    }

    @Override // com.applovin.impl.r1
    public void f() {
        if (!this.Q && t() && l()) {
            v();
            this.Q = true;
        }
    }

    @Override // com.applovin.impl.r1
    public boolean g() {
        return t() && this.f62748i.e(r());
    }

    private void a(long j3) {
        ph phVarA;
        if (z()) {
            phVarA = this.f62741b.a(n());
        } else {
            phVarA = ph.f62438d;
        }
        ph phVar = phVarA;
        boolean zA = z() ? this.f62741b.a(p()) : false;
        this.f62749j.add(new f(phVar, zA, Math.max(0L, j3), this.f62757r.b(r()), null));
        y();
        r1.c cVar = this.f62755p;
        if (cVar != null) {
            cVar.a(zA);
        }
    }

    private long b(long j3) {
        while (!this.f62749j.isEmpty() && j3 >= ((f) this.f62749j.getFirst()).f62783d) {
            this.f62761v = (f) this.f62749j.remove();
        }
        f fVar = this.f62761v;
        long j4 = j3 - fVar.f62783d;
        if (fVar.f62780a.equals(ph.f62438d)) {
            return this.f62761v.f62782c + j4;
        }
        if (this.f62749j.isEmpty()) {
            return this.f62761v.f62782c + this.f62741b.a(j4);
        }
        f fVar2 = (f) this.f62749j.getFirst();
        return fVar2.f62782c - xp.a(fVar2.f62783d - j3, this.f62761v.f62780a.f62440a);
    }

    @Override // com.applovin.impl.r1
    public void e() {
        b1.b(xp.f65027a >= 21);
        b1.b(this.T);
        if (this.W) {
            return;
        }
        this.W = true;
        b();
    }

    @Override // com.applovin.impl.r1
    public boolean c() {
        if (t()) {
            return this.Q && !g();
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ph f62780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f62781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f62782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f62783d;

        private f(ph phVar, boolean z2, long j3, long j4) {
            this.f62780a = phVar;
            this.f62781b = z2;
            this.f62782c = j3;
            this.f62783d = j4;
        }

        /* synthetic */ f(ph phVar, boolean z2, long j3, long j4, a aVar) {
            this(phVar, z2, j3, j4);
        }
    }

    private static int c(int i3) {
        int i4 = xp.f65027a;
        if (i4 <= 28) {
            if (i3 == 7) {
                i3 = 8;
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                i3 = 6;
            }
        }
        if (i4 <= 26 && "fugu".equals(xp.f65028b) && i3 == 1) {
            i3 = 2;
        }
        return xp.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i3) {
        switch (i3) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
        }
    }

    private boolean f(int i3) {
        return this.f62742c && xp.f(i3);
    }

    private void d(long j3) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.I.length;
        int i3 = length;
        while (i3 >= 0) {
            if (i3 > 0) {
                byteBuffer = this.J[i3 - 1];
            } else {
                byteBuffer = this.K;
                if (byteBuffer == null) {
                    byteBuffer = p1.f62400a;
                }
            }
            if (i3 == length) {
                a(byteBuffer, j3);
            } else {
                p1 p1Var = this.I[i3];
                if (i3 > this.P) {
                    p1Var.a(byteBuffer);
                }
                ByteBuffer byteBufferD = p1Var.d();
                this.J[i3] = byteBufferD;
                if (byteBufferD.hasRemaining()) {
                    i3++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i3--;
            }
        }
    }

    @Override // com.applovin.impl.r1
    public void a(e9 e9Var, int i3, int[] iArr) throws r1.a {
        int i4;
        int iIntValue;
        int iIntValue2;
        int i5;
        p1[] p1VarArr;
        int i6;
        int i7;
        int i8;
        int iB;
        p1[] p1VarArr2;
        int[] iArr2;
        if ("audio/raw".equals(e9Var.f59394m)) {
            b1.a(xp.g(e9Var.B));
            int iB2 = xp.b(e9Var.B, e9Var.f59407z);
            if (f(e9Var.B)) {
                p1VarArr2 = this.f62746g;
            } else {
                p1VarArr2 = this.f62745f;
            }
            this.f62744e.a(e9Var.C, e9Var.D);
            if (xp.f65027a < 21 && e9Var.f59407z == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i9 = 0; i9 < 6; i9++) {
                    iArr2[i9] = i9;
                }
            } else {
                iArr2 = iArr;
            }
            this.f62743d.a(iArr2);
            p1.a aVar = new p1.a(e9Var.A, e9Var.f59407z, e9Var.B);
            for (p1 p1Var : p1VarArr2) {
                try {
                    p1.a aVarA = p1Var.a(aVar);
                    if (p1Var.f()) {
                        aVar = aVarA;
                    }
                } catch (p1.b e3) {
                    throw new r1.a(e3, e9Var);
                }
            }
            int i10 = aVar.f62404c;
            i4 = aVar.f62402a;
            iIntValue2 = xp.a(aVar.f62403b);
            p1VarArr = p1VarArr2;
            i7 = i10;
            i6 = iB2;
            iB = xp.b(i10, aVar.f62403b);
            i8 = 0;
        } else {
            p1[] p1VarArr3 = new p1[0];
            i4 = e9Var.A;
            if (a(e9Var, this.f62759t)) {
                iIntValue = hf.b((String) b1.a((Object) e9Var.f59394m), e9Var.f59391j);
                iIntValue2 = xp.a(e9Var.f59407z);
                i5 = 1;
            } else {
                Pair pairA = a(e9Var, this.f62740a);
                if (pairA != null) {
                    iIntValue = ((Integer) pairA.first).intValue();
                    iIntValue2 = ((Integer) pairA.second).intValue();
                    i5 = 2;
                } else {
                    throw new r1.a("Unable to configure passthrough for: " + e9Var, e9Var);
                }
            }
            p1VarArr = p1VarArr3;
            i6 = -1;
            i7 = iIntValue;
            i8 = i5;
            iB = -1;
        }
        if (i7 == 0) {
            throw new r1.a("Invalid output encoding (mode=" + i8 + ") for: " + e9Var, e9Var);
        }
        if (iIntValue2 != 0) {
            this.Y = false;
            c cVar = new c(e9Var, i6, i8, iB, i4, iIntValue2, i7, i3, this.f62750k, p1VarArr);
            if (t()) {
                this.f62756q = cVar;
                return;
            } else {
                this.f62757r = cVar;
                return;
            }
        }
        throw new r1.a("Invalid output channel config (mode=" + i8 + ") for: " + e9Var, e9Var);
    }

    @Override // com.applovin.impl.r1
    public void b() {
        if (t()) {
            w();
            if (this.f62748i.d()) {
                this.f62758s.pause();
            }
            if (a(this.f62758s)) {
                ((i) b1.a(this.f62752m)).b(this.f62758s);
            }
            AudioTrack audioTrack = this.f62758s;
            this.f62758s = null;
            if (xp.f65027a < 21 && !this.T) {
                this.U = 0;
            }
            c cVar = this.f62756q;
            if (cVar != null) {
                this.f62757r = cVar;
                this.f62756q = null;
            }
            this.f62748i.g();
            this.f62747h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.f62754o.a();
        this.f62753n.a();
    }

    @Override // com.applovin.impl.r1
    public int b(e9 e9Var) {
        if (!"audio/raw".equals(e9Var.f59394m)) {
            return ((this.Y || !a(e9Var, this.f62759t)) && !b(e9Var, this.f62740a)) ? 0 : 2;
        }
        if (!xp.g(e9Var.B)) {
            oc.d("DefaultAudioSink", "Invalid PCM encoding: " + e9Var.B);
            return 0;
        }
        int i3 = e9Var.B;
        return (i3 == 2 || (this.f62742c && i3 == 4)) ? 2 : 1;
    }

    private static boolean b(e9 e9Var, n1 n1Var) {
        return a(e9Var, n1Var) != null;
    }

    private void b(AudioTrack audioTrack) {
        if (this.f62752m == null) {
            this.f62752m = new i();
        }
        this.f62752m.a(audioTrack);
    }

    private void b(ph phVar) {
        if (t()) {
            try {
                this.f62758s.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(phVar.f62440a).setPitch(phVar.f62441b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e3) {
                oc.c("DefaultAudioSink", "Failed to set playback params", e3);
            }
            phVar = new ph(this.f62758s.getPlaybackParams().getSpeed(), this.f62758s.getPlaybackParams().getPitch());
            this.f62748i.a(phVar.f62440a);
        }
        this.f62762w = phVar;
    }

    @Override // com.applovin.impl.r1
    public long a(boolean z2) {
        if (!t() || this.F) {
            return Long.MIN_VALUE;
        }
        return c(b(Math.min(this.f62748i.a(z2), this.f62757r.b(r()))));
    }

    private static Pair a(e9 e9Var, n1 n1Var) {
        if (n1Var == null) {
            return null;
        }
        int iB = hf.b((String) b1.a((Object) e9Var.f59394m), e9Var.f59391j);
        int iA = 6;
        if (iB != 5 && iB != 6 && iB != 18 && iB != 17 && iB != 7 && iB != 8 && iB != 14) {
            return null;
        }
        if (iB == 18 && !n1Var.a(18)) {
            iB = 6;
        } else if (iB == 8 && !n1Var.a(8)) {
            iB = 7;
        }
        if (!n1Var.a(iB)) {
            return null;
        }
        if (iB == 18) {
            if (xp.f65027a >= 29 && (iA = a(18, e9Var.A)) == 0) {
                oc.d("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                return null;
            }
        } else {
            iA = e9Var.f59407z;
            if (iA > n1Var.c()) {
                return null;
            }
        }
        int iC = c(iA);
        if (iC == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(iC));
    }

    @Override // com.applovin.impl.r1
    public void b(boolean z2) {
        a(n(), z2);
    }

    private static void b(AudioTrack audioTrack, float f3) {
        audioTrack.setStereoVolume(f3, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat b(int i3, int i4, int i5) {
        return new AudioFormat.Builder().setSampleRate(i3).setChannelMask(i4).setEncoding(i5).build();
    }

    private static int a(int i3, ByteBuffer byteBuffer) {
        switch (i3) {
            case 5:
            case 6:
            case 18:
                return k.b(byteBuffer);
            case 7:
            case 8:
                return e7.a(byteBuffer);
            case 9:
                int iD = sf.d(xp.a(byteBuffer, byteBuffer.position()));
                if (iD != -1) {
                    return iD;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i3);
            case 14:
                int iA = k.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return k.a(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return n.a(byteBuffer);
        }
    }

    @Override // com.applovin.impl.r1
    public ph a() {
        if (this.f62750k) {
            return this.f62762w;
        }
        return n();
    }

    @Override // com.applovin.impl.r1
    public boolean a(ByteBuffer byteBuffer, long j3, int i3) throws Exception {
        ByteBuffer byteBuffer2 = this.K;
        b1.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f62756q != null) {
            if (!l()) {
                return false;
            }
            if (!this.f62756q.a(this.f62757r)) {
                v();
                if (g()) {
                    return false;
                }
                b();
            } else {
                this.f62757r = this.f62756q;
                this.f62756q = null;
                if (a(this.f62758s) && this.f62751l != 3) {
                    this.f62758s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f62758s;
                    e9 e9Var = this.f62757r.f62768a;
                    audioTrack.setOffloadDelayPadding(e9Var.C, e9Var.D);
                    this.Z = true;
                }
            }
            a(j3);
        }
        if (!t()) {
            try {
                s();
            } catch (r1.b e3) {
                if (!e3.f62708b) {
                    this.f62753n.a(e3);
                    return false;
                }
                throw e3;
            }
        }
        this.f62753n.a();
        if (this.F) {
            this.G = Math.max(0L, j3);
            this.E = false;
            this.F = false;
            if (this.f62750k && xp.f65027a >= 23) {
                b(this.f62762w);
            }
            a(j3);
            if (this.S) {
                j();
            }
        }
        if (!this.f62748i.g(r())) {
            return false;
        }
        if (this.K == null) {
            b1.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar = this.f62757r;
            if (cVar.f62770c != 0 && this.D == 0) {
                int iA = a(cVar.f62774g, byteBuffer);
                this.D = iA;
                if (iA == 0) {
                    return true;
                }
            }
            if (this.f62760u != null) {
                if (!l()) {
                    return false;
                }
                a(j3);
                this.f62760u = null;
            }
            long jD = this.G + this.f62757r.d(q() - this.f62744e.j());
            if (!this.E && Math.abs(jD - j3) > 200000) {
                this.f62755p.a(new r1.d(j3, jD));
                this.E = true;
            }
            if (this.E) {
                if (!l()) {
                    return false;
                }
                long j4 = j3 - jD;
                this.G += j4;
                this.E = false;
                a(j3);
                r1.c cVar2 = this.f62755p;
                if (cVar2 != null && j4 != 0) {
                    cVar2.b();
                }
            }
            if (this.f62757r.f62770c == 0) {
                this.f62765z += (long) byteBuffer.remaining();
            } else {
                this.A += (long) (this.D * i3);
            }
            this.K = byteBuffer;
            this.L = i3;
        }
        d(j3);
        if (!this.K.hasRemaining()) {
            this.K = null;
            this.L = 0;
            return true;
        }
        if (!this.f62748i.f(r())) {
            return false;
        }
        oc.d("DefaultAudioSink", "Resetting stalled audio track");
        b();
        return true;
    }

    @Override // com.applovin.impl.r1
    public void a(l1 l1Var) {
        if (this.f62759t.equals(l1Var)) {
            return;
        }
        this.f62759t = l1Var;
        if (this.W) {
            return;
        }
        b();
    }

    private void a(ph phVar, boolean z2) {
        f fVarO = o();
        if (phVar.equals(fVarO.f62780a) && z2 == fVarO.f62781b) {
            return;
        }
        f fVar = new f(phVar, z2, -9223372036854775807L, -9223372036854775807L, null);
        if (t()) {
            this.f62760u = fVar;
        } else {
            this.f62761v = fVar;
        }
    }

    @Override // com.applovin.impl.r1
    public void a(int i3) {
        if (this.U != i3) {
            this.U = i3;
            this.T = i3 != 0;
            b();
        }
    }

    @Override // com.applovin.impl.r1
    public void a(v1 v1Var) {
        if (this.V.equals(v1Var)) {
            return;
        }
        int i3 = v1Var.f64368a;
        float f3 = v1Var.f64369b;
        AudioTrack audioTrack = this.f62758s;
        if (audioTrack != null) {
            if (this.V.f64368a != i3) {
                audioTrack.attachAuxEffect(i3);
            }
            if (i3 != 0) {
                this.f62758s.setAuxEffectSendLevel(f3);
            }
        }
        this.V = v1Var;
    }

    @Override // com.applovin.impl.r1
    public void a(r1.c cVar) {
        this.f62755p = cVar;
    }

    @Override // com.applovin.impl.r1
    public void a(ph phVar) {
        ph phVar2 = new ph(xp.a(phVar.f62440a, 0.1f, 8.0f), xp.a(phVar.f62441b, 0.1f, 8.0f));
        if (this.f62750k && xp.f65027a >= 23) {
            b(phVar2);
        } else {
            a(phVar2, p());
        }
    }

    @Override // com.applovin.impl.r1
    public void a(float f3) {
        if (this.H != f3) {
            this.H = f3;
            x();
        }
    }

    private static void a(AudioTrack audioTrack, float f3) {
        audioTrack.setVolume(f3);
    }

    @Override // com.applovin.impl.r1
    public boolean a(e9 e9Var) {
        return b(e9Var) != 0;
    }

    private void a(ByteBuffer byteBuffer, long j3) throws Exception {
        r5 r5Var;
        ByteBuffer byteBuffer2;
        int iA;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer3 = this.M;
            if (byteBuffer3 != null) {
                b1.a(byteBuffer3 == byteBuffer);
            } else {
                this.M = byteBuffer;
                if (xp.f65027a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.N;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.N = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.N, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.O = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (xp.f65027a < 21) {
                int iB = this.f62748i.b(this.B);
                if (iB > 0) {
                    iA = this.f62758s.write(this.N, this.O, Math.min(iRemaining2, iB));
                    if (iA > 0) {
                        this.O += iA;
                        byteBuffer.position(byteBuffer.position() + iA);
                    }
                    r5Var = this;
                    byteBuffer2 = byteBuffer;
                } else {
                    r5Var = this;
                    byteBuffer2 = byteBuffer;
                    iA = 0;
                }
            } else if (this.W) {
                b1.b(j3 != -9223372036854775807L);
                r5Var = this;
                byteBuffer2 = byteBuffer;
                iA = r5Var.a(this.f62758s, byteBuffer2, iRemaining2, j3);
            } else {
                r5Var = this;
                byteBuffer2 = byteBuffer;
                iA = a(r5Var.f62758s, byteBuffer2, iRemaining2);
            }
            r5Var.X = SystemClock.elapsedRealtime();
            if (iA < 0) {
                boolean zE = e(iA);
                if (zE) {
                    u();
                }
                r1.e eVar = new r1.e(iA, r5Var.f62757r.f62768a, zE);
                r1.c cVar = r5Var.f62755p;
                if (cVar != null) {
                    cVar.a(eVar);
                }
                if (!eVar.f62713b) {
                    r5Var.f62754o.a(eVar);
                    return;
                }
                throw eVar;
            }
            r5Var.f62754o.a();
            if (a(r5Var.f62758s)) {
                long j4 = r5Var.C;
                if (j4 > 0) {
                    r5Var.Z = false;
                }
                if (r5Var.S && r5Var.f62755p != null && iA < iRemaining2 && !r5Var.Z) {
                    r5Var.f62755p.b(r5Var.f62748i.c(j4));
                }
            }
            int i3 = r5Var.f62757r.f62770c;
            if (i3 == 0) {
                r5Var.B += (long) iA;
            }
            if (iA == iRemaining2) {
                if (i3 != 0) {
                    b1.b(byteBuffer2 == r5Var.K);
                    r5Var.C += (long) (r5Var.D * r5Var.L);
                }
                r5Var.M = null;
            }
        }
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
        return audioTrack.write(byteBuffer, i3, 1);
    }

    private static int a(int i3, int i4) {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i5 = 8; i5 > 0; i5--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i3).setSampleRate(i4).setChannelMask(xp.a(i5)).build(), audioAttributesBuild)) {
                return i5;
            }
        }
        return 0;
    }

    private boolean a(e9 e9Var, l1 l1Var) {
        int iB;
        int iA;
        int iA2;
        if (xp.f65027a < 29 || this.f62751l == 0 || (iB = hf.b((String) b1.a((Object) e9Var.f59394m), e9Var.f59391j)) == 0 || (iA = xp.a(e9Var.f59407z)) == 0 || (iA2 = a(b(e9Var.A, iA, iB), l1Var.a())) == 0) {
            return false;
        }
        if (iA2 == 1) {
            return ((e9Var.C != 0 || e9Var.D != 0) && (this.f62751l == 1)) ? false : true;
        }
        if (iA2 == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private int a(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i3 = xp.f65027a;
        if (i3 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i3 == 30 && xp.f65030d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    private static boolean a(AudioTrack audioTrack) {
        return xp.f65027a >= 29 && audioTrack.isOffloadedPlayback();
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3, long j3) {
        if (xp.f65027a >= 26) {
            return audioTrack.write(byteBuffer, i3, 1, j3 * 1000);
        }
        if (this.f62763x == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.f62763x = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.f62763x.putInt(1431633921);
        }
        if (this.f62764y == 0) {
            this.f62763x.putInt(4, i3);
            this.f62763x.putLong(8, j3 * 1000);
            this.f62763x.position(0);
            this.f62764y = i3;
        }
        int iRemaining = this.f62763x.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.f62763x, iRemaining, 1);
            if (iWrite < 0) {
                this.f62764y = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA = a(audioTrack, byteBuffer, i3);
        if (iA < 0) {
            this.f62764y = 0;
            return iA;
        }
        this.f62764y -= iA;
        return iA;
    }
}
