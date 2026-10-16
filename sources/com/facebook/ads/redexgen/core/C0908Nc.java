package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0908Nc implements Serializable {
    public static byte[] A04 = null;
    public static final long serialVersionUID = -4041915335826065133L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A03();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-3, 4, -5, -5, -21, -24, -30};
    }

    public C0908Nc(String str, String str2, JSONObject jSONObject, String str3) {
        this.A03 = A01(str);
        this.A02 = A01(str2);
        this.A00 = A01(str3);
        this.A01 = A02(jSONObject);
    }

    public static String A01(String str) {
        if (A00(0, 4, 65).equalsIgnoreCase(str)) {
            return A00(0, 0, 123);
        }
        return str;
    }

    private String A02(JSONObject jSONObject) {
        String strA00 = A00(0, 0, 123);
        if (jSONObject == null) {
            return strA00;
        }
        return jSONObject.optString(A00(4, 3, 40), strA00);
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final boolean A06() {
        return !TextUtils.isEmpty(this.A01);
    }
}
