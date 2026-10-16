package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2211qN {
    public static <K, V> Map<K, V> A00(int expectedSize) {
        return C2049nh.A0B(expectedSize);
    }

    public static <T> T[] A01(T[] tArr, int i3) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i3);
    }

    public static <T> T[] A02(Object[] objArr, int i3, int i4, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i3, i4, tArr.getClass());
    }
}
