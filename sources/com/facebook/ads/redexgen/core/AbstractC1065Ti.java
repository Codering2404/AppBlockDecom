package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ti, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1065Ti {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.ETB, 52, 60, 60, Framer.STDERR_FRAME_PREFIX, 53, 60, 123, Ascii.NAK, 62, 47, 44, 52, 41, 48, 123, Ascii.RS, Framer.STDIN_FRAME_PREFIX, 62, 53, 47, 34, 51, 52, 39, Framer.STDERR_FRAME_PREFIX, 47, 41, 40, 96, 119, 119, 106, 119, 32, 60, 60, 56, Ascii.ETB, 59, 60, 41, 60, 61, 59, Ascii.ETB, 43, 39, 44, Framer.STDIN_FRAME_PREFIX, 98, 105, Framer.EXIT_FRAME_PREFIX, 123, 99, 126, 103, 41, 56, 32, 53, 54, 56, 61, 6, 42, 48, 35, 60, 55, 48, 37, 54, 48, Ascii.ESC, 48, Framer.STDIN_FRAME_PREFIX, 41, Framer.ENTER_FRAME_PREFIX, 40, Framer.STDIN_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 60, 57, 2, 46, 52, 39, 56};
    }

    public static JSONObject A01(T8 t8, long j3, long j4, long j5, long j6, int i3, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 52), j3);
                try {
                    jSONObject.put(A00(21, 8, 54), j4 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 41), j5);
                        try {
                            jSONObject.put(A00(79, 11, 45), j6);
                        } catch (JSONException e3) {
                            e = e3;
                        }
                    } catch (JSONException e4) {
                        e = e4;
                    }
                } catch (JSONException e5) {
                    e = e5;
                }
            } catch (JSONException e6) {
                e = e6;
            }
        } catch (JSONException e7) {
            e = e7;
        }
        try {
            jSONObject.put(A00(34, 16, 56), i3);
            if (exc != null) {
                jSONObject.put(A00(29, 5, 117), exc.getMessage());
            }
        } catch (JSONException e8) {
            e = e8;
            t8.A08().A4I(e);
        }
        return jSONObject;
    }

    public static void A03(T8 t8, long j3, long j4, long j5, long j6, int i3, Exception exc) {
        C1061Te c1061Te = new C1061Te(A00(0, 21, 43));
        c1061Te.A05(1);
        c1061Te.A07(A01(t8, j3, j4, j5, j6, i3, exc));
        t8.A08().ACA(A00(50, 7, 124), AbstractC1060Td.A20, c1061Te);
    }
}
