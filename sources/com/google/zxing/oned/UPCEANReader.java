package com.google.zxing.oned;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class UPCEANReader extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f91936a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f91937b = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f91938c = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[][] f91939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[][] f91940e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f91939d = iArr;
        int[][] iArr2 = new int[20][];
        f91940e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i3 = 10; i3 < 20; i3++) {
            int[] iArr3 = f91939d[i3 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i4 = 0; i4 < iArr3.length; i4++) {
                iArr4[i4] = iArr3[(iArr3.length - i4) - 1];
            }
            f91940e[i3] = iArr4;
        }
    }

    static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i3 = length - 1;
        return b(charSequence.subSequence(0, i3)) == Character.digit(charSequence.charAt(i3), 10);
    }

    static int b(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i3 = 0;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt = charSequence.charAt(i4) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.a();
            }
            i3 += iCharAt;
        }
        int i5 = i3 * 3;
        for (int i6 = length - 2; i6 >= 0; i6 -= 2) {
            int iCharAt2 = charSequence.charAt(i6) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.a();
            }
            i5 += iCharAt2;
        }
        return (1000 - i5) % 10;
    }
}
