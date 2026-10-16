package com.google.android.gms.internal.ads;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazi {
    public static String zza(byte[] bArr, boolean z2) {
        return Base64.encodeToString(bArr, true != z2 ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z2) throws IllegalArgumentException {
        byte[] bArrDecode = Base64.decode(str, 2);
        if (bArrDecode.length != 0 || str.length() <= 0) {
            return bArrDecode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
