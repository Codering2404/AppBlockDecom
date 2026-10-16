package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public final class BB extends AbstractC2210qK<Comparable<?>> implements Serializable {
    public static byte[] A00;
    public static String[] A01 = {"JDLm", "59j9VSz50JRV62zRfQhUHOfkCXfgeUgK", "B91zWfVJnglJ6qaTwxSE2cgOmWPFgOKk", "ELqJY4", "RV9gCl0i3PKSKYNXbtai8ngQK3fccqTs", "fKxm10xyRNZ", "83zGhfyjGQem9Bncw", "2Nxy8TZF5cPmoYOpvxnNSToHaqPSrsmH"};
    public static final BB A02;
    public static final long serialVersionUID = 0;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 85);
            if (A01[5].length() == 31) {
                throw new RuntimeException();
            }
            A01[3] = "F1rbTbQwQjJP2vUBRKO1k8FP";
            bArrCopyOfRange[i6] = b3;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.CR, 48, 38, 39, 48, 43, 44, 37, 108, 44, 35, 54, 55, 48, 35, 46, 106, 107};
    }

    static {
        A02();
        A02 = new BB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2210qK, java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(Comparable<?> left, Comparable<?> right) {
        AbstractC1878ki.A04(left);
        AbstractC1878ki.A04(right);
        return left.compareTo(right);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2210qK
    public final <S extends Comparable<?>> AbstractC2210qK<S> A06() {
        return B8.A02;
    }

    public final String toString() {
        return A01(0, 18, 23);
    }
}
