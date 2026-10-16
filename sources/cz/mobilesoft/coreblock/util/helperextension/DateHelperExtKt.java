package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.FormatStyle;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DateHelperExtKt {
    public static final long a(long j3, String zoneIdString) {
        Intrinsics.checkNotNullParameter(zoneIdString, "zoneIdString");
        try {
            ZonedDateTime zonedDateTimeP = Instant.A(j3).p(ZoneId.p(zoneIdString));
            LocalTime localTimeY = zonedDateTimeP.y();
            LocalTime localTimeA = LocalTime.A(7, 0);
            LocalTime localTimeA2 = LocalTime.A(22, 0);
            if (localTimeY.y(localTimeA)) {
                zonedDateTimeP = zonedDateTimeP.k(localTimeA);
                Intrinsics.checkNotNull(zonedDateTimeP);
            } else if (localTimeY.x(localTimeA2)) {
                zonedDateTimeP = zonedDateTimeP.k(localTimeA2);
                Intrinsics.checkNotNull(zonedDateTimeP);
            } else {
                Intrinsics.checkNotNull(zonedDateTimeP);
            }
            return zonedDateTimeP.v().S();
        } catch (Exception e3) {
            System.out.println((Object) ("Error processing timestamp for coercion: " + e3.getMessage()));
            return j3;
        }
    }

    public static final String b(String str, String formatPattern) {
        Intrinsics.checkNotNullParameter(formatPattern, "formatPattern");
        if (str != null && !StringsKt.p0(str)) {
            try {
                return DateTimeFormatter.m(formatPattern).d(DateTimeFormatter.m("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").o(str));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static final String c(LocalDateTime localDateTime, String formatPattern) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(formatPattern, "formatPattern");
        try {
            return DateTimeFormatter.m(formatPattern).d(localDateTime);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final String d(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jG = RangesKt.g(Math.abs(j3), TimeUnit.MINUTES.toMillis(1L));
        if (jG >= TimeUnit.DAYS.toMillis(1L)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(jG);
            String quantityString = context.getResources().getQuantityString(R.plurals.f95748i, days, Integer.valueOf(days));
            Intrinsics.checkNotNull(quantityString);
            return quantityString;
        }
        if (jG >= TimeUnit.HOURS.toMillis(1L)) {
            int hours = (int) TimeUnit.MILLISECONDS.toHours(jG);
            String quantityString2 = context.getResources().getQuantityString(R.plurals.f95743d, hours, Integer.valueOf(hours));
            Intrinsics.checkNotNull(quantityString2);
            return quantityString2;
        }
        int iF = RangesKt.f((int) TimeUnit.MILLISECONDS.toMinutes(jG), 1);
        String quantityString3 = context.getResources().getQuantityString(R.plurals.f95744e, iF, Integer.valueOf(iF));
        Intrinsics.checkNotNull(quantityString3);
        return quantityString3;
    }

    public static final String e(long j3, boolean z2, boolean z3, boolean z4) {
        long jAbs = Math.abs(j3);
        String str = z3 ? "min" : "m";
        if (z2 && ((z4 && 1 <= jAbs && jAbs < 61) || (!z4 && 1 <= jAbs && jAbs < 60))) {
            return jAbs + "s";
        }
        if (z4) {
            long j4 = 60;
            jAbs = ((jAbs + ((long) 59)) / j4) * j4;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long days = timeUnit.toDays(jAbs);
        long hours = timeUnit.toHours(jAbs) % ((long) 24);
        long j5 = 60;
        long minutes = timeUnit.toMinutes(jAbs) % j5;
        long seconds = timeUnit.toSeconds(jAbs) % j5;
        if (days > 0) {
            return days + "d " + hours + "h";
        }
        String str2 = "";
        if (hours > 0) {
            if (minutes > 0) {
                str2 = " " + minutes + str;
            }
            return hours + "h" + str2;
        }
        if (minutes <= 0) {
            if (!z2 || seconds <= 0) {
                return AppEventsConstants.EVENT_PARAM_VALUE_NO + str;
            }
            return seconds + "s";
        }
        if (z2 && !z4 && seconds > 0) {
            str2 = " " + seconds + "s";
        }
        return minutes + str + str2;
    }

    public static /* synthetic */ String f(long j3, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        if ((i3 & 8) != 0) {
            z4 = false;
        }
        return e(j3, z2, z3, z4);
    }

    public static final String g(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jAbs = Math.abs(j3);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(jAbs) % ((long) 24);
        long minutes = timeUnit.toMinutes(jAbs) % ((long) 60);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getResources().getQuantityString(R.plurals.f95743d, (int) hours, Long.valueOf(hours)));
        if (minutes > 0) {
            sb.append(", ");
            sb.append(context.getResources().getQuantityString(R.plurals.f95744e, (int) minutes, Long.valueOf(minutes)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "with(...)");
        return string;
    }

    public static final DateFormat h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), android.text.format.DateFormat.is24HourFormat(context) ? "MMMM d yyyy HH:mm" : "MMMM d yyyy hh:mm aa"), Locale.getDefault());
    }

    public static final DateFormat i(Context context, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!z2 && !z3) {
            throw new IllegalArgumentException("Both withDate and withTime cannot be false");
        }
        if (!z2) {
            DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
            Intrinsics.checkNotNull(timeFormat);
            return timeFormat;
        }
        String str = !z3 ? "" : android.text.format.DateFormat.is24HourFormat(context) ? " HH:mm" : " hh:mm aa";
        return new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), "d/M" + str), Locale.getDefault());
    }

    public static final long j(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static final long k() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
    }

    public static final String l(Context context, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z2) {
            String str = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), "d MMMM yyyy"), Locale.getDefault()).format(new Date(j3));
            Intrinsics.checkNotNull(str);
            return str;
        }
        String str2 = i(context, true, false).format(new Date(j3));
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public static final Long m(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.valueOf(OffsetDateTime.y(str).q(ZoneId.s()).toEpochSecond() * ((long) 1000));
        } catch (Exception e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
            return null;
        }
    }

    public static final String n(long j3) {
        String strD = DateTimeFormatter.l(FormatStyle.MEDIUM).u(ZoneId.s()).d(Instant.A(j3));
        Intrinsics.checkNotNullExpressionValue(strD, "format(...)");
        return strD;
    }

    public static final String o(long j3) {
        String strD = DateTimeFormatter.m("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").u(ZoneId.s()).d(Instant.A(j3));
        Intrinsics.checkNotNullExpressionValue(strD, "format(...)");
        return strD;
    }

    public static final String p(Date date, Context context) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return android.text.format.DateFormat.is24HourFormat(context) ? q(date, "HH:mm") : q(date, "hh a");
    }

    public static final String q(Date date, String pattern) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
