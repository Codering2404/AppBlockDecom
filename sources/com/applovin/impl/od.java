package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.applovin.impl.gd;
import com.applovin.impl.md;
import com.applovin.impl.wq;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class od extends kd {

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private static final int[] f62234s1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private static boolean f62235t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private static boolean f62236u1;
    private final Context J0;
    private final vq K0;
    private final wq.a L0;
    private final long M0;
    private final int N0;
    private final boolean O0;
    private a P0;
    private boolean Q0;
    private boolean R0;
    private Surface S0;
    private g7 T0;
    private boolean U0;
    private int V0;
    private boolean W0;
    private boolean X0;
    private boolean Y0;
    private long Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private long f62237a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private long f62238b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private int f62239c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f62240d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private int f62241e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private long f62242f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private long f62243g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private long f62244h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private int f62245i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private int f62246j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private int f62247k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private int f62248l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private float f62249m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private xq f62250n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private boolean f62251o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private int f62252p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    b f62253q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private uq f62254r1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f62256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62257c;

        public a(int i3, int i4, int i5) {
            this.f62255a = i3;
            this.f62256b = i4;
            this.f62257c = i5;
        }
    }

    public od(Context context, gd.b bVar, ld ldVar, long j3, boolean z2, Handler handler, wq wqVar, int i3) {
        super(2, bVar, ldVar, z2, 30.0f);
        this.M0 = j3;
        this.N0 = i3;
        Context applicationContext = context.getApplicationContext();
        this.J0 = applicationContext;
        this.K0 = new vq(applicationContext);
        this.L0 = new wq.a(handler, wqVar);
        this.O0 = e0();
        this.f62237a1 = -9223372036854775807L;
        this.f62246j1 = -1;
        this.f62247k1 = -1;
        this.f62249m1 = -1.0f;
        this.V0 = 1;
        this.f62252p1 = 0;
        d0();
    }

    private static Point b(jd jdVar, e9 e9Var) {
        int i3 = e9Var.f59400s;
        int i4 = e9Var.f59399r;
        boolean z2 = i3 > i4;
        int i5 = z2 ? i3 : i4;
        if (z2) {
            i3 = i4;
        }
        float f3 = i3 / i5;
        for (int i6 : f62234s1) {
            int i7 = (int) (i6 * f3);
            if (i6 <= i5 || i7 <= i3) {
                break;
            }
            if (xp.f65027a >= 21) {
                int i8 = z2 ? i7 : i6;
                if (!z2) {
                    i6 = i7;
                }
                Point pointA = jdVar.a(i8, i6);
                if (jdVar.a(pointA.x, pointA.y, e9Var.f59401t)) {
                    return pointA;
                }
            } else {
                try {
                    int iA = xp.a(i6, 16) * 16;
                    int iA2 = xp.a(i7, 16) * 16;
                    if (iA * iA2 <= md.b()) {
                        int i9 = z2 ? iA2 : iA;
                        if (!z2) {
                            iA = iA2;
                        }
                        return new Point(i9, iA);
                    }
                } catch (md.c unused) {
                }
            }
        }
        return null;
    }

    protected static int c(jd jdVar, e9 e9Var) {
        if (e9Var.f59395n == -1) {
            return a(jdVar, e9Var);
        }
        int size = e9Var.f59396o.size();
        int length = 0;
        for (int i3 = 0; i3 < size; i3++) {
            length += ((byte[]) e9Var.f59396o.get(i3)).length;
        }
        return e9Var.f59395n + length;
    }

    private void c0() {
        gd gdVarI;
        this.W0 = false;
        if (xp.f65027a < 23 || !this.f62251o1 || (gdVarI = I()) == null) {
            return;
        }
        this.f62253q1 = new b(gdVarI);
    }

    private void d0() {
        this.f62250n1 = null;
    }

    private static boolean e0() {
        return "NVIDIA".equals(xp.f65029c);
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private static boolean f0() {
        /*
            Method dump skipped, instruction units count: 3044
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.od.f0():boolean");
    }

    private static boolean g(long j3) {
        return j3 < -30000;
    }

    private void g0() {
        if (this.f62239c1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.L0.a(this.f62239c1, jElapsedRealtime - this.f62238b1);
            this.f62239c1 = 0;
            this.f62238b1 = jElapsedRealtime;
        }
    }

    private static boolean h(long j3) {
        return j3 < -500000;
    }

    private void i0() {
        int i3 = this.f62245i1;
        if (i3 != 0) {
            this.L0.b(this.f62244h1, i3);
            this.f62244h1 = 0L;
            this.f62245i1 = 0;
        }
    }

    private void j0() {
        int i3 = this.f62246j1;
        if (i3 == -1 && this.f62247k1 == -1) {
            return;
        }
        xq xqVar = this.f62250n1;
        if (xqVar != null && xqVar.f65044a == i3 && xqVar.f65045b == this.f62247k1 && xqVar.f65046c == this.f62248l1 && xqVar.f65047d == this.f62249m1) {
            return;
        }
        xq xqVar2 = new xq(this.f62246j1, this.f62247k1, this.f62248l1, this.f62249m1);
        this.f62250n1 = xqVar2;
        this.L0.b(xqVar2);
    }

    private void k0() {
        if (this.U0) {
            this.L0.a(this.S0);
        }
    }

    private void l0() {
        xq xqVar = this.f62250n1;
        if (xqVar != null) {
            this.L0.b(xqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        a0();
    }

    private void n0() {
        this.f62237a1 = this.M0 > 0 ? SystemClock.elapsedRealtime() + this.M0 : -9223372036854775807L;
    }

    @Override // com.applovin.impl.kd
    protected boolean K() {
        return this.f62251o1 && xp.f65027a < 23;
    }

    @Override // com.applovin.impl.kd
    protected void Q() {
        super.Q();
        c0();
    }

    @Override // com.applovin.impl.kd
    protected void W() {
        super.W();
        this.f62241e1 = 0;
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.qi
    public boolean d() {
        g7 g7Var;
        if (super.d() && (this.W0 || (((g7Var = this.T0) != null && this.S0 == g7Var) || I() == null || this.f62251o1))) {
            this.f62237a1 = -9223372036854775807L;
            return true;
        }
        if (this.f62237a1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f62237a1) {
            return true;
        }
        this.f62237a1 = -9223372036854775807L;
        return false;
    }

    protected void f(int i3) {
        m5 m5Var = this.E0;
        m5Var.f61374g += i3;
        this.f62239c1 += i3;
        int i4 = this.f62240d1 + i3;
        this.f62240d1 = i4;
        m5Var.f61375h = Math.max(i4, m5Var.f61375h);
        int i5 = this.N0;
        if (i5 <= 0 || this.f62239c1 < i5) {
            return;
        }
        g0();
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    void h0() {
        this.Y0 = true;
        if (this.W0) {
            return;
        }
        this.W0 = true;
        this.L0.a(this.S0);
        this.U0 = true;
    }

    protected void i(long j3) {
        f(j3);
        j0();
        this.E0.f61372e++;
        h0();
        d(j3);
    }

    protected void j(long j3) {
        this.E0.a(j3);
        this.f62244h1 += j3;
        this.f62245i1++;
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void v() {
        d0();
        c0();
        this.U0 = false;
        this.K0.b();
        this.f62253q1 = null;
        try {
            super.v();
        } finally {
            this.L0.a(this.E0);
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void w() {
        try {
            super.w();
            g7 g7Var = this.T0;
            if (g7Var != null) {
                if (this.S0 == g7Var) {
                    this.S0 = null;
                }
                g7Var.release();
                this.T0 = null;
            }
        } catch (Throwable th) {
            if (this.T0 != null) {
                Surface surface = this.S0;
                g7 g7Var2 = this.T0;
                if (surface == g7Var2) {
                    this.S0 = null;
                }
                g7Var2.release();
                this.T0 = null;
            }
            throw th;
        }
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void x() {
        super.x();
        this.f62239c1 = 0;
        this.f62238b1 = SystemClock.elapsedRealtime();
        this.f62243g1 = SystemClock.elapsedRealtime() * 1000;
        this.f62244h1 = 0L;
        this.f62245i1 = 0;
        this.K0.e();
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void y() {
        this.f62237a1 = -9223372036854775807L;
        g0();
        i0();
        this.K0.f();
        super.y();
    }

    @Override // com.applovin.impl.kd
    protected void g(String str) {
        this.L0.a(str);
    }

    protected boolean h(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (od.class) {
            try {
                if (!f62235t1) {
                    f62236u1 = f0();
                    f62235t1 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f62236u1;
    }

    @Override // com.applovin.impl.kd
    protected p5 a(jd jdVar, e9 e9Var, e9 e9Var2) {
        p5 p5VarA = jdVar.a(e9Var, e9Var2);
        int i3 = p5VarA.f62415e;
        int i4 = e9Var2.f59399r;
        a aVar = this.P0;
        if (i4 > aVar.f62255a || e9Var2.f59400s > aVar.f62256b) {
            i3 |= Function.MAX_NARGS;
        }
        if (c(jdVar, e9Var2) > this.P0.f62257c) {
            i3 |= 64;
        }
        int i5 = i3;
        return new p5(jdVar.f60691a, e9Var, e9Var2, i5 != 0 ? 0 : p5VarA.f62414d, i5);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class b implements gd.c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f62258a;

        public b(gd gdVar) {
            Handler handlerA = xp.a((Handler.Callback) this);
            this.f62258a = handlerA;
            gdVar.a(this, handlerA);
        }

        private void a(long j3) {
            od odVar = od.this;
            if (this != odVar.f62253q1) {
                return;
            }
            if (j3 == Long.MAX_VALUE) {
                odVar.m0();
                return;
            }
            try {
                odVar.i(j3);
            } catch (z7 e3) {
                od.this.a(e3);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a(xp.c(message.arg1, message.arg2));
            return true;
        }

        @Override // com.applovin.impl.gd.c
        public void a(gd gdVar, long j3, long j4) {
            if (xp.f65027a < 30) {
                this.f62258a.sendMessageAtFrontOfQueue(Message.obtain(this.f62258a, 0, (int) (j3 >> 32), (int) j3));
            } else {
                a(j3);
            }
        }
    }

    protected void c(gd gdVar, int i3, long j3) {
        ko.a("skipVideoBuffer");
        gdVar.a(i3, false);
        ko.a();
        this.E0.f61373f++;
    }

    @Override // com.applovin.impl.kd
    protected void d(long j3) {
        super.d(j3);
        if (this.f62251o1) {
            return;
        }
        this.f62241e1--;
    }

    private static void a(MediaFormat mediaFormat, int i3) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i3);
    }

    private boolean c(jd jdVar) {
        if (xp.f65027a < 23 || this.f62251o1 || h(jdVar.f60691a)) {
            return false;
        }
        return !jdVar.f60697g || g7.b(this.J0);
    }

    protected boolean d(long j3, long j4) {
        return g(j3) && j4 > 100000;
    }

    protected void a(gd gdVar, int i3, long j3) {
        ko.a("dropVideoBuffer");
        gdVar.a(i3, false);
        ko.a();
        f(1);
    }

    protected boolean b(long j3, boolean z2) throws z7 {
        int iB = b(j3);
        if (iB == 0) {
            return false;
        }
        m5 m5Var = this.E0;
        m5Var.f61376i++;
        int i3 = this.f62241e1 + iB;
        if (z2) {
            m5Var.f61373f += i3;
        } else {
            f(i3);
        }
        G();
        return true;
    }

    public od(Context context, ld ldVar, long j3, boolean z2, Handler handler, wq wqVar, int i3) {
        this(context, gd.b.f59971a, ldVar, j3, z2, handler, wqVar, i3);
    }

    private static int a(jd jdVar, e9 e9Var) {
        int i3;
        int iA;
        int iIntValue;
        int i4 = e9Var.f59399r;
        int i5 = e9Var.f59400s;
        if (i4 == -1 || i5 == -1) {
            return -1;
        }
        String str = e9Var.f59394m;
        if ("video/dolby-vision".equals(str)) {
            Pair pairA = md.a(e9Var);
            str = (pairA == null || !((iIntValue = ((Integer) pairA.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.getClass();
        i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i4 * i5;
                i3 = 2;
                break;
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i4 * i5;
                break;
            case "video/avc":
                String str2 = xp.f65030d;
                if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(xp.f65029c) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !jdVar.f60697g)))) {
                    iA = xp.a(i4, 16) * xp.a(i5, 16) * Function.MAX_NARGS;
                    i3 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    @Override // com.applovin.impl.kd
    protected void b(o5 o5Var) {
        boolean z2 = this.f62251o1;
        if (!z2) {
            this.f62241e1++;
        }
        if (xp.f65027a >= 23 || !z2) {
            return;
        }
        i(o5Var.f62185f);
    }

    protected void b(gd gdVar, int i3, long j3) {
        j0();
        ko.a("releaseOutputBuffer");
        gdVar.a(i3, true);
        ko.a();
        this.f62243g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f61372e++;
        this.f62240d1 = 0;
        h0();
    }

    protected a a(jd jdVar, e9 e9Var, e9[] e9VarArr) {
        int iA;
        int iMax = e9Var.f59399r;
        int iMax2 = e9Var.f59400s;
        int iC = c(jdVar, e9Var);
        if (e9VarArr.length == 1) {
            if (iC != -1 && (iA = a(jdVar, e9Var)) != -1) {
                iC = Math.min((int) (iC * 1.5f), iA);
            }
            return new a(iMax, iMax2, iC);
        }
        int length = e9VarArr.length;
        boolean z2 = false;
        for (int i3 = 0; i3 < length; i3++) {
            e9 e9VarA = e9VarArr[i3];
            if (e9Var.f59406y != null && e9VarA.f59406y == null) {
                e9VarA = e9VarA.a().a(e9Var.f59406y).a();
            }
            if (jdVar.a(e9Var, e9VarA).f62414d != 0) {
                int i4 = e9VarA.f59399r;
                z2 |= i4 == -1 || e9VarA.f59400s == -1;
                iMax = Math.max(iMax, i4);
                iMax2 = Math.max(iMax2, e9VarA.f59400s);
                iC = Math.max(iC, c(jdVar, e9VarA));
            }
        }
        if (z2) {
            oc.d("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointB = b(jdVar, e9Var);
            if (pointB != null) {
                iMax = Math.max(iMax, pointB.x);
                iMax2 = Math.max(iMax2, pointB.y);
                iC = Math.max(iC, a(jdVar, e9Var.a().q(iMax).g(iMax2).a()));
                oc.d("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iC);
    }

    protected boolean b(long j3, long j4, boolean z2) {
        return g(j3) && !z2;
    }

    @Override // com.applovin.impl.kd
    protected boolean b(jd jdVar) {
        return this.S0 != null || c(jdVar);
    }

    @Override // com.applovin.impl.kd
    protected float a(float f3, e9 e9Var, e9[] e9VarArr) {
        float fMax = -1.0f;
        for (e9 e9Var2 : e9VarArr) {
            float f4 = e9Var2.f59401t;
            if (f4 != -1.0f) {
                fMax = Math.max(fMax, f4);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f3;
    }

    @Override // com.applovin.impl.kd
    protected List a(ld ldVar, e9 e9Var, boolean z2) {
        return a(ldVar, e9Var, z2, this.f62251o1);
    }

    private static List a(ld ldVar, e9 e9Var, boolean z2, boolean z3) {
        Pair pairA;
        String str = e9Var.f59394m;
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        List listA = md.a(ldVar.a(str, z2, z3), e9Var);
        if ("video/dolby-vision".equals(str) && (pairA = md.a(e9Var)) != null) {
            int iIntValue = ((Integer) pairA.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                listA.addAll(ldVar.a("video/hevc", z2, z3));
            } else if (iIntValue == 512) {
                listA.addAll(ldVar.a("video/avc", z2, z3));
            }
        }
        return Collections.unmodifiableList(listA);
    }

    @Override // com.applovin.impl.kd
    protected gd.a a(jd jdVar, e9 e9Var, MediaCrypto mediaCrypto, float f3) {
        g7 g7Var = this.T0;
        if (g7Var != null && g7Var.f59880a != jdVar.f60697g) {
            g7Var.release();
            this.T0 = null;
        }
        String str = jdVar.f60693c;
        a aVarA = a(jdVar, e9Var, t());
        this.P0 = aVarA;
        MediaFormat mediaFormatA = a(e9Var, str, aVarA, f3, this.O0, this.f62251o1 ? this.f62252p1 : 0);
        if (this.S0 == null) {
            if (c(jdVar)) {
                if (this.T0 == null) {
                    this.T0 = g7.a(this.J0, jdVar.f60697g);
                }
                this.S0 = this.T0;
            } else {
                throw new IllegalStateException();
            }
        }
        return gd.a.a(jdVar, mediaFormatA, e9Var, this.S0, mediaCrypto);
    }

    protected MediaFormat a(e9 e9Var, String str, a aVar, float f3, boolean z2, int i3) {
        Pair pairA;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, e9Var.f59399r);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, e9Var.f59400s);
        rd.a(mediaFormat, e9Var.f59396o);
        rd.a(mediaFormat, "frame-rate", e9Var.f59401t);
        rd.a(mediaFormat, "rotation-degrees", e9Var.f59402u);
        rd.a(mediaFormat, e9Var.f59406y);
        if ("video/dolby-vision".equals(e9Var.f59394m) && (pairA = md.a(e9Var)) != null) {
            rd.a(mediaFormat, "profile", ((Integer) pairA.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f62255a);
        mediaFormat.setInteger("max-height", aVar.f62256b);
        rd.a(mediaFormat, "max-input-size", aVar.f62257c);
        if (xp.f65027a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f3 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f3);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i3 != 0) {
            a(mediaFormat, i3);
        }
        return mediaFormat;
    }

    @Override // com.applovin.impl.kd
    protected void a(o5 o5Var) {
        if (this.R0) {
            ByteBuffer byteBuffer = (ByteBuffer) b1.a(o5Var.f62186g);
            if (byteBuffer.remaining() >= 7) {
                byte b3 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b4 = byteBuffer.get();
                byte b5 = byteBuffer.get();
                byteBuffer.position(0);
                if (b3 == -75 && s2 == 60 && s3 == 1 && b4 == 4 && b5 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    a(I(), bArr);
                }
            }
        }
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i3, Object obj) throws z7 {
        if (i3 == 1) {
            a(obj);
            return;
        }
        if (i3 == 7) {
            this.f62254r1 = (uq) obj;
            return;
        }
        if (i3 == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.f62252p1 != iIntValue) {
                this.f62252p1 = iIntValue;
                if (this.f62251o1) {
                    U();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                super.a(i3, obj);
                return;
            } else {
                this.K0.a(((Integer) obj).intValue());
                return;
            }
        }
        this.V0 = ((Integer) obj).intValue();
        gd gdVarI = I();
        if (gdVarI != null) {
            gdVarI.c(this.V0);
        }
    }

    private void a(long j3, long j4, e9 e9Var) {
        uq uqVar = this.f62254r1;
        if (uqVar != null) {
            uqVar.a(j3, j4, e9Var, L());
        }
    }

    @Override // com.applovin.impl.kd
    protected void a(Exception exc) {
        oc.a("MediaCodecVideoRenderer", "Video codec error", exc);
        this.L0.b(exc);
    }

    @Override // com.applovin.impl.kd
    protected void a(String str, long j3, long j4) {
        this.L0.a(str, j3, j4);
        this.Q0 = h(str);
        this.R0 = ((jd) b1.a(J())).b();
        if (xp.f65027a < 23 || !this.f62251o1) {
            return;
        }
        this.f62253q1 = new b((gd) b1.a(I()));
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void a(boolean z2, boolean z3) {
        super.a(z2, z3);
        boolean z4 = q().f63719a;
        b1.b((z4 && this.f62252p1 == 0) ? false : true);
        if (this.f62251o1 != z4) {
            this.f62251o1 = z4;
            U();
        }
        this.L0.b(this.E0);
        this.K0.c();
        this.X0 = z3;
        this.Y0 = false;
    }

    @Override // com.applovin.impl.kd
    protected p5 a(f9 f9Var) throws z7 {
        p5 p5VarA = super.a(f9Var);
        this.L0.a(f9Var.f59641b, p5VarA);
        return p5VarA;
    }

    @Override // com.applovin.impl.kd
    protected void a(e9 e9Var, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        gd gdVarI = I();
        if (gdVarI != null) {
            gdVarI.c(this.V0);
        }
        if (this.f62251o1) {
            this.f62246j1 = e9Var.f59399r;
            this.f62247k1 = e9Var.f59400s;
        } else {
            b1.a(mediaFormat);
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z2) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            }
            this.f62246j1 = integer;
            if (z2) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            }
            this.f62247k1 = integer2;
        }
        float f3 = e9Var.f59403v;
        this.f62249m1 = f3;
        if (xp.f65027a >= 21) {
            int i3 = e9Var.f59402u;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.f62246j1;
                this.f62246j1 = this.f62247k1;
                this.f62247k1 = i4;
                this.f62249m1 = 1.0f / f3;
            }
        } else {
            this.f62248l1 = e9Var.f59402u;
        }
        this.K0.a(e9Var.f59401t);
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.e2
    protected void a(long j3, boolean z2) throws z7 {
        super.a(j3, z2);
        c0();
        this.K0.d();
        this.f62242f1 = -9223372036854775807L;
        this.Z0 = -9223372036854775807L;
        this.f62240d1 = 0;
        if (z2) {
            n0();
        } else {
            this.f62237a1 = -9223372036854775807L;
        }
    }

    @Override // com.applovin.impl.kd
    protected boolean a(long j3, long j4, gd gdVar, ByteBuffer byteBuffer, int i3, int i4, int i5, long j5, boolean z2, boolean z3, e9 e9Var) {
        boolean z4;
        boolean z5;
        od odVar;
        b1.a(gdVar);
        if (this.Z0 == -9223372036854775807L) {
            this.Z0 = j3;
        }
        if (j5 != this.f62242f1) {
            this.K0.b(j5);
            this.f62242f1 = j5;
        }
        long jM = M();
        long j6 = j5 - jM;
        if (z2 && !z3) {
            c(gdVar, i3, j6);
            return true;
        }
        double dN = N();
        boolean z6 = b() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j7 = (long) ((j5 - j3) / dN);
        if (z6) {
            j7 -= jElapsedRealtime - j4;
        }
        if (this.S0 == this.T0) {
            if (!g(j7)) {
                return false;
            }
            c(gdVar, i3, j6);
            j(j7);
            return true;
        }
        long j8 = jElapsedRealtime - this.f62243g1;
        if (this.Y0 ? this.W0 : !(z6 || this.X0)) {
            z4 = true;
            z5 = false;
        } else {
            z4 = true;
            z5 = true;
        }
        if (this.f62237a1 == -9223372036854775807L && j3 >= jM && (z5 || (z6 && d(j7, j8)))) {
            long jNanoTime = System.nanoTime();
            a(j6, jNanoTime, e9Var);
            if (xp.f65027a >= 21) {
                a(gdVar, i3, j6, jNanoTime);
                odVar = this;
            } else {
                odVar = this;
                odVar.b(gdVar, i3, j6);
            }
            odVar.j(j7);
            return z4;
        }
        if (z6 && j3 != this.Z0) {
            long jNanoTime2 = System.nanoTime();
            long jA = this.K0.a((j7 * 1000) + jNanoTime2);
            long j9 = (jA - jNanoTime2) / 1000;
            boolean z7 = this.f62237a1 != -9223372036854775807L ? z4 : false;
            if (a(j9, j4, z3) && b(j3, z7)) {
                return false;
            }
            if (b(j9, j4, z3)) {
                if (z7) {
                    c(gdVar, i3, j6);
                } else {
                    a(gdVar, i3, j6);
                }
                j(j9);
                return z4;
            }
            if (xp.f65027a >= 21) {
                if (j9 < 50000) {
                    a(j6, jA, e9Var);
                    a(gdVar, i3, j6, jA);
                    j(j9);
                    return z4;
                }
            } else if (j9 < 30000) {
                if (j9 > 11000) {
                    try {
                        Thread.sleep((j9 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                a(j6, jA, e9Var);
                b(gdVar, i3, j6);
                j(j9);
                return z4;
            }
        }
        return false;
    }

    protected void a(gd gdVar, int i3, long j3, long j4) {
        j0();
        ko.a("releaseOutputBuffer");
        gdVar.a(i3, j4);
        ko.a();
        this.f62243g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f61372e++;
        this.f62240d1 = 0;
        h0();
    }

    private static void a(gd gdVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        gdVar.a(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.applovin.impl.vq] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.applovin.impl.e2, com.applovin.impl.kd, com.applovin.impl.od] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.applovin.impl.g7] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(Object obj) throws z7 {
        ?? A = obj instanceof Surface ? (Surface) obj : 0;
        if (A == 0) {
            g7 g7Var = this.T0;
            if (g7Var != null) {
                A = g7Var;
            } else {
                jd jdVarJ = J();
                if (jdVarJ != null && c(jdVarJ)) {
                    A = g7.a(this.J0, jdVarJ.f60697g);
                    this.T0 = A;
                }
            }
        }
        if (this.S0 != A) {
            this.S0 = A;
            this.K0.a(A);
            this.U0 = false;
            int iB = b();
            gd gdVarI = I();
            if (gdVarI != null) {
                if (xp.f65027a >= 23 && A != 0 && !this.Q0) {
                    a(gdVarI, A);
                } else {
                    U();
                    P();
                }
            }
            if (A != 0 && A != this.T0) {
                l0();
                c0();
                if (iB == 2) {
                    n0();
                    return;
                }
                return;
            }
            d0();
            c0();
            return;
        }
        if (A == 0 || A == this.T0) {
            return;
        }
        l0();
        k0();
    }

    protected void a(gd gdVar, Surface surface) {
        gdVar.a(surface);
    }

    @Override // com.applovin.impl.kd, com.applovin.impl.qi
    public void a(float f3, float f4) throws z7 {
        super.a(f3, f4);
        this.K0.b(f3);
    }

    protected boolean a(long j3, long j4, boolean z2) {
        return h(j3) && !z2;
    }

    @Override // com.applovin.impl.kd
    protected int a(ld ldVar, e9 e9Var) {
        int i3 = 0;
        if (!hf.i(e9Var.f59394m)) {
            return ri.a(0);
        }
        boolean z2 = e9Var.f59397p != null;
        List listA = a(ldVar, e9Var, z2, false);
        if (z2 && listA.isEmpty()) {
            listA = a(ldVar, e9Var, false, false);
        }
        if (listA.isEmpty()) {
            return ri.a(1);
        }
        if (!kd.d(e9Var)) {
            return ri.a(2);
        }
        jd jdVar = (jd) listA.get(0);
        boolean zB = jdVar.b(e9Var);
        int i4 = jdVar.c(e9Var) ? 16 : 8;
        if (zB) {
            List listA2 = a(ldVar, e9Var, z2, true);
            if (!listA2.isEmpty()) {
                jd jdVar2 = (jd) listA2.get(0);
                if (jdVar2.b(e9Var) && jdVar2.c(e9Var)) {
                    i3 = 32;
                }
            }
        }
        return ri.a(zB ? 4 : 3, i4, i3);
    }

    @Override // com.applovin.impl.kd
    protected id a(Throwable th, jd jdVar) {
        return new nd(th, jdVar, this.S0);
    }
}
