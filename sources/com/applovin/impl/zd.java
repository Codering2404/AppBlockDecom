package com.applovin.impl;

import android.os.Handler;
import android.util.Pair;
import com.applovin.impl.ae;
import com.applovin.impl.db;
import com.applovin.impl.fo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fo.b f65415a = new fo.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fo.d f65416b = new fo.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0 f65417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f65418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f65419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f65421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private wd f65422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private wd f65423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private wd f65424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f65425k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f65426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f65427m;

    public zd(r0 r0Var, Handler handler) {
        this.f65417c = r0Var;
        this.f65418d = handler;
    }

    private void g() {
        if (this.f65417c != null) {
            final db.a aVarF = db.f();
            for (wd wdVarD = this.f65422h; wdVarD != null; wdVarD = wdVarD.d()) {
                aVarF.b(wdVarD.f64646f.f65182a);
            }
            wd wdVar = this.f65423i;
            final ae.a aVar = wdVar == null ? null : wdVar.f64646f.f65182a;
            this.f65418d.post(new Runnable() { // from class: com.applovin.impl.l90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61172a.a(aVarF, aVar);
                }
            });
        }
    }

    public wd b() {
        wd wdVar = this.f65423i;
        b1.b((wdVar == null || wdVar.d() == null) ? false : true);
        this.f65423i = this.f65423i.d();
        g();
        return this.f65423i;
    }

    public void c() {
        if (this.f65425k == 0) {
            return;
        }
        wd wdVarD = (wd) b1.b(this.f65422h);
        this.f65426l = wdVarD.f64642b;
        this.f65427m = wdVarD.f64646f.f65182a.f64965d;
        while (wdVarD != null) {
            wdVarD.l();
            wdVarD = wdVarD.d();
        }
        this.f65422h = null;
        this.f65424j = null;
        this.f65423i = null;
        this.f65425k = 0;
        g();
    }

    public wd d() {
        return this.f65424j;
    }

    public wd e() {
        return this.f65422h;
    }

    public wd f() {
        return this.f65423i;
    }

    public boolean h() {
        wd wdVar = this.f65424j;
        if (wdVar != null) {
            return !wdVar.f64646f.f65190i && wdVar.j() && this.f65424j.f64646f.f65186e != -9223372036854775807L && this.f65425k < 100;
        }
        return true;
    }

    private boolean a(long j3, long j4) {
        return j3 == -9223372036854775807L || j3 == j4;
    }

    public wd a() {
        wd wdVar = this.f65422h;
        if (wdVar == null) {
            return null;
        }
        if (wdVar == this.f65423i) {
            this.f65423i = wdVar.d();
        }
        this.f65422h.l();
        int i3 = this.f65425k - 1;
        this.f65425k = i3;
        if (i3 == 0) {
            this.f65424j = null;
            wd wdVar2 = this.f65422h;
            this.f65426l = wdVar2.f64642b;
            this.f65427m = wdVar2.f64646f.f65182a.f64965d;
        }
        this.f65422h = this.f65422h.d();
        g();
        return this.f65422h;
    }

    private boolean a(yd ydVar, yd ydVar2) {
        return ydVar.f65183b == ydVar2.f65183b && ydVar.f65182a.equals(ydVar2.f65182a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.applovin.impl.wd a(com.applovin.impl.ri[] r10, com.applovin.impl.vo r11, com.applovin.impl.n0 r12, com.applovin.impl.ee r13, com.applovin.impl.yd r14, com.applovin.impl.wo r15) {
        /*
            r9 = this;
            com.applovin.impl.wd r0 = r9.f65424j
            if (r0 != 0) goto L1c
            com.applovin.impl.ae$a r0 = r14.f65182a
            boolean r0 = r0.a()
            if (r0 == 0) goto L19
            long r0 = r14.f65184c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L19
        L17:
            r2 = r0
            goto L2b
        L19:
            r0 = 0
            goto L17
        L1c:
            long r0 = r0.f()
            com.applovin.impl.wd r2 = r9.f65424j
            com.applovin.impl.yd r2 = r2.f64646f
            long r2 = r2.f65186e
            long r0 = r0 + r2
            long r2 = r14.f65183b
            long r0 = r0 - r2
            goto L17
        L2b:
            com.applovin.impl.wd r0 = new com.applovin.impl.wd
            r1 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            com.applovin.impl.wd r1 = r9.f65424j
            if (r1 == 0) goto L3e
            r1.a(r0)
            goto L42
        L3e:
            r9.f65422h = r0
            r9.f65423i = r0
        L42:
            r1 = 0
            r9.f65426l = r1
            r9.f65424j = r0
            int r1 = r9.f65425k
            int r1 = r1 + 1
            r9.f65425k = r1
            r9.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.zd.a(com.applovin.impl.ri[], com.applovin.impl.vo, com.applovin.impl.n0, com.applovin.impl.ee, com.applovin.impl.yd, com.applovin.impl.wo):com.applovin.impl.wd");
    }

    private yd a(oh ohVar) {
        return a(ohVar.f62300a, ohVar.f62301b, ohVar.f62302c, ohVar.f62318s);
    }

    private yd a(fo foVar, wd wdVar, long j3) {
        zd zdVar;
        fo foVar2;
        Object obj;
        long j4;
        long j5;
        yd ydVar = wdVar.f64646f;
        long jF = (wdVar.f() + ydVar.f65186e) - j3;
        long j6 = -9223372036854775807L;
        if (ydVar.f65188g) {
            int iA = foVar.a(foVar.a(ydVar.f65182a.f64962a), this.f65415a, this.f65416b, this.f65420f, this.f65421g);
            if (iA == -1) {
                return null;
            }
            int i3 = foVar.a(iA, this.f65415a, true).f59737c;
            Object obj2 = this.f65415a.f59736b;
            long j7 = ydVar.f65182a.f64965d;
            if (foVar.a(i3, this.f65416b).f59764p == iA) {
                Pair pairA = foVar.a(this.f65416b, this.f65415a, i3, -9223372036854775807L, Math.max(0L, jF));
                if (pairA == null) {
                    return null;
                }
                Object obj3 = pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                wd wdVarD = wdVar.d();
                if (wdVarD != null && wdVarD.f64642b.equals(obj3)) {
                    j5 = wdVarD.f64646f.f65182a.f64965d;
                } else {
                    j5 = this.f65419e;
                    this.f65419e = 1 + j5;
                }
                j7 = j5;
                obj = obj3;
                j4 = jLongValue;
            } else {
                obj = obj2;
                j4 = 0;
                j6 = 0;
            }
            return a(foVar, a(foVar, obj, j4, j7, this.f65415a), j6, j4);
        }
        ae.a aVar = ydVar.f65182a;
        foVar.a(aVar.f64962a, this.f65415a);
        if (aVar.a()) {
            int i4 = aVar.f64963b;
            int iA2 = this.f65415a.a(i4);
            if (iA2 == -1) {
                return null;
            }
            int iB = this.f65415a.b(i4, aVar.f64964c);
            if (iB < iA2) {
                return a(foVar, aVar.f64962a, i4, iB, ydVar.f65184c, aVar.f64965d);
            }
            long jLongValue2 = ydVar.f65184c;
            if (jLongValue2 == -9223372036854775807L) {
                fo.d dVar = this.f65416b;
                fo.b bVar = this.f65415a;
                int i5 = bVar.f59737c;
                long jMax = Math.max(0L, jF);
                zdVar = this;
                foVar2 = foVar;
                Pair pairA2 = foVar2.a(dVar, bVar, i5, -9223372036854775807L, jMax);
                if (pairA2 == null) {
                    return null;
                }
                jLongValue2 = ((Long) pairA2.second).longValue();
            } else {
                zdVar = this;
                foVar2 = foVar;
            }
            return zdVar.a(foVar2, aVar.f64962a, Math.max(zdVar.a(foVar2, aVar.f64962a, aVar.f64963b), jLongValue2), ydVar.f65184c, aVar.f64965d);
        }
        int iD = this.f65415a.d(aVar.f64966e);
        if (iD == this.f65415a.a(aVar.f64966e)) {
            return a(foVar, aVar.f64962a, a(foVar, aVar.f64962a, aVar.f64966e), ydVar.f65186e, aVar.f64965d);
        }
        return a(foVar, aVar.f64962a, aVar.f64966e, iD, ydVar.f65186e, aVar.f64965d);
    }

    private yd a(fo foVar, ae.a aVar, long j3, long j4) {
        foVar.a(aVar.f64962a, this.f65415a);
        if (aVar.a()) {
            return a(foVar, aVar.f64962a, aVar.f64963b, aVar.f64964c, j3, aVar.f64965d);
        }
        return a(foVar, aVar.f64962a, j4, j3, aVar.f64965d);
    }

    private yd a(fo foVar, Object obj, int i3, int i4, long j3, long j4) {
        ae.a aVar = new ae.a(obj, i3, i4, j4);
        long jA = foVar.a(aVar.f64962a, this.f65415a).a(aVar.f64963b, aVar.f64964c);
        long jB = i4 == this.f65415a.d(i3) ? this.f65415a.b() : 0L;
        boolean zF = this.f65415a.f(aVar.f64963b);
        if (jA != -9223372036854775807L && jB >= jA) {
            jB = Math.max(0L, jA - 1);
        }
        return new yd(aVar, jB, j3, -9223372036854775807L, jA, zF, false, false, false);
    }

    private yd a(fo foVar, Object obj, long j3, long j4, long j5) {
        long jMax = j3;
        foVar.a(obj, this.f65415a);
        int iA = this.f65415a.a(jMax);
        ae.a aVar = new ae.a(obj, j5, iA);
        boolean zA = a(aVar);
        boolean zA2 = a(foVar, aVar);
        boolean zA3 = a(foVar, aVar, zA);
        boolean z2 = iA != -1 && this.f65415a.f(iA);
        long jB = iA != -1 ? this.f65415a.b(iA) : -9223372036854775807L;
        long j6 = (jB == -9223372036854775807L || jB == Long.MIN_VALUE) ? this.f65415a.f59738d : jB;
        if (j6 != -9223372036854775807L && jMax >= j6) {
            jMax = Math.max(0L, j6 - 1);
        }
        return new yd(aVar, jMax, j4, jB, j6, z2, zA, zA2, zA3);
    }

    private long a(fo foVar, Object obj, int i3) {
        foVar.a(obj, this.f65415a);
        long jB = this.f65415a.b(i3);
        if (jB == Long.MIN_VALUE) {
            return this.f65415a.f59738d;
        }
        return jB + this.f65415a.c(i3);
    }

    public yd a(long j3, oh ohVar) {
        wd wdVar = this.f65424j;
        if (wdVar == null) {
            return a(ohVar);
        }
        return a(ohVar.f62300a, wdVar, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.applovin.impl.yd a(com.applovin.impl.fo r16, com.applovin.impl.yd r17) {
        /*
            r15 = this;
            r1 = r16
            r2 = r17
            com.applovin.impl.ae$a r3 = r2.f65182a
            boolean r12 = r15.a(r3)
            boolean r13 = r15.a(r1, r3)
            boolean r14 = r15.a(r1, r3, r12)
            com.applovin.impl.ae$a r4 = r2.f65182a
            java.lang.Object r4 = r4.f64962a
            com.applovin.impl.fo$b r5 = r15.f65415a
            r1.a(r4, r5)
            boolean r1 = r3.a()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L33
            int r1 = r3.f64966e
            if (r1 != r6) goto L2c
            goto L33
        L2c:
            com.applovin.impl.fo$b r7 = r15.f65415a
            long r7 = r7.b(r1)
            goto L34
        L33:
            r7 = r4
        L34:
            boolean r1 = r3.a()
            if (r1 == 0) goto L46
            com.applovin.impl.fo$b r1 = r15.f65415a
            int r4 = r3.f64963b
            int r5 = r3.f64964c
            long r4 = r1.a(r4, r5)
        L44:
            r9 = r4
            goto L5a
        L46:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L53
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L51
            goto L53
        L51:
            r9 = r7
            goto L5a
        L53:
            com.applovin.impl.fo$b r1 = r15.f65415a
            long r4 = r1.c()
            goto L44
        L5a:
            boolean r1 = r3.a()
            if (r1 == 0) goto L6a
            com.applovin.impl.fo$b r1 = r15.f65415a
            int r4 = r3.f64963b
            boolean r1 = r1.f(r4)
        L68:
            r11 = r1
            goto L7a
        L6a:
            int r1 = r3.f64966e
            if (r1 == r6) goto L78
            com.applovin.impl.fo$b r4 = r15.f65415a
            boolean r1 = r4.f(r1)
            if (r1 == 0) goto L78
            r1 = 1
            goto L68
        L78:
            r1 = 0
            goto L68
        L7a:
            com.applovin.impl.yd r1 = new com.applovin.impl.yd
            r5 = r3
            long r3 = r2.f65183b
            r16 = r1
            long r0 = r2.f65184c
            r2 = r5
            r5 = r0
            r1 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.zd.a(com.applovin.impl.fo, com.applovin.impl.yd):com.applovin.impl.yd");
    }

    private boolean a(ae.a aVar) {
        return !aVar.a() && aVar.f64966e == -1;
    }

    private boolean a(fo foVar, ae.a aVar, boolean z2) {
        int iA = foVar.a(aVar.f64962a);
        return !foVar.a(foVar.a(iA, this.f65415a).f59737c, this.f65416b).f59758j && foVar.b(iA, this.f65415a, this.f65416b, this.f65420f, this.f65421g) && z2;
    }

    private boolean a(fo foVar, ae.a aVar) {
        if (a(aVar)) {
            return foVar.a(foVar.a(aVar.f64962a, this.f65415a).f59737c, this.f65416b).f59765q == foVar.a(aVar.f64962a);
        }
        return false;
    }

    public boolean a(vd vdVar) {
        wd wdVar = this.f65424j;
        return wdVar != null && wdVar.f64641a == vdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(db.a aVar, ae.a aVar2) {
        this.f65417c.a(aVar.a(), aVar2);
    }

    public void a(long j3) {
        wd wdVar = this.f65424j;
        if (wdVar != null) {
            wdVar.b(j3);
        }
    }

    public boolean a(wd wdVar) {
        boolean z2 = false;
        b1.b(wdVar != null);
        if (wdVar.equals(this.f65424j)) {
            return false;
        }
        this.f65424j = wdVar;
        while (wdVar.d() != null) {
            wdVar = wdVar.d();
            if (wdVar == this.f65423i) {
                this.f65423i = this.f65422h;
                z2 = true;
            }
            wdVar.l();
            this.f65425k--;
        }
        this.f65424j.a((wd) null);
        g();
        return z2;
    }

    public ae.a a(fo foVar, Object obj, long j3) {
        return a(foVar, obj, j3, a(foVar, obj), this.f65415a);
    }

    private static ae.a a(fo foVar, Object obj, long j3, long j4, fo.b bVar) {
        foVar.a(obj, bVar);
        int iB = bVar.b(j3);
        if (iB == -1) {
            return new ae.a(obj, j4, bVar.a(j3));
        }
        return new ae.a(obj, iB, bVar.d(iB), j4);
    }

    private long a(fo foVar, Object obj) {
        int iA;
        int i3 = foVar.a(obj, this.f65415a).f59737c;
        Object obj2 = this.f65426l;
        if (obj2 != null && (iA = foVar.a(obj2)) != -1 && foVar.a(iA, this.f65415a).f59737c == i3) {
            return this.f65427m;
        }
        for (wd wdVarD = this.f65422h; wdVarD != null; wdVarD = wdVarD.d()) {
            if (wdVarD.f64642b.equals(obj)) {
                return wdVarD.f64646f.f65182a.f64965d;
            }
        }
        for (wd wdVarD2 = this.f65422h; wdVarD2 != null; wdVarD2 = wdVarD2.d()) {
            int iA2 = foVar.a(wdVarD2.f64642b);
            if (iA2 != -1 && foVar.a(iA2, this.f65415a).f59737c == i3) {
                return wdVarD2.f64646f.f65182a.f64965d;
            }
        }
        long j3 = this.f65419e;
        this.f65419e = 1 + j3;
        if (this.f65422h == null) {
            this.f65426l = obj;
            this.f65427m = j3;
        }
        return j3;
    }

    private boolean a(fo foVar) {
        fo foVar2;
        wd wdVarD = this.f65422h;
        if (wdVarD == null) {
            return true;
        }
        int iA = foVar.a(wdVarD.f64642b);
        while (true) {
            foVar2 = foVar;
            iA = foVar2.a(iA, this.f65415a, this.f65416b, this.f65420f, this.f65421g);
            while (wdVarD.d() != null && !wdVarD.f64646f.f65188g) {
                wdVarD = wdVarD.d();
            }
            wd wdVarD2 = wdVarD.d();
            if (iA == -1 || wdVarD2 == null || foVar2.a(wdVarD2.f64642b) != iA) {
                break;
            }
            wdVarD = wdVarD2;
            foVar = foVar2;
        }
        boolean zA = a(wdVarD);
        wdVarD.f64646f = a(foVar2, wdVarD.f64646f);
        return !zA;
    }

    public boolean a(fo foVar, long j3, long j4) {
        boolean zA;
        yd ydVarA;
        wd wdVarD = this.f65422h;
        wd wdVar = null;
        while (wdVarD != null) {
            yd ydVar = wdVarD.f64646f;
            if (wdVar == null) {
                ydVarA = a(foVar, ydVar);
            } else {
                yd ydVarA2 = a(foVar, wdVar, j3);
                if (ydVarA2 == null) {
                    zA = a(wdVar);
                } else if (a(ydVar, ydVarA2)) {
                    ydVarA = ydVarA2;
                } else {
                    zA = a(wdVar);
                }
                return !zA;
            }
            wdVarD.f64646f = ydVarA.a(ydVar.f65184c);
            if (!a(ydVar.f65186e, ydVarA.f65186e)) {
                wdVarD.m();
                long j5 = ydVarA.f65186e;
                return (a(wdVarD) || (wdVarD == this.f65423i && !wdVarD.f64646f.f65187f && ((j4 > Long.MIN_VALUE ? 1 : (j4 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j4 > ((j5 > (-9223372036854775807L) ? 1 : (j5 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : wdVarD.e(j5)) ? 1 : (j4 == ((j5 > (-9223372036854775807L) ? 1 : (j5 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : wdVarD.e(j5)) ? 0 : -1)) >= 0))) ? false : true;
            }
            wdVar = wdVarD;
            wdVarD = wdVarD.d();
        }
        return true;
    }

    public boolean a(fo foVar, int i3) {
        this.f65420f = i3;
        return a(foVar);
    }

    public boolean a(fo foVar, boolean z2) {
        this.f65421g = z2;
        return a(foVar);
    }
}
