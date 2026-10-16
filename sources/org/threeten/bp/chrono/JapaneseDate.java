package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
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
public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final LocalDate f146298f = LocalDate.f0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocalDate f146299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient JapaneseEra f146300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f146301d;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.JapaneseDate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146302a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146302a = iArr;
            try {
                iArr[ChronoField.f146503y.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146302a[ChronoField.E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146302a[ChronoField.f146500v.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146302a[ChronoField.f146501w.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146302a[ChronoField.A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146302a[ChronoField.B.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146302a[ChronoField.G.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    JapaneseDate(LocalDate localDate) {
        if (localDate.v(f146298f)) {
            throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
        }
        this.f146300c = JapaneseEra.q(localDate);
        this.f146301d = localDate.Y() - (r0.u().Y() - 1);
        this.f146299b = localDate;
    }

    private ValueRange G(int i3) {
        Calendar calendar = Calendar.getInstance(JapaneseChronology.f146292f);
        calendar.set(0, this.f146300c.getValue() + 2);
        calendar.set(this.f146301d, this.f146299b.W() - 1, this.f146299b.R());
        return ValueRange.i(calendar.getActualMinimum(i3), calendar.getActualMaximum(i3));
    }

    private long I() {
        return this.f146301d == 1 ? (this.f146299b.U() - this.f146300c.u().U()) + 1 : this.f146299b.U();
    }

    static ChronoLocalDate X(DataInput dataInput) throws IOException {
        return JapaneseChronology.f146293g.b(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private JapaneseDate Y(LocalDate localDate) {
        return localDate.equals(this.f146299b) ? this : new JapaneseDate(localDate);
    }

    private JapaneseDate b0(int i3) {
        return c0(t(), i3);
    }

    private JapaneseDate c0(JapaneseEra japaneseEra, int i3) {
        return Y(this.f146299b.D0(JapaneseChronology.f146293g.w(japaneseEra, i3)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f146300c = JapaneseEra.q(this.f146299b);
        this.f146301d = this.f146299b.Y() - (r2.u().Y() - 1);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public JapaneseChronology s() {
        return JapaneseChronology.f146293g;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public JapaneseEra t() {
        return this.f146300c;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public JapaneseDate t(long j3, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.t(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public JapaneseDate u(long j3, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.u(j3, temporalUnit);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public JapaneseDate y(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.y(temporalAmount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public JapaneseDate D(long j3) {
        return Y(this.f146299b.p0(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public JapaneseDate E(long j3) {
        return Y(this.f146299b.q0(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.threeten.bp.chrono.ChronoDateImpl
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public JapaneseDate F(long j3) {
        return Y(this.f146299b.s0(j3));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public JapaneseDate z(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.z(temporalAdjuster);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public JapaneseDate a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (JapaneseDate) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (m(chronoField) == j3) {
            return this;
        }
        int[] iArr = AnonymousClass1.f146302a;
        int i3 = iArr[chronoField.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 7) {
            int iA = s().x(chronoField).a(j3, chronoField);
            int i4 = iArr[chronoField.ordinal()];
            if (i4 == 1) {
                return Y(this.f146299b.p0(((long) iA) - I()));
            }
            if (i4 == 2) {
                return b0(iA);
            }
            if (i4 == 7) {
                return c0(JapaneseEra.r(iA), this.f146301d);
            }
        }
        return Y(this.f146299b.a(temporalField, j3));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (g(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i3 = AnonymousClass1.f146302a[chronoField.ordinal()];
            return i3 != 1 ? i3 != 2 ? s().x(chronoField) : G(1) : G(6);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    void d0(DataOutput dataOutput) {
        dataOutput.writeInt(j(ChronoField.F));
        dataOutput.writeByte(j(ChronoField.C));
        dataOutput.writeByte(j(ChronoField.f146502x));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.f146299b.equals(((JapaneseDate) obj).f146299b);
        }
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        if (temporalField == ChronoField.f146500v || temporalField == ChronoField.f146501w || temporalField == ChronoField.A || temporalField == ChronoField.B) {
            return false;
        }
        return super.g(temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        return s().getId().hashCode() ^ this.f146299b.hashCode();
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
        switch (AnonymousClass1.f146302a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return I();
            case 2:
                return this.f146301d;
            case 3:
            case 4:
            case 5:
            case 6:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            case 7:
                return this.f146300c.getValue();
            default:
                return this.f146299b.m(temporalField);
        }
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.ChronoLocalDate
    public final ChronoLocalDateTime q(LocalTime localTime) {
        return super.q(localTime);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.f146299b.toEpochDay();
    }
}
