package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class I1 implements InterfaceC1286aq {
    public static byte[] A01;
    public static String[] A02 = {"BeK4HZWWIRhrC207wWuIOn", "ZxUaKMHZMCvHIxTDkc1UvZSYXikI2iYM", "xy0Ab8m7NOX4ZRxTfyGPwRY1TRrgVPC4", "ij8auLNb9rfA8yI55JUjNirWgnYpCp0M", "e9T4yeifuMgQg3dKDn6E2LsVBs4fgiHR", "ibrxpSG6qut0wBAmR6wSiB8exNotCqiu", "LMYPYXdb4SaVI93FsN1uYFih9", "8N3vGs6nddgUWUG"};
    public final /* synthetic */ C5F A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[6].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A02[2] = "F3dYTVgRpzEGoEWMN2T8FFCtbrhRHRBi";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 99);
            i6++;
        }
    }

    public static void A01() {
        A01 = new byte[]{Ascii.NAK, 19, 5, Ascii.DC2, 63, Ascii.SO, 1, Ascii.SYN, 9, 7, 1, Ascii.DC4, 9, Ascii.SI, Ascii.SO, 63, 9, 1, 2};
    }

    static {
        A01();
    }

    public I1(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF7(String str) {
        this.A00.A0Q = false;
        this.A00.A0F.setProgress(100);
        YB.A0O(this.A00.A0F, 8);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF9(String str) {
        this.A00.A0Q = true;
        YB.A0O(this.A00.A0F, 0);
        this.A00.A0E.setUrl(str);
        if (!this.A00.A0P) {
            C5F c5f = this.A00;
            if (A02[5].charAt(30) != 'i') {
                throw new RuntimeException();
            }
            A02[7] = "LFtEVX0D7i5Pos5vlgnVVb1H7Q5y";
            if (c5f.A02 > 1) {
                this.A00.A0P = true;
                this.A00.A0i(A00(0, 19, 3));
            }
        }
        C5F.A05(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFY(int i3) {
        if (this.A00.A0Q) {
            this.A00.A0F.setProgress(i3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFb(String str) {
        this.A00.A0E.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFe() {
        ((AbstractC0787Ij) this.A00).A0B.ADJ(14);
    }
}
