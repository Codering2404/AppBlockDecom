package org.threeten.bp.chrono;

import java.util.Iterator;
import java.util.List;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ChronoPeriod implements TemporalAmount {
    public abstract long c(TemporalUnit temporalUnit);

    public abstract List d();

    public boolean e() {
        Iterator it = d().iterator();
        while (it.hasNext()) {
            if (c((TemporalUnit) it.next()) != 0) {
                return false;
            }
        }
        return true;
    }
}
