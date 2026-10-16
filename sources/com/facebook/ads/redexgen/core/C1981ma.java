package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1981ma extends AbstractC0772Hu {
    public static byte[] A06;
    public static String[] A07 = {"k0wYTkKie1JHeFYg", "DKl7H6qsoN4MQmGVFxhVfc9YoKR", "eOp5RF4DxMr8YboQGZKTl4GQk1b", "2gSlciuhxyUpZq2z", "EzoVAngWIMXE2t797gVmsxYwwugMTqE8", "YSwU3mnkrzPmwh4w8hA9Gpc9iPzLacTq", "wmfh6", "T9R7fvqNl5WyvyD6SUGUJNeU84vDYmq7"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final C04554v A04;
    public final C04554v A05;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{68, 123, 118, 119, 125, Framer.STDERR_FRAME_PREFIX, 116, 125, 96, Ascii.DEL, 115, 102, Framer.STDERR_FRAME_PREFIX, 124, 125, 102, Framer.STDERR_FRAME_PREFIX, 97, 103, 98, 98, 125, 96, 102, 119, 118, 40, Framer.STDERR_FRAME_PREFIX, 43, 52, 57, 56, Framer.STDERR_FRAME_PREFIX, 114, 60, 43, 62};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.AbstractC0772Hu
    public final boolean A0C(C04554v c04554v, long j3) throws C3K {
        int iA0I = c04554v.A0I();
        long jA0D = j3 + (((long) c04554v.A0D()) * 1000);
        if (iA0I == 0 && !this.A02) {
            C04554v c04554v2 = new C04554v(new byte[c04554v.A07()]);
            c04554v.A0k(c04554v2.A0l(), 0, c04554v.A07());
            C0747Gv c0747GvA00 = C0747Gv.A00(c04554v2);
            this.A01 = c0747GvA00.A02;
            super.A00.A6e(new C03992p().A11(A00(28, 9, 29)).A0w(c0747GvA00.A04).A0r(c0747GvA00.A03).A0f(c0747GvA00.A01).A0Y(c0747GvA00.A00).A12(c0747GvA00.A05).A14());
            this.A02 = true;
            return false;
        }
        if (iA0I != 1 || !this.A02) {
            return false;
        }
        int i3 = this.A00;
        if (A07[1].length() != 27) {
            throw new RuntimeException();
        }
        A07[5] = "ywa4QqUhdtSZ68DIQ13xWUOznnvwilgI";
        boolean z2 = i3 == 1;
        if (A07[2].length() == 28) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "IIAwH";
        strArr[0] = "qu1M6PwQ9kLePSP6";
        if (!this.A03 && !z2) {
            return false;
        }
        byte[] bArrA0l = this.A04.A0l();
        bArrA0l[0] = 0;
        bArrA0l[1] = 0;
        bArrA0l[2] = 0;
        int i4 = 4 - this.A01;
        int i5 = 0;
        while (c04554v.A07() > 0) {
            c04554v.A0k(this.A04.A0l(), i4, this.A01);
            this.A04.A0f(0);
            int iA0L = this.A04.A0L();
            this.A05.A0f(0);
            super.A00.AIr(this.A05, 4);
            super.A00.AIr(c04554v, iA0L);
            i5 = i5 + 4 + iA0L;
        }
        super.A00.AIu(jA0D, z2 ? 1 : 0, i5, 0, null);
        this.A03 = true;
        return true;
    }

    static {
        A01();
    }

    public C1981ma(InterfaceC0755Hd interfaceC0755Hd) {
        super(interfaceC0755Hd);
        this.A05 = new C04554v(HS.A03);
        this.A04 = new C04554v(4);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0772Hu
    public final boolean A0B(C04554v c04554v) throws C1982mb {
        int iA0I = c04554v.A0I();
        int header = iA0I >> 4;
        int frameType = header & 15;
        int i3 = iA0I & 15;
        if (i3 == 7) {
            this.A00 = frameType;
            return frameType != 5;
        }
        throw new C1982mb(A00(0, 28, 82) + i3);
    }
}
