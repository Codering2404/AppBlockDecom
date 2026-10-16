package org.threeten.bp.temporal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface TemporalAccessor {
    ValueRange c(TemporalField temporalField);

    Object e(TemporalQuery temporalQuery);

    boolean g(TemporalField temporalField);

    int j(TemporalField temporalField);

    long m(TemporalField temporalField);
}
