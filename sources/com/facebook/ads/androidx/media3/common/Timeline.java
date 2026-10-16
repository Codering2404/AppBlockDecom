package com.facebook.ads.androidx.media3.common;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.ads.redexgen.core.AR;
import com.facebook.ads.redexgen.core.AS;
import com.facebook.ads.redexgen.core.AbstractC04323y;
import com.facebook.ads.redexgen.core.AnonymousClass22;
import com.facebook.ads.redexgen.core.AnonymousClass23;
import com.facebook.ads.redexgen.core.AnonymousClass24;
import com.facebook.ads.redexgen.core.AnonymousClass43;
import com.facebook.ads.redexgen.core.BP;
import com.facebook.ads.redexgen.core.C2173pj;
import com.facebook.ads.redexgen.core.C2175pl;
import com.facebook.ads.redexgen.core.C2K;
import com.facebook.ads.redexgen.core.C5C;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class Timeline implements AnonymousClass24 {
    public static String[] A00 = {"u1TV1j0aFj13GJQ9ixTagHG8KyMgbnog", "4GMeFBxldVuonExwkIPaDDi9I59L728Z", "hqD1wOYcZTmehOTQOtlNc0UQ2KV4ETaI", "yejsGunEYiKaKfUzobCfCtheJf3zEEcL", "wYd9LRHFlTpJXE3VqmNr3ySXFdmyeGzN", "VCegaKN739XbWKUaP5Uwy30Zmvr6QTeK", "Cr3igiuAIuu", "x89DN52UD2fFRZn9rQXfWzGYhaiJYHE1"};
    public static final Timeline A02 = new AS();
    public static final String A05 = C5C.A0h(0);
    public static final String A03 = C5C.A0h(1);
    public static final String A04 = C5C.A0h(2);
    public static final AnonymousClass23<Timeline> A01 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pq
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return Timeline.A02(bundle);
        }
    };

    public abstract int A06();

    public abstract int A07();

    public abstract int A0A(Object obj);

    public abstract C2175pl A0I(int i3, C2175pl c2175pl, boolean z2);

    public abstract C2173pj A0L(int i3, C2173pj c2173pj, long j3);

    public abstract Object A0M(int i3);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Period> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Window> */
    public static AR A02(Bundle bundle) {
        BP bpA04 = A04(C2173pj.A0J, AnonymousClass43.A00(bundle, A05));
        BP bpA042 = A04(C2175pl.A08, AnonymousClass43.A00(bundle, A03));
        int[] intArray = bundle.getIntArray(A04);
        if (intArray == null) {
            intArray = A05(bpA04.size());
        }
        return new AR(bpA04, bpA042, intArray);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.23 != com.facebook.ads.androidx.media3.common.Bundleable$Creator<T extends com.facebook.ads.redexgen.X.24> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<T extends com.facebook.ads.redexgen.X.24> */
    public static <T extends AnonymousClass24> BP<T> A04(AnonymousClass23<T> anonymousClass23, IBinder iBinder) {
        if (iBinder == null) {
            return BP.A03();
        }
        C2K c2k = new C2K();
        BP<Bundle> bpA00 = AnonymousClass22.A00(iBinder);
        for (int i3 = 0; i3 < bpA00.size(); i3++) {
            c2k.A04(anonymousClass23.A6f(bpA00.get(i3)));
        }
        return c2k.A05();
    }

    public static int[] A05(int i3) {
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i4] = i4;
            int i5 = A00[1].charAt(20);
            if (i5 == 50) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[2] = "bm1hpxiL8T70YPoy7qoC4X3DFFhRRvrI";
            strArr[4] = "ZU2doOYnXTdq2XyitRV5O0BVNSu1NLTL";
        }
        return iArr;
    }

    public int A08(int i3, int i4, boolean z2) {
        switch (i4) {
            case 0:
                if (i3 == A0C(z2)) {
                    return -1;
                }
                return i3 + 1;
            case 1:
                return i3;
            case 2:
                int iA0C = A0C(z2);
                String[] strArr = A00;
                if (strArr[3].charAt(14) != strArr[5].charAt(14)) {
                    throw new RuntimeException();
                }
                A00[1] = "R0HEAX03GiDQUcMP0CiDD2yYG3qNGv8H";
                if (i3 == iA0C) {
                    return A0B(z2);
                }
                return i3 + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A09(int i3, C2175pl c2175pl, C2173pj c2173pj, int i4, boolean z2) {
        int i5 = A0H(i3, c2175pl).A00;
        int windowIndex = A0K(i5, c2173pj).A01;
        if (windowIndex == i3) {
            int nextWindowIndex = A08(i5, i4, z2);
            if (nextWindowIndex == -1) {
                return -1;
            }
            int windowIndex2 = A0K(nextWindowIndex, c2173pj).A00;
            return windowIndex2;
        }
        int windowIndex3 = i3 + 1;
        return windowIndex3;
    }

    public int A0B(boolean z2) {
        return A0N() ? -1 : 0;
    }

    public int A0C(boolean z2) {
        if (A0N()) {
            return -1;
        }
        return A07() - 1;
    }

    @Deprecated
    public final Pair<Object, Long> A0D(C2173pj c2173pj, C2175pl c2175pl, int i3, long j3) {
        return A0E(c2173pj, c2175pl, i3, j3);
    }

    public final Pair<Object, Long> A0E(C2173pj c2173pj, C2175pl c2175pl, int i3, long j3) {
        return (Pair) AbstractC04323y.A01(A0G(c2173pj, c2175pl, i3, j3, 0L));
    }

    @Deprecated
    public final Pair<Object, Long> A0F(C2173pj c2173pj, C2175pl c2175pl, int i3, long j3, long j4) {
        return A0G(c2173pj, c2175pl, i3, j3, j4);
    }

    public final Pair<Object, Long> A0G(C2173pj c2173pj, C2175pl c2175pl, int i3, long j3, long j4) {
        AbstractC04323y.A00(i3, 0, A07());
        A0L(i3, c2173pj, j4);
        if (j3 == -9223372036854775807L) {
            j3 = c2173pj.A05();
            if (j3 == -9223372036854775807L) {
                return null;
            }
        }
        int i4 = c2173pj.A00;
        A0H(i4, c2175pl);
        while (i4 < c2173pj.A01 && c2175pl.A02 != j3 && A0H(i4 + 1, c2175pl).A02 <= j3) {
            i4++;
        }
        A0I(i4, c2175pl, true);
        long jMin = j3 - c2175pl.A02;
        if (c2175pl.A01 != -9223372036854775807L) {
            long j5 = c2175pl.A01;
            if (A00[1].charAt(20) == '2') {
                throw new RuntimeException();
            }
            A00[1] = "slEcDLMOMSnRw8lzrIQwxe9jf9tcgTic";
            jMin = Math.min(jMin, j5 - 1);
        }
        return Pair.create(AbstractC04323y.A01(c2175pl.A04), Long.valueOf(Math.max(0L, jMin)));
    }

    public final C2175pl A0H(int i3, C2175pl c2175pl) {
        return A0I(i3, c2175pl, false);
    }

    public C2175pl A0J(Object obj, C2175pl c2175pl) {
        return A0I(A0A(obj), c2175pl, true);
    }

    public final C2173pj A0K(int i3, C2173pj c2173pj) {
        return A0L(i3, c2173pj, 0L);
    }

    public final boolean A0N() {
        return A07() == 0;
    }

    public final boolean A0O(int i3, C2175pl c2175pl, C2173pj c2173pj, int i4, boolean z2) {
        return A09(i3, c2175pl, c2173pj, i4, z2) == -1;
    }

    public final boolean equals(Object obj) {
        int iA0C;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.A07() != A07() || timeline.A06() != A06()) {
            return false;
        }
        C2173pj c2173pj = new C2173pj();
        C2175pl c2175pl = new C2175pl();
        C2173pj window = new C2173pj();
        C2175pl otherPeriod = new C2175pl();
        for (int i3 = 0; i3 < A07(); i3++) {
            if (!A0K(i3, c2173pj).equals(timeline.A0K(i3, window))) {
                return false;
            }
        }
        for (int i4 = 0; i4 < A06(); i4++) {
            boolean zEquals = A0I(i4, c2175pl, true).equals(timeline.A0I(i4, otherPeriod, true));
            if (A00[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "LCXdoHEXleHtD1UyLVprjOGqC7qnADXU";
            strArr[0] = "np8LEsRhRemsbbWWIjAQc1GjKbBRdfRS";
            if (!zEquals) {
                return false;
            }
        }
        int iA0B = A0B(true);
        if (iA0B != timeline.A0B(true) || (iA0C = A0C(true)) != timeline.A0C(true)) {
            return false;
        }
        while (iA0B != iA0C) {
            int iA08 = A08(iA0B, 0, true);
            if (iA08 != timeline.A08(iA0B, 0, true)) {
                return false;
            }
            iA0B = iA08;
        }
        return true;
    }

    public final int hashCode() {
        C2173pj c2173pj = new C2173pj();
        C2175pl c2175pl = new C2175pl();
        int result = 7 * 31;
        int i3 = result + A07();
        for (int i4 = 0; i4 < A07(); i4++) {
            C2173pj window = A0K(i4, c2173pj);
            i3 = (i3 * 31) + window.hashCode();
        }
        int result2 = i3 * 31;
        int i5 = result2 + A06();
        for (int i6 = 0; i6 < A06(); i6++) {
            i5 = (i5 * 31) + A0I(i6, c2175pl, true).hashCode();
        }
        int iA0B = A0B(true);
        while (iA0B != -1) {
            int windowIndex = i5 * 31;
            i5 = windowIndex + iA0B;
            iA0B = A08(iA0B, 0, true);
        }
        return i5;
    }
}
