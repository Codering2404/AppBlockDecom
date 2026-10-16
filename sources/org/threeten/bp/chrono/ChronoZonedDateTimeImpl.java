package org.threeten.bp.chrono;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ChronoLocalDateTimeImpl f146247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ZoneOffset f146248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ZoneId f146249d;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoZonedDateTimeImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146250a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146250a = iArr;
            try {
                iArr[ChronoField.H.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146250a[ChronoField.I.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.f146247b = (ChronoLocalDateTimeImpl) Jdk8Methods.i(chronoLocalDateTimeImpl, "dateTime");
        this.f146248c = (ZoneOffset) Jdk8Methods.i(zoneOffset, "offset");
        this.f146249d = (ZoneId) Jdk8Methods.i(zoneId, "zone");
    }

    private ChronoZonedDateTimeImpl E(Instant instant, ZoneId zoneId) {
        return G(w().s(), instant, zoneId);
    }

    static ChronoZonedDateTime F(ChronoLocalDateTimeImpl chronoLocalDateTimeImpl, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.i(chronoLocalDateTimeImpl, "localDateTime");
        Jdk8Methods.i(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules zoneRulesL = zoneId.l();
        LocalDateTime localDateTimeH = LocalDateTime.H(chronoLocalDateTimeImpl);
        List listC = zoneRulesL.c(localDateTimeH);
        if (listC.size() == 1) {
            zoneOffset = (ZoneOffset) listC.get(0);
        } else if (listC.size() == 0) {
            ZoneOffsetTransition zoneOffsetTransitionB = zoneRulesL.b(localDateTimeH);
            chronoLocalDateTimeImpl = chronoLocalDateTimeImpl.Q(zoneOffsetTransitionB.d().i());
            zoneOffset = zoneOffsetTransitionB.g();
        } else if (zoneOffset == null || !listC.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) listC.get(0);
        }
        Jdk8Methods.i(zoneOffset, "offset");
        return new ChronoZonedDateTimeImpl(chronoLocalDateTimeImpl, zoneOffset, zoneId);
    }

    static ChronoZonedDateTimeImpl G(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetA = zoneId.l().a(instant);
        Jdk8Methods.i(zoneOffsetA, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) chronology.k(LocalDateTime.X(instant.t(), instant.u(), zoneOffsetA)), zoneOffsetA, zoneId);
    }

    static ChronoZonedDateTime H(ObjectInput objectInput) {
        ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) objectInput.readObject();
        ZoneOffset zoneOffset = (ZoneOffset) objectInput.readObject();
        return chronoLocalDateTime.q(zoneOffset).D((ZoneId) objectInput.readObject());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(Ascii.CR, this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: A */
    public ChronoZonedDateTime a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return w().s().g(temporalField.a(this, j3));
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i3 = AnonymousClass1.f146250a[chronoField.ordinal()];
        if (i3 == 1) {
            return u(j3 - toEpochSecond(), ChronoUnit.SECONDS);
        }
        if (i3 != 2) {
            return F(this.f146247b.a(temporalField, j3), this.f146249d, this.f146248c);
        }
        return E(this.f146247b.y(ZoneOffset.A(chronoField.f(j3))), this.f146249d);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime B(ZoneId zoneId) {
        Jdk8Methods.i(zoneId, "zone");
        return this.f146249d.equals(zoneId) ? this : E(this.f146247b.y(this.f146248c), zoneId);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime D(ZoneId zoneId) {
        return F(this.f146247b, zoneId, this.f146248c);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return true;
        }
        return temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        return (x().hashCode() ^ r().hashCode()) ^ Integer.rotateLeft(s().hashCode(), 3);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoZonedDateTime chronoZonedDateTimeR = w().s().r(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, chronoZonedDateTimeR);
        }
        return this.f146247b.i(chronoZonedDateTimeR.B(this.f146248c).x(), temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset r() {
        return this.f146248c;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId s() {
        return this.f146249d;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String str = x().toString() + r().toString();
        if (r() == s()) {
            return str;
        }
        return str + '[' + s().toString() + ']';
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ChronoZonedDateTime u(long j3, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? z(this.f146247b.u(j3, temporalUnit)) : w().s().g(temporalUnit.b(this, j3));
    }

    void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f146247b);
        objectOutput.writeObject(this.f146248c);
        objectOutput.writeObject(this.f146249d);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ChronoLocalDateTime x() {
        return this.f146247b;
    }
}
