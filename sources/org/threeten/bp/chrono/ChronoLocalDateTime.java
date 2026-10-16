package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f146237a = new Comparator<ChronoLocalDateTime<?>>() { // from class: org.threeten.bp.chrono.ChronoLocalDateTime.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChronoLocalDateTime chronoLocalDateTime, ChronoLocalDateTime chronoLocalDateTime2) {
            int iB = Jdk8Methods.b(chronoLocalDateTime.z().toEpochDay(), chronoLocalDateTime2.z().toEpochDay());
            return iB == 0 ? Jdk8Methods.b(chronoLocalDateTime.A().U(), chronoLocalDateTime2.A().U()) : iB;
        }
    };

    public abstract LocalTime A();

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDateTime z(TemporalAdjuster temporalAdjuster) {
        return z().s().f(super.z(temporalAdjuster));
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: D */
    public abstract ChronoLocalDateTime a(TemporalField temporalField, long j3);

    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146504z, z().toEpochDay()).a(ChronoField.f146485g, A().U());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return s();
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.b()) {
            return LocalDate.i0(z().toEpochDay());
        }
        if (temporalQuery == TemporalQueries.c()) {
            return A();
        }
        if (temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime) obj) == 0;
    }

    public int hashCode() {
        return z().hashCode() ^ A().hashCode();
    }

    public abstract ChronoZonedDateTime q(ZoneId zoneId);

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: r */
    public int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        int iCompareTo = z().compareTo(chronoLocalDateTime.z());
        return (iCompareTo == 0 && (iCompareTo = A().compareTo(chronoLocalDateTime.A())) == 0) ? s().compareTo(chronoLocalDateTime.s()) : iCompareTo;
    }

    public Chronology s() {
        return z().s();
    }

    public boolean t(ChronoLocalDateTime chronoLocalDateTime) {
        long epochDay = z().toEpochDay();
        long epochDay2 = chronoLocalDateTime.z().toEpochDay();
        if (epochDay <= epochDay2) {
            return epochDay == epochDay2 && A().U() > chronoLocalDateTime.A().U();
        }
        return true;
    }

    public String toString() {
        return z().toString() + 'T' + A().toString();
    }

    public boolean u(ChronoLocalDateTime chronoLocalDateTime) {
        long epochDay = z().toEpochDay();
        long epochDay2 = chronoLocalDateTime.z().toEpochDay();
        if (epochDay >= epochDay2) {
            return epochDay == epochDay2 && A().U() < chronoLocalDateTime.A().U();
        }
        return true;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDateTime t(long j3, TemporalUnit temporalUnit) {
        return z().s().f(super.t(j3, temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public abstract ChronoLocalDateTime u(long j3, TemporalUnit temporalUnit);

    public long x(ZoneOffset zoneOffset) {
        Jdk8Methods.i(zoneOffset, "offset");
        return ((z().toEpochDay() * 86400) + ((long) A().V())) - ((long) zoneOffset.x());
    }

    public Instant y(ZoneOffset zoneOffset) {
        return Instant.D(x(zoneOffset), A().v());
    }

    public abstract ChronoLocalDate z();
}
