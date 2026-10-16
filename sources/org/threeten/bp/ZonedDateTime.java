package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoZonedDateTime;
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
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Temporal, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalQuery f146230f = new TemporalQuery<ZonedDateTime>() { // from class: org.threeten.bp.ZonedDateTime.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ZonedDateTime a(TemporalAccessor temporalAccessor) {
            return ZonedDateTime.F(temporalAccessor);
        }
    };
    private static final long serialVersionUID = -6260982410461394882L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDateTime f146231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f146232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZoneId f146233d;

    /* JADX INFO: renamed from: org.threeten.bp.ZonedDateTime$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146234a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146234a = iArr;
            try {
                iArr[ChronoField.H.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146234a[ChronoField.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.f146231b = localDateTime;
        this.f146232c = zoneOffset;
        this.f146233d = zoneId;
    }

    private static ZonedDateTime E(long j3, int i3, ZoneId zoneId) {
        ZoneOffset zoneOffsetA = zoneId.l().a(Instant.D(j3, i3));
        return new ZonedDateTime(LocalDateTime.X(j3, i3, zoneOffsetA), zoneOffsetA, zoneId);
    }

    public static ZonedDateTime F(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ZonedDateTime) {
            return (ZonedDateTime) temporalAccessor;
        }
        try {
            ZoneId zoneIdD = ZoneId.d(temporalAccessor);
            ChronoField chronoField = ChronoField.H;
            if (temporalAccessor.g(chronoField)) {
                try {
                    return E(temporalAccessor.m(chronoField), temporalAccessor.j(ChronoField.f146484f), zoneIdD);
                } catch (DateTimeException unused) {
                }
            }
            return I(LocalDateTime.H(temporalAccessor), zoneIdD);
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static ZonedDateTime I(LocalDateTime localDateTime, ZoneId zoneId) {
        return S(localDateTime, zoneId, null);
    }

    public static ZonedDateTime P(Instant instant, ZoneId zoneId) {
        Jdk8Methods.i(instant, "instant");
        Jdk8Methods.i(zoneId, "zone");
        return E(instant.t(), instant.u(), zoneId);
    }

    public static ZonedDateTime Q(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.i(localDateTime, "localDateTime");
        Jdk8Methods.i(zoneOffset, "offset");
        Jdk8Methods.i(zoneId, "zone");
        return E(localDateTime.x(zoneOffset), localDateTime.I(), zoneId);
    }

    private static ZonedDateTime R(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.i(localDateTime, "localDateTime");
        Jdk8Methods.i(zoneOffset, "offset");
        Jdk8Methods.i(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime S(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.i(localDateTime, "localDateTime");
        Jdk8Methods.i(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules zoneRulesL = zoneId.l();
        List listC = zoneRulesL.c(localDateTime);
        if (listC.size() == 1) {
            zoneOffset = (ZoneOffset) listC.get(0);
        } else if (listC.size() == 0) {
            ZoneOffsetTransition zoneOffsetTransitionB = zoneRulesL.b(localDateTime);
            localDateTime = localDateTime.e0(zoneOffsetTransitionB.d().i());
            zoneOffset = zoneOffsetTransitionB.g();
        } else if (zoneOffset == null || !listC.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Jdk8Methods.i(listC.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    static ZonedDateTime V(DataInput dataInput) {
        return R(LocalDateTime.h0(dataInput), ZoneOffset.C(dataInput), (ZoneId) Ser.a(dataInput));
    }

    private ZonedDateTime W(LocalDateTime localDateTime) {
        return Q(localDateTime, this.f146232c, this.f146233d);
    }

    private ZonedDateTime X(LocalDateTime localDateTime) {
        return S(localDateTime, this.f146233d, this.f146232c);
    }

    private ZonedDateTime Y(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.f146232c) || !this.f146233d.l().f(this.f146231b, zoneOffset)) ? this : new ZonedDateTime(this.f146231b, zoneOffset, this.f146233d);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    public int G() {
        return this.f146231b.I();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ZonedDateTime t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? w(Long.MAX_VALUE, temporalUnit).w(1L, temporalUnit) : w(-j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ZonedDateTime u(long j3, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.isDateBased() ? X(this.f146231b.o(j3, temporalUnit)) : W(this.f146231b.o(j3, temporalUnit)) : (ZonedDateTime) temporalUnit.b(this, j3);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LocalDate w() {
        return this.f146231b.z();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public LocalDateTime x() {
        return this.f146231b;
    }

    public OffsetDateTime b0() {
        return OffsetDateTime.w(this.f146231b, this.f146232c);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.H || temporalField == ChronoField.I) ? temporalField.range() : this.f146231b.c(temporalField) : temporalField.c(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ZonedDateTime z(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return X(LocalDateTime.W((LocalDate) temporalAdjuster, this.f146231b.A()));
        }
        if (temporalAdjuster instanceof LocalTime) {
            return X(LocalDateTime.W(this.f146231b.z(), (LocalTime) temporalAdjuster));
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return X((LocalDateTime) temporalAdjuster);
        }
        if (!(temporalAdjuster instanceof Instant)) {
            return temporalAdjuster instanceof ZoneOffset ? Y((ZoneOffset) temporalAdjuster) : (ZonedDateTime) temporalAdjuster.b(this);
        }
        Instant instant = (Instant) temporalAdjuster;
        return E(instant.t(), instant.u(), this.f146233d);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ZonedDateTime a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i3 = AnonymousClass2.f146234a[chronoField.ordinal()];
        return i3 != 1 ? i3 != 2 ? X(this.f146231b.D(temporalField, j3)) : Y(ZoneOffset.A(chronoField.f(j3))) : E(j3, G(), this.f146233d);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? w() : super.e(temporalQuery);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime B(ZoneId zoneId) {
        Jdk8Methods.i(zoneId, "zone");
        return this.f146233d.equals(zoneId) ? this : E(this.f146231b.x(this.f146232c), this.f146231b.I(), zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f146231b.equals(zonedDateTime.f146231b) && this.f146232c.equals(zonedDateTime.f146232c) && this.f146233d.equals(zonedDateTime.f146233d)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public ZonedDateTime D(ZoneId zoneId) {
        Jdk8Methods.i(zoneId, "zone");
        return this.f146233d.equals(zoneId) ? this : S(this.f146231b, zoneId, this.f146232c);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return true;
        }
        return temporalField != null && temporalField.b(this);
    }

    void h0(DataOutput dataOutput) {
        this.f146231b.n0(dataOutput);
        this.f146232c.F(dataOutput);
        this.f146233d.t(dataOutput);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        return (this.f146231b.hashCode() ^ this.f146232c.hashCode()) ^ Integer.rotateLeft(this.f146233d.hashCode(), 3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime zonedDateTimeF = F(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, zonedDateTimeF);
        }
        ZonedDateTime zonedDateTimeB = zonedDateTimeF.B(this.f146233d);
        return temporalUnit.isDateBased() ? this.f146231b.i(zonedDateTimeB.f146231b, temporalUnit) : b0().i(zonedDateTimeB.b0(), temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.j(temporalField);
        }
        int i3 = AnonymousClass2.f146234a[((ChronoField) temporalField).ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? this.f146231b.j(temporalField) : r().x();
        }
        throw new DateTimeException("Field too large for an int: " + temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i3 = AnonymousClass2.f146234a[((ChronoField) temporalField).ordinal()];
        return i3 != 1 ? i3 != 2 ? this.f146231b.m(temporalField) : r().x() : toEpochSecond();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset r() {
        return this.f146232c;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId s() {
        return this.f146233d;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String str = this.f146231b.toString() + this.f146232c.toString();
        if (this.f146232c == this.f146233d) {
            return str;
        }
        return str + '[' + this.f146233d.toString() + ']';
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalTime y() {
        return this.f146231b.A();
    }
}
