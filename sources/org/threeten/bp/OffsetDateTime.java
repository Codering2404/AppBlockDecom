package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class OffsetDateTime extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OffsetDateTime f146185c = LocalDateTime.f146146d.E(ZoneOffset.f146224k);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final OffsetDateTime f146186d = LocalDateTime.f146147f.E(ZoneOffset.f146223j);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalQuery f146187f = new TemporalQuery<OffsetDateTime>() { // from class: org.threeten.bp.OffsetDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OffsetDateTime a(TemporalAccessor temporalAccessor) {
            return OffsetDateTime.s(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Comparator f146188g = new Comparator<OffsetDateTime>() { // from class: org.threeten.bp.OffsetDateTime.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int iB = Jdk8Methods.b(offsetDateTime.toEpochSecond(), offsetDateTime2.toEpochSecond());
            return iB == 0 ? Jdk8Methods.b(offsetDateTime.t(), offsetDateTime2.t()) : iB;
        }
    };
    private static final long serialVersionUID = 2287754244819255394L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalDateTime f146189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f146190b;

    /* JADX INFO: renamed from: org.threeten.bp.OffsetDateTime$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146191a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146191a = iArr;
            try {
                iArr[ChronoField.H.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146191a[ChronoField.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.f146189a = (LocalDateTime) Jdk8Methods.i(localDateTime, "dateTime");
        this.f146190b = (ZoneOffset) Jdk8Methods.i(zoneOffset, "offset");
    }

    static OffsetDateTime B(DataInput dataInput) {
        return w(LocalDateTime.h0(dataInput), ZoneOffset.C(dataInput));
    }

    private OffsetDateTime H(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f146189a == localDateTime && this.f146190b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime s(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetDateTime) {
            return (OffsetDateTime) temporalAccessor;
        }
        try {
            ZoneOffset zoneOffsetW = ZoneOffset.w(temporalAccessor);
            try {
                temporalAccessor = w(LocalDateTime.H(temporalAccessor), zoneOffsetW);
                return temporalAccessor;
            } catch (DateTimeException unused) {
                return x(Instant.s(temporalAccessor), zoneOffsetW);
            }
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static OffsetDateTime w(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    public static OffsetDateTime x(Instant instant, ZoneId zoneId) {
        Jdk8Methods.i(instant, "instant");
        Jdk8Methods.i(zoneId, "zone");
        ZoneOffset zoneOffsetA = zoneId.l().a(instant);
        return new OffsetDateTime(LocalDateTime.X(instant.t(), instant.u(), zoneOffsetA), zoneOffsetA);
    }

    public static OffsetDateTime y(CharSequence charSequence) {
        return z(charSequence, DateTimeFormatter.f146342o);
    }

    public static OffsetDateTime z(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.i(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.n(charSequence, f146187f);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public OffsetDateTime u(long j3, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? H(this.f146189a.o(j3, temporalUnit), this.f146190b) : (OffsetDateTime) temporalUnit.b(this, j3);
    }

    public Instant D() {
        return this.f146189a.y(this.f146190b);
    }

    public LocalDate E() {
        return this.f146189a.z();
    }

    public LocalDateTime F() {
        return this.f146189a;
    }

    public LocalTime G() {
        return this.f146189a.A();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public OffsetDateTime z(TemporalAdjuster temporalAdjuster) {
        return ((temporalAdjuster instanceof LocalDate) || (temporalAdjuster instanceof LocalTime) || (temporalAdjuster instanceof LocalDateTime)) ? H(this.f146189a.B(temporalAdjuster), this.f146190b) : temporalAdjuster instanceof Instant ? x((Instant) temporalAdjuster, this.f146190b) : temporalAdjuster instanceof ZoneOffset ? H(this.f146189a, (ZoneOffset) temporalAdjuster) : temporalAdjuster instanceof OffsetDateTime ? (OffsetDateTime) temporalAdjuster : (OffsetDateTime) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public OffsetDateTime a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (OffsetDateTime) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i3 = AnonymousClass3.f146191a[chronoField.ordinal()];
        return i3 != 1 ? i3 != 2 ? H(this.f146189a.D(temporalField, j3), this.f146190b) : H(this.f146189a, ZoneOffset.A(chronoField.f(j3))) : x(Instant.D(j3, t()), this.f146190b);
    }

    public OffsetDateTime Q(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.f146190b)) {
            return this;
        }
        return new OffsetDateTime(this.f146189a.e0(zoneOffset.x() - this.f146190b.x()), zoneOffset);
    }

    void R(DataOutput dataOutput) {
        this.f146189a.n0(dataOutput);
        this.f146190b.F(dataOutput);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146504z, E().toEpochDay()).a(ChronoField.f146485g, G().U()).a(ChronoField.I, u().x());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.H || temporalField == ChronoField.I) ? temporalField.range() : this.f146189a.c(temporalField) : temporalField.c(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.f146288f;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return u();
        }
        if (temporalQuery == TemporalQueries.b()) {
            return E();
        }
        if (temporalQuery == TemporalQueries.c()) {
            return G();
        }
        if (temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f146189a.equals(offsetDateTime.f146189a) && this.f146190b.equals(offsetDateTime.f146190b)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return true;
        }
        return temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        return this.f146189a.hashCode() ^ this.f146190b.hashCode();
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetDateTime offsetDateTimeS = s(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, offsetDateTimeS);
        }
        return this.f146189a.i(offsetDateTimeS.Q(this.f146190b).f146189a, temporalUnit);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.j(temporalField);
        }
        int i3 = AnonymousClass3.f146191a[((ChronoField) temporalField).ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? this.f146189a.j(temporalField) : u().x();
        }
        throw new DateTimeException("Field too large for an int: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i3 = AnonymousClass3.f146191a[((ChronoField) temporalField).ordinal()];
        return i3 != 1 ? i3 != 2 ? this.f146189a.m(temporalField) : u().x() : toEpochSecond();
    }

    public ZonedDateTime q(ZoneId zoneId) {
        return ZonedDateTime.Q(this.f146189a, this.f146190b, zoneId);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(OffsetDateTime offsetDateTime) {
        if (u().equals(offsetDateTime.u())) {
            return F().compareTo(offsetDateTime.F());
        }
        int iB = Jdk8Methods.b(toEpochSecond(), offsetDateTime.toEpochSecond());
        return (iB == 0 && (iB = G().v() - offsetDateTime.G().v()) == 0) ? F().compareTo(offsetDateTime.F()) : iB;
    }

    public int t() {
        return this.f146189a.I();
    }

    public long toEpochSecond() {
        return this.f146189a.x(this.f146190b);
    }

    public String toString() {
        return this.f146189a.toString() + this.f146190b.toString();
    }

    public ZoneOffset u() {
        return this.f146190b;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public OffsetDateTime t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? w(Long.MAX_VALUE, temporalUnit).w(1L, temporalUnit) : w(-j3, temporalUnit);
    }
}
