package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2221qX {
    public static byte[] A00;
    public static final C2220qW A01;
    public static final C0C[] A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{79, 75, 80, 72, 77, 74, 10, 86, 65, 66, 72, 65, 71, 80, 10, 78, 82, 73, 10, 77, 74, 80, 65, 86, 74, 69, 72, 10, 118, 65, 66, 72, 65, 71, 80, 77, 75, 74, 98, 69, 71, 80, 75, 86, 93, 109, 73, 84, 72};
    }

    static {
        C2220qW impl;
        try {
            A02();
            Class<?> implClass = Class.forName(A00(0, 49, 40));
            impl = (C2220qW) implClass.newInstance();
        } catch (ClassCastException unused) {
            impl = null;
        } catch (ClassNotFoundException unused2) {
            impl = null;
        } catch (IllegalAccessException unused3) {
            impl = null;
        } catch (InstantiationException unused4) {
            impl = null;
        }
        if (impl == null) {
            impl = new C2220qW();
        }
        A01 = impl;
        A02 = new C0C[0];
    }

    public static String A01(AbstractC03741o abstractC03741o) {
        return A01.A03(abstractC03741o);
    }
}
