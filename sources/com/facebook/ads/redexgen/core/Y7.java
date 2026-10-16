package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.media.AudioManager;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class Y7 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{100, 92, 111, 123, 106, 103, 97, 121, 109, 108, 119, 104, 116, 121, 97, 7, 0, 2, 7, 0, Ascii.VT};
    }

    public static float A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(2, 5, 11));
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int volume = audioManager.getStreamMaxVolume(3);
            if (volume > 0) {
                return (streamVolume * 1.0f) / volume;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public static void A03(Map<String, String> map, boolean z2, boolean z3) {
        String strA01 = A01(1, 1, 104);
        String strA012 = A01(0, 1, 81);
        map.put(A01(7, 8, 29), z2 ? strA01 : strA012);
        if (!z3) {
            strA01 = strA012;
        }
        map.put(A01(15, 6, 107), strA01);
    }
}
