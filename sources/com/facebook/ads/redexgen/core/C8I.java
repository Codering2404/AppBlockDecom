package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C8I extends AbstractC1869kY<EnumC0872Lr> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-56, -49, -58, -58};
    }

    public C8I(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1869kY
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final C0880Lz A04(EnumC0872Lr enumC0872Lr) {
        return new C0880Lz(this, enumC0872Lr == null ? A00(0, 4, 46) : A00(0, 0, 18) + enumC0872Lr.A03());
    }
}
