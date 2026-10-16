package com.facebook.ads.redexgen.core;

import android.content.ContentResolver;
import android.database.Cursor;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1033Sb {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{61, 53, 56, 79, 64, 74, 92, 65, 71, 74, 71, 74, Ascii.DEL, 115, 114, 104, 121, 114, 104, 38, 51, 51, Ascii.DEL, 115, 113, Framer.STDERR_FRAME_PREFIX, 122, 125, Ascii.DEL, 121, 126, 115, 115, 119, Framer.STDERR_FRAME_PREFIX, 119, 125, 104, 125, 114, 125, Framer.STDERR_FRAME_PREFIX, 108, 110, 115, 106, 117, Framer.EXIT_FRAME_PREFIX, 121, 110, Framer.STDERR_FRAME_PREFIX, 93, 104, 104, 110, 117, 126, 105, 104, 117, 115, 114, 85, Framer.EXIT_FRAME_PREFIX, 76, 110, 115, 106, 117, Framer.EXIT_FRAME_PREFIX, 121, 110, Ascii.DC2, Ascii.ETB, 19, Ascii.ETB, 10, Framer.ENTER_FRAME_PREFIX, 10, Ascii.FF, Ascii.US, Ascii.GS, Ascii.NAK, Ascii.ETB, Ascii.DLE, Ascii.EM};
    }

    public static C1032Sa A00(ContentResolver contentResolver) {
        String strA01 = A01(72, 14, 113);
        String strA012 = A01(3, 9, 33);
        String strA013 = A01(0, 3, 83);
        Cursor c3 = null;
        try {
            c3 = contentResolver.query(XB.A00(A01(12, 60, 19)), new String[]{strA013, strA012, strA01}, null, null, null);
            if (c3 == null || !c3.moveToFirst()) {
                return new C1032Sa(null, null, false);
            }
            String string = c3.getString(c3.getColumnIndex(strA013));
            String attributionId = c3.getString(c3.getColumnIndex(strA012));
            C1032Sa c1032Sa = new C1032Sa(string, attributionId, Boolean.valueOf(c3.getString(c3.getColumnIndex(strA01))).booleanValue());
            if (c3 != null) {
                c3.close();
            }
            return c1032Sa;
        } finally {
            if (c3 != null) {
                c3.close();
            }
        }
    }
}
