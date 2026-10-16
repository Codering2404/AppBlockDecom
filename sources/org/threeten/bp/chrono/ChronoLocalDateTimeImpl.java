package org.threeten.bp.chrono;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.AccessTokenManager;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ChronoLocalDate f146238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocalTime f146239c;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoLocalDateTimeImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146240a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146240a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146240a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146240a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146240a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146240a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146240a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146240a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ChronoLocalDateTimeImpl(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Jdk8Methods.i(chronoLocalDate, "date");
        Jdk8Methods.i(localTime, "time");
        this.f146238b = chronoLocalDate;
        this.f146239c = localTime;
    }

    static ChronoLocalDateTimeImpl E(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(chronoLocalDate, localTime);
    }

    private ChronoLocalDateTimeImpl G(long j3) {
        return U(this.f146238b.u(j3, ChronoUnit.DAYS), this.f146239c);
    }

    private ChronoLocalDateTimeImpl H(long j3) {
        return R(this.f146238b, j3, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl I(long j3) {
        return R(this.f146238b, 0L, j3, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl P(long j3) {
        return R(this.f146238b, 0L, 0L, 0L, j3);
    }

    private ChronoLocalDateTimeImpl R(ChronoLocalDate chronoLocalDate, long j3, long j4, long j5, long j6) {
        if ((j3 | j4 | j5 | j6) == 0) {
            return U(chronoLocalDate, this.f146239c);
        }
        long jU = this.f146239c.U();
        long j7 = (j6 % 86400000000000L) + ((j5 % 86400) * 1000000000) + ((j4 % 1440) * 60000000000L) + ((j3 % 24) * 3600000000000L) + jU;
        long jE = (j6 / 86400000000000L) + (j5 / 86400) + (j4 / 1440) + (j3 / 24) + Jdk8Methods.e(j7, 86400000000000L);
        long jH = Jdk8Methods.h(j7, 86400000000000L);
        return U(chronoLocalDate.u(jE, ChronoUnit.DAYS), jH == jU ? this.f146239c : LocalTime.E(jH));
    }

    static ChronoLocalDateTime S(ObjectInput objectInput) {
        return ((ChronoLocalDate) objectInput.readObject()).q((LocalTime) objectInput.readObject());
    }

    private ChronoLocalDateTimeImpl U(Temporal temporal, LocalTime localTime) {
        ChronoLocalDate chronoLocalDate = this.f146238b;
        return (chronoLocalDate == temporal && this.f146239c == localTime) ? this : new ChronoLocalDateTimeImpl(chronoLocalDate.s().e(temporal), localTime);
    }

    private Object writeReplace() {
        return new Ser(Ascii.FF, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public LocalTime A() {
        return this.f146239c;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDateTimeImpl u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return this.f146238b.s().f(temporalUnit.b(this, j3));
        }
        switch (AnonymousClass1.f146240a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return P(j3);
            case 2:
                return G(j3 / 86400000000L).P((j3 % 86400000000L) * 1000);
            case 3:
                return G(j3 / 86400000).P((j3 % 86400000) * 1000000);
            case 4:
                return Q(j3);
            case 5:
                return I(j3);
            case 6:
                return H(j3);
            case 7:
                return G(j3 / 256).H((j3 % 256) * 12);
            default:
                return U(this.f146238b.u(j3, temporalUnit), this.f146239c);
        }
    }

    ChronoLocalDateTimeImpl Q(long j3) {
        return R(this.f146238b, 0L, 0L, j3, 0L);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDateTimeImpl z(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof ChronoLocalDate ? U((ChronoLocalDate) temporalAdjuster, this.f146239c) : temporalAdjuster instanceof LocalTime ? U(this.f146238b, (LocalTime) temporalAdjuster) : temporalAdjuster instanceof ChronoLocalDateTimeImpl ? this.f146238b.s().f((ChronoLocalDateTimeImpl) temporalAdjuster) : this.f146238b.s().f((ChronoLocalDateTimeImpl) temporalAdjuster.b(this));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public ChronoLocalDateTimeImpl a(TemporalField temporalField, long j3) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? U(this.f146238b, this.f146239c.a(temporalField, j3)) : U(this.f146238b.a(temporalField, j3), this.f146239c) : this.f146238b.s().f(temporalField.a(this, j3));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146239c.c(temporalField) : this.f146238b.c(temporalField) : temporalField.c(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() || temporalField.isTimeBased() : temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDateTime chronoLocalDateTimeK = z().s().k(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, chronoLocalDateTimeK);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (!chronoUnit.c()) {
            ChronoLocalDate chronoLocalDateZ = chronoLocalDateTimeK.z();
            if (chronoLocalDateTimeK.A().y(this.f146239c)) {
                chronoLocalDateZ = chronoLocalDateZ.t(1L, ChronoUnit.DAYS);
            }
            return this.f146238b.i(chronoLocalDateZ, temporalUnit);
        }
        ChronoField chronoField = ChronoField.f146504z;
        long jM = chronoLocalDateTimeK.m(chronoField) - this.f146238b.m(chronoField);
        switch (AnonymousClass1.f146240a[chronoUnit.ordinal()]) {
            case 1:
                jM = Jdk8Methods.n(jM, 86400000000000L);
                break;
            case 2:
                jM = Jdk8Methods.n(jM, 86400000000L);
                break;
            case 3:
                jM = Jdk8Methods.n(jM, 86400000L);
                break;
            case 4:
                jM = Jdk8Methods.m(jM, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS);
                break;
            case 5:
                jM = Jdk8Methods.m(jM, 1440);
                break;
            case 6:
                jM = Jdk8Methods.m(jM, 24);
                break;
            case 7:
                jM = Jdk8Methods.m(jM, 2);
                break;
        }
        return Jdk8Methods.k(jM, this.f146239c.i(chronoLocalDateTimeK.A(), temporalUnit));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146239c.j(temporalField) : this.f146238b.j(temporalField) : c(temporalField).a(m(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() ? this.f146239c.m(temporalField) : this.f146238b.m(temporalField) : temporalField.d(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime q(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.F(this, zoneId, null);
    }

    void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f146238b);
        objectOutput.writeObject(this.f146239c);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDateTime
    public ChronoLocalDate z() {
        return this.f146238b;
    }
}
