package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0961Pd implements InterfaceC1286aq {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC05096x A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-36, -38, -52, -39, -58, -55, -36, -51, -51, -52, -39, -52, -53, -58, -54, -45, -48, -54, -46, -58, -48, -56, -55, -58, -43, -56, -35, -48, -50, -56, -37, -48, -42, -43};
    }

    public C0961Pd(ViewOnClickListenerC05096x viewOnClickListenerC05096x) {
        this.A00 = viewOnClickListenerC05096x;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF7(String str) {
        this.A00.A0C.setProgress(100);
        ((PZ) this.A00).A05 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF9(String str) {
        ((PZ) this.A00).A05 = true;
        this.A00.A0F.setUrl(str);
        if (this.A00.A00 > 1) {
            this.A00.A0I(A00(0, 34, 31));
        }
        ViewOnClickListenerC05096x.A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFY(int i3) {
        if (((PZ) this.A00).A05) {
            this.A00.A0C.setProgress(i3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFb(String str) {
        this.A00.A0F.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFe() {
        this.A00.A0B.ADJ(14);
    }
}
