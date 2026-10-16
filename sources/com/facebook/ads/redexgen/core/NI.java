package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class NI {
    public static byte[] A00;
    public static String[] A01 = {"rumqJp0zjtXTj7VCZC", "TMr6rmpz3eFeqFi1AyEescympmX4mKYs", "yKc30ML1ifcOIqfiQ1Y0n8yeP8tTgKvd", "ifxbXcWS1dksd5gxUX3XXpeR8fGAW9", "ARavVsGpFp1prhlT9X", "AJCuKBIGe5nliswM6BoL4M7qaWNzDabC", "wiV5dRZ8vBgNvrirj4IbquLjXKvqAP", "mqXFYOGhIorfWow0I7OGPDKbQEIe0IwJ"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1818ji A01(@Nullable C1648gi c1648gi, JSONObject jSONObject, String str, boolean z2, int i3, int i4) {
        boolean zOptBoolean;
        int iOptInt;
        boolean zOptBoolean2;
        int iOptInt2;
        boolean zOptBoolean3;
        int iOptInt3;
        ArrayList arrayList;
        if (jSONObject == null) {
            return new C1818ji();
        }
        XI.A04(c1648gi, A02(0, 23, 112));
        String strOptString = jSONObject.optString(A02(479, 10, 1));
        int iOptInt4 = jSONObject.optInt(A02(116, 12, 106), 0);
        String strOptString2 = jSONObject.optString(A02(253, 13, 18));
        String strA02 = AbstractC1159Xd.A02(jSONObject, A02(266, 12, 52));
        Uri uriA00 = TextUtils.isEmpty(strA02) ? null : XB.A00(strA02);
        String strA022 = AbstractC1159Xd.A02(jSONObject, A02(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 4, 54));
        String strA01 = AbstractC1177Xv.A01(strA022);
        String strA023 = AbstractC1159Xd.A02(jSONObject, A02(101, 15, 34));
        String strA024 = AbstractC1159Xd.A02(jSONObject, A02(593, 5, 82));
        String strA025 = AbstractC1159Xd.A02(jSONObject, A02(585, 8, 123));
        String strA026 = AbstractC1159Xd.A02(jSONObject, A02(386, 8, 111));
        String strA027 = AbstractC1159Xd.A02(jSONObject, A02(539, 14, 32));
        String strA028 = AbstractC1159Xd.A02(jSONObject, A02(RCHTTPStatusCodes.FORBIDDEN, 16, 125));
        String strA029 = AbstractC1159Xd.A02(jSONObject, A02(553, 21, 41));
        String strA0210 = AbstractC1159Xd.A02(jSONObject, A02(87, 14, 99));
        String strA0211 = AbstractC1159Xd.A02(jSONObject, A02(459, 20, 94));
        String strA0212 = AbstractC1159Xd.A02(jSONObject, A02(443, 16, 123));
        String strA0213 = AbstractC1159Xd.A02(jSONObject, A02(426, 17, 38));
        String strA0214 = AbstractC1159Xd.A02(jSONObject, A02(132, 14, 16));
        C05247m c05247mA00 = C05247m.A00(jSONObject, c1648gi);
        C1110Vb c1110VbA00 = C1110Vb.A00(jSONObject.optJSONObject(A02(394, 4, 38)));
        C1110Vb c1110VbA002 = C1110Vb.A00(jSONObject.optJSONObject(A02(398, 5, 114)));
        C1111Vc c1111VcA00 = C1111Vc.A00(jSONObject.optJSONObject(A02(574, 11, 124)));
        String strA0215 = AbstractC1159Xd.A02(jSONObject, A02(598, 15, 10));
        boolean zOptBoolean4 = jSONObject.optBoolean(A02(238, 15, 64));
        boolean zOptBoolean5 = jSONObject.optBoolean(A02(219, 19, 54));
        int iOptInt5 = jSONObject.optInt(A02(514, 25, 43), 4);
        int iOptInt6 = jSONObject.optInt(A02(489, 25, 29), 0);
        int iOptInt7 = jSONObject.optInt(A02(695, 31, 75), 0);
        int iOptInt8 = jSONObject.optInt(A02(726, 26, 18), 1000);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A02(53, 15, 30));
        C1110Vb c1110VbA003 = jSONObjectOptJSONObject != null ? C1110Vb.A00(jSONObjectOptJSONObject) : null;
        String strA0216 = AbstractC1159Xd.A02(jSONObject, A02(68, 19, 95));
        EnumC0902Mv enumC0902MvA00 = AbstractC0904Mx.A00(jSONObject);
        Collection<String> collectionA03 = AbstractC0904Mx.A03(c1648gi, jSONObject);
        String strA0217 = AbstractC1159Xd.A02(jSONObject, A02(686, 9, 20));
        int iOptInt9 = jSONObject.optInt(A02(635, 18, 76), 0);
        String strA0218 = A02(662, 24, 63);
        if (A01[2].charAt(6) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "3DgIwYJYxCZHaga7jdAdEfDBKsaQLEaY";
        strArr[0] = "PJjdxes2PDM40JhdCx";
        long jOptLong = jSONObject.optLong(strA0218, -1L);
        String strA0219 = AbstractC1159Xd.A02(jSONObject, A02(653, 9, 120));
        String strA0220 = A02(613, 22, 83);
        EnumC1114Vf enumC1114Vf = !jSONObject.has(strA0220) ? EnumC1114Vf.A03 : jSONObject.optBoolean(strA0220) ? EnumC1114Vf.A05 : EnumC1114Vf.A04;
        String strA0221 = A02(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 29, 111);
        if (A01[2].charAt(6) != 'o') {
            A01[5] = "EiaN2GrSxKmld9dBg6rLOOlJPXBJhn44";
            zOptBoolean = jSONObject.optBoolean(strA0221);
            iOptInt = jSONObject.optInt(A02(154, 36, 107), 100);
            zOptBoolean2 = jSONObject.optBoolean(A02(278, 18, 99), false);
            iOptInt2 = jSONObject.optInt(A02(296, 26, 38), 10);
            zOptBoolean3 = jSONObject.optBoolean(A02(353, 33, 122), false);
            iOptInt3 = jSONObject.optInt(A02(322, 31, 12), 1);
            arrayList = null;
        } else {
            zOptBoolean = jSONObject.optBoolean(strA0221);
            iOptInt = jSONObject.optInt(A02(154, 36, 107), 100);
            zOptBoolean2 = jSONObject.optBoolean(A02(278, 18, 99), false);
            iOptInt2 = jSONObject.optInt(A02(296, 26, 38), 10);
            zOptBoolean3 = jSONObject.optBoolean(A02(353, 33, 122), false);
            iOptInt3 = jSONObject.optInt(A02(322, 31, 12), 1);
            arrayList = null;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A02(146, 8, 26));
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList2 = new ArrayList(length);
                for (int i5 = 0; i5 < length; i5++) {
                    try {
                        arrayList2.add(A01(c1648gi, jSONArrayOptJSONArray.getJSONObject(i5), str, true, i5, length));
                    } catch (JSONException e3) {
                        e = e3;
                        arrayList = arrayList2;
                        c1648gi.A08().ABC(A02(419, 7, 72), AbstractC1060Td.A2A, new C1061Te(e));
                        Log.e(C1830ju.A0E, A02(23, 30, 97), e);
                        return new C1818ji(strA0216, strA01, strA022, strA023, strA024, strA025, strA026, strA027, strA028, strA029, strA0210, strA0211, strA0212, strA0213, strA0214, c1110VbA003, c05247mA00, c1110VbA00, c1110VbA002, c1111VcA00, strA0217, strA0219, jOptLong, enumC1114Vf, z2, i3, i4, arrayList, str, strOptString, iOptInt4, strOptString2, uriA00, strA0215, zOptBoolean4, zOptBoolean5, iOptInt6, iOptInt5, iOptInt7, iOptInt8, enumC0902MvA00, collectionA03, iOptInt, zOptBoolean, iOptInt9, zOptBoolean2, iOptInt2, zOptBoolean3, iOptInt3);
                    }
                }
                arrayList = arrayList2;
            }
        } catch (JSONException e4) {
            e = e4;
        }
        return new C1818ji(strA0216, strA01, strA022, strA023, strA024, strA025, strA026, strA027, strA028, strA029, strA0210, strA0211, strA0212, strA0213, strA0214, c1110VbA003, c05247mA00, c1110VbA00, c1110VbA002, c1111VcA00, strA0217, strA0219, jOptLong, enumC1114Vf, z2, i3, i4, arrayList, str, strOptString, iOptInt4, strOptString2, uriA00, strA0215, zOptBoolean4, zOptBoolean5, iOptInt6, iOptInt5, iOptInt7, iOptInt8, enumC0902MvA00, collectionA03, iOptInt, zOptBoolean, iOptInt9, zOptBoolean2, iOptInt2, zOptBoolean3, iOptInt3);
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{Ascii.SUB, 78, 61, 66, 62, 71, 60, 62, -7, 39, 62, 77, 80, 72, 75, 68, -7, 37, 72, 58, 61, 62, 61, Ascii.US, 56, 43, 44, 54, 47, -22, 62, 57, -22, 58, 43, 60, 61, 47, -22, Framer.STDIN_FRAME_PREFIX, 43, 60, 57, 63, 61, 47, 54, -22, 46, 43, 62, 43, -8, -24, -21, -26, -22, -17, -10, -16, -22, -20, -6, -26, -16, -22, -10, -11, 41, 44, 39, 43, 48, 55, Framer.STDOUT_FRAME_PREFIX, 43, Framer.STDIN_FRAME_PREFIX, 59, 39, 52, Framer.STDOUT_FRAME_PREFIX, 54, 51, 39, 61, 58, 52, Framer.STDIN_FRAME_PREFIX, 48, 43, 64, 62, Framer.STDIN_FRAME_PREFIX, 58, 63, 56, Framer.STDIN_FRAME_PREFIX, 64, 53, 59, 58, -20, -17, 1, -16, -3, -1, -12, -2, -16, -3, -22, -7, -20, -8, -16, 52, 65, Framer.STDERR_FRAME_PREFIX, 63, 66, 58, 66, Framer.STDERR_FRAME_PREFIX, 71, 76, 67, 56, 1, Ascii.SO, 3, Ascii.CAN, -36, -38, -27, -27, -40, -19, -24, -40, -38, -36, -19, -30, -24, -25, -26, -28, -11, -14, -8, -10, -24, -17, 55, 67, 66, 72, 53, 61, 66, 57, 70, 51, 74, 61, 57, 75, 53, 54, 61, 64, 61, 72, 77, 51, 55, 60, 57, 55, 63, 51, 61, 66, 72, 57, 70, 74, 53, 64, 59, 71, 70, 76, 57, 65, 70, 61, 74, 55, 78, 65, 61, 79, 57, 58, 65, 68, 65, 76, 81, 55, 61, 70, 57, 58, 68, 61, 60, 4, Ascii.CR, 0, 1, Ascii.VT, 4, -2, Ascii.DC2, Ascii.CR, 0, Ascii.SI, Ascii.DC2, 7, Ascii.SO, 19, -2, Ascii.VT, Ascii.SO, 6, Ascii.SO, Ascii.ETB, 10, Ascii.VT, Ascii.NAK, Ascii.SO, 8, Ascii.US, Ascii.DC2, Ascii.SO, 32, 8, Ascii.NAK, Ascii.CAN, Ascii.DLE, -32, -23, -34, -19, -12, -21, -17, -32, -33, -38, -34, -21, -24, 3, -1, -2, 1, -4, 0, Ascii.FF, 10, 10, -2, Ascii.VT, 1, 52, Framer.STDOUT_FRAME_PREFIX, 43, 47, 59, 65, 58, 64, Framer.STDOUT_FRAME_PREFIX, 62, 43, Framer.STDOUT_FRAME_PREFIX, 58, Framer.STDIN_FRAME_PREFIX, 46, 56, Framer.STDOUT_FRAME_PREFIX, 48, -9, -12, -18, -14, -2, 4, -3, 3, -12, 1, -18, 3, -8, -4, -12, -18, -8, -3, -18, 2, -12, -14, -2, -3, -13, 2, -35, -38, -44, -30, -22, -31, -23, -34, -44, -40, -31, -34, -40, -32, -44, -40, -31, -28, -24, -38, -44, -34, -40, -28, -29, -44, -40, -28, -22, -29, -23, 75, 72, 66, 80, 88, 79, 87, 76, 66, 70, 79, 76, 70, 78, 66, 70, 79, 82, 86, 72, 66, 76, 70, 82, 81, 66, 72, 81, 68, 69, 79, 72, 71, 64, 61, 57, 60, 68, 65, 70, 61, -8, -14, -2, -3, 68, 72, 60, 66, 64, 82, 79, 84, 81, 69, 74, 75, 89, 73, 88, 79, 86, 90, 79, 85, 84, Framer.ENTER_FRAME_PREFIX, Ascii.DC2, 35, 36, Ascii.SUB, Ascii.US, Ascii.CAN, -1, -16, 4, 2, -12, -18, 3, 1, -16, -3, 2, -5, -16, 3, -8, -2, -3, 84, 80, 69, 93, 67, 88, 86, 69, 82, 87, 80, 69, 88, 77, 83, 82, 55, 57, 54, 52, 54, 59, 44, 43, 38, 59, 57, 40, 53, 58, 51, 40, 59, 48, 54, 53, -36, -49, -37, -33, -49, -35, -34, -55, -45, -50, -7, -12, -25, -10, -7, -18, -11, -6, -27, -23, -11, -13, -10, -8, -21, -7, -7, -27, -9, -5, -25, -14, -17, -6, -1, 7, 2, -11, 4, 7, -4, 3, 8, -13, 0, 3, -5, -13, -8, -7, 0, -11, Ascii.CR, -13, 7, -7, -9, 3, 2, -8, -4, -8, -20, -14, -22, -11, -24, -20, -8, -9, -3, -18, 1, -3, 5, 2, 1, 0, 5, 1, 4, -9, -10, -15, 6, 4, -13, 0, 5, -2, -13, 6, -5, 1, 0, 88, 89, 70, 87, 68, 87, 70, 89, 78, 83, 76, 87, 89, 70, 88, 77, 88, 80, 73, 47, 36, 47, 39, 32, -24, -26, -40, -41, -46, -27, -40, -29, -30, -27, -25, -46, -24, -27, -33, Framer.STDERR_FRAME_PREFIX, 37, 32, Framer.ENTER_FRAME_PREFIX, 43, Ascii.ESC, Ascii.GS, Framer.STDOUT_FRAME_PREFIX, 48, 43, 44, 40, Ascii.GS, 53, Ascii.ESC, Framer.ENTER_FRAME_PREFIX, 42, Ascii.GS, Ascii.RS, 40, Framer.ENTER_FRAME_PREFIX, 32, 43, Ascii.RS, Ascii.EM, Ascii.SUB, 36, Ascii.DC4, Ascii.EM, 42, 39, Ascii.SYN, 41, Ascii.RS, 36, 35, Ascii.DC4, 40, Ascii.SUB, Ascii.CAN, 87, 74, 69, 70, 80, 64, 78, 81, 69, Ascii.RS, 17, Ascii.FF, Ascii.CR, Ascii.ETB, 7, Ascii.CAN, Ascii.SUB, Ascii.CR, Ascii.DC4, Ascii.ETB, 9, Ascii.FF, 7, Ascii.ESC, 17, 34, Ascii.CR, 7, 10, Framer.ENTER_FRAME_PREFIX, Ascii.FS, Ascii.CR, Ascii.ESC, -13, -26, -31, -30, -20, -36, -14, -17, -23, 42, Ascii.GS, Ascii.EM, 43, Ascii.NAK, Ascii.SYN, Ascii.GS, 32, Ascii.GS, 40, Framer.STDIN_FRAME_PREFIX, 19, Ascii.ETB, Ascii.FS, Ascii.EM, Ascii.ETB, Ascii.US, 19, Ascii.GS, 34, Ascii.GS, 40, Ascii.GS, Ascii.NAK, 32, 19, Ascii.CAN, Ascii.EM, 32, Ascii.NAK, Framer.STDIN_FRAME_PREFIX, -15, -28, -32, -14, -36, -35, -28, -25, -28, -17, -12, -38, -34, -29, -32, -34, -26, -38, -28, -23, -17, -32, -19, -15, -36, -25};
    }

    static {
        A03();
    }

    public static C1818ji A00(C1648gi c1648gi, JSONObject jSONObject, String str) {
        return A01(c1648gi, jSONObject, str, false, -1, 0);
    }
}
