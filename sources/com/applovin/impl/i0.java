package com.applovin.impl;

import com.applovin.impl.db;
import com.applovin.impl.g8;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class i0 extends f2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final y1 f60272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f60273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f60274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f60275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f60276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f60277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final db f60278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final l3 f60279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f60280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f60281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f60282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f60283s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f60284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f60285b;

        public a(long j3, long j4) {
            this.f60284a = j3;
            this.f60285b = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f60284a == aVar.f60284a && this.f60285b == aVar.f60285b;
        }

        public int hashCode() {
            return (((int) this.f60284a) * 31) + ((int) this.f60285b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b implements g8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f60286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f60287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f60288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f60289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f60290e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final l3 f60291f;

        public b() {
            this(ColorExtractionConstants.MAX_PIXEL_SAMPLES, 25000, 25000, 0.7f, 0.75f, l3.f61106a);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
        @Override // com.applovin.impl.g8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.applovin.impl.g8[] a(com.applovin.impl.g8.a[] r10, com.applovin.impl.y1 r11, com.applovin.impl.ae.a r12, com.applovin.impl.fo r13) {
            /*
                r9 = this;
                com.applovin.impl.db r12 = com.applovin.impl.i0.a(r10)
                int r13 = r10.length
                com.applovin.impl.g8[] r13 = new com.applovin.impl.g8[r13]
                r0 = 0
                r1 = r0
            L9:
                int r2 = r10.length
                if (r1 >= r2) goto L40
                r2 = r10[r1]
                if (r2 == 0) goto L15
                int[] r5 = r2.f59889b
                int r3 = r5.length
                if (r3 != 0) goto L17
            L15:
                r7 = r11
                goto L3c
            L17:
                int r3 = r5.length
                r4 = 1
                if (r3 != r4) goto L28
                com.applovin.impl.s8 r3 = new com.applovin.impl.s8
                com.applovin.impl.oo r4 = r2.f59888a
                r5 = r5[r0]
                int r2 = r2.f59890c
                r3.<init>(r4, r5, r2)
                r7 = r11
                goto L3a
            L28:
                com.applovin.impl.oo r4 = r2.f59888a
                int r6 = r2.f59890c
                java.lang.Object r2 = r12.get(r1)
                r8 = r2
                com.applovin.impl.db r8 = (com.applovin.impl.db) r8
                r3 = r9
                r7 = r11
                com.applovin.impl.i0 r11 = r3.a(r4, r5, r6, r7, r8)
                r3 = r11
            L3a:
                r13[r1] = r3
            L3c:
                int r1 = r1 + 1
                r11 = r7
                goto L9
            L40:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.i0.b.a(com.applovin.impl.g8$a[], com.applovin.impl.y1, com.applovin.impl.ae$a, com.applovin.impl.fo):com.applovin.impl.g8[]");
        }

        public b(int i3, int i4, int i5, float f3, float f4, l3 l3Var) {
            this.f60286a = i3;
            this.f60287b = i4;
            this.f60288c = i5;
            this.f60289d = f3;
            this.f60290e = f4;
            this.f60291f = l3Var;
        }

        protected i0 a(oo ooVar, int[] iArr, int i3, y1 y1Var, db dbVar) {
            return new i0(ooVar, iArr, i3, y1Var, this.f60286a, this.f60287b, this.f60288c, this.f60289d, this.f60290e, dbVar, this.f60291f);
        }
    }

    protected i0(oo ooVar, int[] iArr, int i3, y1 y1Var, long j3, long j4, long j5, float f3, float f4, List list, l3 l3Var) {
        super(ooVar, iArr, i3);
        if (j5 < j3) {
            oc.d("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j5 = j3;
        }
        this.f60272h = y1Var;
        this.f60273i = j3 * 1000;
        this.f60274j = j4 * 1000;
        this.f60275k = j5 * 1000;
        this.f60276l = f3;
        this.f60277m = f4;
        this.f60278n = db.a((Collection) list);
        this.f60279o = l3Var;
        this.f60280p = 1.0f;
        this.f60282r = 0;
        this.f60283s = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static db b(g8.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (g8.a aVar : aVarArr) {
            if (aVar == null || aVar.f59889b.length <= 1) {
                arrayList.add(null);
            } else {
                db.a aVarF = db.f();
                aVarF.b(new a(0L, 0L));
                arrayList.add(aVarF);
            }
        }
        long[][] jArrC = c(aVarArr);
        int[] iArr = new int[jArrC.length];
        long[] jArr = new long[jArrC.length];
        for (int i3 = 0; i3 < jArrC.length; i3++) {
            long[] jArr2 = jArrC[i3];
            jArr[i3] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        a(arrayList, jArr);
        db dbVarA = a(jArrC);
        for (int i4 = 0; i4 < dbVarA.size(); i4++) {
            int iIntValue = ((Integer) dbVarA.get(i4)).intValue();
            int i5 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i5;
            jArr[iIntValue] = jArrC[iIntValue][i5];
            a(arrayList, jArr);
        }
        for (int i6 = 0; i6 < aVarArr.length; i6++) {
            if (arrayList.get(i6) != null) {
                jArr[i6] = jArr[i6] * 2;
            }
        }
        a(arrayList, jArr);
        db.a aVarF2 = db.f();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            db.a aVar2 = (db.a) arrayList.get(i7);
            aVarF2.b(aVar2 == null ? db.h() : aVar2.a());
        }
        return aVarF2.a();
    }

    private static long[][] c(g8.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            g8.a aVar = aVarArr[i3];
            if (aVar == null) {
                jArr[i3] = new long[0];
            } else {
                jArr[i3] = new long[aVar.f59889b.length];
                int i4 = 0;
                while (true) {
                    if (i4 >= aVar.f59889b.length) {
                        break;
                    }
                    jArr[i3][i4] = aVar.f59888a.a(r5[i4]).f59390i;
                    i4++;
                }
                Arrays.sort(jArr[i3]);
            }
        }
        return jArr;
    }

    @Override // com.applovin.impl.g8
    public int h() {
        return this.f60281q;
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.g8
    public void i() {
        this.f60283s = -9223372036854775807L;
    }

    private static void a(List list, long[] jArr) {
        long j3 = 0;
        for (long j4 : jArr) {
            j3 += j4;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            db.a aVar = (db.a) list.get(i3);
            if (aVar != null) {
                aVar.b(new a(j3, jArr[i3]));
            }
        }
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.g8
    public void a(float f3) {
        this.f60280p = f3;
    }

    private static db a(long[][] jArr) {
        ec ecVarB = vf.a().a().b();
        for (int i3 = 0; i3 < jArr.length; i3++) {
            long[] jArr2 = jArr[i3];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i4 = 0;
                while (true) {
                    long[] jArr3 = jArr[i3];
                    double dLog = 0.0d;
                    if (i4 >= jArr3.length) {
                        break;
                    }
                    long j3 = jArr3[i4];
                    if (j3 != -1) {
                        dLog = Math.log(j3);
                    }
                    dArr[i4] = dLog;
                    i4++;
                }
                int i5 = length - 1;
                double d3 = dArr[i5] - dArr[0];
                int i6 = 0;
                while (i6 < i5) {
                    double d4 = dArr[i6];
                    i6++;
                    ecVarB.put(Double.valueOf(d3 == 0.0d ? 1.0d : (((d4 + dArr[i6]) * 0.5d) - dArr[0]) / d3), Integer.valueOf(i3));
                }
            }
        }
        return db.a(ecVarB.values());
    }

    @Override // com.applovin.impl.f2, com.applovin.impl.g8
    public void f() {
    }
}
