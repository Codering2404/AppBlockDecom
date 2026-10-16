package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.No, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0920No implements Serializable {
    public static byte[] A0Q = null;
    public static String[] A0R = {"ctorgdsQQ2U4B6CI8kOgnWnGWE5Hgfx0", "OfZzAcfvUxmyP", "hRr0xuGBslycC2aIRO91", "oYy00yp7m", "vkVvrMYFy", "Q6DpYSl0Gg7lXNb5sJ12E0KBmjRKKzYP", "aB5DzfiXC0YdMCjW8pZWdkroLLRV865X", ""};
    public static final EnumC0921Np A0S;
    public static final EnumC1309bD A0T;
    public static final long serialVersionUID = -5352540123250859603L;
    public int A00;
    public int A01;
    public String A02;
    public String A03;
    public String A04;
    public String A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final EnumC0921Np A0D;
    public final EnumC1309bD A0E;
    public final String A0F;
    public final String A0G;
    public final String A0H;
    public final String A0I;
    public final String A0J;
    public final String A0K;
    public final boolean A0L;
    public final boolean A0M;
    public final boolean A0N;
    public final boolean A0O;
    public final boolean A0P;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0Q = new byte[]{70, 97, 124, 123, 110, 99, 99, 62, Ascii.GS, 19, Ascii.SYN, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, 34, Ascii.RS, 19, Ascii.VT, 19, Ascii.DLE, Ascii.RS, Ascii.ETB, 91, 103, 106, 114, 43, 88, Ascii.DEL, 100, 121, 110, 43, 124, 98, 103, 103, 43, 106, 126, Ascii.DEL, 100, 102, 106, Ascii.DEL, 98, 104, 106, 103, 103, 114, 43, 100, 123, 110, 101, 43, 98, 101, 43, 80, Framer.EXIT_FRAME_PREFIX, 110, 104, Framer.EXIT_FRAME_PREFIX, 86, Framer.EXIT_FRAME_PREFIX, 2, 62, 51, 43, 51, 48, 62, 55, 114, 51, 54, Framer.STDIN_FRAME_PREFIX, Ascii.SUB, 8, Ascii.RS, Ascii.CR, Ascii.ESC, Ascii.SUB, Ascii.ESC, Framer.STDIN_REQUEST_FRAME_PREFIX, 47, 19, Ascii.RS, 6, 93, 82, 87, 91, 80, 74, 97, 74, 81, 85, 91, 80, 122, 109, Ascii.NAK, Ascii.DC4, Ascii.GS, Ascii.DLE, 8, 46, Ascii.DC2, Ascii.GS, Ascii.CAN, Ascii.DC2, Ascii.SUB, 46, 5, Ascii.DC4, 9, 5, 58, Framer.STDOUT_FRAME_PREFIX, 62, 61, 51, 58, 0, 58, Framer.STDOUT_FRAME_PREFIX, 59, 0, 60, 62, Framer.STDIN_FRAME_PREFIX, 59, 8, 3, Ascii.FF, Ascii.SI, 1, 8, Framer.STDERR_FRAME_PREFIX, 4, 3, Ascii.EM, Ascii.US, 2, Framer.STDERR_FRAME_PREFIX, Ascii.SO, Ascii.FF, Ascii.US, 9, Ascii.EM, Ascii.ESC, Ascii.DLE, Ascii.ESC, Ascii.FF, Ascii.ETB, Ascii.GS, Framer.ENTER_FRAME_PREFIX, 10, Ascii.ESC, 6, 10, 66, 69, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, 74, 69, 72, 78, 116, 66, 79, 107, 108, 118, 112, 109, 93, 97, 99, 112, 102, 93, 107, 97, 109, 108, 93, 119, 112, 110, 122, 96, 76, 99, Ascii.DEL, 114, 106, 114, 113, Ascii.DEL, 118, 76, 97, 118, 126, 124, 103, 118, 76, 117, 124, 97, 126, 114, 103, Ascii.ETB, Ascii.CR, Framer.ENTER_FRAME_PREFIX, Ascii.SO, Ascii.DC2, Ascii.US, 7, Ascii.US, Ascii.FS, Ascii.DC2, Ascii.ESC, Framer.ENTER_FRAME_PREFIX, 8, 76, Framer.ENTER_FRAME_PREFIX, Ascii.FS, Ascii.US, Ascii.DLE, Ascii.DLE, Ascii.ESC, Ascii.FF, Framer.ENTER_FRAME_PREFIX, 17, 8, Ascii.ESC, Ascii.FF, Ascii.DC2, Ascii.US, 7, Framer.ENTER_FRAME_PREFIX, Ascii.GS, Ascii.DC2, Ascii.ETB, Ascii.GS, Ascii.NAK, Ascii.US, Ascii.FS, Ascii.DC2, Ascii.ESC, 68, 94, 114, 93, 65, 76, 84, 76, 79, 65, 72, 114, 91, Ascii.US, 114, 79, 76, 67, 67, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 114, 66, 91, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 76, 84, 114, 72, 67, 76, 79, 65, 72, 73, 118, 107, 112, 124, 119, 109, Framer.EXIT_FRAME_PREFIX, 109, 112, 118, 119, 92, 64, 77, 85, 2, 75, 67, 67, 75, 64, 73, 2, 79, 67, 65, 83, 79, 66, 90, 66, 65, 79, 70, 124, 64, 87, 66, 124, 87, 70, 91, 87, 121, 101, 104, 112, 104, 107, 101, 108, 86, 109, 104, 125, 104, Ascii.ETB, Ascii.VT, 6, Ascii.RS, 6, 5, Ascii.VT, 2, 56, 2, 9, 3, 56, 4, 6, Ascii.NAK, 3, 56, 3, 2, Ascii.DC4, 4, 51, 47, 34, 58, 34, Framer.ENTER_FRAME_PREFIX, 47, 38, Ascii.FS, 42, Framer.STDIN_FRAME_PREFIX, 55, Framer.STDOUT_FRAME_PREFIX, 44, Ascii.FS, 32, 34, Framer.STDOUT_FRAME_PREFIX, 39, Ascii.FS, 39, 38, 48, 32, 42, 54, 59, 35, 59, 56, 54, 63, 5, 52, 46, 62, 5, 46, 51, 55, 63, 55, 43, 38, 62, 38, 37, 43, 34, Ascii.CAN, 53, 34, 35, 34, 52, 46, 32, 41, Ascii.CAN, 34, 41, 38, 37, 43, 34, 35, 38, 58, 55, 47, 55, 52, 58, 51, 9, 37, 61, 63, 38, 38, 55, 52, 58, 51, 9, 37, 51, 53, 57, 56, Framer.STDERR_FRAME_PREFIX, 37, 83, 79, 66, 90, 66, 65, 79, 70, 124, 85, 17, 124, 65, 66, 77, 77, 70, 81, 124, 76, 85, 70, 81, 79, 66, 90, 124, 71, 70, 79, 66, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 93, 74, 76, 78, 76, 71, 70, 65, 72, 112, 66, 74, 91, 71, 64, 75, 110, 108, 123, 114, 113, Ascii.DEL, 122, 119, 112, 121, 65, 110, 114, Ascii.DEL, 103, Ascii.DEL, 124, 114, 123, 65, 125, 113, 112, 106, 123, 112, 106, 65, 123, 112, Ascii.DEL, 124, 114, 123, 122, Ascii.FF, Ascii.ESC, 9, Ascii.US, Ascii.FF, Ascii.SUB, Ascii.ESC, Ascii.SUB, Framer.ENTER_FRAME_PREFIX, Ascii.SO, Ascii.DC2, Ascii.US, 7, Framer.ENTER_FRAME_PREFIX, 10, Ascii.ESC, 6, 10, 4, Ascii.FS, Ascii.RS, 7, 7, Ascii.SYN, Ascii.NAK, Ascii.ESC, Ascii.DC2, 40, 4, Ascii.DC2, Ascii.DC4, Ascii.CAN, Ascii.EM, 19, 4, Ascii.EM, Ascii.SUB, 6, Ascii.VT, Ascii.EM, 2, 53, Ascii.EM, 9, Ascii.CAN, Ascii.SI, Ascii.SI, 4, 53, Ascii.SO, Ascii.US, Ascii.CAN, Ascii.VT, Ascii.RS, 3, 5, 4, 42, 41, 53, 56, 42, Framer.STDOUT_FRAME_PREFIX, 6, 42, 58, 43, 60, 60, 55, 6, Framer.STDIN_FRAME_PREFIX, 60, Framer.ENTER_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Ascii.SO, Ascii.NAK, 8, Ascii.DLE, Ascii.DC2, Ascii.VT, Ascii.VT, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.RS, 36, 8, Ascii.RS, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.US, 8, 9, Ascii.SO, Ascii.NAK, 111, 112, 125, 124, 118, 70, 117, 124, Framer.EXIT_FRAME_PREFIX, 125, 112, 119, 126, 70, 105, 117, Framer.EXIT_FRAME_PREFIX, 96, Framer.EXIT_FRAME_PREFIX, 123, 117, 124, 70, 124, 119, Framer.EXIT_FRAME_PREFIX, 123, 117, 124, 125, 99, 124, 113, 112, 122, 74, 121, 112, 116, 113, 124, 123, 114, 74, 101, 121, 116, 108, 116, 119, 121, 112, 74, 96, 123, 102, 126, 124, 101, 101, 116, 119, 121, 112, 74, 97, 124, Framer.EXIT_FRAME_PREFIX, 112, 102, 116, 115, 78, 103, Framer.EXIT_FRAME_PREFIX, 116, 102, 78, 101, Framer.EXIT_FRAME_PREFIX, 124, 116, 126, 100, 101, 78, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 78, 124, Framer.EXIT_FRAME_PREFIX, 125, 125, Framer.EXIT_FRAME_PREFIX, 98, 116, 114, 126, Ascii.DEL, 117, 98};
    }

    static {
        A09();
        A0T = EnumC1309bD.A04;
        A0S = EnumC0921Np.A03;
    }

    public C0920No(String str, String str2, int i3, String str3, String str4, EnumC1309bD enumC1309bD, int i4, boolean z2, boolean z3, EnumC0921Np enumC0921Np, boolean z4, String str5, boolean z5, boolean z6, int i5, String str6, String str7, int i6, String str8, boolean z7, boolean z8, int i7, boolean z9, int i8, String str9) {
        if (z4) {
            this.A0I = UUID.randomUUID().toString();
            this.A0H = XB.A00(str).buildUpon().appendQueryParameter(A04(166, 11, 28), this.A0I).appendQueryParameter(A04(92, 12, 9), str5).build().toString();
        } else {
            this.A0H = str;
            this.A0I = null;
        }
        this.A0G = str2;
        this.A0A = i3;
        this.A0J = str3;
        this.A0F = str4;
        this.A0E = enumC1309bD;
        this.A0C = i4;
        this.A0L = z2;
        this.A06 = z3;
        this.A0D = enumC0921Np;
        this.A0M = z4;
        this.A08 = z5;
        this.A07 = z6;
        this.A01 = i5;
        this.A05 = str6;
        this.A04 = str7;
        this.A0B = i6;
        this.A0K = str8;
        this.A0P = z7;
        this.A0O = z8;
        this.A09 = i7;
        this.A0N = z9;
        this.A00 = i8;
        this.A03 = str9;
    }

    public static int A00(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(340, 13, 62));
        if (jSONObjectOptJSONObject != null) {
            String strA04 = A04(441, 26, 97);
            boolean zHas = jSONObjectOptJSONObject.has(strA04);
            if (A0R[7].length() == 9) {
                throw new RuntimeException();
            }
            A0R[1] = "DEIp";
            if (zHas) {
                return jSONObjectOptJSONObject.optInt(strA04);
            }
        }
        String strA042 = A04(569, 17, 64);
        if (jSONObject.has(strA042)) {
            return jSONObject.optInt(strA042);
        }
        if (A0R[7].length() == 9) {
            throw new RuntimeException();
        }
        A0R[1] = "AI76RAj";
        return jSONObject.optInt(A04(626, 19, 76), 0);
    }

    public static int A01(JSONObject jSONObject, JSONObject jSONObject2) {
        int playableSkippableTimeInSecs = jSONObject2.optInt(A04(399, 17, 109));
        int playableNTDTime = A00(jSONObject);
        if (playableSkippableTimeInSecs > 0 && playableSkippableTimeInSecs < playableNTDTime) {
            return playableNTDTime - playableSkippableTimeInSecs;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C0920No A02(org.json.JSONObject r32) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0920No.A02(org.json.JSONObject):com.facebook.ads.redexgen.X.No");
    }

    public static EnumC1309bD A03(JSONObject jSONObject) {
        int orientation = jSONObject.optInt(A04(297, 11, 46), A0T.A04());
        return EnumC1309bD.A00(orientation);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(154, 12, 73));
        String strA04 = A04(23, 45, 60);
        return jSONObjectOptJSONObject == null ? strA04 : jSONObjectOptJSONObject.optString(A04(106, 16, 70), strA04);
    }

    public static String A06(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A04(323, 17, 20));
        return (strOptString == null || strOptString.isEmpty()) ? A04(0, 7, 56) : strOptString;
    }

    public static String A07(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(154, 12, 73));
        String strA04 = A04(79, 13, 72);
        return jSONObjectOptJSONObject == null ? strA04 : jSONObjectOptJSONObject.optString(A04(551, 18, 73), strA04);
    }

    public static String A08(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A04(608, 18, 110));
        return (strOptString == null || strOptString.isEmpty()) ? A04(7, 16, 69) : strOptString;
    }

    public final int A0A() {
        return this.A00;
    }

    public final int A0B() {
        return this.A09;
    }

    public final int A0C() {
        return this.A0A;
    }

    public final int A0D() {
        return this.A0B;
    }

    public final int A0E() {
        return this.A01;
    }

    public final int A0F() {
        return this.A0C;
    }

    public final EnumC0921Np A0G() {
        return this.A0D;
    }

    public final EnumC1309bD A0H() {
        return this.A0E;
    }

    public final String A0I() {
        return this.A02;
    }

    public final String A0J() {
        return this.A0F;
    }

    public final String A0K() {
        return this.A0G;
    }

    public final String A0L() {
        return this.A0H;
    }

    public final String A0M() {
        return this.A03;
    }

    public final String A0N() {
        return this.A04;
    }

    public final String A0O() {
        return this.A05;
    }

    public final String A0P() {
        return this.A0I;
    }

    public final String A0Q() {
        return this.A0J;
    }

    public final String A0R() {
        return this.A0K;
    }

    public final void A0S(int i3) {
        this.A00 = i3;
    }

    public final void A0T(String str) {
        this.A02 = str;
    }

    public final void A0U(boolean z2) {
        this.A06 = z2;
    }

    public final boolean A0V() {
        return this.A06;
    }

    public final boolean A0W() {
        return this.A0L;
    }

    public final boolean A0X() {
        return this.A07;
    }

    public final boolean A0Y() {
        return this.A0M;
    }

    public final boolean A0Z() {
        return this.A0O;
    }

    public final boolean A0a() {
        return this.A0P;
    }

    public final boolean A0b() {
        return this.A0N;
    }

    public final boolean A0c() {
        return this.A08;
    }
}
