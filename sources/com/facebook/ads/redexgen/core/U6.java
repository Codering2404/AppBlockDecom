package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class U6 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-74, -72, -85, -84, -59, -71, -86, -79, -59, -87, -89, -87, -82, -85, -35, -33, -46, -45, -20, -32, -47, -40, -20, -38, -50, -37, -50, -44, -46, -47, -20, -48, -50, -48, -43, -46, -54, -56, -54, -49, -52, -28, -31, -12, -27, -33, -13, -27, -12, Framer.ENTER_FRAME_PREFIX, 52, 44, 37, 46, Framer.ENTER_FRAME_PREFIX, 47, Ascii.ESC, 37, 42, -40, -61, -50, -41, -57};
    }

    public static String A01(C1644ge c1644ge) {
        return WN.A00(c1644ge).getString(A00(0, 14, 37), null);
    }

    public static Map<String, String> A02(C1644ge c1644ge) {
        String sdkCache = WN.A00(c1644ge).getString(A00(14, 22, 76), null);
        if (sdkCache == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(sdkCache);
            HashSet hashSet = new HashSet();
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.getLong(A00(41, 8, 63)) + ((long) (jSONObject2.getInt(A00(49, 10, 123)) * 1000)) < System.currentTimeMillis()) {
                    hashSet.add(next);
                } else {
                    map.put(next, jSONObject2.getString(A00(59, 5, 33)));
                }
            }
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONObject.remove((String) it.next());
                }
                A06(c1644ge, jSONObject);
            }
            return map;
        } catch (JSONException e3) {
            c1644ge.A08().ABC(A00(36, 5, 38), AbstractC1060Td.A2U, new C1061Te(e3));
            return null;
        }
    }

    public static void A04(C1644ge c1644ge, String str) {
        WN.A00(c1644ge).edit().putString(A00(0, 14, 37), str).apply();
    }

    public static void A05(C1644ge c1644ge, String str) {
        if (str == null) {
            return;
        }
        String sdkCache = WN.A00(c1644ge).getString(A00(14, 22, 76), null);
        try {
            JSONObject jSONObject = sdkCache == null ? new JSONObject() : new JSONObject(sdkCache);
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(key);
                jSONObject3.put(A00(41, 8, 63), System.currentTimeMillis());
                jSONObject.put(key, jSONObject3);
            }
            A06(c1644ge, jSONObject);
        } catch (JSONException e3) {
            c1644ge.A08().ABC(A00(36, 5, 38), AbstractC1060Td.A2V, new C1061Te(e3));
        }
    }

    public static void A06(C1644ge c1644ge, JSONObject jSONObject) {
        WN.A00(c1644ge).edit().putString(A00(14, 22, 76), jSONObject.toString()).apply();
    }
}
