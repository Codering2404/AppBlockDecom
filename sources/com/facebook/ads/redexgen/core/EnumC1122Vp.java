package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1122Vp implements Serializable {
    A05(320, 50),
    A08(0, 0),
    A06(-1, 50),
    A07(-1, 90),
    A09(-1, 250);

    public static byte[] A02 = null;
    public static String[] A03 = {"Tf0gzpE1z0DOygMknAScYVGYgxUCN6If", "OJWxv0TW5miQ3Kn", "GlLNElMoCA8", "Xgk0OdYHTIXe2Q1HA3YZKPRbdeS7oU4D", "PHyDcqcelsxe2C8hrB0OPMJ92C1p28xb", "tjympuwDZEvmjp4dt80fu9pzZi", "KXSmHfhq6DtFyO2I4KCsZ7pXn2h8CepA", "nIUh7sEtDWkIx81Fpy5uA9wFEXEhOC2B"};
    public static final long serialVersionUID = 42;
    public final int A00;
    public final int A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[4].charAt(1) == 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "VIfYmPrZv6LGyPijtMThbF852HrrLBlI";
            strArr[6] = "4hX5Bu6XJriXyO1ylOVNaDjvP68bIemq";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 68);
            i6++;
        }
    }

    public static void A01() {
        A02 = new byte[]{Ascii.SI, Ascii.FF, 3, 3, 8, Ascii.US, Ascii.DC2, 126, Ascii.DEL, 125, Ascii.DC2, Framer.EXIT_FRAME_PREFIX, 125, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 61, 61, 54, Framer.ENTER_FRAME_PREFIX, 44, 59, 54, 58, 52, 59, 39, 44, 70, 67, 61, 62, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 58, Framer.STDIN_FRAME_PREFIX, 32, 55, 58, 54, 56, 55, 43, 32, 70, 79, 97, 102, 124, 109, 122, 123, 124, 97, 124, 97, 105, 100, 36, 51, 53, 34, 55, 56, Framer.STDOUT_FRAME_PREFIX, 58, 51, 41, 62, 51, 63, Framer.STDOUT_FRAME_PREFIX, 62, 34, 41, 68, 67, 70};
    }

    static {
        A01();
    }

    EnumC1122Vp(int i3, int i4) {
        this.A01 = i3;
        this.A00 = i4;
    }

    public final int A03() {
        return this.A00;
    }

    public final int A04() {
        return this.A01;
    }
}
