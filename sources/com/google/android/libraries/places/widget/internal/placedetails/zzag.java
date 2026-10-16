package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzag f79177a = new zzag();

    private zzag() {
    }

    public static final int a(Place place, Context context, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int color = context.getResources().getColor(R.color.f74670g, context.getTheme());
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, PlacesMaterialThemeAttrs);
        switch (zzaf.f79175a[i(place).ordinal()]) {
            case 1:
            case 3:
                i4 = R.styleable.f74897i;
                break;
            case 2:
            case 4:
            case 5:
                i4 = R.styleable.f74892d;
                break;
            case 6:
                i4 = R.styleable.f74896h;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int color2 = typedArrayObtainStyledAttributes.getColor(i4, color);
        typedArrayObtainStyledAttributes.recycle();
        return color2;
    }

    public static final String b(Place place, Instant instant, Context context) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        OpeningHours openingHoursL = place.l();
        Instant instantJ = openingHoursL != null ? openingHoursL.j() : null;
        OpeningHours openingHoursL2 = place.l();
        Instant instantI = openingHoursL2 != null ? openingHoursL2.i() : null;
        if (place.v0() == null || instant == null) {
            return null;
        }
        if (i(place) == zzae.f79169b && instantJ != null) {
            Integer numV0 = place.v0();
            Intrinsics.checkNotNull(numV0);
            String strG = g(instantJ, numV0.intValue(), instant, context);
            if (strG == null) {
                int i3 = R.string.Z;
                Integer numV02 = place.v0();
                Intrinsics.checkNotNull(numV02);
                return context.getString(i3, h(instantJ, numV02.intValue(), context));
            }
            int i4 = R.string.f74823a0;
            Integer numV03 = place.v0();
            Intrinsics.checkNotNull(numV03);
            return context.getString(i4, h(instantJ, numV03.intValue(), context), strG);
        }
        if (i(place) == zzae.f79171d && instantI != null) {
            Integer numV04 = place.v0();
            Intrinsics.checkNotNull(numV04);
            String strG2 = g(instantI, numV04.intValue(), instant, context);
            if (strG2 == null) {
                int i5 = R.string.f74826b0;
                Integer numV05 = place.v0();
                Intrinsics.checkNotNull(numV05);
                return context.getString(i5, h(instantI, numV05.intValue(), context));
            }
            int i6 = R.string.f74829c0;
            Integer numV06 = place.v0();
            Intrinsics.checkNotNull(numV06);
            return context.getString(i6, h(instantI, numV06.intValue(), context), strG2);
        }
        return null;
    }

    public static final String c(Place place, Context context) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = zzaf.f79175a[i(place).ordinal()];
        if (i3 == 1) {
            return context.getString(R.string.f74853k0);
        }
        if (i3 == 2) {
            return context.getString(R.string.f74850j0);
        }
        if (i3 == 3) {
            return context.getString(R.string.f74856l0);
        }
        if (i3 == 4) {
            return context.getString(R.string.f74861n0);
        }
        if (i3 != 5) {
            return null;
        }
        return context.getString(R.string.f74859m0);
    }

    private static final boolean d(Place place) {
        TimeOfWeek timeOfWeekD;
        LocalTime localTimeE;
        TimeOfWeek timeOfWeekD2;
        LocalTime localTimeE2;
        TimeOfWeek timeOfWeekE;
        LocalTime localTimeE3;
        TimeOfWeek timeOfWeekE2;
        LocalTime localTimeE4;
        OpeningHours openingHoursL = place.l();
        List listE = openingHoursL != null ? openingHoursL.e() : null;
        Period period = listE != null ? (Period) CollectionsKt.singleOrNull(listE) : null;
        return (period != null && (timeOfWeekE = period.e()) != null && (localTimeE3 = timeOfWeekE.e()) != null && localTimeE3.c() == 0 && (timeOfWeekE2 = period.e()) != null && (localTimeE4 = timeOfWeekE2.e()) != null && localTimeE4.d() == 0) && ((period != null ? period.d() : null) == null || ((timeOfWeekD = period.d()) != null && (localTimeE = timeOfWeekD.e()) != null && localTimeE.c() == 23 && (timeOfWeekD2 = period.d()) != null && (localTimeE2 = timeOfWeekD2.e()) != null && localTimeE2.d() == 59));
    }

    private static final boolean e(OffsetDateTime offsetDateTime) {
        return offsetDateTime.getHour() == 0 && offsetDateTime.getMinute() == 0;
    }

    private static final OffsetDateTime f(Instant instant, int i3) {
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(i3 * 60);
        Intrinsics.checkNotNullExpressionValue(zoneOffsetOfTotalSeconds, "ofTotalSeconds(...)");
        OffsetDateTime offsetDateTimeAtOffset = instant.atOffset(zoneOffsetOfTotalSeconds);
        Intrinsics.checkNotNullExpressionValue(offsetDateTimeAtOffset, "atOffset(...)");
        return offsetDateTimeAtOffset;
    }

    private static final String g(Instant instant, int i3, Instant instant2, Context context) {
        OffsetDateTime offsetDateTimeF = f(instant, i3);
        OffsetDateTime offsetDateTimeF2 = f(instant2, i3);
        long hours = Duration.between(instant, instant2).abs().toHours();
        if (offsetDateTimeF.getYear() == offsetDateTimeF2.getYear() && offsetDateTimeF.getDayOfYear() == offsetDateTimeF2.getDayOfYear()) {
            return null;
        }
        if (e(offsetDateTimeF) && hours < 24) {
            return null;
        }
        switch (zzaf.f79176b[offsetDateTimeF.getDayOfWeek().ordinal()]) {
            case 1:
                return context.getString(R.string.N);
            case 2:
                return context.getString(R.string.R);
            case 3:
                return context.getString(R.string.S);
            case 4:
                return context.getString(R.string.Q);
            case 5:
                return context.getString(R.string.M);
            case 6:
                return context.getString(R.string.O);
            case 7:
                return context.getString(R.string.P);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final String h(Instant instant, int i3, Context context) {
        OffsetDateTime offsetDateTimeF = f(instant, i3);
        Locale locale = context.getResources().getConfiguration().locale;
        if (e(offsetDateTimeF)) {
            String string = context.getString(R.string.S0);
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (offsetDateTimeF.getHour() == 12 && offsetDateTimeF.getMinute() == 0) {
            String string2 = context.getString(R.string.T0);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (DateFormat.is24HourFormat(context)) {
            String str = offsetDateTimeF.format(DateTimeFormatter.ofPattern(DateFormat.getBestDateTimePattern(locale, "H:mm")));
            Intrinsics.checkNotNull(str);
            return str;
        }
        String str2 = offsetDateTimeF.format(DateTimeFormatter.ofPattern(offsetDateTimeF.getMinute() == 0 ? DateFormat.getBestDateTimePattern(locale, "h a") : DateFormat.getBestDateTimePattern(locale, "h:mm a")));
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    private static final zzae i(Place place) {
        if (place.i() == Place.BusinessStatus.CLOSED_PERMANENTLY) {
            return zzae.f79173g;
        }
        if (place.i() == Place.BusinessStatus.CLOSED_TEMPORARILY) {
            return zzae.f79172f;
        }
        if (d(place)) {
            return zzae.f79170c;
        }
        OpeningHours openingHoursL = place.l();
        if (openingHoursL != null && Intrinsics.areEqual(openingHoursL.h(), Boolean.TRUE)) {
            return zzae.f79169b;
        }
        OpeningHours openingHoursL2 = place.l();
        return (openingHoursL2 == null || !Intrinsics.areEqual(openingHoursL2.h(), Boolean.FALSE)) ? zzae.f79168a : zzae.f79171d;
    }
}
