package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC2136p7 implements Iterator<Object> {
    A03;

    public static byte[] A00;
    public static String[] A01 = {"MtVTs5cDzTkaqvg8NuH3vwobapVBE0st", "ArMYDbI1ZOKb1PqTCippk6Br36HImDMz", "toSUZKKd1UGhUJ4QalyaWathzboIF5UW", "VPzDHjdriWPgU4d", "Di5eRoJ6h3CuCR5uxiNB2s29p0t6qO11", "B6Kcd5hxdA7PPWxpRUkmfJ1syAdRnb1r", "u5nu3DOOZeH", "WD4F9WHgG47OHFbe2E6bcqFaZ5qcCEPl"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = (bArrCopyOfRange[i6] ^ i5) ^ 118;
            if (A01[4].charAt(4) != 'R') {
                throw new RuntimeException();
            }
            A01[6] = "SHVGlB8lB2rly5Sbj1O4M1TTC2AUnN6";
            bArrCopyOfRange[i6] = (byte) i7;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{98, 101, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 106, 101, 104, 110};
    }

    static {
        A01();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        AbstractC2025nJ.A04(false);
    }
}
