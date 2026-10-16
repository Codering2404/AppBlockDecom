package com.google.zxing.oned;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CodaBarReader extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f91908a = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f91909b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f91910c = {'A', 'B', 'C', 'D'};

    static boolean a(char[] cArr, char c3) {
        if (cArr != null) {
            for (char c4 : cArr) {
                if (c4 == c3) {
                    return true;
                }
            }
        }
        return false;
    }
}
