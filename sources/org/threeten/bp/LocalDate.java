package org.threeten.bp;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class LocalDate extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LocalDate f146138f = f0(-999999999, 1, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LocalDate f146139g = f0(999999999, 12, 31);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TemporalQuery f146140h = new TemporalQuery<LocalDate>() { // from class: org.threeten.bp.LocalDate.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalDate a(TemporalAccessor temporalAccessor) {
            return LocalDate.I(temporalAccessor);
        }
    };
    private static final long serialVersionUID = 2942565459149668126L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f146142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f146143d;

    /* JADX INFO: renamed from: org.threeten.bp.LocalDate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f146145b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146145b = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146145b[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146145b[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146145b[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146145b[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146145b[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146145b[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146145b[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f146144a = iArr2;
            try {
                iArr2[ChronoField.f146502x.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146144a[ChronoField.f146503y.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146144a[ChronoField.A.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146144a[ChronoField.E.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f146144a[ChronoField.f146499u.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f146144a[ChronoField.f146500v.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f146144a[ChronoField.f146501w.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f146144a[ChronoField.f146504z.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f146144a[ChronoField.B.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f146144a[ChronoField.C.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f146144a[ChronoField.D.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f146144a[ChronoField.F.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f146144a[ChronoField.G.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int i3, int i4, int i5) {
        this.f146141b = i3;
        this.f146142c = (short) i4;
        this.f146143d = (short) i5;
    }

    private static LocalDate G(int i3, Month month, int i4) {
        if (i4 <= 28 || i4 <= month.l(IsoChronology.f146288f.isLeapYear(i3))) {
            return new LocalDate(i3, month.getValue(), i4);
        }
        if (i4 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i3 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month.name() + " " + i4 + "'");
    }

    public static LocalDate I(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.e(TemporalQueries.b());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int P(TemporalField temporalField) {
        switch (AnonymousClass2.f146144a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.f146143d;
            case 2:
                return U();
            case 3:
                return ((this.f146143d - 1) / 7) + 1;
            case 4:
                int i3 = this.f146141b;
                return i3 >= 1 ? i3 : 1 - i3;
            case 5:
                return S().getValue();
            case 6:
                return ((this.f146143d - 1) % 7) + 1;
            case 7:
                return ((U() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 9:
                return ((U() - 1) / 7) + 1;
            case 10:
                return this.f146142c;
            case 11:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 12:
                return this.f146141b;
            case 13:
                return this.f146141b >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long X() {
        return (((long) this.f146141b) * 12) + ((long) (this.f146142c - 1));
    }

    private long c0(LocalDate localDate) {
        return (((localDate.X() * 32) + ((long) localDate.R())) - ((X() * 32) + ((long) R()))) / 32;
    }

    public static LocalDate d0() {
        return e0(Clock.d());
    }

    public static LocalDate e0(Clock clock) {
        Jdk8Methods.i(clock, "clock");
        Instant instantB = clock.b();
        return i0(Jdk8Methods.e(instantB.t() + ((long) clock.a().l().a(instantB).x()), 86400L));
    }

    public static LocalDate f0(int i3, int i4, int i5) {
        ChronoField.F.g(i3);
        ChronoField.C.g(i4);
        ChronoField.f146502x.g(i5);
        return G(i3, Month.q(i4), i5);
    }

    public static LocalDate h0(int i3, Month month, int i4) {
        ChronoField.F.g(i3);
        Jdk8Methods.i(month, "month");
        ChronoField.f146502x.g(i4);
        return G(i3, month, i4);
    }

    public static LocalDate i0(long j3) {
        long j4;
        ChronoField.f146504z.g(j3);
        long j5 = 719468 + j3;
        if (j5 < 0) {
            long j6 = ((j3 + 719469) / 146097) - 1;
            j4 = j6 * 400;
            j5 += (-j6) * 146097;
        } else {
            j4 = 0;
        }
        long j7 = ((j5 * 400) + 591) / 146097;
        long j8 = j5 - ((((j7 * 365) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        if (j8 < 0) {
            j7--;
            j8 = j5 - ((((365 * j7) + (j7 / 4)) - (j7 / 100)) + (j7 / 400));
        }
        int i3 = (int) j8;
        int i4 = ((i3 * 5) + 2) / 153;
        return new LocalDate(ChronoField.F.f(j7 + j4 + ((long) (i4 / 10))), ((i4 + 2) % 12) + 1, (i3 - (((i4 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate k0(int i3, int i4) {
        long j3 = i3;
        ChronoField.F.g(j3);
        ChronoField.f146503y.g(i4);
        boolean zIsLeapYear = IsoChronology.f146288f.isLeapYear(j3);
        if (i4 != 366 || zIsLeapYear) {
            Month monthQ = Month.q(((i4 - 1) / 31) + 1);
            if (i4 > (monthQ.d(zIsLeapYear) + monthQ.l(zIsLeapYear)) - 1) {
                monthQ = monthQ.r(1L);
            }
            return G(i3, monthQ, (i4 - monthQ.d(zIsLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i3 + "' is not a leap year");
    }

    public static LocalDate l0(CharSequence charSequence) {
        return m0(charSequence, DateTimeFormatter.f146335h);
    }

    public static LocalDate m0(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.i(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.n(charSequence, f146140h);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    static LocalDate t0(DataInput dataInput) {
        return f0(dataInput.readInt(), dataInput.readByte(), dataInput.readByte());
    }

    private static LocalDate u0(int i3, int i4, int i5) {
        if (i4 == 2) {
            i5 = Math.min(i5, IsoChronology.f146288f.isLeapYear((long) i3) ? 29 : 28);
        } else if (i4 == 4 || i4 == 6 || i4 == 9 || i4 == 11) {
            i5 = Math.min(i5, 30);
        }
        return f0(i3, i4, i5);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public LocalDateTime B() {
        return LocalDateTime.W(this, LocalTime.f146154h);
    }

    public LocalDate B0(int i3) {
        return U() == i3 ? this : k0(this.f146141b, i3);
    }

    public LocalDate C0(int i3) {
        if (this.f146142c == i3) {
            return this;
        }
        ChronoField.C.g(i3);
        return u0(this.f146141b, i3, this.f146143d);
    }

    public LocalDate D0(int i3) {
        if (this.f146141b == i3) {
            return this;
        }
        ChronoField.F.g(i3);
        return u0(i3, this.f146142c, this.f146143d);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public LocalDateTime q(LocalTime localTime) {
        return LocalDateTime.W(this, localTime);
    }

    void E0(DataOutput dataOutput) {
        dataOutput.writeInt(this.f146141b);
        dataOutput.writeByte(this.f146142c);
        dataOutput.writeByte(this.f146143d);
    }

    int F(LocalDate localDate) {
        int i3 = this.f146141b - localDate.f146141b;
        if (i3 != 0) {
            return i3;
        }
        int i4 = this.f146142c - localDate.f146142c;
        return i4 == 0 ? this.f146143d - localDate.f146143d : i4;
    }

    long H(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public IsoChronology s() {
        return IsoChronology.f146288f;
    }

    public int R() {
        return this.f146143d;
    }

    public DayOfWeek S() {
        return DayOfWeek.l(Jdk8Methods.g(toEpochDay() + 3, 7) + 1);
    }

    public int U() {
        return (V().d(isLeapYear()) + this.f146143d) - 1;
    }

    public Month V() {
        return Month.q(this.f146142c);
    }

    public int W() {
        return this.f146142c;
    }

    public int Y() {
        return this.f146141b;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LocalDate t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? u(Long.MAX_VALUE, temporalUnit).u(1L, temporalUnit) : u(-j3, temporalUnit);
    }

    public LocalDate a0(long j3) {
        return j3 == Long.MIN_VALUE ? p0(Long.MAX_VALUE).p0(1L) : p0(-j3);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return super.b(temporal);
    }

    public LocalDate b0(long j3) {
        return j3 == Long.MIN_VALUE ? s0(Long.MAX_VALUE).s0(1L) : s0(-j3);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (!chronoField.isDateBased()) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        int i3 = AnonymousClass2.f146144a[chronoField.ordinal()];
        if (i3 == 1) {
            return ValueRange.i(1L, lengthOfMonth());
        }
        if (i3 == 2) {
            return ValueRange.i(1L, lengthOfYear());
        }
        if (i3 != 3) {
            return i3 != 4 ? temporalField.range() : Y() <= 0 ? ValueRange.i(1L, 1000000000L) : ValueRange.i(1L, 999999999L);
        }
        return ValueRange.i(1L, (V() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? this : super.e(temporalQuery);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && F((LocalDate) obj) == 0;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return super.g(temporalField);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public int hashCode() {
        int i3 = this.f146141b;
        return (((i3 << 11) + (this.f146142c << 6)) + this.f146143d) ^ (i3 & (-2048));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate localDateI = I(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, localDateI);
        }
        switch (AnonymousClass2.f146145b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return H(localDateI);
            case 2:
                return H(localDateI) / 7;
            case 3:
                return c0(localDateI);
            case 4:
                return c0(localDateI) / 12;
            case 5:
                return c0(localDateI) / 120;
            case 6:
                return c0(localDateI) / 1200;
            case 7:
                return c0(localDateI) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.G;
                return localDateI.m(chronoField) - m(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public boolean isLeapYear() {
        return IsoChronology.f146288f.isLeapYear(this.f146141b);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? P(temporalField) : super.j(temporalField);
    }

    public int lengthOfMonth() {
        short s2 = this.f146142c;
        return s2 != 2 ? (s2 == 4 || s2 == 6 || s2 == 9 || s2 == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.f146504z ? toEpochDay() : temporalField == ChronoField.D ? X() : P(temporalField) : temporalField.d(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public LocalDate u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.b(this, j3);
        }
        switch (AnonymousClass2.f146145b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return p0(j3);
            case 2:
                return r0(j3);
            case 3:
                return q0(j3);
            case 4:
                return s0(j3);
            case 5:
                return s0(Jdk8Methods.m(j3, 10));
            case 6:
                return s0(Jdk8Methods.m(j3, 100));
            case 7:
                return s0(Jdk8Methods.m(j3, 1000));
            case 8:
                ChronoField chronoField = ChronoField.G;
                return a(chronoField, Jdk8Methods.k(m(chronoField), j3));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public LocalDate y(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.b(this);
    }

    public LocalDate p0(long j3) {
        return j3 == 0 ? this : i0(Jdk8Methods.k(toEpochDay(), j3));
    }

    public LocalDate q0(long j3) {
        if (j3 == 0) {
            return this;
        }
        long j4 = (((long) this.f146141b) * 12) + ((long) (this.f146142c - 1)) + j3;
        return u0(ChronoField.F.f(Jdk8Methods.e(j4, 12L)), Jdk8Methods.g(j4, 12) + 1, this.f146143d);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, java.lang.Comparable
    /* JADX INFO: renamed from: r */
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? F((LocalDate) chronoLocalDate) : super.compareTo(chronoLocalDate);
    }

    public LocalDate r0(long j3) {
        return p0(Jdk8Methods.m(j3, 7));
    }

    public LocalDate s0(long j3) {
        return j3 == 0 ? this : u0(ChronoField.F.f(((long) this.f146141b) + j3), this.f146142c, this.f146143d);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public Era t() {
        return super.t();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j3 = this.f146141b;
        long j4 = this.f146142c;
        long j5 = 365 * j3;
        long j6 = (j3 >= 0 ? j5 + (((3 + j3) / 4) - ((99 + j3) / 100)) + ((j3 + 399) / 400) : j5 - (((j3 / (-4)) - (j3 / (-100))) + (j3 / (-400)))) + (((367 * j4) - 362) / 12) + ((long) (this.f146143d - 1));
        if (j4 > 2) {
            j6 = !isLeapYear() ? j6 - 2 : j6 - 1;
        }
        return j6 - 719528;
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public String toString() {
        int i3 = this.f146141b;
        short s2 = this.f146142c;
        short s3 = this.f146143d;
        int iAbs = Math.abs(i3);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i3 > 9999) {
                sb.append('+');
            }
            sb.append(i3);
        } else if (i3 < 0) {
            sb.append(i3 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i3 + ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            sb.deleteCharAt(0);
        }
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        sb.append(s3 < 10 ? "-0" : "-");
        sb.append((int) s3);
        return sb.toString();
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean u(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? F((LocalDate) chronoLocalDate) > 0 : super.u(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public boolean v(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? F((LocalDate) chronoLocalDate) < 0 : super.v(chronoLocalDate);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public LocalDate z(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? (LocalDate) temporalAdjuster : (LocalDate) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public LocalDate a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        switch (AnonymousClass2.f146144a[chronoField.ordinal()]) {
            case 1:
                return y0((int) j3);
            case 2:
                return B0((int) j3);
            case 3:
                return r0(j3 - m(ChronoField.A));
            case 4:
                if (this.f146141b < 1) {
                    j3 = 1 - j3;
                }
                return D0((int) j3);
            case 5:
                return p0(j3 - ((long) S().getValue()));
            case 6:
                return p0(j3 - m(ChronoField.f146500v));
            case 7:
                return p0(j3 - m(ChronoField.f146501w));
            case 8:
                return i0(j3);
            case 9:
                return r0(j3 - m(ChronoField.B));
            case 10:
                return C0((int) j3);
            case 11:
                return q0(j3 - m(ChronoField.D));
            case 12:
                return D0((int) j3);
            case 13:
                return m(ChronoField.G) == j3 ? this : D0(1 - this.f146141b);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public LocalDate y0(int i3) {
        return this.f146143d == i3 ? this : f0(this.f146141b, this.f146142c, i3);
    }

    public ZonedDateTime D(ZoneId zoneId) {
        ZoneOffsetTransition zoneOffsetTransitionB;
        Jdk8Methods.i(zoneId, KrzujOtzIk.ZRy);
        LocalDateTime localDateTimeQ = q(LocalTime.f146154h);
        if (!(zoneId instanceof ZoneOffset) && (zoneOffsetTransitionB = zoneId.l().b(localDateTimeQ)) != null && zoneOffsetTransitionB.j()) {
            localDateTimeQ = zoneOffsetTransitionB.b();
        }
        return ZonedDateTime.I(localDateTimeQ, zoneId);
    }
}
