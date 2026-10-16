package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class LocalDate implements Parcelable, Comparable<LocalDate> {
    public static LocalDate f(int i3, int i4, int i5) {
        zzam zzamVar = new zzam();
        zzamVar.d(i3);
        zzamVar.a(i4);
        zzamVar.b(i5);
        LocalDate localDateC = zzamVar.c();
        int iD = localDateC.d();
        Range rangeF = Range.f(1, 12);
        Integer numValueOf = Integer.valueOf(iD);
        Preconditions.h(rangeF.i(numValueOf), "Month must not be out of range of 1 to 12, but was: %s.", iD);
        int iC = localDateC.c();
        Range rangeF2 = Range.f(1, 31);
        Integer numValueOf2 = Integer.valueOf(iC);
        Preconditions.h(rangeF2.i(numValueOf2), "Day must not be out of range of 1 to 31, but was: %s.", iC);
        if (Arrays.asList(4, 6, 9, 11).contains(numValueOf)) {
            Preconditions.i(Range.f(1, 30).i(numValueOf2), "%s is not a valid day for month %s.", iC, iD);
        }
        if (iD == 2) {
            int iE = localDateC.e();
            Preconditions.p(Range.f(1, Integer.valueOf(iE % 4 == 0 ? 29 : 28)).i(numValueOf2), "%s is not a valid day for month %s in year %s.", numValueOf2, 2, Integer.valueOf(iE));
        }
        return localDateC;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(LocalDate localDate) {
        int iC;
        int iC2;
        Preconditions.u(localDate, "dateToCompare must not be null.");
        if (this == localDate) {
            return 0;
        }
        if (e() != localDate.e()) {
            iC = e();
            iC2 = localDate.e();
        } else if (d() != localDate.d()) {
            iC = d();
            iC2 = localDate.d();
        } else {
            iC = c();
            iC2 = localDate.c();
        }
        return iC - iC2;
    }

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public final String toString() {
        return String.format(Locale.getDefault(), "%s-%s-%s", Integer.valueOf(e()), String.format(Locale.getDefault(), "%02d", Integer.valueOf(d())), String.format(Locale.getDefault(), "%02d", Integer.valueOf(c())));
    }
}
