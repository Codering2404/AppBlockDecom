package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class TemporalQueries {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final TemporalQuery f146569a = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.temporal.TemporalQueries.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.e(this);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final TemporalQuery f146570b = new TemporalQuery<Chronology>() { // from class: org.threeten.bp.temporal.TemporalQueries.2
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Chronology a(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.e(this);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final TemporalQuery f146571c = new TemporalQuery<TemporalUnit>() { // from class: org.threeten.bp.temporal.TemporalQueries.3
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TemporalUnit a(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.e(this);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final TemporalQuery f146572d = new TemporalQuery<ZoneId>() { // from class: org.threeten.bp.temporal.TemporalQueries.4
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.e(TemporalQueries.f146569a);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.e(TemporalQueries.f146573e);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final TemporalQuery f146573e = new TemporalQuery<ZoneOffset>() { // from class: org.threeten.bp.temporal.TemporalQueries.5
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZoneOffset a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.I;
            if (temporalAccessor.g(chronoField)) {
                return ZoneOffset.A(temporalAccessor.j(chronoField));
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final TemporalQuery f146574f = new TemporalQuery<LocalDate>() { // from class: org.threeten.bp.temporal.TemporalQueries.6
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalDate a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.f146504z;
            if (temporalAccessor.g(chronoField)) {
                return LocalDate.i0(temporalAccessor.m(chronoField));
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final TemporalQuery f146575g = new TemporalQuery<LocalTime>() { // from class: org.threeten.bp.temporal.TemporalQueries.7
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalTime a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.f146485g;
            if (temporalAccessor.g(chronoField)) {
                return LocalTime.E(temporalAccessor.m(chronoField));
            }
            return null;
        }
    };

    public static final TemporalQuery a() {
        return f146570b;
    }

    public static final TemporalQuery b() {
        return f146574f;
    }

    public static final TemporalQuery c() {
        return f146575g;
    }

    public static final TemporalQuery d() {
        return f146573e;
    }

    public static final TemporalQuery e() {
        return f146571c;
    }

    public static final TemporalQuery f() {
        return f146572d;
    }

    public static final TemporalQuery g() {
        return f146569a;
    }
}
