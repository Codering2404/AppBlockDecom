package org.threeten.bp;

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
public final class Year extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Year>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TemporalQuery f146205b = new TemporalQuery<Year>() { // from class: org.threeten.bp.Year.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Year a(TemporalAccessor temporalAccessor) {
            return Year.q(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f146206c = new DateTimeFormatterBuilder().q(ChronoField.F, 4, 10, SignStyle.EXCEEDS_PAD).E();
    private static final long serialVersionUID = -23038383694477807L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146207a;

    /* JADX INFO: renamed from: org.threeten.bp.Year$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f146209b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146209b = iArr;
            try {
                iArr[ChronoUnit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146209b[ChronoUnit.DECADES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146209b[ChronoUnit.CENTURIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146209b[ChronoUnit.MILLENNIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146209b[ChronoUnit.ERAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f146208a = iArr2;
            try {
                iArr2[ChronoField.E.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146208a[ChronoField.F.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146208a[ChronoField.G.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Year(int i3) {
        this.f146207a = i3;
    }

    public static Year q(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Year) {
            return (Year) temporalAccessor;
        }
        try {
            if (!IsoChronology.f146288f.equals(Chronology.i(temporalAccessor))) {
                temporalAccessor = LocalDate.I(temporalAccessor);
            }
            return t(temporalAccessor.j(ChronoField.F));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static boolean r(long j3) {
        if ((3 & j3) == 0) {
            return j3 % 100 != 0 || j3 % 400 == 0;
        }
        return false;
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Year t(int i3) {
        ChronoField.F.g(i3);
        return new Year(i3);
    }

    static Year w(DataInput dataInput) {
        return t(dataInput.readInt());
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        if (Chronology.i(temporal).equals(IsoChronology.f146288f)) {
            return temporal.a(ChronoField.F, this.f146207a);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.E) {
            return ValueRange.i(1L, this.f146207a <= 0 ? 1000000000L : 999999999L);
        }
        return super.c(temporalField);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.f146288f;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.YEARS;
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
        return (obj instanceof Year) && this.f146207a == ((Year) obj).f146207a;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.F || temporalField == ChronoField.E || temporalField == ChronoField.G : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        return this.f146207a;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        Year yearQ = q(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, yearQ);
        }
        long j3 = ((long) yearQ.f146207a) - ((long) this.f146207a);
        int i3 = AnonymousClass2.f146209b[((ChronoUnit) temporalUnit).ordinal()];
        if (i3 == 1) {
            return j3;
        }
        if (i3 == 2) {
            return j3 / 10;
        }
        if (i3 == 3) {
            return j3 / 100;
        }
        if (i3 == 4) {
            return j3 / 1000;
        }
        if (i3 == 5) {
            ChronoField chronoField = ChronoField.G;
            return yearQ.m(chronoField) - m(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return c(temporalField).a(m(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i3 = AnonymousClass2.f146208a[((ChronoField) temporalField).ordinal()];
        if (i3 == 1) {
            int i4 = this.f146207a;
            if (i4 < 1) {
                i4 = 1 - i4;
            }
            return i4;
        }
        if (i3 == 2) {
            return this.f146207a;
        }
        if (i3 == 3) {
            return this.f146207a < 1 ? 0 : 1;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(Year year) {
        return this.f146207a - year.f146207a;
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Year t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? u(Long.MAX_VALUE, temporalUnit).u(1L, temporalUnit) : u(-j3, temporalUnit);
    }

    public String toString() {
        return Integer.toString(this.f146207a);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.b(this, j3);
        }
        int i3 = AnonymousClass2.f146209b[((ChronoUnit) temporalUnit).ordinal()];
        if (i3 == 1) {
            return v(j3);
        }
        if (i3 == 2) {
            return v(Jdk8Methods.m(j3, 10));
        }
        if (i3 == 3) {
            return v(Jdk8Methods.m(j3, 100));
        }
        if (i3 == 4) {
            return v(Jdk8Methods.m(j3, 1000));
        }
        if (i3 == 5) {
            ChronoField chronoField = ChronoField.G;
            return a(chronoField, Jdk8Methods.k(m(chronoField), j3));
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public Year v(long j3) {
        return j3 == 0 ? this : t(ChronoField.F.f(((long) this.f146207a) + j3));
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public Year z(TemporalAdjuster temporalAdjuster) {
        return (Year) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public Year a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (Year) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        int i3 = AnonymousClass2.f146208a[chronoField.ordinal()];
        if (i3 == 1) {
            if (this.f146207a < 1) {
                j3 = 1 - j3;
            }
            return t((int) j3);
        }
        if (i3 == 2) {
            return t((int) j3);
        }
        if (i3 == 3) {
            return m(ChronoField.G) == j3 ? this : t(1 - this.f146207a);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    void z(DataOutput dataOutput) {
        dataOutput.writeInt(this.f146207a);
    }
}
