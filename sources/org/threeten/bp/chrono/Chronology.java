package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Chronology implements Comparable<Chronology> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalQuery f146251a = new TemporalQuery<Chronology>() { // from class: org.threeten.bp.chrono.Chronology.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Chronology a(TemporalAccessor temporalAccessor) {
            return Chronology.i(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f146252b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f146253c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f146254d;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.Chronology$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends DefaultInterfaceTemporalAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Chronology f146255a;

        @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
        public Object e(TemporalQuery temporalQuery) {
            return temporalQuery == TemporalQueries.a() ? this.f146255a : super.e(temporalQuery);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean g(TemporalField temporalField) {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long m(TemporalField temporalField) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    static {
        Method method;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
            method = null;
        }
        f146254d = method;
    }

    protected Chronology() {
    }

    public static Set getAvailableChronologies() {
        j();
        return new HashSet(f146252b.values());
    }

    public static Chronology i(TemporalAccessor temporalAccessor) {
        Jdk8Methods.i(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.e(TemporalQueries.a());
        return chronology != null ? chronology : IsoChronology.f146288f;
    }

    private static void j() {
        ConcurrentHashMap concurrentHashMap = f146252b;
        if (concurrentHashMap.isEmpty()) {
            n(IsoChronology.f146288f);
            n(ThaiBuddhistChronology.f146321f);
            n(MinguoChronology.f146312f);
            n(JapaneseChronology.f146293g);
            HijrahChronology hijrahChronology = HijrahChronology.f146256f;
            n(hijrahChronology);
            concurrentHashMap.putIfAbsent("Hijrah", hijrahChronology);
            f146253c.putIfAbsent("islamic", hijrahChronology);
            for (Chronology chronology : ServiceLoader.load(Chronology.class, Chronology.class.getClassLoader())) {
                f146252b.putIfAbsent(chronology.getId(), chronology);
                String calendarType = chronology.getCalendarType();
                if (calendarType != null) {
                    f146253c.putIfAbsent(calendarType, chronology);
                }
            }
        }
    }

    public static Chronology l(String str) {
        j();
        Chronology chronology = (Chronology) f146252b.get(str);
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = (Chronology) f146253c.get(str);
        if (chronology2 != null) {
            return chronology2;
        }
        throw new DateTimeException("Unknown chronology: " + str);
    }

    static Chronology m(DataInput dataInput) {
        return l(dataInput.readUTF());
    }

    private static void n(Chronology chronology) {
        f146252b.putIfAbsent(chronology.getId(), chronology);
        String calendarType = chronology.getCalendarType();
        if (calendarType != null) {
            f146253c.putIfAbsent(calendarType, chronology);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    public abstract ChronoLocalDate b(int i3, int i4, int i5);

    public abstract ChronoLocalDate c(TemporalAccessor temporalAccessor);

    public abstract ChronoLocalDate d(long j3);

    ChronoLocalDate e(Temporal temporal) {
        ChronoLocalDate chronoLocalDate = (ChronoLocalDate) temporal;
        if (equals(chronoLocalDate.s())) {
            return chronoLocalDate;
        }
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + chronoLocalDate.s().getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Chronology) && compareTo((Chronology) obj) == 0;
    }

    ChronoLocalDateTimeImpl f(Temporal temporal) {
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (equals(chronoLocalDateTimeImpl.z().s())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoLocalDateTimeImpl.z().s().getId());
    }

    ChronoZonedDateTimeImpl g(Temporal temporal) {
        ChronoZonedDateTimeImpl chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (equals(chronoZonedDateTimeImpl.w().s())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoZonedDateTimeImpl.w().s().getId());
    }

    public abstract String getCalendarType();

    public abstract String getId();

    public abstract Era h(int i3);

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public ChronoLocalDateTime k(TemporalAccessor temporalAccessor) {
        try {
            return c(temporalAccessor).q(LocalTime.s(temporalAccessor));
        } catch (DateTimeException e3) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e3);
        }
    }

    void o(Map map, ChronoField chronoField, long j3) {
        Long l3 = (Long) map.get(chronoField);
        if (l3 == null || l3.longValue() == j3) {
            map.put(chronoField, Long.valueOf(j3));
            return;
        }
        throw new DateTimeException("Invalid state, field: " + chronoField + " " + l3 + " conflicts with " + chronoField + " " + j3);
    }

    void p(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getId());
    }

    public ChronoZonedDateTime q(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.G(this, instant, zoneId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [org.threeten.bp.chrono.ChronoZonedDateTime] */
    public ChronoZonedDateTime r(TemporalAccessor temporalAccessor) {
        try {
            ZoneId zoneIdD = ZoneId.d(temporalAccessor);
            try {
                temporalAccessor = q(Instant.s(temporalAccessor), zoneIdD);
                return temporalAccessor;
            } catch (DateTimeException unused) {
                return ChronoZonedDateTimeImpl.F(f(k(temporalAccessor)), zoneIdD, null);
            }
        } catch (DateTimeException e3) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e3);
        }
    }

    public String toString() {
        return getId();
    }
}
