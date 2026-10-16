package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1606g2 {
    public static byte[] A07;
    public static String[] A08 = {"H9a6GPEeuBppqgml", "UMFfHf9K0rtxTnfS4GQ", "HJf7oQJhMr6BjfdBAkNXb1VX0FlaYu0s", "mblZ", "lDa8BWO3GNKgBVoNV1FydEibnHhzaqpi", "BpHqCYEOVY5", "fQPNbuq5zM2Vt99anBRO7vAhC8TCHPEC", "oGui3UnSaV6fb7qd5azTuEEp3mm97meQ"};
    public InterfaceC1597ft A05;
    public int A04 = 60000;
    public int A03 = 100;
    public int A00 = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
    public int A02 = 8000;
    public int A01 = 3;
    public Map<String, String> A06 = new HashMap();

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 100);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{4, 40, Framer.STDOUT_FRAME_PREFIX, 32, 36, 60, 36, 105, 59, 44, 61, 59, 32, 44, 58, 105, 36, 60, 58, 61, 105, 43, 44, 105, 43, 44, 61, 62, 44, 44, 39, 105, Framer.EXIT_FRAME_PREFIX, 105, 40, 39, Framer.STDIN_FRAME_PREFIX, 105, Framer.EXIT_FRAME_PREFIX, 113};
        if (A08[3].length() != 4) {
            throw new RuntimeException();
        }
        A08[4] = "ylxMzgRnic8ELdWNUfQitMVfYj0C1DI2";
    }

    static {
        A01();
    }

    public final C1606g2 A02(int i3) {
        this.A00 = i3;
        return this;
    }

    public final C1606g2 A03(int i3) {
        if (i3 >= 1 && i3 <= 18) {
            this.A01 = i3;
            return this;
        }
        throw new IllegalArgumentException(A00(0, 40, 45));
    }

    public final C1606g2 A04(int i3) {
        this.A02 = i3;
        return this;
    }

    public final C1606g2 A05(int i3) {
        this.A03 = i3;
        return this;
    }

    public final C1606g2 A06(int i3) {
        this.A04 = i3;
        return this;
    }

    public final C1606g2 A07(InterfaceC1597ft interfaceC1597ft) {
        this.A05 = interfaceC1597ft;
        return this;
    }

    public final C1606g2 A08(Map<String, String> requestHeaders) {
        this.A06 = requestHeaders;
        return this;
    }

    public final C1607g3 A09() {
        return new C1607g3(this.A04, this.A00, this.A02, this.A03, this.A01, this.A06, this.A05);
    }
}
