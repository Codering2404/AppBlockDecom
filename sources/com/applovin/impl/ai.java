package com.applovin.impl;

import android.net.Uri;
import android.os.Handler;
import com.applovin.impl.be;
import com.applovin.impl.bj;
import com.applovin.impl.e9;
import com.applovin.impl.ij;
import com.applovin.impl.k5;
import com.applovin.impl.lc;
import com.applovin.impl.nc;
import com.applovin.impl.sa;
import com.applovin.impl.vd;
import com.applovin.impl.z6;
import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ai implements vd, l8, nc.b, nc.f, bj.d {
    private static final Map N = l();
    private static final e9 O = new e9.b().c("icy").f("application/x-icy").a();
    private boolean B;
    private boolean D;
    private boolean E;
    private int F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f58390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h5 f58391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a7 f58392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final lc f58393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final be.a f58394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final z6.a f58395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f58396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n0 f58397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f58398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f58399k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zh f58401m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private vd.a f58406r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ua f58407s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f58410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f58411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f58412x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e f58413y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ij f58414z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final nc f58400l = new nc("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c4 f58402n = new c4();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f58403o = new Runnable() { // from class: com.applovin.impl.ls
        @Override // java.lang.Runnable
        public final void run() {
            this.f61296a.r();
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f58404p = new Runnable() { // from class: com.applovin.impl.ms
        @Override // java.lang.Runnable
        public final void run() {
            this.f61932a.q();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Handler f58405q = xp.a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private d[] f58409u = new d[0];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private bj[] f58408t = new bj[0];
    private long I = -9223372036854775807L;
    private long G = -1;
    private long A = -9223372036854775807L;
    private int C = 1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class a implements nc.e, sa.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f58416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final fl f58417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final zh f58418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final l8 f58419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c4 f58420f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f58422h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f58424j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private qo f58427m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f58428n;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final th f58421g = new th();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f58423i = true;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f58426l = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f58415a = mc.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private k5 f58425k = a(0);

        public a(Uri uri, h5 h5Var, zh zhVar, l8 l8Var, c4 c4Var) {
            this.f58416b = uri;
            this.f58417c = new fl(h5Var);
            this.f58418d = zhVar;
            this.f58419e = l8Var;
            this.f58420f = c4Var;
        }

        @Override // com.applovin.impl.nc.e
        public void b() {
            this.f58422h = true;
        }

        @Override // com.applovin.impl.nc.e
        public void a() {
            int iA = 0;
            while (iA == 0 && !this.f58422h) {
                try {
                    long j3 = this.f58421g.f63943a;
                    k5 k5VarA = a(j3);
                    this.f58425k = k5VarA;
                    long jA = this.f58417c.a(k5VarA);
                    this.f58426l = jA;
                    if (jA != -1) {
                        this.f58426l = jA + j3;
                    }
                    ai.this.f58407s = ua.a(this.f58417c.e());
                    f5 saVar = this.f58417c;
                    if (ai.this.f58407s != null && ai.this.f58407s.f64163g != -1) {
                        saVar = new sa(this.f58417c, ai.this.f58407s.f64163g, this);
                        qo qoVarO = ai.this.o();
                        this.f58427m = qoVarO;
                        qoVarO.a(ai.O);
                    }
                    this.f58418d.a(saVar, this.f58416b, this.f58417c.e(), j3, this.f58426l, this.f58419e);
                    if (ai.this.f58407s != null) {
                        this.f58418d.c();
                    }
                    if (this.f58423i) {
                        this.f58418d.a(j3, this.f58424j);
                        this.f58423i = false;
                    }
                    while (iA == 0 && !this.f58422h) {
                        try {
                            this.f58420f.a();
                            iA = this.f58418d.a(this.f58421g);
                            long jB = this.f58418d.b();
                            if (jB > ai.this.f58399k + j3) {
                                this.f58420f.c();
                                ai.this.f58405q.post(ai.this.f58404p);
                                j3 = jB;
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    if (iA == 1) {
                        iA = 0;
                    } else if (this.f58418d.b() != -1) {
                        this.f58421g.f63943a = this.f58418d.b();
                    }
                    xp.a((h5) this.f58417c);
                } catch (Throwable th) {
                    if (iA != 1 && this.f58418d.b() != -1) {
                        this.f58421g.f63943a = this.f58418d.b();
                    }
                    xp.a((h5) this.f58417c);
                    throw th;
                }
            }
        }

        @Override // com.applovin.impl.sa.a
        public void a(ah ahVar) {
            long jMax = !this.f58428n ? this.f58424j : Math.max(ai.this.n(), this.f58424j);
            int iA = ahVar.a();
            qo qoVar = (qo) b1.a(this.f58427m);
            qoVar.a(ahVar, iA);
            qoVar.a(jMax, 1, iA, 0, null);
            this.f58428n = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j3, long j4) {
            this.f58421g.f63943a = j3;
            this.f58424j = j4;
            this.f58423i = true;
            this.f58428n = false;
        }

        private k5 a(long j3) {
            return new k5.b().a(this.f58416b).a(j3).a(ai.this.f58398j).a(6).a(ai.N).a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface b {
        void a(long j3, boolean z2, boolean z3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class c implements cj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f58430a;

        public c(int i3) {
            this.f58430a = i3;
        }

        @Override // com.applovin.impl.cj
        public boolean d() {
            return ai.this.a(this.f58430a);
        }

        @Override // com.applovin.impl.cj
        public void a() throws IOException {
            ai.this.d(this.f58430a);
        }

        @Override // com.applovin.impl.cj
        public int a(f9 f9Var, o5 o5Var, int i3) {
            return ai.this.a(this.f58430a, f9Var, o5Var, i3);
        }

        @Override // com.applovin.impl.cj
        public int a(long j3) {
            return ai.this.a(this.f58430a, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f58433b;

        public d(int i3, boolean z2) {
            this.f58432a = i3;
            this.f58433b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (this.f58432a == dVar.f58432a && this.f58433b == dVar.f58433b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f58432a * 31) + (this.f58433b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final po f58434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f58435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f58436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f58437d;

        public e(po poVar, boolean[] zArr) {
            this.f58434a = poVar;
            this.f58435b = zArr;
            int i3 = poVar.f62473a;
            this.f58436c = new boolean[i3];
            this.f58437d = new boolean[i3];
        }
    }

    public ai(Uri uri, h5 h5Var, zh zhVar, a7 a7Var, z6.a aVar, lc lcVar, be.a aVar2, b bVar, n0 n0Var, String str, int i3) {
        this.f58390a = uri;
        this.f58391b = h5Var;
        this.f58392c = a7Var;
        this.f58395g = aVar;
        this.f58393d = lcVar;
        this.f58394f = aVar2;
        this.f58396h = bVar;
        this.f58397i = n0Var;
        this.f58398j = str;
        this.f58399k = i3;
        this.f58401m = zhVar;
    }

    private void k() {
        b1.b(this.f58411w);
        b1.a(this.f58413y);
        b1.a(this.f58414z);
    }

    private static Map l() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        return Collections.unmodifiableMap(map);
    }

    private int m() {
        int iG = 0;
        for (bj bjVar : this.f58408t) {
            iG += bjVar.g();
        }
        return iG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long n() {
        long jMax = Long.MIN_VALUE;
        for (bj bjVar : this.f58408t) {
            jMax = Math.max(jMax, bjVar.c());
        }
        return jMax;
    }

    private boolean p() {
        return this.I != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (this.M) {
            return;
        }
        ((vd.a) b1.a(this.f58406r)).a((pj) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.M || this.f58411w || !this.f58410v || this.f58414z == null) {
            return;
        }
        for (bj bjVar : this.f58408t) {
            if (bjVar.f() == null) {
                return;
            }
        }
        this.f58402n.c();
        int length = this.f58408t.length;
        oo[] ooVarArr = new oo[length];
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            e9 e9VarA = (e9) b1.a(this.f58408t[i3].f());
            String str = e9VarA.f59394m;
            boolean zG = hf.g(str);
            boolean z2 = zG || hf.i(str);
            zArr[i3] = z2;
            this.f58412x = z2 | this.f58412x;
            ua uaVar = this.f58407s;
            if (uaVar != null) {
                if (zG || this.f58409u[i3].f58433b) {
                    af afVar = e9VarA.f59392k;
                    e9VarA = e9VarA.a().a(afVar == null ? new af(uaVar) : afVar.a(uaVar)).a();
                }
                if (zG && e9VarA.f59388g == -1 && e9VarA.f59389h == -1 && uaVar.f64158a != -1) {
                    e9VarA = e9VarA.a().b(uaVar.f64158a).a();
                }
            }
            ooVarArr[i3] = new oo(e9VarA.a(this.f58392c.a(e9VarA)));
        }
        this.f58413y = new e(new po(ooVarArr), zArr);
        this.f58411w = true;
        ((vd.a) b1.a(this.f58406r)).a((vd) this);
    }

    private void u() {
        a aVar = new a(this.f58390a, this.f58391b, this.f58401m, this, this.f58402n);
        if (this.f58411w) {
            b1.b(p());
            long j3 = this.A;
            if (j3 != -9223372036854775807L && this.I > j3) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            aVar.a(((ij) b1.a(this.f58414z)).b(this.I).f60489a.f61039b, this.I);
            for (bj bjVar : this.f58408t) {
                bjVar.c(this.I);
            }
            this.I = -9223372036854775807L;
        }
        this.K = m();
        this.f58394f.c(new mc(aVar.f58415a, aVar.f58425k, this.f58400l.a(aVar, this, this.f58393d.a(this.C))), 1, -1, null, 0, null, aVar.f58424j, this.A);
    }

    private boolean v() {
        return this.E || p();
    }

    @Override // com.applovin.impl.vd
    public void c(long j3) {
    }

    qo o() {
        return a(new d(0, true));
    }

    void s() throws IOException {
        this.f58400l.a(this.f58393d.a(this.C));
    }

    public void t() {
        if (this.f58411w) {
            for (bj bjVar : this.f58408t) {
                bjVar.k();
            }
        }
        this.f58400l.a(this);
        this.f58405q.removeCallbacksAndMessages(null);
        this.f58406r = null;
        this.M = true;
    }

    @Override // com.applovin.impl.vd
    public boolean b(long j3) {
        if (this.L || this.f58400l.c() || this.J) {
            return false;
        }
        if (this.f58411w && this.F == 0) {
            return false;
        }
        boolean zE = this.f58402n.e();
        if (this.f58400l.d()) {
            return zE;
        }
        u();
        return true;
    }

    void d(int i3) throws IOException {
        this.f58408t[i3].j();
        s();
    }

    @Override // com.applovin.impl.vd
    public long e() {
        long jN;
        k();
        boolean[] zArr = this.f58413y.f58435b;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (p()) {
            return this.I;
        }
        if (this.f58412x) {
            int length = this.f58408t.length;
            jN = Long.MAX_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i3] && !this.f58408t[i3].i()) {
                    jN = Math.min(jN, this.f58408t[i3].c());
                }
            }
        } else {
            jN = Long.MAX_VALUE;
        }
        if (jN == Long.MAX_VALUE) {
            jN = n();
        }
        return jN == Long.MIN_VALUE ? this.H : jN;
    }

    @Override // com.applovin.impl.vd
    public void f() throws IOException {
        s();
        if (this.L && !this.f58411w) {
            throw ch.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.applovin.impl.vd
    public long g() {
        if (this.F == 0) {
            return Long.MIN_VALUE;
        }
        return e();
    }

    @Override // com.applovin.impl.vd
    public long h() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L && m() <= this.K) {
            return -9223372036854775807L;
        }
        this.E = false;
        return this.H;
    }

    @Override // com.applovin.impl.l8
    public void c() {
        this.f58410v = true;
        this.f58405q.post(this.f58403o);
    }

    private boolean a(a aVar, int i3) {
        ij ijVar;
        if (this.G == -1 && ((ijVar = this.f58414z) == null || ijVar.d() == -9223372036854775807L)) {
            if (this.f58411w && !v()) {
                this.J = true;
                return false;
            }
            this.E = this.f58411w;
            this.H = 0L;
            this.K = 0;
            for (bj bjVar : this.f58408t) {
                bjVar.n();
            }
            aVar.a(0L, 0L);
            return true;
        }
        this.K = i3;
        return true;
    }

    @Override // com.applovin.impl.nc.f
    public void d() {
        for (bj bjVar : this.f58408t) {
            bjVar.l();
        }
        this.f58401m.a();
    }

    private void c(int i3) {
        k();
        boolean[] zArr = this.f58413y.f58435b;
        if (this.J && zArr[i3]) {
            if (this.f58408t[i3].a(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (bj bjVar : this.f58408t) {
                bjVar.n();
            }
            ((vd.a) b1.a(this.f58406r)).a((pj) this);
        }
    }

    @Override // com.applovin.impl.vd
    public po b() {
        k();
        return this.f58413y.f58434a;
    }

    private void b(int i3) {
        k();
        e eVar = this.f58413y;
        boolean[] zArr = eVar.f58437d;
        if (zArr[i3]) {
            return;
        }
        e9 e9VarA = eVar.f58434a.a(i3).a(0);
        this.f58394f.a(hf.e(e9VarA.f59394m), e9VarA, 0, (Object) null, this.H);
        zArr[i3] = true;
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f58426l;
        }
    }

    @Override // com.applovin.impl.vd
    public void a(long j3, boolean z2) {
        k();
        if (p()) {
            return;
        }
        boolean[] zArr = this.f58413y.f58436c;
        int length = this.f58408t.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f58408t[i3].b(j3, z2, zArr[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(ij ijVar) {
        this.f58414z = this.f58407s == null ? ijVar : new ij.b(-9223372036854775807L);
        this.A = ijVar.d();
        boolean z2 = this.G == -1 && ijVar.d() == -9223372036854775807L;
        this.B = z2;
        this.C = z2 ? 7 : 1;
        this.f58396h.a(this.A, ijVar.b(), this.B);
        if (this.f58411w) {
            return;
        }
        r();
    }

    @Override // com.applovin.impl.vd
    public long a(long j3, jj jjVar) {
        k();
        if (!this.f58414z.b()) {
            return 0L;
        }
        ij.a aVarB = this.f58414z.b(j3);
        return jjVar.a(j3, aVarB.f60489a.f61038a, aVarB.f60490b.f61038a);
    }

    @Override // com.applovin.impl.vd
    public boolean a() {
        return this.f58400l.d() && this.f58402n.d();
    }

    boolean a(int i3) {
        return !v() && this.f58408t[i3].a(this.L);
    }

    @Override // com.applovin.impl.nc.b
    public void a(a aVar, long j3, long j4, boolean z2) {
        fl flVar = aVar.f58417c;
        mc mcVar = new mc(aVar.f58415a, aVar.f58425k, flVar.h(), flVar.i(), j3, j4, flVar.g());
        this.f58393d.a(aVar.f58415a);
        this.f58394f.a(mcVar, 1, -1, null, 0, null, aVar.f58424j, this.A);
        if (z2) {
            return;
        }
        a(aVar);
        for (bj bjVar : this.f58408t) {
            bjVar.n();
        }
        if (this.F > 0) {
            ((vd.a) b1.a(this.f58406r)).a((pj) this);
        }
    }

    @Override // com.applovin.impl.nc.b
    public void a(a aVar, long j3, long j4) {
        ij ijVar;
        if (this.A == -9223372036854775807L && (ijVar = this.f58414z) != null) {
            boolean zB = ijVar.b();
            long jN = n();
            long j5 = jN == Long.MIN_VALUE ? 0L : jN + 10000;
            this.A = j5;
            this.f58396h.a(j5, zB, this.B);
        }
        fl flVar = aVar.f58417c;
        mc mcVar = new mc(aVar.f58415a, aVar.f58425k, flVar.h(), flVar.i(), j3, j4, flVar.g());
        this.f58393d.a(aVar.f58415a);
        this.f58394f.b(mcVar, 1, -1, null, 0, null, aVar.f58424j, this.A);
        a(aVar);
        this.L = true;
        ((vd.a) b1.a(this.f58406r)).a((pj) this);
    }

    @Override // com.applovin.impl.nc.b
    public nc.c a(a aVar, long j3, long j4, IOException iOException, int i3) {
        a aVar2;
        nc.c cVarA;
        a(aVar);
        fl flVar = aVar.f58417c;
        mc mcVar = new mc(aVar.f58415a, aVar.f58425k, flVar.h(), flVar.i(), j3, j4, flVar.g());
        long jA = this.f58393d.a(new lc.a(mcVar, new td(1, -1, null, 0, null, t2.b(aVar.f58424j), t2.b(this.A)), iOException, i3));
        if (jA == -9223372036854775807L) {
            cVarA = nc.f62003g;
            aVar2 = aVar;
        } else {
            int iM = m();
            boolean z2 = iM > this.K;
            aVar2 = aVar;
            if (a(aVar2, iM)) {
                cVarA = nc.a(z2, jA);
            } else {
                cVarA = nc.f62002f;
            }
        }
        boolean zA = cVarA.a();
        this.f58394f.a(mcVar, 1, -1, null, 0, null, aVar2.f58424j, this.A, iOException, !zA);
        if (!zA) {
            this.f58393d.a(aVar2.f58415a);
        }
        return cVarA;
    }

    @Override // com.applovin.impl.bj.d
    public void a(e9 e9Var) {
        this.f58405q.post(this.f58403o);
    }

    @Override // com.applovin.impl.vd
    public void a(vd.a aVar, long j3) {
        this.f58406r = aVar;
        this.f58402n.e();
        u();
    }

    private qo a(d dVar) {
        int length = this.f58408t.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (dVar.equals(this.f58409u[i3])) {
                return this.f58408t[i3];
            }
        }
        bj bjVarA = bj.a(this.f58397i, this.f58405q.getLooper(), this.f58392c, this.f58395g);
        bjVarA.a(this);
        int i4 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f58409u, i4);
        dVarArr[length] = dVar;
        this.f58409u = (d[]) xp.a((Object[]) dVarArr);
        bj[] bjVarArr = (bj[]) Arrays.copyOf(this.f58408t, i4);
        bjVarArr[length] = bjVarA;
        this.f58408t = (bj[]) xp.a((Object[]) bjVarArr);
        return bjVarA;
    }

    int a(int i3, f9 f9Var, o5 o5Var, int i4) {
        if (v()) {
            return -3;
        }
        b(i3);
        int iA = this.f58408t[i3].a(f9Var, o5Var, i4, this.L);
        if (iA == -3) {
            c(i3);
        }
        return iA;
    }

    private boolean a(boolean[] zArr, long j3) {
        int length = this.f58408t.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (!this.f58408t[i3].b(j3, false) && (zArr[i3] || !this.f58412x)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.applovin.impl.l8
    public void a(final ij ijVar) {
        this.f58405q.post(new Runnable() { // from class: com.applovin.impl.ns
            @Override // java.lang.Runnable
            public final void run() {
                this.f62137a.b(ijVar);
            }
        });
    }

    @Override // com.applovin.impl.vd
    public long a(long j3) {
        k();
        boolean[] zArr = this.f58413y.f58435b;
        if (!this.f58414z.b()) {
            j3 = 0;
        }
        int i3 = 0;
        this.E = false;
        this.H = j3;
        if (p()) {
            this.I = j3;
            return j3;
        }
        if (this.C == 7 || !a(zArr, j3)) {
            this.J = false;
            this.I = j3;
            this.L = false;
            if (this.f58400l.d()) {
                bj[] bjVarArr = this.f58408t;
                int length = bjVarArr.length;
                while (i3 < length) {
                    bjVarArr[i3].b();
                    i3++;
                }
                this.f58400l.a();
                return j3;
            }
            this.f58400l.b();
            bj[] bjVarArr2 = this.f58408t;
            int length2 = bjVarArr2.length;
            while (i3 < length2) {
                bjVarArr2[i3].n();
                i3++;
            }
        }
        return j3;
    }

    @Override // com.applovin.impl.vd
    public long a(g8[] g8VarArr, boolean[] zArr, cj[] cjVarArr, boolean[] zArr2, long j3) {
        g8 g8Var;
        k();
        e eVar = this.f58413y;
        po poVar = eVar.f58434a;
        boolean[] zArr3 = eVar.f58436c;
        int i3 = this.F;
        int i4 = 0;
        for (int i5 = 0; i5 < g8VarArr.length; i5++) {
            cj cjVar = cjVarArr[i5];
            if (cjVar != null && (g8VarArr[i5] == null || !zArr[i5])) {
                int i6 = ((c) cjVar).f58430a;
                b1.b(zArr3[i6]);
                this.F--;
                zArr3[i6] = false;
                cjVarArr[i5] = null;
            }
        }
        boolean z2 = !this.D ? j3 == 0 : i3 != 0;
        for (int i7 = 0; i7 < g8VarArr.length; i7++) {
            if (cjVarArr[i7] == null && (g8Var = g8VarArr[i7]) != null) {
                b1.b(g8Var.b() == 1);
                b1.b(g8Var.b(0) == 0);
                int iA = poVar.a(g8Var.a());
                b1.b(!zArr3[iA]);
                this.F++;
                zArr3[iA] = true;
                cjVarArr[i7] = new c(iA);
                zArr2[i7] = true;
                if (!z2) {
                    bj bjVar = this.f58408t[iA];
                    z2 = (bjVar.b(j3, true) || bjVar.e() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.f58400l.d()) {
                bj[] bjVarArr = this.f58408t;
                int length = bjVarArr.length;
                while (i4 < length) {
                    bjVarArr[i4].b();
                    i4++;
                }
                this.f58400l.a();
            } else {
                bj[] bjVarArr2 = this.f58408t;
                int length2 = bjVarArr2.length;
                while (i4 < length2) {
                    bjVarArr2[i4].n();
                    i4++;
                }
            }
        } else if (z2) {
            j3 = a(j3);
            while (i4 < cjVarArr.length) {
                if (cjVarArr[i4] != null) {
                    zArr2[i4] = true;
                }
                i4++;
            }
        }
        this.D = true;
        return j3;
    }

    int a(int i3, long j3) {
        if (v()) {
            return 0;
        }
        b(i3);
        bj bjVar = this.f58408t[i3];
        int iA = bjVar.a(j3, this.L);
        bjVar.f(iA);
        if (iA == 0) {
            c(i3);
        }
        return iA;
    }

    @Override // com.applovin.impl.l8
    public qo a(int i3, int i4) {
        return a(new d(i3, false));
    }
}
