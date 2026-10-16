package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f146576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f146577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f146578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f146579d;

    private ValueRange(long j3, long j4, long j5, long j6) {
        this.f146576a = j3;
        this.f146577b = j4;
        this.f146578c = j5;
        this.f146579d = j6;
    }

    public static ValueRange i(long j3, long j4) {
        if (j3 <= j4) {
            return new ValueRange(j3, j3, j4, j4);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange j(long j3, long j4, long j5) {
        return k(j3, j3, j4, j5);
    }

    public static ValueRange k(long j3, long j4, long j5, long j6) {
        if (j3 > j4) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (j5 > j6) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (j4 <= j6) {
            return new ValueRange(j3, j4, j5, j6);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int a(long j3, TemporalField temporalField) {
        if (g(j3)) {
            return (int) j3;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j3);
    }

    public long b(long j3, TemporalField temporalField) {
        if (h(j3)) {
            return j3;
        }
        if (temporalField == null) {
            throw new DateTimeException("Invalid value (valid values " + this + "): " + j3);
        }
        throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j3);
    }

    public long c() {
        return this.f146579d;
    }

    public long d() {
        return this.f146576a;
    }

    public boolean e() {
        return this.f146576a == this.f146577b && this.f146578c == this.f146579d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueRange) {
            ValueRange valueRange = (ValueRange) obj;
            if (this.f146576a == valueRange.f146576a && this.f146577b == valueRange.f146577b && this.f146578c == valueRange.f146578c && this.f146579d == valueRange.f146579d) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return d() >= -2147483648L && c() <= 2147483647L;
    }

    public boolean g(long j3) {
        return f() && h(j3);
    }

    public boolean h(long j3) {
        return j3 >= d() && j3 <= c();
    }

    public int hashCode() {
        long j3 = this.f146576a;
        long j4 = this.f146577b;
        long j5 = (j3 + j4) << ((int) (j4 + 16));
        long j6 = this.f146578c;
        long j7 = (j5 >> ((int) (j6 + 48))) << ((int) (j6 + 32));
        long j8 = this.f146579d;
        long j9 = ((j7 >> ((int) (32 + j8))) << ((int) (j8 + 48))) >> 16;
        return (int) (j9 ^ (j9 >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f146576a);
        if (this.f146576a != this.f146577b) {
            sb.append('/');
            sb.append(this.f146577b);
        }
        sb.append(" - ");
        sb.append(this.f146578c);
        if (this.f146578c != this.f146579d) {
            sb.append('/');
            sb.append(this.f146579d);
        }
        return sb.toString();
    }
}
