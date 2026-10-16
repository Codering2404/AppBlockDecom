package org.threeten.bp.temporal;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ChronoField implements TemporalField {
    public static final ChronoField A;
    public static final ChronoField B;
    public static final ChronoField C;
    public static final ChronoField D;
    public static final ChronoField E;
    public static final ChronoField F;
    public static final ChronoField G;
    public static final ChronoField H;
    public static final ChronoField I;
    private static final /* synthetic */ ChronoField[] J;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ChronoField f146484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ChronoField f146485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ChronoField f146486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ChronoField f146487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ChronoField f146488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ChronoField f146489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ChronoField f146490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ChronoField f146491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ChronoField f146492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ChronoField f146493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ChronoField f146494p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ChronoField f146495q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ChronoField f146496r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ChronoField f146497s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ChronoField f146498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ChronoField f146499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ChronoField f146500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ChronoField f146501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ChronoField f146502x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ChronoField f146503y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ChronoField f146504z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f146505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TemporalUnit f146506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TemporalUnit f146507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ValueRange f146508d;

    private ChronoField(String str, int i3, String str2, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
        this.f146505a = str2;
        this.f146506b = temporalUnit;
        this.f146507c = temporalUnit2;
        this.f146508d = valueRange;
    }

    public static ChronoField valueOf(String str) {
        return (ChronoField) Enum.valueOf(ChronoField.class, str);
    }

    public static ChronoField[] values() {
        return (ChronoField[]) J.clone();
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public Temporal a(Temporal temporal, long j3) {
        return temporal.a(this, j3);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean b(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange c(TemporalAccessor temporalAccessor) {
        return temporalAccessor.c(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public long d(TemporalAccessor temporalAccessor) {
        return temporalAccessor.m(this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
        return null;
    }

    public int f(long j3) {
        return range().a(j3, this);
    }

    public long g(long j3) {
        return range().b(j3, this);
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isDateBased() {
        return ordinal() >= f146499u.ordinal() && ordinal() <= G.ordinal();
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public boolean isTimeBased() {
        return ordinal() < f146499u.ordinal();
    }

    @Override // org.threeten.bp.temporal.TemporalField
    public ValueRange range() {
        return this.f146508d;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f146505a;
    }

    static {
        ChronoUnit chronoUnit = ChronoUnit.NANOS;
        ChronoUnit chronoUnit2 = ChronoUnit.SECONDS;
        ChronoField chronoField = new ChronoField("NANO_OF_SECOND", 0, "NanoOfSecond", chronoUnit, chronoUnit2, ValueRange.i(0L, 999999999L));
        f146484f = chronoField;
        ChronoUnit chronoUnit3 = ChronoUnit.DAYS;
        ChronoField chronoField2 = new ChronoField("NANO_OF_DAY", 1, "NanoOfDay", chronoUnit, chronoUnit3, ValueRange.i(0L, 86399999999999L));
        f146485g = chronoField2;
        ChronoUnit chronoUnit4 = ChronoUnit.MICROS;
        ChronoField chronoField3 = new ChronoField("MICRO_OF_SECOND", 2, "MicroOfSecond", chronoUnit4, chronoUnit2, ValueRange.i(0L, 999999L));
        f146486h = chronoField3;
        ChronoField chronoField4 = new ChronoField("MICRO_OF_DAY", 3, "MicroOfDay", chronoUnit4, chronoUnit3, ValueRange.i(0L, 86399999999L));
        f146487i = chronoField4;
        ChronoUnit chronoUnit5 = ChronoUnit.MILLIS;
        ChronoField chronoField5 = new ChronoField("MILLI_OF_SECOND", 4, "MilliOfSecond", chronoUnit5, chronoUnit2, ValueRange.i(0L, 999L));
        f146488j = chronoField5;
        ChronoField chronoField6 = new ChronoField("MILLI_OF_DAY", 5, "MilliOfDay", chronoUnit5, chronoUnit3, ValueRange.i(0L, 86399999L));
        f146489k = chronoField6;
        ChronoUnit chronoUnit6 = ChronoUnit.MINUTES;
        ChronoField chronoField7 = new ChronoField("SECOND_OF_MINUTE", 6, "SecondOfMinute", chronoUnit2, chronoUnit6, ValueRange.i(0L, 59L));
        f146490l = chronoField7;
        ChronoField chronoField8 = new ChronoField("SECOND_OF_DAY", 7, "SecondOfDay", chronoUnit2, chronoUnit3, ValueRange.i(0L, 86399L));
        f146491m = chronoField8;
        ChronoUnit chronoUnit7 = ChronoUnit.HOURS;
        ChronoField chronoField9 = new ChronoField("MINUTE_OF_HOUR", 8, "MinuteOfHour", chronoUnit6, chronoUnit7, ValueRange.i(0L, 59L));
        f146492n = chronoField9;
        ChronoField chronoField10 = new ChronoField("MINUTE_OF_DAY", 9, "MinuteOfDay", chronoUnit6, chronoUnit3, ValueRange.i(0L, 1439L));
        f146493o = chronoField10;
        ChronoUnit chronoUnit8 = ChronoUnit.HALF_DAYS;
        ChronoField chronoField11 = new ChronoField("HOUR_OF_AMPM", 10, "HourOfAmPm", chronoUnit7, chronoUnit8, ValueRange.i(0L, 11L));
        f146494p = chronoField11;
        ChronoField chronoField12 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", chronoUnit7, chronoUnit8, ValueRange.i(1L, 12L));
        f146495q = chronoField12;
        ChronoField chronoField13 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", chronoUnit7, chronoUnit3, ValueRange.i(0L, 23L));
        f146496r = chronoField13;
        ChronoField chronoField14 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", chronoUnit7, chronoUnit3, ValueRange.i(1L, 24L));
        f146497s = chronoField14;
        ChronoField chronoField15 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", chronoUnit8, chronoUnit3, ValueRange.i(0L, 1L));
        f146498t = chronoField15;
        ChronoUnit chronoUnit9 = ChronoUnit.WEEKS;
        ChronoField chronoField16 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", chronoUnit3, chronoUnit9, ValueRange.i(1L, 7L));
        f146499u = chronoField16;
        ChronoField chronoField17 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", chronoUnit3, chronoUnit9, ValueRange.i(1L, 7L));
        f146500v = chronoField17;
        ChronoField chronoField18 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", chronoUnit3, chronoUnit9, ValueRange.i(1L, 7L));
        f146501w = chronoField18;
        ChronoUnit chronoUnit10 = ChronoUnit.MONTHS;
        ChronoField chronoField19 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", chronoUnit3, chronoUnit10, ValueRange.j(1L, 28L, 31L));
        f146502x = chronoField19;
        ChronoUnit chronoUnit11 = ChronoUnit.YEARS;
        ChronoField chronoField20 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", chronoUnit3, chronoUnit11, ValueRange.j(1L, 365L, 366L));
        f146503y = chronoField20;
        ChronoUnit chronoUnit12 = ChronoUnit.FOREVER;
        ChronoField chronoField21 = new ChronoField("EPOCH_DAY", 20, "EpochDay", chronoUnit3, chronoUnit12, ValueRange.i(-365243219162L, 365241780471L));
        f146504z = chronoField21;
        ChronoField chronoField22 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", chronoUnit9, chronoUnit10, ValueRange.j(1L, 4L, 5L));
        A = chronoField22;
        ChronoField chronoField23 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", chronoUnit9, chronoUnit11, ValueRange.i(1L, 53L));
        B = chronoField23;
        ChronoField chronoField24 = new ChronoField("MONTH_OF_YEAR", 23, QaXmqxvjHhxVy.ePGbjSROou, chronoUnit10, chronoUnit11, ValueRange.i(1L, 12L));
        C = chronoField24;
        ChronoField chronoField25 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", chronoUnit10, chronoUnit12, ValueRange.i(-11999999988L, 11999999999L));
        D = chronoField25;
        ChronoField chronoField26 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", chronoUnit11, chronoUnit12, ValueRange.j(1L, 999999999L, 1000000000L));
        E = chronoField26;
        ChronoField chronoField27 = new ChronoField("YEAR", 26, "Year", chronoUnit11, chronoUnit12, ValueRange.i(-999999999L, 999999999L));
        F = chronoField27;
        ChronoField chronoField28 = new ChronoField("ERA", 27, "Era", ChronoUnit.ERAS, chronoUnit12, ValueRange.i(0L, 1L));
        G = chronoField28;
        ChronoField chronoField29 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", chronoUnit2, chronoUnit12, ValueRange.i(Long.MIN_VALUE, Long.MAX_VALUE));
        H = chronoField29;
        ChronoField chronoField30 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", chronoUnit2, chronoUnit12, ValueRange.i(-64800L, 64800L));
        I = chronoField30;
        J = new ChronoField[]{chronoField, chronoField2, chronoField3, chronoField4, chronoField5, chronoField6, chronoField7, chronoField8, chronoField9, chronoField10, chronoField11, chronoField12, chronoField13, chronoField14, chronoField15, chronoField16, chronoField17, chronoField18, chronoField19, chronoField20, chronoField21, chronoField22, chronoField23, chronoField24, chronoField25, chronoField26, chronoField27, chronoField28, chronoField29, chronoField30};
    }
}
