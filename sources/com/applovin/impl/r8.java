package com.applovin.impl;

import com.facebook.internal.Utility;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class r8 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f62801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f62802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f62804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f62805e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f62806f;

        private b(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3) {
            this.f62801a = jArr;
            this.f62802b = iArr;
            this.f62803c = i3;
            this.f62804d = jArr2;
            this.f62805e = iArr2;
            this.f62806f = j3;
        }
    }

    public static b a(int i3, long[] jArr, int[] iArr, long j3) {
        int i4 = Utility.DEFAULT_STREAM_BUFFER_SIZE / i3;
        int iA = 0;
        for (int i5 : iArr) {
            iA += xp.a(i5, i4);
        }
        long[] jArr2 = new long[iA];
        int[] iArr2 = new int[iA];
        long[] jArr3 = new long[iA];
        int[] iArr3 = new int[iA];
        int i6 = 0;
        int i7 = 0;
        int iMax = 0;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            long j4 = jArr[i8];
            while (i9 > 0) {
                int iMin = Math.min(i4, i9);
                jArr2[i7] = j4;
                int i10 = i3 * iMin;
                iArr2[i7] = i10;
                iMax = Math.max(iMax, i10);
                jArr3[i7] = ((long) i6) * j3;
                iArr3[i7] = 1;
                j4 += (long) iArr2[i7];
                i6 += iMin;
                i9 -= iMin;
                i7++;
            }
        }
        return new b(jArr2, iArr2, iMax, jArr3, iArr3, j3 * ((long) i6));
    }
}
