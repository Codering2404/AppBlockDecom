package com.applovin.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Supplier;
import com.applovin.impl.ae;
import com.applovin.impl.af;
import com.applovin.impl.db;
import com.applovin.impl.ee;
import com.applovin.impl.fo;
import com.applovin.impl.g6;
import com.applovin.impl.qi;
import com.applovin.impl.rh;
import com.applovin.impl.sd;
import com.applovin.impl.vd;
import com.applovin.impl.vo;
import com.applovin.impl.y6;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class d8 implements Handler.Callback, vd.a, vo.a, ee.d, g6.a, rh.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private h L;
    private long M;
    private int N;
    private boolean O;
    private z7 P;
    private long Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qi[] f59125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f59126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ri[] f59127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final vo f59128d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final wo f59129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kc f59130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final y1 f59131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ia f59132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerThread f59133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Looper f59134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final fo.d f59135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final fo.b f59136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f59137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f59138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final g6 f59139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ArrayList f59140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l3 f59141r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final f f59142s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final zd f59143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ee f59144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final jc f59145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f59146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private jj f59147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private oh f59148y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private e f59149z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements qi.a {
        a() {
        }

        @Override // com.applovin.impl.qi.a
        public void a(long j3) {
            if (j3 >= 2000) {
                d8.this.I = true;
            }
        }

        @Override // com.applovin.impl.qi.a
        public void a() {
            d8.this.f59132i.c(2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class c {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f59159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public oh f59160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f59162d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f59163e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f59164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f59165g;

        public e(oh ohVar) {
            this.f59160b = ohVar;
        }

        public void b(int i3) {
            this.f59159a = true;
            this.f59164f = true;
            this.f59165g = i3;
        }

        public void c(int i3) {
            if (this.f59162d && this.f59163e != 5) {
                b1.a(i3 == 5);
                return;
            }
            this.f59159a = true;
            this.f59162d = true;
            this.f59163e = i3;
        }

        public void a(int i3) {
            this.f59159a |= i3 > 0;
            this.f59161c += i3;
        }

        public void a(oh ohVar) {
            this.f59159a |= this.f59160b != ohVar;
            this.f59160b = ohVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ae.a f59166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f59167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f59168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f59169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f59170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f59171f;

        public g(ae.a aVar, long j3, long j4, boolean z2, boolean z3, boolean z4) {
            this.f59166a = aVar;
            this.f59167b = j3;
            this.f59168c = j4;
            this.f59169d = z2;
            this.f59170e = z3;
            this.f59171f = z4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fo f59172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f59174c;

        public h(fo foVar, int i3, long j3) {
            this.f59172a = foVar;
            this.f59173b = i3;
            this.f59174c = j3;
        }
    }

    public d8(qi[] qiVarArr, vo voVar, wo woVar, kc kcVar, y1 y1Var, int i3, boolean z2, r0 r0Var, jj jjVar, jc jcVar, long j3, boolean z3, Looper looper, l3 l3Var, f fVar) {
        this.f59142s = fVar;
        this.f59125a = qiVarArr;
        this.f59128d = voVar;
        this.f59129f = woVar;
        this.f59130g = kcVar;
        this.f59131h = y1Var;
        this.F = i3;
        this.G = z2;
        this.f59147x = jjVar;
        this.f59145v = jcVar;
        this.f59146w = j3;
        this.Q = j3;
        this.B = z3;
        this.f59141r = l3Var;
        this.f59137n = kcVar.d();
        this.f59138o = kcVar.a();
        oh ohVarA = oh.a(woVar);
        this.f59148y = ohVarA;
        this.f59149z = new e(ohVarA);
        this.f59127c = new ri[qiVarArr.length];
        for (int i4 = 0; i4 < qiVarArr.length; i4++) {
            qiVarArr[i4].b(i4);
            this.f59127c[i4] = qiVarArr[i4].n();
        }
        this.f59139p = new g6(this, l3Var);
        this.f59140q = new ArrayList();
        this.f59126b = rj.b();
        this.f59135l = new fo.d();
        this.f59136m = new fo.b();
        voVar.a(this, y1Var);
        this.O = true;
        Handler handler = new Handler(looper);
        this.f59143t = new zd(r0Var, handler);
        this.f59144u = new ee(this, r0Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f59133j = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f59134k = looper2;
        this.f59132i = l3Var.a(looper2, this);
    }

    private void A() throws z7 {
        int i3;
        float f3 = this.f59139p.a().f62440a;
        wd wdVarF = this.f59143t.f();
        boolean z2 = true;
        for (wd wdVarE = this.f59143t.e(); wdVarE != null && wdVarE.f64644d; wdVarE = wdVarE.d()) {
            wo woVarB = wdVarE.b(f3, this.f59148y.f62300a);
            if (!woVarB.a(wdVarE.i())) {
                if (z2) {
                    wd wdVarE2 = this.f59143t.e();
                    boolean zA = this.f59143t.a(wdVarE2);
                    boolean[] zArr = new boolean[this.f59125a.length];
                    long jA = wdVarE2.a(woVarB, this.f59148y.f62318s, zA, zArr);
                    oh ohVar = this.f59148y;
                    boolean z3 = (ohVar.f62304e == 4 || jA == ohVar.f62318s) ? false : true;
                    oh ohVar2 = this.f59148y;
                    i3 = 4;
                    this.f59148y = a(ohVar2.f62301b, jA, ohVar2.f62302c, ohVar2.f62303d, z3, 5);
                    if (z3) {
                        c(jA);
                    }
                    boolean[] zArr2 = new boolean[this.f59125a.length];
                    int i4 = 0;
                    while (true) {
                        qi[] qiVarArr = this.f59125a;
                        if (i4 >= qiVarArr.length) {
                            break;
                        }
                        qi qiVar = qiVarArr[i4];
                        boolean zC = c(qiVar);
                        zArr2[i4] = zC;
                        cj cjVar = wdVarE2.f64643c[i4];
                        if (zC) {
                            if (cjVar != qiVar.o()) {
                                a(qiVar);
                            } else if (zArr[i4]) {
                                qiVar.a(this.M);
                            }
                        }
                        i4++;
                    }
                    a(zArr2);
                } else {
                    i3 = 4;
                    this.f59143t.a(wdVarE);
                    if (wdVarE.f64644d) {
                        wdVarE.a(woVarB, Math.max(wdVarE.f64646f.f65183b, wdVarE.d(this.M)), false);
                    }
                }
                a(true);
                if (this.f59148y.f62304e != i3) {
                    m();
                    K();
                    this.f59132i.c(2);
                    return;
                }
                return;
            }
            if (wdVarE == wdVarF) {
                z2 = false;
            }
        }
    }

    private void B() {
        wd wdVarE = this.f59143t.e();
        this.C = wdVarE != null && wdVarE.f64646f.f65189h && this.B;
    }

    private boolean C() {
        wd wdVarE;
        wd wdVarD;
        return E() && !this.C && (wdVarE = this.f59143t.e()) != null && (wdVarD = wdVarE.d()) != null && this.M >= wdVarD.g() && wdVarD.f64647g;
    }

    private boolean D() {
        if (!j()) {
            return false;
        }
        wd wdVarD = this.f59143t.d();
        return this.f59130g.a(wdVarD == this.f59143t.e() ? wdVarD.d(this.M) : wdVarD.d(this.M) - wdVarD.f64646f.f65183b, b(wdVarD.e()), this.f59139p.a().f62440a);
    }

    private boolean E() {
        oh ohVar = this.f59148y;
        return ohVar.f62311l && ohVar.f62312m == 0;
    }

    private void F() {
        this.D = false;
        this.f59139p.b();
        for (qi qiVar : this.f59125a) {
            if (c(qiVar)) {
                qiVar.start();
            }
        }
    }

    private void H() {
        this.f59139p.c();
        for (qi qiVar : this.f59125a) {
            if (c(qiVar)) {
                b(qiVar);
            }
        }
    }

    private void I() {
        wd wdVarD = this.f59143t.d();
        boolean z2 = this.E || (wdVarD != null && wdVarD.f64641a.a());
        oh ohVar = this.f59148y;
        if (z2 != ohVar.f62306g) {
            this.f59148y = ohVar.a(z2);
        }
    }

    private void J() throws z7 {
        if (this.f59148y.f62300a.c() || !this.f59144u.d()) {
            return;
        }
        o();
        q();
        r();
        p();
    }

    private void K() {
        wd wdVarE = this.f59143t.e();
        if (wdVarE == null) {
            return;
        }
        long jH = wdVarE.f64644d ? wdVarE.f64641a.h() : -9223372036854775807L;
        if (jH != -9223372036854775807L) {
            c(jH);
            if (jH != this.f59148y.f62318s) {
                oh ohVar = this.f59148y;
                long j3 = jH;
                this.f59148y = a(ohVar.f62301b, j3, ohVar.f62302c, j3, true, 5);
            }
        } else {
            long jB = this.f59139p.b(wdVarE != this.f59143t.f());
            this.M = jB;
            long jD = wdVarE.d(jB);
            b(this.f59148y.f62318s, jD);
            this.f59148y.f62318s = jD;
        }
        this.f59148y.f62316q = this.f59143t.d().c();
        this.f59148y.f62317r = h();
        oh ohVar2 = this.f59148y;
        if (ohVar2.f62311l && ohVar2.f62304e == 3 && a(ohVar2.f62300a, ohVar2.f62301b) && this.f59148y.f62313n.f62440a == 1.0f) {
            float fA = this.f59145v.a(e(), h());
            if (this.f59139p.a().f62440a != fA) {
                this.f59139p.a(this.f59148y.f62313n.a(fA));
                a(this.f59148y.f62313n, this.f59139p.a().f62440a, false, false);
            }
        }
    }

    private void d() throws z7 {
        a(new boolean[this.f59125a.length]);
    }

    private long e() {
        oh ohVar = this.f59148y;
        return a(ohVar.f62300a, ohVar.f62301b.f64962a, ohVar.f62318s);
    }

    private long f() {
        wd wdVarF = this.f59143t.f();
        if (wdVarF == null) {
            return 0L;
        }
        long jF = wdVarF.f();
        if (!wdVarF.f64644d) {
            return jF;
        }
        int i3 = 0;
        while (true) {
            qi[] qiVarArr = this.f59125a;
            if (i3 >= qiVarArr.length) {
                return jF;
            }
            if (c(qiVarArr[i3]) && this.f59125a[i3].o() == wdVarF.f64643c[i3]) {
                long jI = this.f59125a[i3].i();
                if (jI == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jF = Math.max(jI, jF);
            }
            i3++;
        }
    }

    private long h() {
        return b(this.f59148y.f62316q);
    }

    private boolean i() {
        wd wdVarF = this.f59143t.f();
        if (!wdVarF.f64644d) {
            return false;
        }
        int i3 = 0;
        while (true) {
            qi[] qiVarArr = this.f59125a;
            if (i3 >= qiVarArr.length) {
                return true;
            }
            qi qiVar = qiVarArr[i3];
            cj cjVar = wdVarF.f64643c[i3];
            if (qiVar.o() != cjVar || (cjVar != null && !qiVar.j() && !a(qiVar, wdVarF))) {
                break;
            }
            i3++;
        }
        return false;
    }

    private boolean j() {
        wd wdVarD = this.f59143t.d();
        return (wdVarD == null || wdVarD.e() == Long.MIN_VALUE) ? false : true;
    }

    private boolean k() {
        wd wdVarE = this.f59143t.e();
        long j3 = wdVarE.f64646f.f65186e;
        if (wdVarE.f64644d) {
            return j3 == -9223372036854775807L || this.f59148y.f62318s < j3 || !E();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l() {
        return Boolean.valueOf(this.A);
    }

    private void m() {
        boolean zD = D();
        this.E = zD;
        if (zD) {
            this.f59143t.d().a(this.M);
        }
        I();
    }

    private void n() {
        this.f59149z.a(this.f59148y);
        if (this.f59149z.f59159a) {
            this.f59142s.a(this.f59149z);
            this.f59149z = new e(this.f59148y);
        }
    }

    private void o() {
        yd ydVarA;
        this.f59143t.a(this.M);
        if (this.f59143t.h() && (ydVarA = this.f59143t.a(this.M, this.f59148y)) != null) {
            wd wdVarA = this.f59143t.a(this.f59127c, this.f59128d, this.f59130g.b(), this.f59144u, ydVarA, this.f59129f);
            wdVarA.f64641a.a(this, ydVarA.f65183b);
            if (this.f59143t.e() == wdVarA) {
                c(wdVarA.g());
            }
            a(false);
        }
        if (!this.E) {
            m();
        } else {
            this.E = j();
            I();
        }
    }

    private void p() {
        boolean z2 = false;
        while (C()) {
            if (z2) {
                n();
            }
            wd wdVarE = this.f59143t.e();
            wd wdVarA = this.f59143t.a();
            yd ydVar = wdVarA.f64646f;
            ae.a aVar = ydVar.f65182a;
            long j3 = ydVar.f65183b;
            oh ohVarA = a(aVar, j3, ydVar.f65184c, j3, true, 0);
            this.f59148y = ohVarA;
            fo foVar = ohVarA.f62300a;
            a(foVar, wdVarA.f64646f.f65182a, foVar, wdVarE.f64646f.f65182a, -9223372036854775807L);
            B();
            K();
            z2 = true;
        }
    }

    private void q() {
        wd wdVarF = this.f59143t.f();
        if (wdVarF == null) {
            return;
        }
        int i3 = 0;
        if (wdVarF.d() != null && !this.C) {
            if (i()) {
                if (wdVarF.d().f64644d || this.M >= wdVarF.d().g()) {
                    wo woVarI = wdVarF.i();
                    wd wdVarB = this.f59143t.b();
                    wo woVarI2 = wdVarB.i();
                    if (wdVarB.f64644d && wdVarB.f64641a.h() != -9223372036854775807L) {
                        d(wdVarB.g());
                        return;
                    }
                    for (int i4 = 0; i4 < this.f59125a.length; i4++) {
                        boolean zA = woVarI.a(i4);
                        boolean zA2 = woVarI2.a(i4);
                        if (zA && !this.f59125a[i4].k()) {
                            boolean z2 = this.f59127c[i4].e() == -2;
                            si siVar = woVarI.f64724b[i4];
                            si siVar2 = woVarI2.f64724b[i4];
                            if (!zA2 || !siVar2.equals(siVar) || z2) {
                                a(this.f59125a[i4], wdVarB.g());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!wdVarF.f64646f.f65190i && !this.C) {
            return;
        }
        while (true) {
            qi[] qiVarArr = this.f59125a;
            if (i3 >= qiVarArr.length) {
                return;
            }
            qi qiVar = qiVarArr[i3];
            cj cjVar = wdVarF.f64643c[i3];
            if (cjVar != null && qiVar.o() == cjVar && qiVar.j()) {
                long j3 = wdVarF.f64646f.f65186e;
                a(qiVar, (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) ? -9223372036854775807L : wdVarF.f() + wdVarF.f64646f.f65186e);
            }
            i3++;
        }
    }

    private void r() throws z7 {
        wd wdVarF = this.f59143t.f();
        if (wdVarF == null || this.f59143t.e() == wdVarF || wdVarF.f64647g || !z()) {
            return;
        }
        d();
    }

    private void s() throws Throwable {
        a(this.f59144u.a(), true);
    }

    private void t() {
        for (wd wdVarE = this.f59143t.e(); wdVarE != null; wdVarE = wdVarE.d()) {
            for (g8 g8Var : wdVarE.i().f64725c) {
                if (g8Var != null) {
                    g8Var.j();
                }
            }
        }
    }

    private void u() {
        for (wd wdVarE = this.f59143t.e(); wdVarE != null; wdVarE = wdVarE.d()) {
            for (g8 g8Var : wdVarE.i().f64725c) {
                if (g8Var != null) {
                    g8Var.k();
                }
            }
        }
    }

    private void w() {
        this.f59149z.a(1);
        a(false, false, false, true);
        this.f59130g.f();
        c(this.f59148y.f62300a.c() ? 4 : 2);
        this.f59144u.a(this.f59131h.a());
        this.f59132i.c(2);
    }

    private void y() {
        a(true, false, true, false);
        this.f59130g.e();
        c(1);
        this.f59133j.quit();
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    private boolean z() {
        wd wdVarF = this.f59143t.f();
        wo woVarI = wdVarF.i();
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            qi[] qiVarArr = this.f59125a;
            if (i3 >= qiVarArr.length) {
                return !z2;
            }
            qi qiVar = qiVarArr[i3];
            if (c(qiVar)) {
                boolean z3 = qiVar.o() != wdVarF.f64643c[i3];
                if (!woVarI.a(i3) || z3) {
                    if (!qiVar.k()) {
                        qiVar.a(a(woVarI.f64725c[i3]), wdVarF.f64643c[i3], wdVarF.g(), wdVarF.f());
                    } else if (qiVar.c()) {
                        a(qiVar);
                    } else {
                        z2 = true;
                    }
                }
            }
            i3++;
        }
    }

    public void G() {
        this.f59132i.d(6).a();
    }

    public Looper g() {
        return this.f59134k;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        wd wdVarF;
        try {
            switch (message.what) {
                case 0:
                    w();
                    break;
                case 1:
                    a(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    c();
                    break;
                case 3:
                    a((h) message.obj);
                    break;
                case 4:
                    b((ph) message.obj);
                    break;
                case 5:
                    a((jj) message.obj);
                    break;
                case 6:
                    a(false, true);
                    break;
                case 7:
                    y();
                    return true;
                case 8:
                    c((vd) message.obj);
                    break;
                case 9:
                    b((vd) message.obj);
                    break;
                case 10:
                    A();
                    break;
                case 11:
                    b(message.arg1);
                    break;
                case 12:
                    g(message.arg1 != 0);
                    break;
                case 13:
                    a(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    d((rh) message.obj);
                    break;
                case 15:
                    f((rh) message.obj);
                    break;
                case 16:
                    a((ph) message.obj, false);
                    break;
                case 17:
                    a((b) message.obj);
                    break;
                case 18:
                    a((b) message.obj, message.arg1);
                    break;
                case 19:
                    c8.a(message.obj);
                    a((c) null);
                    break;
                case 20:
                    a(message.arg1, message.arg2, (wj) message.obj);
                    break;
                case 21:
                    a((wj) message.obj);
                    break;
                case 22:
                    s();
                    break;
                case 23:
                    e(message.arg1 != 0);
                    break;
                case 24:
                    d(message.arg1 == 1);
                    break;
                case 25:
                    b();
                    break;
                default:
                    return false;
            }
        } catch (ch e3) {
            int i3 = e3.f58907b;
            if (i3 == 1) {
                i = e3.f58906a ? AdError.MEDIATION_ERROR_CODE : 3003;
            } else if (i3 == 4) {
                i = e3.f58906a ? 3002 : 3004;
            }
            a(e3, i);
        } catch (i5 e4) {
            a(e4, e4.f60348a);
        } catch (y6.a e5) {
            a(e5, e5.f65158a);
        } catch (z7 e6) {
            e = e6;
            if (e.f65378d == 1 && (wdVarF = this.f59143t.f()) != null) {
                e = e.a(wdVarF.f64646f.f65182a);
            }
            if (e.f65384k && this.P == null) {
                oc.c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                ia iaVar = this.f59132i;
                iaVar.a(iaVar.a(25, e));
            } else {
                z7 z7Var = this.P;
                if (z7Var != null) {
                    z7Var.addSuppressed(e);
                    e = this.P;
                }
                oc.a("ExoPlayerImplInternal", "Playback error", e);
                a(true, false);
                this.f59148y = this.f59148y.a(e);
            }
        } catch (IOException e7) {
            a(e7, AdError.SERVER_ERROR_CODE);
        } catch (RuntimeException e8) {
            z7 z7VarA = z7.a(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? 1004 : 1000);
            oc.a("ExoPlayerImplInternal", "Playback error", z7VarA);
            a(true, false);
            this.f59148y = this.f59148y.a(z7VarA);
        }
        n();
        return true;
    }

    public void v() {
        this.f59132i.d(0).a();
    }

    public synchronized boolean x() {
        if (!this.A && this.f59133j.isAlive()) {
            this.f59132i.c(7);
            a(new Supplier() { // from class: com.applovin.impl.pu
                @Override // com.applovin.exoplayer2.common.base.Supplier
                public final Object get() {
                    return this.f62515a.l();
                }
            }, this.f59146w);
            return this.A;
        }
        return true;
    }

    private void b() throws z7 {
        c(true);
    }

    private void c() throws z7 {
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        boolean zA;
        boolean z5;
        long jA = this.f59141r.a();
        J();
        int i4 = this.f59148y.f62304e;
        boolean z6 = true;
        if (i4 == 1 || i4 == 4) {
            this.f59132i.b(2);
            return;
        }
        wd wdVarE = this.f59143t.e();
        if (wdVarE == null) {
            c(jA, 10L);
            return;
        }
        ko.a("doSomeWork");
        K();
        if (wdVarE.f64644d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            wdVarE.f64641a.a(this.f59148y.f62318s - this.f59137n, this.f59138o);
            z3 = true;
            z4 = true;
            int i5 = 0;
            while (true) {
                qi[] qiVarArr = this.f59125a;
                if (i5 >= qiVarArr.length) {
                    break;
                }
                qi qiVar = qiVarArr[i5];
                if (c(qiVar)) {
                    z5 = z6;
                    qiVar.a(this.M, jElapsedRealtime);
                    z3 = (z3 && qiVar.c()) ? z5 : false;
                    boolean z7 = wdVarE.f64643c[i5] != qiVar.o() ? z5 : false;
                    boolean z8 = (z7 || ((z7 || !qiVar.j()) ? false : z5) || qiVar.d() || qiVar.c()) ? z5 : false;
                    z4 = (z4 && z8) ? z5 : false;
                    if (!z8) {
                        qiVar.h();
                    }
                } else {
                    z5 = z6;
                }
                i5++;
                z6 = z5;
            }
            z2 = z6;
        } else {
            z2 = true;
            wdVarE.f64641a.f();
            z3 = true;
            z4 = true;
        }
        long j3 = wdVarE.f64646f.f65186e;
        boolean z9 = (z3 && wdVarE.f64644d && (j3 == -9223372036854775807L || j3 <= this.f59148y.f62318s)) ? z2 : false;
        if (z9 && this.C) {
            this.C = false;
            a(false, this.f59148y.f62312m, false, 5);
        }
        if (z9 && wdVarE.f64646f.f65190i) {
            c(4);
            H();
        } else if (this.f59148y.f62304e == 2 && h(z4)) {
            c(3);
            this.P = null;
            if (E()) {
                F();
            }
        } else if (this.f59148y.f62304e == 3 && (this.K != 0 ? !z4 : !k())) {
            this.D = E();
            c(2);
            if (this.D) {
                u();
                this.f59145v.a();
            }
            H();
        }
        if (this.f59148y.f62304e == 2) {
            int i6 = 0;
            while (true) {
                qi[] qiVarArr2 = this.f59125a;
                if (i6 >= qiVarArr2.length) {
                    break;
                }
                if (c(qiVarArr2[i6]) && this.f59125a[i6].o() == wdVarE.f64643c[i6]) {
                    this.f59125a[i6].h();
                }
                i6++;
            }
            oh ohVar = this.f59148y;
            if (!ohVar.f62306g && ohVar.f62317r < 500000 && j()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z10 = this.J;
        oh ohVar2 = this.f59148y;
        if (z10 != ohVar2.f62314o) {
            this.f59148y = ohVar2.b(z10);
        }
        if ((E() && this.f59148y.f62304e == 3) || (i3 = this.f59148y.f62304e) == 2) {
            zA = a(jA, 10L) ^ z2;
        } else {
            if (this.K == 0 || i3 == 4) {
                this.f59132i.b(2);
            } else {
                c(jA, 1000L);
            }
            zA = false;
        }
        oh ohVar3 = this.f59148y;
        if (ohVar3.f62315p != zA) {
            this.f59148y = ohVar3.c(zA);
        }
        this.I = false;
        ko.a();
    }

    private void e(rh rhVar) {
        if (rhVar.b() != this.f59134k) {
            this.f59132i.a(15, rhVar).a();
            return;
        }
        b(rhVar);
        int i3 = this.f59148y.f62304e;
        if (i3 == 3 || i3 == 2) {
            this.f59132i.c(2);
        }
    }

    private void g(boolean z2) throws z7 {
        this.G = z2;
        if (!this.f59143t.a(this.f59148y.f62300a, z2)) {
            c(true);
        }
        a(false);
    }

    private boolean h(boolean z2) {
        if (this.K == 0) {
            return k();
        }
        if (!z2) {
            return false;
        }
        oh ohVar = this.f59148y;
        if (!ohVar.f62306g) {
            return true;
        }
        long jB = a(ohVar.f62300a, this.f59143t.e().f64646f.f65182a) ? this.f59145v.b() : -9223372036854775807L;
        wd wdVarD = this.f59143t.d();
        return (wdVarD.j() && wdVarD.f64646f.f65190i) || (wdVarD.f64646f.f65182a.a() && !wdVarD.f64644d) || this.f59130g.a(h(), this.f59139p.a().f62440a, this.D, jB);
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(vd vdVar) {
        this.f59132i.a(9, vdVar).a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rh f59155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f59156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f59157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f59158d;

        public d(rh rhVar) {
            this.f59155a = rhVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f59158d;
            if ((obj == null) != (dVar.f59158d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i3 = this.f59156b - dVar.f59156b;
            return i3 != 0 ? i3 : xp.a(this.f59157c, dVar.f59157c);
        }

        public void a(int i3, long j3, Object obj) {
            this.f59156b = i3;
            this.f59157c = j3;
            this.f59158d = obj;
        }
    }

    private void a(wj wjVar) throws Throwable {
        this.f59149z.a(1);
        a(this.f59144u.a(wjVar), false);
    }

    private void b(rh rhVar) {
        if (rhVar.i()) {
            return;
        }
        try {
            rhVar.e().a(rhVar.g(), rhVar.c());
        } finally {
            rhVar.a(true);
        }
    }

    private void d(rh rhVar) {
        if (rhVar.d() == -9223372036854775807L) {
            e(rhVar);
            return;
        }
        if (this.f59148y.f62300a.c()) {
            this.f59140q.add(new d(rhVar));
            return;
        }
        d dVar = new d(rhVar);
        fo foVar = this.f59148y.f62300a;
        if (a(dVar, foVar, foVar, this.F, this.G, this.f59135l, this.f59136m)) {
            this.f59140q.add(dVar);
            Collections.sort(this.f59140q);
        } else {
            rhVar.a(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f59151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final wj f59152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f59153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f59154d;

        private b(List list, wj wjVar, int i3, long j3) {
            this.f59151a = list;
            this.f59152b = wjVar;
            this.f59153c = i3;
            this.f59154d = j3;
        }

        /* synthetic */ b(List list, wj wjVar, int i3, long j3, a aVar) {
            this(list, wjVar, i3, j3);
        }
    }

    private void a(b bVar, int i3) throws Throwable {
        this.f59149z.a(1);
        ee eeVar = this.f59144u;
        if (i3 == -1) {
            i3 = eeVar.c();
        }
        a(eeVar.a(i3, bVar.f59151a, bVar.f59152b), false);
    }

    private void e(boolean z2) throws z7 {
        this.B = z2;
        B();
        if (!this.C || this.f59143t.f() == this.f59143t.e()) {
            return;
        }
        c(true);
        a(false);
    }

    private void b(qi qiVar) {
        if (qiVar.b() == 2) {
            qiVar.stop();
        }
    }

    private void f(final rh rhVar) {
        Looper looperB = rhVar.b();
        if (!looperB.getThread().isAlive()) {
            oc.d("TAG", "Trying to send message on a dead thread.");
            rhVar.a(false);
        } else {
            this.f59141r.a(looperB, null).a(new Runnable() { // from class: com.applovin.impl.qu
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62680a.c(rhVar);
                }
            });
        }
    }

    private long b(long j3) {
        wd wdVarD = this.f59143t.d();
        if (wdVarD == null) {
            return 0L;
        }
        return Math.max(0L, j3 - wdVarD.d(this.M));
    }

    private void d(long j3) {
        for (qi qiVar : this.f59125a) {
            if (qiVar.o() != null) {
                a(qiVar, j3);
            }
        }
    }

    private boolean a(fo foVar, ae.a aVar) {
        if (!aVar.a() && !foVar.c()) {
            foVar.a(foVar.a(aVar.f64962a, this.f59136m).f59737c, this.f59135l);
            if (this.f59135l.e()) {
                fo.d dVar = this.f59135l;
                if (dVar.f59758j && dVar.f59755g != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b(vd vdVar) {
        if (this.f59143t.a(vdVar)) {
            this.f59143t.a(this.M);
            m();
        }
    }

    private void d(boolean z2) {
        if (z2 == this.J) {
            return;
        }
        this.J = z2;
        oh ohVar = this.f59148y;
        int i3 = ohVar.f62304e;
        if (!z2 && i3 != 4 && i3 != 1) {
            this.f59132i.c(2);
        } else {
            this.f59148y = ohVar.b(z2);
        }
    }

    public void f(boolean z2) {
        this.f59132i.a(12, z2 ? 1 : 0, 0).a();
    }

    private void a(qi qiVar) {
        if (c(qiVar)) {
            this.f59139p.a(qiVar);
            b(qiVar);
            qiVar.f();
            this.K--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r9, long r11) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d8.b(long, long):void");
    }

    private void a(boolean z2, boolean z3) {
        a(z2 || !this.H, false, true, false);
        this.f59149z.a(z3 ? 1 : 0);
        this.f59130g.c();
        c(1);
    }

    private void a(fo foVar, ae.a aVar, fo foVar2, ae.a aVar2, long j3) {
        if (!foVar.c() && a(foVar, aVar)) {
            foVar.a(foVar.a(aVar.f64962a, this.f59136m).f59737c, this.f59135l);
            this.f59145v.a((sd.f) xp.a(this.f59135l.f59760l));
            if (j3 != -9223372036854775807L) {
                this.f59145v.a(a(foVar, aVar.f64962a, j3));
                return;
            }
            if (xp.a(!foVar2.c() ? foVar2.a(foVar2.a(aVar2.f64962a, this.f59136m).f59737c, this.f59135l).f59750a : null, this.f59135l.f59750a)) {
                return;
            }
            this.f59145v.a(-9223372036854775807L);
            return;
        }
        float f3 = this.f59139p.a().f62440a;
        ph phVar = this.f59148y.f62313n;
        if (f3 != phVar.f62440a) {
            this.f59139p.a(phVar);
        }
    }

    private void a(int i3, boolean z2) throws z7 {
        qi qiVar = this.f59125a[i3];
        if (c(qiVar)) {
            return;
        }
        wd wdVarF = this.f59143t.f();
        boolean z3 = wdVarF == this.f59143t.e();
        wo woVarI = wdVarF.i();
        si siVar = woVarI.f64724b[i3];
        e9[] e9VarArrA = a(woVarI.f64725c[i3]);
        boolean z4 = E() && this.f59148y.f62304e == 3;
        boolean z5 = !z2 && z4;
        this.K++;
        this.f59126b.add(qiVar);
        qiVar.a(siVar, e9VarArrA, wdVarF.f64643c[i3], this.M, z5, z3, wdVarF.g(), wdVarF.f());
        qiVar.a(11, new a());
        this.f59139p.b(qiVar);
        if (z4) {
            qiVar.start();
        }
    }

    private void b(boolean z2) {
        for (wd wdVarE = this.f59143t.e(); wdVarE != null; wdVarE = wdVarE.d()) {
            for (g8 g8Var : wdVarE.i().f64725c) {
                if (g8Var != null) {
                    g8Var.a(z2);
                }
            }
        }
    }

    public void b(int i3, int i4, wj wjVar) {
        this.f59132i.a(20, i3, i4, wjVar).a();
    }

    private void b(ph phVar) {
        this.f59139p.a(phVar);
        a(this.f59139p.a(), true);
    }

    private void b(int i3) throws z7 {
        this.F = i3;
        if (!this.f59143t.a(this.f59148y.f62300a, i3)) {
            c(true);
        }
        a(false);
    }

    private void a(po poVar, wo woVar) {
        this.f59130g.a(this.f59125a, poVar, woVar.f64725c);
    }

    private void a(boolean[] zArr) throws z7 {
        wd wdVarF = this.f59143t.f();
        wo woVarI = wdVarF.i();
        for (int i3 = 0; i3 < this.f59125a.length; i3++) {
            if (!woVarI.a(i3) && this.f59126b.remove(this.f59125a[i3])) {
                this.f59125a[i3].reset();
            }
        }
        for (int i4 = 0; i4 < this.f59125a.length; i4++) {
            if (woVarI.a(i4)) {
                a(i4, zArr[i4]);
            }
        }
        wdVarF.f64647g = true;
    }

    private void c(vd vdVar) throws z7 {
        if (this.f59143t.a(vdVar)) {
            wd wdVarD = this.f59143t.d();
            wdVarD.a(this.f59139p.a().f62440a, this.f59148y.f62300a);
            a(wdVarD.h(), wdVarD.i());
            if (wdVarD == this.f59143t.e()) {
                c(wdVarD.f64646f.f65183b);
                d();
                oh ohVar = this.f59148y;
                ae.a aVar = ohVar.f62301b;
                long j3 = wdVarD.f64646f.f65183b;
                this.f59148y = a(aVar, j3, ohVar.f62302c, j3, false, 5);
            }
            m();
        }
    }

    public void a(long j3) {
        this.Q = j3;
    }

    private void a(float f3) {
        for (wd wdVarE = this.f59143t.e(); wdVarE != null; wdVarE = wdVarE.d()) {
            for (g8 g8Var : wdVarE.i().f64725c) {
                if (g8Var != null) {
                    g8Var.a(f3);
                }
            }
        }
    }

    private synchronized void a(Supplier supplier, long j3) {
        long jC = this.f59141r.c() + j3;
        boolean z2 = false;
        while (!((Boolean) supplier.get()).booleanValue() && j3 > 0) {
            try {
                this.f59141r.b();
                wait(j3);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j3 = jC - this.f59141r.c();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean c(qi qiVar) {
        return qiVar.b() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(rh rhVar) {
        try {
            b(rhVar);
        } catch (z7 e3) {
            oc.a("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e3);
            throw new RuntimeException(e3);
        }
    }

    private db a(g8[] g8VarArr) {
        db.a aVar = new db.a();
        boolean z2 = false;
        for (g8 g8Var : g8VarArr) {
            if (g8Var != null) {
                af afVar = g8Var.a(0).f59392k;
                if (afVar == null) {
                    aVar.b(new af(new af.b[0]));
                } else {
                    aVar.b(afVar);
                    z2 = true;
                }
            }
        }
        return z2 ? aVar.a() : db.h();
    }

    private void c(long j3) {
        wd wdVarE = this.f59143t.e();
        if (wdVarE != null) {
            j3 = wdVarE.e(j3);
        }
        this.M = j3;
        this.f59139p.a(j3);
        for (qi qiVar : this.f59125a) {
            if (c(qiVar)) {
                qiVar.a(this.M);
            }
        }
        t();
    }

    private static e9[] a(g8 g8Var) {
        int iB = g8Var != null ? g8Var.b() : 0;
        e9[] e9VarArr = new e9[iB];
        for (int i3 = 0; i3 < iB; i3++) {
            e9VarArr[i3] = g8Var.a(i3);
        }
        return e9VarArr;
    }

    private void c(long j3, long j4) {
        this.f59132i.b(2);
        this.f59132i.a(2, j3 + j4);
    }

    private long a(fo foVar, Object obj, long j3) {
        foVar.a(foVar.a(obj, this.f59136m).f59737c, this.f59135l);
        fo.d dVar = this.f59135l;
        if (dVar.f59755g != -9223372036854775807L && dVar.e()) {
            fo.d dVar2 = this.f59135l;
            if (dVar2.f59758j) {
                return t2.a(dVar2.a() - this.f59135l.f59755g) - (j3 + this.f59136m.e());
            }
        }
        return -9223372036854775807L;
    }

    private void c(boolean z2) throws z7 {
        ae.a aVar = this.f59143t.e().f64646f.f65182a;
        long jA = a(aVar, this.f59148y.f62318s, true, false);
        if (jA != this.f59148y.f62318s) {
            oh ohVar = this.f59148y;
            this.f59148y = a(aVar, jA, ohVar.f62302c, ohVar.f62303d, z2, 5);
        }
    }

    private Pair a(fo foVar) {
        long jB = 0;
        if (foVar.c()) {
            return Pair.create(oh.a(), 0L);
        }
        Pair pairA = foVar.a(this.f59135l, this.f59136m, foVar.a(this.G), -9223372036854775807L);
        ae.a aVarA = this.f59143t.a(foVar, pairA.first, 0L);
        long jLongValue = ((Long) pairA.second).longValue();
        if (aVarA.a()) {
            foVar.a(aVarA.f64962a, this.f59136m);
            if (aVarA.f64964c == this.f59136m.d(aVarA.f64963b)) {
                jB = this.f59136m.b();
            }
        } else {
            jB = jLongValue;
        }
        return Pair.create(aVarA, Long.valueOf(jB));
    }

    private void c(int i3) {
        oh ohVar = this.f59148y;
        if (ohVar.f62304e != i3) {
            this.f59148y = ohVar.a(i3);
        }
    }

    private void a(IOException iOException, int i3) {
        z7 z7VarA = z7.a(iOException, i3);
        wd wdVarE = this.f59143t.e();
        if (wdVarE != null) {
            z7VarA = z7VarA.a(wdVarE.f64646f.f65182a);
        }
        oc.a("ExoPlayerImplInternal", "Playback error", z7VarA);
        a(false, false);
        this.f59148y = this.f59148y.a(z7VarA);
    }

    private void a(boolean z2) {
        long jC;
        wd wdVarD = this.f59143t.d();
        ae.a aVar = wdVarD == null ? this.f59148y.f62301b : wdVarD.f64646f.f65182a;
        boolean zEquals = this.f59148y.f62310k.equals(aVar);
        if (!zEquals) {
            this.f59148y = this.f59148y.a(aVar);
        }
        oh ohVar = this.f59148y;
        if (wdVarD == null) {
            jC = ohVar.f62318s;
        } else {
            jC = wdVarD.c();
        }
        ohVar.f62316q = jC;
        this.f59148y.f62317r = h();
        if ((!zEquals || z2) && wdVarD != null && wdVarD.f64644d) {
            a(wdVarD.h(), wdVarD.i());
        }
    }

    private void a(fo foVar, boolean z2) throws Throwable {
        int i3;
        ae.a aVar;
        long j3;
        fo foVar2;
        long j4;
        boolean z3;
        fo foVar3;
        fo foVar4;
        g gVarA = a(foVar, this.f59148y, this.L, this.f59143t, this.F, this.G, this.f59135l, this.f59136m);
        ae.a aVar2 = gVarA.f59166a;
        long j5 = gVarA.f59168c;
        boolean z4 = gVarA.f59169d;
        long jA = gVarA.f59167b;
        int i4 = 1;
        boolean z5 = (this.f59148y.f62301b.equals(aVar2) && jA == this.f59148y.f62318s) ? false : true;
        fo foVar5 = null;
        try {
            if (gVarA.f59170e) {
                if (this.f59148y.f62304e != 1) {
                    c(4);
                }
                a(false, false, false, true);
            }
            try {
                if (!z5) {
                    try {
                        try {
                            i3 = 4;
                            try {
                                i4 = -1;
                                try {
                                    foVar3 = foVar;
                                    if (!this.f59143t.a(foVar, this.M, f())) {
                                        c(false);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    foVar5 = foVar;
                                    aVar = aVar2;
                                    j3 = j5;
                                    foVar2 = foVar5;
                                    oh ohVar = this.f59148y;
                                    fo foVar6 = ohVar.f62300a;
                                    ae.a aVar3 = ohVar.f62301b;
                                    fo foVar7 = foVar2;
                                    a(foVar7, aVar, foVar6, aVar3, gVarA.f59171f ? jA : -9223372036854775807L);
                                    if (z5 || j3 != this.f59148y.f62302c) {
                                        oh ohVar2 = this.f59148y;
                                        Object obj = ohVar2.f62301b.f64962a;
                                        fo foVar8 = ohVar2.f62300a;
                                        if (!z5 || !z2 || foVar8.c() || foVar8.a(obj, this.f59136m).f59740g) {
                                            j4 = j3;
                                            z3 = false;
                                        } else {
                                            j4 = j3;
                                            z3 = true;
                                        }
                                        this.f59148y = a(aVar, jA, j4, this.f59148y.f62303d, z3, foVar7.a(obj) == i4 ? i3 : 3);
                                    }
                                    B();
                                    a(foVar7, this.f59148y.f62300a);
                                    this.f59148y = this.f59148y.a(foVar7);
                                    if (!foVar7.c()) {
                                        this.L = null;
                                    }
                                    a(false);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                foVar5 = foVar;
                                i4 = -1;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            foVar5 = foVar;
                            i4 = -1;
                            i3 = 4;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        foVar5 = foVar;
                        i4 = -1;
                        i3 = 4;
                    }
                } else {
                    foVar3 = foVar;
                    i4 = -1;
                    i3 = 4;
                    if (!foVar3.c()) {
                        for (wd wdVarE = this.f59143t.e(); wdVarE != null; wdVarE = wdVarE.d()) {
                            if (wdVarE.f64646f.f65182a.equals(aVar2)) {
                                wdVarE.f64646f = this.f59143t.a(foVar3, wdVarE.f64646f);
                                wdVarE.m();
                            }
                        }
                        jA = a(aVar2, jA, z4);
                    }
                }
                oh ohVar3 = this.f59148y;
                a(foVar3, aVar2, ohVar3.f62300a, ohVar3.f62301b, gVarA.f59171f ? jA : -9223372036854775807L);
                if (z5 || j5 != this.f59148y.f62302c) {
                    oh ohVar4 = this.f59148y;
                    Object obj2 = ohVar4.f62301b.f64962a;
                    fo foVar9 = ohVar4.f62300a;
                    foVar4 = foVar3;
                    this.f59148y = a(aVar2, jA, j5, this.f59148y.f62303d, z5 && z2 && !foVar9.c() && !foVar9.a(obj2, this.f59136m).f59740g, foVar3.a(obj2) == i4 ? i3 : 3);
                } else {
                    foVar4 = foVar3;
                }
                B();
                a(foVar4, this.f59148y.f62300a);
                this.f59148y = this.f59148y.a(foVar4);
                if (!foVar4.c()) {
                    this.L = null;
                }
                a(false);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            i4 = -1;
            i3 = 4;
            aVar = aVar2;
            j3 = j5;
            foVar2 = foVar;
        }
    }

    private void a(ph phVar, float f3, boolean z2, boolean z3) {
        if (z2) {
            if (z3) {
                this.f59149z.a(1);
            }
            this.f59148y = this.f59148y.a(phVar);
        }
        a(phVar.f62440a);
        for (qi qiVar : this.f59125a) {
            if (qiVar != null) {
                qiVar.a(f3, phVar.f62440a);
            }
        }
    }

    private void a(ph phVar, boolean z2) {
        a(phVar, phVar.f62440a, true, z2);
    }

    private oh a(ae.a aVar, long j3, long j4, long j5, boolean z2, int i3) {
        List list;
        po poVar;
        wo woVar;
        po poVarH;
        wo woVarI;
        this.O = (!this.O && j3 == this.f59148y.f62318s && aVar.equals(this.f59148y.f62301b)) ? false : true;
        B();
        oh ohVar = this.f59148y;
        po poVar2 = ohVar.f62307h;
        wo woVar2 = ohVar.f62308i;
        List listH = ohVar.f62309j;
        if (this.f59144u.d()) {
            wd wdVarE = this.f59143t.e();
            if (wdVarE == null) {
                poVarH = po.f62471d;
            } else {
                poVarH = wdVarE.h();
            }
            if (wdVarE == null) {
                woVarI = this.f59129f;
            } else {
                woVarI = wdVarE.i();
            }
            db dbVarA = a(woVarI.f64725c);
            if (wdVarE != null) {
                yd ydVar = wdVarE.f64646f;
                if (ydVar.f65184c != j4) {
                    wdVarE.f64646f = ydVar.a(j4);
                }
            }
            poVar = poVarH;
            woVar = woVarI;
            list = dbVarA;
        } else {
            if (!aVar.equals(this.f59148y.f62301b)) {
                poVar2 = po.f62471d;
                woVar2 = this.f59129f;
                listH = db.h();
            }
            list = listH;
            poVar = poVar2;
            woVar = woVar2;
        }
        if (z2) {
            this.f59149z.c(i3);
        }
        return this.f59148y.a(aVar, j3, j4, j5, h(), poVar, woVar, list);
    }

    private boolean a(qi qiVar, wd wdVar) {
        wd wdVarD = wdVar.d();
        if (wdVar.f64646f.f65187f && wdVarD.f64644d) {
            return (qiVar instanceof bo) || qiVar.i() >= wdVarD.g();
        }
        return false;
    }

    private static boolean a(oh ohVar, fo.b bVar) {
        ae.a aVar = ohVar.f62301b;
        fo foVar = ohVar.f62300a;
        return foVar.c() || foVar.a(aVar.f64962a, bVar).f59740g;
    }

    private boolean a(long j3, long j4) {
        if (this.J && this.I) {
            return false;
        }
        c(j3, j4);
        return true;
    }

    private void a(c cVar) {
        this.f59149z.a(1);
        throw null;
    }

    @Override // com.applovin.impl.g6.a
    public void a(ph phVar) {
        this.f59132i.a(16, phVar).a();
    }

    @Override // com.applovin.impl.ee.d
    public void a() {
        this.f59132i.c(22);
    }

    @Override // com.applovin.impl.vd.a
    public void a(vd vdVar) {
        this.f59132i.a(8, vdVar).a();
    }

    private void a(int i3, int i4, wj wjVar) throws Throwable {
        this.f59149z.a(1);
        a(this.f59144u.a(i3, i4, wjVar), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[PHI: r4 r5 r7
      0x00a0: PHI (r4v3 com.applovin.impl.ae$a) = (r4v2 com.applovin.impl.ae$a), (r4v8 com.applovin.impl.ae$a) binds: [B:30:0x0075, B:32:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00a0: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:30:0x0075, B:32:0x009a] A[DONT_GENERATE, DONT_INLINE]
      0x00a0: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0075, B:32:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d8.a(boolean, boolean, boolean, boolean):void");
    }

    private static void a(fo foVar, d dVar, fo.d dVar2, fo.b bVar) {
        int i3 = foVar.a(foVar.a(dVar.f59158d, bVar).f59737c, dVar2).f59765q;
        Object obj = foVar.a(i3, bVar, true).f59736b;
        long j3 = bVar.f59738d;
        dVar.a(i3, j3 != -9223372036854775807L ? j3 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean a(d dVar, fo foVar, fo foVar2, int i3, boolean z2, fo.d dVar2, fo.b bVar) {
        Object obj = dVar.f59158d;
        if (obj == null) {
            Pair pairA = a(foVar, new h(dVar.f59155a.f(), dVar.f59155a.h(), dVar.f59155a.d() == Long.MIN_VALUE ? -9223372036854775807L : t2.a(dVar.f59155a.d())), false, i3, z2, dVar2, bVar);
            if (pairA == null) {
                return false;
            }
            dVar.a(foVar.a(pairA.first), ((Long) pairA.second).longValue(), pairA.first);
            if (dVar.f59155a.d() == Long.MIN_VALUE) {
                a(foVar, dVar, dVar2, bVar);
            }
            return true;
        }
        int iA = foVar.a(obj);
        if (iA == -1) {
            return false;
        }
        if (dVar.f59155a.d() == Long.MIN_VALUE) {
            a(foVar, dVar, dVar2, bVar);
            return true;
        }
        dVar.f59156b = iA;
        foVar2.a(dVar.f59158d, bVar);
        if (bVar.f59740g && foVar2.a(bVar.f59737c, dVar2).f59764p == foVar2.a(dVar.f59158d)) {
            Pair pairA2 = foVar.a(dVar2, bVar, foVar.a(dVar.f59158d, bVar).f59737c, dVar.f59157c + bVar.e());
            dVar.a(foVar.a(pairA2.first), ((Long) pairA2.second).longValue(), pairA2.first);
        }
        return true;
    }

    private void a(fo foVar, fo foVar2) {
        if (foVar.c() && foVar2.c()) {
            return;
        }
        int size = this.f59140q.size() - 1;
        while (size >= 0) {
            fo foVar3 = foVar;
            fo foVar4 = foVar2;
            if (!a((d) this.f59140q.get(size), foVar3, foVar4, this.F, this.G, this.f59135l, this.f59136m)) {
                ((d) this.f59140q.get(size)).f59155a.a(false);
                this.f59140q.remove(size);
            }
            size--;
            foVar = foVar3;
            foVar2 = foVar4;
        }
        Collections.sort(this.f59140q);
    }

    private static g a(fo foVar, oh ohVar, h hVar, zd zdVar, int i3, boolean z2, fo.d dVar, fo.b bVar) {
        long j3;
        long j4;
        Object obj;
        int iA;
        long jLongValue;
        int iA2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        fo foVar2;
        fo.b bVar2;
        long j5;
        int i4;
        boolean z7;
        if (foVar.c()) {
            return new g(oh.a(), 0L, -9223372036854775807L, false, true, false);
        }
        ae.a aVar = ohVar.f62301b;
        Object obj2 = aVar.f64962a;
        boolean zA = a(ohVar, bVar);
        if (!ohVar.f62301b.a() && !zA) {
            j3 = ohVar.f62318s;
        } else {
            j3 = ohVar.f62302c;
        }
        long j6 = j3;
        boolean z8 = false;
        if (hVar != null) {
            Pair pairA = a(foVar, hVar, true, i3, z2, dVar, bVar);
            if (pairA == null) {
                iA2 = foVar.a(z2);
                jLongValue = j6;
                j4 = -9223372036854775807L;
                z3 = false;
                z5 = false;
                z4 = true;
            } else {
                if (hVar.f59174c == -9223372036854775807L) {
                    iA2 = foVar.a(pairA.first, bVar).f59737c;
                    jLongValue = j6;
                    z7 = false;
                } else {
                    obj2 = pairA.first;
                    jLongValue = ((Long) pairA.second).longValue();
                    iA2 = -1;
                    z7 = true;
                }
                j4 = -9223372036854775807L;
                z5 = z7;
                if (ohVar.f62304e == 4) {
                    z4 = false;
                    z3 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
            }
        } else {
            j4 = -9223372036854775807L;
            if (ohVar.f62300a.c()) {
                iA2 = foVar.a(z2);
            } else {
                if (foVar.a(obj2) == -1) {
                    obj = obj2;
                    Object objA = a(dVar, bVar, i3, z2, obj, ohVar.f62300a, foVar);
                    if (objA == null) {
                        iA = foVar.a(z2);
                        z6 = true;
                        z4 = z6;
                        iA2 = iA;
                        obj2 = obj;
                        jLongValue = j6;
                        z3 = false;
                        z5 = false;
                    } else {
                        iA = foVar.a(objA, bVar).f59737c;
                    }
                } else {
                    obj = obj2;
                    if (j6 == -9223372036854775807L) {
                        iA2 = foVar.a(obj, bVar).f59737c;
                        obj2 = obj;
                    } else if (zA) {
                        ohVar.f62300a.a(aVar.f64962a, bVar);
                        if (ohVar.f62300a.a(bVar.f59737c, dVar).f59764p == ohVar.f62300a.a(aVar.f64962a)) {
                            Pair pairA2 = foVar.a(dVar, bVar, foVar.a(obj, bVar).f59737c, bVar.e() + j6);
                            obj2 = pairA2.first;
                            jLongValue = ((Long) pairA2.second).longValue();
                        } else {
                            obj2 = obj;
                            jLongValue = j6;
                        }
                        iA2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        iA = -1;
                    }
                }
                z6 = false;
                z4 = z6;
                iA2 = iA;
                obj2 = obj;
                jLongValue = j6;
                z3 = false;
                z5 = false;
            }
            jLongValue = j6;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        if (iA2 != -1) {
            foVar2 = foVar;
            Pair pairA3 = foVar2.a(dVar, bVar, iA2, -9223372036854775807L);
            bVar2 = bVar;
            obj2 = pairA3.first;
            jLongValue = ((Long) pairA3.second).longValue();
            j5 = j4;
        } else {
            foVar2 = foVar;
            bVar2 = bVar;
            j5 = jLongValue;
        }
        ae.a aVarA = zdVar.a(foVar2, obj2, jLongValue);
        boolean z9 = aVarA.f64966e == -1 || ((i4 = aVar.f64966e) != -1 && aVarA.f64963b >= i4);
        boolean zEquals = aVar.f64962a.equals(obj2);
        boolean z10 = zEquals && !aVar.a() && !aVarA.a() && z9;
        foVar2.a(obj2, bVar2);
        if (zEquals && !zA && j6 == j5 && ((aVarA.a() && bVar2.f(aVarA.f64963b)) || (aVar.a() && bVar2.f(aVar.f64963b)))) {
            z8 = true;
        }
        if (z10 || z8) {
            aVarA = aVar;
        }
        if (aVarA.a()) {
            if (aVarA.equals(aVar)) {
                jLongValue = ohVar.f62318s;
            } else {
                foVar2.a(aVarA.f64962a, bVar2);
                jLongValue = aVarA.f64964c == bVar2.d(aVarA.f64963b) ? bVar2.b() : 0L;
            }
        }
        return new g(aVarA, jLongValue, j5, z3, z4, z5);
    }

    private static Pair a(fo foVar, h hVar, boolean z2, int i3, boolean z3, fo.d dVar, fo.b bVar) {
        Pair pairA;
        fo foVar2;
        Object objA;
        fo foVar3 = hVar.f59172a;
        if (foVar.c()) {
            return null;
        }
        boolean zC = foVar3.c();
        fo foVar4 = foVar3;
        if (zC) {
            foVar4 = foVar;
        }
        try {
            pairA = foVar4.a(dVar, bVar, hVar.f59173b, hVar.f59174c);
            foVar2 = foVar4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (foVar.equals(foVar2)) {
            return pairA;
        }
        if (foVar.a(pairA.first) != -1) {
            return (foVar2.a(pairA.first, bVar).f59740g && foVar2.a(bVar.f59737c, dVar).f59764p == foVar2.a(pairA.first)) ? foVar.a(dVar, bVar, foVar.a(pairA.first, bVar).f59737c, hVar.f59174c) : pairA;
        }
        if (z2 && (objA = a(dVar, bVar, i3, z3, pairA.first, foVar2, foVar)) != null) {
            return foVar.a(dVar, bVar, foVar.a(objA, bVar).f59737c, -9223372036854775807L);
        }
        return null;
    }

    static Object a(fo.d dVar, fo.b bVar, int i3, boolean z2, Object obj, fo foVar, fo foVar2) {
        int iA = foVar.a(obj);
        int iA2 = foVar.a();
        int i4 = 0;
        int iA3 = iA;
        int iA4 = -1;
        while (i4 < iA2 && iA4 == -1) {
            fo.d dVar2 = dVar;
            fo.b bVar2 = bVar;
            int i5 = i3;
            boolean z3 = z2;
            fo foVar3 = foVar;
            iA3 = foVar3.a(iA3, bVar2, dVar2, i5, z3);
            if (iA3 == -1) {
                break;
            }
            iA4 = foVar2.a(foVar3.b(iA3));
            i4++;
            foVar = foVar3;
            bVar = bVar2;
            dVar = dVar2;
            i3 = i5;
            z2 = z3;
        }
        if (iA4 == -1) {
            return null;
        }
        return foVar2.b(iA4);
    }

    public void a(fo foVar, int i3, long j3) {
        this.f59132i.a(3, new h(foVar, i3, j3)).a();
    }

    private void a(h hVar) throws Throwable {
        long jLongValue;
        ae.a aVarA;
        long j3;
        boolean z2;
        long j4;
        boolean z3;
        ae.a aVar;
        long j5;
        ae.a aVar2;
        long jA;
        oh ohVar;
        int i3;
        long jA2;
        oh ohVar2;
        fo foVar;
        ae.a aVar3;
        long j6;
        ae.a aVar4;
        long j7;
        this.f59149z.a(1);
        Pair pairA = a(this.f59148y.f62300a, hVar, true, this.F, this.G, this.f59135l, this.f59136m);
        if (pairA == null) {
            Pair pairA2 = a(this.f59148y.f62300a);
            aVarA = (ae.a) pairA2.first;
            jLongValue = ((Long) pairA2.second).longValue();
            z2 = !this.f59148y.f62300a.c();
            j4 = -9223372036854775807L;
            j3 = 0;
        } else {
            Object obj = pairA.first;
            jLongValue = ((Long) pairA.second).longValue();
            long j8 = hVar.f59174c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            aVarA = this.f59143t.a(this.f59148y.f62300a, obj, jLongValue);
            if (aVarA.a()) {
                this.f59148y.f62300a.a(aVarA.f64962a, this.f59136m);
                jLongValue = this.f59136m.d(aVarA.f64963b) == aVarA.f64964c ? this.f59136m.b() : 0L;
                j3 = 0;
            } else {
                j3 = 0;
                if (hVar.f59174c != -9223372036854775807L) {
                    z2 = false;
                }
                j4 = j8;
            }
            z2 = true;
            j4 = j8;
        }
        try {
            if (this.f59148y.f62300a.c()) {
                this.L = hVar;
            } else if (pairA == null) {
                if (this.f59148y.f62304e != 1) {
                    c(4);
                }
                a(false, true, false, true);
            } else {
                if (aVarA.equals(this.f59148y.f62301b)) {
                    try {
                        wd wdVarE = this.f59143t.e();
                        jA = (wdVarE == null || !wdVarE.f64644d || jLongValue == j3) ? jLongValue : wdVarE.f64641a.a(jLongValue, this.f59147x);
                        aVar2 = aVarA;
                        try {
                            if (t2.b(jA) != t2.b(this.f59148y.f62318s) || ((i3 = (ohVar = this.f59148y).f62304e) != 2 && i3 != 3)) {
                                z3 = z2;
                            }
                            long j9 = ohVar.f62318s;
                            this.f59148y = a(aVar2, j9, j4, j9, z2, 2);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            z3 = z2;
                            aVar = aVar2;
                            j5 = jLongValue;
                            this.f59148y = a(aVar, j5, j4, j5, z3, 2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z3 = z2;
                        aVar2 = aVarA;
                    }
                } else {
                    z3 = z2;
                    aVar2 = aVarA;
                    jA = jLongValue;
                }
                try {
                    jA2 = a(aVar2, jA, this.f59148y.f62304e == 4);
                    z2 = z3 | (jLongValue != jA2);
                    try {
                        ohVar2 = this.f59148y;
                        foVar = ohVar2.f62300a;
                        aVar3 = aVar2;
                        j6 = j4;
                    } catch (Throwable th3) {
                        th = th3;
                        aVar = aVar2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    aVar = aVar2;
                    j5 = jLongValue;
                    this.f59148y = a(aVar, j5, j4, j5, z3, 2);
                    throw th;
                }
                try {
                    a(foVar, aVar3, foVar, ohVar2.f62301b, j6);
                    aVar4 = aVar3;
                    j4 = j6;
                    j7 = jA2;
                    this.f59148y = a(aVar4, j7, j4, j7, z2, 2);
                } catch (Throwable th5) {
                    th = th5;
                    aVar = aVar3;
                    j4 = j6;
                    z3 = z2;
                    j5 = jA2;
                    this.f59148y = a(aVar, j5, j4, j5, z3, 2);
                    throw th;
                }
            }
            aVar4 = aVarA;
            j7 = jLongValue;
            this.f59148y = a(aVar4, j7, j4, j7, z2, 2);
        } catch (Throwable th6) {
            th = th6;
            z3 = z2;
            aVar = aVarA;
        }
    }

    private long a(ae.a aVar, long j3, boolean z2) {
        return a(aVar, j3, this.f59143t.e() != this.f59143t.f(), z2);
    }

    private long a(ae.a aVar, long j3, boolean z2, boolean z3) throws z7 {
        H();
        this.D = false;
        if (z3 || this.f59148y.f62304e == 3) {
            c(2);
        }
        wd wdVarE = this.f59143t.e();
        wd wdVarD = wdVarE;
        while (wdVarD != null && !aVar.equals(wdVarD.f64646f.f65182a)) {
            wdVarD = wdVarD.d();
        }
        if (z2 || wdVarE != wdVarD || (wdVarD != null && wdVarD.e(j3) < 0)) {
            for (qi qiVar : this.f59125a) {
                a(qiVar);
            }
            if (wdVarD != null) {
                while (this.f59143t.e() != wdVarD) {
                    this.f59143t.a();
                }
                this.f59143t.a(wdVarD);
                wdVarD.c(0L);
                d();
            }
        }
        if (wdVarD != null) {
            this.f59143t.a(wdVarD);
            if (!wdVarD.f64644d) {
                wdVarD.f64646f = wdVarD.f64646f.b(j3);
            } else if (wdVarD.f64645e) {
                j3 = wdVarD.f64641a.a(j3);
                wdVarD.f64641a.a(j3 - this.f59137n, this.f59138o);
            }
            c(j3);
            m();
        } else {
            this.f59143t.c();
            c(j3);
        }
        a(false);
        this.f59132i.c(2);
        return j3;
    }

    @Override // com.applovin.impl.rh.a
    public synchronized void a(rh rhVar) {
        if (!this.A && this.f59133j.isAlive()) {
            this.f59132i.a(14, rhVar).a();
            return;
        }
        oc.d("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        rhVar.a(false);
    }

    private void a(qi qiVar, long j3) {
        qiVar.g();
        if (qiVar instanceof bo) {
            ((bo) qiVar).c(j3);
        }
    }

    private void a(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.H != z2) {
            this.H = z2;
            if (!z2) {
                for (qi qiVar : this.f59125a) {
                    if (!c(qiVar) && this.f59126b.remove(qiVar)) {
                        qiVar.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void a(b bVar) throws Throwable {
        this.f59149z.a(1);
        if (bVar.f59153c != -1) {
            this.L = new h(new sh(bVar.f59151a, bVar.f59152b), bVar.f59153c, bVar.f59154d);
        }
        a(this.f59144u.a(bVar.f59151a, bVar.f59152b), false);
    }

    public void a(List list, int i3, long j3, wj wjVar) {
        this.f59132i.a(17, new b(list, wjVar, i3, j3, null)).a();
    }

    public void a(boolean z2, int i3) {
        this.f59132i.a(1, z2 ? 1 : 0, i3).a();
    }

    private void a(boolean z2, int i3, boolean z3, int i4) {
        this.f59149z.a(z3 ? 1 : 0);
        this.f59149z.b(i4);
        this.f59148y = this.f59148y.a(z2, i3);
        this.D = false;
        b(z2);
        if (!E()) {
            H();
            K();
            return;
        }
        int i5 = this.f59148y.f62304e;
        if (i5 == 3) {
            F();
            this.f59132i.c(2);
        } else if (i5 == 2) {
            this.f59132i.c(2);
        }
    }

    public void a(int i3) {
        this.f59132i.a(11, i3, 0).a();
    }

    private void a(jj jjVar) {
        this.f59147x = jjVar;
    }
}
