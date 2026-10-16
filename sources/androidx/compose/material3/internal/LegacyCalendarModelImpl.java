package androidx.compose.material3.internal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
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
public final class LegacyCalendarModelImpl extends CalendarModel {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f22071e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f22072f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TimeZone f22073g = TimeZone.getTimeZone("UTC");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f22075d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleDateFormat b(String str, Locale locale, Map map) {
            String str2 = str + locale.toLanguageTag();
            Object obj = map.get(str2);
            Object obj2 = obj;
            if (obj == null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                simpleDateFormat.setTimeZone(LegacyCalendarModelImpl.f22071e.c());
                map.put(str2, simpleDateFormat);
                obj2 = simpleDateFormat;
            }
            return (SimpleDateFormat) obj2;
        }

        public final String a(long j3, String str, Locale locale, Map map) {
            SimpleDateFormat simpleDateFormatB = b(str, locale, map);
            Calendar calendar = Calendar.getInstance(c());
            calendar.setTimeInMillis(j3);
            return simpleDateFormatB.format(Long.valueOf(calendar.getTimeInMillis()));
        }

        public final TimeZone c() {
            return LegacyCalendarModelImpl.f22073g;
        }

        private Companion() {
        }
    }

    private final int n(int i3) {
        int i4 = (i3 + 6) % 7;
        if (i4 == 0) {
            return 7;
        }
        return i4;
    }

    private final CalendarMonth o(Calendar calendar) {
        int iN = n(calendar.get(7)) - d();
        if (iN < 0) {
            iN += 7;
        }
        return new CalendarMonth(calendar.get(1), calendar.get(2) + 1, calendar.getActualMaximum(5), iN, calendar.getTimeInMillis());
    }

    private final Calendar p(CalendarMonth calendarMonth) {
        Calendar calendar = Calendar.getInstance(f22073g);
        calendar.setTimeInMillis(calendarMonth.e());
        return calendar;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String a(long j3, String str, Locale locale) {
        return f22071e.a(j3, str, locale, e());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate b(long j3) {
        Calendar calendar = Calendar.getInstance(f22073g);
        calendar.setTimeInMillis(j3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.getTimeInMillis());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public DateInputFormat c(Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(3, locale);
        Intrinsics.checkNotNull(dateInstance, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        return CalendarModelKt.a(((SimpleDateFormat) dateInstance).toPattern());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int d() {
        return this.f22074c;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth f(int i3, int i4) {
        Calendar calendar = Calendar.getInstance(f22073g);
        calendar.clear();
        calendar.set(1, i3);
        calendar.set(2, i4 - 1);
        calendar.set(5, 1);
        return o(calendar);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth g(long j3) {
        Calendar calendar = Calendar.getInstance(f22073g);
        calendar.setTimeInMillis(j3);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return o(calendar);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth h(CalendarDate calendarDate) {
        return f(calendarDate.e(), calendarDate.c());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate i() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new CalendarDate(calendar.get(1), 1 + calendar.get(2), calendar.get(5), calendar.getTimeInMillis() + ((long) (calendar.get(15) + calendar.get(16))));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public List j() {
        return this.f22075d;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate k(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        TimeZone timeZone = f22073g;
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(str);
            if (date == null) {
                return null;
            }
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(date);
            return new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.getTimeInMillis());
        } catch (ParseException unused) {
            return null;
        }
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth l(CalendarMonth calendarMonth, int i3) {
        if (i3 <= 0) {
            return calendarMonth;
        }
        Calendar calendarP = p(calendarMonth);
        calendarP.add(2, i3);
        return o(calendarP);
    }

    public String toString() {
        return "LegacyCalendarModel";
    }
}
