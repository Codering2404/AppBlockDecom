package com.iab.omid.library.applovin.devicevolume;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public float a(int i3, int i4) {
        if (i4 <= 0 || i3 <= 0) {
            return 0.0f;
        }
        float f3 = i3 / i4;
        if (f3 > 1.0f) {
            return 1.0f;
        }
        return f3;
    }
}
