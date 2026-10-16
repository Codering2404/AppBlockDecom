package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class NZ {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.CAN, Ascii.SUB, 9, Ascii.DC4, Ascii.SO, 8, Ascii.RS, Ascii.ETB, 100, 117, 102, 103, 125, 122, 115, 85, 74, 71, 70, 76, 124, 86, 81, 79};
    }

    public static List<NR> A01(JSONArray jSONArray, JSONObject jSONObject, C1648gi c1648gi, InterfaceC0910Ne interfaceC0910Ne) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (i3 == 0) {
                    A03(jSONObject2, jSONObject);
                }
                NR nrA00 = NR.A00(jSONObject2);
                interfaceC0910Ne.A3y(nrA00, jSONObject2);
                arrayList.add(nrA00);
            } catch (JSONException e3) {
                c1648gi.A08().ABC(A00(8, 7, 90), AbstractC1060Td.A2B, new C1061Te(e3));
            }
        }
        return arrayList;
    }

    public static void A03(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!next.equals(A00(15, 9, 109)) && !next.equals(A00(0, 8, 53)) && !jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }
}
