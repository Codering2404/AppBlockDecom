package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0809Jg extends AbstractC1361c3 {
    public static byte[] A00;

    static {
        A0B();
    }

    public static String A0A(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{106, 111, 111, 110, Ascii.DEL, 106, 98, 103, Framer.EXIT_FRAME_PREFIX};
    }

    public abstract void A1R();

    public abstract void A1S();

    public abstract void A1T();

    public abstract boolean A1U();

    public abstract boolean A1V();

    public AbstractC0809Jg(C1365c7 c1365c7, boolean z2) {
        super(c1365c7, z2);
        if (C1098Up.A17(c1365c7.A06())) {
            if (c1365c7.A0B() != null) {
                c1365c7.A0B().setCTAClickListener(getCtaButton());
            }
            getTitleDescContainer().setCTAClickListener(getCtaButton());
        }
    }

    public final void A1Q() {
        if (C1098Up.A17(this.A07.A06()) && this.A07.A0B() != null) {
            this.A07.A0B().setCTAClickListener(getCtaButton());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1361c3
    public ViewOnClickListenerC0846Kr getCtaButton() {
        return super.getCtaButton();
    }

    public void setAdDetailsClickListener(AbstractC1311bF abstractC1311bF) {
        if (C1098Up.A17(this.A07.A06()) && abstractC1311bF != null) {
            abstractC1311bF.setOnClickListener(AbstractC1352bu.A03(getCtaButton(), A0A(0, 9, 29)));
        }
    }

    public void setupNativeCtaExtension(C1486e5 c1486e5) {
    }
}
