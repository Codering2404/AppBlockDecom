package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1953lw implements H9 {
    public static byte[] A03;
    public static String[] A04 = {"IFBRawCVF0AWJOiiVagp2bzm1iWWQKSj", "auHMqC8YUXWsvqiTg7", "x05hwyQceYKgfv4KdHsaZDzMFYGIFABO", "EiWauAjA92n8uYBsDF1eTop4V9uY", "nHLlm8XHOjaWHtwU5p4BIc0GM3UweWlu", "dBwF9hq9j3gGLabp", "n4a5QuSOEmxq5i2DA2", "Zy0ftHIbrTR5qGqkd"};
    public static final HD A05;
    public HA A00;
    public AbstractC0804Jb A01;
    public boolean A02;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[3].length() == 20) {
                throw new RuntimeException();
            }
            A04[3] = "IEdap1c7a0gADNuxefg";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 36);
            i6++;
        }
    }

    public static void A02() {
        A03 = new byte[]{96, 71, 79, 74, 67, 66, 6, 82, 73, 6, 66, 67, 82, 67, 84, 75, 79, 72, 67, 6, 68, 79, 82, 85, 82, 84, 67, 71, 75, 6, 82, Framer.STDIN_REQUEST_FRAME_PREFIX, 86, 67};
    }

    static {
        A02();
        A05 = new HD() { // from class: com.facebook.ads.redexgen.X.lx
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1953lw.A04();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public static C04554v A00(C04554v c04554v) {
        c04554v.A0f(0);
        return c04554v;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    private boolean A03(InterfaceC1999ms interfaceC1999ms) throws IOException {
        JX jx = new JX();
        if (!jx.A05(interfaceC1999ms, true) || (jx.A04 & 2) != 2) {
            return false;
        }
        int length = Math.min(jx.A00, 8);
        C04554v c04554v = new C04554v(length);
        interfaceC1999ms.AGt(c04554v.A0l(), 0, length);
        if (C1955ly.A01(A00(c04554v))) {
            this.A01 = new C1955ly();
        } else if (C1950lt.A06(A00(c04554v))) {
            this.A01 = new C1950lt();
        } else {
            if (!C1952lv.A02(A00(c04554v))) {
                return false;
            }
            this.A01 = new C1952lv();
        }
        return true;
    }

    public static /* synthetic */ H9[] A04() {
        return new H9[]{new C1953lw()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A00 = ha;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        AbstractC04323y.A02(this.A00);
        if (this.A01 == null) {
            if (A03(interfaceC1999ms)) {
                interfaceC1999ms.AIl();
            } else {
                throw C3K.A01(A01(0, 34, 2), null);
            }
        }
        boolean z2 = this.A02;
        if (A04[0].charAt(6) == 'U') {
            throw new RuntimeException();
        }
        A04[5] = "ISTJLhLpuA8o4P7J";
        if (!z2) {
            InterfaceC0755Hd interfaceC0755HdAKS = this.A00.AKS(0, 1);
            this.A00.A6O();
            this.A01.A08(this.A00, interfaceC0755HdAKS);
            this.A02 = true;
        }
        return this.A01.A04(interfaceC1999ms, hv);
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j3, long j4) {
        if (this.A01 != null) {
            this.A01.A07(j3, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        try {
            return A03(interfaceC1999ms);
        } catch (C3K unused) {
            return false;
        }
    }
}
