package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface TemporalField {
    Temporal a(Temporal temporal, long j3);

    boolean b(TemporalAccessor temporalAccessor);

    ValueRange c(TemporalAccessor temporalAccessor);

    long d(TemporalAccessor temporalAccessor);

    TemporalAccessor e(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle);

    boolean isDateBased();

    boolean isTimeBased();

    ValueRange range();
}
