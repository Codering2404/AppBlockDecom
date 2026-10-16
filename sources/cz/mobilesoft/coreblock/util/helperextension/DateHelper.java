package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import com.facebook.AccessTokenManager;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import java.util.Calendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class DateHelper {
    public static DayFlags[] a() {
        if (o()) {
            int iB = b();
            return iB != 1 ? iB != 6 ? iB != 7 ? new DayFlags[]{DayFlags.SUNDAY, DayFlags.SATURDAY, DayFlags.FRIDAY, DayFlags.THURSDAY, DayFlags.WEDNESDAY, DayFlags.TUESDAY, DayFlags.MONDAY} : new DayFlags[]{DayFlags.FRIDAY, DayFlags.THURSDAY, DayFlags.WEDNESDAY, DayFlags.TUESDAY, DayFlags.MONDAY, DayFlags.SUNDAY, DayFlags.SATURDAY} : new DayFlags[]{DayFlags.THURSDAY, DayFlags.WEDNESDAY, DayFlags.TUESDAY, DayFlags.MONDAY, DayFlags.SUNDAY, DayFlags.SATURDAY, DayFlags.FRIDAY} : new DayFlags[]{DayFlags.SATURDAY, DayFlags.FRIDAY, DayFlags.THURSDAY, DayFlags.WEDNESDAY, DayFlags.TUESDAY, DayFlags.MONDAY, DayFlags.SUNDAY};
        }
        int iB2 = b();
        return iB2 != 1 ? iB2 != 6 ? iB2 != 7 ? new DayFlags[]{DayFlags.MONDAY, DayFlags.TUESDAY, DayFlags.WEDNESDAY, DayFlags.THURSDAY, DayFlags.FRIDAY, DayFlags.SATURDAY, DayFlags.SUNDAY} : new DayFlags[]{DayFlags.SATURDAY, DayFlags.SUNDAY, DayFlags.MONDAY, DayFlags.TUESDAY, DayFlags.WEDNESDAY, DayFlags.THURSDAY, DayFlags.FRIDAY} : new DayFlags[]{DayFlags.FRIDAY, DayFlags.SATURDAY, DayFlags.SUNDAY, DayFlags.MONDAY, DayFlags.TUESDAY, DayFlags.WEDNESDAY, DayFlags.THURSDAY} : new DayFlags[]{DayFlags.SUNDAY, DayFlags.MONDAY, DayFlags.TUESDAY, DayFlags.WEDNESDAY, DayFlags.THURSDAY, DayFlags.FRIDAY, DayFlags.SATURDAY};
    }

    public static int b() {
        return TimeHelperExt.A().getFirstDayOfWeek();
    }

    public static String c(Long l3) {
        if (l3.longValue() == 0) {
            return "";
        }
        int iLongValue = (int) (l3.longValue() / 60);
        int i3 = iLongValue / 60;
        int i4 = iLongValue - (i3 * 60);
        if (i4 == 0 && i3 == 0) {
            return String.format(Locale.getDefault(), "%ds", Integer.valueOf(l3.intValue()));
        }
        StringBuilder sb = new StringBuilder();
        if (i3 > 0) {
            sb.append(i3);
            sb.append("h ");
        }
        sb.append(i4);
        sb.append("m");
        return sb.toString();
    }

    public static String d(Long l3, int i3) {
        int iLongValue = (int) (l3.longValue() / 60);
        int i4 = iLongValue / 60;
        int i5 = iLongValue - (i4 * 60);
        int iIntValue = l3.intValue() - (i5 * 60);
        StringBuilder sb = new StringBuilder();
        if (i4 > 0) {
            sb.append(i4);
            sb.append("h ");
        }
        if (i5 > 0) {
            sb.append(i5);
            sb.append("m ");
        }
        if ((i5 < i3 || i3 == -1) && i4 == 0) {
            sb.append(iIntValue);
            sb.append("s");
        }
        return sb.toString();
    }

    public static String e(long j3) {
        String str;
        long hours = TimeUnit.SECONDS.toHours(j3);
        if (hours > 0) {
            j3 -= TimeUnit.HOURS.toSeconds(hours);
            str = hours + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        } else {
            str = "";
        }
        long j4 = j3 / 60;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        Locale locale = Locale.US;
        sb.append(String.format(locale, "%02d", Long.valueOf(j4)));
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(String.format(locale, "%02d", Long.valueOf(j3 - (60 * j4))));
        return sb.toString();
    }

    public static long f(Interval interval) {
        Calendar calendarA = TimeHelperExt.A();
        int iB = (int) (interval.b() / 60);
        int iAbs = (int) Math.abs(interval.b() - (((long) iB) * 60));
        calendarA.set(11, iB);
        calendarA.set(12, iAbs);
        return calendarA.getTimeInMillis();
    }

    public static String g(Context context, long j3, boolean z2) {
        if (j3 < 60000) {
            return context.getString(R.string.Ev, Integer.valueOf(((int) j3) / 1000));
        }
        if (j3 < 3600000) {
            int i3 = ((int) j3) / 60000;
            return context.getString(R.string.Pj, Integer.valueOf(i3), Integer.valueOf(((int) (j3 / 1000)) - (i3 * 60)));
        }
        if (j3 <= 86400000) {
            int i4 = ((int) j3) / 3600000;
            int i5 = ((int) (j3 / 60000)) - (i4 * 60);
            return context.getString(R.string.Kf, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf((((int) (j3 / 1000)) - (i4 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS)) - (i5 * 60)));
        }
        int i6 = (int) (j3 / 86400000);
        int i7 = ((int) (j3 / 3600000)) - (i6 * 24);
        int i8 = (((int) (j3 / 60000)) - (i6 * 1440)) - (i7 * 60);
        return z2 ? context.getString(R.string.d9, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)) : context.getString(R.string.e9, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(((((int) (j3 / 1000)) - (AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS * i6)) - (i7 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS)) - (i8 * 60)));
    }

    public static Calendar h() {
        Calendar calendarA = TimeHelperExt.A();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        return calendarA;
    }

    public static long i() {
        Calendar calendarA = TimeHelperExt.A();
        long timeInMillis = calendarA.getTimeInMillis();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        return timeInMillis - calendarA.getTimeInMillis();
    }

    public static Calendar j() {
        Calendar calendarH = h();
        calendarH.add(6, 1);
        return calendarH;
    }

    public static String k(Context context, long j3) {
        if (j3 < 60000) {
            return context.getString(R.string.Ev, Integer.valueOf(((int) j3) / 1000));
        }
        if (j3 < 3600000) {
            int i3 = ((int) j3) / 60000;
            int i4 = ((int) (j3 / 1000)) - (i3 * 60);
            return i4 > 0 ? context.getString(R.string.Pj, Integer.valueOf(i3), Integer.valueOf(i4)) : context.getString(R.string.Oj, Integer.valueOf(i3));
        }
        if (j3 > 86400000) {
            int i5 = (int) (j3 / 86400000);
            return context.getString(R.string.c9, Integer.valueOf(i5), Integer.valueOf(((int) (j3 / 3600000)) - (i5 * 24)));
        }
        int i6 = ((int) j3) / 3600000;
        int i7 = ((int) (j3 / 60000)) - (i6 * 60);
        return i7 > 0 ? context.getString(R.string.Jf, Integer.valueOf(i6), Integer.valueOf(i7)) : context.getString(R.string.wk, Integer.valueOf(i6));
    }

    public static String l(Context context, long j3, boolean z2) {
        return m(context, j3, z2, false);
    }

    public static String m(Context context, long j3, boolean z2, boolean z3) {
        if (j3 == 0 && z3) {
            return context.getString(R.string.Oj, 0);
        }
        if (j3 < 60000) {
            return context.getString(R.string.Oj, 1);
        }
        if (j3 < 3600000) {
            return context.getString(R.string.Oj, Long.valueOf(j3 / 60000));
        }
        if (j3 > 86400000) {
            int i3 = (int) (j3 / 86400000);
            return context.getString(R.string.c9, Integer.valueOf(i3), Integer.valueOf(((int) (j3 / 3600000)) - (i3 * 24)));
        }
        int i4 = ((int) j3) / 3600000;
        int i5 = ((int) (j3 / 60000)) - (i4 * 60);
        return (i5 != 0 || z2) ? context.getString(R.string.Jf, Integer.valueOf(i4), Integer.valueOf(i5)) : context.getString(R.string.wk, Integer.valueOf(i4));
    }

    public static int[] n(Long l3) {
        int iLongValue = (int) (l3.longValue() / 60);
        int i3 = iLongValue / 60;
        int i4 = iLongValue - (i3 * 60);
        return new int[]{i3, i4, l3.intValue() - (i4 * 60)};
    }

    public static boolean o() {
        try {
            return Locale.getDefault().getISO3Language().substring(0, 2).toLowerCase().equals("ar");
        } catch (MissingResourceException unused) {
            return false;
        }
    }
}
