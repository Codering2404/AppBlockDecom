package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.impl.ae;
import com.applovin.impl.d8;
import com.applovin.impl.ee;
import com.applovin.impl.fo;
import com.applovin.impl.gc;
import com.applovin.impl.qh;
import com.applovin.impl.rh;
import com.applovin.impl.wj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class b8 extends d2 {
    private jj A;
    private wj B;
    private boolean C;
    private qh.b D;
    private ud E;
    private ud F;
    private oh G;
    private int H;
    private int I;
    private long J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final wo f58572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final qh.b f58573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final qi[] f58574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final vo f58575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ia f58576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d8.f f58577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d8 f58578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final gc f58579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArraySet f58580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final fo.b f58581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f58582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f58583m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ce f58584n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final r0 f58585o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Looper f58586p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final y1 f58587q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final long f58588r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f58589s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final l3 f58590t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f58591u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f58592v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f58593w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f58594x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f58595y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f58596z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements de {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f58597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private fo f58598b;

        public a(Object obj, fo foVar) {
            this.f58597a = obj;
            this.f58598b = foVar;
        }

        @Override // com.applovin.impl.de
        public fo b() {
            return this.f58598b;
        }

        @Override // com.applovin.impl.de
        public Object a() {
            return this.f58597a;
        }
    }

    public b8(qi[] qiVarArr, vo voVar, ce ceVar, kc kcVar, y1 y1Var, r0 r0Var, boolean z2, jj jjVar, long j3, long j4, jc jcVar, long j5, boolean z3, l3 l3Var, Looper looper, qh qhVar, qh.b bVar) {
        oc.c("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + xp.f65031e + "]");
        b1.b(qiVarArr.length > 0);
        this.f58574d = (qi[]) b1.a(qiVarArr);
        this.f58575e = (vo) b1.a(voVar);
        this.f58584n = ceVar;
        this.f58587q = y1Var;
        this.f58585o = r0Var;
        this.f58583m = z2;
        this.A = jjVar;
        this.f58588r = j3;
        this.f58589s = j4;
        this.C = z3;
        this.f58586p = looper;
        this.f58590t = l3Var;
        this.f58591u = 0;
        final qh qhVar2 = qhVar != null ? qhVar : this;
        this.f58579i = new gc(looper, l3Var, new gc.b() { // from class: com.applovin.impl.dt
            @Override // com.applovin.impl.gc.b
            public final void a(Object obj, a9 a9Var) {
                b8.a(qhVar2, (qh.c) obj, a9Var);
            }
        });
        this.f58580j = new CopyOnWriteArraySet();
        this.f58582l = new ArrayList();
        this.B = new wj.a(0);
        wo woVar = new wo(new si[qiVarArr.length], new g8[qiVarArr.length], null);
        this.f58572b = woVar;
        this.f58581k = new fo.b();
        qh.b bVarA = new qh.b.a().a(1, 2, 12, 13, 14, 15, 16, 17, 18, 19).a(28, voVar.b()).a(bVar).a();
        this.f58573c = bVarA;
        this.D = new qh.b.a().a(bVarA).a(3).a(9).a();
        ud udVar = ud.H;
        this.E = udVar;
        this.F = udVar;
        this.H = -1;
        this.f58576f = l3Var.a(looper, null);
        d8.f fVar = new d8.f() { // from class: com.applovin.impl.et
            @Override // com.applovin.impl.d8.f
            public final void a(d8.e eVar) {
                this.f59552a.c(eVar);
            }
        };
        this.f58577g = fVar;
        this.G = oh.a(woVar);
        if (r0Var != null) {
            r0Var.a(qhVar2, looper);
            b((qh.e) r0Var);
            y1Var.a(new Handler(looper), r0Var);
        }
        this.f58578h = new d8(qiVarArr, voVar, woVar, kcVar, y1Var, this.f58591u, this.f58592v, r0Var, jjVar, jcVar, j5, z3, looper, l3Var, fVar);
    }

    private int U() {
        if (this.G.f62300a.c()) {
            return this.H;
        }
        oh ohVar = this.G;
        return ohVar.f62300a.a(ohVar.f62301b.f64962a, this.f58581k).f59737c;
    }

    private void X() {
        qh.b bVar = this.D;
        qh.b bVarA = a(this.f58573c);
        this.D = bVarA;
        if (bVarA.equals(bVar)) {
            return;
        }
        this.f58579i.a(13, new gc.a() { // from class: com.applovin.impl.ht
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                this.f60256a.d((qh.c) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public db x() {
        return db.h();
    }

    @Override // com.applovin.impl.qh
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public z7 c() {
        return this.G.f62305f;
    }

    public void W() {
        oc.c("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.15.1] [" + xp.f65031e + "] [" + e8.a() + "]");
        if (!this.f58578h.x()) {
            this.f58579i.b(10, new gc.a() { // from class: com.applovin.impl.kt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.c((qh.c) obj);
                }
            });
        }
        this.f58579i.b();
        this.f58576f.a((Object) null);
        r0 r0Var = this.f58585o;
        if (r0Var != null) {
            this.f58587q.a(r0Var);
        }
        oh ohVarA = this.G.a(1);
        this.G = ohVarA;
        oh ohVarA2 = ohVarA.a(ohVarA.f62301b);
        this.G = ohVarA2;
        ohVarA2.f62316q = ohVarA2.f62318s;
        this.G.f62317r = 0L;
    }

    @Override // com.applovin.impl.qh
    public void a(SurfaceView surfaceView) {
    }

    @Override // com.applovin.impl.qh
    public void b(SurfaceView surfaceView) {
    }

    public void c(long j3) {
        this.f58578h.a(j3);
    }

    @Override // com.applovin.impl.qh
    public long e() {
        return this.f58589s;
    }

    @Override // com.applovin.impl.qh
    public int f() {
        if (d()) {
            return this.G.f62301b.f64964c;
        }
        return -1;
    }

    @Override // com.applovin.impl.qh
    public long g() {
        if (!d()) {
            return getCurrentPosition();
        }
        oh ohVar = this.G;
        ohVar.f62300a.a(ohVar.f62301b.f64962a, this.f58581k);
        oh ohVar2 = this.G;
        return ohVar2.f62302c == -9223372036854775807L ? ohVar2.f62300a.a(t(), this.f59059a).b() : this.f58581k.d() + t2.b(this.G.f62302c);
    }

    @Override // com.applovin.impl.qh
    public long getCurrentPosition() {
        return t2.b(a(this.G));
    }

    @Override // com.applovin.impl.qh
    public long getDuration() {
        if (!d()) {
            return G();
        }
        oh ohVar = this.G;
        ae.a aVar = ohVar.f62301b;
        ohVar.f62300a.a(aVar.f64962a, this.f58581k);
        return t2.b(this.f58581k.a(aVar.f64963b, aVar.f64964c));
    }

    @Override // com.applovin.impl.qh
    public long h() {
        return t2.b(this.G.f62317r);
    }

    private fo R() {
        return new sh(this.f58582l, this.B);
    }

    private qh.f d(long j3) {
        Object obj;
        int iA;
        sd sdVar;
        Object obj2;
        int iT = t();
        if (this.G.f62300a.c()) {
            obj = null;
            iA = -1;
            sdVar = null;
            obj2 = null;
        } else {
            oh ohVar = this.G;
            Object obj3 = ohVar.f62301b.f64962a;
            ohVar.f62300a.a(obj3, this.f58581k);
            iA = this.G.f62300a.a(obj3);
            obj2 = obj3;
            obj = this.G.f62300a.a(iT, this.f59059a).f59750a;
            sdVar = this.f59059a.f59752c;
        }
        int i3 = iA;
        long jB = t2.b(j3);
        long jB2 = this.G.f62301b.a() ? t2.b(b(this.G)) : jB;
        ae.a aVar = this.G.f62301b;
        return new qh.f(obj, iT, sdVar, obj2, i3, jB, jB2, aVar.f64963b, aVar.f64964c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f62304e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f62312m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f62313n);
    }

    @Override // com.applovin.impl.qh
    public to A() {
        return new to(this.G.f62308i.f64725c);
    }

    @Override // com.applovin.impl.qh
    public ud C() {
        return this.E;
    }

    @Override // com.applovin.impl.qh
    public int E() {
        if (d()) {
            return this.G.f62301b.f64963b;
        }
        return -1;
    }

    @Override // com.applovin.impl.qh
    public long F() {
        return this.f58588r;
    }

    public boolean S() {
        return this.G.f62315p;
    }

    @Override // com.applovin.impl.qh
    public void a(TextureView textureView) {
    }

    @Override // com.applovin.impl.qh
    public void b(TextureView textureView) {
    }

    @Override // com.applovin.impl.qh
    public qh.b i() {
        return this.D;
    }

    @Override // com.applovin.impl.qh
    public int j() {
        return this.G.f62312m;
    }

    @Override // com.applovin.impl.qh
    public po k() {
        return this.G.f62307h;
    }

    @Override // com.applovin.impl.qh
    public boolean l() {
        return this.G.f62311l;
    }

    @Override // com.applovin.impl.qh
    public int m() {
        return this.f58591u;
    }

    @Override // com.applovin.impl.qh
    public fo n() {
        return this.G.f62300a;
    }

    @Override // com.applovin.impl.qh
    public int o() {
        return this.G.f62304e;
    }

    @Override // com.applovin.impl.qh
    public Looper p() {
        return this.f58586p;
    }

    @Override // com.applovin.impl.qh
    public long q() {
        return 3000L;
    }

    @Override // com.applovin.impl.qh
    public boolean r() {
        return this.f58592v;
    }

    @Override // com.applovin.impl.qh
    public long s() {
        if (this.G.f62300a.c()) {
            return this.J;
        }
        oh ohVar = this.G;
        if (ohVar.f62310k.f64965d != ohVar.f62301b.f64965d) {
            return ohVar.f62300a.a(t(), this.f59059a).d();
        }
        long j3 = ohVar.f62316q;
        if (this.G.f62310k.a()) {
            oh ohVar2 = this.G;
            fo.b bVarA = ohVar2.f62300a.a(ohVar2.f62310k.f64962a, this.f58581k);
            long jB = bVarA.b(this.G.f62310k.f64963b);
            j3 = jB == Long.MIN_VALUE ? bVarA.f59738d : jB;
        }
        oh ohVar3 = this.G;
        return t2.b(a(ohVar3.f62300a, ohVar3.f62310k, j3));
    }

    @Override // com.applovin.impl.qh
    public int t() {
        int iU = U();
        if (iU == -1) {
            return 0;
        }
        return iU;
    }

    @Override // com.applovin.impl.qh
    public int v() {
        if (this.G.f62300a.c()) {
            return this.I;
        }
        oh ohVar = this.G;
        return ohVar.f62300a.a(ohVar.f62301b.f64962a);
    }

    @Override // com.applovin.impl.qh
    public xq z() {
        return xq.f65042f;
    }

    private static boolean c(oh ohVar) {
        return ohVar.f62304e == 3 && ohVar.f62311l && ohVar.f62312m == 0;
    }

    public void a(a8 a8Var) {
        this.f58580j.add(a8Var);
    }

    @Override // com.applovin.impl.qh
    public void b(qh.e eVar) {
        a((qh.c) eVar);
    }

    public void e(qh.c cVar) {
        this.f58579i.b(cVar);
    }

    private static long b(oh ohVar) {
        fo.d dVar = new fo.d();
        fo.b bVar = new fo.b();
        ohVar.f62300a.a(ohVar.f62301b.f64962a, bVar);
        if (ohVar.f62302c == -9223372036854775807L) {
            return ohVar.f62300a.a(bVar.f59737c, dVar).c();
        }
        return bVar.e() + ohVar.f62302c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final d8.e eVar) {
        this.f58576f.a(new Runnable() { // from class: com.applovin.impl.jt
            @Override // java.lang.Runnable
            public final void run() {
                this.f60816a.b(eVar);
            }
        });
    }

    public void a(qh.c cVar) {
        this.f58579i.a(cVar);
    }

    private Pair a(oh ohVar, oh ohVar2, boolean z2, int i3, boolean z3) {
        fo foVar = ohVar2.f62300a;
        fo foVar2 = ohVar.f62300a;
        if (foVar2.c() && foVar.c()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i4 = 3;
        if (foVar2.c() != foVar.c()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (foVar.a(foVar.a(ohVar2.f62301b.f64962a, this.f58581k).f59737c, this.f59059a).f59750a.equals(foVar2.a(foVar2.a(ohVar.f62301b.f64962a, this.f58581k).f59737c, this.f59059a).f59750a)) {
            if (z2 && i3 == 0 && ohVar2.f62301b.f64965d < ohVar.f62301b.f64965d) {
                return new Pair(Boolean.TRUE, 0);
            }
            return new Pair(Boolean.FALSE, -1);
        }
        if (z2 && i3 == 0) {
            i4 = 1;
        } else if (z2 && i3 == 1) {
            i4 = 2;
        } else if (!z3) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(qh.c cVar) {
        cVar.a(z7.a(new f8(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(oh ohVar, qh.c cVar) {
        cVar.d(c(ohVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(oh ohVar, qh.c cVar) {
        cVar.e(ohVar.f62306g);
        cVar.c(ohVar.f62306g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(qh.c cVar) {
        cVar.a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(oh ohVar, qh.c cVar) {
        cVar.a(ohVar.f62305f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(oh ohVar, int i3, qh.c cVar) {
        cVar.a(ohVar.f62300a, i3);
    }

    @Override // com.applovin.impl.qh
    public void b() {
        oh ohVar = this.G;
        if (ohVar.f62304e != 1) {
            return;
        }
        oh ohVarA = ohVar.a((z7) null);
        oh ohVarA2 = ohVarA.a(ohVarA.f62300a.c() ? 4 : 2);
        this.f58593w++;
        this.f58578h.v();
        a(ohVarA2, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.applovin.impl.qh
    public boolean d() {
        return this.G.f62301b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(qh.c cVar) {
        cVar.a(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f62311l, ohVar.f62304e);
    }

    private void b(int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            this.f58582l.remove(i5);
        }
        this.B = this.B.a(i3, i4);
    }

    @Override // com.applovin.impl.qh
    public void b(final boolean z2) {
        if (this.f58592v != z2) {
            this.f58592v = z2;
            this.f58578h.f(z2);
            this.f58579i.a(9, new gc.a() { // from class: com.applovin.impl.gt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    ((qh.c) obj).b(z2);
                }
            });
            X();
            this.f58579i.a();
        }
    }

    private long a(oh ohVar) {
        if (ohVar.f62300a.c()) {
            return t2.a(this.J);
        }
        if (ohVar.f62301b.a()) {
            return ohVar.f62318s;
        }
        return a(ohVar.f62300a, ohVar.f62301b, ohVar.f62318s);
    }

    private Pair a(fo foVar, fo foVar2) {
        long jG = g();
        if (!foVar.c() && !foVar2.c()) {
            Pair pairA = foVar.a(this.f59059a, this.f58581k, t(), t2.a(jG));
            Object obj = ((Pair) xp.a(pairA)).first;
            if (foVar2.a(obj) != -1) {
                return pairA;
            }
            Object objA = d8.a(this.f59059a, this.f58581k, this.f58591u, this.f58592v, obj, foVar, foVar2);
            if (objA != null) {
                foVar2.a(objA, this.f58581k);
                int i3 = this.f58581k.f59737c;
                return a(foVar2, i3, foVar2.a(i3, this.f59059a).b());
            }
            return a(foVar2, -1, -9223372036854775807L);
        }
        boolean z2 = !foVar.c() && foVar2.c();
        int iU = z2 ? -1 : U();
        if (z2) {
            jG = -9223372036854775807L;
        }
        return a(foVar2, iU, jG);
    }

    private Pair a(fo foVar, int i3, long j3) {
        if (foVar.c()) {
            this.H = i3;
            if (j3 == -9223372036854775807L) {
                j3 = 0;
            }
            this.J = j3;
            this.I = 0;
            return null;
        }
        if (i3 == -1 || i3 >= foVar.b()) {
            i3 = foVar.a(this.f58592v);
            j3 = foVar.a(i3, this.f59059a).b();
        }
        return foVar.a(this.f59059a, this.f58581k, i3, t2.a(j3));
    }

    @Override // com.applovin.impl.qh
    public ph a() {
        return this.G.f62313n;
    }

    private qh.f a(int i3, oh ohVar, int i4) {
        int i5;
        Object obj;
        sd sdVar;
        Object obj2;
        int i6;
        long jB;
        long jA;
        long jB2;
        long j3;
        fo.b bVar = new fo.b();
        if (ohVar.f62300a.c()) {
            i5 = i4;
            obj = null;
            sdVar = null;
            obj2 = null;
            i6 = -1;
        } else {
            Object obj3 = ohVar.f62301b.f64962a;
            ohVar.f62300a.a(obj3, bVar);
            int i7 = bVar.f59737c;
            int iA = ohVar.f62300a.a(obj3);
            Object obj4 = ohVar.f62300a.a(i7, this.f59059a).f59750a;
            sdVar = this.f59059a.f59752c;
            obj2 = obj3;
            i6 = iA;
            obj = obj4;
            i5 = i7;
        }
        if (i3 == 0) {
            jB = bVar.f59739f + bVar.f59738d;
            if (ohVar.f62301b.a()) {
                ae.a aVar = ohVar.f62301b;
                jA = bVar.a(aVar.f64963b, aVar.f64964c);
                jB2 = b(ohVar);
                long j4 = jA;
                jB = jB2;
                j3 = j4;
            } else {
                if (ohVar.f62301b.f64966e != -1 && this.G.f62301b.a()) {
                    jB = b(this.G);
                }
                j3 = jB;
            }
        } else if (ohVar.f62301b.a()) {
            jA = ohVar.f62318s;
            jB2 = b(ohVar);
            long j42 = jA;
            jB = jB2;
            j3 = j42;
        } else {
            jB = bVar.f59739f + ohVar.f62318s;
            j3 = jB;
        }
        long jB3 = t2.b(j3);
        long jB4 = t2.b(jB);
        ae.a aVar2 = ohVar.f62301b;
        return new qh.f(obj, i5, sdVar, obj2, i6, jB3, jB4, aVar2.f64963b, aVar2.f64964c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(d8.e eVar) {
        int i3 = this.f58593w - eVar.f59161c;
        this.f58593w = i3;
        boolean z2 = true;
        if (eVar.f59162d) {
            this.f58594x = eVar.f59163e;
            this.f58595y = true;
        }
        if (eVar.f59164f) {
            this.f58596z = eVar.f59165g;
        }
        if (i3 == 0) {
            fo foVar = eVar.f59160b.f62300a;
            if (!this.G.f62300a.c() && foVar.c()) {
                this.H = -1;
                this.J = 0L;
                this.I = 0;
            }
            if (!foVar.c()) {
                List listD = ((sh) foVar).d();
                b1.b(listD.size() == this.f58582l.size());
                for (int i4 = 0; i4 < listD.size(); i4++) {
                    ((a) this.f58582l.get(i4)).f58598b = (fo) listD.get(i4);
                }
            }
            long jA = -9223372036854775807L;
            if (this.f58595y) {
                if (eVar.f59160b.f62301b.equals(this.G.f62301b) && eVar.f59160b.f62303d == this.G.f62318s) {
                    z2 = false;
                }
                if (z2) {
                    if (!foVar.c() && !eVar.f59160b.f62301b.a()) {
                        oh ohVar = eVar.f59160b;
                        jA = a(foVar, ohVar.f62301b, ohVar.f62303d);
                    } else {
                        jA = eVar.f59160b.f62303d;
                    }
                }
            } else {
                z2 = false;
            }
            long j3 = jA;
            this.f58595y = false;
            a(eVar.f59160b, 1, this.f58596z, false, z2, this.f58594x, j3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(qh qhVar, qh.c cVar, a9 a9Var) {
        cVar.a(qhVar, new qh.d(a9Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i3, qh.f fVar, qh.f fVar2, qh.c cVar) {
        cVar.e(i3);
        cVar.a(fVar, fVar2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, qh.c cVar) {
        cVar.b(ohVar.f62305f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, to toVar, qh.c cVar) {
        cVar.a(ohVar.f62307h, toVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(oh ohVar, int i3, qh.c cVar) {
        cVar.a(ohVar.f62311l, i3);
    }

    private oh a(oh ohVar, fo foVar, Pair pair) {
        long jA;
        b1.a(foVar.c() || pair != null);
        fo foVar2 = ohVar.f62300a;
        oh ohVarA = ohVar.a(foVar);
        if (foVar.c()) {
            ae.a aVarA = oh.a();
            long jA2 = t2.a(this.J);
            oh ohVarA2 = ohVarA.a(aVarA, jA2, jA2, jA2, 0L, po.f62471d, this.f58572b, db.h()).a(aVarA);
            ohVarA2.f62316q = ohVarA2.f62318s;
            return ohVarA2;
        }
        Object obj = ohVarA.f62301b.f64962a;
        boolean zEquals = obj.equals(((Pair) xp.a(pair)).first);
        ae.a aVar = !zEquals ? new ae.a(pair.first) : ohVarA.f62301b;
        long jLongValue = ((Long) pair.second).longValue();
        long jA3 = t2.a(g());
        if (!foVar2.c()) {
            jA3 -= foVar2.a(obj, this.f58581k).e();
        }
        if (!zEquals || jLongValue < jA3) {
            ae.a aVar2 = aVar;
            b1.b(!aVar2.a());
            oh ohVarA3 = ohVarA.a(aVar2, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? po.f62471d : ohVarA.f62307h, !zEquals ? this.f58572b : ohVarA.f62308i, !zEquals ? db.h() : ohVarA.f62309j).a(aVar2);
            ohVarA3.f62316q = jLongValue;
            return ohVarA3;
        }
        if (jLongValue == jA3) {
            int iA = foVar.a(ohVarA.f62310k.f64962a);
            if (iA != -1 && foVar.a(iA, this.f58581k).f59737c == foVar.a(aVar.f64962a, this.f58581k).f59737c) {
                return ohVarA;
            }
            foVar.a(aVar.f64962a, this.f58581k);
            if (aVar.a()) {
                jA = this.f58581k.a(aVar.f64963b, aVar.f64964c);
            } else {
                jA = this.f58581k.f59738d;
            }
            ae.a aVar3 = aVar;
            oh ohVarA4 = ohVarA.a(aVar3, ohVarA.f62318s, ohVarA.f62318s, ohVarA.f62303d, jA - ohVarA.f62318s, ohVarA.f62307h, ohVarA.f62308i, ohVarA.f62309j).a(aVar3);
            ohVarA4.f62316q = jA;
            return ohVarA4;
        }
        ae.a aVar4 = aVar;
        b1.b(!aVar4.a());
        long jMax = Math.max(0L, ohVarA.f62317r - (jLongValue - jA3));
        long j3 = ohVarA.f62316q;
        if (ohVarA.f62310k.equals(ohVarA.f62301b)) {
            j3 = jLongValue + jMax;
        }
        oh ohVarA5 = ohVarA.a(aVar4, jLongValue, jLongValue, jLongValue, jMax, ohVarA.f62307h, ohVarA.f62308i, ohVarA.f62309j);
        ohVarA5.f62316q = j3;
        return ohVarA5;
    }

    public void a(af afVar) {
        ud udVarA = this.E.a().a(afVar).a();
        if (udVarA.equals(this.E)) {
            return;
        }
        this.E = udVarA;
        this.f58579i.b(14, new gc.a() { // from class: com.applovin.impl.ft
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                this.f59830a.b((qh.c) obj);
            }
        });
    }

    private long a(fo foVar, ae.a aVar, long j3) {
        foVar.a(aVar.f64962a, this.f58581k);
        return j3 + this.f58581k.e();
    }

    @Override // com.applovin.impl.qh
    public void a(qh.e eVar) {
        e(eVar);
    }

    private oh a(int i3, int i4) {
        b1.a(i3 >= 0 && i4 >= i3 && i4 <= this.f58582l.size());
        int iT = t();
        fo foVarN = n();
        int size = this.f58582l.size();
        this.f58593w++;
        b(i3, i4);
        fo foVarR = R();
        oh ohVarA = a(this.G, foVarR, a(foVarN, foVarR));
        int i5 = ohVarA.f62304e;
        if (i5 != 1 && i5 != 4 && i3 < i4 && i4 == size && iT >= ohVarA.f62300a.b()) {
            ohVarA = ohVarA.a(4);
        }
        this.f58578h.b(i3, i4, this.B);
        return ohVarA;
    }

    @Override // com.applovin.impl.qh
    public void a(int i3, long j3) {
        fo foVar = this.G.f62300a;
        if (i3 >= 0 && (foVar.c() || i3 < foVar.b())) {
            this.f58593w++;
            if (d()) {
                oc.d("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                d8.e eVar = new d8.e(this.G);
                eVar.a(1);
                this.f58577g.a(eVar);
                return;
            }
            int i4 = o() != 1 ? 2 : 1;
            int iT = t();
            oh ohVarA = a(this.G.a(i4), foVar, a(foVar, i3, j3));
            this.f58578h.a(foVar, i3, t2.a(j3));
            a(ohVarA, 0, 1, true, true, 1, a(ohVarA), iT);
            return;
        }
        throw new ab(foVar, i3, j3);
    }

    public void a(ae aeVar) {
        a(Collections.singletonList(aeVar));
    }

    public void a(List list) {
        a(list, true);
    }

    public void a(List list, boolean z2) {
        a(list, -1, -9223372036854775807L, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.List r15, int r16, long r17, boolean r19) {
        /*
            r14 = this;
            r1 = r16
            int r2 = r14.U()
            long r3 = r14.getCurrentPosition()
            int r5 = r14.f58593w
            r6 = 1
            int r5 = r5 + r6
            r14.f58593w = r5
            java.util.List r5 = r14.f58582l
            boolean r5 = r5.isEmpty()
            r7 = 0
            if (r5 != 0) goto L22
            java.util.List r5 = r14.f58582l
            int r5 = r5.size()
            r14.b(r7, r5)
        L22:
            java.util.List r9 = r14.a(r7, r15)
            com.applovin.impl.fo r5 = r14.R()
            boolean r8 = r5.c()
            if (r8 != 0) goto L36
            int r8 = r5.b()
            if (r1 >= r8) goto L39
        L36:
            r10 = r17
            goto L41
        L39:
            com.applovin.impl.ab r2 = new com.applovin.impl.ab
            r10 = r17
            r2.<init>(r5, r1, r10)
            throw r2
        L41:
            r8 = -1
            if (r19 == 0) goto L51
            boolean r1 = r14.f58592v
            int r1 = r5.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L4f:
            r10 = r1
            goto L58
        L51:
            if (r1 != r8) goto L56
            r10 = r2
            r2 = r3
            goto L58
        L56:
            r2 = r10
            goto L4f
        L58:
            com.applovin.impl.oh r1 = r14.G
            android.util.Pair r4 = r14.a(r5, r10, r2)
            com.applovin.impl.oh r1 = r14.a(r1, r5, r4)
            int r4 = r1.f62304e
            if (r10 == r8) goto L78
            if (r4 == r6) goto L78
            boolean r4 = r5.c()
            if (r4 != 0) goto L77
            int r4 = r5.b()
            if (r10 < r4) goto L75
            goto L77
        L75:
            r4 = 2
            goto L78
        L77:
            r4 = 4
        L78:
            com.applovin.impl.oh r1 = r1.a(r4)
            com.applovin.impl.d8 r8 = r14.f58578h
            long r11 = com.applovin.impl.t2.a(r2)
            com.applovin.impl.wj r13 = r14.B
            r8.a(r9, r10, r11, r13)
            com.applovin.impl.oh r2 = r14.G
            com.applovin.impl.ae$a r2 = r2.f62301b
            java.lang.Object r2 = r2.f64962a
            com.applovin.impl.ae$a r3 = r1.f62301b
            java.lang.Object r3 = r3.f64962a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto La3
            com.applovin.impl.oh r2 = r14.G
            com.applovin.impl.fo r2 = r2.f62300a
            boolean r2 = r2.c()
            if (r2 != 0) goto La3
            r5 = r6
            goto La4
        La3:
            r5 = r7
        La4:
            long r7 = r14.a(r1)
            r6 = 4
            r9 = -1
            r2 = 0
            r3 = 1
            r4 = 0
            r0 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.b8.a(java.util.List, int, long, boolean):void");
    }

    @Override // com.applovin.impl.qh
    public void a(boolean z2) {
        a(z2, 0, 1);
    }

    public void a(boolean z2, int i3, int i4) {
        oh ohVar = this.G;
        if (ohVar.f62311l == z2 && ohVar.f62312m == i3) {
            return;
        }
        this.f58593w++;
        oh ohVarA = ohVar.a(z2, i3);
        this.f58578h.a(z2, i3);
        a(ohVarA, 0, i4, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.applovin.impl.qh
    public void a(final int i3) {
        if (this.f58591u != i3) {
            this.f58591u = i3;
            this.f58578h.a(i3);
            this.f58579i.a(8, new gc.a() { // from class: com.applovin.impl.vs
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    ((qh.c) obj).c(i3);
                }
            });
            X();
            this.f58579i.a();
        }
    }

    public void a(boolean z2, z7 z7Var) {
        oh ohVarA;
        if (z2) {
            ohVarA = a(0, this.f58582l.size()).a((z7) null);
        } else {
            oh ohVar = this.G;
            ohVarA = ohVar.a(ohVar.f62301b);
            ohVarA.f62316q = ohVarA.f62318s;
            ohVarA.f62317r = 0L;
        }
        oh ohVarA2 = ohVarA.a(1);
        if (z7Var != null) {
            ohVarA2 = ohVarA2.a(z7Var);
        }
        oh ohVar2 = ohVarA2;
        this.f58593w++;
        this.f58578h.G();
        a(ohVar2, 0, 1, false, ohVar2.f62300a.c() && !this.G.f62300a.c(), 4, a(ohVar2), -1);
    }

    private void a(final oh ohVar, final int i3, final int i4, boolean z2, boolean z3, final int i5, long j3, int i6) {
        oh ohVar2 = this.G;
        this.G = ohVar;
        Pair pairA = a(ohVar, ohVar2, z3, i5, !ohVar2.f62300a.equals(ohVar.f62300a));
        boolean zBooleanValue = ((Boolean) pairA.first).booleanValue();
        final int iIntValue = ((Integer) pairA.second).intValue();
        ud udVarA = this.E;
        if (zBooleanValue) {
            sdVar = ohVar.f62300a.c() ? null : ohVar.f62300a.a(ohVar.f62300a.a(ohVar.f62301b.f64962a, this.f58581k).f59737c, this.f59059a).f59752c;
            udVarA = sdVar != null ? sdVar.f63038d : ud.H;
        }
        if (!ohVar2.f62309j.equals(ohVar.f62309j)) {
            udVarA = udVarA.a().a(ohVar.f62309j).a();
        }
        boolean zEquals = udVarA.equals(this.E);
        this.E = udVarA;
        if (!ohVar2.f62300a.equals(ohVar.f62300a)) {
            this.f58579i.a(0, new gc.a() { // from class: com.applovin.impl.lt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.b(ohVar, i3, (qh.c) obj);
                }
            });
        }
        if (z3) {
            final qh.f fVarA = a(i5, ohVar2, i6);
            final qh.f fVarD = d(j3);
            this.f58579i.a(11, new gc.a() { // from class: com.applovin.impl.rt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.a(i5, fVarA, fVarD, (qh.c) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f58579i.a(1, new gc.a() { // from class: com.applovin.impl.st
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    ((qh.c) obj).a(sdVar, iIntValue);
                }
            });
        }
        if (ohVar2.f62305f != ohVar.f62305f) {
            this.f58579i.a(10, new gc.a() { // from class: com.applovin.impl.ws
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.a(ohVar, (qh.c) obj);
                }
            });
            if (ohVar.f62305f != null) {
                this.f58579i.a(10, new gc.a() { // from class: com.applovin.impl.xs
                    @Override // com.applovin.impl.gc.a
                    public final void a(Object obj) {
                        b8.b(ohVar, (qh.c) obj);
                    }
                });
            }
        }
        wo woVar = ohVar2.f62308i;
        wo woVar2 = ohVar.f62308i;
        if (woVar != woVar2) {
            this.f58575e.a(woVar2.f64726d);
            final to toVar = new to(ohVar.f62308i.f64725c);
            this.f58579i.a(2, new gc.a() { // from class: com.applovin.impl.ys
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.a(ohVar, toVar, (qh.c) obj);
                }
            });
        }
        if (!zEquals) {
            final ud udVar = this.E;
            this.f58579i.a(14, new gc.a() { // from class: com.applovin.impl.zs
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    ((qh.c) obj).a(udVar);
                }
            });
        }
        if (ohVar2.f62306g != ohVar.f62306g) {
            this.f58579i.a(3, new gc.a() { // from class: com.applovin.impl.at
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.c(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f62304e != ohVar.f62304e || ohVar2.f62311l != ohVar.f62311l) {
            this.f58579i.a(-1, new gc.a() { // from class: com.applovin.impl.bt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.d(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f62304e != ohVar.f62304e) {
            this.f58579i.a(4, new gc.a() { // from class: com.applovin.impl.ct
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.e(ohVar, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f62311l != ohVar.f62311l) {
            this.f58579i.a(5, new gc.a() { // from class: com.applovin.impl.mt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.a(ohVar, i4, (qh.c) obj);
                }
            });
        }
        if (ohVar2.f62312m != ohVar.f62312m) {
            this.f58579i.a(6, new gc.a() { // from class: com.applovin.impl.nt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.f(ohVar, (qh.c) obj);
                }
            });
        }
        if (c(ohVar2) != c(ohVar)) {
            this.f58579i.a(7, new gc.a() { // from class: com.applovin.impl.ot
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.g(ohVar, (qh.c) obj);
                }
            });
        }
        if (!ohVar2.f62313n.equals(ohVar.f62313n)) {
            this.f58579i.a(12, new gc.a() { // from class: com.applovin.impl.pt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    b8.h(ohVar, (qh.c) obj);
                }
            });
        }
        if (z2) {
            this.f58579i.a(-1, new gc.a() { // from class: com.applovin.impl.qt
                @Override // com.applovin.impl.gc.a
                public final void a(Object obj) {
                    ((qh.c) obj).b();
                }
            });
        }
        X();
        this.f58579i.a();
        if (ohVar2.f62314o != ohVar.f62314o) {
            Iterator it = this.f58580j.iterator();
            while (it.hasNext()) {
                ((a8) it.next()).f(ohVar.f62314o);
            }
        }
        if (ohVar2.f62315p != ohVar.f62315p) {
            Iterator it2 = this.f58580j.iterator();
            while (it2.hasNext()) {
                ((a8) it2.next()).g(ohVar.f62315p);
            }
        }
    }

    public rh a(rh.b bVar) {
        return new rh(this.f58578h, bVar, this.G.f62300a, t(), this.f58590t, this.f58578h.g());
    }

    private List a(int i3, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            ee.c cVar = new ee.c((ae) list.get(i4), this.f58583m);
            arrayList.add(cVar);
            this.f58582l.add(i4 + i3, new a(cVar.f59482b, cVar.f59481a.i()));
        }
        this.B = this.B.b(i3, arrayList.size());
        return arrayList;
    }
}
