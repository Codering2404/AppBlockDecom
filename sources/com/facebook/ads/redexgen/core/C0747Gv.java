package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0747Gv {
    public static byte[] A06;
    public static String[] A07 = {"f", "7N0kip4m3flPJ4wRylUb66l3ycty4bLO", "ZrqOCWQk631j6sxAoqisBRdwge9gr5QF", "2DRaKiCosA9Zs551XHqRbpaUmywwD6L7", "dzNr4lbarI8PqRX9M2ICRMrM1SnLdD", "nBYqh81NM1tC", "zWHuac", "46iX5XNzwkY5yhjGLtKEm3XHMbBVctSm"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final String A04;
    public final List<byte[]> A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0747Gv A00(C04554v c04554v) throws C3K {
        try {
            c04554v.A0g(4);
            int iA0I = (c04554v.A0I() & 3) + 1;
            if (iA0I == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iA0I2 = c04554v.A0I() & 31;
            for (int i3 = 0; i3 < iA0I2; i3++) {
                arrayList.add(A03(c04554v));
            }
            int iA0I3 = c04554v.A0I();
            String[] strArr = A07;
            if (strArr[4].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A07[1] = "rQ6g8gs4UtzNEdd6WIb5nHQ3c92ce055";
            for (int i4 = 0; i4 < iA0I3; i4++) {
                arrayList.add(A03(c04554v));
            }
            int i5 = -1;
            int i6 = -1;
            float f3 = 1.0f;
            String strA01 = null;
            if (iA0I2 > 0) {
                HR hrA09 = HS.A09((byte[]) arrayList.get(0), iA0I, ((byte[]) arrayList.get(0)).length);
                i5 = hrA09.A0A;
                i6 = hrA09.A03;
                f3 = hrA09.A00;
                strA01 = AnonymousClass46.A01(hrA09.A08, hrA09.A01, hrA09.A04);
            }
            return new C0747Gv(arrayList, iA0I, i5, i6, f3, strA01);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw C3K.A01(A01(0, 24, 51), e3);
        }
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-106, -61, -61, -64, -61, 113, -63, -78, -61, -60, -70, -65, -72, 113, -110, -89, -108, 113, -76, -64, -65, -73, -70, -72};
    }

    static {
        A02();
    }

    public C0747Gv(List<byte[]> initializationData, int i3, int i4, int i5, float f3, String str) {
        this.A05 = initializationData;
        this.A02 = i3;
        this.A03 = i4;
        this.A01 = i5;
        this.A00 = f3;
        this.A04 = str;
    }

    public static byte[] A03(C04554v c04554v) {
        int iA0M = c04554v.A0M();
        int offset = c04554v.A09();
        c04554v.A0g(iA0M);
        return AnonymousClass46.A07(c04554v.A0l(), offset, iA0M);
    }
}
