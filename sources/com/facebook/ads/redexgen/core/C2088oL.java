package com.facebook.ads.redexgen.core;

import java.math.RoundingMode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2088oL implements C9F {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;

    public C2088oL(C9Q c9q) {
        this.A02 = c9q.A02;
        this.A01 = c9q.A01;
        this.A05 = c9q.A05;
        this.A04 = c9q.A04;
        this.A03 = c9q.A03;
        this.A00 = c9q.A00;
    }

    public static int A00(int i3) {
        switch (i3) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    private final int A01(int i3) {
        int iA00 = A00(i3);
        int maxByteRate = this.A03;
        return AbstractC0592As.A02((((long) maxByteRate) * ((long) iA00)) / 1000000);
    }

    private final int A02(int i3, int i4) {
        int bufferSizeUs;
        int i5 = this.A04;
        if (i3 == 5) {
            int bufferSizeUs2 = this.A00;
            i5 *= bufferSizeUs2;
        }
        if (i4 != -1) {
            bufferSizeUs = AbstractC0973Pr.A00(i4, 8, RoundingMode.CEILING);
        } else {
            bufferSizeUs = A00(i3);
        }
        return AbstractC0592As.A02((((long) i5) * ((long) bufferSizeUs)) / 1000000);
    }

    public static int A03(int i3, int i4, int i5) {
        return AbstractC0592As.A02(((((long) i3) * ((long) i4)) * ((long) i5)) / 1000000);
    }

    private final int A04(int i3, int i4, int i5) {
        int maxAppBufferSize = this.A05 * i3;
        int targetBufferSize = this.A02;
        int minAppBufferSize = A03(targetBufferSize, i4, i5);
        int targetBufferSize2 = this.A01;
        return C5C.A07(maxAppBufferSize, minAppBufferSize, A03(targetBufferSize2, i4, i5));
    }

    private final int A05(int i3, int i4, int i5, int i6, int i7, int i8) {
        switch (i5) {
            case 0:
                return A04(i3, i7, i6);
            case 1:
                return A01(i4);
            case 2:
                return A02(i4, i8);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C9F
    public final int A75(int i3, int i4, int i5, int i6, int i7, int i8, double d3) {
        int bufferSize = A05(i3, i4, i5, i6, i7, i8);
        return (((Math.max(i3, (int) (((double) bufferSize) * d3)) + i6) - 1) / i6) * i6;
    }
}
