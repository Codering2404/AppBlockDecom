package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal h(long j3, TemporalUnit temporalUnit) {
        return j3 == Long.MIN_VALUE ? o(Long.MAX_VALUE, temporalUnit).o(1L, temporalUnit) : o(-j3, temporalUnit);
    }

    public Temporal k(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.b(this);
    }

    public Temporal p(TemporalAmount temporalAmount) {
        return temporalAmount.b(this);
    }
}
