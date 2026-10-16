package com.google.android.gms.tagmanager;

import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp {
    public static byte[] zzb(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("purported base16 string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            int iDigit = Character.digit(str.charAt(i3), 16);
            int iDigit2 = Character.digit(str.charAt(i3 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("purported base16 string has illegal char");
            }
            bArr[i3 / 2] = (byte) ((iDigit << 4) + iDigit2);
        }
        return bArr;
    }

    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b3 : bArr) {
            if ((b3 & 240) == 0) {
                sb.append(wgbAZXYjrv.ionYEAGZcQNywC);
            }
            sb.append(Integer.toHexString(b3 & 255));
        }
        return sb.toString().toUpperCase();
    }
}
