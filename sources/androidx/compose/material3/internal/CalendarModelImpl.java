package androidx.compose.material3.internal;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CalendarModelImpl extends CalendarModel {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f21988e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21989f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ZoneId f21990g = ZoneId.of("UTC");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f21992d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final DateTimeFormatter b(String str, Locale locale, Map map) {
            String str2 = "P:" + str + locale.toLanguageTag();
            Object objWithDecimalStyle = map.get(str2);
            if (objWithDecimalStyle == null) {
                objWithDecimalStyle = DateTimeFormatter.ofPattern(str, locale).withDecimalStyle(DecimalStyle.of(locale));
                map.put(str2, objWithDecimalStyle);
            }
            Intrinsics.checkNotNull(objWithDecimalStyle, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return (DateTimeFormatter) objWithDecimalStyle;
        }

        public final String a(long j3, String str, Locale locale, Map map) {
            return Instant.ofEpochMilli(j3).atZone(c()).toLocalDate().format(b(str, locale, map));
        }

        public final ZoneId c() {
            return CalendarModelImpl.f21990g;
        }

        private Companion() {
        }
    }

    public CalendarModelImpl(Locale locale) {
        super(locale);
        this.f21991c = WeekFields.of(locale).getFirstDayOfWeek().getValue();
        DayOfWeek[] dayOfWeekArrValues = DayOfWeek.values();
        ArrayList arrayList = new ArrayList(dayOfWeekArrValues.length);
        for (DayOfWeek dayOfWeek : dayOfWeekArrValues) {
            arrayList.add(TuplesKt.a(dayOfWeek.getDisplayName(TextStyle.FULL, locale), dayOfWeek.getDisplayName(TextStyle.NARROW, locale)));
        }
        this.f21992d = arrayList;
    }

    private final CalendarMonth n(LocalDate localDate) {
        int value = localDate.getDayOfWeek().getValue() - d();
        if (value < 0) {
            value += 7;
        }
        return new CalendarMonth(localDate.getYear(), localDate.getMonthValue(), localDate.lengthOfMonth(), value, localDate.atTime(LocalTime.MIDNIGHT).atZone(f21990g).toInstant().toEpochMilli());
    }

    private final LocalDate o(CalendarMonth calendarMonth) {
        return Instant.ofEpochMilli(calendarMonth.e()).atZone(f21990g).toLocalDate();
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String a(long j3, String str, Locale locale) {
        return f21988e.a(j3, str, locale, e());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate b(long j3) {
        LocalDate localDate = Instant.ofEpochMilli(j3).atZone(f21990g).toLocalDate();
        return new CalendarDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), ((long) 1000) * localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public DateInputFormat c(Locale locale) {
        return CalendarModelKt.a(DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, Chronology.ofLocale(locale), locale));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int d() {
        return this.f21991c;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth f(int i3, int i4) {
        return n(LocalDate.of(i3, i4, 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth g(long j3) {
        return n(Instant.ofEpochMilli(j3).atZone(f21990g).withDayOfMonth(1).toLocalDate());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth h(CalendarDate calendarDate) {
        return n(LocalDate.of(calendarDate.e(), calendarDate.c(), 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate i() {
        LocalDate localDateNow = LocalDate.now();
        return new CalendarDate(localDateNow.getYear(), localDateNow.getMonthValue(), localDateNow.getDayOfMonth(), localDateNow.atTime(LocalTime.MIDNIGHT).atZone(f21990g).toInstant().toEpochMilli());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public List j() {
        return this.f21992d;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate k(String str, String str2) {
        try {
            LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern(str2));
            return new CalendarDate(localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth(), localDate.atTime(LocalTime.MIDNIGHT).atZone(f21990g).toInstant().toEpochMilli());
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth l(CalendarMonth calendarMonth, int i3) {
        return i3 <= 0 ? calendarMonth : n(o(calendarMonth).plusMonths(i3));
    }

    public String toString() {
        return "CalendarModel";
    }
}
