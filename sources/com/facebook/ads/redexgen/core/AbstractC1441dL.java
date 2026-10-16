package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1441dL {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1440dK A00(C1648gi c1648gi, JSONObject jSONObject, C1054Sx c1054Sx, VI vi, C1419cz c1419cz, boolean z2) {
        boolean z3;
        String strA0S;
        boolean z4 = z2;
        String strA01 = A01(101, 3, 41);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String strOptString = jSONObject.optString(A01(51, 26, 104));
        arrayList3.add(strOptString);
        if (z4) {
            strA0S = c1054Sx.A0S(strOptString);
            if (strOptString.equals(strA0S)) {
                z4 = false;
                z3 = false;
            } else {
                z3 = z4;
            }
        } else {
            z3 = z4;
            strA0S = strOptString;
        }
        vi.A04(VH.A0P, null);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(92, 4, 49));
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString(strA01) != null) {
                arrayList.add(jSONObjectOptJSONObject.optString(strA01));
                if (z3) {
                    jSONObjectOptJSONObject.put(strA01, c1054Sx.A0R(jSONObjectOptJSONObject.optString(strA01)));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A01(77, 15, 113));
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    String strOptString2 = jSONArrayOptJSONArray.optString(i3);
                    arrayList.add(strOptString2);
                    if (z3) {
                        jSONArrayOptJSONArray.put(i3, c1054Sx.A0R(strOptString2));
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(A01(43, 8, 37));
            if (jSONArrayOptJSONArray2 != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                    A03(arrayList, arrayList2, jSONArrayOptJSONArray2.optJSONObject(i4), c1054Sx, z3);
                }
            } else {
                A03(arrayList, arrayList2, jSONObject, c1054Sx, z3);
            }
        } catch (JSONException unused) {
            c1419cz.A04(AbstractC1060Td.A15, A01(0, 43, 35));
        }
        return new C1440dK(jSONObject, strA0S, arrayList, arrayList2, arrayList3, z4);
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-87, -42, -42, -45, -42, -124, -40, -42, -59, -46, -41, -54, -45, -42, -47, -51, -46, -53, -124, -82, -73, -77, -78, -124, -51, -46, -124, -39, -44, -56, -59, -40, -55, -89, -59, -57, -52, -55, -56, -71, -42, -48, -41, -55, -57, -40, -43, -37, -39, -53, -46, Ascii.CR, 34, Ascii.ETB, 10, Ascii.SYN, Ascii.DC2, Ascii.FF, 8, Ascii.FS, Ascii.CR, Ascii.DC4, 8, Ascii.NAK, 10, 34, Ascii.SO, Ascii.ESC, 8, 17, Ascii.GS, Ascii.SYN, Ascii.NAK, 8, Ascii.RS, Ascii.ESC, Ascii.NAK, Ascii.ETB, 32, Ascii.SYN, 17, Ascii.NAK, 19, 36, Ascii.SYN, 17, Ascii.ESC, Ascii.US, 19, Ascii.EM, Ascii.ETB, 37, -37, -43, -31, -32, -35, -31, -43, -37, -39, -33, -36, -42, -32, -45, -50, -49, -39, -55, -33, -36, -42};
    }

    public static void A03(ArrayList<String> imageUrls, ArrayList<String> videoUrls, JSONObject jSONObject, C1054Sx c1054Sx, boolean z2) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(96, 5, 51));
        if (jSONObjectOptJSONObject != null) {
            String strA01 = A01(101, 3, 41);
            if (jSONObjectOptJSONObject.optString(strA01) != null) {
                String strOptString = jSONObjectOptJSONObject.optString(strA01);
                imageUrls.add(strOptString);
                if (z2) {
                    jSONObjectOptJSONObject.put(strA01, c1054Sx.A0R(strOptString));
                }
            }
        }
        String strA012 = A01(104, 9, 41);
        if (!TextUtils.isEmpty(jSONObject.optString(strA012))) {
            String strOptString2 = jSONObject.optString(strA012);
            videoUrls.add(strOptString2);
            if (z2) {
                jSONObject.put(strA012, c1054Sx.A0S(strOptString2));
            }
        }
    }
}
