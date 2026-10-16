package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f146236a = new Comparator<ChronoLocalDate>() { // from class: org.threeten.bp.chrono.ChronoLocalDate.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return Jdk8Methods.b(chronoLocalDate.toEpochDay(), chronoLocalDate2.toEpochDay());
        }
    };

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public abstract ChronoLocalDate a(TemporalField temporalField, long j3);

    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146504z, toEpochDay());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return s();
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.b()) {
            return LocalDate.i0(toEpochDay());
        }
        if (temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        long epochDay = toEpochDay();
        return ((int) (epochDay ^ (epochDay >>> 32))) ^ s().hashCode();
    }

    public ChronoLocalDateTime q(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.E(this, localTime);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        int iB = Jdk8Methods.b(toEpochDay(), chronoLocalDate.toEpochDay());
        return iB == 0 ? s().compareTo(chronoLocalDate.s()) : iB;
    }

    public abstract Chronology s();

    public Era t() {
        return s().h(j(ChronoField.G));
    }

    public long toEpochDay() {
        return m(ChronoField.f146504z);
    }

    public String toString() {
        long jM = m(ChronoField.E);
        long jM2 = m(ChronoField.C);
        long jM3 = m(ChronoField.f146502x);
        StringBuilder sb = new StringBuilder(30);
        sb.append(s().toString());
        sb.append(" ");
        sb.append(t());
        sb.append(" ");
        sb.append(jM);
        sb.append(jM2 < 10 ? "-0" : "-");
        sb.append(jM2);
        sb.append(jM3 < 10 ? "-0" : "-");
        sb.append(jM3);
        return sb.toString();
    }

    public boolean u(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() > chronoLocalDate.toEpochDay();
    }

    public boolean v(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() < chronoLocalDate.toEpochDay();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDate t(long j3, TemporalUnit temporalUnit) {
        return s().e(super.t(j3, temporalUnit));
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public abstract ChronoLocalDate u(long j3, TemporalUnit temporalUnit);

    public ChronoLocalDate y(TemporalAmount temporalAmount) {
        return s().e(super.p(temporalAmount));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoLocalDate z(TemporalAdjuster temporalAdjuster) {
        return s().e(super.z(temporalAdjuster));
    }
}
