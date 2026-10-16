package org.threeten.bp;

import com.facebook.AccessTokenManager;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Temporal, TemporalAdjuster, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f146146d = W(LocalDate.f146138f, LocalTime.f146152f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LocalDateTime f146147f = W(LocalDate.f146139g, LocalTime.f146153g);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TemporalQuery f146148g = new TemporalQuery<LocalDateTime>() { // from class: org.threeten.bp.LocalDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalDateTime a(TemporalAccessor temporalAccessor) {
            return LocalDateTime.H(temporalAccessor);
        }
    };
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDate f146149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocalTime f146150c;

    /* JADX INFO: renamed from: org.threeten.bp.LocalDateTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146151a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146151a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146151a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146151a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146151a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146151a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146151a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146151a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.f146149b = localDate;
        this.f146150c = localTime;
    }

    private int G(LocalDateTime localDateTime) {
        int iF = this.f146149b.F(localDateTime.z());
        return iF == 0 ? this.f146150c.compareTo(localDateTime.A()) : iF;
    }

    public static LocalDateTime H(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).x();
        }
        try {
            return new LocalDateTime(LocalDate.I(temporalAccessor), LocalTime.s(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static LocalDateTime S() {
        return U(Clock.d());
    }

    public static LocalDateTime U(Clock clock) {
        Jdk8Methods.i(clock, "clock");
        Instant instantB = clock.b();
        return X(instantB.t(), instantB.u(), clock.a().l().a(instantB));
    }

    public static LocalDateTime V(int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new LocalDateTime(LocalDate.f0(i3, i4, i5), LocalTime.D(i6, i7, i8, i9));
    }

    public static LocalDateTime W(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.i(localDate, "date");
        Jdk8Methods.i(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime X(long j3, int i3, ZoneOffset zoneOffset) {
        Jdk8Methods.i(zoneOffset, "offset");
        return new LocalDateTime(LocalDate.i0(Jdk8Methods.e(j3 + ((long) zoneOffset.x()), 86400L)), LocalTime.G(Jdk8Methods.g(r2, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS), i3));
    }

    public static LocalDateTime Y(Instant instant, ZoneId zoneId) {
        Jdk8Methods.i(instant, "instant");
        Jdk8Methods.i(zoneId, "zone");
        return X(instant.t(), instant.u(), zoneId.l().a(instant));
    }

    private LocalDateTime f0(LocalDate localDate, long j3, long j4, long j5, long j6, int i3) {
        if ((j3 | j4 | j5 | j6) == 0) {
            return k0(localDate, this.f146150c);
        }
        long j7 = i3;
        long jU = this.f146150c.U();
        long j8 = (((j6 % 86400000000000L) + ((j5 % 86400) * 1000000000) + ((j4 % 1440) * 60000000000L) + ((j3 % 24) * 3600000000000L)) * j7) + jU;
        long jE = (((j6 / 86400000000000L) + (j5 / 86400) + (j4 / 1440) + (j3 / 24)) * j7) + Jdk8Methods.e(j8, 86400000000000L);
        long jH = Jdk8Methods.h(j8, 86400000000000L);
        return k0(localDate.p0(jE), jH == jU ? this.f146150c : LocalTime.E(jH));
    }

    static LocalDateTime h0(DataInput dataInput) {
        return W(LocalDate.t0(dataInput), LocalTime.S(dataInput));
    }

    private LocalDateTime k0(LocalDate localDate, LocalTime localTime) {
        return (this.f146149b == localDate && this.f146150c == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime A() {
        return this.f146150c;
    }

    public OffsetDateTime E(ZoneOffset zoneOffset) {
        return OffsetDateTime.w(this, zoneOffset);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime q(ZoneId zoneId) {
        return ZonedDateTime.I(this, zoneId);
    }

    public int I() {
        return this.f146150c.v();
    }

    public int P() {
        return this.f146150c.w();
    }

    public int Q() {
        return this.f146149b.Y();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LocalDateTime t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? o(Long.MAX_VALUE, temporalUnit).o(1L, temporalUnit) : o(-j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LocalDateTime u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.b(this, j3);
        }
        switch (AnonymousClass2.f146151a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return d0(j3);
            case 2:
                return a0(j3 / 86400000000L).d0((j3 % 86400000000L) * 1000);
            case 3:
                return a0(j3 / 86400000).d0((j3 % 86400000) * 1000000);
            case 4:
                return e0(j3);
            case 5:
                return c0(j3);
            case 6:
                return b0(j3);
            case 7:
                return a0(j3 / 256).b0((j3 % 256) * 12);
            default:
                return k0(this.f146149b.u(j3, temporalUnit), this.f146150c);
        }
    }

    public LocalDateTime a0(long j3) {
        return k0(this.f146149b.p0(j3), this.f146150c);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return super.b(temporal);
    }

    public LocalDateTime b0(long j3) {
        return f0(this.f146149b, j3, 0L, 0L, 0L, 1);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146150c.c(temporalField) : this.f146149b.c(temporalField) : temporalField.c(this);
    }

    public LocalDateTime c0(long j3) {
        return f0(this.f146149b, 0L, j3, 0L, 0L, 1);
    }

    public LocalDateTime d0(long j3) {
        return f0(this.f146149b, 0L, 0L, 0L, j3, 1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? z() : super.e(temporalQuery);
    }

    public LocalDateTime e0(long j3) {
        return f0(this.f146149b, 0L, 0L, j3, 0L, 1);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f146149b.equals(localDateTime.f146149b) && this.f146150c.equals(localDateTime.f146150c)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public int hashCode() {
        return this.f146149b.hashCode() ^ this.f146150c.hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDateTime localDateTimeH = H(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, localDateTimeH);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (!chronoUnit.c()) {
            LocalDate localDateP0 = localDateTimeH.f146149b;
            if (localDateP0.u(this.f146149b) && localDateTimeH.f146150c.y(this.f146150c)) {
                localDateP0 = localDateP0.a0(1L);
            } else if (localDateP0.v(this.f146149b) && localDateTimeH.f146150c.x(this.f146150c)) {
                localDateP0 = localDateP0.p0(1L);
            }
            return this.f146149b.i(localDateP0, temporalUnit);
        }
        long jH = this.f146149b.H(localDateTimeH.f146149b);
        long jU = localDateTimeH.f146150c.U() - this.f146150c.U();
        if (jH > 0 && jU < 0) {
            jH--;
            jU += 86400000000000L;
        } else if (jH < 0 && jU > 0) {
            jH++;
            jU -= 86400000000000L;
        }
        switch (AnonymousClass2.f146151a[chronoUnit.ordinal()]) {
            case 1:
                return Jdk8Methods.k(Jdk8Methods.n(jH, 86400000000000L), jU);
            case 2:
                return Jdk8Methods.k(Jdk8Methods.n(jH, 86400000000L), jU / 1000);
            case 3:
                return Jdk8Methods.k(Jdk8Methods.n(jH, 86400000L), jU / 1000000);
            case 4:
                return Jdk8Methods.k(Jdk8Methods.m(jH, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS), jU / 1000000000);
            case 5:
                return Jdk8Methods.k(Jdk8Methods.m(jH, 1440), jU / 60000000000L);
            case 6:
                return Jdk8Methods.k(Jdk8Methods.m(jH, 24), jU / 3600000000000L);
            case 7:
                return Jdk8Methods.k(Jdk8Methods.m(jH, 2), jU / 43200000000000L);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public LocalDate z() {
        return this.f146149b;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146150c.j(temporalField) : this.f146149b.j(temporalField) : super.j(temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LocalDateTime z(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? k0((LocalDate) temporalAdjuster, this.f146150c) : temporalAdjuster instanceof LocalTime ? k0(this.f146149b, (LocalTime) temporalAdjuster) : temporalAdjuster instanceof LocalDateTime ? (LocalDateTime) temporalAdjuster : (LocalDateTime) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146150c.m(temporalField) : this.f146149b.m(temporalField) : temporalField.d(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public LocalDateTime a(TemporalField temporalField, long j3) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? k0(this.f146149b, this.f146150c.a(temporalField, j3)) : k0(this.f146149b.a(temporalField, j3), this.f146150c) : (LocalDateTime) temporalField.a(this, j3);
    }

    void n0(DataOutput dataOutput) {
        this.f146149b.E0(dataOutput);
        this.f146150c.c0(dataOutput);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, java.lang.Comparable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? G((LocalDateTime) chronoLocalDateTime) : super.compareTo(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean t(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? G((LocalDateTime) chronoLocalDateTime) > 0 : super.t(chronoLocalDateTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public String toString() {
        return this.f146149b.toString() + 'T' + this.f146150c.toString();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public boolean u(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? G((LocalDateTime) chronoLocalDateTime) < 0 : super.u(chronoLocalDateTime);
    }
}
