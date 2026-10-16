package com.google.android.gms.common.util;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Hex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f72276a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f72277b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i3 = 0;
        for (byte b3 : bArr) {
            char[] cArr2 = f72277b;
            cArr[i3] = cArr2[(b3 & 255) >>> 4];
            cArr[i3 + 1] = cArr2[b3 & Ascii.SI];
            i3 += 2;
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr) {
        return c(bArr, false);
    }

    public static String c(byte[] bArr, boolean z2) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i3 = 0; i3 < length && (!z2 || i3 != length - 1 || (bArr[i3] & 255) != 0); i3++) {
            char[] cArr = f72276a;
            sb.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb.append(cArr[bArr[i3] & Ascii.SI]);
        }
        return sb.toString();
    }

    public static byte[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        byte[] bArr = new byte[length / 2];
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 2;
            bArr[i3 / 2] = (byte) Integer.parseInt(str.substring(i3, i4), 16);
            i3 = i4;
        }
        return bArr;
    }
}
