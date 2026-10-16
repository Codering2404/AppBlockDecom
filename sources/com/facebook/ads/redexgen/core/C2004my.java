package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.my, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2004my implements HY {
    public static byte[] A06;
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final long[] A03;
    public final long[] A04;
    public final long A05;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{65, 57, 53, 113, 96, 103, 116, 97, 124, 122, 123, 102, 64, 102, 40, 111, 99, 44, 37, 37, 48, 38, 55, 48, 126, 53, 57, 106, 112, 99, 124, 106, 36, 105, 101, Framer.STDOUT_FRAME_PREFIX, 44, 40, 32, Ascii.DLE, 54, Framer.EXIT_FRAME_PREFIX, 47, 4, Ascii.EM, 2, 7, 37, 2, 8, 9, Ascii.DC4, 68, 0, 9, 2, Ascii.VT, Ascii.CAN, 4, 81};
    }

    public C2004my(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.A01 = iArr;
        this.A03 = jArr;
        this.A02 = jArr2;
        this.A04 = jArr3;
        this.A00 = iArr.length;
        if (this.A00 > 0) {
            this.A05 = jArr2[this.A00 - 1] + jArr3[this.A00 - 1];
        } else {
            this.A05 = 0L;
        }
    }

    private final int A00(long j3) {
        return C5C.A0L(this.A04, j3, true, true);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        int iA00 = A00(j3);
        HZ hz = new HZ(this.A04[iA00], this.A03[iA00]);
        if (hz.A01 < j3) {
            int chunkIndex = this.A00;
            if (iA00 != chunkIndex - 1) {
                int chunkIndex2 = iA00 + 1;
                long j4 = this.A04[chunkIndex2];
                int chunkIndex3 = iA00 + 1;
                HZ seekPoint = new HZ(j4, this.A03[chunkIndex3]);
                return new HX(hz, seekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }

    public final String toString() {
        return A01(42, 18, 116) + this.A00 + A01(25, 8, 1) + Arrays.toString(this.A01) + A01(15, 10, 91) + Arrays.toString(this.A03) + A01(33, 9, 93) + Arrays.toString(this.A04) + A01(1, 14, 13) + Arrays.toString(this.A02) + A01(0, 1, 112);
    }
}
