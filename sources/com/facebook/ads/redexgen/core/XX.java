package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class XX {
    public static byte[] A00;
    public static String[] A01 = {"oiur5Gbx9Vkb8pNp9gZzU2heRSdk76uI", "KcefTCcuaU05Z9sCY8CUGAfDHno7A6Wv", "bJXbqvk5sb1jFzs2YeQkTjOgq4", "MXk0dIH8gF0Kt4EkqgzdHodGFIc", "5Jwp5xVo7ldrls8e1BLn8Q9HzbIas5MN", "BGKorZg39BSfa4B", "tbwfvdKmgBKRGshTqqnFkMc0Pskkyh5R", "DBfe4K11V"};
    public static final float A02;
    public static final float A03;
    public static final DisplayMetrics A04;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{46, 32, 37, Ascii.ESC, 38, 46};
    }

    static {
        A02();
        A04 = Resources.getSystem().getDisplayMetrics();
        A02 = A04.density;
        A03 = A04.scaledDensity / 1.3f;
    }

    public static int A00(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(A01(0, 6, 82));
        if (windowManager == null) {
            return 13;
        }
        switch (windowManager.getDefaultDisplay().getOrientation()) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                if (A01[2].length() != 26) {
                    throw new RuntimeException();
                }
                A01[4] = "CVXSSTaTyGD8rGam3jI5MG2HGxoF6OEi";
                return 9;
            case 3:
                return 8;
            default:
                return 13;
        }
    }
}
