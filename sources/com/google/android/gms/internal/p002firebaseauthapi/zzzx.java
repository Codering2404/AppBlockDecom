package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzx {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            int i3 = b3 & 255;
            sb.append("0123456789abcdef".charAt(i3 / 16));
            sb.append("0123456789abcdef".charAt(i3 % 16));
        }
        return sb.toString();
    }

    public static byte[] zza(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                int iDigit = Character.digit(str.charAt(i4), 16);
                int iDigit2 = Character.digit(str.charAt(i4 + 1), 16);
                if (iDigit != -1 && iDigit2 != -1) {
                    bArr[i3] = (byte) ((iDigit << 4) + iDigit2);
                } else {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }
}
