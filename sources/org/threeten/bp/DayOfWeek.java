package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
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
public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final TemporalQuery f146121i = new TemporalQuery<DayOfWeek>() { // from class: org.threeten.bp.DayOfWeek.1
        @Override // org.threeten.bp.temporal.TemporalQuery
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DayOfWeek a(TemporalAccessor temporalAccessor) {
            return DayOfWeek.d(temporalAccessor);
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final DayOfWeek[] f146122j = values();

    public static DayOfWeek d(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return l(temporalAccessor.j(ChronoField.f146499u));
        } catch (DateTimeException e3) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e3);
        }
    }

    public static DayOfWeek l(int i3) {
        if (i3 >= 1 && i3 <= 7) {
            return f146122j[i3 - 1];
        }
        throw new DateTimeException("Invalid value for DayOfWeek: " + i3);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.f146499u, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.f146499u) {
            return temporalField.range();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public String f(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().m(ChronoField.f146499u, textStyle).F(locale).d(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.f146499u : temporalField != null && temporalField.b(this);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField == ChronoField.f146499u ? getValue() : c(temporalField).a(m(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (temporalField == ChronoField.f146499u) {
            return getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public DayOfWeek n(long j3) {
        return f146122j[(ordinal() + (((int) (j3 % 7)) + 7)) % 7];
    }
}
