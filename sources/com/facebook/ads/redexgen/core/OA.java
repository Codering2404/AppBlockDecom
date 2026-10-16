package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OA {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-121, -122, -128, -109, 125, -126, -120, 121, 123, -122, 117, -120, 125, -125, -126, -109, 121, -122, -122, -125, -122, -109, -127, -125, Framer.EXIT_FRAME_PREFIX, 121, -109, Ascii.DEL, 121, -115};
    }

    public static AdSettings.IntegrationErrorMode A00(C1648gi c1648gi) {
        AdSettings.IntegrationErrorMode integrationErrorMode = (AdSettings.IntegrationErrorMode) AdInternalSettings.sSettingsBundle.getSerializable(A01(0, 30, 9));
        if (integrationErrorMode == null) {
            integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
        }
        AdSettings.IntegrationErrorMode integrationErrorMode2 = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
        if (integrationErrorMode == integrationErrorMode2 && !A03(c1648gi)) {
            return AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CALLBACK_MODE;
        }
        return integrationErrorMode;
    }

    public static boolean A03(C1648gi c1648gi) {
        return (c1648gi.getApplicationInfo().flags & 2) != 0;
    }
}
