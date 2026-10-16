package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AM extends C2134p5 {
    public static byte[] A00;
    public static String[] A01 = {"IiHFHpE70aCOc94efxOlf2iC0Ng8zMr5", "b3mzaytlZJgoRVhs4UINeaUr6S0G0E41", "6IHqdrhMw9UxFnoc7iMNxZeDC0DTO0yB", "go0dTVggBQ2s7heaJCrnqGQgIh6JhPx1", "bkC24C7HhnNqTiNutYzB4zMXotuBenI", "te5qRCwogDd297VgLok2fv8nwYFOdDR1", "xjDDw5bsf4CogqtV7hhNk6k9HWMs2JIA", "oLDdWjUmHvVvISH87gP40QDZoo9t6EZz"};

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[0].charAt(11) != 'O') {
                throw new RuntimeException();
            }
            A01[2] = "31sOmOCDO5yq31NNiMqquOfpDH8J50WI";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 39);
            i6++;
        }
    }

    public static void A02() {
        A00 = new byte[]{96, 79, 70, 66, 81, 87, 70, 91, 87, 3, 107, 119, 119, 115, 3, 87, 81, 66, 69, 69, 74, 64, 3, 77, 76, 87, 3, 83, 70, 81, 78, 74, 87, 87, 70, 71, Ascii.CR, 3, 112, 70, 70, 3, 75, 87, 87, 83, 80, Ascii.EM, Ascii.FF, Ascii.FF, 71, 70, 85, 70, 79, 76, 83, 70, 81, Ascii.CR, 66, 77, 71, 81, 76, 74, 71, Ascii.CR, 64, 76, 78, Ascii.FF, 68, 86, 74, 71, 70, Ascii.FF, 87, 76, 83, 74, 64, 80, Ascii.FF, 78, 70, 71, 74, 66, Ascii.FF, 74, 80, 80, 86, 70, 80, Ascii.FF, 64, 79, 70, 66, 81, 87, 70, 91, 87, Ascii.SO, 77, 76, 87, Ascii.SO, 83, 70, 81, 78, 74, 87, 87, 70, 71};
    }

    static {
        A02();
    }

    public AM(IOException iOException, C04685i c04685i) {
        super(A01(0, 121, 4), iOException, c04685i, 2007, 1);
    }
}
