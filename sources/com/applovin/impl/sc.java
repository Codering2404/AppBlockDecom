package com.applovin.impl;

import android.util.Pair;
import com.applovin.impl.ae;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sc extends vo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f63025c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f63026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f63027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f63028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final po[] f63029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f63030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[][][] f63031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final po f63032g;

        a(String[] strArr, int[] iArr, po[] poVarArr, int[] iArr2, int[][][] iArr3, po poVar) {
            this.f63027b = strArr;
            this.f63028c = iArr;
            this.f63029d = poVarArr;
            this.f63031f = iArr3;
            this.f63030e = iArr2;
            this.f63032g = poVar;
            this.f63026a = iArr.length;
        }

        public int a() {
            return this.f63026a;
        }

        public po b(int i3) {
            return this.f63029d[i3];
        }

        public int a(int i3) {
            return this.f63028c[i3];
        }
    }

    private static int a(ri[] riVarArr, oo ooVar, int[] iArr, boolean z2) {
        int length = riVarArr.length;
        int i3 = 0;
        boolean z3 = true;
        for (int i4 = 0; i4 < riVarArr.length; i4++) {
            ri riVar = riVarArr[i4];
            int iMax = 0;
            for (int i5 = 0; i5 < ooVar.f62350a; i5++) {
                iMax = Math.max(iMax, ri.d(riVar.a(ooVar.a(i5))));
            }
            boolean z4 = iArr[i4] == 0;
            if (iMax > i3 || (iMax == i3 && z2 && !z3 && z4)) {
                length = i4;
                z3 = z4;
                i3 = iMax;
            }
        }
        return length;
    }

    protected abstract Pair a(a aVar, int[][][] iArr, int[] iArr2, ae.a aVar2, fo foVar);

    private static int[] a(ri riVar, oo ooVar) {
        int[] iArr = new int[ooVar.f62350a];
        for (int i3 = 0; i3 < ooVar.f62350a; i3++) {
            iArr[i3] = riVar.a(ooVar.a(i3));
        }
        return iArr;
    }

    private static int[] a(ri[] riVarArr) {
        int length = riVarArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = riVarArr[i3].m();
        }
        return iArr;
    }

    @Override // com.applovin.impl.vo
    public final void a(Object obj) {
        this.f63025c = (a) obj;
    }

    @Override // com.applovin.impl.vo
    public final wo a(ri[] riVarArr, po poVar, ae.a aVar, fo foVar) {
        int[] iArrA;
        int[] iArr = new int[riVarArr.length + 1];
        int length = riVarArr.length + 1;
        oo[][] ooVarArr = new oo[length][];
        int[][][] iArr2 = new int[riVarArr.length + 1][][];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = poVar.f62473a;
            ooVarArr[i3] = new oo[i4];
            iArr2[i3] = new int[i4][];
        }
        int[] iArrA2 = a(riVarArr);
        for (int i5 = 0; i5 < poVar.f62473a; i5++) {
            oo ooVarA = poVar.a(i5);
            int iA = a(riVarArr, ooVarA, iArr, hf.e(ooVarA.a(0).f59394m) == 5);
            if (iA == riVarArr.length) {
                iArrA = new int[ooVarA.f62350a];
            } else {
                iArrA = a(riVarArr[iA], ooVarA);
            }
            int i6 = iArr[iA];
            ooVarArr[iA][i6] = ooVarA;
            iArr2[iA][i6] = iArrA;
            iArr[iA] = i6 + 1;
        }
        po[] poVarArr = new po[riVarArr.length];
        String[] strArr = new String[riVarArr.length];
        int[] iArr3 = new int[riVarArr.length];
        for (int i7 = 0; i7 < riVarArr.length; i7++) {
            int i8 = iArr[i7];
            poVarArr[i7] = new po((oo[]) xp.a(ooVarArr[i7], i8));
            iArr2[i7] = (int[][]) xp.a(iArr2[i7], i8);
            strArr[i7] = riVarArr[i7].getName();
            iArr3[i7] = riVarArr[i7].e();
        }
        a aVar2 = new a(strArr, iArr3, poVarArr, iArrA2, iArr2, new po((oo[]) xp.a(ooVarArr[riVarArr.length], iArr[riVarArr.length])));
        Pair pairA = a(aVar2, iArr2, iArrA2, aVar, foVar);
        return new wo((si[]) pairA.first, (g8[]) pairA.second, aVar2);
    }
}
