package com.google.android.libraries.places.widget.internal.placedetails;

import kotlin.ranges.OpenEndRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbr {
    public static final zzbs a(double d3) {
        int i3 = (int) d3;
        if (i3 <= 0 || i3 >= 5) {
            return i3 == 5 ? new zzbs(5, false) : new zzbs(0, false);
        }
        OpenEndRange openEndRangeC = RangesKt.c(0.0d, 0.25d);
        Double dValueOf = Double.valueOf(d3 - ((double) i3));
        return openEndRangeC.b(dValueOf) ? new zzbs(i3, false) : RangesKt.c(0.25d, 0.75d).b(dValueOf) ? new zzbs(i3, true) : new zzbs(i3 + 1, false);
    }
}
