package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AU extends AbstractC2183pt {
    public static byte[] A02;
    public static String[] A03 = {"Ze0y2PQb31vngbi38k5mfZCC", "5", "jLmR5cr6Hwks3p4PsKfIxGU921nipvRD", "Pp3qhBBlWU8bouyoK5QiOWA", "ww40dK", "331B", "UQZ2ltoBgBcCSgXWY09raSZ", "C"};
    public static final AnonymousClass23<AU> A04;
    public static final String A05;
    public static final String A06;
    public final float A00;
    public final int A01;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A03[4] = "26ayShss4mhG1SZ6mAOlhU0";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 13);
            i6++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-108, -120, -97, 122, -101, -120, -103, -102, 71, -108, -100, -102, -101, 71, -119, -116, 71, -120, 71, -105, -106, -102, -112, -101, -112, -99, -116, 71, -112, -107, -101, -116, -114, -116, -103, -68, -67, -86, -69, -101, -86, -67, -78, -73, -80, 105, -78, -68, 105, -72, -66, -67, 105, -72, -81, 105, -69, -86, -73, -80, -82, 105, -92, 121, 117, 105, -74, -86, -63, -100, -67, -86, -69, -68, -90};
    }

    static {
        A03();
        A05 = C5C.A0h(1);
        A06 = C5C.A0h(2);
        A04 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.ps
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return AU.A00(bundle);
            }
        };
    }

    public AU(int i3) {
        AbstractC04323y.A09(i3 > 0, A02(0, 35, 26));
        this.A01 = i3;
        this.A00 = -1.0f;
    }

    public AU(int i3, float f3) {
        AbstractC04323y.A09(i3 > 0, A02(0, 35, 26));
        AbstractC04323y.A09(f3 >= 0.0f && f3 <= ((float) i3), A02(35, 40, 60));
        this.A01 = i3;
        this.A00 = f3;
    }

    public static AU A00(Bundle bundle) {
        AbstractC04323y.A07(bundle.getInt(AbstractC2183pt.A02, -1) == 2);
        int i3 = bundle.getInt(A05, 5);
        float starRating = bundle.getFloat(A06, -1.0f);
        if (starRating == -1.0f) {
            return new AU(i3);
        }
        return new AU(i3, starRating);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AU)) {
            return false;
        }
        AU au = (AU) obj;
        return this.A01 == au.A01 && this.A00 == au.A00;
    }

    public final int hashCode() {
        return CB.A00(Integer.valueOf(this.A01), Float.valueOf(this.A00));
    }
}
