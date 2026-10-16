package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class HL {
    public static byte[] A09;
    public static String[] A0A = {"EsB1Svc2O0r", "neXgiGAVZF2hPSW", "e5UrGC6TzR", "xWVfqfZ1XD25z1nFBwMIBfHnywy3RQhb", "m9mgew9TdIxun9z0pjAF4NJPGlbJBstI", "nE", "RVA0jPrNpk", "4CgUEtTVWe3Kq65nNHH5xBV3YKPxdnIZ"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final String A07;
    public final List<byte[]> A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static HL A00(C04554v c04554v) throws C3K {
        try {
            c04554v.A0g(21);
            int iA0I = c04554v.A0I() & 3;
            int iA0I2 = c04554v.A0I();
            int i3 = 0;
            int iA09 = c04554v.A09();
            for (int i4 = 0; i4 < iA0I2; i4++) {
                c04554v.A0g(1);
                int iA0M = c04554v.A0M();
                for (int i5 = 0; i5 < iA0M; i5++) {
                    int iA0M2 = c04554v.A0M();
                    i3 += iA0M2 + 4;
                    c04554v.A0g(iA0M2);
                }
            }
            c04554v.A0f(iA09);
            byte[] bArr = new byte[i3];
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            float f3 = 1.0f;
            String strA03 = null;
            for (int i12 = 0; i12 < iA0I2; i12++) {
                int iA0I3 = c04554v.A0I() & 63;
                int iA0M3 = c04554v.A0M();
                for (int i13 = 0; i13 < iA0M3; i13++) {
                    int iA0M4 = c04554v.A0M();
                    System.arraycopy(HS.A03, 0, bArr, i6, HS.A03.length);
                    int length = i6 + HS.A03.length;
                    System.arraycopy(c04554v.A0l(), c04554v.A09(), bArr, length, iA0M4);
                    if (iA0I3 == 33 && i13 == 0) {
                        HP hpA05 = HS.A05(bArr, length, length + iA0M4);
                        i7 = hpA05.A0A;
                        i8 = hpA05.A08;
                        i9 = hpA05.A02;
                        i10 = hpA05.A01;
                        i11 = hpA05.A03;
                        f3 = hpA05.A00;
                        strA03 = AnonymousClass46.A03(hpA05.A07, hpA05.A0B, hpA05.A06, hpA05.A05, hpA05.A0C, hpA05.A04);
                    }
                    i6 = length + iA0M4;
                    c04554v.A0g(iA0M4);
                }
            }
            return new HL(i3 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iA0I + 1, i7, i8, f3, strA03, i9, i10, i11);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw C3K.A01(A01(0, 25, 126), e3);
        }
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0A[5].length() == 29) {
                throw new RuntimeException();
            }
            A0A[5] = "YyBlh7kREcvGfk8zeLahZrRMr2fR36";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 68);
            i6++;
        }
    }

    public static void A02() {
        A09 = new byte[]{Ascii.DEL, 72, 72, 85, 72, Ascii.SUB, 74, 91, 72, 73, 83, 84, 93, Ascii.SUB, 114, Ascii.DEL, 108, 121, Ascii.SUB, 89, 85, 84, 92, 83, 93};
    }

    static {
        A02();
    }

    public HL(List<byte[]> initializationData, int i3, int i4, int i5, float f3, String str, int i6, int i7, int i8) {
        this.A08 = initializationData;
        this.A05 = i3;
        this.A06 = i4;
        this.A04 = i5;
        this.A00 = f3;
        this.A07 = str;
        this.A02 = i6;
        this.A01 = i7;
        this.A03 = i8;
    }
}
