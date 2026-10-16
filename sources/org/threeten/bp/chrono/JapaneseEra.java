package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.jdk8.DefaultInterfaceEra;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class JapaneseEra extends DefaultInterfaceEra implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final JapaneseEra f146303d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final JapaneseEra f146304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JapaneseEra f146305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final JapaneseEra f146306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final JapaneseEra f146307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicReference f146308j;
    private static final long serialVersionUID = 1466499369062886794L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient LocalDate f146310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient String f146311c;

    static {
        JapaneseEra japaneseEra = new JapaneseEra(-1, LocalDate.f0(1868, 9, 8), "Meiji");
        f146303d = japaneseEra;
        JapaneseEra japaneseEra2 = new JapaneseEra(0, LocalDate.f0(1912, 7, 30), "Taisho");
        f146304f = japaneseEra2;
        JapaneseEra japaneseEra3 = new JapaneseEra(1, LocalDate.f0(1926, 12, 25), "Showa");
        f146305g = japaneseEra3;
        JapaneseEra japaneseEra4 = new JapaneseEra(2, LocalDate.f0(1989, 1, 8), "Heisei");
        f146306h = japaneseEra4;
        JapaneseEra japaneseEra5 = new JapaneseEra(3, LocalDate.f0(2019, 5, 1), "Reiwa");
        f146307i = japaneseEra5;
        f146308j = new AtomicReference(new JapaneseEra[]{japaneseEra, japaneseEra2, japaneseEra3, japaneseEra4, japaneseEra5});
    }

    private JapaneseEra(int i3, LocalDate localDate, String str) {
        this.f146309a = i3;
        this.f146310b = localDate;
        this.f146311c = str;
    }

    static JapaneseEra q(LocalDate localDate) {
        if (localDate.v(f146303d.f146310b)) {
            throw new DateTimeException("Date too early: " + localDate);
        }
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) f146308j.get();
        for (int length = japaneseEraArr.length - 1; length >= 0; length--) {
            JapaneseEra japaneseEra = japaneseEraArr[length];
            if (localDate.compareTo(japaneseEra.f146310b) >= 0) {
                return japaneseEra;
            }
        }
        return null;
    }

    public static JapaneseEra r(int i3) {
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) f146308j.get();
        if (i3 < f146303d.f146309a || i3 > japaneseEraArr[japaneseEraArr.length - 1].f146309a) {
            throw new DateTimeException("japaneseEra is invalid");
        }
        return japaneseEraArr[s(i3)];
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            return r(this.f146309a);
        } catch (DateTimeException e3) {
            InvalidObjectException invalidObjectException = new InvalidObjectException("Invalid era");
            invalidObjectException.initCause(e3);
            throw invalidObjectException;
        }
    }

    private static int s(int i3) {
        return i3 + 1;
    }

    static JapaneseEra t(DataInput dataInput) {
        return r(dataInput.readByte());
    }

    public static JapaneseEra[] v() {
        JapaneseEra[] japaneseEraArr = (JapaneseEra[]) f146308j.get();
        return (JapaneseEra[]) Arrays.copyOf(japaneseEraArr, japaneseEraArr.length);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        ChronoField chronoField = ChronoField.G;
        return temporalField == chronoField ? JapaneseChronology.f146293g.x(chronoField) : super.c(temporalField);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return this.f146309a;
    }

    LocalDate p() {
        int iS = s(this.f146309a);
        JapaneseEra[] japaneseEraArrV = v();
        return iS >= japaneseEraArrV.length + (-1) ? LocalDate.f146139g : japaneseEraArrV[iS + 1].u().a0(1L);
    }

    public String toString() {
        return this.f146311c;
    }

    LocalDate u() {
        return this.f146310b;
    }

    void w(DataOutput dataOutput) {
        dataOutput.writeByte(getValue());
    }
}
