package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
public final class OffsetTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<OffsetTime>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OffsetTime f146192c = LocalTime.f146152f.p(ZoneOffset.f146224k);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final OffsetTime f146193d = LocalTime.f146153g.p(ZoneOffset.f146223j);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalQuery f146194f = new TemporalQuery<OffsetTime>() { // from class: org.threeten.bp.OffsetTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OffsetTime a(TemporalAccessor temporalAccessor) {
            return OffsetTime.q(temporalAccessor);
        }
    };
    private static final long serialVersionUID = 7264499704384272492L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalTime f146195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f146196b;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146197a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146197a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146197a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146197a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146197a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146197a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146197a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146197a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        this.f146195a = (LocalTime) Jdk8Methods.i(localTime, "time");
        this.f146196b = (ZoneOffset) Jdk8Methods.i(zoneOffset, "offset");
    }

    public static OffsetTime q(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetTime) {
            return (OffsetTime) temporalAccessor;
        }
        try {
            return new OffsetTime(LocalTime.s(temporalAccessor), ZoneOffset.w(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static OffsetTime t(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    static OffsetTime v(DataInput dataInput) {
        return t(LocalTime.S(dataInput), ZoneOffset.C(dataInput));
    }

    private long w() {
        return this.f146195a.U() - (((long) this.f146196b.x()) * 1000000000);
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    private OffsetTime x(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.f146195a == localTime && this.f146196b.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }

    void A(DataOutput dataOutput) {
        this.f146195a.c0(dataOutput);
        this.f146196b.F(dataOutput);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146485g, this.f146195a.U()).a(ChronoField.I, r().x());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.I ? temporalField.range() : this.f146195a.c(temporalField) : temporalField.c(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return r();
        }
        if (temporalQuery == TemporalQueries.c()) {
            return this.f146195a;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetTime) {
            OffsetTime offsetTime = (OffsetTime) obj;
            if (this.f146195a.equals(offsetTime.f146195a) && this.f146196b.equals(offsetTime.f146196b)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() || temporalField == ChronoField.I : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        return this.f146195a.hashCode() ^ this.f146196b.hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetTime offsetTimeQ = q(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, offsetTimeQ);
        }
        long jW = offsetTimeQ.w() - w();
        switch (AnonymousClass2.f146197a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return jW;
            case 2:
                return jW / 1000;
            case 3:
                return jW / 1000000;
            case 4:
                return jW / 1000000000;
            case 5:
                return jW / 60000000000L;
            case 6:
                return jW / 3600000000000L;
            case 7:
                return jW / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return super.j(temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.I ? r().x() : this.f146195a.m(temporalField) : temporalField.d(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(OffsetTime offsetTime) {
        if (this.f146196b.equals(offsetTime.f146196b)) {
            return this.f146195a.compareTo(offsetTime.f146195a);
        }
        int iB = Jdk8Methods.b(w(), offsetTime.w());
        return iB == 0 ? this.f146195a.compareTo(offsetTime.f146195a) : iB;
    }

    public ZoneOffset r() {
        return this.f146196b;
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public OffsetTime t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? u(Long.MAX_VALUE, temporalUnit).u(1L, temporalUnit) : u(-j3, temporalUnit);
    }

    public String toString() {
        return this.f146195a.toString() + this.f146196b.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public OffsetTime u(long j3, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? x(this.f146195a.w(j3, temporalUnit), this.f146196b) : (OffsetTime) temporalUnit.b(this, j3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public OffsetTime z(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalTime ? x((LocalTime) temporalAdjuster, this.f146196b) : temporalAdjuster instanceof ZoneOffset ? x(this.f146195a, (ZoneOffset) temporalAdjuster) : temporalAdjuster instanceof OffsetTime ? (OffsetTime) temporalAdjuster : (OffsetTime) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public OffsetTime a(TemporalField temporalField, long j3) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.I ? x(this.f146195a, ZoneOffset.A(((ChronoField) temporalField).f(j3))) : x(this.f146195a.a(temporalField, j3), this.f146196b) : (OffsetTime) temporalField.a(this, j3);
    }
}
