package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QO {
    public static byte[] A02;
    public static String[] A03 = {"eKMrgqlCE6gemHc3i8XP3AKPCikI", "F056EMXFpemItrIKSNHDMT", "UP7tmvacf", "VwJuHcYZb6pOUF9c5fygzqO1xhwXl8", "rbSS0TX92cN6cYo9TUPXDkEXEuy61J", "qalk034xToBy0kTaZmHtwYGALLiE8EwC", "z1", "iDDMQnl7H0FoGDQAr6PhZLTqZy2Xncag"};
    public long A00 = 0;
    public QO A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{47, 47};
    }

    static {
        A02();
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new QO();
        }
    }

    public final int A03(int i3) {
        if (this.A01 == null) {
            if (i3 >= 64) {
                return Long.bitCount(this.A00);
            }
            long j3 = this.A00;
            long j4 = (1 << i3) - 1;
            if (A03[6].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "eBNk3oMk3zKdgPZGJWBoIC6ya78Y9W";
            strArr[4] = "SZljZRIwDL4qj86IVN03h7W6Ja49N5";
            return Long.bitCount(j3 & j4);
        }
        if (i3 < 64) {
            return Long.bitCount(this.A00 & ((1 << i3) - 1));
        }
        return this.A01.A03(i3 - 64) + Long.bitCount(this.A00);
    }

    public final void A04() {
        this.A00 = 0L;
        if (this.A01 != null) {
            QO qo = this.A01;
            String[] strArr = A03;
            if (strArr[1].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "MSI1mtfoMLAkHcYJR6PW0K";
            strArr2[7] = "fUjJFSbhC3MyLq7bD4XnyNju1VoRa1IS";
            qo.A04();
        }
    }

    public final void A05(int i3) {
        if (i3 >= 64) {
            if (this.A01 != null) {
                QO qo = this.A01;
                int i4 = i3 - 64;
                if (A03[6].length() != 2) {
                    throw new RuntimeException();
                }
                A03[6] = "gh";
                qo.A05(i4);
                return;
            }
            return;
        }
        this.A00 &= ~(1 << i3);
    }

    public final void A06(int i3) {
        if (i3 >= 64) {
            A01();
            this.A01.A06(i3 - 64);
        } else {
            this.A00 |= 1 << i3;
        }
    }

    public final void A07(int i3, boolean z2) {
        if (i3 >= 64) {
            A01();
            this.A01.A07(i3 - 64, z2);
            return;
        }
        boolean z3 = (this.A00 & Long.MIN_VALUE) != 0;
        long j3 = (1 << i3) - 1;
        long j4 = this.A00 & j3;
        long j5 = this.A00;
        long mask = ~j3;
        this.A00 = j4 | ((j5 & mask) << 1);
        if (z2) {
            A06(i3);
        } else {
            A05(i3);
        }
        if (!z3 && this.A01 == null) {
            return;
        }
        A01();
        this.A01.A07(0, z3);
    }

    public final boolean A08(int i3) {
        if (i3 < 64) {
            return (this.A00 & (1 << i3)) != 0;
        }
        A01();
        return this.A01.A08(i3 - 64);
    }

    public final boolean A09(int i3) {
        if (i3 >= 64) {
            A01();
            return this.A01.A09(i3 - 64);
        }
        long j3 = 1 << i3;
        boolean z2 = (this.A00 & j3) != 0;
        long mask = this.A00;
        this.A00 = mask & (~j3);
        long j4 = j3 - 1;
        long j5 = this.A00 & j4;
        long mask2 = this.A00;
        long before = ~j4;
        this.A00 = j5 | Long.rotateRight(mask2 & before, 1);
        if (this.A01 != null) {
            if (this.A01.A08(0)) {
                A06(63);
            }
            this.A01.A09(0);
        }
        return z2;
    }

    public final String toString() {
        return this.A01 == null ? Long.toBinaryString(this.A00) : this.A01.toString() + A00(0, 2, 114) + Long.toBinaryString(this.A00);
    }
}
