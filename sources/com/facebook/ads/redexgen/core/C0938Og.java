package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Og, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0938Og {
    public static byte[] A01;
    public static String[] A02 = {"pVDJwwImNDAzAU7MVHYB7KJyYkXB8ng6", "xCCCN", "WmAvu667o4AOfXv58a4lhsk2v5Ms6Skb", "l5AJTkPNjTtBLXifXwK6kFeEJ0fMsOcr", "3rlSEGUZnv4yJ13AM8B6pi", "FEUqx4", "USh9ikhtS0UWG5H8nhVral6z3PYi0bQO", "dZN"};
    public static final String[] A03;
    public final InterfaceC0944Om A00;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A01 = new byte[]{106, 7, 43, 56, Framer.ENTER_FRAME_PREFIX, 106, 43, 46, 106, 43, 57, 106, 37, 44, 44, 47, 36, 57, 35, 60, 47, 106, 37, 56, 106, 35, 36, 43, 58, 58, 56, 37, 58, 56, 35, 43, 62, 47, 104, 77, 9, 65, 64, 77, 77, 76, 71, 7, 106, 79, Ascii.VT, 89, 78, 91, 68, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 79, 5, Ascii.DC2, 63, 54, 42, 122, 47, 41, 122, 47, 52, 62, 63, 40, 41, 46, 59, 52, 62, 122, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 59, 46, 122, 51, 41, 122, Framer.STDERR_FRAME_PREFIX, 59, 42, 42, 63, 52, 51, 52, 61, 116, 122, Ascii.CR, Framer.STDERR_FRAME_PREFIX, 35, 122, 62, 53, 52, 125, 46, 122, 35, 53, 47, 122, Framer.STDIN_FRAME_PREFIX, 59, 52, 46, 122, 46, 53, 122, 41, 63, 63, 122, 46, Framer.STDERR_FRAME_PREFIX, 51, 41, 101, 39, 10, 3, Ascii.US, 79, Ascii.SUB, Ascii.FS, 79, Ascii.SUB, 1, Ascii.VT, 10, Ascii.GS, Ascii.FS, Ascii.ESC, Ascii.SO, 1, Ascii.VT, 79, Ascii.CAN, 7, Ascii.SO, Ascii.ESC, 79, 6, Ascii.FS, 79, 7, Ascii.SO, Ascii.US, Ascii.US, 10, 1, 6, 1, 8, 65, 79, 56, 7, Ascii.SYN, 79, 6, Ascii.FS, 79, Ascii.ESC, 7, 6, Ascii.FS, 79, 6, 1, Ascii.SO, Ascii.US, Ascii.US, Ascii.GS, 0, Ascii.US, Ascii.GS, 6, Ascii.SO, Ascii.ESC, 10, 80, 77, 108, 97, 96, 37, 68, 97, 118, 90, 85, 90, 92, 94, Ascii.ESC, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ESC, 75, 73, 94, 93, 94, 73, 94, 85, 88, 94, 72, 89, Framer.EXIT_FRAME_PREFIX, 55, Ascii.DEL, 126, 115, 114, 55, 118, 115, 55, Framer.EXIT_FRAME_PREFIX, 103, 99, 126, Framer.EXIT_FRAME_PREFIX, 121, 100, Ascii.US, 62, 113, 35, 52, Framer.ENTER_FRAME_PREFIX, 62, 35, 37, 113, 48, 53, 113, 62, Framer.ENTER_FRAME_PREFIX, 37, 56, 62, 63, 34, 77, 122, 111, 112, 109, 107, 63, 94, 123, 73, Ascii.DEL, Ascii.DEL, 58, 124, Ascii.DEL, 109, Ascii.DEL, 104, 58, 123, 126, 105, 58, 118, 115, 113, Ascii.DEL, 58, 110, 114, 115, 105, 110, 81, 64, Ascii.EM, 88, 84, Ascii.EM, 112, Ascii.EM, 74, 92, 92, 80, 87, 94, Ascii.EM, 77, 81, 80, 74, Ascii.EM, 88, 93, 6, 60, 10, Ascii.DLE, Ascii.ETB, 69, Ascii.SYN, Ascii.DLE, 7, 8, Ascii.FF, Ascii.SYN, Ascii.SYN, Ascii.FF, 10, Ascii.VT, 69, Ascii.FF, Ascii.SYN, 69, Ascii.VT, 10, Ascii.DC2, 69, 7, 0, Ascii.FF, Ascii.VT, 2, 69, Ascii.ETB, 0, 19, Ascii.FF, 0, Ascii.DC2, 0, 1, 75, 76, 74, 125, Framer.EXIT_FRAME_PREFIX, 67, Ascii.DEL, 116, 115, 117, Ascii.DEL, 121, 111, 67, 105, 110, 117, 102, 109, 108, 105, 97, 119, 96, 107, 90, 109, 96, 100, 97, 108, 107, 98, 38, Framer.STDIN_FRAME_PREFIX, 44, 41, Framer.ENTER_FRAME_PREFIX, 55, 32, 43, Ascii.SUB, 42, 53, Framer.STDOUT_FRAME_PREFIX, 44, 42, 43, 54, 117, 122, 125, 122, 96, 123, 118, 119, 76, 119, 118, 96, 112, 97, 122, 99, 103, 122, 124, 125, 74, 69, 66, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 73, 72, 115, 68, 69, 72, 73, 115, 77, 72, 90, 85, 82, 85, 79, 84, 89, 88, 99, 78, 89, 76, 83, 78, 72, 99, 93, 88, 59, 58, 55, 54, Ascii.FF, Framer.STDERR_FRAME_PREFIX, 55, Framer.STDOUT_FRAME_PREFIX, 48, 61, 60, 6, 56, 61, 6, 61, 60, 42, 58, 43, 48, 41, Framer.STDIN_FRAME_PREFIX, 48, 54, 55, 61, 60, Framer.STDOUT_FRAME_PREFIX, 48, 10, 52, Framer.STDOUT_FRAME_PREFIX, 10, 51, 58, 57, 57, 58, 34, 10, 32, 37, 10, 61, 48, 52, Framer.STDOUT_FRAME_PREFIX, 60, 59, Framer.STDERR_FRAME_PREFIX, 90, 91, 86, 87, 109, 83, 86, 109, 93, 66, 70, 91, 93, 92, 65, 89, 84, 70, 65, 106, 64, 69, 81, 84, 65, 80, 81, 106, 65, 92, 88, 80, 70, 65, 84, 88, 69, 40, 36, 43, 36, 34, 32, Ascii.SUB, 36, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, 53, 55, 32, 35, 32, 55, 32, 43, 38, 32, 54, 85, 89, 86, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 93, 103, 89, 92, 103, 72, 74, 93, 94, 93, 74, 93, 86, 91, 93, 75, 103, 77, 74, 81, 117, 110, 119, 119, 98, 125, 121, 100, 98, 99, 82, 121, 104, 117, 121, Framer.ENTER_FRAME_PREFIX, 62, 58, 39, Framer.ENTER_FRAME_PREFIX, 32, 17, 56, 47, 34, 59, 43, 8, Ascii.US, 10, Ascii.NAK, 8, Ascii.SO, 37, Ascii.ESC, Ascii.RS, 39, 48, 37, 58, 39, Framer.ENTER_FRAME_PREFIX, 10, 52, Framer.STDOUT_FRAME_PREFIX, 10, Framer.STDOUT_FRAME_PREFIX, 48, 38, 54, 39, 60, 37, Framer.ENTER_FRAME_PREFIX, 60, 58, 59, Ascii.CR, Ascii.SUB, Ascii.SI, Ascii.DLE, Ascii.CR, Ascii.VT, 32, Ascii.RS, Ascii.ESC, 32, Ascii.EM, Ascii.DLE, 19, 19, Ascii.DLE, 8, 32, 10, Ascii.SI, 32, Ascii.ETB, Ascii.SUB, Ascii.RS, Ascii.ESC, Ascii.SYN, 17, Ascii.CAN, 66, 85, 64, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 68, 111, 81, 84, 111, Framer.STDIN_REQUEST_FRAME_PREFIX, 64, 68, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, 67, 91, 76, 89, 70, 91, 93, 64, 71, 78, Ascii.DLE, Ascii.SI, Ascii.RS, 56, 6, 10, 56, Ascii.SO, 56, Ascii.DC4, 2, 2, Ascii.SO, 9, 0, 56, 19, Ascii.SI, Ascii.SO, Ascii.DC4};
    }

    static {
        A06();
        A03 = new String[]{A02(455, 7, 105), A02(462, 19, 99), A02(481, 25, 111), A02(506, 15, 8), A02(616, 9, 64), A02(625, 21, 111), A02(646, 27, 69), A02(673, 17, 10), A02(543, 21, 127), A02(421, 16, 22), A02(437, 18, 6), A02(RCHTTPStatusCodes.UNAUTHORIZED, 20, 41), A02(699, 20, 93), A02(355, 14, 38), A02(564, 25, 2)};
    }

    public C0938Og(InterfaceC0944Om interfaceC0944Om) {
        this.A00 = interfaceC0944Om;
    }

    private String A00() {
        return A03(A02(481, 25, 111), A02(60, 69, 96));
    }

    private String A01() {
        return A03(A02(646, 27, 69), A02(129, 64, 85));
    }

    private String A03(String str, String str2) {
        String strA9E = this.A00.A9E(str, str2);
        if (strA9E == null) {
            return str2;
        }
        String value = A02(589, 4, 33);
        return strA9E.equals(value) ? str2 : strA9E;
    }

    public static List<C0942Ok> A04(String str) throws JSONException {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(A02(589, 4, 33))) {
            return new ArrayList();
        }
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
            C0942Ok c0942Ok = new C0942Ok(jSONObject.getInt(A02(604, 12, 116)), jSONObject.getString(A02(593, 11, 55)), jSONObject.optString(A02(369, 16, 63)));
            Iterator<C0942Ok> it = A04(jSONObject.optString(A02(385, 16, 127))).iterator();
            while (it.hasNext()) {
                c0942Ok.A06(it.next());
            }
            arrayList.add(c0942Ok);
        }
        return arrayList;
    }

    public static Map<String, String> A05(String str) {
        if (str != null && !str.isEmpty()) {
            if (A02[0].charAt(31) == '2') {
                throw new RuntimeException();
            }
            A02[0] = "A8tiJT5v19tpxSVqHJBkbDhH2RRDdRkC";
            if (!str.equals(A02(353, 2, 45))) {
                HashMap map = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (String str2 : A03) {
                        if (!jSONObject.has(str2)) {
                            return null;
                        }
                        map.put(str2, jSONObject.getString(str2));
                    }
                    if (A04(jSONObject.getString(A02(673, 17, 10))).size() == 0) {
                        A08(AbstractC1060Td.A28, new C1061Te(A02(239, 20, 107)));
                        return null;
                    }
                    if (A04(jSONObject.getString(A02(506, 15, 8))).size() == 0) {
                        A08(AbstractC1060Td.A25, new C1061Te(A02(221, 18, 45)));
                        return null;
                    }
                    return map;
                } catch (JSONException e3) {
                    A08(AbstractC1060Td.A27, new C1061Te(e3));
                    return null;
                }
            }
        }
        return null;
    }

    private final void A07() {
        C1737iC c1737iCA6I = this.A00.A6I();
        c1737iCA6I.A00(A02(521, 22, 15), 0L);
        c1737iCA6I.A02();
    }

    public static void A08(int i3, C1061Te c1061Te) {
        C1644ge sdkContext = T7.A00();
        if (sdkContext != null) {
            sdkContext.A08().ABC(A02(690, 9, 19), i3, c1061Te);
        }
    }

    public final long A09() {
        return this.A00.A8Q(A02(521, 22, 15), 0L);
    }

    public final C0942Ok A0A() {
        C0942Ok c0942Ok = new C0942Ok(A00());
        try {
            for (C0942Ok hideAdParent : A04(A03(A02(506, 15, 8), A02(0, 0, 48)))) {
                c0942Ok.A06(hideAdParent);
            }
        } catch (JSONException e3) {
            A07();
            A08(AbstractC1060Td.A26, new C1061Te(e3));
        }
        return c0942Ok;
    }

    public final C0942Ok A0B() {
        C0942Ok c0942Ok = new C0942Ok(A01());
        try {
            for (C0942Ok reportAdParent : A04(A03(A02(673, 17, 10), A02(0, 0, 48)))) {
                c0942Ok.A06(reportAdParent);
            }
        } catch (JSONException e3) {
            A07();
            A08(AbstractC1060Td.A29, new C1061Te(e3));
        }
        return c0942Ok;
    }

    public final String A0C() {
        return A03(A02(355, 14, 38), A02(0, 0, 48));
    }

    public final String A0D() {
        return A03(A02(RCHTTPStatusCodes.UNAUTHORIZED, 20, 41), A02(315, 38, 95));
    }

    public final String A0E() {
        return A03(A02(421, 16, 22), A02(38, 10, 19));
    }

    public final String A0F() {
        return A03(A02(437, 18, 6), A02(48, 12, 17));
    }

    public final String A0G() {
        return A03(A02(462, 19, 99), A02(268, 23, 32));
    }

    public final String A0H() {
        return A03(A02(455, 7, 105), A02(193, 7, 63));
    }

    public final String A0I() {
        return A03(A02(564, 25, 2), A02(0, 0, 48));
    }

    public final String A0J() {
        return A03(A02(543, 21, 127), A02(200, 21, 1));
    }

    public final String A0K() {
        return A03(A02(625, 21, 111), A02(0, 38, 112));
    }

    public final String A0L() {
        return A03(A02(616, 9, 64), A02(259, 9, 37));
    }

    public final String A0M() {
        return A03(A02(699, 20, 93), A02(291, 24, 3));
    }

    public final void A0N(String str) {
        Map<String, String> mapA05 = A05(str);
        if (mapA05 == null || mapA05.size() != A03.length) {
            return;
        }
        C1737iC c1737iCA6I = this.A00.A6I();
        for (String str2 : A03) {
            c1737iCA6I.A01(str2, mapA05.get(str2));
        }
        if (A02[1].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "MCE7RaiUtGHbfQd9DpKX6Z";
        strArr[5] = "LB7njF";
        c1737iCA6I.A00(A02(521, 22, 15), System.currentTimeMillis());
        c1737iCA6I.A02();
    }

    public final boolean A0O(Context context, boolean z2) {
        return (z2 || C1098Up.A2h(context)) && ((A09() > 0L ? 1 : (A09() == 0L ? 0 : -1)) > 0);
    }
}
