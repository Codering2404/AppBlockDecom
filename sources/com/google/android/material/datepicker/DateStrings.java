package com.google.android.material.datepicker;

import android.content.Context;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DateStrings {
    static Pair a(Long l3, Long l4) {
        return b(l3, l4, null);
    }

    static Pair b(Long l3, Long l4, SimpleDateFormat simpleDateFormat) {
        if (l3 == null && l4 == null) {
            return Pair.a(null, null);
        }
        if (l3 == null) {
            return Pair.a(null, d(l4.longValue(), simpleDateFormat));
        }
        if (l4 == null) {
            return Pair.a(d(l3.longValue(), simpleDateFormat), null);
        }
        Calendar calendarK = UtcDates.k();
        Calendar calendarM = UtcDates.m();
        calendarM.setTimeInMillis(l3.longValue());
        Calendar calendarM2 = UtcDates.m();
        calendarM2.setTimeInMillis(l4.longValue());
        if (simpleDateFormat != null) {
            return Pair.a(simpleDateFormat.format(new Date(l3.longValue())), simpleDateFormat.format(new Date(l4.longValue())));
        }
        return calendarM.get(1) == calendarM2.get(1) ? calendarM.get(1) == calendarK.get(1) ? Pair.a(g(l3.longValue(), Locale.getDefault()), g(l4.longValue(), Locale.getDefault())) : Pair.a(g(l3.longValue(), Locale.getDefault()), n(l4.longValue(), Locale.getDefault())) : Pair.a(n(l3.longValue(), Locale.getDefault()), n(l4.longValue(), Locale.getDefault()));
    }

    static String c(long j3) {
        return d(j3, null);
    }

    static String d(long j3, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j3)) : q(j3) ? f(j3) : m(j3);
    }

    static String e(Context context, long j3, boolean z2, boolean z3, boolean z4) {
        String strJ = j(j3);
        if (z2) {
            strJ = String.format(context.getString(R.string.Y), strJ);
        }
        return z3 ? String.format(context.getString(R.string.U), strJ) : z4 ? String.format(context.getString(R.string.I), strJ) : strJ;
    }

    static String f(long j3) {
        return g(j3, Locale.getDefault());
    }

    static String g(long j3, Locale locale) {
        return UtcDates.b(locale).format(new Date(j3));
    }

    static String h(long j3) {
        return i(j3, Locale.getDefault());
    }

    static String i(long j3, Locale locale) {
        return UtcDates.h(locale).format(new Date(j3));
    }

    static String j(long j3) {
        return q(j3) ? h(j3) : o(j3);
    }

    static String k(Context context, int i3) {
        return UtcDates.k().get(1) == i3 ? String.format(context.getString(R.string.N), Integer.valueOf(i3)) : String.format(context.getString(R.string.O), Integer.valueOf(i3));
    }

    static String l(long j3) {
        return UtcDates.p(Locale.getDefault()).format(new Date(j3));
    }

    static String m(long j3) {
        return n(j3, Locale.getDefault());
    }

    static String n(long j3, Locale locale) {
        return UtcDates.o(locale).format(new Date(j3));
    }

    static String o(long j3) {
        return p(j3, Locale.getDefault());
    }

    static String p(long j3, Locale locale) {
        return UtcDates.q(locale).format(new Date(j3));
    }

    private static boolean q(long j3) {
        Calendar calendarK = UtcDates.k();
        Calendar calendarM = UtcDates.m();
        calendarM.setTimeInMillis(j3);
        return calendarK.get(1) == calendarM.get(1);
    }
}
