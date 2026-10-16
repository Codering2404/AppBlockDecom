package com.applovin.impl;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.e9;
import com.facebook.internal.FacebookRequestErrorClassification;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class lr implements j8 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n8 f61268f = new n8() { // from class: com.applovin.impl.lz
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return lr.c();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l8 f61269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f61270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f61271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f61272d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f61273e = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int[] f61274m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int[] f61275n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l8 f61276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final qo f61277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final mr f61278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f61279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f61280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ah f61281f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f61282g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final e9 f61283h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f61284i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f61285j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f61286k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f61287l;

        public a(l8 l8Var, qo qoVar, mr mrVar) throws ch {
            this.f61276a = l8Var;
            this.f61277b = qoVar;
            this.f61278c = mrVar;
            int iMax = Math.max(1, mrVar.f61927c / 10);
            this.f61282g = iMax;
            ah ahVar = new ah(mrVar.f61931g);
            ahVar.r();
            int iR = ahVar.r();
            this.f61279d = iR;
            int i3 = mrVar.f61926b;
            int i4 = (((mrVar.f61929e - (i3 * 4)) * 8) / (mrVar.f61930f * i3)) + 1;
            if (iR == i4) {
                int iA = xp.a(iMax, iR);
                this.f61280e = new byte[mrVar.f61929e * iA];
                this.f61281f = new ah(iA * a(iR, i3));
                int i5 = ((mrVar.f61927c * mrVar.f61929e) * 8) / iR;
                this.f61283h = new e9.b().f("audio/raw").b(i5).k(i5).i(a(iMax, i3)).c(mrVar.f61926b).n(mrVar.f61927c).j(2).a();
                return;
            }
            throw ch.a("Expected frames per block: " + i4 + "; got: " + iR, null);
        }

        private static int a(int i3, int i4) {
            return i3 * 2 * i4;
        }

        private int b(int i3) {
            return a(i3, this.f61278c.f61926b);
        }

        private void c(int i3) {
            long jC = this.f61285j + xp.c(this.f61287l, 1000000L, this.f61278c.f61927c);
            int iB = b(i3);
            this.f61277b.a(jC, 1, iB, this.f61286k - iB, null);
            this.f61287l += (long) i3;
            this.f61286k -= iB;
        }

        private void a(byte[] bArr, int i3, ah ahVar) {
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < this.f61278c.f61926b; i5++) {
                    a(bArr, i4, i5, ahVar.c());
                }
            }
            int iB = b(this.f61279d * i3);
            ahVar.f(0);
            ahVar.e(iB);
        }

        private void a(byte[] bArr, int i3, int i4, byte[] bArr2) {
            mr mrVar = this.f61278c;
            int i5 = mrVar.f61929e;
            int i6 = mrVar.f61926b;
            int i7 = (i3 * i5) + (i4 * 4);
            int i8 = (i6 * 4) + i7;
            int i9 = (i5 / i6) - 4;
            int iA = (short) (((bArr[i7 + 1] & 255) << 8) | (bArr[i7] & 255));
            int iMin = Math.min(bArr[i7 + 2] & 255, 88);
            int i10 = f61275n[iMin];
            int i11 = ((i3 * this.f61279d * i6) + i4) * 2;
            bArr2[i11] = (byte) (iA & 255);
            bArr2[i11 + 1] = (byte) (iA >> 8);
            for (int i12 = 0; i12 < i9 * 2; i12++) {
                byte b3 = bArr[((i12 / 8) * i6 * 4) + i8 + ((i12 / 2) % 4)];
                int i13 = i12 % 2 == 0 ? b3 & Ascii.SI : (b3 & 255) >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i10) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                iA = xp.a(iA + i14, -32768, 32767);
                i11 += i6 * 2;
                bArr2[i11] = (byte) (iA & 255);
                bArr2[i11 + 1] = (byte) (iA >> 8);
                int i15 = iMin + f61274m[i13];
                int[] iArr = f61275n;
                iMin = xp.a(i15, 0, iArr.length - 1);
                i10 = iArr[iMin];
            }
        }

        @Override // com.applovin.impl.lr.b
        public void a(int i3, long j3) {
            this.f61276a.a(new or(this.f61278c, this.f61279d, i3, j3));
            this.f61277b.a(this.f61283h);
        }

        private int a(int i3) {
            return i3 / (this.f61278c.f61926b * 2);
        }

        @Override // com.applovin.impl.lr.b
        public void a(long j3) {
            this.f61284i = 0;
            this.f61285j = j3;
            this.f61286k = 0;
            this.f61287l = 0L;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x001c, code lost:
        
            r1 = true;
         */
        @Override // com.applovin.impl.lr.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(com.applovin.impl.k8 r6, long r7) {
            /*
                r5 = this;
                int r0 = r5.f61282g
                int r1 = r5.f61286k
                int r1 = r5.a(r1)
                int r0 = r0 - r1
                int r1 = r5.f61279d
                int r0 = com.applovin.impl.xp.a(r0, r1)
                com.applovin.impl.mr r1 = r5.f61278c
                int r1 = r1.f61929e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r1 != 0) goto L1b
                goto L35
            L1b:
                r1 = 0
            L1c:
                if (r1 != 0) goto L3d
                int r2 = r5.f61284i
                if (r2 >= r0) goto L3d
                int r2 = r0 - r2
                long r2 = (long) r2
                long r2 = java.lang.Math.min(r2, r7)
                int r2 = (int) r2
                byte[] r3 = r5.f61280e
                int r4 = r5.f61284i
                int r2 = r6.a(r3, r4, r2)
                r3 = -1
                if (r2 != r3) goto L37
            L35:
                r1 = 1
                goto L1c
            L37:
                int r3 = r5.f61284i
                int r3 = r3 + r2
                r5.f61284i = r3
                goto L1c
            L3d:
                int r6 = r5.f61284i
                com.applovin.impl.mr r7 = r5.f61278c
                int r7 = r7.f61929e
                int r6 = r6 / r7
                if (r6 <= 0) goto L74
                byte[] r7 = r5.f61280e
                com.applovin.impl.ah r8 = r5.f61281f
                r5.a(r7, r6, r8)
                int r7 = r5.f61284i
                com.applovin.impl.mr r8 = r5.f61278c
                int r8 = r8.f61929e
                int r6 = r6 * r8
                int r7 = r7 - r6
                r5.f61284i = r7
                com.applovin.impl.ah r6 = r5.f61281f
                int r6 = r6.e()
                com.applovin.impl.qo r7 = r5.f61277b
                com.applovin.impl.ah r8 = r5.f61281f
                r7.a(r8, r6)
                int r7 = r5.f61286k
                int r7 = r7 + r6
                r5.f61286k = r7
                int r6 = r5.a(r7)
                int r7 = r5.f61282g
                if (r6 < r7) goto L74
                r5.c(r7)
            L74:
                if (r1 == 0) goto L81
                int r6 = r5.f61286k
                int r6 = r5.a(r6)
                if (r6 <= 0) goto L81
                r5.c(r6)
            L81:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.lr.a.a(com.applovin.impl.k8, long):boolean");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface b {
        void a(int i3, long j3);

        void a(long j3);

        boolean a(k8 k8Var, long j3);
    }

    private void b() {
        b1.b(this.f61270b);
        xp.a(this.f61269a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] c() {
        return new j8[]{new lr()};
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l8 f61288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final qo f61289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final mr f61290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final e9 f61291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f61292e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f61293f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f61294g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f61295h;

        public c(l8 l8Var, qo qoVar, mr mrVar, String str, int i3) throws ch {
            this.f61288a = l8Var;
            this.f61289b = qoVar;
            this.f61290c = mrVar;
            int i4 = (mrVar.f61926b * mrVar.f61930f) / 8;
            if (mrVar.f61929e == i4) {
                int i5 = mrVar.f61927c * i4;
                int i6 = i5 * 8;
                int iMax = Math.max(i4, i5 / 10);
                this.f61292e = iMax;
                this.f61291d = new e9.b().f(str).b(i6).k(i6).i(iMax).c(mrVar.f61926b).n(mrVar.f61927c).j(i3).a();
                return;
            }
            throw ch.a("Expected block size: " + i4 + "; got: " + mrVar.f61929e, null);
        }

        @Override // com.applovin.impl.lr.b
        public void a(int i3, long j3) {
            this.f61288a.a(new or(this.f61290c, 1, i3, j3));
            this.f61289b.a(this.f61291d);
        }

        @Override // com.applovin.impl.lr.b
        public void a(long j3) {
            this.f61293f = j3;
            this.f61294g = 0;
            this.f61295h = 0L;
        }

        @Override // com.applovin.impl.lr.b
        public boolean a(k8 k8Var, long j3) {
            int i3;
            int i4;
            long j4 = j3;
            while (j4 > 0 && (i3 = this.f61294g) < (i4 = this.f61292e)) {
                int iA = this.f61289b.a((f5) k8Var, (int) Math.min(i4 - i3, j4), true);
                if (iA == -1) {
                    j4 = 0;
                } else {
                    this.f61294g += iA;
                    j4 -= (long) iA;
                }
            }
            int i5 = this.f61290c.f61929e;
            int i6 = this.f61294g / i5;
            if (i6 > 0) {
                long jC = this.f61293f + xp.c(this.f61295h, 1000000L, r1.f61927c);
                int i7 = i6 * i5;
                int i8 = this.f61294g - i7;
                this.f61289b.a(jC, 1, i7, i8, null);
                this.f61295h += (long) i6;
                this.f61294g = i8;
            }
            return j4 <= 0;
        }
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f61269a = l8Var;
        this.f61270b = l8Var.a(0, 1);
        l8Var.c();
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        b();
        if (this.f61271c == null) {
            mr mrVarA = nr.a(k8Var);
            if (mrVarA != null) {
                int i3 = mrVarA.f61925a;
                if (i3 == 17) {
                    this.f61271c = new a(this.f61269a, this.f61270b, mrVarA);
                } else if (i3 == 6) {
                    this.f61271c = new c(this.f61269a, this.f61270b, mrVarA, "audio/g711-alaw", -1);
                } else if (i3 == 7) {
                    this.f61271c = new c(this.f61269a, this.f61270b, mrVarA, "audio/g711-mlaw", -1);
                } else {
                    int iA = pr.a(i3, mrVarA.f61930f);
                    if (iA != 0) {
                        this.f61271c = new c(this.f61269a, this.f61270b, mrVarA, "audio/raw", iA);
                    } else {
                        throw ch.a("Unsupported WAV format type: " + mrVarA.f61925a);
                    }
                }
            } else {
                throw ch.a("Unsupported or unrecognized wav header.", null);
            }
        }
        if (this.f61272d == -1) {
            Pair pairB = nr.b(k8Var);
            this.f61272d = ((Long) pairB.first).intValue();
            long jLongValue = ((Long) pairB.second).longValue();
            this.f61273e = jLongValue;
            this.f61271c.a(this.f61272d, jLongValue);
        } else if (k8Var.f() == 0) {
            k8Var.a(this.f61272d);
        }
        b1.b(this.f61273e != -1);
        return this.f61271c.a(k8Var, this.f61273e - k8Var.f()) ? -1 : 0;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        b bVar = this.f61271c;
        if (bVar != null) {
            bVar.a(j4);
        }
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        return nr.a(k8Var) != null;
    }
}
