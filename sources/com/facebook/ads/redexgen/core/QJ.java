package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QJ implements InterfaceC1173Xr {
    public static byte[] A03;
    public int A00;
    public String A01;
    public final InterfaceC1173Xr A02;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-93, -93, -107, -104};
    }

    public QJ(InterfaceC1173Xr interfaceC1173Xr) {
        this.A02 = interfaceC1173Xr;
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.AH8(this.A01 + A00(0, 4, 67) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void AH8(String str) {
        if (AbstractC1175Xt.A0A(str)) {
            A01();
            this.A02.AH8(str);
            return;
        }
        String strA04 = AbstractC1175Xt.A04(str);
        String filtered = this.A01;
        if (strA04.equals(filtered)) {
            this.A00++;
            return;
        }
        A01();
        this.A01 = strA04;
        this.A00 = 1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
