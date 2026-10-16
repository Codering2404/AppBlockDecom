package org.threeten.bp.jdk8;

import org.threeten.bp.chrono.Era;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultInterfaceEra extends DefaultInterfaceTemporalAccessor implements Era {
    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal b(Temporal temporal) {
        return temporal.a(ChronoField.G, getValue());
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean g(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.G : temporalField != null && temporalField.b(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
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
}
