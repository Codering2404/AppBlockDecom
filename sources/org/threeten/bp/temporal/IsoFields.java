package org.threeten.bp.temporal;

import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class IsoFields {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalField f146528a = Field.DAY_OF_QUARTER;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TemporalField f146529b = Field.QUARTER_OF_YEAR;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalField f146530c = Field.WEEK_OF_WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TemporalField f146531d = Field.WEEK_BASED_YEAR;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TemporalUnit f146532e = Unit.WEEK_BASED_YEARS;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalUnit f146533f = Unit.QUARTER_YEARS;

    /* JADX INFO: renamed from: org.threeten.bp.temporal.IsoFields$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146534a;

        static {
            int[] iArr = new int[Unit.values().length];
            f146534a = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146534a[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Field implements TemporalField {
        DAY_OF_QUARTER { // from class: org.threeten.bp.temporal.IsoFields.Field.1
            @Override // org.threeten.bp.temporal.TemporalField
            public Temporal a(Temporal temporal, long j3) {
                long jD = d(temporal);
                range().b(j3, this);
                ChronoField chronoField = ChronoField.f146503y;
                return temporal.a(chronoField, temporal.m(chronoField) + (j3 - jD));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean b(TemporalAccessor temporalAccessor) {
                return temporalAccessor.g(ChronoField.f146503y) && temporalAccessor.g(ChronoField.C) && temporalAccessor.g(ChronoField.F) && Field.p(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange c(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long jM = temporalAccessor.m(Field.QUARTER_OF_YEAR);
                if (jM == 1) {
                    return IsoChronology.f146288f.isLeapYear(temporalAccessor.m(ChronoField.F)) ? ValueRange.i(1L, 91L) : ValueRange.i(1L, 90L);
                }
                return jM == 2 ? ValueRange.i(1L, 91L) : (jM == 3 || jM == 4) ? ValueRange.i(1L, 92L) : range();
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long d(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(this)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.j(ChronoField.f146503y) - Field.f146539f[((temporalAccessor.j(ChronoField.C) - 1) / 3) + (IsoChronology.f146288f.isLeapYear(temporalAccessor.m(ChronoField.F)) ? 4 : 0)];
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDateP0;
                ChronoField chronoField = ChronoField.F;
                Long l3 = (Long) map.get(chronoField);
                TemporalField temporalField = Field.QUARTER_OF_YEAR;
                Long l4 = (Long) map.get(temporalField);
                if (l3 == null || l4 == null) {
                    return null;
                }
                int iF = chronoField.f(l3.longValue());
                long jLongValue = ((Long) map.get(Field.DAY_OF_QUARTER)).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDateP0 = LocalDate.f0(iF, 1, 1).q0(Jdk8Methods.m(Jdk8Methods.p(l4.longValue(), 1L), 3)).p0(Jdk8Methods.p(jLongValue, 1L));
                } else {
                    int iA = temporalField.range().a(l4.longValue(), temporalField);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i3 = 91;
                        if (iA == 1) {
                            if (!IsoChronology.f146288f.isLeapYear(iF)) {
                                i3 = 90;
                            }
                        } else if (iA != 2) {
                            i3 = 92;
                        }
                        ValueRange.i(1L, i3).b(jLongValue, this);
                    } else {
                        range().b(jLongValue, this);
                    }
                    localDateP0 = LocalDate.f0(iF, ((iA - 1) * 3) + 1, 1).p0(jLongValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(temporalField);
                return localDateP0;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.j(1L, 90L, 92L);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.2
            @Override // org.threeten.bp.temporal.TemporalField
            public Temporal a(Temporal temporal, long j3) {
                long jD = d(temporal);
                range().b(j3, this);
                ChronoField chronoField = ChronoField.C;
                return temporal.a(chronoField, temporal.m(chronoField) + ((j3 - jD) * 3));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean b(TemporalAccessor temporalAccessor) {
                return temporalAccessor.g(ChronoField.C) && Field.p(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange c(TemporalAccessor temporalAccessor) {
                return range();
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long d(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.g(this)) {
                    return (temporalAccessor.m(ChronoField.C) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.i(1L, 4L);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.3
            @Override // org.threeten.bp.temporal.TemporalField
            public Temporal a(Temporal temporal, long j3) {
                range().b(j3, this);
                return temporal.u(Jdk8Methods.p(j3, d(temporal)), ChronoUnit.WEEKS);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean b(TemporalAccessor temporalAccessor) {
                return temporalAccessor.g(ChronoField.f146504z) && Field.p(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange c(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.g(this)) {
                    return Field.o(LocalDate.I(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long d(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.g(this)) {
                    return Field.l(LocalDate.I(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.IsoFields.Field, org.threeten.bp.temporal.TemporalField
            public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDateX0;
                long j3;
                TemporalField temporalField = Field.WEEK_BASED_YEAR;
                Long l3 = (Long) map.get(temporalField);
                ChronoField chronoField = ChronoField.f146499u;
                Long l4 = (Long) map.get(chronoField);
                if (l3 == null || l4 == null) {
                    return null;
                }
                int iA = temporalField.range().a(l3.longValue(), temporalField);
                long jLongValue = ((Long) map.get(Field.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long jLongValue2 = l4.longValue();
                    if (jLongValue2 > 7) {
                        long j4 = jLongValue2 - 1;
                        j3 = j4 / 7;
                        jLongValue2 = (j4 % 7) + 1;
                    } else if (jLongValue2 < 1) {
                        j3 = (jLongValue2 / 7) - 1;
                        jLongValue2 = (jLongValue2 % 7) + 7;
                    } else {
                        j3 = 0;
                    }
                    localDateX0 = LocalDate.f0(iA, 1, 4).r0(jLongValue - 1).r0(j3).a(chronoField, jLongValue2);
                } else {
                    int iF = chronoField.f(l4.longValue());
                    if (resolverStyle == ResolverStyle.STRICT) {
                        Field.o(LocalDate.f0(iA, 1, 4)).b(jLongValue, this);
                    } else {
                        range().b(jLongValue, this);
                    }
                    localDateX0 = LocalDate.f0(iA, 1, 4).r0(jLongValue - 1).a(chronoField, iF);
                }
                map.remove(this);
                map.remove(temporalField);
                map.remove(chronoField);
                return localDateX0;
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.j(1L, 52L, 53L);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR { // from class: org.threeten.bp.temporal.IsoFields.Field.4
            @Override // org.threeten.bp.temporal.TemporalField
            public Temporal a(Temporal temporal, long j3) {
                if (!b(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int iA = range().a(j3, Field.WEEK_BASED_YEAR);
                LocalDate localDateI = LocalDate.I(temporal);
                int iJ = localDateI.j(ChronoField.f146499u);
                int iL = Field.l(localDateI);
                if (iL == 53 && Field.n(iA) == 52) {
                    iL = 52;
                }
                return temporal.z(LocalDate.f0(iA, 1, 4).p0((iJ - r6.j(r0)) + ((iL - 1) * 7)));
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public boolean b(TemporalAccessor temporalAccessor) {
                return temporalAccessor.g(ChronoField.f146504z) && Field.p(temporalAccessor);
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange c(TemporalAccessor temporalAccessor) {
                return ChronoField.F.range();
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public long d(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.g(this)) {
                    return Field.m(LocalDate.I(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // org.threeten.bp.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.F.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int[] f146539f = {0, 90, 181, 273, 0, 91, 182, 274};

        /* JADX INFO: Access modifiers changed from: private */
        public static int l(LocalDate localDate) {
            int iOrdinal = localDate.S().ordinal();
            int iU = localDate.U() - 1;
            int i3 = (3 - iOrdinal) + iU;
            int i4 = i3 - ((i3 / 7) * 7);
            int i5 = i4 - 3;
            if (i5 < -3) {
                i5 = i4 + 4;
            }
            if (iU < i5) {
                return (int) o(localDate.B0(SensibleDefaults.X_OFFSET).b0(1L)).c();
            }
            int i6 = ((iU - i5) / 7) + 1;
            if (i6 != 53 || i5 == -3 || (i5 == -2 && localDate.isLeapYear())) {
                return i6;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int m(LocalDate localDate) {
            int iY = localDate.Y();
            int iU = localDate.U();
            if (iU <= 3) {
                return iU - localDate.S().ordinal() < -2 ? iY - 1 : iY;
            }
            if (iU >= 363) {
                return ((iU - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.S().ordinal() >= 0 ? iY + 1 : iY;
            }
            return iY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int n(int i3) {
            LocalDate localDateF0 = LocalDate.f0(i3, 1, 1);
            if (localDateF0.S() != DayOfWeek.THURSDAY) {
                return (localDateF0.S() == DayOfWeek.WEDNESDAY && localDateF0.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange o(LocalDate localDate) {
            return ValueRange.i(1L, n(m(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(TemporalAccessor temporalAccessor) {
            return Chronology.i(temporalAccessor).equals(IsoChronology.f146288f);
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        /* synthetic */ Field(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.r(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.r(7889238));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Duration f146545b;

        Unit(String str, Duration duration) {
            this.f146544a = str;
            this.f146545b = duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public long a(Temporal temporal, Temporal temporal2) {
            int i3 = AnonymousClass1.f146534a[ordinal()];
            if (i3 == 1) {
                TemporalField temporalField = IsoFields.f146531d;
                return Jdk8Methods.p(temporal2.m(temporalField), temporal.m(temporalField));
            }
            if (i3 == 2) {
                return temporal.i(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public Temporal b(Temporal temporal, long j3) {
            int i3 = AnonymousClass1.f146534a[ordinal()];
            if (i3 == 1) {
                return temporal.a(IsoFields.f146531d, Jdk8Methods.k(temporal.j(r0), j3));
            }
            if (i3 == 2) {
                return temporal.u(j3 / 256, ChronoUnit.YEARS).u((j3 % 256) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f146544a;
        }
    }
}
