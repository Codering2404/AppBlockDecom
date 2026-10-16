package com.airbnb.lottie.parser.moshi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class JsonScope {
    static String a(int i3, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            if (i5 == 1 || i5 == 2) {
                sb.append('[');
                sb.append(iArr2[i4]);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String str = strArr[i4];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
