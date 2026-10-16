package com.facebook.ads.redexgen.core;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1915lK implements InterfaceC0850Kv {
    public static byte[] A0F;
    public static String[] A0G = {"mAIJKcC20Y3eOfYyWQRzrg7mLeRMrJFl", "eZxkBrFzPoxgu8goyyke6z3uoIiInH7I", "", "7SF2NgL0Q5eCPREDvftOSH9OstPB", "tBtJ4FuF4UkjOIbBZeVQSFTGpUKvKhYU", "G", "JQCW8upC74KuI6xTj5WGF", "PsTmzjLTY6QrmqAE1gFrtVK8jOOfhc8D"};
    public long A01;
    public InterfaceC0755Hd A02;
    public L2 A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final L9 A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean[] A0E = new boolean[3];
    public final L4 A0A = new L4(7, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    public final L4 A08 = new L4(8, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    public final L4 A09 = new L4(6, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    public long A00 = -9223372036854775807L;
    public final C04554v A07 = new C04554v();

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{60, 35, 46, 47, 37, 101, 43, 60, 41};
    }

    static {
        A02();
    }

    public C1915lK(L9 l9, boolean z2, boolean z3) {
        this.A0B = l9;
        this.A0C = z2;
        this.A0D = z3;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void A01() {
        AbstractC04323y.A02(this.A02);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void A03(long j3, int i3, int i4, long j4) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A04(i4);
            this.A08.A04(i4);
            if (!this.A05) {
                if (this.A0A.A03() && this.A08.A03()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.A0A.A01, this.A0A.A00));
                    arrayList.add(Arrays.copyOf(this.A08.A01, this.A08.A00));
                    HR hrA09 = HS.A09(this.A0A.A01, 3, this.A0A.A00);
                    HQ hqA07 = HS.A07(this.A08.A01, 3, this.A08.A00);
                    this.A02.A6e(new C03992p().A0y(this.A04).A11(A00(0, 9, 116)).A0w(AnonymousClass46.A01(hrA09.A08, hrA09.A01, hrA09.A04)).A0r(hrA09.A0A).A0f(hrA09.A03).A0Y(hrA09.A00).A12(arrayList).A14());
                    this.A05 = true;
                    this.A03.A04(hrA09);
                    this.A03.A03(hqA07);
                    this.A0A.A00();
                    this.A08.A00();
                }
            } else {
                boolean sampleIsKeyFrame = this.A0A.A03();
                if (sampleIsKeyFrame) {
                    this.A03.A04(HS.A09(this.A0A.A01, 3, this.A0A.A00));
                    this.A0A.A00();
                } else if (this.A08.A03()) {
                    this.A03.A03(HS.A07(this.A08.A01, 3, this.A08.A00));
                    this.A08.A00();
                }
            }
        }
        if (this.A09.A04(i4)) {
            byte[] bArr = this.A09.A01;
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "IcPmfl1yBNDnokE5CaufU";
            strArr[2] = "";
            this.A07.A0j(this.A09.A01, HS.A02(bArr, this.A09.A00));
            this.A07.A0f(4);
            this.A0B.A02(j4, this.A07);
        }
        boolean sampleIsKeyFrame2 = this.A03.A07(j3, i3, this.A05, this.A06);
        if (sampleIsKeyFrame2) {
            this.A06 = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void A04(long j3, int i3, long j4) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A01(i3);
            this.A08.A01(i3);
        }
        this.A09.A01(i3);
        this.A03.A02(j3, i3, j4);
    }

    @RequiresNonNull({"sampleReader"})
    private void A05(byte[] bArr, int i3, int i4) {
        if (!this.A05 || this.A03.A06()) {
            this.A0A.A02(bArr, i3, i4);
            this.A08.A02(bArr, i3, i4);
        }
        this.A09.A02(bArr, i3, i4);
        this.A03.A05(bArr, i3, i4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5A(C04554v c04554v) {
        A01();
        int iA09 = c04554v.A09();
        int iA0A = c04554v.A0A();
        byte[] bArrA0l = c04554v.A0l();
        long j3 = this.A01;
        int offset = c04554v.A07();
        this.A01 = j3 + ((long) offset);
        InterfaceC0755Hd interfaceC0755Hd = this.A02;
        int offset2 = c04554v.A07();
        interfaceC0755Hd.AIr(c04554v, offset2);
        while (true) {
            int iA04 = HS.A04(bArrA0l, iA09, iA0A, this.A0E);
            if (iA04 == iA0A) {
                A05(bArrA0l, iA09, iA0A);
                return;
            }
            int lengthToNalUnit = HS.A01(bArrA0l, iA04);
            if (A0G[7].charAt(24) == 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "800XsA7BA4hpamNrxbWO1";
            strArr[2] = "";
            int i3 = iA04 - iA09;
            if (i3 > 0) {
                A05(bArrA0l, iA09, iA04);
            }
            int i4 = iA0A - iA04;
            long j4 = this.A01 - ((long) i4);
            int offset3 = i3 < 0 ? -i3 : 0;
            A03(j4, i4, offset3, this.A00);
            A04(j4, lengthToNalUnit, this.A00);
            iA09 = iA04 + 3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A04 = lg.A04();
        this.A02 = ha.AKS(lg.A03(), 2);
        this.A03 = new L2(this.A02, this.A0C, this.A0D);
        this.A0B.A03(ha, lg);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGq(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.A00 = j3;
        }
        this.A06 |= (i3 & 2) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AJ5() {
        this.A01 = 0L;
        this.A06 = false;
        this.A00 = -9223372036854775807L;
        HS.A0H(this.A0E);
        this.A0A.A00();
        this.A08.A00();
        this.A09.A00();
        if (this.A03 != null) {
            this.A03.A01();
        }
    }
}
