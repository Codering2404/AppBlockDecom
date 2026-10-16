package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0904Mx {
    public static byte[] A00;
    public static String[] A01 = {"jSoy8XspXCFqO9NWG0uega5zyBcMMpnv", "8I941vkvBihlhZSR3", "E0n4xhy7f55RdYtJKKgnHTy6BEjDvFXE", "Oow628hlFtykEPzM3xMW0Wh", "gjSfO6YGNNbsKn6TLZq3stDSfq2Vbbu6", "XJoMwGgC8l1BSQaiX90ZQnicuTGj509z", "JK4GcCSwzapE3gOVlVNykyUw2lU6lT6d", "8BqJ2MeWpSgEuyxwl"};

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        byte[] bArr = {86, 115, 55, 126, 100, 55, 126, 121, 97, 118, 123, 126, 115, 118, 99, 114, 115, 55, 96, 126, 99, Ascii.DEL, Framer.EXIT_FRAME_PREFIX, 98, 99, 55, 99, Framer.EXIT_FRAME_PREFIX, 124, 114, 121, 57, Ascii.ESC, 10, 19, 117, 116, 101, 116, 114, 101, Framer.EXIT_FRAME_PREFIX, 126, Ascii.DEL, 78, 98, 101, 99, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 118, 98, 39, 32, 56, 47, 34, 39, 42, 47, 58, 39, Framer.ENTER_FRAME_PREFIX, 32, 17, 44, 43, 38, 47, 56, 39, Framer.ENTER_FRAME_PREFIX, 60, Framer.STDIN_FRAME_PREFIX, 60, 47, 46, 52, 51, 58};
        if (A01[6].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "4DtSv1ItoT1AnjNkW";
        strArr[1] = "xsdhzuZMhKe1kPAxh";
        A00 = bArr;
    }

    static {
        A05();
    }

    public static EnumC0902Mv A00(JSONObject jSONObject) {
        return EnumC0902Mv.A00(jSONObject.optString(A02(52, 21, 9)));
    }

    public static C1854kJ A01(C1648gi c1648gi, JSONObject jSONObject, String str) {
        return new C1854kJ(jSONObject, c1648gi, str);
    }

    public static Collection<String> A03(C1648gi c1648gi, JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            String detectionStringJSON = jSONObject.optString(A02(35, 17, 86));
            if (!TextUtils.isEmpty(detectionStringJSON)) {
                JSONArray detectionStringsArray = new JSONArray(detectionStringJSON);
                jSONArray = detectionStringsArray;
            }
        } catch (JSONException e3) {
            c1648gi.A08().ABC(A02(73, 7, 26), AbstractC1060Td.A2C, new C1061Te(e3));
        }
        return A04(jSONArray);
    }

    public static Collection<String> A04(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            hashSet.add(jSONArray.optString(i3));
        }
        return hashSet;
    }

    public static boolean A06(C1648gi c1648gi, InterfaceC0903Mw interfaceC0903Mw, VA va) {
        EnumC0902Mv enumC0902MvA8K = interfaceC0903Mw.A8K();
        if (enumC0902MvA8K != null) {
            EnumC0902Mv invalidationBehavior = EnumC0902Mv.A03;
            if (enumC0902MvA8K != invalidationBehavior) {
                boolean packageInstalled = false;
                Collection<String> collectionA7p = interfaceC0903Mw.A7p();
                if (collectionA7p == null || collectionA7p.isEmpty()) {
                    return false;
                }
                Iterator<String> it = collectionA7p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (AbstractC1164Xi.A04(c1648gi, it.next())) {
                        packageInstalled = true;
                        break;
                    }
                }
                EnumC0902Mv invalidationBehavior2 = EnumC0902Mv.A02;
                if (packageInstalled != (enumC0902MvA8K == invalidationBehavior2)) {
                    return false;
                }
                String clientToken = interfaceC0903Mw.A7O();
                if (!TextUtils.isEmpty(clientToken)) {
                    va.ABK(clientToken, null);
                    return true;
                }
                c1648gi.A08().ABC(A02(32, 3, 61), AbstractC1060Td.A0Z, new C1061Te(A02(0, 32, 80)));
                return true;
            }
        }
        return false;
    }
}
