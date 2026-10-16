package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.AccessTokenManager;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XP implements VM {
    public static byte[] A04;
    public static String[] A05 = {"HMqNF3eSIzlMBYXVNU3nP1NvWYo5", "x1o785RKTr7Jq0RcU0BPUyycJ3fBjUeE", "GBfmO3K", "Po", "VaaklUluHJvo1XkXnH3kavV5L6d7gpHG", "rG9SvJ3uZ6", "s9MPDvRc6n", "AU4sbnw7bsTTRuLyXll9UaPcK28fS"};
    public static final String A06;
    public ViewOnAttachStateChangeListenerC1160Xe A00;
    public C2257rN<C1105Uw, V1> A01;
    public final C1644ge A02;
    public final C0588Ao A03 = C0588Ao.A01();

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[1].length() == 18) {
                throw new RuntimeException();
            }
            A05[1] = "YaUcq3PJYQGMSsmKTTLasxzUL6lFeW7O";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 121);
            i6++;
        }
    }

    public static void A02() {
        A04 = new byte[]{79, 115, 126, 59, 118, 126, Ascii.DEL, 114, 122, 59, Framer.EXIT_FRAME_PREFIX, 105, 126, 122, 111, 114, 109, 126, 59, 109, 114, 126, 108, 59, 114, 104, 59, 117, 110, 119, 119, 53, 121, 66, 94, 73, 75, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 88, 73, 94, 69, 66, 75, Ascii.FF, 77, Ascii.FF, 66, 89, 64, 64, Ascii.FF, 79, 94, 73, 77, 88, 69, 90, 73, Ascii.FF, 90, 69, 73, 91, Ascii.CR, 83, 108, 96, 114, 117, 106, 108, 107, 113, 65, 100, 113, 100, 37, 108, 118, 37, 107, 112, 105, 105, 36, Ascii.EM, Ascii.SI, 9, 5, 4, Ascii.SO, 53, 9, 2, Ascii.VT, 4, 4, Ascii.SI, 6};
    }

    static {
        A02();
        A06 = XP.class.getSimpleName();
    }

    public XP(C1644ge c1644ge) {
        this.A02 = c1644ge;
    }

    private void A01() {
        this.A02.A08().ABC(A00(89, 14, 19), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(67, 22, 124)));
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void ADb() {
        if (this.A01 != null) {
            this.A01.A07.A00();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AGc() {
        if (this.A01 != null) {
            this.A01.A07.A03();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKU(View view) {
        if (this.A01 == null) {
            this.A02.A08().ABC(A00(89, 14, 19), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(32, 35, 85)));
            return;
        }
        this.A03.A08(view);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKn(View view, String str, boolean z2) {
        AKo(view, str, z2, false);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKo(View view, String str, boolean z2, boolean z3) {
        AKp(view, str, z2, z3, false);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKp(View view, String str, boolean z2, boolean z3, boolean z4) {
        if (view != null) {
            this.A00 = new ViewOnAttachStateChangeListenerC1160Xe(view, this.A02);
            this.A03.A0A(this.A00, view);
            if (z3) {
                this.A00.A04();
            }
            this.A01 = C2257rN.A00(new C1105Uw(this.A02, view, str, z2, z4), new V1(), A06).A06(new C1161Xf(new XM())).A07();
            this.A03.A09(view, this.A01);
            return;
        }
        this.A02.A08().ABC(A00(89, 14, 19), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(0, 32, 98)));
    }
}
