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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, Comparable<ChronoZonedDateTime<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Comparator f146245a = new Comparator<ChronoZonedDateTime<?>>() { // from class: org.threeten.bp.chrono.ChronoZonedDateTime.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
            int iB = Jdk8Methods.b(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
            return iB == 0 ? Jdk8Methods.b(chronoZonedDateTime.y().U(), chronoZonedDateTime2.y().U()) : iB;
        }
    };

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoZonedDateTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146246a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146246a = iArr;
            try {
                iArr[ChronoField.H.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146246a[ChronoField.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: A */
    public abstract ChronoZonedDateTime a(TemporalField temporalField, long j3);

    public abstract ChronoZonedDateTime B(ZoneId zoneId);

    public abstract ChronoZonedDateTime D(ZoneId zoneId);

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.H || temporalField == ChronoField.I) ? temporalField.range() : x().c(temporalField) : temporalField.c(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        return (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f()) ? s() : temporalQuery == TemporalQueries.a() ? w().s() : temporalQuery == TemporalQueries.e() ? ChronoUnit.NANOS : temporalQuery == TemporalQueries.d() ? r() : temporalQuery == TemporalQueries.b() ? LocalDate.i0(w().toEpochDay()) : temporalQuery == TemporalQueries.c() ? y() : super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    public int hashCode() {
        return (x().hashCode() ^ r().hashCode()) ^ Integer.rotateLeft(s().hashCode(), 3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.j(temporalField);
        }
        int i3 = AnonymousClass2.f146246a[((ChronoField) temporalField).ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? x().j(temporalField) : r().x();
        }
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i3 = AnonymousClass2.f146246a[((ChronoField) temporalField).ordinal()];
        return i3 != 1 ? i3 != 2 ? x().m(temporalField) : r().x() : toEpochSecond();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        int iB = Jdk8Methods.b(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        return (iB == 0 && (iB = y().v() - chronoZonedDateTime.y().v()) == 0 && (iB = x().compareTo(chronoZonedDateTime.x())) == 0 && (iB = s().getId().compareTo(chronoZonedDateTime.s().getId())) == 0) ? w().s().compareTo(chronoZonedDateTime.w().s()) : iB;
    }

    public abstract ZoneOffset r();

    public abstract ZoneId s();

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime t(long j3, TemporalUnit temporalUnit) {
        return w().s().g(super.t(j3, temporalUnit));
    }

    public long toEpochSecond() {
        return ((w().toEpochDay() * 86400) + ((long) y().V())) - ((long) r().x());
    }

    public String toString() {
        String str = x().toString() + r().toString();
        if (r() == s()) {
            return str;
        }
        return str + '[' + s().toString() + ']';
    }

    @Override // org.threeten.bp.temporal.Temporal
    public abstract ChronoZonedDateTime u(long j3, TemporalUnit temporalUnit);

    public Instant v() {
        return Instant.D(toEpochSecond(), y().v());
    }

    public ChronoLocalDate w() {
        return x().z();
    }

    public abstract ChronoLocalDateTime x();

    public LocalTime y() {
        return x().A();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime z(TemporalAdjuster temporalAdjuster) {
        return w().s().g(super.z(temporalAdjuster));
    }
}
