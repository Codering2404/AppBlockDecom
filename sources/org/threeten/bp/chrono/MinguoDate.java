package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long serialVersionUID = 1300372329181994526L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDate f146314b;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.MinguoDate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146315a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146315a = iArr;
            try {
                iArr[ChronoField.f146502x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146315a[ChronoField.f146503y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146315a[ChronoField.A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146315a[ChronoField.E.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146315a[ChronoField.D.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146315a[ChronoField.F.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146315a[ChronoField.G.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    MinguoDate(LocalDate localDate) {
        Jdk8Methods.i(localDate, "date");
        this.f146314b = localDate;
    }

    private long I() {
        return ((((long) P()) * 12) + ((long) this.f146314b.W())) - 1;
    }

    private int P() {
        return this.f146314b.Y() - 1911;
    }

    static ChronoLocalDate X(DataInput dataInput) throws IOException {
        return MinguoChronology.f146312f.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private MinguoDate Y(LocalDate localDate) {
        return localDate.equals(this.f146314b) ? this : new MinguoDate(localDate);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public MinguoChronology s() {
        return MinguoChronology.f146312f;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public MinguoEra t() {
        return (MinguoEra) super.t();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public MinguoDate t(long j3, TemporalUnit temporalUnit) {
        return (MinguoDate) super.t(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public MinguoDate u(long j3, TemporalUnit temporalUnit) {
        return (MinguoDate) super.u(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public MinguoDate y(TemporalAmount temporalAmount) {
        return (MinguoDate) super.y(temporalAmount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public MinguoDate D(long j3) {
        return Y(this.f146314b.p0(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public MinguoDate E(long j3) {
        return Y(this.f146314b.q0(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public MinguoDate F(long j3) {
        return Y(this.f146314b.s0(j3));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public MinguoDate z(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) super.z(temporalAdjuster);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.threeten.bp.chrono.MinguoDate a(org.threeten.bp.temporal.TemporalField r8, long r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof org.threeten.bp.temporal.ChronoField
            if (r0 == 0) goto L92
            r0 = r8
            org.threeten.bp.temporal.ChronoField r0 = (org.threeten.bp.temporal.ChronoField) r0
            long r1 = r7.m(r0)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = org.threeten.bp.chrono.MinguoDate.AnonymousClass1.f146315a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L3a
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L3a
            if (r2 == r3) goto L3a
            goto L52
        L25:
            org.threeten.bp.chrono.MinguoChronology r8 = r7.s()
            org.threeten.bp.temporal.ValueRange r8 = r8.w(r0)
            r8.b(r9, r0)
            long r0 = r7.I()
            long r9 = r9 - r0
            org.threeten.bp.chrono.MinguoDate r8 = r7.E(r9)
            return r8
        L3a:
            org.threeten.bp.chrono.MinguoChronology r2 = r7.s()
            org.threeten.bp.temporal.ValueRange r2 = r2.w(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L7b
            if (r0 == r4) goto L6e
            if (r0 == r3) goto L5d
        L52:
            org.threeten.bp.LocalDate r0 = r7.f146314b
            org.threeten.bp.LocalDate r8 = r0.a(r8, r9)
            org.threeten.bp.chrono.MinguoDate r8 = r7.Y(r8)
            return r8
        L5d:
            org.threeten.bp.LocalDate r8 = r7.f146314b
            int r9 = r7.P()
            int r9 = 1912 - r9
            org.threeten.bp.LocalDate r8 = r8.D0(r9)
            org.threeten.bp.chrono.MinguoDate r8 = r7.Y(r8)
            return r8
        L6e:
            org.threeten.bp.LocalDate r8 = r7.f146314b
            int r2 = r2 + 1911
            org.threeten.bp.LocalDate r8 = r8.D0(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.Y(r8)
            return r8
        L7b:
            org.threeten.bp.LocalDate r8 = r7.f146314b
            int r9 = r7.P()
            r10 = 1
            if (r9 < r10) goto L87
            int r2 = r2 + 1911
            goto L89
        L87:
            int r2 = 1912 - r2
        L89:
            org.threeten.bp.LocalDate r8 = r8.D0(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.Y(r8)
            return r8
        L92:
            org.threeten.bp.temporal.Temporal r8 = r8.a(r7, r9)
            org.threeten.bp.chrono.MinguoDate r8 = (org.threeten.bp.chrono.MinguoDate) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoDate.a(org.threeten.bp.temporal.TemporalField, long):org.threeten.bp.chrono.MinguoDate");
    }

    void b0(DataOutput dataOutput) {
        dataOutput.writeInt(j(ChronoField.F));
        dataOutput.writeByte(j(ChronoField.C));
        dataOutput.writeByte(j(ChronoField.f146502x));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (!g(temporalField)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i3 = AnonymousClass1.f146315a[chronoField.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return this.f146314b.c(temporalField);
        }
        if (i3 != 4) {
            return s().w(chronoField);
        }
        ValueRange valueRangeRange = ChronoField.F.range();
        return ValueRange.i(1L, P() <= 0 ? (-valueRangeRange.d()) + 1912 : valueRangeRange.c() - 1911);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            return this.f146314b.equals(((MinguoDate) obj).f146314b);
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        return s().getId().hashCode() ^ this.f146314b.hashCode();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long i(Temporal temporal, TemporalUnit temporalUnit) {
        return super.i(temporal, temporalUnit);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i3 = AnonymousClass1.f146315a[((ChronoField) temporalField).ordinal()];
        if (i3 == 4) {
            int iP = P();
            if (iP < 1) {
                iP = 1 - iP;
            }
            return iP;
        }
        if (i3 == 5) {
            return I();
        }
        if (i3 == 6) {
            return P();
        }
        if (i3 != 7) {
            return this.f146314b.m(temporalField);
        }
        return P() < 1 ? 0 : 1;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime q(LocalTime localTime) {
        return super.q(localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.f146314b.toEpochDay();
    }
}
