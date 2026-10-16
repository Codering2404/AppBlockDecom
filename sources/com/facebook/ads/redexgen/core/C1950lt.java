package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1950lt extends AbstractC0804Jb {
    public static byte[] A05;
    public static String[] A06 = {"uV3egKqPt", "vbtXlOI", "gip2ILD7nBGTUOP5yb7zSULibNYEk", "ypzju5tbq0Qdtgd67o3qNaulkzBfCJSX", "gCa1Tkio4U0hXnRqOcWVPONwWAtrpMS5", "m", "OXoEHzgO5FTzqO33f", "i"};
    public int A00;
    public C0759Hh A01;
    public C0761Hj A02;
    public C0805Jc A03;
    public boolean A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final C0805Jc A02(C04554v c04554v) throws IOException {
        if (this.A02 == null) {
            this.A02 = AbstractC0762Hk.A06(c04554v);
            return null;
        }
        if (this.A01 == null) {
            this.A01 = AbstractC0762Hk.A04(c04554v);
            return null;
        }
        C0761Hj c0761Hj = this.A02;
        C0759Hh c0759Hh = this.A01;
        byte[] bArr = new byte[c04554v.A0A()];
        System.arraycopy(c04554v.A0l(), 0, bArr, 0, c04554v.A0A());
        return new C0805Jc(c0761Hj, c0759Hh, bArr, AbstractC0762Hk.A0D(c04554v, c0761Hj.A05), AbstractC0762Hk.A00(r6.length - 1));
    }

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{-108, -88, -105, -100, -94, 98, -87, -94, -91, -107, -100, -90};
    }

    static {
        A04();
    }

    public static int A00(byte b3, int i3, int i4) {
        return (b3 >> i4) & (255 >>> (8 - i3));
    }

    public static int A01(byte b3, C0805Jc c0805Jc) {
        if (!c0805Jc.A04[A00(b3, c0805Jc.A00, 1)].A03) {
            int modeNumber = c0805Jc.A02.A03;
            return modeNumber;
        }
        int modeNumber2 = c0805Jc.A02.A04;
        return modeNumber2;
    }

    public static void A05(C04554v c04554v, long j3) {
        if (c04554v.A08() < c04554v.A0A() + 4) {
            c04554v.A0i(Arrays.copyOf(c04554v.A0l(), c04554v.A0A() + 4));
        } else {
            c04554v.A0e(c04554v.A0A() + 4);
        }
        byte[] bArrA0l = c04554v.A0l();
        bArrA0l[c04554v.A0A() - 4] = (byte) (j3 & 255);
        bArrA0l[c04554v.A0A() - 3] = (byte) ((j3 >>> 8) & 255);
        bArrA0l[c04554v.A0A() - 2] = (byte) ((j3 >>> 16) & 255);
        bArrA0l[c04554v.A0A() - 1] = (byte) (255 & (j3 >>> 24));
    }

    public static boolean A06(C04554v c04554v) {
        try {
            return AbstractC0762Hk.A0C(1, c04554v, true);
        } catch (C3K unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    public final long A09(C04554v c04554v) {
        int i3 = 0;
        if ((c04554v.A0l()[0] & 1) == 1) {
            return -1L;
        }
        byte b3 = c04554v.A0l()[0];
        if (A06[4].charAt(1) != 'C') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[0] = "17tCp0Qcd";
        strArr[6] = "uqZ30DdcDRhFwj0kQ";
        int samplesInPacket = A01(b3, (C0805Jc) AbstractC04323y.A02(this.A03));
        if (this.A04) {
            int packetBlockSize = this.A00;
            i3 = (packetBlockSize + samplesInPacket) / 4;
        }
        A05(c04554v, i3);
        this.A04 = true;
        this.A00 = samplesInPacket;
        return i3;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    public final void A0A(long j3) {
        super.A0A(j3);
        this.A04 = j3 != 0;
        this.A00 = this.A02 != null ? this.A02.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    public final void A0B(boolean z2) {
        super.A0B(z2);
        if (z2) {
            this.A03 = null;
            this.A02 = null;
            this.A01 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C04554v c04554v, long j3, C0803Ja c0803Ja) throws IOException {
        if (this.A03 != null) {
            AbstractC04323y.A01(c0803Ja.A00);
            return false;
        }
        this.A03 = A02(c04554v);
        if (this.A03 == null) {
            return true;
        }
        C0805Jc c0805Jc = this.A03;
        C0761Hj c0761Hj = c0805Jc.A02;
        ArrayList<byte[]> codecInitializationData = new ArrayList<>();
        codecInitializationData.add(c0761Hj.A09);
        codecInitializationData.add(c0805Jc.A03);
        c0803Ja.A00 = new C03992p().A11(A03(0, 12, 22)).A0a(c0761Hj.A02).A0j(c0761Hj.A00).A0b(c0761Hj.A05).A0m(c0761Hj.A06).A12(codecInitializationData).A0v(AbstractC0762Hk.A02(MetaExoPlayerCustomizedCollections.A02(c0805Jc.A01.A02))).A14();
        return true;
    }
}
