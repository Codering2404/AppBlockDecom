package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.85, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass85 extends AbstractC1852kH {
    public static byte[] A02;
    public Map<String, String> A00;
    public final Uri A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{36, Framer.ENTER_FRAME_PREFIX, 38, 35};
    }

    public AnonymousClass85(C1648gi c1648gi, VA va, String str, Uri uri, Map<String, String> mExtraData) {
        super(c1648gi, va, str, null, true, true);
        this.A01 = uri;
        this.A00 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1852kH
    public final EnumC0897Mq A0H() {
        A0J(this.A00, null);
        return EnumC0897Mq.A09;
    }

    public final Uri A0M() {
        String uri = this.A01.getQueryParameter(A00(0, 4, 5));
        if (uri == null) {
            uri = A00(0, 0, 121);
        }
        return XB.A00(uri);
    }
}
