package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1159Xd {
    public static byte[] A00;
    public static String[] A01 = {"k0KWJrtOeyRtx2YSOmZ2S9sZBWRzRtzR", "FhSJWxdRwKLMP9JOn6q1b2qMo", "vd4", "prNs3YfRmQWdH9Q7PHydrBddu2xVDtuC", "TQMlXyI0yqbHfDCacucNcvBBb28", "i9ckL4hGn3OwY3VfnpnVreAjs5dC9GVS", "Iva6FryQGZnTk8EX70gQNR0ykk5ruyon", ""};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{9, Ascii.DC2, Ascii.VT, Ascii.VT};
    }

    static {
        A05();
    }

    public static String A01(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                if (A01[7].length() == 0) {
                    A01[6] = "jcZWkwS564qIWYGPRhtwMiRcu2uJOsmN";
                    if (!zHasNext) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String A02(JSONObject jSONObject, String str) {
        return A03(jSONObject, str, null);
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString(str, str2);
        String value = A00(0, 4, 26);
        if (value.equals(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public static List<String> A04(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String strOptString = jSONArray.optString(i3);
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }
}
