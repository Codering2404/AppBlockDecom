package com.applovin.impl;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.applovin.impl.dp;
import com.applovin.impl.ij;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class cp implements j8 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final n8 f58990t = new n8() { // from class: com.applovin.impl.mu
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return cp.c();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f58991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f58992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f58993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ah f58994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseIntArray f58995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final dp.c f58996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray f58997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseBooleanArray f58998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseBooleanArray f58999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final bp f59000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ap f59001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private l8 f59002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f59003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f59004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f59005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f59006p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private dp f59007q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f59008r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f59009s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class a implements gj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zg f59010a = new zg(new byte[4]);

        public a() {
        }

        @Override // com.applovin.impl.gj
        public void a(ho hoVar, l8 l8Var, dp.d dVar) {
        }

        @Override // com.applovin.impl.gj
        public void a(ah ahVar) {
            if (ahVar.w() == 0 && (ahVar.w() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                ahVar.g(6);
                int iA = ahVar.a() / 4;
                for (int i3 = 0; i3 < iA; i3++) {
                    ahVar.a(this.f59010a, 4);
                    int iA2 = this.f59010a.a(16);
                    this.f59010a.d(3);
                    if (iA2 == 0) {
                        this.f59010a.d(13);
                    } else {
                        int iA3 = this.f59010a.a(13);
                        if (cp.this.f58997g.get(iA3) == null) {
                            cp.this.f58997g.put(iA3, new hj(cp.this.new b(iA3)));
                            cp.d(cp.this);
                        }
                    }
                }
                if (cp.this.f58991a != 2) {
                    cp.this.f58997g.remove(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b implements gj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zg f59012a = new zg(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f59013b = new SparseArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SparseIntArray f59014c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f59015d;

        public b(int i3) {
            this.f59015d = i3;
        }

        @Override // com.applovin.impl.gj
        public void a(ho hoVar, l8 l8Var, dp.d dVar) {
        }

        @Override // com.applovin.impl.gj
        public void a(ah ahVar) {
            ho hoVar;
            if (ahVar.w() != 2) {
                return;
            }
            if (cp.this.f58991a == 1 || cp.this.f58991a == 2 || cp.this.f59003m == 1) {
                hoVar = (ho) cp.this.f58993c.get(0);
            } else {
                hoVar = new ho(((ho) cp.this.f58993c.get(0)).a());
                cp.this.f58993c.add(hoVar);
            }
            if ((ahVar.w() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return;
            }
            ahVar.g(1);
            int iC = ahVar.C();
            int i3 = 3;
            ahVar.g(3);
            ahVar.a(this.f59012a, 2);
            this.f59012a.d(3);
            int i4 = 13;
            cp.this.f59009s = this.f59012a.a(13);
            ahVar.a(this.f59012a, 2);
            int i5 = 4;
            this.f59012a.d(4);
            ahVar.g(this.f59012a.a(12));
            if (cp.this.f58991a == 2 && cp.this.f59007q == null) {
                dp.b bVar = new dp.b(21, null, null, xp.f65032f);
                cp cpVar = cp.this;
                cpVar.f59007q = cpVar.f58996f.a(21, bVar);
                if (cp.this.f59007q != null) {
                    cp.this.f59007q.a(hoVar, cp.this.f59002l, new dp.d(iC, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                }
            }
            this.f59013b.clear();
            this.f59014c.clear();
            int iA = ahVar.a();
            while (iA > 0) {
                ahVar.a(this.f59012a, 5);
                int iA2 = this.f59012a.a(8);
                this.f59012a.d(i3);
                int iA3 = this.f59012a.a(i4);
                this.f59012a.d(i5);
                int iA4 = this.f59012a.a(12);
                dp.b bVarA = a(ahVar, iA4);
                if (iA2 == 6 || iA2 == 5) {
                    iA2 = bVarA.f59281a;
                }
                iA -= iA4 + 5;
                int i6 = cp.this.f58991a == 2 ? iA2 : iA3;
                if (!cp.this.f58998h.get(i6)) {
                    dp dpVarA = (cp.this.f58991a == 2 && iA2 == 21) ? cp.this.f59007q : cp.this.f58996f.a(iA2, bVarA);
                    if (cp.this.f58991a != 2 || iA3 < this.f59014c.get(i6, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                        this.f59014c.put(i6, iA3);
                        this.f59013b.put(i6, dpVarA);
                    }
                }
                i3 = 3;
                i5 = 4;
                i4 = 13;
            }
            int size = this.f59014c.size();
            for (int i7 = 0; i7 < size; i7++) {
                int iKeyAt = this.f59014c.keyAt(i7);
                int iValueAt = this.f59014c.valueAt(i7);
                cp.this.f58998h.put(iKeyAt, true);
                cp.this.f58999i.put(iValueAt, true);
                dp dpVar = (dp) this.f59013b.valueAt(i7);
                if (dpVar != null) {
                    if (dpVar != cp.this.f59007q) {
                        dpVar.a(hoVar, cp.this.f59002l, new dp.d(iC, iKeyAt, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    }
                    cp.this.f58997g.put(iValueAt, dpVar);
                }
            }
            if (cp.this.f58991a == 2) {
                if (cp.this.f59004n) {
                    return;
                }
                cp.this.f59002l.c();
                cp.this.f59003m = 0;
                cp.this.f59004n = true;
                return;
            }
            cp.this.f58997g.remove(this.f59015d);
            cp cpVar2 = cp.this;
            cpVar2.f59003m = cpVar2.f58991a == 1 ? 0 : cp.this.f59003m - 1;
            if (cp.this.f59003m == 0) {
                cp.this.f59002l.c();
                cp.this.f59004n = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.applovin.impl.dp.b a(com.applovin.impl.ah r12, int r13) {
            /*
                Method dump skipped, instruction units count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.cp.b.a(com.applovin.impl.ah, int):com.applovin.impl.dp$b");
        }
    }

    public cp() {
        this(0);
    }

    static /* synthetic */ int d(cp cpVar) {
        int i3 = cpVar.f59003m;
        cpVar.f59003m = i3 + 1;
        return i3;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public cp(int i3) {
        this(1, i3, 112800);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] c() {
        return new j8[]{new cp()};
    }

    private void d() {
        this.f58998h.clear();
        this.f58997g.clear();
        SparseArray sparseArrayA = this.f58996f.a();
        int size = sparseArrayA.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f58997g.put(sparseArrayA.keyAt(i3), (dp) sparseArrayA.valueAt(i3));
        }
        this.f58997g.put(0, new hj(new a()));
        this.f59007q = null;
    }

    public cp(int i3, int i4, int i5) {
        this(i3, new ho(0L), new m6(i4), i5);
    }

    private boolean b(k8 k8Var) {
        byte[] bArrC = this.f58994d.c();
        if (9400 - this.f58994d.d() < 188) {
            int iA = this.f58994d.a();
            if (iA > 0) {
                System.arraycopy(bArrC, this.f58994d.d(), bArrC, 0, iA);
            }
            this.f58994d.a(bArrC, iA);
        }
        while (this.f58994d.a() < 188) {
            int iE = this.f58994d.e();
            int iA2 = k8Var.a(bArrC, iE, 9400 - iE);
            if (iA2 == -1) {
                return false;
            }
            this.f58994d.e(iE + iA2);
        }
        return true;
    }

    public cp(int i3, ho hoVar, dp.c cVar, int i4) {
        this.f58996f = (dp.c) b1.a(cVar);
        this.f58992b = i4;
        this.f58991a = i3;
        if (i3 != 1 && i3 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f58993c = arrayList;
            arrayList.add(hoVar);
        } else {
            this.f58993c = Collections.singletonList(hoVar);
        }
        this.f58994d = new ah(new byte[9400], 0);
        this.f58998h = new SparseBooleanArray();
        this.f58999i = new SparseBooleanArray();
        this.f58997g = new SparseArray();
        this.f58995e = new SparseIntArray();
        this.f59000j = new bp(i4);
        this.f59002l = l8.f61166e;
        this.f59009s = -1;
        d();
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f59002l = l8Var;
    }

    private void a(long j3) {
        if (this.f59005o) {
            return;
        }
        this.f59005o = true;
        if (this.f59000j.a() != -9223372036854775807L) {
            ap apVar = new ap(this.f59000j.b(), this.f59000j.a(), j3, this.f59009s, this.f58992b);
            this.f59001k = apVar;
            this.f59002l.a(apVar.a());
            return;
        }
        this.f59002l.a(new ij.b(this.f59000j.a()));
    }

    private int b() throws ch {
        int iD = this.f58994d.d();
        int iE = this.f58994d.e();
        int iA = ep.a(this.f58994d.c(), iD, iE);
        this.f58994d.f(iA);
        int i3 = iA + 188;
        if (i3 > iE) {
            int i4 = this.f59008r + (iA - iD);
            this.f59008r = i4;
            if (this.f58991a != 2 || i4 <= 376) {
                return i3;
            }
            throw ch.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
        }
        this.f59008r = 0;
        return i3;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        long j3;
        long jA = k8Var.a();
        if (this.f59004n) {
            if (jA != -1 && this.f58991a != 2 && !this.f59000j.c()) {
                return this.f59000j.a(k8Var, thVar, this.f59009s);
            }
            a(jA);
            if (this.f59006p) {
                this.f59006p = false;
                a(0L, 0L);
                if (k8Var.f() != 0) {
                    thVar.f63943a = 0L;
                    return 1;
                }
            }
            ap apVar = this.f59001k;
            if (apVar != null && apVar.b()) {
                return this.f59001k.a(k8Var, thVar);
            }
        }
        if (!b(k8Var)) {
            return -1;
        }
        int iB = b();
        int iE = this.f58994d.e();
        if (iB > iE) {
            return 0;
        }
        int iJ = this.f58994d.j();
        if ((8388608 & iJ) != 0) {
            this.f58994d.f(iB);
            return 0;
        }
        int i3 = (4194304 & iJ) != 0 ? 1 : 0;
        int i4 = (2096896 & iJ) >> 8;
        boolean z2 = (iJ & 32) != 0;
        dp dpVar = (iJ & 16) != 0 ? (dp) this.f58997g.get(i4) : null;
        if (dpVar == null) {
            this.f58994d.f(iB);
            return 0;
        }
        if (this.f58991a != 2) {
            int i5 = iJ & 15;
            j3 = -1;
            int i6 = this.f58995e.get(i4, i5 - 1);
            this.f58995e.put(i4, i5);
            if (i6 == i5) {
                this.f58994d.f(iB);
                return 0;
            }
            if (i5 != ((i6 + 1) & 15)) {
                dpVar.a();
            }
        } else {
            j3 = -1;
        }
        if (z2) {
            int iW = this.f58994d.w();
            i3 |= (this.f58994d.w() & 64) != 0 ? 2 : 0;
            this.f58994d.g(iW - 1);
        }
        boolean z3 = this.f59004n;
        if (a(i4)) {
            this.f58994d.e(iB);
            dpVar.a(this.f58994d, i3);
            this.f58994d.e(iE);
        }
        if (this.f58991a != 2 && !z3 && this.f59004n && jA != j3) {
            this.f59006p = true;
        }
        this.f58994d.f(iB);
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    @Override // com.applovin.impl.j8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r10, long r12) {
        /*
            r9 = this;
            int r10 = r9.f58991a
            r11 = 2
            r0 = 1
            r1 = 0
            if (r10 == r11) goto L9
            r10 = r0
            goto La
        L9:
            r10 = r1
        La:
            com.applovin.impl.b1.b(r10)
            java.util.List r10 = r9.f58993c
            int r10 = r10.size()
            r11 = r1
        L14:
            r2 = 0
            if (r11 >= r10) goto L4b
            java.util.List r4 = r9.f58993c
            java.lang.Object r4 = r4.get(r11)
            com.applovin.impl.ho r4 = (com.applovin.impl.ho) r4
            long r5 = r4.c()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L2f
            r5 = r0
            goto L30
        L2f:
            r5 = r1
        L30:
            if (r5 != 0) goto L43
            long r5 = r4.a()
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L48
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L48
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 == 0) goto L48
            goto L45
        L43:
            if (r5 == 0) goto L48
        L45:
            r4.d(r12)
        L48:
            int r11 = r11 + 1
            goto L14
        L4b:
            int r10 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r10 == 0) goto L56
            com.applovin.impl.ap r10 = r9.f59001k
            if (r10 == 0) goto L56
            r10.b(r12)
        L56:
            com.applovin.impl.ah r10 = r9.f58994d
            r10.d(r1)
            android.util.SparseIntArray r10 = r9.f58995e
            r10.clear()
            r10 = r1
        L61:
            android.util.SparseArray r11 = r9.f58997g
            int r11 = r11.size()
            if (r10 >= r11) goto L77
            android.util.SparseArray r11 = r9.f58997g
            java.lang.Object r11 = r11.valueAt(r10)
            com.applovin.impl.dp r11 = (com.applovin.impl.dp) r11
            r11.a()
            int r10 = r10 + 1
            goto L61
        L77:
            r9.f59008r = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.cp.a(long, long):void");
    }

    private boolean a(int i3) {
        return this.f58991a == 2 || this.f59004n || !this.f58999i.get(i3, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.applovin.impl.j8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.applovin.impl.k8 r7) {
        /*
            r6 = this;
            com.applovin.impl.ah r0 = r6.f58994d
            byte[] r0 = r0.c()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.c(r0, r2, r1)
            r1 = r2
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = r2
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.a(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.cp.a(com.applovin.impl.k8):boolean");
    }
}
