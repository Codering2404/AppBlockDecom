package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class LocalTime implements Parcelable, Comparable<LocalTime> {
    public static LocalTime e(int i3, int i4) {
        try {
            zzao zzaoVar = new zzao();
            zzaoVar.c(i3);
            zzaoVar.a(i4);
            LocalTime localTimeB = zzaoVar.b();
            int iC = localTimeB.c();
            Preconditions.B(Range.f(0, 23).i(Integer.valueOf(iC)), "Hours must not be out-of-range: 0 to 23, but was: %s.", iC);
            int iD = localTimeB.d();
            Preconditions.B(Range.f(0, 59).i(Integer.valueOf(iD)), "Minutes must not be out-of-range: 0 to 59, but was: %s.", iD);
            return localTimeB;
        } catch (IllegalStateException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(LocalTime localTime) {
        int iC;
        int iC2;
        Preconditions.u(localTime, "compare must not be null.");
        if (this == localTime) {
            return 0;
        }
        if (c() == localTime.c()) {
            iC = d();
            iC2 = localTime.d();
        } else {
            iC = c();
            iC2 = localTime.c();
        }
        return iC - iC2;
    }

    public abstract int c();

    public abstract int d();
}
