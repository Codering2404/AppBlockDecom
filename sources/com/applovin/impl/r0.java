package com.applovin.impl;

import android.os.Looper;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.ae;
import com.applovin.impl.fb;
import com.applovin.impl.fo;
import com.applovin.impl.gc;
import com.applovin.impl.qh;
import com.applovin.impl.s0;
import com.applovin.impl.y1;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class r0 implements qh.e, q1, wq, be, y1.a, z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f62691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fo.b f62692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final fo.d f62693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f62694d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray f62695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private gc f62696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private qh f62697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ia f62698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f62699j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fo.b f62700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private db f62701b = db.h();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private fb f62702c = fb.h();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ae.a f62703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ae.a f62704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ae.a f62705f;

        public a(fo.b bVar) {
            this.f62700a = bVar;
        }

        public ae.a b() {
            if (this.f62701b.isEmpty()) {
                return null;
            }
            return (ae.a) vb.b(this.f62701b);
        }

        public ae.a c() {
            return this.f62704e;
        }

        public ae.a d() {
            return this.f62705f;
        }

        private void a(fb.a aVar, ae.a aVar2, fo foVar) {
            if (aVar2 == null) {
                return;
            }
            if (foVar.a(aVar2.f64962a) != -1) {
                aVar.a(aVar2, foVar);
                return;
            }
            fo foVar2 = (fo) this.f62702c.get(aVar2);
            if (foVar2 != null) {
                aVar.a(aVar2, foVar2);
            }
        }

        public void b(qh qhVar) {
            this.f62703d = a(qhVar, this.f62701b, this.f62704e, this.f62700a);
            a(qhVar.n());
        }

        private static ae.a a(qh qhVar, db dbVar, ae.a aVar, fo.b bVar) {
            fo foVarN = qhVar.n();
            int iV = qhVar.v();
            Object objB = foVarN.c() ? null : foVarN.b(iV);
            int iA = (qhVar.d() || foVarN.c()) ? -1 : foVarN.a(iV, bVar).a(t2.a(qhVar.getCurrentPosition()) - bVar.e());
            for (int i3 = 0; i3 < dbVar.size(); i3++) {
                ae.a aVar2 = (ae.a) dbVar.get(i3);
                if (a(aVar2, objB, qhVar.d(), qhVar.E(), qhVar.f(), iA)) {
                    return aVar2;
                }
            }
            if (dbVar.isEmpty() && aVar != null && a(aVar, objB, qhVar.d(), qhVar.E(), qhVar.f(), iA)) {
                return aVar;
            }
            return null;
        }

        public ae.a a() {
            return this.f62703d;
        }

        public fo a(ae.a aVar) {
            return (fo) this.f62702c.get(aVar);
        }

        private static boolean a(ae.a aVar, Object obj, boolean z2, int i3, int i4, int i5) {
            if (!aVar.f64962a.equals(obj)) {
                return false;
            }
            if (z2 && aVar.f64963b == i3 && aVar.f64964c == i4) {
                return true;
            }
            return !z2 && aVar.f64963b == -1 && aVar.f64966e == i5;
        }

        public void a(qh qhVar) {
            this.f62703d = a(qhVar, this.f62701b, this.f62704e, this.f62700a);
        }

        public void a(List list, ae.a aVar, qh qhVar) {
            this.f62701b = db.a((Collection) list);
            if (!list.isEmpty()) {
                this.f62704e = (ae.a) list.get(0);
                this.f62705f = (ae.a) b1.a(aVar);
            }
            if (this.f62703d == null) {
                this.f62703d = a(qhVar, this.f62701b, this.f62704e, this.f62700a);
            }
            a(qhVar.n());
        }

        private void a(fo foVar) {
            fb.a aVarA = fb.a();
            if (this.f62701b.isEmpty()) {
                a(aVarA, this.f62704e, foVar);
                if (!Objects.equal(this.f62705f, this.f62704e)) {
                    a(aVarA, this.f62705f, foVar);
                }
                if (!Objects.equal(this.f62703d, this.f62704e) && !Objects.equal(this.f62703d, this.f62705f)) {
                    a(aVarA, this.f62703d, foVar);
                }
            } else {
                for (int i3 = 0; i3 < this.f62701b.size(); i3++) {
                    a(aVarA, (ae.a) this.f62701b.get(i3), foVar);
                }
                if (!this.f62701b.contains(this.f62703d)) {
                    a(aVarA, this.f62703d, foVar);
                }
            }
            this.f62702c = aVarA.a();
        }
    }

    public r0(l3 l3Var) {
        this.f62691a = (l3) b1.a(l3Var);
        this.f62696g = new gc(xp.d(), l3Var, new gc.b() { // from class: com.applovin.impl.h30
            @Override // com.applovin.impl.gc.b
            public final void a(Object obj, a9 a9Var) {
                r0.a((s0) obj, a9Var);
            }
        });
        fo.b bVar = new fo.b();
        this.f62692b = bVar;
        this.f62693c = new fo.d();
        this.f62694d = new a(bVar);
        this.f62695f = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0 s0Var, a9 a9Var) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, m5 m5Var, s0 s0Var) {
        s0Var.b(aVar, m5Var);
        s0Var.a(aVar, 1, m5Var);
    }

    private s0.a d() {
        return a(this.f62694d.b());
    }

    private s0.a e() {
        return a(this.f62694d.c());
    }

    private s0.a f(int i3, ae.a aVar) {
        b1.a(this.f62697h);
        if (aVar != null) {
            return this.f62694d.a(aVar) != null ? a(aVar) : a(fo.f59732a, i3, aVar);
        }
        fo foVarN = this.f62697h.n();
        if (i3 >= foVarN.b()) {
            foVarN = fo.f59732a;
        }
        return a(foVarN, i3, (ae.a) null);
    }

    protected final s0.a c() {
        return a(this.f62694d.a());
    }

    private s0.a a(ae.a aVar) {
        b1.a(this.f62697h);
        fo foVarA = aVar == null ? null : this.f62694d.a(aVar);
        if (aVar != null && foVarA != null) {
            return a(foVarA, foVarA.a(aVar.f64962a, this.f62692b).f59737c, aVar);
        }
        int iT = this.f62697h.t();
        fo foVarN = this.f62697h.n();
        if (iT >= foVarN.b()) {
            foVarN = fo.f59732a;
        }
        return a(foVarN, iT, (ae.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f62696g.b();
    }

    public final void h() {
        if (this.f62699j) {
            return;
        }
        final s0.a aVarC = c();
        this.f62699j = true;
        a(aVarC, -1, new gc.a() { // from class: com.applovin.impl.t10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC);
            }
        });
    }

    public void i() {
        final s0.a aVarC = c();
        this.f62695f.put(1036, aVarC);
        a(aVarC, 1036, new gc.a() { // from class: com.applovin.impl.v10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarC);
            }
        });
        ((ia) b1.b(this.f62698i)).a(new Runnable() { // from class: com.applovin.impl.w10
            @Override // java.lang.Runnable
            public final void run() {
                this.f64533a.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(s0.a aVar, m5 m5Var, s0 s0Var) {
        s0Var.a(aVar, m5Var);
        s0Var.a(aVar, 2, m5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(s0.a aVar, m5 m5Var, s0 s0Var) {
        s0Var.d(aVar, m5Var);
        s0Var.b(aVar, 2, m5Var);
    }

    @Override // com.applovin.impl.z6
    public final void d(int i3, ae.a aVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1031, new gc.a() { // from class: com.applovin.impl.g20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void c(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, 1037, new gc.a() { // from class: com.applovin.impl.a20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, String str, long j3, long j4, s0 s0Var) {
        s0Var.b(aVar, str, j3);
        s0Var.a(aVar, str, j4, j3);
        s0Var.a(aVar, 2, str, j3);
    }

    private s0.a f() {
        return a(this.f62694d.d());
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void d(final boolean z2) {
        final s0.a aVarC = c();
        a(aVarC, 7, new gc.a() { // from class: com.applovin.impl.r10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarC, z2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.applovin.impl.s0.a a(com.applovin.impl.fo r17, int r18, com.applovin.impl.ae.a r19) {
        /*
            r16 = this;
            r0 = r16
            r4 = r17
            r5 = r18
            boolean r1 = r4.c()
            if (r1 == 0) goto Lf
            r1 = 0
            r6 = r1
            goto L11
        Lf:
            r6 = r19
        L11:
            com.applovin.impl.l3 r1 = r0.f62691a
            long r2 = r1.c()
            com.applovin.impl.qh r1 = r0.f62697h
            com.applovin.impl.fo r1 = r1.n()
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L2d
            com.applovin.impl.qh r1 = r0.f62697h
            int r1 = r1.t()
            if (r5 != r1) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r6 == 0) goto L53
            boolean r7 = r6.a()
            if (r7 == 0) goto L53
            if (r1 == 0) goto L62
            com.applovin.impl.qh r1 = r0.f62697h
            int r1 = r1.E()
            int r7 = r6.f64963b
            if (r1 != r7) goto L62
            com.applovin.impl.qh r1 = r0.f62697h
            int r1 = r1.f()
            int r7 = r6.f64964c
            if (r1 != r7) goto L62
            com.applovin.impl.qh r1 = r0.f62697h
            long r7 = r1.getCurrentPosition()
            goto L6f
        L53:
            if (r1 == 0) goto L5c
            com.applovin.impl.qh r1 = r0.f62697h
            long r7 = r1.g()
            goto L6f
        L5c:
            boolean r1 = r4.c()
            if (r1 == 0) goto L65
        L62:
            r7 = 0
            goto L6f
        L65:
            com.applovin.impl.fo$d r1 = r0.f62693c
            com.applovin.impl.fo$d r1 = r4.a(r5, r1)
            long r7 = r1.b()
        L6f:
            com.applovin.impl.r0$a r1 = r0.f62694d
            com.applovin.impl.ae$a r11 = r1.a()
            com.applovin.impl.s0$a r1 = new com.applovin.impl.s0$a
            com.applovin.impl.qh r9 = r0.f62697h
            com.applovin.impl.fo r9 = r9.n()
            com.applovin.impl.qh r10 = r0.f62697h
            int r10 = r10.t()
            com.applovin.impl.qh r12 = r0.f62697h
            long r12 = r12.getCurrentPosition()
            com.applovin.impl.qh r14 = r0.f62697h
            long r14 = r14.h()
            r1.<init>(r2, r4, r5, r6, r7, r9, r10, r11, r12, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.r0.a(com.applovin.impl.fo, int, com.applovin.impl.ae$a):com.applovin.impl.s0$a");
    }

    @Override // com.applovin.impl.q1
    public final void c(final m5 m5Var) {
        final s0.a aVarE = e();
        a(aVarE, 1014, new gc.a() { // from class: com.applovin.impl.f20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarE, m5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void d(final m5 m5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1020, new gc.a() { // from class: com.applovin.impl.d20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.d(aVarF, m5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.z6
    public final void c(int i3, ae.a aVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1033, new gc.a() { // from class: com.applovin.impl.r30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, e9 e9Var, p5 p5Var, s0 s0Var) {
        s0Var.a(aVar, e9Var);
        s0Var.a(aVar, e9Var, p5Var);
        s0Var.a(aVar, 2, e9Var);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void c(final boolean z2) {
        final s0.a aVarC = c();
        a(aVarC, 3, new gc.a() { // from class: com.applovin.impl.o30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarC, z2, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void b(final String str) {
        final s0.a aVarF = f();
        a(aVarF, 1013, new gc.a() { // from class: com.applovin.impl.j20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, str);
            }
        });
    }

    @Override // com.applovin.impl.be
    public final void c(int i3, ae.a aVar, final mc mcVar, final td tdVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, AdError.NO_FILL_ERROR_CODE, new gc.a() { // from class: com.applovin.impl.a30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF, mcVar, tdVar);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void b(final e9 e9Var, final p5 p5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1010, new gc.a() { // from class: com.applovin.impl.y10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarF, e9Var, p5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void c(final int i3) {
        final s0.a aVarC = c();
        a(aVarC, 8, new gc.a() { // from class: com.applovin.impl.s20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).f(aVarC, i3);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void b(final int i3, final long j3, final long j4) {
        final s0.a aVarF = f();
        a(aVarF, 1012, new gc.a() { // from class: com.applovin.impl.x10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, i3, j3, j4);
            }
        });
    }

    @Override // com.applovin.impl.z6
    public final void b(int i3, ae.a aVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1035, new gc.a() { // from class: com.applovin.impl.i20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).g(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.be
    public final void b(int i3, ae.a aVar, final mc mcVar, final td tdVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1000, new gc.a() { // from class: com.applovin.impl.t30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, mcVar, tdVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void b(final int i3) {
        final s0.a aVarC = c();
        a(aVarC, 4, new gc.a() { // from class: com.applovin.impl.r20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarC, i3);
            }
        });
    }

    @Override // com.applovin.impl.qh.c
    public final void b(final boolean z2, final int i3) {
        final s0.a aVarC = c();
        a(aVarC, -1, new gc.a() { // from class: com.applovin.impl.w20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, z2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, String str, long j3, long j4, s0 s0Var) {
        s0Var.a(aVar, str, j3);
        s0Var.b(aVar, str, j4, j3);
        s0Var.a(aVar, 1, str, j3);
    }

    @Override // com.applovin.impl.qh.c
    public final void b() {
        final s0.a aVarC = c();
        a(aVarC, -1, new gc.a() { // from class: com.applovin.impl.k30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).e(aVarC);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void b(final boolean z2) {
        final s0.a aVarC = c();
        a(aVarC, 9, new gc.a() { // from class: com.applovin.impl.n30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, m5 m5Var, s0 s0Var) {
        s0Var.c(aVar, m5Var);
        s0Var.b(aVar, 1, m5Var);
    }

    @Override // com.applovin.impl.wq
    public final void b(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, 1038, new gc.a() { // from class: com.applovin.impl.k20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, e9 e9Var, p5 p5Var, s0 s0Var) {
        s0Var.b(aVar, e9Var);
        s0Var.b(aVar, e9Var, p5Var);
        s0Var.a(aVar, 1, e9Var);
    }

    @Override // com.applovin.impl.wq
    public final void b(final String str, final long j3, final long j4) {
        final s0.a aVarF = f();
        a(aVarF, 1021, new gc.a() { // from class: com.applovin.impl.q10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.b(aVarF, str, j4, j3, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void b(final m5 m5Var) {
        final s0.a aVarE = e();
        a(aVarE, 1025, new gc.a() { // from class: com.applovin.impl.f30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.c(aVarE, m5Var, (s0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, int i3, s0 s0Var) {
        s0Var.f(aVar);
        s0Var.b(aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, boolean z2, s0 s0Var) {
        s0Var.c(aVar, z2);
        s0Var.e(aVar, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, int i3, qh.f fVar, qh.f fVar2, s0 s0Var) {
        s0Var.a(aVar, i3);
        s0Var.a(aVar, fVar, fVar2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, xq xqVar, s0 s0Var) {
        s0Var.a(aVar, xqVar);
        s0Var.a(aVar, xqVar.f65044a, xqVar.f65045b, xqVar.f65046c, xqVar.f65047d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(qh qhVar, s0 s0Var, a9 a9Var) {
        s0Var.a(qhVar, new s0.b(a9Var, this.f62695f));
    }

    @Override // com.applovin.impl.q1
    public final void a(final String str, final long j3, final long j4) {
        final s0.a aVarF = f();
        a(aVarF, 1009, new gc.a() { // from class: com.applovin.impl.e30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarF, str, j4, j3, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final m5 m5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1008, new gc.a() { // from class: com.applovin.impl.h20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.b(aVarF, m5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final long j3) {
        final s0.a aVarF = f();
        a(aVarF, CloseCodes.UNEXPECTED_CONDITION, new gc.a() { // from class: com.applovin.impl.m20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, j3);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, 1018, new gc.a() { // from class: com.applovin.impl.c20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void a(final qh.b bVar) {
        final s0.a aVarC = c();
        a(aVarC, 13, new gc.a() { // from class: com.applovin.impl.z10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, bVar);
            }
        });
    }

    @Override // com.applovin.impl.y1.a
    public final void a(final int i3, final long j3, final long j4) {
        final s0.a aVarD = d();
        a(aVarD, CloseCodes.CLOSED_ABNORMALLY, new gc.a() { // from class: com.applovin.impl.o20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarD, i3, j3, j4);
            }
        });
    }

    @Override // com.applovin.impl.be
    public final void a(int i3, ae.a aVar, final td tdVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1004, new gc.a() { // from class: com.applovin.impl.l20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, tdVar);
            }
        });
    }

    @Override // com.applovin.impl.z6
    public final void a(int i3, ae.a aVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1034, new gc.a() { // from class: com.applovin.impl.t20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).h(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.z6
    public final void a(int i3, ae.a aVar, final int i4) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1030, new gc.a() { // from class: com.applovin.impl.x20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarF, i4, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.z6
    public final void a(int i3, ae.a aVar, final Exception exc) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1032, new gc.a() { // from class: com.applovin.impl.e20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final int i3, final long j3) {
        final s0.a aVarE = e();
        a(aVarE, 1023, new gc.a() { // from class: com.applovin.impl.z20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarE, i3, j3);
            }
        });
    }

    @Override // com.applovin.impl.be
    public final void a(int i3, ae.a aVar, final mc mcVar, final td tdVar) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1002, new gc.a() { // from class: com.applovin.impl.u10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, mcVar, tdVar);
            }
        });
    }

    @Override // com.applovin.impl.be
    public final void a(int i3, ae.a aVar, final mc mcVar, final td tdVar, final IOException iOException, final boolean z2) {
        final s0.a aVarF = f(i3, aVar);
        a(aVarF, 1003, new gc.a() { // from class: com.applovin.impl.u30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, mcVar, tdVar, iOException, z2);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final sd sdVar, final int i3) {
        final s0.a aVarC = c();
        a(aVarC, 1, new gc.a() { // from class: com.applovin.impl.b30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, sdVar, i3);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void a(final ud udVar) {
        final s0.a aVarC = c();
        a(aVarC, 14, new gc.a() { // from class: com.applovin.impl.p30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, udVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final af afVar) {
        final s0.a aVarC = c();
        a(aVarC, 1007, new gc.a() { // from class: com.applovin.impl.m30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, afVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final boolean z2, final int i3) {
        final s0.a aVarC = c();
        a(aVarC, 5, new gc.a() { // from class: com.applovin.impl.i30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarC, z2, i3);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final ph phVar) {
        final s0.a aVarC = c();
        a(aVarC, 12, new gc.a() { // from class: com.applovin.impl.d30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, phVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final int i3) {
        final s0.a aVarC = c();
        a(aVarC, 6, new gc.a() { // from class: com.applovin.impl.v20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).e(aVarC, i3);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final nh nhVar) {
        xd xdVar;
        final s0.a aVarA = (!(nhVar instanceof z7) || (xdVar = ((z7) nhVar).f65383j) == null) ? null : a(new ae.a(xdVar));
        if (aVarA == null) {
            aVarA = c();
        }
        a(aVarA, 10, new gc.a() { // from class: com.applovin.impl.q30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarA, nhVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final qh.f fVar, final qh.f fVar2, final int i3) {
        if (i3 == 1) {
            this.f62699j = false;
        }
        this.f62694d.a((qh) b1.a(this.f62697h));
        final s0.a aVarC = c();
        a(aVarC, 11, new gc.a() { // from class: com.applovin.impl.u20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarC, i3, fVar, fVar2, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final Object obj, final long j3) {
        final s0.a aVarF = f();
        a(aVarF, 1027, new gc.a() { // from class: com.applovin.impl.n20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj2) {
                ((s0) obj2).a(aVarF, obj, j3);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.q1
    public final void a(final boolean z2) {
        final s0.a aVarF = f();
        a(aVarF, 1017, new gc.a() { // from class: com.applovin.impl.b20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarF, z2);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public void a(final int i3, final int i4) {
        final s0.a aVarF = f();
        a(aVarF, 1029, new gc.a() { // from class: com.applovin.impl.l30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, i3, i4);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(fo foVar, final int i3) {
        this.f62694d.b((qh) b1.a(this.f62697h));
        final s0.a aVarC = c();
        a(aVarC, 0, new gc.a() { // from class: com.applovin.impl.s10
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarC, i3);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final po poVar, final to toVar) {
        final s0.a aVarC = c();
        a(aVarC, 2, new gc.a() { // from class: com.applovin.impl.j30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, poVar, toVar);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final String str) {
        final s0.a aVarF = f();
        a(aVarF, 1024, new gc.a() { // from class: com.applovin.impl.g30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, str);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final long j3, final int i3) {
        final s0.a aVarE = e();
        a(aVarE, 1026, new gc.a() { // from class: com.applovin.impl.s30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarE, j3, i3);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final e9 e9Var, final p5 p5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1022, new gc.a() { // from class: com.applovin.impl.y20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.b(aVarF, e9Var, p5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final xq xqVar) {
        final s0.a aVarF = f();
        a(aVarF, 1028, new gc.a() { // from class: com.applovin.impl.c30
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                r0.a(aVarF, xqVar, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final float f3) {
        final s0.a aVarF = f();
        a(aVarF, 1019, new gc.a() { // from class: com.applovin.impl.q20
            @Override // com.applovin.impl.gc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, f3);
            }
        });
    }

    protected final void a(s0.a aVar, int i3, gc.a aVar2) {
        this.f62695f.put(i3, aVar);
        this.f62696g.b(i3, aVar2);
    }

    public void a(final qh qhVar, Looper looper) {
        b1.b(this.f62697h == null || this.f62694d.f62701b.isEmpty());
        this.f62697h = (qh) b1.a(qhVar);
        this.f62698i = this.f62691a.a(looper, null);
        this.f62696g = this.f62696g.a(looper, new gc.b() { // from class: com.applovin.impl.p20
            @Override // com.applovin.impl.gc.b
            public final void a(Object obj, a9 a9Var) {
                this.f62406a.a(qhVar, (s0) obj, a9Var);
            }
        });
    }

    public final void a(List list, ae.a aVar) {
        this.f62694d.a(list, aVar, (qh) b1.a(this.f62697h));
    }
}
