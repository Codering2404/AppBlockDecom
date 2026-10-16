package com.google.crypto.tink.subtle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Hex {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            int i3 = b3 & 255;
            sb.append("0123456789abcdef".charAt(i3 / 16));
            sb.append("0123456789abcdef".charAt(i3 % 16));
        }
        return sb.toString();
    }
}
