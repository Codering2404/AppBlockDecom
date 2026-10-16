package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1823jn implements InterfaceC0903Mw {
    public static byte[] A08;
    public final EnumC0902Mv A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final String A05;
    public final Collection<String> A06;
    public final Map<String, String> A07;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1823jn A00(AnonymousClass76 anonymousClass76, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A01(33, 6, 120));
        String strOptString2 = jSONObject.optString(A01(0, 18, 118));
        String strOptString3 = jSONObject.optString(A01(47, 10, 52));
        String strA02 = AbstractC1159Xd.A02(jSONObject, A01(18, 2, 83));
        EnumC0902Mv enumC0902MvA00 = AbstractC0904Mx.A00(jSONObject);
        Collection<String> collectionA03 = AbstractC0904Mx.A03(anonymousClass76, jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(39, 8, 66));
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject.optString(next));
            }
        }
        return new C1823jn(strOptString, strOptString2, enumC0902MvA00, collectionA03, map, strOptString3, strA02, AbstractC1159Xd.A02(jSONObject, A01(20, 13, 89)));
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{78, 80, 97, 86, 99, 78, 97, 86, 92, 91, 76, 80, 92, 90, 90, 78, 91, 81, Framer.STDIN_FRAME_PREFIX, 62, 53, 62, 51, 66, 73, 64, 68, 53, 52, 47, 51, 64, 61, 92, 80, 97, 90, 100, Framer.STDIN_REQUEST_FRAME_PREFIX, 38, Ascii.RS, Framer.STDIN_FRAME_PREFIX, Ascii.SUB, Ascii.GS, Ascii.SUB, Framer.STDIN_FRAME_PREFIX, Ascii.SUB, Ascii.GS, Ascii.DLE, Ascii.FS, 32, Ascii.DLE, Ascii.RS, Ascii.US, 10, Ascii.DC4, Ascii.SI};
    }

    public C1823jn(String str, String str2, EnumC0902Mv enumC0902Mv, Collection<String> detectionStrings, Map<String, String> metadata, String str3, String str4, String str5) {
        this.A04 = str;
        this.A01 = str2;
        this.A00 = enumC0902Mv;
        this.A06 = detectionStrings;
        this.A07 = metadata;
        this.A05 = str3;
        this.A02 = str4;
        this.A03 = str5;
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A04;
    }

    public final String A05() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final String A7O() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final Collection<String> A7p() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final EnumC0902Mv A8K() {
        return this.A00;
    }
}
