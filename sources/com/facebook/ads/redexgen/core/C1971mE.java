package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public final class C1971mE extends AbstractC0797Iu {
    public static byte[] A03;
    public static String[] A04 = {"GA2pmS7X4ROGOgByNCdi18taC", "aAh4RNygY6pz4IdlAQ9iIXEvCFWWkzLF", "JuodTrkofMpjka010", "J1Lmlws0eqmUUC5GC3jhEdxTYojxk4jf", "6Ya7uqSvo", "3XyRCMiSsp8rG7f8J4q6xkUhsqnZzFaE", "VspF2Q", "vTSdivoAe22KROlTGGoK4NP8GmV"};
    public final long A00;
    public final List<C1971mE> A01;
    public final List<C1970mD> A02;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{68, 7, Ascii.VT, 10, Ascii.DLE, 5, Ascii.CR, 10, 1, Ascii.SYN, Ascii.ETB, 94, 68, 105, 37, 44, 40, 63, 44, 58, 115, 105};
    }

    static {
        A05();
    }

    public C1971mE(int i3, long j3) {
        super(i3);
        this.A00 = j3;
        this.A02 = new ArrayList();
        this.A01 = new ArrayList();
    }

    public final C1971mE A06(int i3) {
        int size = this.A01.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1971mE c1971mE = this.A01.get(i4);
            int i5 = A04[7].length();
            if (i5 == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[1] = "n49CDGF4gSULbNzRfDOXSmTNWTogkE10";
            strArr[3] = "P3Agw1JJwclCkyu9DcuVtuUqOjxfkaYK";
            C1971mE c1971mE2 = c1971mE;
            int childrenSize = ((AbstractC0797Iu) c1971mE2).A00;
            if (childrenSize == i3) {
                return c1971mE2;
            }
        }
        if (A04[4].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "eWhxbLiQvYVwUHrDqb1spRuVxj0ikF7I";
        strArr2[3] = "G0JrlMiW26lgTwAQcPtVzhOkcvjPkvCh";
        return null;
    }

    public final C1970mD A07(int i3) {
        int size = this.A02.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1970mD c1970mD = this.A02.get(i4);
            String[] strArr = A04;
            String str = strArr[2];
            String str2 = strArr[0];
            int i5 = str.length();
            int childrenSize = str2.length();
            if (i5 == childrenSize) {
                throw new RuntimeException();
            }
            A04[5] = "r5cbbIuLaeCnR7fWkiITKmUfsEKVcSuB";
            int childrenSize2 = ((AbstractC0797Iu) c1970mD).A00;
            if (childrenSize2 == i3) {
                return c1970mD;
            }
        }
        return null;
    }

    public final void A08(C1971mE c1971mE) {
        this.A01.add(c1971mE);
    }

    public final void A09(C1970mD c1970mD) {
        this.A02.add(c1970mD);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0797Iu
    public final String toString() {
        return AbstractC0797Iu.A02(super.A00) + A04(13, 9, 29) + Arrays.toString(this.A02.toArray()) + A04(0, 13, 48) + Arrays.toString(this.A01.toArray());
    }
}
