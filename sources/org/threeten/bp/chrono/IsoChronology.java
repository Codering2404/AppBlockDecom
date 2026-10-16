package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class IsoChronology extends Chronology implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final IsoChronology f146288f = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    private IsoChronology() {
    }

    private Object readResolve() {
        return f146288f;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "ISO";
    }

    public boolean isLeapYear(long j3) {
        if ((3 & j3) == 0) {
            return j3 % 100 != 0 || j3 % 400 == 0;
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public LocalDate b(int i3, int i4, int i5) {
        return LocalDate.f0(i3, i4, i5);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public LocalDate c(TemporalAccessor temporalAccessor) {
        return LocalDate.I(temporalAccessor);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public LocalDate d(long j3) {
        return LocalDate.i0(j3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public IsoEra h(int i3) {
        return IsoEra.d(i3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public LocalDateTime k(TemporalAccessor temporalAccessor) {
        return LocalDateTime.H(temporalAccessor);
    }

    public LocalDate x(Map map, ResolverStyle resolverStyle) {
        Object obj = ChronoField.f146504z;
        if (map.containsKey(obj)) {
            return LocalDate.i0(((Long) map.remove(obj)).longValue());
        }
        ChronoField chronoField = ChronoField.D;
        Long l3 = (Long) map.remove(chronoField);
        if (l3 != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField.g(l3.longValue());
            }
            o(map, ChronoField.C, Jdk8Methods.g(l3.longValue(), 12) + 1);
            o(map, ChronoField.F, Jdk8Methods.e(l3.longValue(), 12L));
        }
        ChronoField chronoField2 = ChronoField.E;
        Long l4 = (Long) map.remove(chronoField2);
        if (l4 != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField2.g(l4.longValue());
            }
            Long l5 = (Long) map.remove(ChronoField.G);
            if (l5 == null) {
                ChronoField chronoField3 = ChronoField.F;
                Long l6 = (Long) map.get(chronoField3);
                if (resolverStyle != ResolverStyle.STRICT) {
                    o(map, chronoField3, (l6 == null || l6.longValue() > 0) ? l4.longValue() : Jdk8Methods.p(1L, l4.longValue()));
                } else if (l6 != null) {
                    o(map, chronoField3, l6.longValue() > 0 ? l4.longValue() : Jdk8Methods.p(1L, l4.longValue()));
                } else {
                    map.put(chronoField2, l4);
                }
            } else if (l5.longValue() == 1) {
                o(map, ChronoField.F, l4.longValue());
            } else {
                if (l5.longValue() != 0) {
                    throw new DateTimeException("Invalid value for era: " + l5);
                }
                o(map, ChronoField.F, Jdk8Methods.p(1L, l4.longValue()));
            }
        } else {
            ChronoField chronoField4 = ChronoField.G;
            if (map.containsKey(chronoField4)) {
                chronoField4.g(((Long) map.get(chronoField4)).longValue());
            }
        }
        ChronoField chronoField5 = ChronoField.F;
        if (!map.containsKey(chronoField5)) {
            return null;
        }
        ChronoField chronoField6 = ChronoField.C;
        if (map.containsKey(chronoField6)) {
            ChronoField chronoField7 = ChronoField.f146502x;
            if (map.containsKey(chronoField7)) {
                int iF = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
                int iQ = Jdk8Methods.q(((Long) map.remove(chronoField6)).longValue());
                int iQ2 = Jdk8Methods.q(((Long) map.remove(chronoField7)).longValue());
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return LocalDate.f0(iF, 1, 1).q0(Jdk8Methods.o(iQ, 1)).p0(Jdk8Methods.o(iQ2, 1));
                }
                if (resolverStyle != ResolverStyle.SMART) {
                    return LocalDate.f0(iF, iQ, iQ2);
                }
                chronoField7.g(iQ2);
                if (iQ == 4 || iQ == 6 || iQ == 9 || iQ == 11) {
                    iQ2 = Math.min(iQ2, 30);
                } else if (iQ == 2) {
                    iQ2 = Math.min(iQ2, Month.FEBRUARY.l(Year.r(iF)));
                }
                return LocalDate.f0(iF, iQ, iQ2);
            }
            ChronoField chronoField8 = ChronoField.A;
            if (map.containsKey(chronoField8)) {
                ChronoField chronoField9 = ChronoField.f146500v;
                if (map.containsKey(chronoField9)) {
                    int iF2 = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.f0(iF2, 1, 1).q0(Jdk8Methods.p(((Long) map.remove(chronoField6)).longValue(), 1L)).r0(Jdk8Methods.p(((Long) map.remove(chronoField8)).longValue(), 1L)).p0(Jdk8Methods.p(((Long) map.remove(chronoField9)).longValue(), 1L));
                    }
                    int iF3 = chronoField6.f(((Long) map.remove(chronoField6)).longValue());
                    LocalDate localDateP0 = LocalDate.f0(iF2, iF3, 1).p0(((chronoField8.f(((Long) map.remove(chronoField8)).longValue()) - 1) * 7) + (chronoField9.f(((Long) map.remove(chronoField9)).longValue()) - 1));
                    if (resolverStyle != ResolverStyle.STRICT || localDateP0.j(chronoField6) == iF3) {
                        return localDateP0;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
                ChronoField chronoField10 = ChronoField.f146499u;
                if (map.containsKey(chronoField10)) {
                    int iF4 = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return LocalDate.f0(iF4, 1, 1).q0(Jdk8Methods.p(((Long) map.remove(chronoField6)).longValue(), 1L)).r0(Jdk8Methods.p(((Long) map.remove(chronoField8)).longValue(), 1L)).p0(Jdk8Methods.p(((Long) map.remove(chronoField10)).longValue(), 1L));
                    }
                    int iF5 = chronoField6.f(((Long) map.remove(chronoField6)).longValue());
                    LocalDate localDateV0 = LocalDate.f0(iF4, iF5, 1).r0(chronoField8.f(((Long) map.remove(chronoField8)).longValue()) - 1).z(TemporalAdjusters.a(DayOfWeek.l(chronoField10.f(((Long) map.remove(chronoField10)).longValue()))));
                    if (resolverStyle != ResolverStyle.STRICT || localDateV0.j(chronoField6) == iF5) {
                        return localDateV0;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                }
            }
        }
        ChronoField chronoField11 = ChronoField.f146503y;
        if (map.containsKey(chronoField11)) {
            int iF6 = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.k0(iF6, 1).p0(Jdk8Methods.p(((Long) map.remove(chronoField11)).longValue(), 1L));
            }
            return LocalDate.k0(iF6, chronoField11.f(((Long) map.remove(chronoField11)).longValue()));
        }
        ChronoField chronoField12 = ChronoField.B;
        if (!map.containsKey(chronoField12)) {
            return null;
        }
        ChronoField chronoField13 = ChronoField.f146501w;
        if (map.containsKey(chronoField13)) {
            int iF7 = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
            if (resolverStyle == ResolverStyle.LENIENT) {
                return LocalDate.f0(iF7, 1, 1).r0(Jdk8Methods.p(((Long) map.remove(chronoField12)).longValue(), 1L)).p0(Jdk8Methods.p(((Long) map.remove(chronoField13)).longValue(), 1L));
            }
            LocalDate localDateP02 = LocalDate.f0(iF7, 1, 1).p0(((chronoField12.f(((Long) map.remove(chronoField12)).longValue()) - 1) * 7) + (chronoField13.f(((Long) map.remove(chronoField13)).longValue()) - 1));
            if (resolverStyle != ResolverStyle.STRICT || localDateP02.j(chronoField5) == iF7) {
                return localDateP02;
            }
            throw new DateTimeException("Strict mode rejected date parsed to a different year");
        }
        ChronoField chronoField14 = ChronoField.f146499u;
        if (!map.containsKey(chronoField14)) {
            return null;
        }
        int iF8 = chronoField5.f(((Long) map.remove(chronoField5)).longValue());
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.f0(iF8, 1, 1).r0(Jdk8Methods.p(((Long) map.remove(chronoField12)).longValue(), 1L)).p0(Jdk8Methods.p(((Long) map.remove(chronoField14)).longValue(), 1L));
        }
        LocalDate localDateV02 = LocalDate.f0(iF8, 1, 1).r0(chronoField12.f(((Long) map.remove(chronoField12)).longValue()) - 1).z(TemporalAdjusters.a(DayOfWeek.l(chronoField14.f(((Long) map.remove(chronoField14)).longValue()))));
        if (resolverStyle != ResolverStyle.STRICT || localDateV02.j(chronoField5) == iF8) {
            return localDateV02;
        }
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime q(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.P(instant, zoneId);
    }

    @Override // org.threeten.bp.chrono.Chronology
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime r(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.F(temporalAccessor);
    }
}
