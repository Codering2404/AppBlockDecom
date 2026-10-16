package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MI implements InterfaceC1190Yi {
    public static byte[] A0D;
    public int A00;
    public C0695Eu A01;
    public C4L A02;
    public String A03;
    public final C1648gi A04;
    public final VA A05;
    public final InterfaceC1189Yh A06;
    public final ZP A07;
    public final C0685Ek A08;
    public final E2 A0C = new E2() { // from class: com.facebook.ads.redexgen.X.6d
        public static byte[] A01;

        static {
            A01();
        }

        public static String A00(int i3, int i4, int i5) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 58);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{115, 108, 97, 96, 106, 76, 107, 113, 96, 119, 118, 113, 108, 113, 100, 105, 64, 115, 96, 107, 113};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(E3 e3) {
            this.A00.A06.A4k(A00(0, 21, 63), e3);
        }
    };
    public final E4 A0B = new E4() { // from class: com.facebook.ads.redexgen.X.6a
        public static byte[] A01;

        static {
            A01();
        }

        public static String A00(int i3, int i4, int i5) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 120);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{38, 57, 52, 53, 63, Ascii.EM, 62, 36, 53, 34, 35, 36, 57, 36, Framer.STDOUT_FRAME_PREFIX, 60, Ascii.NAK, 38, 53, 62, 36};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(C4B c4b) {
            this.A00.A06.A4k(A00(0, 21, 40), c4b);
        }
    };
    public final EA A09 = new EA() { // from class: com.facebook.ads.redexgen.X.6Z
        public static byte[] A01;
        public static String[] A02 = {"cVYzzU3WDwilAiB6lBwH", "ltb11yKnDLf", "qD1l7ddw57WScFbFlpW6gLQQ4LJZYMm4", "7tmDLtuP1dSUokfmYRKMMhnjp75BOUEQ", "O1T", "OUAaXGhWo5xW6BfvCbr", "NPW6PnCzVK8iTd9b27h5", "ykk8Miz3Z2gvnB5Rb4Sxgn912BIo"};

        public static String A00(int i3, int i4, int i5) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
            for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                int i7 = bArrCopyOfRange[i6] ^ i5;
                if (A02[2].charAt(8) != '5') {
                    throw new RuntimeException();
                }
                A02[5] = "7KI0j9KfVtSFY3dF";
                bArrCopyOfRange[i6] = (byte) (i7 ^ 70);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{3, Ascii.FS, 17, Ascii.DLE, Ascii.SUB, 60, Ascii.ESC, 1, Ascii.DLE, 7, 6, 1, Ascii.FS, 1, Ascii.DC4, Ascii.EM, 48, 3, Ascii.DLE, Ascii.ESC, 1};
        }

        static {
            A01();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A03(C4K c4k) {
            this.A00.A06.A4k(A00(0, 21, 51), c4k);
        }
    };
    public final E8 A0A = new E8() { // from class: com.facebook.ads.redexgen.X.6Y
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.core.UN
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A03(E9 e9) {
            this.A00.A07.ADv();
        }
    };

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{44, 56, 57, 34, 61, Framer.ENTER_FRAME_PREFIX, 44, 52, 122, 117, 112, 124, 119, 109, 77, 118, 114, 124, 119, Ascii.DC4, Ascii.DC2, 4, 47, 0, Ascii.NAK, 8, Ascii.ETB, 4, 34, Ascii.NAK, 0, 35, Ascii.DC4, Ascii.NAK, Ascii.NAK, Ascii.SO, Ascii.SI, 55, 40, 37, 36, 46, 8, 47, 53, 36, 51, Framer.STDERR_FRAME_PREFIX, 53, 40, 53, 32, Framer.STDIN_FRAME_PREFIX, 4, 55, 36, 47, 53, 81, 78, 67, 66, 72, 107, 72, 64, 64, 66, 85, 116, 107, 102, 103, 109, 79, 82, 70, 103, Framer.EXIT_FRAME_PREFIX, 117, 116, 126, 66, 116, 116, 122, 69, Framer.EXIT_FRAME_PREFIX, 124, 116, 63, 32, Framer.STDIN_FRAME_PREFIX, 44, 38, Ascii.FS, Ascii.ESC, 5};
    }

    public MI(C1648gi c1648gi, ZP zp, VA va, InterfaceC1189Yh interfaceC1189Yh) {
        this.A04 = c1648gi;
        this.A05 = va;
        this.A07 = zp;
        this.A08 = new C0685Ek(c1648gi);
        this.A08.A0f(new C04243q(c1648gi));
        this.A08.getEventBus().A03(this.A0C, this.A0B, this.A09, this.A0A);
        this.A06 = interfaceC1189Yh;
        this.A08.setIsFullScreen(true);
        this.A08.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        interfaceC1189Yh.A45(this.A08, layoutParams);
        C1197Yp closeButton = new C1197Yp(c1648gi);
        closeButton.setOnClickListener(new ZN(this));
        RelativeLayout.LayoutParams params = closeButton.getDefaultLayoutParams();
        interfaceC1189Yh.A45(closeButton, params);
    }

    public final void A04(int i3) {
        this.A08.setVideoProgressReportIntervalMs(i3);
    }

    public final void A05(View view) {
        this.A08.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AAu(Intent intent, Bundle bundle, C1010Re c1010Re) {
        String ctaText = A02(8, 11, 127);
        if (bundle == null) {
            this.A03 = intent.getStringExtra(ctaText);
        } else {
            this.A03 = bundle.getString(ctaText);
        }
        String stringExtra = intent.getStringExtra(A02(19, 18, 7));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            C1484e3 c1484e3 = new C1484e3(this.A04, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i3 = (int) (16.0f * XX.A02);
            layoutParams.setMargins(i3, i3, i3, i3);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            c1484e3.setOnClickListener(new ZO(this));
            this.A06.A45(c1484e3, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 119), 0);
        this.A02 = new C4L(this.A04, this.A05, this.A08, this.A03, intent.getBundleExtra(A02(58, 11, 65)), null);
        if (C1098Up.A20(this.A04)) {
            this.A01 = new C0695Eu(this.A04, this.A05, this.A08, this.A03, false, this.A02, null);
        } else {
            this.A01 = null;
        }
        this.A08.setVideoMPD(intent.getStringExtra(A02(69, 8, 100)));
        this.A08.setVideoURI(intent.getStringExtra(A02(90, 8, 47)));
        if (this.A00 > 0) {
            this.A08.A0a(this.A00);
        }
        if (intent.getBooleanExtra(A02(0, 8, 43), false)) {
            this.A08.A0e(EnumC1535et.A04, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFA(boolean z2) {
        this.A06.A4k(A02(37, 21, 39), new E6());
        this.A08.A0X();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFi(boolean z2) {
        this.A06.A4k(A02(37, 21, 39), new E5());
        if (!this.A08.A0o()) {
            this.A08.A0e(EnumC1535et.A04, 18);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final String getCurrentClientToken() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final boolean onActivityResult(int i3, int i4, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void onDestroy() {
        this.A06.A4k(A02(37, 21, 39), new C0673Dy(this.A00, this.A08.getCurrentPositionInMillis()));
        this.A02.A0j(this.A08.getCurrentPositionInMillis());
        if (this.A01 != null) {
            this.A01.A08();
        }
        this.A08.A0b(1);
        this.A08.A0W();
    }
}
