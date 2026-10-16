package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ck, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0634Ck implements InterfaceC1615gB {
    public static byte[] A01;
    public final boolean A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{75, Ascii.SO, 48, Ascii.FS, Ascii.GS, 7, Ascii.SYN, Ascii.GS, 7, 73, 83, 42, Ascii.GS, Ascii.ESC, Ascii.GS, 17, Ascii.SO, Ascii.GS, 88, Ascii.CR, 10, Ascii.DC4, 66, 88, Ascii.RS, 57, 44, 57, 56, 62, 119, 109};
    }

    public C0634Ck(boolean z2) {
        this.A00 = z2;
    }

    private void A02(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String header : map.get(str)) {
                    String str2 = str + A00(1, 1, 74) + header;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1615gB
    public final boolean AAZ() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1615gB
    public final void ABt(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        String str = httpURLConnection.getRequestMethod() + A00(0, 1, 21) + httpURLConnection.getURL().toString();
        if (obj instanceof String) {
            String str2 = A00(2, 9, 13) + ((String) obj);
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1615gB
    public final void ABu(InterfaceC1598fu interfaceC1598fu) {
        if (interfaceC1598fu != null) {
            String str = A00(11, 13, 6) + interfaceC1598fu.getUrl();
            String str2 = A00(24, 8, 51) + interfaceC1598fu.A9C();
            A02(interfaceC1598fu.A8E());
        }
    }
}
