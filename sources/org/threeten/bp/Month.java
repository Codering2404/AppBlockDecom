package org.threeten.bp;

import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
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
public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;


    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TemporalQuery f146176n = new TemporalQuery<Month>() { // from class: org.threeten.bp.Month.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month a(TemporalAccessor temporalAccessor) {
            return Month.f(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Month[] f146177o = values();

    /* JADX INFO: renamed from: org.threeten.bp.Month$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f146179a;

        static {
            int[] iArr = new int[Month.values().length];
            f146179a = iArr;
            try {
                iArr[Month.FEBRUARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146179a[Month.APRIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146179a[Month.JUNE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146179a[Month.SEPTEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146179a[Month.NOVEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146179a[Month.JANUARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146179a[Month.MARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f146179a[Month.MAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f146179a[Month.JULY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f146179a[Month.AUGUST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f146179a[Month.OCTOBER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f146179a[Month.DECEMBER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Month f(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Month) {
            return (Month) temporalAccessor;
        }
        try {
            if (!IsoChronology.f146288f.equals(Chronology.i(temporalAccessor))) {
                temporalAccessor = LocalDate.I(temporalAccessor);
            }
            return q(temporalAccessor.j(ChronoField.C));
        } catch (DateTimeException e3) {
            throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e3);
        }
    }

    public static Month q(int i3) {
        if (i3 >= 1 && i3 <= 12) {
            return f146177o[i3 - 1];
        }
        throw new DateTimeException("Invalid value for MonthOfYear: " + i3);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        if (Chronology.i(temporal).equals(IsoChronology.f146288f)) {
            return temporal.a(ChronoField.C, getValue());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.C) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int d(boolean z2) {
        switch (AnonymousClass2.f146179a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z2 ? 1 : 0) + 91;
            case 3:
                return (z2 ? 1 : 0) + 152;
            case 4:
                return (z2 ? 1 : 0) + 244;
            case 5:
                return (z2 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z2 ? 1 : 0) + 60;
            case 8:
                return (z2 ? 1 : 0) + 121;
            case 9:
                return (z2 ? 1 : 0) + 182;
            case 10:
                return (z2 ? 1 : 0) + 213;
            case 11:
                return (z2 ? 1 : 0) + 274;
            default:
                return (z2 ? 1 : 0) + 335;
        }
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
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
        return temporalQuery.a(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.C : temporalField != null && temporalField.b(this);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField == ChronoField.C ? getValue() : c(temporalField).a(m(temporalField), temporalField);
    }

    public int l(boolean z2) {
        int i3 = AnonymousClass2.f146179a[ordinal()];
        return i3 != 1 ? (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) ? 30 : 31 : z2 ? 29 : 28;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (temporalField == ChronoField.C) {
            return getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int n() {
        int i3 = AnonymousClass2.f146179a[ordinal()];
        if (i3 != 1) {
            return (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) ? 30 : 31;
        }
        return 29;
    }

    public int p() {
        int i3 = AnonymousClass2.f146179a[ordinal()];
        if (i3 != 1) {
            return (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) ? 30 : 31;
        }
        return 28;
    }

    public Month r(long j3) {
        return f146177o[(ordinal() + (((int) (j3 % 12)) + 12)) % 12];
    }
}
