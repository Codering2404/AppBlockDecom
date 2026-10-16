package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public final class B8 extends AbstractC2210qK<Comparable<?>> implements Serializable {
    public static byte[] A00;
    public static String[] A01 = {"VpDQNWoK0mmjrFci3J1ES8becoOn0yPT", "Vr", "", "dVgvDtkQ8cSY7jysLBul", "4dcdEYs2txrJkBrXjBMi1LqbKTa90ufq", "PVumC7zyVZC9p2BLxPfo", "qAFwV", ""};
    public static final B8 A02;
    public static final long serialVersionUID = 0;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.DC2, 47, 57, 56, 47, 52, 51, 58, 115, 51, 60, 41, 40, 47, 60, Framer.STDOUT_FRAME_PREFIX, 117, 116, 115, 47, 56, 43, 56, 47, 46, 56, 117, 116};
    }

    static {
        A02();
        A02 = new B8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2210qK, java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(Comparable<?> left, Comparable<?> right) {
        AbstractC1878ki.A04(left);
        if (left != right) {
            return right.compareTo(left);
        }
        String[] strArr = A01;
        if (strArr[6].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A01[0] = "QsSMXmf1NPN173cjiLSi9PN2wuQJFCPh";
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2210qK
    public final <S extends Comparable<?>> AbstractC2210qK<S> A06() {
        return AbstractC2210qK.A03();
    }

    public final String toString() {
        return A01(0, 28, 44);
    }
}
