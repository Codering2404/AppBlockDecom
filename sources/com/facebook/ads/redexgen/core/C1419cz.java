package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1419cz {
    public static byte[] A03;
    public final int A00;
    public final String A01;
    public final String A02;

    static {
        A03();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-88, -73, -80, -80, -45, -53, -53, -55, -42, -74, -49, -62, -61, -51, -58, -127, -43, -48, -127, -60, -45, -58, -62, -43, -58, -127, -62, -59, -59, -54, -43, -54, -48, -49, -62, -51, -86, -49, -57, -48, -28, -25, -30, -26, -11, -24, -28, -9, -20, -7, -24, -30, -9, -4, -13, -24, -44, -41, -46, -39, -30, -27, -32, -44, -25, -46, -25, -20, -29, -40, Ascii.DLE, 19, Ascii.SO, Framer.ENTER_FRAME_PREFIX, Ascii.DC4, 32, 36, Ascii.DC4, 34, 35, Ascii.SO, Ascii.CAN, 19, -26, -11, -18, -39, -35, -47, -41, -43, -6, -19, -24, -23, -13};
    }

    public C1419cz(String str, String str2, int i3) {
        String strA01;
        this.A02 = str;
        this.A00 = i3;
        if (!TextUtils.isEmpty(str2)) {
            strA01 = A01(91, 5, 56);
        } else {
            strA01 = A01(86, 5, 36);
        }
        this.A01 = strA01;
    }

    private C1061Te A00(String str) {
        C1061Te c1061Te = new C1061Te(str);
        c1061Te.A07(A02());
        c1061Te.A05(1);
        return c1061Te;
    }

    private JSONObject A02() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A01(56, 14, 39), this.A00);
            jSONObject.put(A01(70, 13, 99), this.A02);
            jSONObject.put(A01(40, 16, 55), this.A01);
        } catch (JSONException e3) {
            Log.w(A01(0, 9, 24), A01(9, 31, 21), e3);
        }
        return jSONObject;
    }

    public final void A04(int i3, String str) {
        C1644ge sdkContext = T7.A00();
        if (sdkContext != null) {
            sdkContext.A08().ABC(A01(83, 3, 54), i3, A00(str));
        }
    }
}
