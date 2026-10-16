package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0901Mu {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{44, Ascii.ETB, Ascii.CAN, Ascii.ESC, Ascii.NAK, Ascii.FS, 89, Ascii.CR, Ascii.SYN, 89, 9, Ascii.CAN, Ascii.VT, 10, Ascii.FS, 89, 19, 10, Ascii.SYN, Ascii.ETB, 89, Ascii.GS, Ascii.CAN, Ascii.CR, Ascii.CAN, 89, Ascii.DLE, Ascii.ETB, 89, 56, Ascii.GS, 56, Ascii.SUB, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.ETB, 63, Ascii.CAN, Ascii.SUB, Ascii.CR, Ascii.SYN, Ascii.VT, 0, 87, 114, 119, 98, 119, 51, Framer.STDERR_FRAME_PREFIX, 47, 53, 40, 57, 126, 97, 116, Ascii.DEL, 78, 125, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 122, Framer.STDOUT_FRAME_PREFIX, 32, 51, Framer.STDERR_FRAME_PREFIX, 40, 47, 38, 62, 47, 61, 61, 58, 38, 60, Framer.ENTER_FRAME_PREFIX, 59, 41, 38, 42, Framer.STDIN_FRAME_PREFIX, 54, 43, 60, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 89, 78, 116, 94, 89, 71, 116, 92, 78, 73, 116, 77, 74, 71, 71, 73, 74, 72, 64, Framer.STDERR_FRAME_PREFIX, 52, 51, 35, 76, 83, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 101, 79, 72, 86};
    }

    static {
        A03();
        A01 = C0901Mu.class.getSimpleName();
    }

    public static AbstractC0900Mt A00(C1648gi c1648gi, VA va, String str, Uri uri, Map<String, String> extraData, C0912Ng c0912Ng) {
        return A01(c1648gi, va, str, uri, extraData, true, false, c0912Ng);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.AbstractC0900Mt A01(final com.facebook.ads.redexgen.core.C1648gi r15, final com.facebook.ads.redexgen.core.VA r16, final java.lang.String r17, final android.net.Uri r18, final java.util.Map<java.lang.String, java.lang.String> r19, final boolean r20, boolean r21, com.facebook.ads.redexgen.core.C0912Ng r22) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0901Mu.A01(com.facebook.ads.redexgen.X.gi, com.facebook.ads.redexgen.X.VA, java.lang.String, android.net.Uri, java.util.Map, boolean, boolean, com.facebook.ads.redexgen.X.Ng):com.facebook.ads.redexgen.X.Mt");
    }

    public static boolean A04(String str) {
        return A02(82, 5, 80).equalsIgnoreCase(str) || A02(55, 9, 24).equalsIgnoreCase(str);
    }
}
