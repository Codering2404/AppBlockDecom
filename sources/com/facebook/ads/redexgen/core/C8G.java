package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C8G extends AbstractC1869kY<M5> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{83, 90, 81, 81};
    }

    public C8G(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1869kY
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final C0880Lz A04(M5 m5) {
        return new C0880Lz(this, m5 == null ? A00(0, 4, 114) : m5.A03());
    }
}
