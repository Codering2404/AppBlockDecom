package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0794Iq {
    public static byte[] A03;
    public static String[] A04 = {"HAKRynb8Q9v8wV", "SuVhDSJQ2bNZpX8wX0KLsmsmTr4DPxxi", "R4UQPZj2Q3kbph", "e9pWJk1Ybkx6CP9fcYJC0x", "eiipULpIaD7vlRs8Jy7kUpOIExEcCgDN", "YpNetcItpMoyU0YUx2skn5ODY6DUrezi", "ou3Ne9sakumlTqc9WPghqVzc9J2dmBuy", "DIJExoJGQDv48UOT"};
    public static final long[] A05;
    public int A00;
    public int A01;
    public final byte[] A02 = new byte[8];

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{79, 110, Framer.ENTER_FRAME_PREFIX, 119, 96, 109, 104, 101, Framer.ENTER_FRAME_PREFIX, 119, 96, 115, 104, 111, 117, Framer.ENTER_FRAME_PREFIX, 109, 100, 111, 102, 117, 105, Framer.ENTER_FRAME_PREFIX, 108, 96, 114, 106, Framer.ENTER_FRAME_PREFIX, 103, 110, 116, 111, 101};
    }

    static {
        A03();
        A05 = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(int r7) {
        /*
            r6 = -1
            r5 = 0
        L2:
            long[] r0 = com.facebook.ads.redexgen.core.C0794Iq.A05
            int r0 = r0.length
            if (r5 >= r0) goto L15
            long[] r0 = com.facebook.ads.redexgen.core.C0794Iq.A05
            r3 = r0[r5]
            long r0 = (long) r7
            long r3 = r3 & r0
            r1 = 0
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L16
            int r6 = r5 + 1
        L15:
            return r6
        L16:
            int r5 = r5 + 1
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0794Iq.A00(int):int");
    }

    public static long A01(byte[] bArr, int i3, boolean z2) {
        long j3 = ((long) bArr[0]) & 255;
        if (z2) {
            long varint = A05[i3 - 1];
            long j4 = ~varint;
            if (A04[3].length() != 22) {
                throw new RuntimeException();
            }
            A04[1] = "UrbVUTUxAL9DS6258RCx02QNXCAhkfZP";
            j3 &= j4;
        }
        for (int i4 = 1; i4 < i3; i4++) {
            long varint2 = bArr[i4];
            j3 = (j3 << 8) | (varint2 & 255);
        }
        return j3;
    }

    public final int A04() {
        return this.A00;
    }

    public final long A05(InterfaceC1999ms interfaceC1999ms, boolean z2, boolean z3, int i3) throws IOException {
        if (this.A01 == 0) {
            if (!interfaceC1999ms.AHR(this.A02, 0, 1, z2)) {
                return -1L;
            }
            int firstByte = this.A02[0] & 255;
            this.A00 = A00(firstByte);
            if (this.A00 != -1) {
                this.A01 = 1;
            } else {
                throw new IllegalStateException(A02(0, 33, 126));
            }
        }
        int firstByte2 = this.A00;
        if (firstByte2 > i3) {
            this.A01 = 0;
            return -2L;
        }
        if (this.A00 != 1) {
            interfaceC1999ms.readFully(this.A02, 1, this.A00 - 1);
        }
        this.A01 = 0;
        return A01(this.A02, this.A00, z3);
    }

    public final void A06() {
        this.A01 = 0;
        this.A00 = 0;
    }
}
