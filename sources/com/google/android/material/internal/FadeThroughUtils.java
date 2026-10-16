package com.google.android.material.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class FadeThroughUtils {
    static void a(float f3, float[] fArr) {
        if (f3 <= 0.5f) {
            fArr[0] = 1.0f - (f3 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f3 * 2.0f) - 1.0f;
        }
    }
}
