package io.reactivex.internal.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Pow2 {
    public static int a(int i3) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i3 - 1));
    }
}
