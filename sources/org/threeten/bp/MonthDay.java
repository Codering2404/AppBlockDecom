package org.threeten.bp;

import com.facebook.appevents.AppEventsConstants;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, TemporalAdjuster, Comparable<MonthDay>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalQuery f146180c = new TemporalQuery<MonthDay>() { // from class: org.threeten.bp.MonthDay.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MonthDay a(TemporalAccessor temporalAccessor) {
            return MonthDay.q(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f146181d = new DateTimeFormatterBuilder().f("--").p(ChronoField.C, 2).e('-').p(ChronoField.f146502x, 2).E();
    private static final long serialVersionUID = -939150713474957432L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146183b;

    /* JADX INFO: renamed from: org.threeten.bp.MonthDay$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146184a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f146184a = iArr;
            try {
                iArr[ChronoField.f146502x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146184a[ChronoField.C.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MonthDay(int i3, int i4) {
        this.f146182a = i3;
        this.f146183b = i4;
    }

    public static MonthDay q(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.f146288f.equals(Chronology.i(temporalAccessor))) {
                temporalAccessor = LocalDate.I(temporalAccessor);
            }
            return s(temporalAccessor.j(ChronoField.C), temporalAccessor.j(ChronoField.f146502x));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static MonthDay s(int i3, int i4) {
        return t(Month.q(i3), i4);
    }

    public static MonthDay t(Month month, int i3) {
        Jdk8Methods.i(month, "month");
        ChronoField.f146502x.g(i3);
        if (i3 <= month.n()) {
            return new MonthDay(month.getValue(), i3);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i3 + " is not valid for month " + month.name());
    }

    static MonthDay u(DataInput dataInput) {
        return s(dataInput.readByte(), dataInput.readByte());
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        if (!Chronology.i(temporal).equals(IsoChronology.f146288f)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        Temporal temporalA = temporal.a(ChronoField.C, this.f146182a);
        ChronoField chronoField = ChronoField.f146502x;
        return temporalA.a(chronoField, Math.min(temporalA.c(chronoField).c(), this.f146183b));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        return temporalField == ChronoField.C ? temporalField.range() : temporalField == ChronoField.f146502x ? ValueRange.j(1L, r().p(), r().n()) : super.c(temporalField);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.a() ? IsoChronology.f146288f : super.e(temporalQuery);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MonthDay) {
            MonthDay monthDay = (MonthDay) obj;
            if (this.f146182a == monthDay.f146182a && this.f146183b == monthDay.f146183b) {
                return true;
            }
        }
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.C || temporalField == ChronoField.f146502x : temporalField != null && temporalField.b(this);
    }

    public int hashCode() {
        return (this.f146182a << 6) + this.f146183b;
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
        int i4 = AnonymousClass2.f146184a[((ChronoField) temporalField).ordinal()];
        if (i4 == 1) {
            i3 = this.f146183b;
        } else {
            if (i4 != 2) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i3 = this.f146182a;
        }
        return i3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(MonthDay monthDay) {
        int i3 = this.f146182a - monthDay.f146182a;
        return i3 == 0 ? this.f146183b - monthDay.f146183b : i3;
    }

    public Month r() {
        return Month.q(this.f146182a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f146182a < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
        sb.append(this.f146182a);
        sb.append(this.f146183b < 10 ? "-0" : "-");
        sb.append(this.f146183b);
        return sb.toString();
    }

    void v(DataOutput dataOutput) {
        dataOutput.writeByte(this.f146182a);
        dataOutput.writeByte(this.f146183b);
    }
}
