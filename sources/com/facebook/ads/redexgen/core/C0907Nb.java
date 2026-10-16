package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0907Nb implements Serializable {
    public static byte[] A03 = null;
    public static final long serialVersionUID = 6010729991575063286L;
    public final int A00;
    public final int A01;
    public final String A02;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 117);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{Ascii.EM, Ascii.SYN, Ascii.SUB, Ascii.CAN, Ascii.EM, 37, 89, 86, 80, 2, -12, -17, -1, -13};
    }

    public C0907Nb(String str, int i3, int i4) {
        this.A02 = str;
        this.A01 = i3;
        this.A00 = i4;
    }

    public static C0907Nb A00(JSONObject jSONObject) {
        String strOptString;
        if (jSONObject == null || (strOptString = jSONObject.optString(A01(6, 3, 111))) == null) {
            return null;
        }
        return new C0907Nb(strOptString, jSONObject.optInt(A01(9, 5, 22), 0), jSONObject.optInt(A01(0, 6, 60), 0));
    }

    public final int A03() {
        return this.A00;
    }

    public final int A04() {
        return this.A01;
    }

    public final String A05() {
        return this.A02;
    }
}
