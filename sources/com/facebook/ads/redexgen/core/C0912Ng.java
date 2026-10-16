package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ng, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0912Ng implements Serializable {
    public static byte[] A05 = null;
    public static final long serialVersionUID = 238472947123L;
    public int A00;
    public String A01;
    public String A02;
    public String A03;
    public boolean A04;

    static {
        A05();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0912Ng A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(A04(0, 6, 78));
        String strOptString2 = jSONObject.optString(A04(36, 8, 81));
        String strOptString3 = jSONObject.optString(A04(24, 12, 84));
        int iOptInt = jSONObject.optInt(A04(44, 14, 5), -1);
        boolean zOptBoolean = jSONObject.optBoolean(A04(6, 18, 35), false);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || iOptInt == -1) {
            return null;
        }
        return new C0912Ng(strOptString, strOptString2, strOptString3, iOptInt, zOptBoolean);
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{46, 61, 61, 44, 54, Framer.STDOUT_FRAME_PREFIX, 8, 3, Ascii.SO, Ascii.SO, 4, 3, 5, Ascii.CR, 1, Ascii.VT, Ascii.DLE, Ascii.NAK, Ascii.SYN, 3, 9, Ascii.DC4, 3, Ascii.SI, 67, 52, 54, 62, 52, 58, 56, Framer.STDERR_FRAME_PREFIX, 65, 52, 64, 56, 66, 53, 54, 53, 66, 66, 53, 66, -10, -23, -12, -13, -10, -8, -19, -14, -21, -29, -15, -13, -24, -23};
    }

    public C0912Ng(String str, String str2, String str3, int i3, boolean z2) {
        this.A01 = str;
        this.A03 = str2;
        this.A02 = str3;
        this.A00 = i3;
        this.A04 = z2;
    }

    private final String A01() {
        return this.A01;
    }

    private final String A02() {
        return this.A02;
    }

    private final String A03() {
        return this.A03;
    }

    public static void A06(C0912Ng c0912Ng, C1648gi c1648gi) {
        if (c0912Ng != null && c0912Ng.A09()) {
            new W6(c1648gi).A04(true, c0912Ng.A01(), c0912Ng.A03(), c0912Ng.A02(), System.currentTimeMillis(), c0912Ng.A08());
        }
    }

    public static void A07(C0912Ng c0912Ng, C1648gi c1648gi) {
        if (c0912Ng != null && c0912Ng.A0A()) {
            new W6(c1648gi).A04(false, c0912Ng.A01(), c0912Ng.A03(), c0912Ng.A02(), System.currentTimeMillis(), c0912Ng.A08());
        }
    }

    private final boolean A08() {
        return this.A04;
    }

    private final boolean A09() {
        return (this.A00 & 2) != 0;
    }

    private final boolean A0A() {
        return (this.A00 & 1) != 0;
    }
}
