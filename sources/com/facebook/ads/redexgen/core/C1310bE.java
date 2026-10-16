package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1310bE implements InterfaceC0875Lu {
    public static byte[] A01;
    public final T8 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-93, -73, -56, -82, -118, -71, -78, -78, -87, -80, -87, -40, -47, -47, -56, -49, -99, -125, -39, -24, -2, -52, -3, -20, -11, -5, -26, -117, -102, -109, -109, -118, -111, -68, -53, -60, -60, -69, -62, -75, -62, -59, -67, -67, -69, -70, -58, -43, -50, -50, -59, -52, -65, -52, -49, -57, -57, -55, -50, -57, -65, -51, -49, -60, -59};
    }

    public C1310bE(T8 t8) {
        this.A00 = t8;
    }

    private void A02(int i3, String str, JSONObject jSONObject, boolean z2, int i4) {
        C1061Te c1061Te = new C1061Te(A00(4, 6, 44));
        c1061Te.A07(jSONObject);
        c1061Te.A05(1);
        c1061Te.A09(z2);
        c1061Te.A04(i4);
        try {
            jSONObject.put(A00(33, 13, 62), TX.A0H(this.A00));
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put(A00(46, 19, 72), i4);
        } catch (JSONException unused2) {
        }
        this.A00.A08().ABD(A00(27, 6, 13), i3 + 4000, c1061Te);
        if (this.A00.A05().AAO()) {
            String str2 = A00(10, 8, 75) + str + A00(0, 1, 99) + i3 + A00(1, 3, 118) + jSONObject.toString();
        }
    }

    public static boolean A03(EnumC0877Lw enumC0877Lw) {
        for (EnumC0877Lw enumC0877Lw2 : ZJ.A06) {
            if (enumC0877Lw2.equals(enumC0877Lw)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0875Lu
    public final void ABE(EnumC0877Lw enumC0877Lw, JSONObject jSONObject, int i3) {
        A02(enumC0877Lw.A03(), enumC0877Lw.toString(), jSONObject, A03(enumC0877Lw), i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0875Lu
    public final void ABs(int i3, JSONObject jSONObject, int i4) {
        A02(i3, A00(18, 9, 111) + i3, jSONObject, false, i4);
    }
}
