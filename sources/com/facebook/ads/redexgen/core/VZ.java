package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class VZ implements InterfaceC1046Sp {
    public static byte[] A03;
    public static String[] A04 = {"mqH0C", "P", "Prv4rgxv4XvjDltPpSeqnrL7fWipLvZ8", "wRAQVkTW0Fdys8", "msKGEa7u", "", "70lhKNnmmmhMBIKZ0qoNvOWwjw91iHAS", "ylnG6cBHFe0YAiTdKU1DLGP7G6QidCUo"};
    public final /* synthetic */ C1830ju A00;
    public final /* synthetic */ UK A01;
    public final /* synthetic */ boolean A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{Ascii.FS, 55, 63, 66, 59, 58, -10, 74, 69, -10, 58, 69, 77, 68, 66, 69, 55, 58, -10, 55, -10, 67, 59, 58, 63, 55, 4};
    }

    static {
        A01();
    }

    public VZ(UK uk, C1830ju c1830ju, boolean z2) {
        this.A01 = uk;
        this.A00 = c1830ju;
        this.A02 = z2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADL() {
        if (this.A01.A0e != null) {
            this.A01.A0e.A0J();
            this.A01.A0e = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, 111);
        this.A01.A0g.A0F().A3N(Y1.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        if (this.A01.A0I != null) {
            this.A01.A0I.ADp(C1120Vm.A01(adErrorType, strA00));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADT() {
        this.A01.A0e = this.A00;
        if (this.A02 && this.A01.A0B != null) {
            this.A01.A0B.A0L();
        }
        if (this.A01.A0I != null) {
            if (this.A01.A0G.equals(VW.A04) && !this.A01.A0r()) {
                this.A01.A0I.AEq();
            }
            if (this.A02) {
                UK uk = this.A01;
                String[] strArr = A04;
                if (strArr[4].length() != strArr[0].length()) {
                    String[] strArr2 = A04;
                    strArr2[4] = "lirdd0Qr";
                    strArr2[0] = "muvxx";
                    if (C1098Up.A1s(uk.A0g) && this.A01.A13() != null && this.A01.A13().A1g()) {
                        this.A01.A0P = AbstractC1433dD.A01(this.A01.A0g, this.A01.A13(), 4, new C1124Vr(this));
                        return;
                    } else {
                        UK uk2 = this.A01;
                        if (A04[3].length() != 28) {
                            A04[6] = "Y1qaffLCA6OgZ6gO9VGOLjOrervRHVYN";
                            uk2.A0I.ACq();
                            return;
                        }
                    }
                }
                throw new RuntimeException();
            }
        }
    }
}
