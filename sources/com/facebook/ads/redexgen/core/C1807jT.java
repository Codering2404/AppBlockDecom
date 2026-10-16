package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1807jT extends NQ implements Serializable {
    public static byte[] A0E = null;
    public static final long serialVersionUID = 3751287062553772011L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public boolean A08;
    public boolean A09;
    public final List<AbstractC1813jd> A0D;
    public final ArrayList<Integer> A0C = new ArrayList<>();
    public boolean A0A = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public String A05 = A02(280, 2, 22);
    public final String A0B = UUID.randomUUID().toString();

    static {
        A05();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{93, 88, 79, 117, 126, 119, Ascii.DEL, Framer.EXIT_FRAME_PREFIX, 73, 102, 119, 100, 119, 123, 101, 17, Ascii.SUB, 19, Ascii.ESC, Ascii.FS, Ascii.ETB, Ascii.SYN, Framer.STDIN_FRAME_PREFIX, 19, Ascii.SYN, 1, Framer.STDIN_FRAME_PREFIX, 17, Ascii.GS, 7, Ascii.FS, 6, 54, 61, 52, 60, 59, 48, Framer.STDOUT_FRAME_PREFIX, 10, 52, Framer.STDOUT_FRAME_PREFIX, 38, 10, 56, 52, Framer.STDIN_FRAME_PREFIX, 10, Framer.STDOUT_FRAME_PREFIX, 32, 39, 52, Framer.ENTER_FRAME_PREFIX, 60, 58, 59, 73, 66, 75, 67, 68, 79, 78, 117, 75, 78, 89, 117, 92, 75, 88, 67, 79, 68, 94, 74, 65, 72, 64, 71, 64, 71, 78, 118, 79, 70, 91, 74, 76, 118, Framer.STDIN_REQUEST_FRAME_PREFIX, 64, 76, 94, 118, 93, 64, 68, 76, 90, 110, 101, 111, 84, 104, 106, 121, 111, 84, 106, 126, Ascii.DEL, 100, 84, 104, 103, 100, Framer.EXIT_FRAME_PREFIX, 110, 84, Ascii.DEL, 98, 102, 110, 118, 113, 123, 122, 103, 64, 107, 112, 64, 109, 122, 111, 112, 109, 107, 64, 115, 112, 126, 123, 122, 123, 65, 86, 67, 92, 65, 71, 108, 85, 90, 65, 64, 71, 108, 86, 80, 67, 94, 108, 92, 93, Framer.STDIN_REQUEST_FRAME_PREFIX, 74, Ascii.FF, Ascii.ESC, Ascii.SO, 17, Ascii.FF, 10, Framer.ENTER_FRAME_PREFIX, Ascii.CAN, Ascii.ETB, Ascii.FF, Ascii.CR, 10, Framer.ENTER_FRAME_PREFIX, Ascii.ETB, 19, Ascii.SO, Ascii.FF, Ascii.ESC, Ascii.CR, Ascii.CR, Ascii.ETB, 17, Ascii.DLE, Framer.ENTER_FRAME_PREFIX, 17, Ascii.DLE, Ascii.DC2, 7, 17, 10, Ascii.CR, Ascii.NAK, 61, 17, 7, 1, Ascii.CR, Ascii.FF, 6, 61, 3, 6, 61, Ascii.CR, Ascii.FF, 61, 3, 6, 61, Ascii.DLE, 7, Ascii.DC2, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.VT, Ascii.FF, 5, Ascii.SO, Ascii.NAK, Ascii.DC2, 10, 34, Ascii.SO, Ascii.CAN, Ascii.RS, Ascii.DC2, 19, Ascii.EM, 34, Ascii.FS, Ascii.EM, 34, Ascii.DC2, 19, 34, Ascii.VT, Ascii.DC4, Ascii.EM, Ascii.CAN, Ascii.DC2, 34, Ascii.CR, 17, Ascii.FS, 4, Ascii.US, Ascii.FS, Ascii.RS, Ascii.SYN, 34, Ascii.CAN, Ascii.SI, Ascii.SI, Ascii.DC2, Ascii.SI, 3, 0, Ascii.FS, Ascii.EM, 4, 47, Ascii.SYN, Ascii.US, 2, 19, Ascii.NAK, 47, 6, Ascii.EM, Ascii.NAK, 7, 72, 78};
    }

    public C1807jT(List<AbstractC1813jd> list) {
        this.A0D = list;
    }

    public static C1807jT A00(JSONObject jSONObject, C1648gi c1648gi) throws JSONException {
        return A01(jSONObject, c1648gi, false);
    }

    public static C1807jT A01(JSONObject jSONObject, C1648gi c1648gi, boolean z2) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(A02(0, 3, 25));
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (z2) {
                arrayList.add(C05257n.A00(jSONArray.getJSONObject(i3), c1648gi));
            } else {
                arrayList.add(C05237l.A00(jSONArray.getJSONObject(i3), c1648gi));
            }
        }
        C1807jT c1807jT = new C1807jT(arrayList);
        JSONObject chainingParams = jSONObject.getJSONObject(A02(3, 12, 51));
        c1807jT.A05 = chainingParams.toString();
        c1807jT.A01 = chainingParams.optInt(A02(15, 17, 87), arrayList.size());
        c1807jT.A04 = chainingParams.optInt(A02(32, 24, 112), 0);
        c1807jT.A02 = chainingParams.optInt(A02(100, 24, 46), 0);
        c1807jT.A03 = chainingParams.optInt(A02(124, 22, 58), 0);
        c1807jT.A09 = chainingParams.optBoolean(A02(226, 38, 88), true);
        c1807jT.A08 = chainingParams.optBoolean(A02(196, 30, 71), true);
        c1807jT.A00 = chainingParams.optInt(A02(56, 19, 15), 2);
        c1807jT.A1P(chainingParams);
        c1807jT.A0A = chainingParams.optBoolean(A02(264, 16, 85), false);
        c1807jT.A07 = chainingParams.optBoolean(A02(168, 28, 91), false);
        c1807jT.A06 = chainingParams.optBoolean(A02(146, 22, 22), false);
        JSONArray jSONArrayOptJSONArray = chainingParams.optJSONArray(A02(75, 25, 12));
        if (jSONArrayOptJSONArray != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                c1807jT.A0C.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i4, 0)));
            }
        }
        return c1807jT;
    }

    @Override // com.facebook.ads.redexgen.core.NQ
    public final int A0o() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.core.NQ
    public final int A0p() {
        return this.A04 + this.A02;
    }

    public final int A22() {
        return this.A00;
    }

    public final int A23() {
        return this.A01;
    }

    public final int A24() {
        return this.A02;
    }

    public final int A25() {
        return this.A03;
    }

    public final AbstractC1813jd A26() {
        if (!this.A0D.isEmpty()) {
            return this.A0D.get(0);
        }
        return null;
    }

    public final AbstractC1813jd A27(int i3) {
        return this.A0D.get(i3);
    }

    public final String A28() {
        return this.A0B;
    }

    public final String A29() {
        return this.A05;
    }

    public final String A2A() {
        AbstractC1813jd firstAdDataBundle = A26();
        if (firstAdDataBundle != null) {
            return firstAdDataBundle.A2E();
        }
        return null;
    }

    public final ArrayList<Integer> A2B() {
        return this.A0C;
    }

    public final void A2C(int i3) {
        this.A0D.remove(i3);
        this.A01--;
    }

    public final boolean A2D() {
        return this.A00 == 0;
    }

    public final boolean A2E() {
        return this.A06;
    }

    public final boolean A2F() {
        return this.A07;
    }

    public final boolean A2G() {
        return this.A08;
    }

    public final boolean A2H() {
        return this.A09;
    }

    public final boolean A2I() {
        return this.A0A;
    }

    public final boolean A2J(int i3) {
        return i3 >= 0 && i3 < this.A0D.size();
    }
}
