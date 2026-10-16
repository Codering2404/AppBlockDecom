package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05689m extends Timeline {
    public static byte[] A0D;
    public static final C2197q7 A0E;
    public static final Object A0F;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C2200qA A07;
    public final C2197q7 A08;
    public final Object A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{-79, -57, -52, -59, -54, -61, -82, -61, -48, -57, -51, -62, -78, -57, -53, -61, -54, -57, -52, -61};
    }

    static {
        A01();
        A0F = new Object();
        A0E = new C04042u().A03(A00(0, 20, 44)).A00(Uri.EMPTY).A05();
    }

    public C05689m(long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z2, boolean z3, boolean z4, Object obj, C2197q7 c2197q7, C2200qA c2200qA) {
        this.A02 = j3;
        this.A06 = j4;
        this.A00 = j5;
        this.A01 = j6;
        this.A04 = j7;
        this.A05 = j8;
        this.A03 = j9;
        this.A0B = z2;
        this.A0A = z3;
        this.A0C = z4;
        this.A09 = obj;
        this.A08 = (C2197q7) AbstractC04323y.A01(c2197q7);
        this.A07 = c2200qA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C05689m(long j3, long j4, long j5, long j6, boolean z2, boolean z3, boolean z4, Object obj, C2197q7 c2197q7) {
        C2200qA c2200qA;
        if (z4) {
            c2200qA = c2197q7.A02;
        } else {
            c2200qA = null;
        }
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j3, j4, j5, j6, z2, z3, false, obj, c2197q7, c2200qA);
    }

    public C05689m(long j3, boolean z2, boolean z3, boolean z4, Object obj, C2197q7 c2197q7) {
        this(j3, j3, 0L, 0L, z2, z3, z4, obj, c2197q7);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0A(Object obj) {
        return A0F.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2175pl A0I(int i3, C2175pl c2175pl, boolean z2) {
        AbstractC04323y.A00(i3, 0, 1);
        return c2175pl.A0F(null, z2 ? A0F : null, 0, this.A01, -this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2173pj A0L(int i3, C2173pj c2173pj, long j3) {
        AbstractC04323y.A00(i3, 0, 1);
        long j4 = this.A03;
        if (this.A0A && !this.A0C && j3 != 0) {
            if (this.A04 == -9223372036854775807L) {
                j4 = -9223372036854775807L;
            } else {
                j4 += j3;
                if (j4 > this.A04) {
                    j4 = -9223372036854775807L;
                }
            }
        }
        return c2173pj.A07(C2173pj.A0K, this.A08, this.A09, this.A02, this.A06, -9223372036854775807L, this.A0B, this.A0A, null, j4, this.A04, 0, 0, this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final Object A0M(int i3) {
        AbstractC04323y.A00(i3, 0, 1);
        return A0F;
    }
}
