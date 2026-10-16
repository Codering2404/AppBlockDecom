package com.google.android.gms.internal.ads;

import androidx.appcompat.app.jE.vxrlPPpdv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziaj {
    public static byte[] zza(String str) {
        if ((str.length() & 1) == 0) {
            int length = str.length() >> 1;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 + i3;
                int iDigit = Character.digit(str.charAt(i4), 16);
                int iDigit2 = Character.digit(str.charAt(i4 + 1), 16);
                if (iDigit != -1 && iDigit2 != -1) {
                    bArr[i3] = (byte) ((iDigit * 16) + iDigit2);
                } else {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException(vxrlPPpdv.mjeqZoShLCU);
    }
}
