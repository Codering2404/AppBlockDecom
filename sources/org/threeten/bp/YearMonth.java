package org.threeten.bp;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
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
public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalQuery f146210c = new TemporalQuery<YearMonth>() { // from class: org.threeten.bp.YearMonth.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public YearMonth a(TemporalAccessor temporalAccessor) {
            return YearMonth.q(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f146211d = new DateTimeFormatterBuilder().q(ChronoField.F, 4, 10, SignStyle.EXCEEDS_PAD).e('-').p(ChronoField.C, 2).E();
    private static final long serialVersionUID = 4183400860270640070L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146213b;

    /* JADX INFO: renamed from: org.threeten.bp.YearMonth$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f146215b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146215b = iArr;
            try {
                iArr[ChronoUnit.MONTHS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146215b[ChronoUnit.YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146215b[ChronoUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146215b[ChronoUnit.CENTURIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146215b[ChronoUnit.MILLENNIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146215b[ChronoUnit.ERAS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f146214a = iArr2;
            try {
                iArr2[ChronoField.C.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146214a[ChronoField.D.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146214a[ChronoField.E.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146214a[ChronoField.F.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146214a[ChronoField.G.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private YearMonth(int i3, int i4) {
        this.f146212a = i3;
        this.f146213b = i4;
    }

    public static YearMonth q(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof YearMonth) {
            return (YearMonth) temporalAccessor;
        }
        try {
            if (!IsoChronology.f146288f.equals(Chronology.i(temporalAccessor))) {
                temporalAccessor = LocalDate.I(temporalAccessor);
            }
            return u(temporalAccessor.j(ChronoField.F), temporalAccessor.j(ChronoField.C));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private long r() {
        return (((long) this.f146212a) * 12) + ((long) (this.f146213b - 1));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static YearMonth u(int i3, int i4) {
        ChronoField.F.g(i3);
        ChronoField.C.g(i4);
        return new YearMonth(i3, i4);
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    static YearMonth y(DataInput dataInput) {
        return u(dataInput.readInt(), dataInput.readByte());
    }

    private YearMonth z(int i3, int i4) {
        return (this.f146212a == i3 && this.f146213b == i4) ? this : new YearMonth(i3, i4);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public YearMonth z(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public YearMonth a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (YearMonth) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        int i3 = AnonymousClass2.f146214a[chronoField.ordinal()];
        if (i3 == 1) {
            return D((int) j3);
        }
        if (i3 == 2) {
            return w(j3 - m(ChronoField.D));
        }
        if (i3 == 3) {
            if (this.f146212a < 1) {
                j3 = 1 - j3;
            }
            return E((int) j3);
        }
        if (i3 == 4) {
            return E((int) j3);
        }
        if (i3 == 5) {
            return m(ChronoField.G) == j3 ? this : E(1 - this.f146212a);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public YearMonth D(int i3) {
        ChronoField.C.g(i3);
        return z(this.f146212a, i3);
    }

    public YearMonth E(int i3) {
        ChronoField.F.g(i3);
        return z(i3, this.f146213b);
    }

    void F(DataOutput dataOutput) {
        dataOutput.writeInt(this.f146212a);
        dataOutput.writeByte(this.f146213b);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        if (Chronology.i(temporal).equals(IsoChronology.f146288f)) {
            return temporal.a(ChronoField.D, r());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.E) {
            return ValueRange.i(1L, s() <= 0 ? 1000000000L : 999999999L);
        }
        return super.c(temporalField);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.f146288f;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YearMonth) {
            YearMonth yearMonth = (YearMonth) obj;
            if (this.f146212a == yearMonth.f146212a && this.f146213b == yearMonth.f146213b) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.F || temporalField == ChronoField.C || temporalField == ChronoField.D || temporalField == ChronoField.E || temporalField == ChronoField.G : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        return this.f146212a ^ (this.f146213b << 27);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth yearMonthQ = q(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, yearMonthQ);
        }
        long jR = yearMonthQ.r() - r();
        switch (AnonymousClass2.f146215b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return jR;
            case 2:
                return jR / 12;
            case 3:
                return jR / 120;
            case 4:
                return jR / 1200;
            case 5:
                return jR / 12000;
            case 6:
                ChronoField chronoField = ChronoField.G;
                return yearMonthQ.m(chronoField) - m(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return c(temporalField).a(m(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        int i3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i4 = AnonymousClass2.f146214a[((ChronoField) temporalField).ordinal()];
        if (i4 == 1) {
            i3 = this.f146213b;
        } else {
            if (i4 == 2) {
                return r();
            }
            if (i4 == 3) {
                int i5 = this.f146212a;
                if (i5 < 1) {
                    i5 = 1 - i5;
                }
                return i5;
            }
            if (i4 != 4) {
                if (i4 == 5) {
                    return this.f146212a < 1 ? 0 : 1;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i3 = this.f146212a;
        }
        return i3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(YearMonth yearMonth) {
        int i3 = this.f146212a - yearMonth.f146212a;
        return i3 == 0 ? this.f146213b - yearMonth.f146213b : i3;
    }

    public int s() {
        return this.f146212a;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public YearMonth t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? u(Long.MAX_VALUE, temporalUnit).u(1L, temporalUnit) : u(-j3, temporalUnit);
    }

    public String toString() {
        int iAbs = Math.abs(this.f146212a);
        StringBuilder sb = new StringBuilder(9);
        if (iAbs < 1000) {
            int i3 = this.f146212a;
            if (i3 < 0) {
                sb.append(i3 - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i3 + ColorExtractionConstants.MAX_PIXEL_SAMPLES);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.f146212a);
        }
        sb.append(this.f146213b < 10 ? "-0" : "-");
        sb.append(this.f146213b);
        return sb.toString();
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public YearMonth u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.b(this, j3);
        }
        switch (AnonymousClass2.f146215b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return w(j3);
            case 2:
                return x(j3);
            case 3:
                return x(Jdk8Methods.m(j3, 10));
            case 4:
                return x(Jdk8Methods.m(j3, 100));
            case 5:
                return x(Jdk8Methods.m(j3, 1000));
            case 6:
                ChronoField chronoField = ChronoField.G;
                return a(chronoField, Jdk8Methods.k(m(chronoField), j3));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth w(long j3) {
        if (j3 == 0) {
            return this;
        }
        long j4 = (((long) this.f146212a) * 12) + ((long) (this.f146213b - 1)) + j3;
        return z(ChronoField.F.f(Jdk8Methods.e(j4, 12L)), Jdk8Methods.g(j4, 12) + 1);
    }

    public YearMonth x(long j3) {
        return j3 == 0 ? this : z(ChronoField.F.f(((long) this.f146212a) + j3), this.f146213b);
    }
}
