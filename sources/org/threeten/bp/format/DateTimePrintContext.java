package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class DateTimePrintContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TemporalAccessor f146441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Locale f146442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DecimalStyle f146443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f146444d;

    DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.f146441a = a(temporalAccessor, dateTimeFormatter);
        this.f146442b = dateTimeFormatter.h();
        this.f146443c = dateTimeFormatter.g();
    }

    private static TemporalAccessor a(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology chronologyF = dateTimeFormatter.f();
        ZoneId zoneIdK = dateTimeFormatter.k();
        if (chronologyF == null && zoneIdK == null) {
            return temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.e(TemporalQueries.a());
        final ZoneId zoneId = (ZoneId) temporalAccessor.e(TemporalQueries.g());
        final ChronoLocalDate chronoLocalDateC = null;
        if (Jdk8Methods.c(chronology, chronologyF)) {
            chronologyF = null;
        }
        if (Jdk8Methods.c(zoneId, zoneIdK)) {
            zoneIdK = null;
        }
        if (chronologyF == null && zoneIdK == null) {
            return temporalAccessor;
        }
        final Chronology chronology2 = chronologyF != null ? chronologyF : chronology;
        if (zoneIdK != null) {
            zoneId = zoneIdK;
        }
        if (zoneIdK != null) {
            if (temporalAccessor.g(ChronoField.H)) {
                if (chronology2 == null) {
                    chronology2 = IsoChronology.f146288f;
                }
                return chronology2.q(Instant.s(temporalAccessor), zoneIdK);
            }
            ZoneId zoneIdN = zoneIdK.n();
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.e(TemporalQueries.d());
            if ((zoneIdN instanceof ZoneOffset) && zoneOffset != null && !zoneIdN.equals(zoneOffset)) {
                throw new DateTimeException("Invalid override zone for temporal: " + zoneIdK + " " + temporalAccessor);
            }
        }
        if (chronologyF != null) {
            if (temporalAccessor.g(ChronoField.f146504z)) {
                chronoLocalDateC = chronology2.c(temporalAccessor);
            } else if (chronologyF != IsoChronology.f146288f || chronology != null) {
                for (ChronoField chronoField : ChronoField.values()) {
                    if (chronoField.isDateBased() && temporalAccessor.g(chronoField)) {
                        throw new DateTimeException("Invalid override chronology for temporal: " + chronologyF + " " + temporalAccessor);
                    }
                }
            }
        }
        return new DefaultInterfaceTemporalAccessor() { // from class: org.threeten.bp.format.DateTimePrintContext.1
            @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
            public ValueRange c(TemporalField temporalField) {
                return (chronoLocalDateC == null || !temporalField.isDateBased()) ? temporalAccessor.c(temporalField) : chronoLocalDateC.c(temporalField);
            }

            @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
            public Object e(TemporalQuery temporalQuery) {
                return temporalQuery == TemporalQueries.a() ? chronology2 : temporalQuery == TemporalQueries.g() ? zoneId : temporalQuery == TemporalQueries.e() ? temporalAccessor.e(temporalQuery) : temporalQuery.a(this);
            }

            @Override // org.threeten.bp.temporal.TemporalAccessor
            public boolean g(TemporalField temporalField) {
                return (chronoLocalDateC == null || !temporalField.isDateBased()) ? temporalAccessor.g(temporalField) : chronoLocalDateC.g(temporalField);
            }

            @Override // org.threeten.bp.temporal.TemporalAccessor
            public long m(TemporalField temporalField) {
                return (chronoLocalDateC == null || !temporalField.isDateBased()) ? temporalAccessor.m(temporalField) : chronoLocalDateC.m(temporalField);
            }
        };
    }

    void b() {
        this.f146444d--;
    }

    Locale c() {
        return this.f146442b;
    }

    DecimalStyle d() {
        return this.f146443c;
    }

    TemporalAccessor e() {
        return this.f146441a;
    }

    Long f(TemporalField temporalField) {
        try {
            return Long.valueOf(this.f146441a.m(temporalField));
        } catch (DateTimeException e3) {
            if (this.f146444d > 0) {
                return null;
            }
            throw e3;
        }
    }

    Object g(TemporalQuery temporalQuery) {
        Object objE = this.f146441a.e(temporalQuery);
        if (objE != null || this.f146444d != 0) {
            return objE;
        }
        throw new DateTimeException("Unable to extract value: " + this.f146441a.getClass());
    }

    void h() {
        this.f146444d++;
    }

    public String toString() {
        return this.f146441a.toString();
    }
}
