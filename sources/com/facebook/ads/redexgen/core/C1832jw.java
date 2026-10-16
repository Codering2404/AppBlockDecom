package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1832jw implements InterfaceC1046Sp {
    public static byte[] A04;
    public final /* synthetic */ N9 A00;
    public final /* synthetic */ AnonymousClass80 A01;
    public final /* synthetic */ AnonymousClass76 A02;
    public final /* synthetic */ Z2 A03;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-109, -82, -74, -71, -78, -79, 109, -63, -68, 109, -79, -68, -60, -69, -71, -68, -82, -79, 109, -82, 109, -70, -78, -79, -74, -82, 123};
    }

    public C1832jw(AnonymousClass80 anonymousClass80, Z2 z2, N9 n9, AnonymousClass76 anonymousClass76) {
        this.A01 = anonymousClass80;
        this.A03 = z2;
        this.A00 = n9;
        this.A02 = anonymousClass76;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADL() {
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, 69);
        this.A02.A0F().A3N(Y1.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        this.A00.AEN(this.A01, C1120Vm.A01(adErrorType, strA00));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1046Sp
    public final void ADT() {
        this.A03.A0J();
        this.A00.ADD(this.A01, this.A03);
        this.A02.A0F().A4O(this.A01.A01 != null);
    }
}
