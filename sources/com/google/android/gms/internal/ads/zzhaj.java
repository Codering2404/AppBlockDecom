package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhaj {
    private static final byte[] zza;

    static {
        byte[] bArr = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        Arrays.fill(bArr, (byte) -1);
        for (int i3 = 0; i3 < 10; i3++) {
            bArr[i3 + 48] = (byte) i3;
        }
        for (int i4 = 0; i4 < 26; i4++) {
            byte b3 = (byte) (i4 + 10);
            bArr[i4 + 65] = b3;
            bArr[i4 + 97] = b3;
        }
        zza = bArr;
    }

    static int zza(char c3) {
        if (c3 < 128) {
            return zza[c3];
        }
        return -1;
    }
}
