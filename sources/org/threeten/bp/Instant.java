package org.threeten.bp;

import com.facebook.AccessTokenManager;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f146130c = new Instant(0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Instant f146131d = D(-31557014167219200L, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Instant f146132f = D(31556889864403199L, 999999999);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TemporalQuery f146133g = new TemporalQuery<Instant>() { // from class: org.threeten.bp.Instant.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Instant a(TemporalAccessor temporalAccessor) {
            return Instant.s(temporalAccessor);
        }
    };
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f146134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146135b;

    /* JADX INFO: renamed from: org.threeten.bp.Instant$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f146137b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146137b = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146137b[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146137b[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146137b[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146137b[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146137b[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146137b[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146137b[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f146136a = iArr2;
            try {
                iArr2[ChronoField.f146484f.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146136a[ChronoField.f146486h.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146136a[ChronoField.f146488j.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146136a[ChronoField.H.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Instant(long j3, int i3) {
        this.f146134a = j3;
        this.f146135b = i3;
    }

    public static Instant A(long j3) {
        return r(Jdk8Methods.e(j3, 1000L), Jdk8Methods.g(j3, 1000) * 1000000);
    }

    public static Instant B(long j3) {
        return r(j3, 0);
    }

    public static Instant D(long j3, long j4) {
        return r(Jdk8Methods.k(j3, Jdk8Methods.e(j4, 1000000000L)), Jdk8Methods.g(j4, 1000000000));
    }

    private Instant E(long j3, long j4) {
        if ((j3 | j4) == 0) {
            return this;
        }
        return D(Jdk8Methods.k(Jdk8Methods.k(this.f146134a, j3), j4 / 1000000000), ((long) this.f146135b) + (j4 % 1000000000));
    }

    static Instant Q(DataInput dataInput) {
        return D(dataInput.readLong(), dataInput.readInt());
    }

    private long R(Instant instant) {
        long jP = Jdk8Methods.p(instant.f146134a, this.f146134a);
        long j3 = instant.f146135b - this.f146135b;
        return (jP <= 0 || j3 >= 0) ? (jP >= 0 || j3 <= 0) ? jP : jP + 1 : jP - 1;
    }

    private static Instant r(long j3, int i3) {
        if ((((long) i3) | j3) == 0) {
            return f146130c;
        }
        if (j3 < -31557014167219200L || j3 > 31556889864403199L) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j3, i3);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Instant s(TemporalAccessor temporalAccessor) {
        try {
            return D(temporalAccessor.m(ChronoField.H), temporalAccessor.j(ChronoField.f146484f));
        } catch (DateTimeException e3) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e3);
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    private long y(Instant instant) {
        return Jdk8Methods.k(Jdk8Methods.m(Jdk8Methods.p(instant.f146134a, this.f146134a), 1000000000), instant.f146135b - this.f146135b);
    }

    public static Instant z() {
        return Clock.e().b();
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Instant u(long j3, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.b(this, j3);
        }
        switch (AnonymousClass2.f146137b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return I(j3);
            case 2:
                return E(j3 / 1000000, (j3 % 1000000) * 1000);
            case 3:
                return H(j3);
            case 4:
                return P(j3);
            case 5:
                return P(Jdk8Methods.m(j3, 60));
            case 6:
                return P(Jdk8Methods.m(j3, AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS));
            case 7:
                return P(Jdk8Methods.m(j3, 43200));
            case 8:
                return P(Jdk8Methods.m(j3, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public Instant G(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.b(this);
    }

    public Instant H(long j3) {
        return E(j3 / 1000, (j3 % 1000) * 1000000);
    }

    public Instant I(long j3) {
        return E(0L, j3);
    }

    public Instant P(long j3) {
        return E(j3, 0L);
    }

    public long S() {
        long j3 = this.f146134a;
        return j3 >= 0 ? Jdk8Methods.k(Jdk8Methods.n(j3, 1000L), this.f146135b / 1000000) : Jdk8Methods.p(Jdk8Methods.n(j3 + 1, 1000L), 1000 - ((long) (this.f146135b / 1000000)));
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Instant z(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.b(this);
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public Instant a(TemporalField temporalField, long j3) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.a(this, j3);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.g(j3);
        int i3 = AnonymousClass2.f146136a[chronoField.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                int i4 = ((int) j3) * 1000;
                if (i4 != this.f146135b) {
                    return r(this.f146134a, i4);
                }
            } else if (i3 == 3) {
                int i5 = ((int) j3) * 1000000;
                if (i5 != this.f146135b) {
                    return r(this.f146134a, i5);
                }
            } else {
                if (i3 != 4) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
                }
                if (j3 != this.f146134a) {
                    return r(j3, this.f146135b);
                }
            }
        } else if (j3 != this.f146135b) {
            return r(this.f146134a, (int) j3);
        }
        return this;
    }

    void W(DataOutput dataOutput) {
        dataOutput.writeLong(this.f146134a);
        dataOutput.writeInt(this.f146135b);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.H, this.f146134a).a(ChronoField.f146484f, this.f146135b);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return super.c(temporalField);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f146134a == instant.f146134a && this.f146135b == instant.f146135b) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.H || temporalField == ChronoField.f146484f || temporalField == ChronoField.f146486h || temporalField == ChronoField.f146488j : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        long j3 = this.f146134a;
        return ((int) (j3 ^ (j3 >>> 32))) + (this.f146135b * 51);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long i(Temporal temporal, TemporalUnit temporalUnit) {
        Instant instantS = s(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.a(this, instantS);
        }
        switch (AnonymousClass2.f146137b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return y(instantS);
            case 2:
                return y(instantS) / 1000;
            case 3:
                return Jdk8Methods.p(instantS.S(), S());
            case 4:
                return R(instantS);
            case 5:
                return R(instantS) / 60;
            case 6:
                return R(instantS) / 3600;
            case 7:
                return R(instantS) / 43200;
            case 8:
                return R(instantS) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return c(temporalField).a(temporalField.d(this), temporalField);
        }
        int i3 = AnonymousClass2.f146136a[((ChronoField) temporalField).ordinal()];
        if (i3 == 1) {
            return this.f146135b;
        }
        if (i3 == 2) {
            return this.f146135b / 1000;
        }
        if (i3 == 3) {
            return this.f146135b / 1000000;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        int i3;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        int i4 = AnonymousClass2.f146136a[((ChronoField) temporalField).ordinal()];
        if (i4 == 1) {
            i3 = this.f146135b;
        } else if (i4 == 2) {
            i3 = this.f146135b / 1000;
        } else {
            if (i4 != 3) {
                if (i4 == 4) {
                    return this.f146134a;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i3 = this.f146135b / 1000000;
        }
        return i3;
    }

    public ZonedDateTime p(ZoneId zoneId) {
        return ZonedDateTime.P(this, zoneId);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(Instant instant) {
        int iB = Jdk8Methods.b(this.f146134a, instant.f146134a);
        return iB != 0 ? iB : this.f146135b - instant.f146135b;
    }

    public long t() {
        return this.f146134a;
    }

    public String toString() {
        return DateTimeFormatter.f146347t.d(this);
    }

    public int u() {
        return this.f146135b;
    }

    @Override // org.threeten.bp.temporal.Temporal
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Instant t(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? o(Long.MAX_VALUE, temporalUnit).o(1L, temporalUnit) : o(-j3, temporalUnit);
    }

    public Instant w(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.a(this);
    }

    public Instant x(long j3) {
        return j3 == Long.MIN_VALUE ? I(Long.MAX_VALUE).I(1L) : I(-j3);
    }
}
