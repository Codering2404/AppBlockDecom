package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum HijrahEra implements Era {
    BEFORE_AH,
    AH;

    public static HijrahEra d(int i3) {
        if (i3 == 0) {
            return BEFORE_AH;
        }
        if (i3 == 1) {
            return AH;
        }
        throw new DateTimeException("HijrahEra not valid");
    }

    static HijrahEra l(DataInput dataInput) {
        return d(dataInput.readByte());
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.G, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (temporalField == ChronoField.G) {
            return ValueRange.i(1L, 1L);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    int f(int i3) {
        return this == AH ? i3 : 1 - i3;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.G : temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return ordinal();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return temporalField == ChronoField.G ? getValue() : c(temporalField).a(m(temporalField), temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long m(TemporalField temporalField) {
        if (temporalField == ChronoField.G) {
            return getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.d(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    void n(DataOutput dataOutput) {
        dataOutput.writeByte(getValue());
    }
}
