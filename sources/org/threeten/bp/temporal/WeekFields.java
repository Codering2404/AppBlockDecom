package org.threeten.bp.temporal;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class WeekFields implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ConcurrentMap f146580i = new ConcurrentHashMap(4, 0.75f, 2);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final WeekFields f146581j = new WeekFields(DayOfWeek.MONDAY, 4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final WeekFields f146582k = f(DayOfWeek.SUNDAY, 1);
    private static final long serialVersionUID = -1177360819670808121L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DayOfWeek f146583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient TemporalField f146585c = ComputedDayOfField.l(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient TemporalField f146586d = ComputedDayOfField.n(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient TemporalField f146587f = ComputedDayOfField.p(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient TemporalField f146588g = ComputedDayOfField.o(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient TemporalField f146589h = ComputedDayOfField.m(this);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ComputedDayOfField implements TemporalField {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final ValueRange f146590g = ValueRange.i(1, 7);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final ValueRange f146591h = ValueRange.k(0, 1, 4, 6);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final ValueRange f146592i = ValueRange.k(0, 1, 52, 54);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final ValueRange f146593j = ValueRange.j(1, 52, 53);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final ValueRange f146594k = ChronoField.F.range();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeekFields f146596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TemporalUnit f146597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TemporalUnit f146598d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ValueRange f146599f;

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.f146595a = str;
            this.f146596b = weekFields;
            this.f146597c = temporalUnit;
            this.f146598d = temporalUnit2;
            this.f146599f = valueRange;
        }

        private int f(int i3, int i4) {
            return ((i3 + 7) + (i4 - 1)) / 7;
        }

        private int g(TemporalAccessor temporalAccessor, int i3) {
            return Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - i3, 7) + 1;
        }

        private int h(TemporalAccessor temporalAccessor) {
            int iF = Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - this.f146596b.c().getValue(), 7) + 1;
            int iJ = temporalAccessor.j(ChronoField.F);
            long jK = k(temporalAccessor, iF);
            if (jK == 0) {
                return iJ - 1;
            }
            if (jK < 53) {
                return iJ;
            }
            return jK >= ((long) f(r(temporalAccessor.j(ChronoField.f146503y), iF), (Year.r((long) iJ) ? 366 : 365) + this.f146596b.d())) ? iJ + 1 : iJ;
        }

        private int i(TemporalAccessor temporalAccessor) {
            int iF = Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - this.f146596b.c().getValue(), 7) + 1;
            long jK = k(temporalAccessor, iF);
            if (jK == 0) {
                return ((int) k(Chronology.i(temporalAccessor).c(temporalAccessor).t(1L, ChronoUnit.WEEKS), iF)) + 1;
            }
            if (jK >= 53) {
                int iF2 = f(r(temporalAccessor.j(ChronoField.f146503y), iF), (Year.r((long) temporalAccessor.j(ChronoField.F)) ? 366 : 365) + this.f146596b.d());
                if (jK >= iF2) {
                    return (int) (jK - ((long) (iF2 - 1)));
                }
            }
            return (int) jK;
        }

        private long j(TemporalAccessor temporalAccessor, int i3) {
            int iJ = temporalAccessor.j(ChronoField.f146502x);
            return f(r(iJ, i3), iJ);
        }

        private long k(TemporalAccessor temporalAccessor, int i3) {
            int iJ = temporalAccessor.j(ChronoField.f146503y);
            return f(r(iJ, i3), iJ);
        }

        static ComputedDayOfField l(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, f146590g);
        }

        static ComputedDayOfField m(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.f146532e, ChronoUnit.FOREVER, f146594k);
        }

        static ComputedDayOfField n(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, f146591h);
        }

        static ComputedDayOfField o(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.f146532e, f146593j);
        }

        static ComputedDayOfField p(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, f146592i);
        }

        private ValueRange q(TemporalAccessor temporalAccessor) {
            int iF = Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - this.f146596b.c().getValue(), 7) + 1;
            long jK = k(temporalAccessor, iF);
            if (jK == 0) {
                return q(Chronology.i(temporalAccessor).c(temporalAccessor).t(2L, ChronoUnit.WEEKS));
            }
            return jK >= ((long) f(r(temporalAccessor.j(ChronoField.f146503y), iF), (Year.r((long) temporalAccessor.j(ChronoField.F)) ? 366 : 365) + this.f146596b.d())) ? q(Chronology.i(temporalAccessor).c(temporalAccessor).u(2L, ChronoUnit.WEEKS)) : ValueRange.i(1L, r0 - 1);
        }

        private int r(int i3, int i4) {
            int iF = Jdk8Methods.f(i3 - i4, 7);
            return iF + 1 > this.f146596b.d() ? 7 - iF : -iF;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public Temporal a(Temporal temporal, long j3) {
            int iA = this.f146599f.a(j3, this);
            if (iA == temporal.j(this)) {
                return temporal;
            }
            if (this.f146598d != ChronoUnit.FOREVER) {
                return temporal.u(iA - r1, this.f146597c);
            }
            int iJ = temporal.j(this.f146596b.f146588g);
            long j4 = (long) ((j3 - ((long) r1)) * 52.1775d);
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            Temporal temporalU = temporal.u(j4, chronoUnit);
            if (temporalU.j(this) > iA) {
                return temporalU.t(temporalU.j(this.f146596b.f146588g), chronoUnit);
            }
            if (temporalU.j(this) < iA) {
                temporalU = temporalU.u(2L, chronoUnit);
            }
            Temporal temporalU2 = temporalU.u(iJ - temporalU.j(this.f146596b.f146588g), chronoUnit);
            return temporalU2.j(this) > iA ? temporalU2.t(1L, chronoUnit) : temporalU2;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean b(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.g(ChronoField.f146499u)) {
                return false;
            }
            TemporalUnit temporalUnit = this.f146598d;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return temporalAccessor.g(ChronoField.f146502x);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return temporalAccessor.g(ChronoField.f146503y);
            }
            if (temporalUnit == IsoFields.f146532e) {
                return temporalAccessor.g(ChronoField.f146504z);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return temporalAccessor.g(ChronoField.f146504z);
            }
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange c(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            TemporalUnit temporalUnit = this.f146598d;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.f146599f;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.f146502x;
            } else {
                if (temporalUnit != ChronoUnit.YEARS) {
                    if (temporalUnit == IsoFields.f146532e) {
                        return q(temporalAccessor);
                    }
                    if (temporalUnit == ChronoUnit.FOREVER) {
                        return temporalAccessor.c(ChronoField.F);
                    }
                    throw new IllegalStateException("unreachable");
                }
                chronoField = ChronoField.f146503y;
            }
            int iR = r(temporalAccessor.j(chronoField), Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - this.f146596b.c().getValue(), 7) + 1);
            ValueRange valueRangeC = temporalAccessor.c(chronoField);
            return ValueRange.i(f(iR, (int) valueRangeC.d()), f(iR, (int) valueRangeC.c()));
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public long d(TemporalAccessor temporalAccessor) {
            int iH;
            int iF = Jdk8Methods.f(temporalAccessor.j(ChronoField.f146499u) - this.f146596b.c().getValue(), 7) + 1;
            TemporalUnit temporalUnit = this.f146598d;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return iF;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                int iJ = temporalAccessor.j(ChronoField.f146502x);
                iH = f(r(iJ, iF), iJ);
            } else if (temporalUnit == ChronoUnit.YEARS) {
                int iJ2 = temporalAccessor.j(ChronoField.f146503y);
                iH = f(r(iJ2, iF), iJ2);
            } else if (temporalUnit == IsoFields.f146532e) {
                iH = i(temporalAccessor);
            } else {
                if (temporalUnit != ChronoUnit.FOREVER) {
                    throw new IllegalStateException("unreachable");
                }
                iH = h(temporalAccessor);
            }
            return iH;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            long jA;
            ChronoLocalDate chronoLocalDateB;
            long jA2;
            ChronoLocalDate chronoLocalDateB2;
            long jA3;
            int iG;
            long jK;
            int value = this.f146596b.c().getValue();
            if (this.f146598d == ChronoUnit.WEEKS) {
                map.put(ChronoField.f146499u, Long.valueOf(Jdk8Methods.f((value - 1) + (this.f146599f.a(((Long) map.remove(this)).longValue(), this) - 1), 7) + 1));
                return null;
            }
            ChronoField chronoField = ChronoField.f146499u;
            if (!map.containsKey(chronoField)) {
                return null;
            }
            if (this.f146598d == ChronoUnit.FOREVER) {
                if (!map.containsKey(this.f146596b.f146588g)) {
                    return null;
                }
                Chronology chronologyI = Chronology.i(temporalAccessor);
                int iF = Jdk8Methods.f(chronoField.f(((Long) map.get(chronoField)).longValue()) - value, 7) + 1;
                int iA = range().a(((Long) map.get(this)).longValue(), this);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    chronoLocalDateB2 = chronologyI.b(iA, 1, this.f146596b.d());
                    jA3 = ((Long) map.get(this.f146596b.f146588g)).longValue();
                    iG = g(chronoLocalDateB2, value);
                    jK = k(chronoLocalDateB2, iG);
                } else {
                    chronoLocalDateB2 = chronologyI.b(iA, 1, this.f146596b.d());
                    jA3 = this.f146596b.f146588g.range().a(((Long) map.get(this.f146596b.f146588g)).longValue(), this.f146596b.f146588g);
                    iG = g(chronoLocalDateB2, value);
                    jK = k(chronoLocalDateB2, iG);
                }
                ChronoLocalDate chronoLocalDateU = chronoLocalDateB2.u(((jA3 - jK) * 7) + ((long) (iF - iG)), ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && chronoLocalDateU.m(this) != ((Long) map.get(this)).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(this.f146596b.f146588g);
                map.remove(chronoField);
                return chronoLocalDateU;
            }
            ChronoField chronoField2 = ChronoField.F;
            if (!map.containsKey(chronoField2)) {
                return null;
            }
            int iF2 = Jdk8Methods.f(chronoField.f(((Long) map.get(chronoField)).longValue()) - value, 7) + 1;
            int iF3 = chronoField2.f(((Long) map.get(chronoField2)).longValue());
            Chronology chronologyI2 = Chronology.i(temporalAccessor);
            TemporalUnit temporalUnit = this.f146598d;
            ChronoUnit chronoUnit = ChronoUnit.MONTHS;
            if (temporalUnit != chronoUnit) {
                if (temporalUnit != ChronoUnit.YEARS) {
                    throw new IllegalStateException("unreachable");
                }
                long jLongValue = ((Long) map.remove(this)).longValue();
                ChronoLocalDate chronoLocalDateB3 = chronologyI2.b(iF3, 1, 1);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    int iG2 = g(chronoLocalDateB3, value);
                    jA = ((jLongValue - k(chronoLocalDateB3, iG2)) * 7) + ((long) (iF2 - iG2));
                } else {
                    int iG3 = g(chronoLocalDateB3, value);
                    jA = ((long) (iF2 - iG3)) + ((((long) this.f146599f.a(jLongValue, this)) - k(chronoLocalDateB3, iG3)) * 7);
                }
                ChronoLocalDate chronoLocalDateU2 = chronoLocalDateB3.u(jA, ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && chronoLocalDateU2.m(chronoField2) != ((Long) map.get(chronoField2)).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(chronoField2);
                map.remove(chronoField);
                return chronoLocalDateU2;
            }
            ChronoField chronoField3 = ChronoField.C;
            if (!map.containsKey(chronoField3)) {
                return null;
            }
            long jLongValue2 = ((Long) map.remove(this)).longValue();
            if (resolverStyle == ResolverStyle.LENIENT) {
                chronoLocalDateB = chronologyI2.b(iF3, 1, 1).u(((Long) map.get(chronoField3)).longValue() - 1, chronoUnit);
                int iG4 = g(chronoLocalDateB, value);
                jA2 = ((jLongValue2 - j(chronoLocalDateB, iG4)) * 7) + ((long) (iF2 - iG4));
            } else {
                chronoLocalDateB = chronologyI2.b(iF3, chronoField3.f(((Long) map.get(chronoField3)).longValue()), 8);
                int iG5 = g(chronoLocalDateB, value);
                jA2 = ((long) (iF2 - iG5)) + ((((long) this.f146599f.a(jLongValue2, this)) - j(chronoLocalDateB, iG5)) * 7);
            }
            ChronoLocalDate chronoLocalDateU3 = chronoLocalDateB.u(jA2, ChronoUnit.DAYS);
            if (resolverStyle == ResolverStyle.STRICT && chronoLocalDateU3.m(chronoField3) != ((Long) map.get(chronoField3)).longValue()) {
                throw new DateTimeException("Strict mode rejected date parsed to a different month");
            }
            map.remove(this);
            map.remove(chronoField2);
            map.remove(chronoField3);
            map.remove(chronoField);
            return chronoLocalDateU3;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public ValueRange range() {
            return this.f146599f;
        }

        public String toString() {
            return this.f146595a + "[" + this.f146596b.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek, int i3) {
        Jdk8Methods.i(dayOfWeek, "firstDayOfWeek");
        if (i3 < 1 || i3 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f146583a = dayOfWeek;
        this.f146584b = i3;
    }

    public static WeekFields e(Locale locale) {
        Jdk8Methods.i(locale, "locale");
        return f(DayOfWeek.SUNDAY.n(r4.getFirstDayOfWeek() - 1), new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    public static WeekFields f(DayOfWeek dayOfWeek, int i3) {
        String str = dayOfWeek.toString() + i3;
        ConcurrentMap concurrentMap = f146580i;
        WeekFields weekFields = (WeekFields) concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i3));
        return (WeekFields) concurrentMap.get(str);
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return f(this.f146583a, this.f146584b);
        } catch (IllegalArgumentException e3) {
            throw new InvalidObjectException("Invalid WeekFields" + e3.getMessage());
        }
    }

    public TemporalField b() {
        return this.f146585c;
    }

    public DayOfWeek c() {
        return this.f146583a;
    }

    public int d() {
        return this.f146584b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public TemporalField g() {
        return this.f146589h;
    }

    public TemporalField h() {
        return this.f146586d;
    }

    public int hashCode() {
        return (this.f146583a.ordinal() * 7) + this.f146584b;
    }

    public TemporalField i() {
        return this.f146588g;
    }

    public String toString() {
        return "WeekFields[" + this.f146583a + ',' + this.f146584b + ']';
    }
}
