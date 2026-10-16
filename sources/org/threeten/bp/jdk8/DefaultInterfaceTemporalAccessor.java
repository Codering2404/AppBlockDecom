package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultInterfaceTemporalAccessor implements TemporalAccessor {
    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (g(temporalField)) {
            return temporalField.range();
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.e()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int j(TemporalField temporalField) {
        return c(temporalField).a(m(temporalField), temporalField);
    }
}
