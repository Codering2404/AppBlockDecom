package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class LP {
    public static byte[] A00;
    public static String[] A01 = {"sX38XYxjSWs23SpIJtTv7zqsiULa6NDN", "GVdzvLjErUQlCiFlI6sj0UXKxa4oVMD1", "mIptDDVqgJzdzMBxnTdyNQyM9U5NEVN", "EbHk890dVqPqb4rol71PU8NjsI2mWG9N", "NaaYWHcYaAW6JEQtPhbZM5A", "ny7KRitGLB3lrMhzsw8kbWX2NySq0vmW", "JAavj5eiIDuEB7ikgcXMWWkFbaDdUxIE", "svQ0hoJoeE45w1Y6xC2"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static LN A02(InterfaceC1999ms interfaceC1999ms) throws IOException {
        byte[] bArr;
        C04554v c04554v = new C04554v(16);
        LO loA03 = A03(1718449184, interfaceC1999ms, c04554v);
        AbstractC04323y.A08(loA03.A01 >= 16);
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 16);
        c04554v.A0f(0);
        int iA0G = c04554v.A0G();
        int iA0G2 = c04554v.A0G();
        int iA0F = c04554v.A0F();
        int iA0F2 = c04554v.A0F();
        int iA0G3 = c04554v.A0G();
        int iA0G4 = c04554v.A0G();
        int i3 = ((int) loA03.A01) - 16;
        if (i3 > 0) {
            bArr = new byte[i3];
            interfaceC1999ms.AGt(bArr, 0, i3);
        } else {
            bArr = C5C.A07;
        }
        interfaceC1999ms.AK3((int) (interfaceC1999ms.A8i() - interfaceC1999ms.A8n()));
        return new LN(iA0G, iA0G2, iA0F, iA0F2, iA0G3, iA0G4, bArr);
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{59, Ascii.DLE, Ascii.CR, Ascii.SYN, 19, 88, 17, Ascii.VT, 88, Ascii.FF, Ascii.ETB, Ascii.ETB, 88, Ascii.DC4, Ascii.EM, 10, Ascii.US, Ascii.GS, 88, 80, 6, 74, 63, 58, 83, 81, 88, Ascii.FF, Ascii.ETB, 88, Ascii.VT, 19, 17, 8, 67, 88, 17, Ascii.FS, 66, 88, Framer.STDIN_FRAME_PREFIX, 3, 10, Ascii.VT, Ascii.SYN, Ascii.CR, 10, 3, 68, 17, 10, Ascii.SI, 10, Ascii.VT, 19, 10, 68, 51, 37, Framer.STDERR_FRAME_PREFIX, 68, 7, Ascii.FF, 17, 10, Ascii.SI, 94, 68, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, Ascii.FS, 90, 83, 78, 81, Ascii.FS, 72, 69, 76, 89, 6, Ascii.FS, 105, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 118, 91, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, 91, 76, 108, 91, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, 91, 76};
    }

    static {
        A05();
    }

    public static long A00(InterfaceC1999ms interfaceC1999ms) throws IOException {
        C04554v c04554v = new C04554v(8);
        LO chunkHeader = LO.A00(interfaceC1999ms, c04554v);
        if (chunkHeader.A00 != 1685272116) {
            interfaceC1999ms.AIl();
            return -1L;
        }
        interfaceC1999ms.A47(8);
        c04554v.A0f(0);
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 8);
        long sampleDataSize = c04554v.A0N();
        interfaceC1999ms.AK3(((int) chunkHeader.A01) + 8);
        return sampleDataSize;
    }

    public static Pair<Long, Long> A01(InterfaceC1999ms interfaceC1999ms) throws IOException {
        interfaceC1999ms.AIl();
        LO loA03 = A03(1684108385, interfaceC1999ms, new C04554v(8));
        interfaceC1999ms.AK3(8);
        return Pair.create(Long.valueOf(interfaceC1999ms.A8n()), Long.valueOf(loA03.A01));
    }

    public static LO A03(int i3, InterfaceC1999ms interfaceC1999ms, C04554v c04554v) throws IOException {
        LO loA00 = LO.A00(interfaceC1999ms, c04554v);
        while (loA00.A00 != i3) {
            AbstractC04404g.A07(A04(91, 15, 125), A04(40, 28, 39) + loA00.A00);
            long j3 = loA00.A01 + 8;
            if (j3 <= 2147483647L) {
                interfaceC1999ms.AK3((int) j3);
                loA00 = LO.A00(interfaceC1999ms, c04554v);
            } else {
                throw C3K.A00(A04(0, 40, 59) + loA00.A00);
            }
        }
        return loA00;
    }

    public static boolean A06(InterfaceC1999ms interfaceC1999ms) throws IOException {
        C04554v c04554v = new C04554v(8);
        LO loA00 = LO.A00(interfaceC1999ms, c04554v);
        if (loA00.A00 != 1380533830) {
            int i3 = loA00.A00;
            if (A01[1].charAt(26) == 'h') {
                throw new RuntimeException();
            }
            A01[4] = "7d3HBnqB6pKujyEoyh9Hov6";
            if (i3 != 1380333108) {
                return false;
            }
        }
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 4);
        c04554v.A0f(0);
        int iA0C = c04554v.A0C();
        if (iA0C != 1463899717) {
            AbstractC04404g.A05(A04(91, 15, 125), A04(68, 23, 127) + iA0C);
            return false;
        }
        return true;
    }
}
