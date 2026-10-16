package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcgb {
    public static final int a(zzcfs zzcfsVar, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(zzcfsVar, "<this>");
        int[] iArrR = zzcfsVar.r();
        int length = zzcfsVar.q().length;
        Intrinsics.checkNotNullParameter(iArrR, "<this>");
        int i5 = length - 1;
        int i6 = 0;
        while (true) {
            if (i6 <= i5) {
                int i7 = i3 + 1;
                i4 = (i6 + i5) >>> 1;
                int i8 = iArrR[i4];
                if (i8 >= i7) {
                    if (i8 <= i7) {
                        break;
                    }
                    i5 = i4 - 1;
                } else {
                    i6 = i4 + 1;
                }
            } else {
                i4 = (-i6) - 1;
                break;
            }
        }
        return i4 >= 0 ? i4 : ~i4;
    }
}
