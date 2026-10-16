package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K5 {
    public static String[] A09 = {"UUlEJ3Jo50NOk35TUHs6UNRK6svNK9bY", "Rfapb4gOuHxAcdI53hJjgoF3fgUzCf8l", "549CgiYhO6ZoxkZsxucd", "d0g0H9nuc7MFYEKhz8GgPJKXV4KY3uwa", "SvGPJzr3mUIjg4zk3UE0lmEsGQStmHiR", "UIGV6MTRsZPNdj8JuGQraJXbpN7YiCpC", "sPKUkdPP6cbZl7mqg699SGb1Qg8cwcjc", "pSvb9vtzFVNohJw9Yc2pgYHm"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final C04554v A07 = new C04554v();
    public final int[] A08 = new int[Function.MAX_NARGS];

    /* JADX INFO: Access modifiers changed from: private */
    public void A00(C04554v c04554v, int i3) {
        int totalLength;
        if (i3 < 4) {
            return;
        }
        c04554v.A0g(3);
        int i4 = i3 - 4;
        if ((c04554v.A0I() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            if (i4 < 7 || (totalLength = c04554v.A0K()) < 4) {
                return;
            }
            this.A01 = c04554v.A0M();
            this.A00 = c04554v.A0M();
            this.A07.A0d(totalLength - 4);
            i4 -= 7;
        }
        int limit = this.A07.A09();
        int position = this.A07.A0A();
        if (limit < position && i4 > 0) {
            int iMin = Math.min(i4, position - limit);
            c04554v.A0k(this.A07.A0l(), limit, iMin);
            this.A07.A0f(limit + iMin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01(C04554v c04554v, int i3) {
        if (i3 < 19) {
            return;
        }
        this.A05 = c04554v.A0M();
        this.A04 = c04554v.A0M();
        c04554v.A0g(11);
        this.A02 = c04554v.A0M();
        this.A03 = c04554v.A0M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(C04554v c04554v, int i3) {
        if (i3 % 5 != 2) {
            return;
        }
        c04554v.A0g(2);
        Arrays.fill(this.A08, 0);
        int i4 = i3 / 5;
        for (int index = 0; index < i4; index++) {
            int iA0I = c04554v.A0I();
            int a3 = c04554v.A0I();
            int iA0I2 = c04554v.A0I();
            int iA0I3 = c04554v.A0I();
            int entryCount = iA0I2 - 128;
            int i5 = (int) (((double) a3) + (((double) entryCount) * 1.402d));
            int g3 = (int) ((((double) a3) - (((double) (iA0I3 - 128)) * 0.34414d)) - (((double) (iA0I2 - 128)) * 0.71414d));
            int entryCount2 = c04554v.A0I() << 24;
            this.A08[iA0I] = entryCount2 | (C5C.A07(i5, 0, 255) << 16) | (C5C.A07(g3, 0, 255) << 8) | C5C.A07((int) (((double) a3) + (((double) (iA0I3 - 128)) * 1.772d)), 0, 255);
        }
        this.A06 = true;
    }

    public final C2158pT A06() {
        int iA0I;
        if (this.A05 == 0 || this.A04 == 0 || this.A01 == 0 || this.A00 == 0 || this.A07.A0A() == 0 || this.A07.A09() != this.A07.A0A() || !this.A06) {
            return null;
        }
        this.A07.A0f(0);
        int[] iArr = new int[this.A01 * this.A00];
        int runLength = 0;
        while (runLength < iArr.length) {
            int argbBitmapDataIndex = this.A07.A0I();
            if (argbBitmapDataIndex != 0) {
                int[] argbBitmapData = this.A08;
                iArr[runLength] = argbBitmapData[argbBitmapDataIndex];
                runLength++;
            } else {
                int color = this.A07.A0I();
                if (color != 0) {
                    int i3 = color & 64;
                    String[] strArr = A09;
                    if (strArr[6].charAt(29) == strArr[4].charAt(29)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A09;
                    strArr2[0] = "GtJojiNEMobCnjKA96lXJCCL45Dtio0z";
                    strArr2[1] = "Lfhzohsg2V0yWJPoWAL0pRvwojJGYPpJ";
                    if (i3 == 0) {
                        iA0I = color & 63;
                    } else {
                        iA0I = ((color & 63) << 8) | this.A07.A0I();
                    }
                    Arrays.fill(iArr, runLength, runLength + iA0I, (color & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? 0 : this.A08[this.A07.A0I()]);
                    runLength += iA0I;
                } else {
                    continue;
                }
            }
        }
        return new C04223o().A0D(Bitmap.createBitmap(iArr, this.A01, this.A00, Bitmap.Config.ARGB_8888)).A04(this.A02 / this.A05).A0A(0).A07(this.A03 / this.A04, 0).A09(0).A06(this.A01 / this.A05).A03(this.A00 / this.A04).A0H();
    }

    public final void A07() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0d(0);
        this.A06 = false;
    }
}
