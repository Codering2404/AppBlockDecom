package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoUnit;

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
public final class StatisticsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StatisticsHelper f128018a = new StatisticsHelper();

    private StatisticsHelper() {
    }

    public static final long b(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(g(j3));
        calendar.add(7, 1);
        return calendar.getTimeInMillis();
    }

    private final String d(Calendar calendar) {
        String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMMMMyyyy")).format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String f(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        Calendar calendar2 = Calendar.getInstance(Locale.getDefault());
        if (Math.abs(calendar.get(6) - calendar2.get(6)) < 2) {
            Intrinsics.checkNotNull(calendar2);
            return j(calendar2, calendar);
        }
        String str = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final long g(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private final String j(Calendar calendar, Calendar calendar2) {
        return DateUtils.getRelativeTimeSpanString(calendar2.getTimeInMillis(), calendar.getTimeInMillis(), 86400000L, 2).toString();
    }

    public static final long k(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(7, calendar.getFirstDayOfWeek());
        return calendar.getTimeInMillis();
    }

    public static final long l(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(k(j3));
        calendar.add(7, 7);
        return calendar.getTimeInMillis();
    }

    public static final void o(TextView headerTextView, long j3, int i3, int i4) {
        long j4;
        long j5;
        long j6;
        Intrinsics.checkNotNullParameter(headerTextView, "headerTextView");
        Context context = headerTextView.getContext();
        ArrayList arrayList = new ArrayList();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long days = timeUnit.toDays(j3);
        if (days > 0) {
            String strValueOf = String.valueOf(days);
            j5 = 0;
            String str = strValueOf + "d ";
            SpannableString spannableString = new SpannableString(str);
            int iN0 = StringsKt.n0(str, strValueOf, 0, false, 6, null);
            int iN02 = StringsKt.n0(str, "d", 0, false, 6, null);
            j4 = days;
            spannableString.setSpan(new TextAppearanceSpan(context, i3), iN0, iN0 + strValueOf.length(), 33);
            spannableString.setSpan(new TextAppearanceSpan(context, i4), iN02, iN02 + 1, 33);
            arrayList.add(spannableString);
        } else {
            j4 = days;
            j5 = 0;
        }
        long hours = timeUnit.toHours(j3) - (((long) 24) * j4);
        if (hours > j5) {
            String strValueOf2 = String.valueOf(hours);
            String str2 = strValueOf2 + "h";
            j6 = hours;
            if (days == 0) {
                str2 = str2 + " ";
            }
            SpannableString spannableString2 = new SpannableString(str2);
            String str3 = str2;
            int iN03 = StringsKt.n0(str3, strValueOf2, 0, false, 6, null);
            int iN04 = StringsKt.n0(str3, "h", 0, false, 6, null);
            spannableString2.setSpan(new TextAppearanceSpan(context, i3), iN03, strValueOf2.length() + iN03, 33);
            spannableString2.setSpan(new TextAppearanceSpan(context, i4), iN04, iN04 + 1, 33);
            arrayList.add(spannableString2);
        } else {
            j6 = hours;
        }
        if (days == 0) {
            long minutes = timeUnit.toMinutes(j3) - (((long) 60) * j6);
            if (minutes == j5 && hours == j5) {
                String strValueOf3 = String.valueOf(j3);
                String str4 = strValueOf3 + "s";
                SpannableString spannableString3 = new SpannableString(str4);
                int iN05 = StringsKt.n0(str4, strValueOf3, 0, false, 6, null);
                int iN06 = StringsKt.n0(str4, "s", 0, false, 6, null);
                spannableString3.setSpan(new TextAppearanceSpan(context, i3), iN05, strValueOf3.length() + iN05, 33);
                spannableString3.setSpan(new TextAppearanceSpan(context, i4), iN06, iN06 + 1, 33);
                arrayList.add(spannableString3);
            } else {
                String strValueOf4 = String.valueOf(minutes);
                String str5 = strValueOf4 + "m";
                SpannableString spannableString4 = new SpannableString(str5);
                int iN07 = StringsKt.n0(str5, strValueOf4, 0, false, 6, null);
                int iN08 = StringsKt.n0(str5, "m", 0, false, 6, null);
                spannableString4.setSpan(new TextAppearanceSpan(context, i3), iN07, strValueOf4.length() + iN07, 33);
                spannableString4.setSpan(new TextAppearanceSpan(context, i4), iN08, iN08 + 1, 33);
                arrayList.add(spannableString4);
            }
        }
        SpannableString[] spannableStringArr = (SpannableString[]) arrayList.toArray(new SpannableString[0]);
        headerTextView.setText(TextUtils.concat((CharSequence[]) Arrays.copyOf(spannableStringArr, spannableStringArr.length)), TextView.BufferType.SPANNABLE);
    }

    public static /* synthetic */ void p(TextView textView, long j3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = R.style.f95872g;
        }
        if ((i5 & 8) != 0) {
            i4 = R.style.f95873h;
        }
        o(textView, j3, i3, i4);
    }

    public static final void q(TextView headerTextView, double d3) {
        Intrinsics.checkNotNullParameter(headerTextView, "headerTextView");
        String strValueOf = String.valueOf((int) d3);
        String str = strValueOf + "x";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new TextAppearanceSpan(headerTextView.getContext(), R.style.f95872g), StringsKt.n0(str, strValueOf, 0, false, 6, null), StringsKt.n0(str, strValueOf, 0, false, 6, null) + strValueOf.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan(headerTextView.getContext(), R.style.f95873h), StringsKt.n0(str, "x", 0, false, 6, null), StringsKt.n0(str, "x", 0, false, 6, null) + 1, 33);
        headerTextView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public final boolean a(long j3, Long l3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar.add(6, 1);
        Calendar calendar2 = Calendar.getInstance();
        if (l3 != null) {
            calendar2.setTimeInMillis(l3.longValue());
        }
        return calendar2.before(calendar);
    }

    public final String c(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Intrinsics.checkNotNull(calendar);
        return d(calendar);
    }

    public final String e(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Intrinsics.checkNotNull(calendar);
        return f(calendar);
    }

    public final int h(long j3, long j4) {
        return (int) ChronoUnit.DAYS.a(LocalDateTime.Y(Instant.A(g(j3)), ZoneId.s()), LocalDateTime.Y(Instant.A(b(j4)), ZoneId.s()));
    }

    public final int i(long j3, long j4) {
        return (int) ChronoUnit.WEEKS.a(LocalDateTime.Y(Instant.A(k(j3)), ZoneId.s()), LocalDateTime.Y(Instant.A(l(j4)), ZoneId.s()));
    }

    public final String m(Context context, long j3, long j4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        calendar2.setTimeInMillis(j4);
        calendar2.add(6, -1);
        Intrinsics.checkNotNull(calendar);
        Intrinsics.checkNotNull(calendar2);
        return n(context, calendar, calendar2);
    }

    public final String n(Context context, Calendar firstDay, Calendar lastDay) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(firstDay, "firstDay");
        Intrinsics.checkNotNullParameter(lastDay, "lastDay");
        int i3 = firstDay.get(1);
        int i4 = lastDay.get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dM"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMyyyy"));
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMyyyy"));
        if (i3 == i4) {
            return context.getString(R.string.lG) + " " + simpleDateFormat.format(firstDay.getTime()) + " - " + simpleDateFormat3.format(lastDay.getTime());
        }
        return context.getString(R.string.lG) + " " + simpleDateFormat2.format(firstDay.getTime()) + " - " + simpleDateFormat3.format(lastDay.getTime());
    }
}
