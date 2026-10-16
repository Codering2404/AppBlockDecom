package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2183pt implements AnonymousClass24 {
    public static byte[] A00;
    public static String[] A01 = {"aC8uc30vckBh0ldJ8CsDkWWGmQgl7sOm", "2", "dPCbCdxH5PRV4edn", "QHj", "dDf", "KHWYQA", "nwDl9CeJStZlhkBKgBcw2akg3aHE6X2p", "I5"};
    public static final String A02;
    public static final AnonymousClass23<AbstractC2183pt> A03;

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-126, -101, -104, -101, -100, -92, -101, 77, Ascii.DEL, -114, -95, -106, -101, -108, -127, -90, -99, -110, 103, 77};
    }

    static {
        A07();
        A02 = C5C.A0h(0);
        A03 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pu
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return AbstractC2183pt.A04(bundle);
            }
        };
    }

    public static AbstractC2183pt A04(Bundle bundle) {
        int i3 = bundle.getInt(A02, -1);
        switch (i3) {
            case 0:
                return (AbstractC2183pt) AX.A02.A6f(bundle);
            case 1:
                AbstractC2183pt abstractC2183pt = (AbstractC2183pt) AV.A02.A6f(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr = A01;
                    strArr[7] = "RK";
                    strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    return abstractC2183pt;
                }
                break;
            case 2:
                return (AbstractC2183pt) AU.A04.A6f(bundle);
            case 3:
                AnonymousClass24 anonymousClass24A6f = AT.A02.A6f(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr2 = A01;
                    strArr2[7] = "Vr";
                    strArr2[1] = "2";
                    return (AbstractC2183pt) anonymousClass24A6f;
                }
                break;
            default:
                throw new IllegalArgumentException(A06(0, 20, 36) + i3);
        }
        throw new RuntimeException();
    }
}
