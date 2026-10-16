package com.facebook.ads.redexgen.core;

import android.util.Log;
import android.view.View;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class Z4 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-112, -116, -117, -65, -82, -77, -81, -72, -83, -81, -104, -81, -66, -63, -71, -68, -75, -123, -96, -88, -85, Framer.STDIN_REQUEST_FRAME_PREFIX, -77, -82, Framer.STDIN_REQUEST_FRAME_PREFIX, -79, -92, -83, -93, -92, -79, Framer.STDIN_REQUEST_FRAME_PREFIX, -115, -96, -77, -88, -75, -92, Framer.STDIN_REQUEST_FRAME_PREFIX, -77, -92, -84, -81, -85, -96, -77, -92, 109, Framer.STDIN_REQUEST_FRAME_PREFIX, -124, -84, -81, -77, -72, Framer.STDIN_REQUEST_FRAME_PREFIX, -128, -83, -93, -79, -82, -88, -93, Framer.STDIN_REQUEST_FRAME_PREFIX, -107, -88, -92, -74, Framer.STDIN_REQUEST_FRAME_PREFIX, -74, -88, -85, -85, Framer.STDIN_REQUEST_FRAME_PREFIX, -95, -92, Framer.STDIN_REQUEST_FRAME_PREFIX, -79, -92, -77, -76, -79, -83, -92, -93, 109, -1, -14, 5, -6, 7, -10, -16, 5, -10, -2, 1, -3, -14, 5, -10};
    }

    public static View A00(C1648gi c1648gi, Throwable th) {
        A03(c1648gi, th);
        return new View(c1648gi);
    }

    public static void A03(C1648gi c1648gi, Throwable th) {
        c1648gi.A08().ABC(A01(85, 15, 103), AbstractC1060Td.A1w, new C1061Te(th));
        Log.e(A01(0, 17, 32), A01(17, 68, 21), th);
    }
}
