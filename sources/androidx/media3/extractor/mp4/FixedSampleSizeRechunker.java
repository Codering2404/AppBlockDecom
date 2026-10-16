package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Util;
import com.facebook.internal.Utility;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FixedSampleSizeRechunker {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Results {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f46722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f46723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f46725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f46726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f46727f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f46728g;

        private Results(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3, long j4) {
            this.f46722a = jArr;
            this.f46723b = iArr;
            this.f46724c = i3;
            this.f46725d = jArr2;
            this.f46726e = iArr2;
            this.f46727f = j3;
            this.f46728g = j4;
        }
    }

    public static Results a(int i3, long[] jArr, int[] iArr, long j3) {
        int[] iArr2 = iArr;
        int i4 = Utility.DEFAULT_STREAM_BUFFER_SIZE / i3;
        int i5 = 0;
        int iM = 0;
        for (int i6 : iArr2) {
            iM += Util.m(i6, i4);
        }
        long[] jArr2 = new long[iM];
        int[] iArr3 = new int[iM];
        long[] jArr3 = new long[iM];
        int[] iArr4 = new int[iM];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int iMax = 0;
        while (i5 < iArr2.length) {
            int i10 = iArr2[i5];
            long j4 = jArr[i5];
            while (i10 > 0) {
                int iMin = Math.min(i4, i10);
                jArr2[i9] = j4;
                int i11 = i3 * iMin;
                iArr3[i9] = i11;
                i8 += i11;
                iMax = Math.max(iMax, i11);
                jArr3[i9] = ((long) i7) * j3;
                iArr4[i9] = 1;
                j4 += (long) iArr3[i9];
                i7 += iMin;
                i10 -= iMin;
                i9++;
                i4 = i4;
            }
            i5++;
            iArr2 = iArr;
        }
        return new Results(jArr2, iArr3, iMax, jArr3, iArr4, j3 * ((long) i7), i8);
    }
}
