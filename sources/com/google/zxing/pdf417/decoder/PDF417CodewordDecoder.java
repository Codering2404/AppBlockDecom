package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class PDF417CodewordDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[][] f91993a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, PDF417Common.f91974b.length, 8);

    static {
        int i3;
        int i4 = 0;
        while (true) {
            int[] iArr = PDF417Common.f91974b;
            if (i4 >= iArr.length) {
                return;
            }
            int i5 = iArr[i4];
            int i6 = i5 & 1;
            int i7 = 0;
            while (i7 < 8) {
                float f3 = 0.0f;
                while (true) {
                    i3 = i5 & 1;
                    if (i3 == i6) {
                        f3 += 1.0f;
                        i5 >>= 1;
                    }
                }
                f91993a[i4][7 - i7] = f3 / 17.0f;
                i7++;
                i6 = i3;
            }
            i4++;
        }
    }
}
