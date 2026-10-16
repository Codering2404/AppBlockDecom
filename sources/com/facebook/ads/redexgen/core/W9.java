package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class W9 {
    public static boolean A00;
    public static byte[] A01;
    public static final Map<String, Long> A02;
    public static final Map<String, Long> A03;
    public static final Map<String, String> A04;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{96, 54, Ascii.DEL, 96, 54, Ascii.DEL, 96, Framer.ENTER_FRAME_PREFIX, Ascii.DEL, 96, Framer.ENTER_FRAME_PREFIX, Ascii.DEL, 96, Framer.ENTER_FRAME_PREFIX, 82, 92, 4, 92, 0, 87, 85, 85, Ascii.VT, Framer.STDIN_FRAME_PREFIX, 55, 48, 57, 126, Framer.STDERR_FRAME_PREFIX, 63, Framer.STDIN_FRAME_PREFIX, 42, 126, 63, 58, 126, 44, 59, Framer.STDIN_FRAME_PREFIX, 46, Framer.STDOUT_FRAME_PREFIX, 48, Framer.STDIN_FRAME_PREFIX, 59, 65, 67, 82, 106, 71, 85, 82, 116, 67, 85, 86, 73, 72, 85, 67};
    }

    static {
        A04();
        A03 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
        A04 = new ConcurrentHashMap();
        A00 = false;
    }

    public static long A00(String str, EnumC1123Vq enumC1123Vq) {
        if (A03.containsKey(str)) {
            return A03.get(str).longValue();
        }
        switch (enumC1123Vq) {
            case A0E:
            case A0F:
            case A0G:
            case A0D:
                return 15000L;
            default:
                return -1000L;
        }
    }

    public static String A02(WA wa) {
        AbstractC1131Vy.A05(A01(44, 15, 126), A01(22, 22, 6), A01(14, 8, 61));
        return A04.get(A03(wa));
    }

    public static String A03(WA wa) {
        return String.format(Locale.US, A01(0, 14, 29), wa.A09(), wa.A07(), Integer.valueOf(wa.A08() == null ? 0 : wa.A08().A00()), Integer.valueOf(wa.A08() == null ? 0 : wa.A08().A01()), Integer.valueOf(wa.A04()));
    }

    public static void A05(long j3, WA wa) {
        A03.put(A03(wa), Long.valueOf(j3));
    }

    public static void A06(WA wa) {
        A02.put(A03(wa), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A07(String str, WA wa) {
        A04.put(A03(wa), str);
    }

    public static boolean A08(WA wa) {
        if (A00) {
            return false;
        }
        String strA03 = A03(wa);
        if (A02.containsKey(strA03)) {
            return System.currentTimeMillis() - A02.get(strA03).longValue() < A00(strA03, wa.A07());
        }
        return false;
    }
}
