package org.threeten.bp;

import com.facebook.AccessTokenManager;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Duration f146124c = new Duration(0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f146125d = BigInteger.valueOf(1000000000);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f146126f = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    private static final long serialVersionUID = 3078945930695997490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f146127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146128b;

    /* JADX INFO: renamed from: org.threeten.bp.Duration$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146129a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f146129a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146129a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146129a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146129a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Duration(long j3, int i3) {
        this.f146127a = j3;
        this.f146128b = i3;
    }

    private BigDecimal A() {
        return BigDecimal.valueOf(this.f146127a).add(BigDecimal.valueOf(this.f146128b, 9));
    }

    public static Duration c(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long jI = temporal.i(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.f146484f;
        long j3 = 0;
        if (temporal.g(chronoField) && temporal2.g(chronoField)) {
            try {
                long jM = temporal.m(chronoField);
                long jM2 = temporal2.m(chronoField) - jM;
                if (jI > 0 && jM2 < 0) {
                    jM2 += 1000000000;
                } else if (jI < 0 && jM2 > 0) {
                    jM2 -= 1000000000;
                } else if (jI == 0 && jM2 != 0) {
                    try {
                        jI = temporal.i(temporal2.a(chronoField, jM), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j3 = jM2;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return s(jI, j3);
    }

    private static Duration e(long j3, int i3) {
        return (((long) i3) | j3) == 0 ? f146124c : new Duration(j3, i3);
    }

    private static Duration f(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerExact.divideAndRemainder(f146125d);
        if (bigIntegerArrDivideAndRemainder[0].bitLength() <= 63) {
            return s(bigIntegerArrDivideAndRemainder[0].longValue(), bigIntegerArrDivideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    public static Duration m(long j3) {
        return e(Jdk8Methods.m(j3, AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS), 0);
    }

    public static Duration n(long j3) {
        return e(Jdk8Methods.m(j3, AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS), 0);
    }

    public static Duration o(long j3) {
        long j4 = j3 / 1000;
        int i3 = (int) (j3 % 1000);
        if (i3 < 0) {
            i3 += 1000;
            j4--;
        }
        return e(j4, i3 * 1000000);
    }

    public static Duration p(long j3) {
        return e(Jdk8Methods.m(j3, 60), 0);
    }

    public static Duration q(long j3) {
        long j4 = j3 / 1000000000;
        int i3 = (int) (j3 % 1000000000);
        if (i3 < 0) {
            i3 += 1000000000;
            j4--;
        }
        return e(j4, i3);
    }

    public static Duration r(long j3) {
        return e(j3, 0);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Duration s(long j3, long j4) {
        return e(Jdk8Methods.k(j3, Jdk8Methods.e(j4, 1000000000L)), Jdk8Methods.g(j4, 1000000000));
    }

    private Duration t(long j3, long j4) {
        if ((j3 | j4) == 0) {
            return this;
        }
        return s(Jdk8Methods.k(Jdk8Methods.k(this.f146127a, j3), j4 / 1000000000), ((long) this.f146128b) + (j4 % 1000000000));
    }

    static Duration v(DataInput dataInput) {
        return s(dataInput.readLong(), dataInput.readInt());
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    void B(DataOutput dataOutput) {
        dataOutput.writeLong(this.f146127a);
        dataOutput.writeInt(this.f146128b);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal a(Temporal temporal) {
        long j3 = this.f146127a;
        if (j3 != 0) {
            temporal = temporal.h(j3, ChronoUnit.SECONDS);
        }
        int i3 = this.f146128b;
        return i3 != 0 ? temporal.h(i3, ChronoUnit.NANOS) : temporal;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal b(Temporal temporal) {
        long j3 = this.f146127a;
        if (j3 != 0) {
            temporal = temporal.o(j3, ChronoUnit.SECONDS);
        }
        int i3 = this.f146128b;
        return i3 != 0 ? temporal.o(i3, ChronoUnit.NANOS) : temporal;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Duration duration) {
        int iB = Jdk8Methods.b(this.f146127a, duration.f146127a);
        return iB != 0 ? iB : this.f146128b - duration.f146128b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f146127a == duration.f146127a && this.f146128b == duration.f146128b) {
                return true;
            }
        }
        return false;
    }

    public Duration g(long j3) {
        if (j3 != 0) {
            return j3 == 1 ? this : f(A().divide(BigDecimal.valueOf(j3), RoundingMode.DOWN));
        }
        throw new ArithmeticException("Cannot divide by zero");
    }

    public int h() {
        return this.f146128b;
    }

    public int hashCode() {
        long j3 = this.f146127a;
        return ((int) (j3 ^ (j3 >>> 32))) + (this.f146128b * 51);
    }

    public long i() {
        return this.f146127a;
    }

    public boolean j() {
        return (this.f146127a | ((long) this.f146128b)) == 0;
    }

    public Duration k(long j3) {
        return j3 == 0 ? f146124c : j3 == 1 ? this : f(A().multiply(BigDecimal.valueOf(j3)));
    }

    public Duration l() {
        return k(-1L);
    }

    public String toString() {
        if (this == f146124c) {
            return "PT0S";
        }
        long j3 = this.f146127a;
        long j4 = j3 / 3600;
        int i3 = (int) ((j3 % 3600) / 60);
        int i4 = (int) (j3 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j4 != 0) {
            sb.append(j4);
            sb.append('H');
        }
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        if (i4 == 0 && this.f146128b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i4 >= 0 || this.f146128b <= 0) {
            sb.append(i4);
        } else if (i4 == -1) {
            sb.append("-0");
        } else {
            sb.append(i4 + 1);
        }
        if (this.f146128b > 0) {
            int length = sb.length();
            if (i4 < 0) {
                sb.append(2000000000 - this.f146128b);
            } else {
                sb.append(this.f146128b + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    public Duration u(Duration duration) {
        return t(duration.i(), duration.h());
    }

    public long w() {
        return this.f146127a / 86400;
    }

    public long x() {
        return this.f146127a / 3600;
    }

    public long y() {
        return Jdk8Methods.k(Jdk8Methods.m(this.f146127a, 1000), this.f146128b / 1000000);
    }

    public long z() {
        return this.f146127a / 60;
    }
}
