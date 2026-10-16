package com.applovin.impl;

import android.util.SparseArray;
import com.applovin.impl.dp;
import com.applovin.impl.ij;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ii implements j8 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n8 f60469l = new n8() { // from class: com.applovin.impl.cy
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return ii.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho f60470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f60471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f60472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final hi f60473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f60475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f60476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f60477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private gi f60478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l8 f60479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f60480k;

    public ii() {
        this(new ho(0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new ii()};
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public ii(ho hoVar) {
        this.f60470a = hoVar;
        this.f60472c = new ah(4096);
        this.f60471b = new SparseArray();
        this.f60473d = new hi();
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f60479j = l8Var;
    }

    private void a(long j3) {
        if (this.f60480k) {
            return;
        }
        this.f60480k = true;
        if (this.f60473d.a() != -9223372036854775807L) {
            gi giVar = new gi(this.f60473d.b(), this.f60473d.a(), j3);
            this.f60478i = giVar;
            this.f60479j.a(giVar.a());
            return;
        }
        this.f60479j.a(new ij.b(this.f60473d.a()));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p7 f60481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ho f60482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final zg f60483c = new zg(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f60484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f60485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f60486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f60487g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f60488h;

        public a(p7 p7Var, ho hoVar) {
            this.f60481a = p7Var;
            this.f60482b = hoVar;
        }

        private void b() {
            this.f60488h = 0L;
            if (this.f60484d) {
                this.f60483c.d(4);
                long jA = ((long) this.f60483c.a(3)) << 30;
                this.f60483c.d(1);
                long jA2 = jA | ((long) (this.f60483c.a(15) << 15));
                this.f60483c.d(1);
                long jA3 = jA2 | ((long) this.f60483c.a(15));
                this.f60483c.d(1);
                if (!this.f60486f && this.f60485e) {
                    this.f60483c.d(4);
                    long jA4 = ((long) this.f60483c.a(3)) << 30;
                    this.f60483c.d(1);
                    long jA5 = jA4 | ((long) (this.f60483c.a(15) << 15));
                    this.f60483c.d(1);
                    long jA6 = jA5 | ((long) this.f60483c.a(15));
                    this.f60483c.d(1);
                    this.f60482b.b(jA6);
                    this.f60486f = true;
                }
                this.f60488h = this.f60482b.b(jA3);
            }
        }

        public void a(ah ahVar) {
            ahVar.a(this.f60483c.f65436a, 0, 3);
            this.f60483c.c(0);
            a();
            ahVar.a(this.f60483c.f65436a, 0, this.f60487g);
            this.f60483c.c(0);
            b();
            this.f60481a.a(this.f60488h, 4);
            this.f60481a.a(ahVar);
            this.f60481a.b();
        }

        public void c() {
            this.f60486f = false;
            this.f60481a.a();
        }

        private void a() {
            this.f60483c.d(8);
            this.f60484d = this.f60483c.f();
            this.f60485e = this.f60483c.f();
            this.f60483c.d(6);
            this.f60487g = this.f60483c.a(8);
        }
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        p7 eaVar;
        b1.b(this.f60479j);
        long jA = k8Var.a();
        if (jA != -1 && !this.f60473d.c()) {
            return this.f60473d.a(k8Var, thVar);
        }
        a(jA);
        gi giVar = this.f60478i;
        if (giVar != null && giVar.b()) {
            return this.f60478i.a(k8Var, thVar);
        }
        k8Var.b();
        long jD = jA != -1 ? jA - k8Var.d() : -1L;
        if ((jD != -1 && jD < 4) || !k8Var.b(this.f60472c.c(), 0, 4, true)) {
            return -1;
        }
        this.f60472c.f(0);
        int iJ = this.f60472c.j();
        if (iJ == 441) {
            return -1;
        }
        if (iJ == 442) {
            k8Var.c(this.f60472c.c(), 0, 10);
            this.f60472c.f(9);
            k8Var.a((this.f60472c.w() & 7) + 14);
            return 0;
        }
        if (iJ == 443) {
            k8Var.c(this.f60472c.c(), 0, 2);
            this.f60472c.f(0);
            k8Var.a(this.f60472c.C() + 6);
            return 0;
        }
        if (((iJ & (-256)) >> 8) != 1) {
            k8Var.a(1);
            return 0;
        }
        int i3 = iJ & 255;
        a aVar = (a) this.f60471b.get(i3);
        if (!this.f60474e) {
            if (aVar == null) {
                if (i3 == 189) {
                    eaVar = new j();
                    this.f60475f = true;
                    this.f60477h = k8Var.f();
                } else if ((iJ & 224) == 192) {
                    eaVar = new rf();
                    this.f60475f = true;
                    this.f60477h = k8Var.f();
                } else if ((iJ & 240) == 224) {
                    eaVar = new ea();
                    this.f60476g = true;
                    this.f60477h = k8Var.f();
                } else {
                    eaVar = null;
                }
                if (eaVar != null) {
                    eaVar.a(this.f60479j, new dp.d(i3, Function.MAX_NARGS));
                    aVar = new a(eaVar, this.f60470a);
                    this.f60471b.put(i3, aVar);
                }
            }
            if (k8Var.f() > ((this.f60475f && this.f60476g) ? this.f60477h + 8192 : 1048576L)) {
                this.f60474e = true;
                this.f60479j.c();
            }
        }
        k8Var.c(this.f60472c.c(), 0, 2);
        this.f60472c.f(0);
        int iC = this.f60472c.C() + 6;
        if (aVar == null) {
            k8Var.a(iC);
        } else {
            this.f60472c.d(iC);
            k8Var.d(this.f60472c.c(), 0, iC);
            this.f60472c.f(6);
            aVar.a(this.f60472c);
            ah ahVar = this.f60472c;
            ahVar.e(ahVar.b());
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    @Override // com.applovin.impl.j8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r5, long r7) {
        /*
            r4 = this;
            com.applovin.impl.ho r5 = r4.f60470a
            long r5 = r5.c()
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r6 = 0
            if (r5 != 0) goto L12
            r5 = 1
            goto L13
        L12:
            r5 = r6
        L13:
            if (r5 != 0) goto L2a
            com.applovin.impl.ho r5 = r4.f60470a
            long r2 = r5.a()
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L31
            r0 = 0
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L31
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 == 0) goto L31
            goto L2c
        L2a:
            if (r5 == 0) goto L31
        L2c:
            com.applovin.impl.ho r5 = r4.f60470a
            r5.d(r7)
        L31:
            com.applovin.impl.gi r5 = r4.f60478i
            if (r5 == 0) goto L38
            r5.b(r7)
        L38:
            android.util.SparseArray r5 = r4.f60471b
            int r5 = r5.size()
            if (r6 >= r5) goto L4e
            android.util.SparseArray r5 = r4.f60471b
            java.lang.Object r5 = r5.valueAt(r6)
            com.applovin.impl.ii$a r5 = (com.applovin.impl.ii.a) r5
            r5.c()
            int r6 = r6 + 1
            goto L38
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ii.a(long, long):void");
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        byte[] bArr = new byte[14];
        k8Var.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        k8Var.c(bArr[13] & 7);
        k8Var.c(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }
}
