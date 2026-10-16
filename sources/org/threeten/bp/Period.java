package org.threeten.bp;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Period extends ChronoPeriod implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Period f146198d = new Period(0, 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f146199f = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final long serialVersionUID = -8290556941213247973L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f146202c;

    private Period(int i3, int i4, int i5) {
        this.f146200a = i3;
        this.f146201b = i4;
        this.f146202c = i5;
    }

    private static Period f(int i3, int i4, int i5) {
        return ((i3 | i4) | i5) == 0 ? f146198d : new Period(i3, i4, i5);
    }

    public static Period k(int i3) {
        return f(0, 0, i3);
    }

    public static Period l(int i3) {
        return f(0, i3, 0);
    }

    public static Period m(int i3) {
        return f(0, 0, Jdk8Methods.l(i3, 7));
    }

    public static Period n(int i3) {
        return f(i3, 0, 0);
    }

    public static Period o(CharSequence charSequence) {
        Jdk8Methods.i(charSequence, "text");
        Matcher matcher = f146199f.matcher(charSequence);
        if (matcher.matches()) {
            int i3 = "-".equals(matcher.group(1)) ? -1 : 1;
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(3);
            String strGroup3 = matcher.group(4);
            String strGroup4 = matcher.group(5);
            if (strGroup != null || strGroup2 != null || strGroup3 != null || strGroup4 != null) {
                try {
                    return f(p(charSequence, strGroup, i3), p(charSequence, strGroup2, i3), Jdk8Methods.j(p(charSequence, strGroup4, i3), Jdk8Methods.l(p(charSequence, strGroup3, i3), 7)));
                } catch (NumberFormatException e3) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e3));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int p(CharSequence charSequence, String str, int i3) {
        if (str == null) {
            return 0;
        }
        try {
            return Jdk8Methods.l(Integer.parseInt(str), i3);
        } catch (ArithmeticException e3) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e3));
        }
    }

    private Object readResolve() {
        return ((this.f146200a | this.f146201b) | this.f146202c) == 0 ? f146198d : this;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal a(Temporal temporal) {
        Jdk8Methods.i(temporal, "temporal");
        int i3 = this.f146200a;
        if (i3 != 0) {
            temporal = this.f146201b != 0 ? temporal.h(q(), ChronoUnit.MONTHS) : temporal.h(i3, ChronoUnit.YEARS);
        } else {
            int i4 = this.f146201b;
            if (i4 != 0) {
                temporal = temporal.h(i4, ChronoUnit.MONTHS);
            }
        }
        int i5 = this.f146202c;
        return i5 != 0 ? temporal.h(i5, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal b(Temporal temporal) {
        Jdk8Methods.i(temporal, "temporal");
        int i3 = this.f146200a;
        if (i3 != 0) {
            temporal = this.f146201b != 0 ? temporal.o(q(), ChronoUnit.MONTHS) : temporal.o(i3, ChronoUnit.YEARS);
        } else {
            int i4 = this.f146201b;
            if (i4 != 0) {
                temporal = temporal.o(i4, ChronoUnit.MONTHS);
            }
        }
        int i5 = this.f146202c;
        return i5 != 0 ? temporal.o(i5, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public long c(TemporalUnit temporalUnit) {
        int i3;
        if (temporalUnit == ChronoUnit.YEARS) {
            i3 = this.f146200a;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i3 = this.f146201b;
        } else {
            if (temporalUnit != ChronoUnit.DAYS) {
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
            i3 = this.f146202c;
        }
        return i3;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public List d() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public boolean e() {
        return this == f146198d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            if (this.f146200a == period.f146200a && this.f146201b == period.f146201b && this.f146202c == period.f146202c) {
                return true;
            }
        }
        return false;
    }

    public int g() {
        return this.f146202c;
    }

    public int h() {
        return this.f146201b;
    }

    public int hashCode() {
        return this.f146200a + Integer.rotateLeft(this.f146201b, 8) + Integer.rotateLeft(this.f146202c, 16);
    }

    public int i() {
        return this.f146200a;
    }

    public Period j() {
        long jQ = q();
        long j3 = jQ / 12;
        int i3 = (int) (jQ % 12);
        return (j3 == ((long) this.f146200a) && i3 == this.f146201b) ? this : f(Jdk8Methods.q(j3), i3, this.f146202c);
    }

    public long q() {
        return (((long) this.f146200a) * 12) + ((long) this.f146201b);
    }

    public String toString() {
        if (this == f146198d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i3 = this.f146200a;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('Y');
        }
        int i4 = this.f146201b;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('M');
        }
        int i5 = this.f146202c;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('D');
        }
        return sb.toString();
    }
}
