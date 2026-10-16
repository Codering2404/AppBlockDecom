package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = 275618735781L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chronology f146241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f146242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f146243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f146244d;

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal a(Temporal temporal) {
        Jdk8Methods.i(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.e(TemporalQueries.a());
        if (chronology != null && !this.f146241a.equals(chronology)) {
            throw new DateTimeException("Invalid chronology, required: " + this.f146241a.getId() + ", but was: " + chronology.getId());
        }
        int i3 = this.f146242b;
        if (i3 != 0) {
            temporal = temporal.t(i3, ChronoUnit.YEARS);
        }
        int i4 = this.f146243c;
        if (i4 != 0) {
            temporal = temporal.t(i4, ChronoUnit.MONTHS);
        }
        int i5 = this.f146244d;
        return i5 != 0 ? temporal.t(i5, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal b(Temporal temporal) {
        Jdk8Methods.i(temporal, "temporal");
        Chronology chronology = (Chronology) temporal.e(TemporalQueries.a());
        if (chronology != null && !this.f146241a.equals(chronology)) {
            throw new DateTimeException("Invalid chronology, required: " + this.f146241a.getId() + ", but was: " + chronology.getId());
        }
        int i3 = this.f146242b;
        if (i3 != 0) {
            temporal = temporal.u(i3, ChronoUnit.YEARS);
        }
        int i4 = this.f146243c;
        if (i4 != 0) {
            temporal = temporal.u(i4, ChronoUnit.MONTHS);
        }
        int i5 = this.f146244d;
        return i5 != 0 ? temporal.u(i5, ChronoUnit.DAYS) : temporal;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public long c(TemporalUnit temporalUnit) {
        int i3;
        if (temporalUnit == ChronoUnit.YEARS) {
            i3 = this.f146242b;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i3 = this.f146243c;
        } else {
            if (temporalUnit != ChronoUnit.DAYS) {
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
            i3 = this.f146244d;
        }
        return i3;
    }

    @Override // org.threeten.bp.chrono.ChronoPeriod
    public List d() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
            if (this.f146242b == chronoPeriodImpl.f146242b && this.f146243c == chronoPeriodImpl.f146243c && this.f146244d == chronoPeriodImpl.f146244d && this.f146241a.equals(chronoPeriodImpl.f146241a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f146241a.hashCode() + Integer.rotateLeft(this.f146242b, 16) + Integer.rotateLeft(this.f146243c, 8) + this.f146244d;
    }

    public String toString() {
        if (e()) {
            return this.f146241a + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f146241a);
        sb.append(' ');
        sb.append('P');
        int i3 = this.f146242b;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('Y');
        }
        int i4 = this.f146243c;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('M');
        }
        int i5 = this.f146244d;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('D');
        }
        return sb.toString();
    }
}
